package com.ownroom;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.getLevenshteinDistance;

public class DistanceMatcher extends Matcher {
    private List<String> patterns;

    public DistanceMatcher(String name) {
        this.name = name;
    }

    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }

    public List<String> match(List<String> text) {
        matches = text.stream().filter((textLine) -> patterns.stream()
                                    .anyMatch((pattern) -> getLevenshteinDistance(textLine,pattern) <= 1 ))
                                    .collect(Collectors.toList());
        return matches;
    }
}
