package stratagies;

import models.Board;
import models.Move;

public class RowWinningstrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}