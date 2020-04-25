package ru.jasintar.textconverter.services.utils;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Created on 25.04.2020.
 *
 * @authot Julia Savicheva
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tag {
    String startTag;
    String endTag;
}
