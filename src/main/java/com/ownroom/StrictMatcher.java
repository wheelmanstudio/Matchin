package com.ownroom;

import java.util.List;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

public class StrictMatcher extends Matcher {
    private String pattern = "";

    public StrictMatcher(String name) {
        this.name = name;
    }

    public void setPatterns(List<String> patterns) {
        patterns.forEach((pattern) -> this.pattern+="(^\\Q"+pattern+"\\E$)|");
        pattern = pattern.substring(0,pattern.length()-1);
    }

    public List<String> match(List<String> text) {
        Pattern pattern = Pattern.compile(this.pattern, Pattern.MULTILINE);
        matches = text.stream()
                .filter((textLine) -> pattern.matcher(textLine).find())
                .collect(Collectors.toList());
        return matches;
    }
}
