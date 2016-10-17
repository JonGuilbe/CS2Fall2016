/**
 * Created by Jonathan Guilbe on 9/6/2016.
 */
import java.util.*;
public class Pairings {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int femaleNum = stdin.nextInt();
        int maleNum = stdin.nextInt();
        int females[] = new int [femaleNum];
        int males[] = new int [maleNum];

        for (int i = 0; i < femaleNum; i++) {
            females[i] = stdin.nextInt();
        }

        for (int i = 0; i < maleNum; i++) {
            males[i] = stdin.nextInt();
        }

        Arrays.sort(males);

        for (int i = 0; i < females.length; i++) {
            System.out.println(binarySearch(males, females[i]));
        }

    }

    public static int binarySearch(int[] males, int searchFor){
        int low = 0;
        int mid = 0;
        int high = males.length - 1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(males[mid] == searchFor && !((mid+1 <= males.length-1 && males[mid+1] == searchFor))){
                return males.length - mid - 1;
            }

            if(searchFor < males[mid]){
                high = mid - 1;
            }
            else if(searchFor >= males[mid]){
                low = mid + 1;
            }
        }

        if(low == males.length - 1 && searchFor < males[males.length - 1])
            return 1;
        return males.length - mid - 1;
    }

}
