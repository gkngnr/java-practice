package inheritance;

public class ConcreteDisplayer implements Displayer1, Displayer2 {
    @Override
    public void display() {
        Displayer1.super.display();
        Displayer2.super.display();
    }
}
