package jp.co.nile.infrastructures.repositories.players;

import java.util.List;
import java.util.UUID;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlayersMapper {
    void createPlayers(List<PlayerEntity> newPlayers);

    List<PlayerEntity> selectAllPlayers();

    PlayerEntity selectPlayerById(UUID playerId);

    List<PlayerEntity> selectPlayersById(List<UUID> playerIds);

    void updatePlayer(UUID playerId, String playerName);

    void deletePlayers(List<UUID> playerIds);
}
