package ru.jasintar.textconverter.services;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * Created on 20.03.2020.
 *
 * @authot Julia Savicheva
 */
@Slf4j
public class TextProcessor {
    private String sourceFileName;
    private String resultFileName;

    private StringProcessor stringProcessor;

    public TextProcessor(String sourceFileName, String resultFileName) {
        this.sourceFileName = sourceFileName;
        this.resultFileName = resultFileName;
        this.stringProcessor = new StringProcessor();
    }

    public void process() {
        log.info("Start process file: {}", sourceFileName);
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(sourceFileName))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFileName))) {
                // читаем построчно
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String resultLine = stringProcessor.process(currentLine);
                    bufferedWriter.write(resultLine);
                    bufferedWriter.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(); //TODO логи ошибок
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
