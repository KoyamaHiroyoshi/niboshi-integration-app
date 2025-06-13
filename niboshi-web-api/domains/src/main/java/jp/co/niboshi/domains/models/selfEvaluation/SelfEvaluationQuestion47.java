package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion47 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion47(String selfEvaluationQuestion47) {
    if (Objects.isNull(selfEvaluationQuestion47)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion47.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion47;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
