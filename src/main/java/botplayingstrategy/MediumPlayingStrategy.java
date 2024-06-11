package botplayingstrategy;

import models.Board;
import models.Cell;

import java.util.Random;

public class MediumPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Cell makeMove(Board board) {
        Cell winningMove = findWinningMove(board);
        if (winningMove != null) {
            return winningMove;
        }

        // If no winning move, pick a random move
        return getRandomMove(board);
    }

    private Cell findWinningMove(Board board) {
        // Check if there's a move that can win the game
        for (Cell cell : board.getEmptyCells()) {
            board.setCell(cell, 1); // Assume bot is player 1
            if (board.checkWin(1)) {
                board.setCell(cell, 0); // Reset cell
                return cell;
            }
            board.setCell(cell, 0); // Reset cell
        }
        return null;
    }

    private Cell getRandomMove(Board board) {
        Random random = new Random();
        Cell[] emptyCells = board.getEmptyCells();
        return emptyCells[random.nextInt(emptyCells.length)];
    }
}
