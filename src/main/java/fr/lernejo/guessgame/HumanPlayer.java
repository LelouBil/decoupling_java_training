package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    final Logger logger = LoggerFactory.getLogger("player");

    final Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        System.out.print("Chiffre : ");
        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater   ){
            System.out.println("the goal is greater");
        }else{
            System.out.println("the goal is lower");
        }
    }
}
