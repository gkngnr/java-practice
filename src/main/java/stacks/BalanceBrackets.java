package stacks;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class BalanceBrackets {

    public static boolean isBalanced(String input) {
        final var bracketStack = new StackLinked<Character>();
        final var symbols = "{[(}])";

        for (char charItem : input.toCharArray()) {
            final var index = symbols.indexOf(charItem);
            if (index > 2) {
                if (bracketStack.isEmpty()) return false;
                if (bracketStack.peek() == symbols.charAt(index - 3)) {
                    bracketStack.pop();
                } else {
                    return false;
                }
            } else if (index > -1) {
                bracketStack.push(symbols.charAt(index));
            }
        }
        return bracketStack.isEmpty();
    }
}
