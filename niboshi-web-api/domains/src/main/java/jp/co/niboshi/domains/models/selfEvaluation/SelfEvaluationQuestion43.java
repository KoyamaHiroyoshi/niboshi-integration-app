package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion43 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion43(String selfEvaluationQuestion43) {
    if (Objects.isNull(selfEvaluationQuestion43)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion43.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion43;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
