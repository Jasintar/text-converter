package ru.jasintar.textconverter.configs;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Created on 26.04.2020.
 *
 * @authot Julia Savicheva
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileConfig {
    List<String> sourceFiles;
    String resultFolder;


}
