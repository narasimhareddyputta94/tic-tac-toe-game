package botplayingstrategy;
import models.BotDifficultylevel;

public class BotPlayingStrategyFactory {
    public BotPlayingStrategy getBotPlayingStrategy(BotDifficultylevel botDifficultylevel){
        switch (botDifficultylevel){
            case EASY:
                return new EasyPlayingStrategy();
            case MEDIUM:
                return new MediumPlayingStrategy();
            case HARD:
                return new HardPlayingStrategy();
            default:
                return null;
        }
    }

}
