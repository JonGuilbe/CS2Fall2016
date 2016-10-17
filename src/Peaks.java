import java.util.*;

/**
 * Created by reneg on 9/6/2016.
 */
public class Peaks {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int length = stdin.nextInt();
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = stdin.nextInt();
        }

        System.out.println(countPeaks(numbers));

    }


    public static long countPeaks(int[] perm)
    {
        long numTriplets = 0;

        FenwickTree prefixTree = new FenwickTree(perm.length+1);
        FenwickTree suffixTree = new FenwickTree(perm.length+1);

        for (int p : perm)
        {
            suffixTree.addValue(p, 1);
            numTriplets += prefixTree.prefixSum(p-1) * suffixTree.rangeSum(p+1, perm.length);
            prefixTree.addValue(p, 1);
        }

        return numTriplets;
    }

    public static class FenwickTree
    {
        int size;
        long[] tree;

        public FenwickTree(int size)
        {
            this.size = size;
            tree = new long[size];
        }


        public void addValue(int index, long amount)
        {
            while (index < size)
            {
                tree[index] += amount;
                index += Integer.lowestOneBit(index);
            }
        }

        public long prefixSum(int index)
        {
            long prefixSumResult = 0;
            while (index > 0)
            {
                prefixSumResult += tree[index];
                index -= Integer.lowestOneBit(index);
            }

            return prefixSumResult;
        }

        public long rangeSum(int lowIndex, int highIndex)
        {
            return prefixSum(highIndex) - prefixSum(lowIndex-1);
        }
    }

}
