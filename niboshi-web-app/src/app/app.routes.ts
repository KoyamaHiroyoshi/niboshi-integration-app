import { Routes } from '@angular/router';
import { LoginComponent } from './feature/login/login.component';
import { HomeComponent } from './feature/home/home.component';
import { SelfEvaluationTopComponent } from './feature/self-evaluation/self-evaluation-top/self-evaluation-top.component';
import { SelfEvaluationrRegistComponent } from './feature/self-evaluation/self-evaluation-regist/self-evaluation-regist.component';

export const routes: Routes = [
    {
        path: '',
        title: 'Login',
        component: LoginComponent,
    },
    {
        path: 'Home',
        title: 'Home',
        component: HomeComponent,
    },
    {
        path: 'SelfEvaluation-Top',
        title: 'SelfEvaluation-Top',
        component: SelfEvaluationTopComponent,
    },
    {
        path: 'SelfEvaluation-Regist',
        title: 'SelfEvaluation-Regist',
        component: SelfEvaluationrRegistComponent,
    }
];
