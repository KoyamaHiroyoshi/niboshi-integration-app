import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root' // スタンドアロン環境でも利用可能
})
export class SendApiService {
  private apiUrl = 'https://example.com/api'; // 実際のAPIのURLに置き換えてください

  constructor(private http: HttpClient) { }

  sendData(data: any): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.apiUrl, data, { headers });
  }

  sample01() {
    var s: string = 'str';
    return s;
  }
}

