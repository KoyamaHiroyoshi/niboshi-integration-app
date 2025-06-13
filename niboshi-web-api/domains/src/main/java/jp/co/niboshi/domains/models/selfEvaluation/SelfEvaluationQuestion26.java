package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion26 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion26(String selfEvaluationQuestion26) {
    if (Objects.isNull(selfEvaluationQuestion26)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion26.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion26;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
