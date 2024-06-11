package AppRunner;

import controller.GameController;
import exception.MoreThanOneBotException;
import exception.SymbolsNotUniqueException;
import exception.dimensionislessthan3exception;
import exception.minimunmplayersrequiredshouldbe1lessthansizeofboardexception;
import models.*;
import winningstratagies.ColumnWinningStrategy;
import winningstratagies.DiagonalWinningStrategy;
import winningstratagies.RowWinningstrategy;
import winningstratagies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws dimensionislessthan3exception, SymbolsNotUniqueException, MoreThanOneBotException, minimunmplayersrequiredshouldbe1lessthansizeofboardexception {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        int dimension = 3;
        List<Player> playerList = new ArrayList<>();
        List<WinningStrategy> winningStrategies = new ArrayList<>();

        playerList.add(new Player('X', "Keerthi", 1, PlayerType.HUMAN));
        playerList.add(new Bot('0', "GPT", 2, PlayerType.BOT, BotDifficultylevel.HARD));

        winningStrategies.add(new RowWinningstrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.startGame(dimension, playerList, winningStrategies);

        while(game.getGameState().equals(GameState.IN_PROGRESS)){

            /*
                1. print board
                2. do you want to undo
                3 make move?
            */




            game.printBoard();

            System.out.println("Do you want to undo the last move? (Y/N)");

            String undo = scanner.next();

            if("Y".equalsIgnoreCase(undo)){
                gameController.undoMove(game);
                continue;
            }


            gameController.makeMove(game);
        }

        // If I'm here, it means game is not in progress anymore
        if(GameState.WIN.equals(game.getGameState())){
            System.out.println(game.getWinner().getName()+", Congrats! You won the Game :)");
        }
        if(GameState.DRAW.equals(game.getGameState())){
            System.out.println("Match tied :| ");
        }
    }
}