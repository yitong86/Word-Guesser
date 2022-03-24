package com.sophia;

import java.util.*;

public class Main {
    static String letterGuess;
    static int incorrectGuessCount = 0;
    static int incorrectGuessLimit = 2;
    static boolean outOfGuesses = false;

    static  String[] playableWords = new String[]{
            "about", "beginning", "carry",
            "dance", "early", "false",
            "glasses", "happy", "issues",
            "jewels", "knife", "labor",
            "major", "never", "oceans",
            "paint", "quick", "radar",
            "seize", "taste", "under",
            "value", "wages"
    };


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //pick one word
        Random random = new Random();
        String word = playableWords[(random.nextInt(playableWords.length))];
        System.out.println(word);
        // int index = random.nextInt(playableWords.length);
        //int randomIndex = (int) (Math.random() * PLAYABLE_WORDS.length);
        //list of character
        ArrayList<Character> playerGuesses = new ArrayList<>();
        printWordState(word,playerGuesses);



       while (true) {
           getPlayerGuess(keyboard, word, playerGuesses);

           printWordState(word,playerGuesses);
           // ArrayList convert to string
           String  str = "";
           for (int i = 0;i < playerGuesses.size();i++) {
               if (playerGuesses.size() - 1 == i) {
                   str += playerGuesses.get(i) + " ";
               } else {
                   str += playerGuesses.get(i) + ",";
               }
           }
           System.out.println();
           System.out.println("Guesses: " + str);

      }

    }

    //take the word the player guess and take it to the playerGuesses
    private static void getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {

            if (incorrectGuessCount < incorrectGuessLimit ) {
                System.out.println();
                System.out.println("Please guess a letter in a word !");
                letterGuess = keyboard.nextLine();
                if(!word.contains(letterGuess)) {
                    incorrectGuessCount++;
                }
                    playerGuesses.add(letterGuess.charAt(0));
                    System.out.println("Incorrect Guesses made: " + incorrectGuessCount + "/" + incorrectGuessLimit);
            } else {
               outOfGuesses = true;
                System.out.println("You run out of turns. ");
                System.exit(0);




                    }
                    }




    //if player has guess the letter.print out the letter.if not print out "_"
    private static void printWordState(String word, List<Character> playerGuesses) {
        System.out.print("Word: ");
        int letterCounter = 0;
        int correctCount = 0;
        //user guess the correct letter. we print a letter.otherwise print"-"
        for (int i = 0; i < word.length(); i++) {
                if (playerGuesses.contains(word.charAt(i)) ) {
                    System.out.print(word.charAt(i));
                    correctCount++;
                } else {
                    System.out.print("_");
                    letterCounter++;

                }
            }

        System.out.println();

        System.out.print("You need to guess " + letterCounter + " letters." );

            if (word.length() == correctCount){
                System.out.println();
                System.out.println("You win");
                System.exit(0);
            }

        }
    }
