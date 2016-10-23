/**
 * Created by reneg on 10/22/2016.
 */
import java.util.*;
public class SticksAnswer {
    static Integer memo[][];
    static int INF = Integer.MAX_VALUE;
    static int[] notchLocations;
    static int[] notchWidth;
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int notches = stdin.nextInt();
        int stickLength = stdin.nextInt();
        notchLocations = new int[notches];
        for (int i = 0; i < notches; i++) {
            notchLocations[i] = stdin.nextInt();
        }
        notchWidth = new int[notches];

        for (int i = 0; i < notches - 1; i++) {
            notchWidth[i] = notchLocations[i] - notchLocations[i-1];
        }
        memo = new Integer[notches][notches];
        System.out.println(calc(0,notches-1));
    }


    static int calc(int a, int b){
        if(memo[a][b] != null)
            return memo[a][b];
        if (a > b){
            memo[a][b] = INF;
            return memo[a][b];}
        if (a + 1 == b){
            memo[a][b] = 1;
            return memo[a][b];}
        if (a == b){
            memo[a][b] = 0;
            return memo[a][b];}

        int ans = INF;

        //Comparing the current optimal solution with a new solution
        for (int i = a + 1; i < b; i++){
            ans = Math.min(ans, calc(a, i) + calc(i, b));
        }
        memo[a][b] = (ans == INF ? INF : ans + (notchLocations[b] * notchLocations[a]));
        return memo[a][b];
    }
}
