package com.helpdesk.service;

import java.util.Random;

public class Randomizer {
    public static int createRandomCustomerId() {
        return getRandomNumberInRange(1, 5000);
    }

    private static int getRandomNumberInRange(int min, int max){
        Random random = new Random();
        if (min == 0 && max == 0){
            return random.nextInt();
        } else {
            return random.nextInt((max - min) + 1) + min;
        }
    }
}
