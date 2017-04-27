package com.ownroom;

import java.util.List;

public abstract class Matcher {
    protected List<String> matches;
    protected String name;

    public String getName() {
        return name;
    }

    public List<String> getMatches() {
        return matches;
    }
    public abstract void setPatterns(List<String> patterns);

    public abstract List<String> match(List<String> text);
}
