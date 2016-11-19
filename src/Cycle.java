/**
 * Created by Jonathan on 11/17/2016.
 */
import java.util.*;
public class Cycle {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int verticies = stdin.nextInt();
        int edges = stdin.nextInt();
        boolean adjMatrix[][] = new boolean[verticies+1][verticies+1];
        for(int i = 0; i < edges; i++){
            int x = stdin.nextInt();
            int y = stdin.nextInt();
            adjMatrix[x][y] = true;
            adjMatrix[y][x] = true;
        }

    }
}
