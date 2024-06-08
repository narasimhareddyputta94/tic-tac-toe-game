package models;



import botplayingstrategy.*;

public class Bot extends Player{
   private BotDifficultylevel botDifficultylevel;
   private BotPlayingStrategy botPlayingStrategy;
    public Bot(char symbol, String name, int id, PlayerType playerType,BotDifficultylevel botDifficultylevel) {
        super(symbol, name, id, playerType);
        this.botDifficultylevel = botDifficultylevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyforDifficultylevel(botDifficultylevel);
    }
}
