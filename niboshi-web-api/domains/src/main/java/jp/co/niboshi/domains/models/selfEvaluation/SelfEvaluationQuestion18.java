package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion18 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion18(String selfEvaluationQuestion18) {
    if (Objects.isNull(selfEvaluationQuestion18)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion18.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion18;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
