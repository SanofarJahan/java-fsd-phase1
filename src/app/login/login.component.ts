import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  registerForm: FormGroup;
  uemail: string = '';
  upassword: string = '';
  submitted: boolean = false;
  constructor(private builder: FormBuilder, private router: Router) {}

  ngOnInit(): void {
    this.registerForm = this.builder.group({
      uemail: [''],
      upassword: [''],
    });
  }

  OnSubmit() {
    this.submitted = true;

    this.uemail = this.registerForm.get('uemail')?.value;
    this.upassword = this.registerForm.get('upassword')?.value;
    if (this.uemail == 'san@gmail.com' && this.upassword == '123') {
      // alert("Form Submitted Successfully"+this.upassword);
      this.router.navigate(['dashboard']);
    } else {
      alert('wrong credential');
    }
  }
}