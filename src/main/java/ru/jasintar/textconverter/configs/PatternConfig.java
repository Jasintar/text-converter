package ru.jasintar.textconverter.configs;

import ru.jasintar.textconverter.models.Pattern;

import java.util.ArrayList;
import java.util.List;

import static ru.jasintar.textconverter.configs.PatternEnvironment.ANY_LTTER_OR_NUMBER;
import static ru.jasintar.textconverter.configs.PatternEnvironment.ANY_SYMBOL_OR_NULL;

/**
 * Created on 23.04.2020.
 *
 * @authot Julia Savicheva
 */
public class PatternConfig {

    private static List<Pattern> patterns;

    public static List<Pattern> getPatterns() {
        if (patterns == null)
            patterns = buildPatternCollection();
        return patterns;
    }

    private static List<Pattern> buildPatternCollection() {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(Pattern.builder()
                .prevSymbol(ANY_SYMBOL_OR_NULL) //any
                .patternToReplace("__")
                .nextSymbol(ANY_LTTER_OR_NUMBER) // 1 любая буква русская или английская или цифра
                .replaceTo("<b>")
                .build());

        patterns.add(Pattern.builder()
                .prevSymbol("[A-Za-zА-яа-яЁё0-9]") // 1 любая буква русская или английская или цифра
                .patternToReplace("**")
                .nextSymbol(ANY_SYMBOL_OR_NULL) // any
                .replaceTo("</b>")
                .build());

        patterns.add(Pattern.builder()
                .prevSymbol(ANY_SYMBOL_OR_NULL) //any
                .patternToReplace("__")
                .nextSymbol(ANY_LTTER_OR_NUMBER) // 1 любая буква русская или английская или цифра
                .replaceTo("<b>")
                .build());

        patterns.add(Pattern.builder()
                .prevSymbol("[A-Za-zА-яа-яЁё0-9]") // 1 любая буква русская или английская или цифра
                .patternToReplace("**")
                .nextSymbol(ANY_SYMBOL_OR_NULL) // any
                .replaceTo("</b>")
                .build());

        patterns.add(Pattern.builder()
                .prevSymbol(ANY_SYMBOL_OR_NULL) //any
                .patternToReplace("_")
                .nextSymbol(ANY_LTTER_OR_NUMBER) // 1 любая буква русская или английская или цифра
                .replaceTo("<i>")
                .build());

        patterns.add(Pattern.builder()
                .prevSymbol("[A-Za-zА-яа-яЁё0-9]") // 1 любая буква русская или английская или цифра
                .patternToReplace("_")
                .nextSymbol(ANY_SYMBOL_OR_NULL) // any
                .replaceTo("</i>")
                .build());

        patterns.add(Pattern.builder()
                .prevSymbol(ANY_SYMBOL_OR_NULL) //any
                .patternToReplace("*")
                .nextSymbol(ANY_LTTER_OR_NUMBER) // 1 любая буква русская или английская или цифра
                .replaceTo("<i>")
                .build());

        patterns.add(Pattern.builder()
                .prevSymbol("[A-Za-zА-яа-яЁё0-9]") // 1 любая буква русская или английская или цифра
                .patternToReplace("*")
                .nextSymbol(ANY_SYMBOL_OR_NULL) // any
                .replaceTo("</i>")
                .build());

        patterns.add(Pattern.builder()
                .prevSymbol(null)
                .patternToReplace("---")
                .nextSymbol(null)
                .replaceTo("<center>***</center>")
                .build());
        return patterns;
    }
}
