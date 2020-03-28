package ru.jasintar.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created on 20.03.2020.
 *
 * @authot Julia Savicheva
 */
public class TextProcessor {
    private String sourceFileName;
    private String resultFile;

    public TextProcessor(String sourceFileName, String resultFile) {
        this.sourceFileName = sourceFileName;
        this.resultFile = resultFile;
    }

    public void process() {
        try(FileReader reader = new FileReader(sourceFileName)) {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
