import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { provideHttpClient } from '@angular/common/http';

// bootstrapApplication(AppComponent, appConfig)
//   .catch((err) => console.error(err));

// bootstrapApplication(AppComponent, {
//   providers: [
//     provideHttpClient() // HttpClient を使用するためのプロバイダ
//   ]
// });

bootstrapApplication(AppComponent, {
  ...appConfig, // 既存の設定を展開
  providers: [
    ...(appConfig.providers || []), // 既存の providers を引き継ぐ
    provideHttpClient() // HttpClient を追加
  ]
}).catch((err) => console.error(err));

