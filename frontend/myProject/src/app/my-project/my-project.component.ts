import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyProject } from '../list-my-projects/list-my-projects.component';
import { MyProjectDataService } from '../service/data/my-project-data.service';

@Component({
  selector: 'app-my-project',
  templateUrl: './my-project.component.html',
  styleUrls: ['./my-project.component.css']
})
export class MyProjectComponent implements OnInit {

  id: any;
  myProject: any;

  constructor(
    private myProjectService: MyProjectDataService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.myProject = new MyProject(this.id, "", false, new Date);

    if (this.id != -1) {
      this.myProjectService.retriveMyProject('SDA', this.id).subscribe(
        data => this.myProject = data
      )
    }
  }

  saveMyProject() {
    if (this.id == -1) {
      //create MyProject
      this.myProjectService.createMyProject('SDA', this.myProject).subscribe(
        data => {
          console.log(data)
          this.router.navigate(['myProjects'])
        }
      )
    } else {
      this.myProjectService.updateMyProject('SDA', this.id, this.myProject).subscribe(
        data => {
          console.log(data)
          this.router.navigate(['myProjects'])
        }
      )
    }
  }

}
