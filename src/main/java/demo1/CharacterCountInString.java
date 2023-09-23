package demo1;

public class CharacterCountInString {

    /**
     * Returns the characters with its consecutive appearance count
     * Ex: AAA      -> A3
     *     AABBCCZ  -> A2B2C2Z1
     */
    public static String characterCountString(String input) {
        if (input == null || input.isEmpty()) return input;

        StringBuilder sb = new StringBuilder();
        char control = input.charAt(0);
        int counter = 1;

        for (int i = 1; i < input.length(); i++) {
            final var cursorItem = input.charAt(i);
            if (control == cursorItem) {
                counter++;
            } else {
                sb.append(control).append(counter);
                control = cursorItem;
                counter = 1;
            }
        }
        sb.append(control).append(counter);


        return sb.toString();
    }

}
