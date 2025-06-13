package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion41 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion41(String selfEvaluationQuestion41) {
    if (Objects.isNull(selfEvaluationQuestion41)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion41.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion41;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
