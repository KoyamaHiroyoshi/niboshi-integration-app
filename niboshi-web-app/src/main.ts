import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { AppLayoutHeaderComponent } from './app/layout/app-layout-header/app-layout-header.component';
import { AppLayoutFooterComponent } from './app/layout/app-layout-footer/app-layout-footer.component';

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));

bootstrapApplication(AppLayoutHeaderComponent, appConfig)
  .catch((err) => console.error(err));

bootstrapApplication(AppLayoutFooterComponent, appConfig)
  .catch((err) => console.error(err));