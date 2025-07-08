import java.io.*;
import java.util.*;

public class MatchGroupingSymbols {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java MatchGroupingSymbols filename");
            return;
        }

        Stack<Character> stack = new Stack<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char c = (char) ch;
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    if (stack.isEmpty() || !matches(stack.pop(), c)) {
                        System.out.println("Grouping symbols do not match.");
                        return;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("All grouping symbols match.");
        } else {
            System.out.println("Grouping symbols do not match.");
        }
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
