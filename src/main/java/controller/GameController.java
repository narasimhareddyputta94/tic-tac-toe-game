package controller;

import exception.MoreThanOneBotException;
import exception.SymbolsNotUniqueException;
import exception.dimensionislessthan3exception;
import exception.minimunmplayersrequiredshouldbe1lessthansizeofboardexception;
import models.Game;
import models.Player;
import winningstratagies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategies) throws dimensionislessthan3exception, SymbolsNotUniqueException, MoreThanOneBotException, minimunmplayersrequiredshouldbe1lessthansizeofboardexception {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(playerList)
                .setWinningStrategies(winningStrategies)
                .build();

    }
    public void printBoard(Game game) {
        game.printBoard();
    }
}
