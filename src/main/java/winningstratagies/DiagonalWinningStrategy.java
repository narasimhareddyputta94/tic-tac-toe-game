package winningstratagies;

import models.Board;
import models.Move;
import winningstratagies.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {
    private Map<Character, Integer> mainDiagonalCounts = new HashMap<>();
    private Map<Character, Integer> antiDiagonalCounts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();
        int dimension = board.getDimension();

        // Check main diagonal
        if (row == col) {
            mainDiagonalCounts.put(symbol, mainDiagonalCounts.getOrDefault(symbol, 0) + 1);
            if (mainDiagonalCounts.get(symbol) == dimension) {
                System.out.print("Diagonal Winner " + symbol + " wins!");
                return true;
            }
        }

        // Check anti-diagonal
        if (row + col == dimension - 1) {
            antiDiagonalCounts.put(symbol, antiDiagonalCounts.getOrDefault(symbol, 0) + 1);
            if (antiDiagonalCounts.get(symbol) == dimension) {
                System.out.print("Diagonal Winner "+ symbol + " wins!");
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean undoWinningMove(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        char symbol = lastMove.getPlayer().getSymbol();
        int dimension = board.getDimension();

        // Check main diagonal
        if (row == col) {
            mainDiagonalCounts.put(symbol, mainDiagonalCounts.get(symbol) - 1);
        }

        // Check anti-diagonal
        if (row + col == dimension - 1) {
            antiDiagonalCounts.put(symbol, antiDiagonalCounts.get(symbol) - 1);
        }

        return false;
    }
}
