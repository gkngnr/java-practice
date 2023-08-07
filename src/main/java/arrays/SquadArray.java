package arrays;

import java.util.Arrays;

public class SquadArray {
    private final long[] teamArray;
    private int lastIndex;
    private final int INDEX_NOT_FOUND = -1;

    public SquadArray(int size) {
        this.teamArray = new long[size];
        lastIndex = -1;
    }

    public int insertItem(long key) {
        teamArray[++lastIndex] = key;
        return lastIndex;
    }

    public int searchKey(long key) {
        for (int i = 0; i <= lastIndex; i++) {
            if (teamArray[i] == key) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public long delete(long key) {
        int indexFound = searchKey(key);
        if (indexFound == INDEX_NOT_FOUND) {
            return INDEX_NOT_FOUND;
        }

        for (int i = indexFound; i < lastIndex ; i++) {
            teamArray[i] = teamArray[i + 1];
        }
        teamArray[lastIndex--] = 0L;

        return key;
    }

    public void display() {
        Arrays.stream(teamArray).asDoubleStream().forEach(i -> System.out.print(i + " "));
        System.out.println();
    }


}
