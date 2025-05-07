package jp.co.nile.interfaces.players;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.openapitools.api.PlayersApi;
import org.openapitools.model.CreatePlayersRequest;
import org.openapitools.model.Player;
import org.openapitools.model.Players;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import jp.co.nile.applications.usecases.players.PlayerUsecases;
import jp.co.nile.domains.models.players.CreatePlayerParams;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.players.PlayerName;
import jp.co.nile.domains.models.players.UpdatePlayerParams;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PlayersController implements PlayersApi {
  private final PlayerUsecases playersUseCases;
  private final InterfacePlayersConverter playersConverter;

  @Override
  public ResponseEntity<Void> createPlayers(@Valid CreatePlayersRequest createPlayersRequest) {
    playersUseCases.createPlayers(createPlayersRequest.getPlayers().stream()
        .map(req -> new PlayerName(req.getName())).collect(Collectors.toList()).stream()
        .map(CreatePlayerParams::new).collect(Collectors.toList()));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deletePlayer(String playerId) {
    playersUseCases.deletePlayers(new ArrayList<>(Arrays.asList(new PlayerId(playerId))));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Players> findAllPlayers() {
    return new ResponseEntity<>(
        playersConverter.toInterfaceFindAllPlayersResponse(playersUseCases.findAllPlayers()),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Player> findPlayer(String playerId) {
    return new ResponseEntity<>(
        playersConverter.toInterfacePlayer(playersUseCases.findPlayer(new PlayerId(playerId))),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> updatePlayer(String playerId,
      org.openapitools.model.@Valid CreatePlayerParams body) {
    playersUseCases.updatePlayer(UpdatePlayerParams.builder().id(new PlayerId(playerId))
        .name(new PlayerName(body.getName())).build());

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
