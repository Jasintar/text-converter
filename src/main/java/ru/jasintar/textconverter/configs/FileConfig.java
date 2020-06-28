package ru.jasintar.textconverter.configs;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 26.04.2020.
 *
 * @authot Julia Savicheva
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileConfig {
    public static final List<String> sourceFiles = configureSourceFiles();
    public static final String resultFolder = configureResultFolder();

    private static List<String> configureSourceFiles() {
        List<String> sources = new ArrayList<>();
        sources.add("C:\\Chiaroscuro\\chapter 001\\Пролог.md");
        return sources;
    }

    private static String configureResultFolder() {
        return "C:\\Chiaroscuro\\approved\\";
    }

}
