package AppRunner;

import controller.GameController;
import exception.MoreThanOneBotException;
import exception.SymbolsNotUniqueException;
import exception.dimensionislessthan3exception;
import exception.minimunmplayersrequiredshouldbe1lessthansizeofboardexception;
import models.*;
import winningstratagies.ColumnWinningStrategy;
import winningstratagies.DiagonalWinningStratregy;
import winningstratagies.RowWinningstrategy;
import winningstratagies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws dimensionislessthan3exception, SymbolsNotUniqueException, MoreThanOneBotException, minimunmplayersrequiredshouldbe1lessthansizeofboardexception {
        GameController gameController = new GameController();
        int dimension = 3;
        List<Player> playerList = new ArrayList<>();
        List<WinningStrategy> winningStrategies = new ArrayList<>();

        playerList.add(new Player('X', "Player1", 1, PlayerType.HUMAN));
        playerList.add(new Bot('O', "Player2", 2, PlayerType.BOT, BotDifficultylevel.EASY));

        winningStrategies.add(new RowWinningstrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStratregy());

        Game game = gameController.startGame(dimension, playerList, winningStrategies);
        game.printBoard();


    }
}
