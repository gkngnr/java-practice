package generics;

public class Tester {
    public static void main(String[] args) {
        Gen<Number> g1 = new Gen<>();
        g1.val = 12;

        Gen<String> g2 = new Gen<>();
        g2.val = "test";

        print(g1, g2);

    }

    static void print(Gen<? extends Number> gen1, Gen<?> gen2) {
        System.out.println(gen1.val);
        System.out.println(gen2.val);
    }
}
