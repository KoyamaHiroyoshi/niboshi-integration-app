## WEBアプリ実行
- npm install -g @angular/cli
- cd niboshi-web-app
- npm install
- ng serve

## API起動
### local起動Ver
- niboshi-web-api配下の.env.template を.envとしてコピー
- Spring Boot Dahsboardからniboshi-interfacesを起動

### Docker起動Ver
- niboshi-web-api配下の.env.template を.envとしてコピー
- VSCodeタスクから「up-app-database」を実行

### コンポーネント作成
- ng generate component xxxxxxxxxxx

### サービス作成
- ng generate service xxxxxxxxxxx

### コンソールの文字化け解消
- chcp 65001