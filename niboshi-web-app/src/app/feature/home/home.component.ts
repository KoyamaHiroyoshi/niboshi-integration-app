import { Component } from '@angular/core';
import { SendApiService } from '../../service/send-api.service';
import { AppLayoutHeaderComponent } from '../../layout/app-layout-header/app-layout-header.component';
import { AppLayoutFooterComponent } from '../../layout/app-layout-footer/app-layout-footer.component';

@Component({
  selector: 'app-home',
  imports: [AppLayoutHeaderComponent, AppLayoutFooterComponent],
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
