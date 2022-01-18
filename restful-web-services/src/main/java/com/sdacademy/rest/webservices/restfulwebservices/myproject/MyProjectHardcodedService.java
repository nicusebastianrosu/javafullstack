package com.sdacademy.rest.webservices.restfulwebservices.myproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyProjectHardcodedService {

	private static List<MyProject> myProjects = new ArrayList<>();
	private static long idCounter = 0;

	static {
		myProjects.add(new MyProject(++idCounter, "SDA", "Learn Java", new Date(), false));
		myProjects.add(new MyProject(++idCounter, "SDA", "Learn Angular", new Date(), false));
		myProjects.add(new MyProject(++idCounter, "SDA", "Learn H2 Database", new Date(), false));
		myProjects.add(new MyProject(++idCounter, "SDA", "Learn with SDAcademy", new Date(), false));
		myProjects.add(new MyProject(++idCounter, "SDA", "Learn with TelAcademy", new Date(), false));
	}

	public List<MyProject> findAll() {
		return myProjects;
	}

	public MyProject save(MyProject myProject) {
		if (myProject.getId() == -1 || myProject.getId() == 0) {
			myProject.setId(++idCounter);
			myProjects.add(myProject);
		} else {
			deleteById(myProject.getId());
			myProjects.add(myProject);
		}
		return myProject;
	}

	public MyProject deleteById(long id) {
		MyProject myProject = findById(id);
		if (myProject == null)
			return null;
		if (myProjects.remove(myProject)) {
			return myProject;
		}
		return null;
	}

	public MyProject findById(long id) {
		for (MyProject myProject : myProjects) {
			if (myProject.getId() == id) {
				return myProject;
			}
		}
		return null;
	}

}
