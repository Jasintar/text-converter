package ru.jasintar.textconverter.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Created on 20.03.2020.
 *
 * @authot Julia Savicheva
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pattern {
    String prevSymbol;
    String patternToReplace;
    String nextSymbol;
    String raplaceTo;

}
