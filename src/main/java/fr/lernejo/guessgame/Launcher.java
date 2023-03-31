package fr.lernejo.guessgame;

import fr.lernejo.guessgame.HumanPlayer;
import fr.lernejo.guessgame.Simulation;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int i = random.nextInt(100);
        Simulation simulation = new Simulation(new HumanPlayer());
        simulation.initialize(i);
        simulation.loopUntilPlayerSucceed();
    }
}
