package com.sophia;

public class WGGame {
    private final static String[] PLAYABLE_WORDS = new String[]{
            "guessing", "these", "words",
            "is", "very", "easy"
    };
    public static void startGame(){

        System.out.println("GAME STARTED");

        int randomIndex = (int) (Math.random() * PLAYABLE_WORDS.length);

        String gameWord = PLAYABLE_WORDS[randomIndex];
        String gwPlayerCopy = gameWord;



        while (true){

//remove single character
//            if (true){
//                gwPlayerCopy = gwPlayerCopy.substring(0,2) +  gwPlayerCopy.substring(2);
//            }
            //check user has completed word
            break;
        }
        System.out.println(gameWord);
        System.out.println(gwPlayerCopy);
        //Additive
        /*
        *
        * AS the player guesses correct letters, build a copy of the "GameWord"until they match
         */

        //Subtractive Approach
       //gameWord and gameWordPlayerCopy


    }
}
