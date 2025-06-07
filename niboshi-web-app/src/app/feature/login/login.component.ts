import { Component, ChangeDetectorRef } from '@angular/core';
import { SendApiService, Employee } from '../../service/send-api.service';
import { CommonModule } from '@angular/common'; // ✅ 追加

@Component({
  selector: 'app-login',
  imports: [CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  employees: Employee | null = null;

  constructor(private sendApiService: SendApiService, private cdRef: ChangeDetectorRef) { }

  ngOnInit() {
    this.sendApiService.loginCheck("NBS_100001").subscribe({
      next: (response: Employee) => { // ✅ 正しい型を指定
        console.log('API Response:', response);
        this.employees = response; // ✅ 直接オブジェクトをセット
        this.cdRef.detectChanges(); // ✅ 変更検知を強制実行
        console.log('Formatted employee:', this.employees);
      },
      error: (err) => console.error('API Error:', err)
    });
  }
}
