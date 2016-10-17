/**
 * Created by Jonathan Guilbe on 9/6/2016.
 */

import java.util.*;

public class Inversions {
    private static int[] numbers;
    private static int[] tempNumbers;
    static long sum = 0;

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int length = stdin.nextInt();
        numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = stdin.nextInt();
        }

        tempNumbers = new int[length];
        mergeSort(0, numbers.length-1);
        System.out.println(sum);
    }

    private static void mergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            mergeSort(lowerIndex, middle);
            mergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private static void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempNumbers[i] = numbers[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempNumbers[i] <= tempNumbers[j]) {
                numbers[k] = tempNumbers[i];
                i++;
            } else {
                numbers[k] = tempNumbers[j];
                sum += (middle + 1 - i);
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = tempNumbers[i];
            k++;
            i++;
        }

    }

}
