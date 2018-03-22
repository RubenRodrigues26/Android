package com.example.ruben.converter.TextSpeak;

import java.util.HashMap;

/**
 * Created by rubenrodrigues on 05/11/2017.
 */

public class TextSpeakFunctionality {

    static String[] ALPHA = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "?", "!", ",", ".", " ",};

    static String[] TEXTSPEAK = {"", "b", "c", "d", "", "f", "g", "h", "", "j", "k", "l", "m", "n", "", "p", "q", "r",
            "s", "t", "", "v", "w", "x", "y", "z", "?", "!", ",", ".", " "};

    public static HashMap<String, String> AlphaToTextspeak = new HashMap<>();

    static {
        for (int i = 0; i < ALPHA.length && i < TEXTSPEAK.length; i++){
            AlphaToTextspeak.put(ALPHA[i], TEXTSPEAK[i]);
        }
    }

    public static String alphaToTextspeak(String engText){
        StringBuilder builder = new StringBuilder();
        String[] word = engText.trim().split("");

        for (String words : word){
            for (int i = 0; i < words.length(); i++){
                String textspeak = AlphaToTextspeak.get(words.substring(i, i+1).toLowerCase());
                builder.append(textspeak).append("");
            }

            builder.append("");
        }

        return builder.toString();
    }
}