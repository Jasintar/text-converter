package ru.jasintar.textconverter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.jasintar.textconverter.models.Pattern;

import java.util.List;

import static ru.jasintar.textconverter.configs.PatternConfig.getPatterns;


/**
 * Created on 20.03.2020.
 *
 * @authot Julia Savicheva
 */
@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        log.info("App starting...");

        List<Pattern> patterns = getPatterns();

        log.info("Patterns: {}", patterns);
    }

}
