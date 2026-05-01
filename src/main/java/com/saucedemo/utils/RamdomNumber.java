package com.saucedemo.utils;

import java.util.Random;

public class RamdomNumber {

    private static final Random random = new Random();

    public static int generateInt(int bound) {
        return random.nextInt(1, bound + 1);
    }

}
