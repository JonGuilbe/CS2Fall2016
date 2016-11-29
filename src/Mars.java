/**
 * Created by Jonathan on 11/17/2016.
 */
import java.util.*;
public class Mars {
    static int[] directionX = {0,1,0,-1};
    static int[] directionY = {1,0,-1,0};
    static int[][] distance;
    static int solutions = 0;
    static int minDepth = 987654321;
    static int height, width;
    static int INF = 999999999;
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        height = stdin.nextInt();
        width = stdin.nextInt();
        distance  = new int[height][width];
        String[] grid = new String[height];
        int startX = 0, startY = 0, endX = 0, endY = 0;
        for(int i = 0; i < height; i ++){
            grid[i] = stdin.next();
            for (int j = 0; j < width; j++) {
              if(grid[i].charAt(j) == 'G'){
                endX = i;
                endY = j;
              }
              if(grid[i].charAt(j) == 'R'){
                    startX = i;
                    startY = j;
                    distance[i][j] = 0;
                }
                else
                  distance[i][j] = INF;
            }
        }
        boolean visited[][] = new boolean[height][width];
        crappybfs(grid, startX, startY, visited);
        solutions = neoDFS(grid, startX, startY);
        //dfs(grid, visited, startX, startY, 0);
        //System.out.println(minDepth + " " + solutions);
      for(int i = 0; i < height; i++){
        System.out.println(Arrays.toString(distance[i]));
      }
      System.out.printf("%d %d", distance[endX][endY], solutions);
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
  
  public static int neoDFS(String[] grid, int x, int y){
    if(grid[x].charAt(y) == 'G'){
      return 1;
    }
    int sum = 0;
    for(int i = 0; i < 4; i++){
      int newX = x + directionX[i];
      int newY = y + directionY[i];
      if(isValidLocation(newX, newY) && grid[newX].charAt(newY) != '#' && distance[x][y] < distance[newX][newY]){
        sum += neoDFS(grid, newX, newY);
      }
    }
    return sum;
  }
  
  public static void crappybfs(String[] grid, int startX, int startY, boolean[][] visited){
    Queue<int[]> q = new LinkedList<int[]>();
    int[] start = {startX, startY};
    q.add(start);
    visited[startX][startY] = true;
    while(q.peek() != null){
      int[] current = q.poll();
      int currentX = current[0];
      int currentY = current[1];
          for(int i = 0; i < 4; i++){
            int newX = currentX + directionX[i];
            int newY = currentY + directionY[i];
             if(isValidLocation(newX,newY) && grid[newX].charAt(newY) != '#' && !visited[newX][newY]){
               //System.out.printf("Current distance is %d new distance is %d", distance[currentX][currentY] + 1, distance[newX][newY]);
               if(distance[currentX][currentY] + 1 < distance[newX][newY]){
                  //System.out.println("Something wrong with distances!");
                  distance[newX][newY] = distance[currentX][currentY] + 1;}
                int[] next = {newX, newY};
                visited[newX][newY] = true;
                q.add(next);
            }
      }
    } 
    
  }
  

}
