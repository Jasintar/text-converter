package ru.jasintar.textconverter.services.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 25.04.2020.
 *
 * @authot Julia Savicheva
 */
public class TagLibrary {
    public static Map<String, String> getPairedTags() {
        Map<String, String> pairedTags = new HashMap<>();
        // ключ - закрывающий тег
        // значение - открывающий тег
        pairedTags.put("</i>", "<i>");
        pairedTags.put("</b>", "<b>");
        return pairedTags;
    }
}
