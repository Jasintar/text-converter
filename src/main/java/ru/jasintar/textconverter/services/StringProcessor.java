package ru.jasintar.textconverter.services;

import ru.jasintar.textconverter.models.Pattern;
import ru.jasintar.textconverter.models.ReplacebleElement;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import static ru.jasintar.textconverter.configs.PatternConfig.buildPatternCollection;
import static ru.jasintar.textconverter.services.utils.TagLibrary.getPairedTags;

/**
 * Created on 23.04.2020.
 *
 * @authot Julia Savicheva
 */
public class StringProcessor {

    private List<Pattern> patterns = buildPatternCollection();

    // stack из открытых тегов
    private List<ReplacebleElement> tagList;

//    public static void main(String[] args) {
//        List<ReplacebleElement> tagList;
//
//        Map<String, String> pairedTags = getPairedTags();
//        Collection<String> startTags = pairedTags.values();
//        Collection<String> endTags = pairedTags.keySet();
//        tagList = new ArrayList<>();
//        tagList.add(ReplacebleElement.builder()
//                .beginIndex(0)
//                .length(1)
//                .replaceTo("<i>")
//                .build());
//        tagList.add(ReplacebleElement.builder()
//                .beginIndex(5)
//                .length(1)
//                .replaceTo("<i>")
//                .build());
//        tagList.add(ReplacebleElement.builder()
//                .beginIndex(8)
//                .length(1)
//                .replaceTo("</i>")
//                .build());
//
//        Map<Integer, ReplacebleElement> map = tagList.stream()
//                .collect(Collectors.toMap(ReplacebleElement::getBeginIndex, e -> e, (e1, e2) -> e1));
//
//        // кдюч - стартовый тег, значение - стэк из ReplacebleElement
//        Map<String, Stack<ReplacebleElement>> tagStack = pairedTags.values()
//                .stream()
//                .collect(Collectors.toMap(startTag -> startTag, startTag -> new Stack<>(), (e1, e2) -> e1));
//
//        // когда встречаем закрывающий тег - достаем из стека последний открывающий тег
//        tagList.forEach(element -> {
//            if (startTags.contains(element.getReplaceTo())) { // Встретили открывающий тег
//                tagStack.get(element.getReplaceTo()).push(element);
//            } else if (endTags.contains(element.getReplaceTo())) { // Встретили закрывающий тег
//                Stack<ReplacebleElement> stack = tagStack.get(pairedTags.get(element.getReplaceTo()));
//                if (!stack.isEmpty()) {
//                    ReplacebleElement startElement = stack.pop();
//                    startElement.setValid(true);
//                    element.setValid(true);
//                }
//            } else { // Встретили не парный тег
//                element.setValid(true);
//            }
//        });
//        System.out.println(tagList);
//    }

    private void validateTagList() {
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
    }


}
