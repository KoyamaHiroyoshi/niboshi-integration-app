package jp.co.niboshi.errors;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NiboshiErrorResponse {
  /**
   * メッセージ
   */
  private String message;
  /**
   * エラー詳細
   */
  private List<Niboshi400Error> errors;
}
