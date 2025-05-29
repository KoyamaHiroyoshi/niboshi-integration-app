import { Component } from '@angular/core';
import { AppLayoutHeaderComponent } from '../../../layout/app-layout-header/app-layout-header.component';
import { AppLayoutFooterComponent } from '../../../layout/app-layout-footer/app-layout-footer.component';
@Component({
  selector: 'app-self-evaluation-top',
  imports: [AppLayoutHeaderComponent, AppLayoutFooterComponent],
  templateUrl: './self-evaluation-top.component.html',
  styleUrl: './self-evaluation-top.component.css'
})
export class SelfEvaluationTopComponent {

}
