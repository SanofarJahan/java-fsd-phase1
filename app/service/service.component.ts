import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {
  title='service';

  user={"fname":'',"lname":''}
  //dependency injection of data service
  constructor(private service:DataService) { }

  ngOnInit(): void {
    this.user=this.service.getUser()
  }

}
