// https://www.codewars.com/kata/54b80308488cb6cd31000161
// written for java8

import java.util.Stack;

public class Groups{

    public static boolean groupCheck(String s){
        System.out.println(s);
        Stack<Character> items = new Stack<>();
        for(Character c : s.toCharArray()){
            if(isClosingBracket(c)){
                if(items.isEmpty()) return false;
                if(items.pop() != getMatch(c)) return false;
            } else {
                items.push(c);
            }
        }
        return items.isEmpty();
    }

    private static Character getMatch(Character c){
        switch(c){
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return '_';
        }
    }

    private static boolean isClosingBracket(Character c){
        return c == ')' || c == '}' || c == ']';
    }
}
