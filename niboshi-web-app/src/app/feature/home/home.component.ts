import { Component } from '@angular/core';
import { SendApiService } from '../../service/send-api.service';
@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  count: number = 0;
  returnStr: string = "";

  increment() {
    this.count++;
  }

  constructor(private sendApiService: SendApiService) {}

  test01() {
    this.returnStr = this.sendApiService.sample01();
    this.returnStr = this.returnStr + this.count.toString();
  }

}
