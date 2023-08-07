package demo1;

public class NewSwitchStatement {

    private NewSwitchStatement() {}

    public static String getQuarterName(Integer monthNumber) {
        return switch (monthNumber) {
            case 1, 2, 3 -> "Q1";
            case 4, 5, 6 -> "Q2";
            case 7, 8, 9 -> "Q3";
            case 10, 11, 12 -> {
                System.out.println("yeey last quarter");
                yield "Q4";
            }
            default -> "Wrong month no passed";
        };

    }
}
