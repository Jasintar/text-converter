package ru.jasintar.textconverter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.jasintar.textconverter.configs.FileConfig;
import ru.jasintar.textconverter.models.MarkdownPattern;
import ru.jasintar.textconverter.services.TextProcessor;

import java.util.List;

import static ru.jasintar.textconverter.configs.PatternConfig.getMarkdownPatterns;


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

        log.info("Source files: {}, result file path: {}", FileConfig.sourceFiles, FileConfig.resultFolder);
        List<MarkdownPattern> markdownPatterns = getMarkdownPatterns();
        FileConfig.sourceFiles.stream().forEach(file -> {
            String[] split;
            split = file.split("\\\\");
            String shortFilename = split[split.length - 1];
            TextProcessor textProcessor = new TextProcessor(file, FileConfig.resultFolder + shortFilename);
            textProcessor.process();
        });

        log.info("Patterns: {}", markdownPatterns);
    }

}
