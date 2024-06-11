package models;



import botplayingstrategy.*;

public class Bot extends Player{
   private BotDifficultylevel botDifficultylevel;
   private BotPlayingStrategy botPlayingStrategy;
    public Bot(char symbol, String name, int id, PlayerType playerType,BotDifficultylevel botDifficultylevel) {
        super(symbol, name, id, playerType);
        this.botDifficultylevel = botDifficultylevel;
        BotPlayingStrategyFactory botPlayingStrategyFactory = new BotPlayingStrategyFactory();
        this.botPlayingStrategy = botPlayingStrategyFactory.getBotPlayingStrategy(botDifficultylevel);

    }

    public Cell makeMove(Board board) {
        Cell cell =  botPlayingStrategy.makeMove(board);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }
}
