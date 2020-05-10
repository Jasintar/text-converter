package ru.jasintar.textconverter.models;

import java.util.List;

/**
 * Created on 20.03.2020.
 *
 * @authot Julia Savicheva
 */
public class PatternDictionary {
    private List<MarkdownPattern> markdownPatterns;
    private String patternSymbols;

    public PatternDictionary(List<MarkdownPattern> markdownPatterns) {
        this.markdownPatterns = markdownPatterns;
        patternSymbols = this.markdownPatterns.stream()
                .map(MarkdownPattern::getPatternToReplace)
                .reduce("", (s1, s2) -> s1 + s2);
    }

    public boolean isSymbolInPatternString(String c) {
        return patternSymbols.contains(c);
    }
}
