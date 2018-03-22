package com.example.ruben.converter.MorseCode;

import java.util.HashMap;

/**
 * Created by rubenrodrigues on 05/11/2017.
 */

public class MorseCodeFunctionality {

    static String[] ALPHA = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "!", ",", "?",
            ".", "'" };
    static String[] MORSE = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "-.-.--", "--..--",
            "..--..", ".-.-.-", ".----.", };

    public static HashMap<String, String> ALPHA_TO_MORSE = new HashMap<>();

    static {
        for (int i = 0; i < ALPHA.length  &&  i < MORSE.length; i++) {
            ALPHA_TO_MORSE.put(ALPHA[i], MORSE[i]);
        }
    }

    public static String alphaToMorseCode(String englishCode) {
        StringBuilder builder = new StringBuilder();
        String[] words = englishCode.trim().split(" ");

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String hex = ALPHA_TO_MORSE.get(word.substring(i, i + 1));
                builder.append(hex).append(" ");
            }

            builder.append("  ");
        }

        return builder.toString();
    }
}
