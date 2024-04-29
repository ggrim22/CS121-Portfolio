import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sorting sort = new Sorting();

        int[] array = sort.getArray();
        System.out.printf("Unsorted Array: " + Arrays.toString(array));
        int[] sortedArray = sort.sortArray(array);
        System.out.printf("\nSorted Array: " + Arrays.toString(sortedArray));


    }
}
