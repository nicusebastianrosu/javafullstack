import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MY_PROJECT_JPA_API_URL } from 'src/app/app.constants';
import { MyProject } from '../../list-my-projects/list-my-projects.component';

@Injectable({
  providedIn: 'root'
})
export class MyProjectDataService {

  constructor(
    private http: HttpClient
  ) { }

  retrieveAllMyProjects(username: any) {
    return this.http.get<MyProject[]>(`${MY_PROJECT_JPA_API_URL}/users/${username}/myProjects/`);

    // console.log("Execute Hello World Bean Service");
  }

  deleteMyProject(username: any, id: any) {
    return this.http.delete(`${MY_PROJECT_JPA_API_URL}/users/${username}/myProjects/${id}`);
  }

  retriveMyProject(username: any, id: any) {
    return this.http.get<MyProject>(`${MY_PROJECT_JPA_API_URL}/users/${username}/myProjects/${id}`);
  }

  updateMyProject(username: any, id: any, myProject: any) {
    return this.http.put(`${MY_PROJECT_JPA_API_URL}/users/${username}/myProjects/${id}`, myProject);
  }

  createMyProject(username: any, myProject: any) {
    return this.http.post(`${MY_PROJECT_JPA_API_URL}/users/${username}/myProjects`, myProject);
  }


}

// Access to XMLHttpRequest at 'http://localhost:8080/hello-world/path-variable/SDA' 
//from origin 'http://localhost:4200' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' 
//header is present on the requested resource.
// :8080/hello-world/path-variable/SDA:1 Failed to load resource: net::ERR_FAILED
//TODO_JPA_API_URL
//`${TODO_JPA_API_URL}/users/${username}/todos/${id}`
