import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class HelloWorldBean {
  constructor(public message: string) {

  }
}

@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(
    private http: HttpClient
  ) { }

  executeHelloWorldBeanService() {
    return this.http.get<HelloWorldBean>('http://localhost:8080/hello-world-bean');
    // console.log("Execute Hello World Bean Service");
  }

  // http://localhost:8080/hello-world/path-variable/SDA

  executeHelloWorldServiceWithPathVariable(name: any) {
    // let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    // let headers = new HttpHeaders({
    //   Authorization: basicAuthHeaderString
    // })
    return this.http.get<HelloWorldBean>(`http://localhost:8080/hello-world/path-variable/${name}`)
    // { headers });
    // console.log("Execute Hello World Bean Service");
  }



  // createBasicAuthenticationHttpHeader() {
  //   let username = 'SDA'
  //   let password = 'dummy'
  //   let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
  //   return basicAuthHeaderString;
  // }

}

// Access to XMLHttpRequest at 'http://localhost:8080/hello-world/path-variable/SDA' 
//from origin 'http://localhost:4200' has been blocked by CORS policy: 
//No 'Access-Control-Allow-Origin' header is present on the requested resource.
// :8080/hello-world/path-variable/SDA:1 Failed to load resource: net::ERR_FAILED