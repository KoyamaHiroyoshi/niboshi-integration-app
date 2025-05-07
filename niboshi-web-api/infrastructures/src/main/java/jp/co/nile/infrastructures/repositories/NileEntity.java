package jp.co.nile.infrastructures.repositories;

import jp.co.nile.domains.models.shared.NileModel;

/**
 * Nileで扱うEntityはこのinterfaceを実装すること
 */
public interface NileEntity<T extends NileModel> {
  // /**
  // * Entityをドメインモデルに変換する
  // *
  // * @return T(ドメインモデル)
  // * @throws SystemDomainModelException
  // */
  // T toModel() throws SystemDomainModelException;
}
