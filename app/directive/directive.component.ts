import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directive',
  templateUrl: './directive.component.html',
  styleUrls: ['./directive.component.css']
})
export class DirectiveComponent implements OnInit {

  constructor() { }

ngOnInit(): void {

}

products=[{"name":"Nikunj Soni","email":"nikunj@gmail.com"},

{"name":"Alex","email":"alex@gmail.com"},

{"name":"Jhon","email":"jhon@gmail.com"},

{"name":"Sujal","email":"sujal@gmail.com"},

{"name":"Baljeet","email":"baljeet@gmail.com"},

{"name":"Mohan","email":"mohan@gmail.com"},

{"name":"Rorisang","email":"rorisang@gmail.com"},

{"name":"Arvind","email":"arvind@gmail.com"},

]

//used for if

flag=false;

show(){

this.flag=!this.flag;

}

//used for switch case

public day= new Date().getDay();

}