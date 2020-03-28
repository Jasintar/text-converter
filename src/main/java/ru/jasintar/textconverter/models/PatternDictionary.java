package ru.jasintar.textconverter.models;

import java.util.List;

/**
 * Created on 20.03.2020.
 *
 * @authot Julia Savicheva
 */
public class PatternDictionary {
    private List<Pattern> patterns;
    private String patternSymbols;

    public PatternDictionary(List<Pattern> patterns) {
        this.patterns = patterns;
        patternSymbols = this.patterns.stream()
                .map(Pattern::getPatternToReplace)
                .reduce("", (s1, s2) -> s1 + s2);
    }

    public boolean isSymbolInPatternString(String c) {
        return patternSymbols.contains(c);
    }
}
