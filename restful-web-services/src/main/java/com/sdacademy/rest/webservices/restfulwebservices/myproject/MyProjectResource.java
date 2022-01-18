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
public class MyProjectResource {

	@Autowired
	private MyProjectHardcodedService myProjectService;

	@GetMapping(path = "/users/{username}/myProjects")
	public List<MyProject> getAllMyProjects(@PathVariable String username) {
		return myProjectService.findAll();
	}

	@GetMapping(path = "/users/{username}/myProjects/{id}")
	public MyProject getMyProject(@PathVariable String username, @PathVariable long id) {
		return myProjectService.findById(id);
	}

	@DeleteMapping(path = "/users/{username}/myProjects/{id}")
	public ResponseEntity<Void> deleteMyProject(@PathVariable String username, @PathVariable long id) {

		MyProject myProject = myProjectService.deleteById(id);
		if (myProject != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping(path = "/users/{username}/myProjects/{id}")
	public ResponseEntity<MyProject> updateMyProject(@PathVariable String username, @PathVariable long id,
			@RequestBody MyProject myProject) {

		MyProject myProjectUpdated = myProjectService.save(myProject);
		return new ResponseEntity<MyProject>(myProject, HttpStatus.OK);
	}

	@PostMapping(path = "/users/{username}/myProjects")
	public ResponseEntity<Void> updateMyProject(@PathVariable String username, @RequestBody MyProject myProject) {

		MyProject createdMyProject = myProjectService.save(myProject);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdMyProject.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

}
