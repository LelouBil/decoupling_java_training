package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long guess = player.askNextGuess();
        logger.log("Player guessed " + guess);
        if(guess == numberToGuess){
            logger.log("Right number");
            return true;
        }else{
            boolean lowerOrGreater = numberToGuess > guess;
            if(lowerOrGreater){
                logger.log("Number is greater");
            }else{
                logger.log("Number is lower");
            }
            player.respond(lowerOrGreater);
            return false;
        }
    }

    public void loopUntilPlayerSucceed() {
        //noinspection StatementWithEmptyBody
        while (!nextRound());
    }
}
