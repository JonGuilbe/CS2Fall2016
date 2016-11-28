/**
 * Created by reneg on 11/20/2016.
 */
import java.util.*;
public class Mining {
    static int[] directionX = {1,0,-1};
    static int[] directionY = {0,1,-0};
    static int rows;
    static int columns;
    static int bestSum = 0;
    static Integer[][] memo;

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        rows = stdin.nextInt();
        columns = stdin.nextInt();
        String[] grid = new String[rows];
        memo = new Integer[rows][columns];
        for (int i = 0; i < rows; i++) {
            grid[i] = stdin.next();
        }
        for(int i = 0; i < columns; i++){
            approach2(grid, 0, i);
        }
        System.out.println(bestSum);
    }

    public static int approach2(String[] grid, int row, int column){
        if(row >= rows || column >= columns)
            return 0;
        if(memo[row][column] != null){
            //System.out.println("Debug 1");
            return memo[row][column];}
        int sum = 0;
        if(!isValidLocation(row, column,grid))
            return sum;

        int leftCol = column, rightCol = column;
        while(isValidLocation(row, leftCol,grid)){
            //System.out.println("Debug 2");
            if(Character.isDigit(grid[row].charAt(leftCol))){
                //System.out.println("Adding from left " + Character.getNumericValue(grid[row].charAt(leftCol)));
                sum += Character.getNumericValue(grid[row].charAt(leftCol));}
            leftCol--;
        }
        if(isValidLocation(row, rightCol, grid)){

            while(isValidLocation(row, rightCol, grid)){
                //System.out.println("Debug 3");
                if(column != rightCol && Character.isDigit(grid[row].charAt(rightCol))){
                    //System.out.println("Adding from right " + Character.getNumericValue(grid[row].charAt(rightCol)));
                    sum += Character.getNumericValue(grid[row].charAt(rightCol));}
                rightCol++;
            }
        }
        int bestLocalSum = 0;
        //System.out.printf("Current sum: %d, going to check level %d left is %d right is %d\n", sum, row + 1, leftCol, rightCol);

        if(row + 1 < rows){
            for(int i = leftCol + 1; i < rightCol; i++){
                //System.out.printf("Current sum: %d, going to check level %d\n", sum, row + 1);
                bestLocalSum = Math.max(approach2(grid,row + 1, i), bestLocalSum);
            }
        }
        sum += bestLocalSum;
        //System.out.printf("Setting memo table for %d to %d!\n", leftCol, rightCol);
        for(int i = leftCol + 1; i < rightCol; i++){
            memo[row][i] = sum;
        }
        //System.out.println("Debug 5");
        bestSum = Math.max(bestSum, sum);
        return sum;
    }

    public static void dfs(String[] grid, boolean[][] visited, int x, int y, int total){
        if(Character.isDigit(grid[x].charAt(y))){
            //System.out.println("Adding " + Character.getNumericValue(grid[x].charAt(y)));
            total += Character.getNumericValue(grid[x].charAt(y));}
        if(x == rows - 1){
            //System.out.println("Solution found with depth " + depth + "!");
            bestSum = Math.max(bestSum, total);
            return;
        }
        visited[x][y] = true;
        for(int i = 0; i < 3; i++){
            int newX = x + directionX[i];
            int newY = y + directionY[i];
            if(isValidLocation(newX,newY, grid) && !visited[newX][newY] && grid[newX].charAt(newY) != '#'){
                dfs(grid, visited, newX, newY, total);
            }
        }
        visited[x][y] = false;
    }

    public static boolean isValidLocation(int x, int y, String[] grid){
        return!(x >= rows || x  < 0 || y  >= columns || y  < 0 || grid[x].charAt(y) == '#');
    }
}
