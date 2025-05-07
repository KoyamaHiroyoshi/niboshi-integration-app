package jp.co.nile.domains.models.players;

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
public class UpdatePlayerParams {
  @NonNull
  private PlayerId id;
  @NonNull
  private PlayerName name;
}
