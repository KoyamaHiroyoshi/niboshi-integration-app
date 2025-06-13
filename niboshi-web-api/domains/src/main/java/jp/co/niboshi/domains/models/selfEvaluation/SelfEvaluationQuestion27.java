package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion27 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion27(String selfEvaluationQuestion27) {
    if (Objects.isNull(selfEvaluationQuestion27)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion27.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion27;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
