import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SelfEvaluationTopComponent } from './feature/self-evaluation/self-evaluation-top/self-evaluation-top.component';
import { SelfEvaluationrRegistComponent } from './feature/self-evaluation/self-evaluation-regist/self-evaluation-regist.component';



@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SelfEvaluationTopComponent, SelfEvaluationrRegistComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-app';
}
