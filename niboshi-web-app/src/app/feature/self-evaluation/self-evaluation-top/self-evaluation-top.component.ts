import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppLayoutHeaderComponent } from '../../../layout/app-layout-header/app-layout-header.component';
import { AppLayoutFooterComponent } from '../../../layout/app-layout-footer/app-layout-footer.component';
import { SendApiService, Employee } from '../../../service/send-api.service';

@Component({
  selector: 'app-self-evaluation-top',
  standalone: true, 
  imports: [CommonModule, AppLayoutHeaderComponent, AppLayoutFooterComponent], 
  templateUrl: './self-evaluation-top.component.html',
  styleUrl: './self-evaluation-top.component.css'

})

export class SelfEvaluationTopComponent {
  employees: Employee[] = [];

  constructor(private sendApiService: SendApiService) { }

ngOnInit() {
  this.sendApiService.getData().subscribe({
    next: response => {
      console.log('API Response:', response); // ✅ レスポンスの構造を確認
      this.employees = response.employees || []; // ✅ `employees` の配列をセット
      console.log('Formatted employees:', this.employees); // ✅ 正しくデータが格納されているか確認
    },
    error: err => console.error('API Error:', err)
  });
}



  // sendData() {
  //   const payload = { message: 'Hello, API!' };
  //   this.sendApiService.sendData(payload).subscribe({
  //     next: response => console.log('API Response:', response),
  //     error: err => console.error('API Error:', err)
  //   });
  // }

  sendData() {
    this.sendApiService.sendData().subscribe({
      next: response => console.log('API Response:', response),
      error: err => console.error('API Error:', err)
    });
  }
}
