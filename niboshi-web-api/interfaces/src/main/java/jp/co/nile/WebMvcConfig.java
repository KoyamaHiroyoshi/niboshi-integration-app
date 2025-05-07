package jp.co.nile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import jp.co.nile.interceptors.NileControllerLoggingInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  @Value("${nile.cors.origin:http://localhost:5173}")
  private String nileCorsOrigin;

  @Bean
  NileControllerLoggingInterceptor nileControllerLoggingInterceptor() {
    return new NileControllerLoggingInterceptor();
  }

  @Override
  public void addCorsMappings(@NonNull CorsRegistry registry) {
    registry.addMapping("/**").allowedOrigins(nileCorsOrigin).allowedMethods("GET", "POST", "PUT",
        "DELETE");
  }

  @Override
  public void addInterceptors(@NonNull InterceptorRegistry registry) {
    // コントローラのIN、OUTのロギング
    registry.addInterceptor(nileControllerLoggingInterceptor());
  }
}
