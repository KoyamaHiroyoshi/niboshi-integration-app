package jp.co.niboshi.handlers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jp.co.niboshi.domains.models.exceptions.DomainModelException;
import jp.co.niboshi.domains.models.exceptions.SystemDomainModelException;
import jp.co.niboshi.domains.models.exceptions.UserInputErrorException;
import jp.co.niboshi.errors.Niboshi400Error;
import jp.co.niboshi.errors.NiboshiErrorResponse;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class NiboshiControllerAdvice extends ResponseEntityExceptionHandler {
  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
      @NonNull HttpRequestMethodNotSupportedException ex, @NonNull HttpHeaders headers,
      @NonNull HttpStatusCode status, @NonNull WebRequest request) {

    log.debug(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
    return new ResponseEntity<>(NiboshiErrorResponse.builder().message("HTTPリクエストメソッド不正").build(),
        headers, status);
  }

  /**
   * 404エラー時にResourceNotFoundと見分けがつくようにパス不正時のエラーをカスタマイズする
   */
  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(
      @NonNull NoHandlerFoundException ex, @NonNull HttpHeaders headers,
      @NonNull HttpStatusCode status, @NonNull WebRequest request) {

    return handleExceptionInternal(ex, NiboshiErrorResponse.builder().message("パスが見つかりません").build(),
        headers, status, request);
  }

  // TODO: その他発生しうるExceptionのOverride
  // TODO: このファイルが肥大化しすぎそう？分割で対応か

  /**
   * リクエストをドメイン変換する際に発生するDomainModelExceptionのエラー処理を行う<br>
   * HTTPステータス400に変換する。
   *
   * @param exception 発生した例外
   *
   * @return HttpStatus.BAD_REQUEST
   */
  @ExceptionHandler(DomainModelException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public NiboshiErrorResponse handleDomainModelException(DomainModelException exception) {
    log.warn(exception.getMessage(), exception);
    return NiboshiErrorResponse.builder().message(exception.getMessage())
        .errors(List.of(new Niboshi400Error(exception))).build();
  }

  /**
   * バリデーションエラー以外のユーザー入力不正(外部キー制約違反など)<br>
   * HTTPステータス400に変換する。
   *
   * @param exception 発生した例外
   *
   * @return HttpStatus.BAD_REQUEST
   */
  @ExceptionHandler(UserInputErrorException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public NiboshiErrorResponse handleUserInputErrorException(UserInputErrorException exception) {
    log.warn(exception.getMessage(), exception);
    return NiboshiErrorResponse
        .builder()
        .message(exception.getReason())
        .build();
  }

  /**
   * システム内でドメイン変換する際に発生するSystemModelExceptionのエラー処理を行う<br>
   * HTTPステータス500に変換する。
   *
   * @param exception 発生した例外
   *
   * @return HttpStatus.INTERNAL_SERVER_ERROR
   */
  @ExceptionHandler(SystemDomainModelException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public NiboshiErrorResponse handleSystemModelException(SystemDomainModelException exception) {
    log.error(exception.getMessage(), exception);
    return NiboshiErrorResponse.builder().message(exception.getMessage())
        .errors(List.of(new Niboshi400Error(exception))).build();
  }

  /**
   * 上記以外の例外が発生した場合のエラー処理を行う
   *
   * @param exception 発生した例外
   *
   * @return HttpStatus.INTERNAL_SERVER_ERROR
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public NiboshiErrorResponse handleOtherException(Exception exception) {
    log.error("想定外エラー", exception);
    return NiboshiErrorResponse.builder().message("想定外エラー").build();
  }
}
