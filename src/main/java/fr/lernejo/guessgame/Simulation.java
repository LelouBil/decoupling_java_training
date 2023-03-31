package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Simulation {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("mm:ss.SSS");
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
            System.out.println("Bravo tu a gagné");
            return true;
        }else{
            boolean lowerOrGreater = numberToGuess > guess;
            player.respond(lowerOrGreater);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long maxIterations) {
        Instant start = Instant.now();
        int count = 0;
        while (!nextRound()){
            count++;
        }
        Instant end = Instant.now();
        Duration timeTook = Duration.between(start,end);
        logger.log(String.format("Temps : %02d:%02d.%03d",timeTook.toMinutesPart(),timeTook.toSecondsPart(),timeTook.toMillisPart()));
        logger.log(String.format("Used %d/%d iters",count,maxIterations));
    }
}
