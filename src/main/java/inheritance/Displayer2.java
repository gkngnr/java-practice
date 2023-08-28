package inheritance;

public interface Displayer2 {

    default void display() {
        System.out.println("Displayer2!");
    }

}
