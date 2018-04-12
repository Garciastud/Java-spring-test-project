package com.project.test_webservices.toCsvService;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConvertToCsv {


    public String convertToCsv(String table_name) throws IOException, SQLException {

            JdbcConnection dbcon=new JdbcConnection ();
            StringWriter s = new StringWriter();

            CSVWriter writer = new CSVWriter(s);
            dbcon.CreateConnection();
            ResultSet rs=dbcon.getData(table_name);
            writer.writeAll(rs, true);
            String result = s.toString();
             writer.close();
            dbcon.closeConnections();
            return result;




}
}
