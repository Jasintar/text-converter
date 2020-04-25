package ru.jasintar.textconverter.configs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 25.04.2020.
 *
 * @authot Julia Savicheva
 */
public class TagLibrary {

    private static Map<String, String> tagMapFinishToStart;

    public static Map<String, String> getPairedTags() {
        if (tagMapFinishToStart == null)
            tagMapFinishToStart = buildPairedTags();
        return tagMapFinishToStart;
    }

    private static Map<String, String> buildPairedTags() {
        Map<String, String> pairedTags = new HashMap<>();
        // ключ - закрывающий тег
        // значение - открывающий тег
        pairedTags.put("</i>", "<i>");
        pairedTags.put("</b>", "<b>");
        return pairedTags;
    }
}
