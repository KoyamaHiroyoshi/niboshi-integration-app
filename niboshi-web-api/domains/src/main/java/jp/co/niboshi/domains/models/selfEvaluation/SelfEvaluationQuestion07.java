package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion07 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion07(String selfEvaluationQuestion07) {
    if (Objects.isNull(selfEvaluationQuestion07)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion07.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion07;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
