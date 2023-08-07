package sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class InsertionSort {

    public static void sort(int[] a) {
        final int l = a.length;
        for (int i = 1; i < l; i++) {
            int temp = a[i];
            int j;
            for (j = i; j > 0; j--) {
                if (a[j - 1] > temp) {
                    a[j] = a[j - 1];
                } else {
                    break;
                }
            }
            a[j] = temp;
        }

    }
}
