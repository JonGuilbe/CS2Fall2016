/**
 * Created by Jonathan on 11/17/2016.
 */
import java.util.*;
public class Cycle {

    static boolean visited[];
    static boolean cycleFound = false;

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int vertices = stdin.nextInt() + 1;
        int edges = stdin.nextInt();
        node[] adjList = new node[vertices];
        for (int i = 1; i < vertices; i++) {
            adjList[i] = new node();
        }
        visited = new boolean[vertices];
        for (int i = 0; i < edges; i++) {
            int x = stdin.nextInt();
            int y = stdin.nextInt();
            adjList[x].add(y);
            adjList[y].add(x);
        }
        for (int i = 1; i < vertices; i++) {
            if(!visited[i])
                dfs(adjList, i, visited, -1);
        }
        if(cycleFound)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static void dfs(node[] adjList, int index, boolean[] visited, int previous){
        visited[index] = true;
        for (int i = 0; i < adjList[index].connectedTo.size(); i++) {
            if(cycleFound)
                return;
            if(!visited[adjList[index].connectedTo.get(i)])
                dfs(adjList,adjList[index].connectedTo.get(i), visited, index);
            else if(adjList[index].connectedTo.get(i) != previous){
                cycleFound = true;
                return;
            }
        }
    }

    public static class node{
        ArrayList<Integer> connectedTo = new ArrayList<>();
        public void add(int i){
            connectedTo.add(i);
        }
    }
}
