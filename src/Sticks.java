import java.util.*;
//always break from the largest to smallest

public class Sticks{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int notches = stdin.nextInt();
        int stickLength = stdin.nextInt();
        int[] notchLocations = new int[notches];
        for (int i = 0; i < notches; i++) {
            notchLocations[i] = stdin.nextInt();
        }

        int currentLength = stickLength;
        int sum = 0;
        for (int i = notches-1; i >= 0; i--) {
            sum += notchLocations[i] * (currentLength-notchLocations[i]);
            currentLength = notchLocations[i];
        }
        System.out.println(sum);
    }
}
