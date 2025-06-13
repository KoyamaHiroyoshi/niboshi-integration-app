package jp.co.niboshi.interfaces.selfEvaluation;

import java.util.ArrayList;
import java.util.Arrays;

import org.openapitools.api.SelfEvaluationApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jp.co.niboshi.applications.usecases.selfEvaluations.SelfEvaluationsUsecases;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluation;
import jp.co.niboshi.domains.models.selfEvaluation.CreateSelfEvaluationParams;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluationId;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluationUserId;
import jp.co.niboshi.domains.models.selfEvaluation.UpdateSelfEvaluationParams;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class SelfEvaluationApiController implements SelfEvaluationApi {
  private final SelfEvaluationsUsecases selfEvaluationsUsecases;
  private final InterfaceSelfEvaluationConverter selfEvaluationConverter;

  // @Override
  // public ResponseEntity<SelfEvaluation> findSelfEvaluation(String selfEvaluationUserId) {
  //   ResponseEntity<SelfEvaluation> returnEntity = new ResponseEntity<>(
  //       selfEvaluationConverter
  //           .toInterfaceSelfEvaluation(
  //               selfEvaluationsUsecases
  //                   .findSelfEvaluation(new SelfEvaluationUserId(selfEvaluationUserId))),
  //       HttpStatus.OK);
  //   log.info(returnEntity.toString());
  //   return returnEntity;
  // }

  @Override
  public ResponseEntity<org.openapitools.model.SelfEvaluation> findSelfEvaluation(String selfEvaluationUserId) {
    org.openapitools.model.SelfEvaluation response = selfEvaluationConverter.toInterfaceSelfEvaluation(
        selfEvaluationsUsecases.findSelfEvaluation(new SelfEvaluationUserId(selfEvaluationUserId)));

    return ResponseEntity.ok(response);
  }
}
