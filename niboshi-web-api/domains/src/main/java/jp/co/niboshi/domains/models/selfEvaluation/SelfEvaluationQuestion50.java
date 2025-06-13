package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion50 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion50(String selfEvaluationQuestion50) {
    if (Objects.isNull(selfEvaluationQuestion50)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion50.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion50;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
