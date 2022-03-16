package com.sophia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String letterGuess;
    static int guessCount = 0 ;
    static int guessLimit = 7;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String[] playableWords = new String[]{
                "guessing", "these", "words",
                "is", "very", "easy"
        };

        Random random = new Random();
        // int index = random.nextInt(playableWords.length);
        //int randomIndex = (int) (Math.random() * PLAYABLE_WORDS.length);
        String word = playableWords[(random.nextInt(playableWords.length))];
        System.out.println(word);


        ArrayList<Character> playerGuesses = new ArrayList<>();

        printWordState(word, playerGuesses);

        while (true) {
            getPlayerGuess(keyboard, word, playerGuesses);
        }
    }

    //take the word the player guess and take it to the playerGuesses
    private static void getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {

        letterGuess = keyboard.nextLine();
        guessCount++;

        if (guessCount < guessLimit){
            System.out.println("Please guess a letter in a word !");
            System.out.println("Guesses made: " + guessCount);
        }else{
            System.out.println("You loose");
            return;
        }

        playerGuesses.add(letterGuess.charAt(0));
        printWordState(word, playerGuesses);

        //ArrayList convert to string
        String str = "";
        for (int i = 0;i < playerGuesses.size();i++) {
            if (playerGuesses.size() - 1 == i) {
                str += playerGuesses.get(i) + " ";
            } else {
                str += playerGuesses.get(i) + ",";
            }
        }
       // System.out.println(str);
        System.out.println("Guesses: " + str);
    }

    //if player has guess the letter.print out the letter.if not print out "_"
    private static void printWordState(String word, List<Character> playerGuesses) {
        System.out.print("Word: ");
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
                if (playerGuesses.contains(word.charAt(i))) {

                    System.out.print(word.charAt(i));

                } else {

                    System.out.print("_");
                    count++;
                }
            }
            System.out.println();
            System.out.print("You need to guess " + count + " letters." );

            System.out.println();
        }
    }
