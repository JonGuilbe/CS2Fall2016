import java.util.Scanner;

/**
 * Created by reneg on 10/22/2016.
 */
public class NeoNewSticks {
    static Long memo[][];
    static int[] notchLocations;

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int notches = stdin.nextInt();
        int stickLength = stdin.nextInt();
        notchLocations = new int[notches + 2];
        notchLocations[0] = 0;
        for (int i = 1; i <= notches; i++) {
            notchLocations[i] = stdin.nextInt();
        }
        notchLocations[notches+1] = stickLength;
        memo = new Long[stickLength + 1][stickLength + 1];
        int currentLength = stickLength;
        boolean broken[] = new boolean[notchLocations.length];

        System.out.println(answer(0, stickLength, 1));
    }

    public static long answer(int i, int j,int k) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i == j || i + 1 == j)
            return 0;
        if(notchLocations[k] >= j){
            System.out.println("It worked!");
            return 0;}

        long bestCost = Integer.MAX_VALUE;

        for (int index = k; index < notchLocations.length-1; index++) {
            System.out.println("index is " + index + " k is " + k);
            if (notchLocations[index] < i || notchLocations[index] > j)
                break;

            int A = notchLocations[index] - i;
            int B = j - notchLocations[index];
            long currentCost;

                System.out.println("A is " + A + " B is " + B);
                System.out.println("Calling rec("+i+","+notchLocations[index]+") + ("+notchLocations[index]+","+j+")");
            if(A <= 0 || B <= 0){
                System.out.println("We shouldn't be here...");
                break;}

                currentCost = (A * B) + answer(i, notchLocations[index], k) + answer(notchLocations[index], j, k+1);
                System.out.println("Current cost is " + currentCost);
                bestCost = Math.min(bestCost, currentCost);
        }

            memo[i][j] = bestCost;
            return bestCost;
        }

}
