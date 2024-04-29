import java.util.*;
public class Sorting {
    Scanner scanner = new Scanner(System.in);
    public int[] getArray(){
        System.out.println("Enter 5 Numbers");
        int[] array = new int[5];
        for(int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public int[] sortArray(int array[]) {
        int n = array.length;

        for(int i = 0; i < n-1; i++){
            int min_idx = i;
            for(int j = i + 1; j < n; j++){
                if(array[j] < array[min_idx]){
                    min_idx = j;
                }
            }

            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }

        return array;
    }


}
