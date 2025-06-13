package jp.co.niboshi.infrastructures.repositories.selfEvaluation;

import org.springframework.stereotype.Component;

import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluation;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluationId;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InfraSelfEvaluationsConverter {
  public SelfEvaluation toSelfEvaluation(SelfEvaluationEntity selfEvaluationEntity) {
    try {
      return SelfEvaluation.builder()
          .id(new SelfEvaluationId(selfEvaluationEntity.getId()))
          .build();
    } catch (Exception e) {
      log.error("catch箇所:　" + "InfraEmployeesConverter.Employee");
      log.error("エラー内容：　" + e.toString());
    }
    return null;
  }
}
