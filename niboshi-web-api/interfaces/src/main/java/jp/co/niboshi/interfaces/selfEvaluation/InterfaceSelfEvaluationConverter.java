package jp.co.niboshi.interfaces.selfEvaluation;

import org.openapitools.model.SelfEvaluation;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InterfaceSelfEvaluationConverter {
  public SelfEvaluation toInterfaceSelfEvaluation(
      jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluation domainSelfEvaluation) {
    log.info("Id:　" + domainSelfEvaluation.getId().toString());
    log.info("UserId:　" + domainSelfEvaluation.getUserId().toString());
    SelfEvaluation interfaceSelfEvaluation = new SelfEvaluation();
    try{
    interfaceSelfEvaluation.setId(domainSelfEvaluation.getId().toString());
    interfaceSelfEvaluation.setUserId(domainSelfEvaluation.getUserId().toString());
    interfaceSelfEvaluation.setQuestion01(domainSelfEvaluation.getQuestion01().toString());
    interfaceSelfEvaluation.setQuestion02(domainSelfEvaluation.getQuestion02().toString());
    interfaceSelfEvaluation.setQuestion03(domainSelfEvaluation.getQuestion03().toString());
    interfaceSelfEvaluation.setQuestion04(domainSelfEvaluation.getQuestion04().toString());
    interfaceSelfEvaluation.setQuestion05(domainSelfEvaluation.getQuestion05().toString());
    interfaceSelfEvaluation.setQuestion06(domainSelfEvaluation.getQuestion06().toString());
    interfaceSelfEvaluation.setQuestion07(domainSelfEvaluation.getQuestion07().toString());
    interfaceSelfEvaluation.setQuestion08(domainSelfEvaluation.getQuestion08().toString());
    interfaceSelfEvaluation.setQuestion09(domainSelfEvaluation.getQuestion09().toString());
    interfaceSelfEvaluation.setQuestion10(domainSelfEvaluation.getQuestion10().toString());
    interfaceSelfEvaluation.setQuestion11(domainSelfEvaluation.getQuestion11().toString());
    interfaceSelfEvaluation.setQuestion12(domainSelfEvaluation.getQuestion12().toString());
    interfaceSelfEvaluation.setQuestion13(domainSelfEvaluation.getQuestion13().toString());
    interfaceSelfEvaluation.setQuestion14(domainSelfEvaluation.getQuestion14().toString());
    interfaceSelfEvaluation.setQuestion15(domainSelfEvaluation.getQuestion15().toString());
    interfaceSelfEvaluation.setQuestion16(domainSelfEvaluation.getQuestion16().toString());
    interfaceSelfEvaluation.setQuestion17(domainSelfEvaluation.getQuestion17().toString());
    interfaceSelfEvaluation.setQuestion18(domainSelfEvaluation.getQuestion18().toString());
    interfaceSelfEvaluation.setQuestion19(domainSelfEvaluation.getQuestion19().toString());
    interfaceSelfEvaluation.setQuestion20(domainSelfEvaluation.getQuestion20().toString());
    interfaceSelfEvaluation.setQuestion21(domainSelfEvaluation.getQuestion21().toString());
    interfaceSelfEvaluation.setQuestion22(domainSelfEvaluation.getQuestion22().toString());
    interfaceSelfEvaluation.setQuestion23(domainSelfEvaluation.getQuestion23().toString());
    interfaceSelfEvaluation.setQuestion24(domainSelfEvaluation.getQuestion24().toString());
    interfaceSelfEvaluation.setQuestion25(domainSelfEvaluation.getQuestion25().toString());
    interfaceSelfEvaluation.setQuestion26(domainSelfEvaluation.getQuestion26().toString());
    interfaceSelfEvaluation.setQuestion27(domainSelfEvaluation.getQuestion27().toString());
    interfaceSelfEvaluation.setQuestion28(domainSelfEvaluation.getQuestion28().toString());
    interfaceSelfEvaluation.setQuestion29(domainSelfEvaluation.getQuestion29().toString());
    interfaceSelfEvaluation.setQuestion30(domainSelfEvaluation.getQuestion30().toString());
    interfaceSelfEvaluation.setQuestion31(domainSelfEvaluation.getQuestion31().toString());
    interfaceSelfEvaluation.setQuestion32(domainSelfEvaluation.getQuestion32().toString());
    interfaceSelfEvaluation.setQuestion33(domainSelfEvaluation.getQuestion33().toString());
    interfaceSelfEvaluation.setQuestion34(domainSelfEvaluation.getQuestion34().toString());
    interfaceSelfEvaluation.setQuestion35(domainSelfEvaluation.getQuestion35().toString());
    interfaceSelfEvaluation.setQuestion36(domainSelfEvaluation.getQuestion36().toString());
    interfaceSelfEvaluation.setQuestion37(domainSelfEvaluation.getQuestion37().toString());
    interfaceSelfEvaluation.setQuestion38(domainSelfEvaluation.getQuestion38().toString());
    interfaceSelfEvaluation.setQuestion39(domainSelfEvaluation.getQuestion39().toString());
    interfaceSelfEvaluation.setQuestion40(domainSelfEvaluation.getQuestion40().toString());
    interfaceSelfEvaluation.setQuestion41(domainSelfEvaluation.getQuestion41().toString());
    interfaceSelfEvaluation.setQuestion42(domainSelfEvaluation.getQuestion42().toString());
    interfaceSelfEvaluation.setQuestion43(domainSelfEvaluation.getQuestion43().toString());
    interfaceSelfEvaluation.setQuestion44(domainSelfEvaluation.getQuestion44().toString());
    interfaceSelfEvaluation.setQuestion45(domainSelfEvaluation.getQuestion45().toString());
    interfaceSelfEvaluation.setQuestion46(domainSelfEvaluation.getQuestion46().toString());
    interfaceSelfEvaluation.setQuestion47(domainSelfEvaluation.getQuestion47().toString());
    interfaceSelfEvaluation.setQuestion48(domainSelfEvaluation.getQuestion48().toString());
    interfaceSelfEvaluation.setQuestion49(domainSelfEvaluation.getQuestion49().toString());
    interfaceSelfEvaluation.setQuestion50(domainSelfEvaluation.getQuestion50().toString());
    } catch (Exception ex) {
      log.error("catch箇所:　" + "InterfaceSelfEvaluationConverter.toInterfaceSelfEvaluation");
      log.error("エラー内容：" + ex.toString());
    }

    return interfaceSelfEvaluation;
  }

  // public SelfEvaluation toInterfaceFindAllSelfEvaluationResponse(
  // List<jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluation> domainSelfEvaluation) {
  // SelfEvaluation interfaceFindAllPlayersResponse = new SelfEvaluation();
  // interfaceFindAllPlayersResponse.setEmployees(
  // domainSelfEvaluation.stream().map(this::toInterfaceSelfEvaluation).toList());

  // return interfaceFindAllPlayersResponse;
  // }
}
