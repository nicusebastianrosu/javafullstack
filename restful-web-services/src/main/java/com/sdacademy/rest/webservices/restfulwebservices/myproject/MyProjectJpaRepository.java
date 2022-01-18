package com.sdacademy.rest.webservices.restfulwebservices.myproject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyProjectJpaRepository extends CrudRepository<MyProject, Long> {

	List<MyProject> findByUsername(String username);

}
