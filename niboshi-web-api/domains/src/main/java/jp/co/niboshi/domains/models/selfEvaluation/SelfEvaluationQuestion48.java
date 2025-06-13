package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion48 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion48(String selfEvaluationQuestion48) {
    if (Objects.isNull(selfEvaluationQuestion48)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion48.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion48;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
