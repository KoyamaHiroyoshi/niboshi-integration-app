package jp.co.niboshi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jp.co.niboshi.interceptors.NiboshiControllerLoggingInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  @Value("${niboshi.cors.origin:http://localhost:4200}")
  private String niboshiCorsOrigin;

  @Bean
  NiboshiControllerLoggingInterceptor niboshiControllerLoggingInterceptor() {
    return new NiboshiControllerLoggingInterceptor();
  }

  @Override
  public void addCorsMappings(@NonNull CorsRegistry registry) {
    registry.addMapping("/**").allowedOrigins(niboshiCorsOrigin).allowedMethods("GET", "POST",
        "PUT",
        "DELETE");
  }

  @Override
  public void addInterceptors(@NonNull InterceptorRegistry registry) {
    // コントローラのIN、OUTのロギング
    registry.addInterceptor(niboshiControllerLoggingInterceptor());
  }
}
