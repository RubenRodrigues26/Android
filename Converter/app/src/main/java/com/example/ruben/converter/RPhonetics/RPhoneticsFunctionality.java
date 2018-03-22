package com.example.ruben.converter.RPhonetics;

import java.util.HashMap;

/**
 * Created by rubenrodrigues on 05/11/2017.
 */

public class RPhoneticsFunctionality {

    static String[] ALPHA = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    static String[] RPHONETICS = {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India",
            "Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango",
            "Uniform", "Victor", "Whiskey", "Xray", "Yankee", "Zulu", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Zero"};

    public static HashMap<String, String> AlphaToRPhonetics = new HashMap<>();

    static {
        for (int i = 0; i < ALPHA.length && i < RPHONETICS.length; i++){
            AlphaToRPhonetics.put(ALPHA[i], RPHONETICS[i]);
        }
    }

    public static String alphaToRphonetics(String engText){
        StringBuilder builder = new StringBuilder();
        String[] word = engText.trim().split(" ");

        for (String words : word){
            for (int i = 0; i < words.length(); i++){
                String morse = AlphaToRPhonetics.get(words.substring(i, i+1).toLowerCase());
                builder.append(morse).append(" ");
            }

            builder.append(" ");
        }

        return builder.toString();
    }
}
