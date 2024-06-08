package models;

public class Bot extends Player{
    BotDifficultylevel botDifficultylevel;

    public Bot(char symbol, String name, int id, PlayerType playerType,BotDifficultylevel botDifficultylevel) {
        super(symbol, name, id, playerType);
        this.botDifficultylevel = botDifficultylevel;
    }
}
