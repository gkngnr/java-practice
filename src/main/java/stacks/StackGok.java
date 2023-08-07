package stacks;

public class StackGok {
    private final int maxSize;
    private int[] a;
    private int top;

    public StackGok(int maxSize) {
        this.maxSize = maxSize;
        a = new int[maxSize];
        top = -1;
    }

    public void push(int itemBeingPushed) {
        a[++top] = itemBeingPushed;
    }

    public int pop() {
        return a[top--];
    }

    public int peek() {
        return a[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }


}
