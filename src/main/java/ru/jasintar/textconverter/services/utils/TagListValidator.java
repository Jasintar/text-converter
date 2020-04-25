package ru.jasintar.textconverter.services.utils;

import ru.jasintar.textconverter.models.ReplacebleElement;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import static ru.jasintar.textconverter.configs.TagLibrary.getPairedTags;

/**
 * Created on 25.04.2020.
 *
 * @authot Julia Savicheva
 */
public class TagListValidator {

    public static List<ReplacebleElement> validateTagList(List<ReplacebleElement> tagList) {
        Map<String, String> pairedTags = getPairedTags();
        Collection<String> startTags = pairedTags.values();
        Collection<String> endTags = pairedTags.keySet();

        Map<Integer, ReplacebleElement> map = tagList.stream()
                .collect(Collectors.toMap(ReplacebleElement::getBeginIndex, e -> e, (e1, e2) -> e1));

        // кдюч - стартовый тег, значение - стэк из ReplacebleElement
        Map<String, Stack<ReplacebleElement>> tagStack = pairedTags.values()
                .stream()
                .collect(Collectors.toMap(startTag -> startTag, startTag -> new Stack<>(), (e1, e2) -> e1));

        // когда встречаем закрывающий тег - достаем из стека последний открывающий тег
        tagList.forEach(element -> {
            if (startTags.contains(element.getReplaceTo())) { // Встретили открывающий тег
                tagStack.get(element.getReplaceTo()).push(element);
            } else if (endTags.contains(element.getReplaceTo())) { // Встретили закрывающий тег
                Stack<ReplacebleElement> stack = tagStack.get(pairedTags.get(element.getReplaceTo()));
                if (!stack.isEmpty()) {
                    ReplacebleElement startElement = stack.pop();
                    startElement.setValid(true);
                    element.setValid(true);
                }
            } else { // Встретили не парный тег
                element.setValid(true);
            }
        });

        return tagList.stream()
                .filter(ReplacebleElement::isValid)
                .collect(Collectors.toList());
    }

}
