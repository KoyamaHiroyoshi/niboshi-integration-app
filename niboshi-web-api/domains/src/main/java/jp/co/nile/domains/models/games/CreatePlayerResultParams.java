package jp.co.nile.domains.models.games;

import jp.co.nile.domains.models.players.PlayerId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CreatePlayerResultParams {
  @NonNull
  private final PlayerId playerId;

  @NonNull
  private final Integer score;

  @NonNull
  private final GameStartWind gameStartWind;
}
