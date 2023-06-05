package com.example.joueur;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.springframework.boot.SpringApplication;

import java.util.Random;

@ApplicationPath("/api")
public class Joueur extends Application {
    public static void main(String[] args){
        SpringApplication.run(Joueur.class,args);

    }

    public static int[] rollDice() {
        int[] dice = new int[5];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            dice[i] = random.nextInt(6) + 1;
        }
        return dice;
    }

    public static int[] rerollDice(int[] dice, int[] keep) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            if (!contains(keep, i)) {
                dice[i] = random.nextInt(6) + 1;
            }
        }
        return dice;
    }

    public static boolean contains(int[] arr, int val) {
        for (int i : arr) {
            if (i == val) {
                return true;
            }
        }
        return false;
    }

    public static int[] chooseDiceToKeep(int[] dice) {
        int[] keep = new int[5];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            if (random.nextBoolean()) {
                keep[i] = 1;
            }
        }
        return keep;
    }

    public static int chooseCategory(int[] dice) {
        Random random = new Random();
        return random.nextInt(13);
    }

}