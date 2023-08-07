package sorting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class SelectionSort {

    public static void sort(int[] a) {
        final var length = a.length;
        int selected;
        for (int i = 0; i < length - 1; i++) {
            selected = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[selected]) {
                    selected = j;
                }
            }
            if (selected != i) {
                int temp = a[i];
                a[i] = a[selected];
                a[selected] = temp;
            }
        }
    }
}
