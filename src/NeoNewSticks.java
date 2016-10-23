import java.util.Scanner;

/**
 * Created by reneg on 10/22/2016.
 */
public class NeoNewSticks {
    static Integer memo[][];
    static int[] notchLocations;
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int notches = stdin.nextInt();
        int stickLength = stdin.nextInt();
        notchLocations = new int[notches+1];
        for (int i = 0; i < notches; i++) {
            notchLocations[i] = stdin.nextInt();
        }
        memo = new Integer[stickLength+1][stickLength+1];
        int currentLength = stickLength;
        boolean broken[] = new boolean[notchLocations.length];

        System.out.println(answer(0, stickLength, broken));
    }

    static int answer(int i, int j, boolean[] broken){
        if(i==j)
            return 0;
        if(i<0 || j < 0)
            return 0;
        if(memo[i][j] != null){
            return memo[i][j];
        }

        int bestCost = Integer.MAX_VALUE;


        for(int k=0; k<notchLocations.length; k++){
            if(!broken[k]){
                int A = notchLocations[k] - i;
                int B = j - notchLocations[k];
                if(A < 0 || B < 0)
                    break;
                broken[k] = true;
                System.out.println("A is " + A + " B is " + B);
                int currentCost = A * B + answer(A,notchLocations[k], broken) + answer(notchLocations[k], B, broken);
                //broken[k] = false;
                bestCost = Math.min(bestCost, currentCost);
            }
        }
        memo[i][j] = bestCost;
        return bestCost;
    }
}
