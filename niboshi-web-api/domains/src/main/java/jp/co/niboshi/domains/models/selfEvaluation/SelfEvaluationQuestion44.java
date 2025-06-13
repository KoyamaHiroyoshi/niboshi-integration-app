package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion44 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion44(String selfEvaluationQuestion44) {
    if (Objects.isNull(selfEvaluationQuestion44)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion44.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion44;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
