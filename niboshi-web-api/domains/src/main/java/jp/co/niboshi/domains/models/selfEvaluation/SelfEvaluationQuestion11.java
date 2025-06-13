package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion11 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion11(String selfEvaluationQuestion11) {
    if (Objects.isNull(selfEvaluationQuestion11)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion11.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion11;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
