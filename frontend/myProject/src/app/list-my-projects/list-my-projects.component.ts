import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyProjectDataService } from '../service/data/my-project-data.service';

export class MyProject {
  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date
  ) {

  }
}

@Component({
  selector: 'app-list-my-projects',
  templateUrl: './list-my-projects.component.html',
  styleUrls: ['./list-my-projects.component.css']
})

export class ListMyProjectsComponent implements OnInit {

  myProjects: MyProject[] | undefined;

  message: any;


  // = [
  //   new MyProject(1, 'Learn Java Basic',false, new Date()),
  //   new MyProject(2, 'Head First Spring', false, new Date()),
  //   new MyProject(3, 'Learn Java Frameworks', false, new Date()),
  //   new MyProject(4, 'Learn Angular Framework', false, new Date())
  // {id: 1, description: 'Learn to Dance'},
  // {id: 2, description: 'Become an Expert at Angular'},
  // {id: 3, description: 'Visit Romania'}
  //]
  // myProject = {
  //   id: 1,
  //   description: 'Learn to dance'
  // }

  // = [
  //   new MyProject(1, 'Learn Java Basic',false, new Date()),
  //   new MyProject(2, 'Head First Spring', false, new Date()),
  //   new MyProject(3, 'Learn Java Frameworks', false, new Date()),
  //   new MyProject(4, 'Learn Angular Framework', false, new Date())

  // {id: 1, description: 'Learn to Dance'},
  // {id: 2, description: 'Become an Expert at Angular'},
  // {id: 3, description: 'Visit Romania'}

  //]

  // myProject = {
  //   id: 1,
  //   description: 'Learn to dance'
  // }

  constructor(
    private myProjectService: MyProjectDataService,
    private router: Router
  ) { }

  ngOnInit() {
    this.refreshMyProjects()
  }

  refreshMyProjects() {
    this.myProjectService.retrieveAllMyProjects('SDA').subscribe(
      response => {
        console.log(response);
        this.myProjects = response;
      }
    )
  }

  deleteMyProject(id: any) {
    console.log(`delete myProject ${id}`)
    this.myProjectService.deleteMyProject('SDA', id).subscribe(
      response => {
        console.log(response);
        this.message = `Delete of MyProject ${id} Successful!`
        this.refreshMyProjects();
      }
    )
  }

  updateMyProject(id: any) {
    console.log(`update myProject ${id}`)
    this.router.navigate(['myProjects', id])
  }

  addMyProject() {
    this.router.navigate(['myProjects', -1])
  }

}
