package jp.co.nile.errors;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NileErrorResponse {
  /**
   * メッセージ
   */
  private String message;
  /**
   * エラー詳細
   */
  private List<NileError> errors;
}
