package inheritance;

public interface Displayer1 {

    default void display() {
        System.out.println("Displayer1!");
    }

}
