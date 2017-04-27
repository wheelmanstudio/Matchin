package com.ownroom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.exit;

public class App 
{
    static final String patternsPath = "data/patterns.txt";
    static final String textPath = "data/text.txt";
    public static void main( String[] args )
    {
        List<Matcher> matchers = new ArrayList<>();
        matchers.add(new StrictMatcher("Matcher 1 (entire line match)"));
        matchers.add(new FreeMatcher("Matcher 2 (any part match)"));
        matchers.add(new DistanceMatcher("Matcher 3 (distance <= 1)"));

        try(Stream<String> patternsStream = Files.lines(Paths.get(patternsPath))) {
            List<String> patterns = patternsStream.collect(Collectors.toList());
            matchers.forEach((matcher) -> matcher.setPatterns(patterns));
        } catch (IOException ex) {
            System.out.println( "File " + patternsPath + " is not found" );
            exit(1);
        }

        try(Stream<String> textStream = Files.lines(Paths.get(textPath))) {
            List<String> text = textStream.collect(Collectors.toList());
            matchers.parallelStream().forEach((matcher) -> {
                matcher.match(text);
            });
        } catch (IOException ex) {
            System.out.println( "File " + textPath + " is not found" );
            exit(1);
        }

        matchers.forEach((matcher) -> {
            System.out.println("// " + matcher.getName());
            System.out.println(matcher.getMatches());
            System.out.println();
        });


    }
}
