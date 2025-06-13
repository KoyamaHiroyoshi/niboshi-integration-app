package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;
import lombok.Getter;

@Getter
public class CreateSelfEvaluationParams implements NiboshiModel {
  private final SelfEvaluationId selfEvaluationId;

  public CreateSelfEvaluationParams(SelfEvaluationId selfEvaluationId) {
    if (Objects.isNull(selfEvaluationId)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    }
    this.selfEvaluationId = selfEvaluationId;
  }
}
