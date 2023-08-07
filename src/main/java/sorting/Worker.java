package sorting;


import java.util.Arrays;

public class Worker {
    public static void main(String[] args) {
        var arrayToBeSorted = new int[]{122, 45, 3, 15, 7, 90, 12, 10};
        display(arrayToBeSorted);
        InsertionSort.sort(arrayToBeSorted);
        display(arrayToBeSorted);
    }

    private static void display(int[] arr) {
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
        System.out.println();
    }
}
