import { Routes } from '@angular/router';
import { HomeComponent } from './feature/home/home.component';
import { SelfEvaluation01Component } from './feature/self-evaluation/self-evaluation-01/self-evaluation-01.component';
import { SelfEvaluation02Component } from './feature/self-evaluation/self-evaluation-02/self-evaluation-02.component';

export const routes: Routes = [
    {
        path: '',
        title: 'Home',
        component: HomeComponent,
    },
    {
        path: 'SelfEvaluation',
        title: 'SelfEvaluation',
        component: SelfEvaluation01Component,
    },
    {
        path: 'SelfEvaluation02',
        title: 'SelfEvaluation',
        component: SelfEvaluation02Component,
    }
];
