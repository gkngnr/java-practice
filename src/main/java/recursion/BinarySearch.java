package recursion;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class BinarySearch {

    private static int searchInner(int[] a, int l, int r, int x) {
        if (l > r) {
            return -1;
        }
        final int mid = (r + l) / 2;

        if (a[mid] == x) {
            return mid;
        }
        if (a[mid] > x) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
        return searchInner(a, l, r, x);
    }

    public static int search(int[] a, int x) {
        return searchInner(a, 0, a.length - 1, x);
    }
}
