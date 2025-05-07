package jp.co.nile.domains.models.leagues;

import java.util.Optional;
import jp.co.nile.domains.models.shared.NileModel;
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
public class League implements NileModel {
  @Getter
  @NonNull
  private final LeagueId id;
  @Getter
  @NonNull
  private final LeagueName name;
  @Getter
  @NonNull
  private final LeagueStartAt startAt;
  private final LeagueEndAt endAt;

  public Optional<LeagueEndAt> getEndAt() {
    return Optional.ofNullable(endAt);
  }
}
