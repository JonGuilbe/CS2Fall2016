/**
 * Created by Jonathan on 11/17/2016.
 */
import java.util.*;
public class Mars {
    int[] directionX = {0,1,0,-1};
    int[] directionY = {1,0,-1,0};
    int solutions = 0;
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int height = stdin.nextInt();
        int width = stdin.nextInt();
        String[] grid = new String[height];
        for(int i = 0; i < height; i ++){
            grid[i] = stdin.next();
        }
        boolean visited[][] = new boolean[height][width];
    }

    public void dfs(String[] grid, int width, boolean[][] visited, int x, int y){
        if(grid[x].charAt(y) == 'G'){
            solutions++;
            return;
        }
        if(visited[x][y])
            return; //NOT OKAY
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            dfs(grid, width, visited, x + directionX[i], y + directionY[i]); //need to check if it isn't a rock & that x and y are valid
        }
    }

    public int bfs(String[] grid, int width, boolean[][] visited, int x, int y){ //finds the shortest path
        return 1;
    }
}
