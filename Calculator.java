package javaMentor.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Calculator {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calculate(bufferedReader.readLine()));
    }

    public static String calculate(String userInput) {
        new UserInputValidator(userInput);
        int result = 0;
        String sResult;

        switch (Extractor.getOperator()) {
            case '+':
                result = Extractor.getFirst() + Extractor.getSecond();
                break;
            case '-':
                result = Extractor.getFirst() - Extractor.getSecond();
                break;
            case '*':
                result = Extractor.getFirst() * Extractor.getSecond();
                break;
            case '/':
                try {
                    result = Extractor.getFirst() / Extractor.getSecond();
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        if (UserInputValidator.isArabic()) sResult = result + "";
        else sResult = Converter.arabicToRoman(result);


        return sResult;




    }
}
