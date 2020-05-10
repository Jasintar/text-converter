package ru.jasintar.textconverter.configs;

import ru.jasintar.textconverter.models.MarkdownPattern;

import java.util.ArrayList;
import java.util.List;

import static ru.jasintar.textconverter.configs.PatternEnvironment.*;

/**
 * Created on 23.04.2020.
 *
 * @authot Julia Savicheva
 */
public class PatternConfig {

    private static List<MarkdownPattern> markdownPatterns;

    public static List<MarkdownPattern> getMarkdownPatterns() {
        if (markdownPatterns == null)
            markdownPatterns = buildPatternCollection();
        return markdownPatterns;
    }

    private static List<MarkdownPattern> buildPatternCollection() {
        List<MarkdownPattern> markdownPatterns = new ArrayList<>();
        markdownPatterns.add(MarkdownPattern.builder()
                .prevSymbol(ANY_SYMBOL_OR_NULL) //any
                .patternToReplace("__")
                .nextSymbol(ANY_LTTER_OR_NUMBER) // 1 любая буква русская или английская или цифра
                .replaceTo("<b>")
                .build());

        markdownPatterns.add(MarkdownPattern.builder()
                .prevSymbol(ANY_SYMBOL_OR_NULL) // any
                .patternToReplace("**")
                .nextSymbol(ANY_LTTER_OR_NUMBER) // 1 любая буква русская или английская или цифра
                .replaceTo("<b>")
                .build());

        markdownPatterns.add(MarkdownPattern.builder()
                .prevSymbol(ANY_SYMBOL_OR_NULL) //any
                .patternToReplace("__")
                .nextSymbol(ANY_LTTER_OR_NUMBER) // 1 любая буква русская или английская или цифра
                .replaceTo("<b>")
                .build());

        markdownPatterns.add(MarkdownPattern.builder()
                .prevSymbol(ANY_LTTER_OR_NUMBER_OR_MARK) // 1 любая буква русская или английская или цифра или конец предложения
                .patternToReplace("**")
                .nextSymbol(ANY_SYMBOL_OR_NULL) // any
                .replaceTo("</b>")
                .build());

        markdownPatterns.add(MarkdownPattern.builder()
                .prevSymbol(ANY_SYMBOL_OR_NULL) //any
                .patternToReplace("_")
                .nextSymbol(ANY_LTTER_OR_NUMBER) // 1 любая буква русская или английская или цифра
                .replaceTo("<i>")
                .build());

        markdownPatterns.add(MarkdownPattern.builder()
                .prevSymbol(ANY_LTTER_OR_NUMBER_OR_MARK) // 1 любая буква русская или английская или цифра или конец предложения
                .patternToReplace("_")
                .nextSymbol(ANY_SYMBOL_OR_NULL) // any
                .replaceTo("</i>")
                .build());

        markdownPatterns.add(MarkdownPattern.builder()
                .prevSymbol(ANY_SYMBOL_OR_NULL) //any
                .patternToReplace("*")
                .nextSymbol(ANY_LTTER_OR_NUMBER) // 1 любая буква русская или английская или цифра
                .replaceTo("<i>")
                .build());

        markdownPatterns.add(MarkdownPattern.builder()
                .prevSymbol(ANY_LTTER_OR_NUMBER_OR_MARK) // 1 любая буква русская или английская или цифра или конец предложения
                .patternToReplace("*")
                .nextSymbol(ANY_SYMBOL_OR_NULL) // any
                .replaceTo("</i>")
                .build());

        markdownPatterns.add(MarkdownPattern.builder()
                .prevSymbol(ANY_SYMBOL_OR_NULL)
                .patternToReplace("---")
                .nextSymbol(ANY_SYMBOL_OR_NULL)
                .replaceTo("<center>***</center>")
                .build());
        return markdownPatterns;
    }
}
