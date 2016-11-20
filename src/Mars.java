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
        String[] grid = new String[height]; //this is NOT okay because we need to find the starting point...
        for(int i = 0; i < height; i ++){
            grid[i] = stdin.next();
        }
        boolean visited[][] = new boolean[height][width];
        dfs(grid, visited, 0, 3, 0);
        System.out.println(minDepth + " " + solutions);
    }

    public static void dfs(String[] grid, boolean[][] visited, int x, int y, int depth){
        if(grid[x].charAt(y) == 'G'){
            //System.out.println("Solution found with depth " + depth + "!");
            solutions++;
            minDepth = Math.min(minDepth, depth);
            return;
        }
        visited[x][y] = true;
        //printVisited(visited);
        for(int i = 0; i < 4; i++){
            int newX = x + directionX[i];
            int newY = y + directionY[i];
            if(isValidLocation(newX,newY) && !visited[newX][newY] && grid[newX].charAt(newY) != '#'){
                dfs(grid, visited, newX, newY, depth + 1); //need to check if it isn't a rock & that x and y are valid}
            }
        }
        visited[x][y] = false;
    }

    /*public int bfs(String[] grid, int width, boolean[][] visited, int x, int y){ //finds the shortest path
        return 1;
    } */

    public static boolean isValidLocation(int x, int y){
        return!(x >= height || x  < 0 || y  >= width || y  < 0);
    }

    public static void printVisited(boolean visited[][]){
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if(visited[i][j])
                    System.out.print('X');
                else
                    System.out.print('.');
            }
            System.out.println();
        }
        System.out.println();
    }
}
