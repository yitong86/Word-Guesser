package com.sophia;

import java.util.*;

public class Main {
    static String letterGuess;
    static int incorrectGuessCount = 0;
    static int incorrectGuessLimit = 2;
    static String str ;

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

//        String[] playableWords = new String[]{
//                "guessing", "these", "words",
//                "is", "very", "easy"
//        };
        //pick one word
        Random random = new Random();
        // int index = random.nextInt(playableWords.length);
        //int randomIndex = (int) (Math.random() * PLAYABLE_WORDS.length);
        String word = playableWords[(random.nextInt(playableWords.length))];
        System.out.println(word);

//list of character
        ArrayList<Character> playerGuesses = new ArrayList<>();

        printWordState(word, playerGuesses);


        while (true) {

            getPlayerGuess(keyboard, word, playerGuesses);

          if(printWordState(word,playerGuesses)){
               break;
           }

        }
        System.out.println("You win");
        System.exit(0);
    }

    //take the word the player guess and take it to the playerGuesses
    private static void getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        //ArrayList convert to string
//        str = "";
//        for (int i = 0;i < playerGuesses.size();i++) {
//            if (playerGuesses.size() - 1 == i) {
//                str += playerGuesses.get(i) + " ";
//            } else {
//                str += playerGuesses.get(i) + ",";
//            }
//        }
//        System.out.println("Guesses: " + str);

            if (incorrectGuessCount < incorrectGuessLimit ) {
                System.out.println("Please guess a letter in a word !");
                letterGuess = keyboard.nextLine();
                if(!word.contains(letterGuess)) {
                    incorrectGuessCount++;
                }
                    playerGuesses.add(letterGuess.charAt(0));
                    System.out.println("Incorrect Guesses made: " + incorrectGuessCount + "/" + incorrectGuessLimit);


            } else {
                System.out.println("You run out of turns. ");
                System.out.println("Would you like to start a game or exit? Please enter 1 to start or 2 to exit.");
                int input = keyboard.nextInt();
                    if (input == 2) {
                        System.out.println("Thank you for your playing");
                        System.exit(0);

                    } else if (input == 1) {
                        playerGuesses = new ArrayList<>();
                        Random random = new Random();
                         word = playableWords[(random.nextInt(playableWords.length))];
                        System.out.println(word);
                        incorrectGuessCount = 0;
                        letterGuess = keyboard.nextLine();

                    }
                    }

        System.out.println("Guesses:" + playerGuesses);

    }

    //if player has guess the letter.print out the letter.if not print out "_"
    private static boolean printWordState(String word, List<Character> playerGuesses) {
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

       // System.out.print("You need to guess " + letterCounter + " letters." );

            return (word.length() == correctCount);//true
        }
    }
