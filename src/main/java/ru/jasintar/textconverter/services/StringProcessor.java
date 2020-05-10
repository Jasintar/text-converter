package ru.jasintar.textconverter.services;

import lombok.extern.slf4j.Slf4j;
import ru.jasintar.textconverter.models.MarkdownPattern;
import ru.jasintar.textconverter.models.ReplacebleElement;
import ru.jasintar.textconverter.services.utils.TagListValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.jasintar.textconverter.configs.PatternConfig.getMarkdownPatterns;

/**
 * Created on 23.04.2020.
 *
 * @author Julia Savicheva
 */
@Slf4j
public class StringProcessor {

    private List<MarkdownPattern> markdownPatterns = getMarkdownPatterns();

    public String process(String initialString) {
        log.info("Start process line: {}", initialString);
        List<ReplacebleElement> tagList = findTags(initialString); // Ищем теги, которые нужно заменить
        tagList = TagListValidator.validateTagList(tagList); // валидируем теги на парность
        return applyReplaceValidTags(initialString, tagList); // выполняем замены
    }

    private List<ReplacebleElement> findTags(String initialString) {
        List<ReplacebleElement> tagList = new ArrayList<>();
        List<String> replacablePatterns = this.markdownPatterns.stream()
                .map(MarkdownPattern::getPatternToReplace)
                .collect(Collectors.toList());

        StringBuilder sourceString = new StringBuilder(initialString);
        StringBuilder currentTag = new StringBuilder();
        int beginIndexOfTag = 0;
        char[] charArray = initialString.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            if (currentTag.length() == 0) { // если пустой буффер тега, то инициализируем начальный индекс текущим индексом
                beginIndexOfTag = i;
            }
            currentTag.append(charArray[i]); // добавляем символ
            boolean isExistPattern = replacablePatterns.stream()
                    .filter(rp -> rp.length() >= currentTag.length())
                    .anyMatch(rp -> rp.substring(0, currentTag.length()).contentEquals(currentTag));
            if (!isExistPattern) { // если нет паттерна
                if (currentTag.length() > 1) {
                    currentTag.deleteCharAt(currentTag.length() - 1); // то убираем последний символ и заносив в список тегов
                    // сверяем с полным паттерном, включая предыдущий и следующий символы
                    String prevSymbol = (beginIndexOfTag == 0) ? null : "" + "" + charArray[beginIndexOfTag - 1];
                    String nextSymbol = "" + charArray[i];
                    Optional<MarkdownPattern> findedPattern = markdownPatterns.stream()
                            .filter(p -> p.isApplicable(prevSymbol, currentTag.toString(), nextSymbol))
                            .findFirst();
                    if (findedPattern.isPresent()) { // если нашли, добавляем в список найденных тегов
                        tagList.add(ReplacebleElement.builder()
                                .beginIndex(beginIndexOfTag)
                                .replaceTo(findedPattern.get().getReplaceTo())
                                .length(findedPattern.get().getPatternToReplace().length())
                                .build());
                    }
                }
                currentTag.setLength(0); // обнуляем буффер текущего тега
            } else if (i == charArray.length - 1) { // паттерн найден, нужно сверяем с полным паттерном, включая предыдущий и следующий символы
                String prevSymbol = (beginIndexOfTag == 0) ? null : "" + "" + charArray[beginIndexOfTag - 1];
                String nextSymbol = null;
                Optional<MarkdownPattern> findedPattern = markdownPatterns.stream()
                        .filter(p -> p.isApplicable(prevSymbol, currentTag.toString(), nextSymbol))
                        .findFirst();
                if (findedPattern.isPresent()) { // если нашли, добавляем в список найденных тегов
                    tagList.add(ReplacebleElement.builder()
                            .beginIndex(beginIndexOfTag)
                            .replaceTo(findedPattern.get().getReplaceTo())
                            .length(findedPattern.get().getPatternToReplace().length())
                            .build());
                    currentTag.setLength(0); // обнуляем буффер текущего тега
                }
            }
            i++;
        }

        return tagList;
    }

    private String applyReplaceValidTags(String initialString, List<ReplacebleElement> tagList) {
        StringBuilder resultBuilder = new StringBuilder(initialString);
        tagList.stream()
                .filter(ReplacebleElement::isValid)
                .sorted(Comparator.comparingInt(ReplacebleElement::getBeginIndex).reversed()) // сортируем в обратном порядке, заменять можно только в обратном порядке, или все перепутается
                .forEach(tag -> resultBuilder.replace( // заменяем
                        tag.getBeginIndex(),
                        tag.getBeginIndex() + tag.getLength(),
                        tag.getReplaceTo()));

        return resultBuilder.toString();

    }

}
