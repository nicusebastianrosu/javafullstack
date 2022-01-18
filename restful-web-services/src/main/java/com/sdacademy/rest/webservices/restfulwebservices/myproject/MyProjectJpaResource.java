package com.sdacademy.rest.webservices.restfulwebservices.myproject;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sdacademy.rest.webservices.restfulwebservices.myproject.MyProject;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MyProjectJpaResource {

//	@Autowired
//	private MyProjectHardcodedService myProjectService;

	@Autowired
	private MyProjectJpaRepository myProjectJpaRepository;

	@GetMapping(path = "/jpa/users/{username}/myProjects")
	public List<MyProject> getAllMyProjects(@PathVariable String username) {
		return myProjectJpaRepository.findByUsername(username);
		// return myProjectService.findAll();
	}

	@GetMapping(path = "/jpa/users/{username}/myProjects/{id}")
	public MyProject getMyProject(@PathVariable String username, @PathVariable Long id) {
		return myProjectJpaRepository.findById(id).get();
		// return myProjectService.findById(id);
	}

	@DeleteMapping(path = "/jpa/users/{username}/myProjects/{id}")
	public ResponseEntity<Void> deleteMyProject(@PathVariable String username, @PathVariable Long id) {

		// MyProject myProject = myProjectService.deleteById(id);
		myProjectJpaRepository.deleteById(id);
		// if (myProject != null) {
		return ResponseEntity.noContent().build();
		// }
		// return ResponseEntity.notFound().build();
	}

	@PutMapping(path = "/jpa/users/{username}/myProjects/{id}")
	public ResponseEntity<MyProject> updateMyProject(@PathVariable String username, @PathVariable Long id,
			@RequestBody MyProject myProject) {

		MyProject myProjectUpdated = myProjectJpaRepository.save(myProject);
		return new ResponseEntity<MyProject>(myProject, HttpStatus.OK);
	}

	@PostMapping(path = "/jpa/users/{username}/myProjects")
	public ResponseEntity<Void> createMyProject(@PathVariable String username, @RequestBody MyProject myProject) {

		// MyProject createdMyProject = myProjectService.save(myProject);
		myProject.setUsername(username);
		MyProject createdMyProject = myProjectJpaRepository.save(myProject);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdMyProject.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
//	@PostMapping(path = "/users/{username}/myProjects")
//	public ResponseEntity<Void> updateMyProject(@PathVariable String username, @RequestBody MyProject myProject) {
//
//		MyProject createdMyProject = myProjectService.save(myProject);
//
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(createdMyProject.getId()).toUri();
//
//		return ResponseEntity.created(uri).build();
//	}

}
