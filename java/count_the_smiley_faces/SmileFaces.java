// https://www.codewars.com/kata/583203e6eb35d7980400002a
// written for java8

import java.util.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmileFaces {

    public static int countSmileys(List<String> arr) {
        int matches = 0;
        for(String s : arr){
            if(s.matches("[:;][-~]?[)D]"))
                matches++;
        }
        return matches;
    }
}
