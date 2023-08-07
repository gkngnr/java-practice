package arrays;

import java.util.Arrays;

public class SortedSquadArray {

    private final long[] teamArray;
    private int lastIndex;

    public SortedSquadArray(int size) {
        this.teamArray = new long[size];
        lastIndex = -1;
    }

    public int find(long searchKey) {
        int low = 0, high = lastIndex;
        int current;
        while (true) {
            current = (low + high) / 2;
            if (searchKey == teamArray[current]) {
                return current;
            }
            if (low > high)
                return lastIndex + 1;

            if (searchKey > teamArray[current]) {
                low = current + 1;
            } else {
                high = current - 1;
            }
        }
    }

    public void insert(long value) {
        int index;
        for (index = 0; index <= lastIndex; index++) {
            if (value < teamArray[index])
                break;

        }
        for (int k = lastIndex; k >= index; k--) {
            teamArray[k + 1] = teamArray[k];
        }
        teamArray[index] = value;
        lastIndex++;
    }

    public boolean delete(long value) {
        int indexFound = find(value);
        if (indexFound > lastIndex)
            return false;
        int i;
        for (i = indexFound; i < lastIndex; i++) {
            teamArray[i] = teamArray[i + 1];
        }
        teamArray[i] = 0;
        lastIndex--;
        return true;
    }

    public void display() {
        for (int i = 0; i <= lastIndex; i ++)
            System.out.print(teamArray[i] + " ");
        System.out.println();
    }


}
