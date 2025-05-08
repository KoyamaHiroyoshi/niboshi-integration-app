package jp.co.niboshi.infrastructures.repositories;

import jp.co.niboshi.domains.models.shared.NiboshiModel;

/**
 * Niboshiで扱うEntityはこのinterfaceを実装すること
 */
public interface NiboshiEntity<T extends NiboshiModel> {
}
