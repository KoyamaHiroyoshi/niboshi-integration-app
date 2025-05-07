package jp.co.nile.domains.models.players;

import jp.co.nile.domains.models.shared.NileModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Player implements NileModel {
  @NonNull
  private PlayerId id;
  @NonNull
  private PlayerName name;
}
