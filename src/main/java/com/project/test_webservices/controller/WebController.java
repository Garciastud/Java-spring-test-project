package com.project.test_webservices.controller;

import com.project.test_webservices.exception.RersonNotFound;
import com.project.test_webservices.model.Address;
import com.project.test_webservices.model.Person;
import com.project.test_webservices.model.Phone;
import com.project.test_webservices.repository.PersonRepository;
import com.project.test_webservices.toCsvService.ConvertToCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@RestController
public class WebController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET,path = "/rest/")
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,path = "/rest/")
    public Person addNewPerson(@Valid @RequestBody Person person) {
        for (Phone phone: person.getPhones()){
            phone.setPerson(person);
        }
        for (Address address: person.getAddresses()){
            address.setPerson(person);
        }
        return personRepository.save(person);
    }

    @RequestMapping(path = "/rest/{id}",method = RequestMethod.GET)
    public Person getPersonById(@PathVariable(value = "id") Integer personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new RersonNotFound("Person", "id", personId));
    }


    @RequestMapping(path="/rest/csv/{table_name}",produces = "text/csv",method = RequestMethod.GET)
    public String getCsvPerson(@PathVariable String table_name) throws IOException, SQLException {
        ConvertToCsv conCsv = new ConvertToCsv();
        return conCsv.convertToCsv(table_name);
    }



    }



