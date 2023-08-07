package sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class BubbleSort {

    public static void sort(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length - 1; i++) {
            for (int j = i; j < arrayToSort.length - 1 - i; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
        }
    }

    public static void sortAlter(int[] arrayToSort) {
        int out, in;
        int nElems = arrayToSort.length;
        for(out = nElems-1; out > 1; out--) // outer loop (backward)
            for(in = 0; in < out; in++) // inner loop (forward)
                if( arrayToSort[in] > arrayToSort[in+1] ) { // out of order?
                    int temp = arrayToSort[in];
                    arrayToSort[in] = arrayToSort[in + 1];
                    arrayToSort[in + 1] = temp;
                }

    }

    public static void sortBubbleReverse(int[] a) {
        final int l = a.length;
        for (int i = l - 1; i > 0; i--) {
            for (int j = l - 1; j > l - i - 1; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

}
