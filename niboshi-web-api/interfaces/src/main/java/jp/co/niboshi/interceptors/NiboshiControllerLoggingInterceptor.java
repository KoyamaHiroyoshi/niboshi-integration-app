package jp.co.niboshi.interceptors;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NiboshiControllerLoggingInterceptor implements HandlerInterceptor {
  private static final String START_TIME_ATTR_NAME = "NIBOSHI_CONTROLLER_START_TIME";

  @Override
  public boolean preHandle(@NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
    request.setAttribute(START_TIME_ATTR_NAME, System.currentTimeMillis());
    log.info("コントローラ開始:%s %s".formatted(request.getMethod(), request.getRequestURI()));
    return true;
  }

  @Override
  public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
      @NonNull Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    long startTime = (Long) request.getAttribute(START_TIME_ATTR_NAME);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    log.info("コントローラ終了:%s %s(処理時間:%dms)".formatted(request.getMethod(), request.getRequestURI(),
        executionTime));
  }
}
