import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Employee {
  id: number;
  name: string;
  mail_address: string;
  password: string;
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
  getData(): Observable<{ employees: Employee[] }> { 
    return this.http.get<{ employees: Employee[] }>(this.apiUrl);
  }

  loginCheck(mail_address: string, password: string): Observable<Employee> { 
    return this.http.get<Employee>(this.apiUrl + '/' + mail_address + '/' + password);
  }

  sendData(): Observable<any> {
    return this.http.get(this.apiUrl); // GETリクエストを送信
  }

  sample01() {
    var s: string = 'str';
    return s;
  }
}

