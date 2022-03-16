package com.sophia;

import java.util.Random;

public class Randomizer {
    //instance of random class
    private static Random rand = new Random();
    //upperlim =100->0->99.9999
    public static int getRandInt(int upperLim){
        return rand.nextInt(upperLim);
    }

}
