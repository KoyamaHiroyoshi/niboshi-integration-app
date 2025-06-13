package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion19 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion19(String selfEvaluationQuestion19) {
    if (Objects.isNull(selfEvaluationQuestion19)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion19.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion19;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
