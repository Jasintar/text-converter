package ru.jasintar.textconverter.models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Created on 20.03.2020.
 *
 * @authot Julia Savicheva
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pattern {
//    public static enum
    String prevSymbol; // null or regExp
    String patternToReplace;
    String nextSymbol; // null or regExp
    String replaceTo;

}
