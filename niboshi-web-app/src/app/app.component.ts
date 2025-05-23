import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SelfEvaluation01Component } from './feature/self-evaluation/self-evaluation-01/self-evaluation-01.component';
import { SelfEvaluation02Component } from './feature/self-evaluation/self-evaluation-02/self-evaluation-02.component';



@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SelfEvaluation01Component, SelfEvaluation02Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-app';
}
