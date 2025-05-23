import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { SelfEvaluationComponent } from './app/self-evaluation/self-evaluation.component';
import { SelfEvaluation02Component } from './app/self-evaluation-02/self-evaluation-02.component';

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));

bootstrapApplication(SelfEvaluationComponent, appConfig)
.catch((err) => console.error(err));

bootstrapApplication(SelfEvaluation02Component, appConfig)
.catch((err) => console.error(err));