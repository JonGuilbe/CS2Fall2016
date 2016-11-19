/**
 * Created by reneg on 9/6/2016.
 */
import java.util.*;
public class Escape {
    public static void main(String[] args){

        //Extra 1 because we start at 1, not 0
        int space[] = new int[1000001];
        //long bunnySum[] = new long[1000001];
        //long distanceSum[] = new long[1000001];

        Scanner stdin = new Scanner(System.in);
        int bunnyNum = stdin.nextInt();
        int simulations = stdin.nextInt();

        int bunnyLoc = 0;
        for (int i = 0; i < bunnyNum; i++) {
            bunnyLoc = stdin.nextInt();
            space[bunnyLoc]++;
        }

        /*
        for (int i = 1; i < 1000001; i++) {
            bunnySum[i] = bunnySum[i-1] + space[i];
            distanceSum[i] = distanceSum[i-1] + bunnySum[i-1];
        }*/

        for (int i = 0; i < simulations; i++) {

            //int spaceCopy[] = space.clone();
            int rainStart = stdin.nextInt();
            int rainStop = stdin.nextInt();
            //long totalMove = ((distanceSum[rainStop] - distanceSum[rainStart]) - ((bunnySum[rainStop] - bunnySum[rainStart]) * (rainStart-1)));
            long totalMove = 0;
            int bunnyCount = 0;
            if(rainStart == rainStop){
                totalMove = space[rainStart];
            }
            for (int j = rainStart; j < rainStop; j++) {
                bunnyCount += space[j];
                totalMove += bunnyCount;
            }
            System.out.println(totalMove);
        }


    }
}
