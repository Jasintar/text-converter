package ru.jasintar.textconverter;

import lombok.extern.slf4j.Slf4j;
import ru.jasintar.textconverter.models.Pattern;

import java.util.List;

import static ru.jasintar.textconverter.configs.PatternConfig.buildPatternCollection;


/**
 * Created on 20.03.2020.
 *
 * @authot Julia Savicheva
 */
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("App starting...");

        List<Pattern> patterns = buildPatternCollection();

        log.info("Patterns: {}", patterns);
    }

}
