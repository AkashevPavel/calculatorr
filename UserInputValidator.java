package javaMentor.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator {
    private final String arabicTemplate = "^([1][0]|[1-9])(\\+|\\-|\\*|\\/)([1][0]|[1-9])$",
            romanTemplate = "^(I{1,3}|I{0,2}[VX]|VI{0,2}|X)(\\+|\\-|\\*|\\/)(I{1,3}|I{0,2}[VX]|VI{0,2}|X)$";
    private Pattern arabicPattern, romanPattern;
    private Matcher arabicMatcher, romanMatcher;
    private static String userInput;

    private static String getUserInput(){
        return userInput;
    }

     UserInputValidator(String userInput) {
        UserInputValidator.userInput = userInput;
        arabicPattern = Pattern.compile(arabicTemplate);
        arabicMatcher = arabicPattern.matcher(userInput);

        romanPattern = Pattern.compile(romanTemplate);
        romanMatcher = romanPattern.matcher(userInput);

        if(!arabicMatcher.matches() && !romanMatcher.matches()) throw new IllegalArgumentException(userInput + " is illegal expression. Try again");

        if(arabicMatcher.matches()) Extractor.extraction(arabicMatcher);
        else Extractor.extraction(romanMatcher);
    }

    public static boolean isArabic() {

        return UserInputValidator.getUserInput().matches("^([1][0]|[1-9])(\\+|\\-|\\*|\\/)([1][0]|[1-9])$");
    }

}
