package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion35 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion35(String selfEvaluationQuestion35) {
    if (Objects.isNull(selfEvaluationQuestion35)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion35.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion35;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
