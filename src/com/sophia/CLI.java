package com.sophia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readString(String question){
        System.out.println(question + "\nInput: ");
        return SCANNER.nextLine();
    }

}