package ru.jasintar.textconverter.models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.regex.Pattern;

/**
 * Created on 20.03.2020.
 *
 * @authot Julia Savicheva
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MarkdownPattern {
//    public static enum
    String prevSymbol; // null or regExp
    String patternToReplace;
    String nextSymbol; // null or regExp
    String replaceTo;

    public boolean isApplicable(String _prevSymbol, String _patternToReplace, String _nextSymbol) {
        if (_patternToReplace == null)
            return false;
        if ((_prevSymbol == null && this.prevSymbol != null) || (_nextSymbol == null && this.nextSymbol != null))
            return false;
        return (this.prevSymbol == null || Pattern.matches(this.prevSymbol, _prevSymbol)) &&
                (this.patternToReplace.equals(_patternToReplace)) &&
                (this.nextSymbol == null || Pattern.matches(this.nextSymbol, _nextSymbol));
    }

}
