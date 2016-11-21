/**
 * Created by Jonathan on 11/17/2016.
 */
import java.util.*;
public class Mars {
    static int[] directionX = {0,1,0,-1};
    static int[] directionY = {1,0,-1,0};
    static int solutions = 0;
    static int minDepth = 987654321;
    static int height, width;
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        height = stdin.nextInt();
        width = stdin.nextInt();
        String[] grid = new String[height];
        int startX = 0, startY = 0;
        for(int i = 0; i < height; i ++){
            grid[i] = stdin.next();
            for (int j = 0; j < width; j++) {
                if(grid[i].charAt(j) == 'R'){
                    startX = i;
                    startY = j;
                }
            }
        }
        boolean visited[][] = new boolean[height][width];
        dfs(grid, visited, startX, startY, 0);
        System.out.println(minDepth + " " + solutions);
    }

    public static void dfs(String[] grid, boolean[][] visited, int x, int y, int depth){
        if(grid[x].charAt(y) == 'G'){
            int bestDepth = Math.min(minDepth, depth);
            if(bestDepth != minDepth){
                minDepth = bestDepth;
                solutions = 1;
            }
            else if(depth == minDepth)
                solutions++;
            return;
        }
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int newX = x + directionX[i];
            int newY = y + directionY[i];
            if(isValidLocation(newX,newY) && !visited[newX][newY] && grid[newX].charAt(newY) != '#'){
                dfs(grid, visited, newX, newY, depth + 1); //need to check if it isn't a rock & that x and y are valid}
            }
        }
        visited[x][y] = false;
    }

    public static boolean isValidLocation(int x, int y){
        return!(x >= height || x  < 0 || y  >= width || y  < 0);
    }

}
