# ベースイメージの指定
FROM amazoncorretto:21

# ワーキングディレクトリの設定
WORKDIR /app

# アプリケーションのJARファイルをコンテナにコピー
COPY /interfaces/target/*.war app.war

# ポートの公開
EXPOSE 8082

# アプリケーションの実行コマンド
ENTRYPOINT ["java", "-jar", "app.war"]
