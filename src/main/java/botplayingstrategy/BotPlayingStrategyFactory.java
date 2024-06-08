package botplayingstrategy;
import models.BotDifficultylevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyforDifficultylevel(BotDifficultylevel botDifficultylevel) {
        return new EasyPlayingStrategy();
    }

}
