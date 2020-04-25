package ru.jasintar.textconverter.services;

import java.io.*;

/**
 * Created on 20.03.2020.
 *
 * @authot Julia Savicheva
 */
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
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(sourceFileName))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFileName))) {

                // читаем построчно
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    System.out.print(currentLine);
                    String resultLine = stringProcessor.process(currentLine);
                    bufferedWriter.write(resultLine);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
