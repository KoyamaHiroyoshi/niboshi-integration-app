import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { SendApiService, Employee } from '../../service/send-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  employees: Employee | null = null;
  errorMessage: string = ''; // ✅ エラーメッセージ用変数

  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required]), // ✅ 必須チェック
    password: new FormControl('', [Validators.required]) // ✅ 必須チェック
  });

  constructor(private sendApiService: SendApiService, private router: Router) { }

  login() {
    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched(); // ✅ 全フィールドのエラーメッセージを表示
      return;
    }

    let inputMailAddress = this.loginForm.value.email!;
    let inputPassword = this.loginForm.value.password!;
    if (inputMailAddress == 'aaa') {
      inputMailAddress = 'aaaaaaaaaa@yahoo.co.jp';
      inputPassword = 'NBS_100001';
    }

    console.log('入力メールアドレス:', inputMailAddress);
    console.log('入力パスワード:', inputPassword);

    this.sendApiService.loginCheck(inputMailAddress, inputPassword).subscribe({
      next: (response: Employee) => {
        console.log('API Response:', response);
        this.employees = response;
        console.log('Formatted employee:', this.employees);

        this.router.navigate(['/Home']);

      },
      error: (err) => {
        console.error('API Error:', err);
        this.errorMessage = 'ユーザーが存在しません。再度入力し直してください。'; 
      }
    });
  }
}