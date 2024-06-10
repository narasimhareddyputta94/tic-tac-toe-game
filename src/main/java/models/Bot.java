package models;



import botplayingstrategy.*;

public class Bot extends Player{
   private BotDifficultylevel botDifficultylevel;
   private BotPlayingStrategy botPlayingStrategy;


    public Cell makeMove(Board board) {
        Cell cell =  botPlayingStrategy.makeMove(board);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }
}
