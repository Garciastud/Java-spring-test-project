package com.project.test_webservices.toCsvService;

import java.net.ConnectException;
import java.sql.*;

public class JdbcConnection {
    final private String url = "jdbc:mysql://localhost:3306/webservice3?autoReconnect=true&relaxAutoCommit=true&useSSL=false";
    final private String user = "root";
    final private String password = "19950807";
    Connection con=null;
    Statement stmt=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    String SQL="";

    public void CreateConnection()  {
        try {
            con = DriverManager.getConnection(url,user,password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet getData(String tableName){
        try{
            SQL="SELECT * FROM " + tableName;
            stmt=con.createStatement();
            rs=stmt.executeQuery(SQL);
        }catch(SQLException s){
            s.printStackTrace();
        }
        return rs;
    }

    public void closeConnections() throws SQLException {
        try{
            con.commit();
        }catch(Exception e){
            e.printStackTrace();
        }


        if (rs != null) {
            rs.close();
            rs = null;
        }

        if (stmt != null) {
            stmt.close();
            stmt = null;
        }

        if (pstmt != null) {
            pstmt.close();
            pstmt = null;
        }
        if (con != null) {
            con.close();
            con = null;
        }
    }
}
