import { Component, OnInit } from '@angular/core';
import {Authentication} from "../../domain/authentication";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  auth = new Authentication('', '');

  constructor() { }

  ngOnInit() {
  }

}
