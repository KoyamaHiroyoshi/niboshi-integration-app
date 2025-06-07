import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Employee {
  id: number;
  name: string;
  mail_address: string;
}

@Injectable({
  providedIn: 'root' // スタンドアロン環境でも利用可能
})

export class SendApiService {
  private apiUrl = 'http://localhost:8082/employees'; // 実際のAPIのURLに置き換えてください

  constructor(private http: HttpClient) { }

  // sendData(data: any): Observable<any> {
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.post(this.apiUrl, data, { headers });
  // }
  getData(): Observable<{ employees: Employee[] }> { // ✅ 実際のAPIレスポンスの型に修正
    return this.http.get<{ employees: Employee[] }>(this.apiUrl);
  }

  loginCheck(employeeId: string): Observable<Employee> { // ✅ 直接 Employee を返すように修正
    return this.http.get<Employee>(this.apiUrl + '/' + employeeId);
  }

  sendData(): Observable<any> {
    return this.http.get(this.apiUrl); // GETリクエストを送信
  }

  sample01() {
    var s: string = 'str';
    return s;
  }
}

