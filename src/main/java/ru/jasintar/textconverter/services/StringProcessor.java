package ru.jasintar.textconverter.services;

import ru.jasintar.textconverter.models.Pattern;
import ru.jasintar.textconverter.models.ReplacebleElement;

import java.util.List;

import static ru.jasintar.textconverter.configs.PatternConfig.getPatterns;

/**
 * Created on 23.04.2020.
 *
 * @authot Julia Savicheva
 */
public class StringProcessor {

    private List<Pattern> patterns = getPatterns();

    // список найденных тегов
    private List<ReplacebleElement> tagList;

//    public static void main(String[] args) {
//        List<ReplacebleElement> tagList;
//
//        Map<String, String> pairedTags = getPairedTags();
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
//        System.out.println(TagListValidator.validateTagList(tagList));
//    }

    public String process(String initialString) {
        String resultString;

        return initialString;
    }

}
