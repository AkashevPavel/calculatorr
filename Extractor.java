package javaMentor.calculator;


import java.util.regex.Matcher;

import static java.lang.Integer.parseInt;

public class Extractor {
    private static int first, second;
    private static char operator;

    public static int getFirst() {
        return first;
    }
    public static int getSecond() {
        return second;
    }
    public static char getOperator() {
        return operator;
    }

    public static void extraction(Matcher matcher) {

        try {
            first = parseInt(matcher.group(1));
            second = parseInt(matcher.group(3));
        } catch (NumberFormatException nfe) {
            first = Converter.romanToArabic(matcher.group(1));
            second = Converter.romanToArabic(matcher.group(3));
        }
        operator = matcher.group(2).charAt(0);

    }


}


