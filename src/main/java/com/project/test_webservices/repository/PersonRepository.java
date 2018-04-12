package com.project.test_webservices.repository;

import com.project.test_webservices.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository< Person, Integer> {
}
