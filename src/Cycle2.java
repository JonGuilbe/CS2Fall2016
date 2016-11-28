/**
 * Created by reneg on 11/25/2016.
 */
import java.util.*;
public class Cycle2 {
    static boolean visited[];
    static boolean cycleFound = false;
    static boolean tempcycleFound = false;
    static ArrayList<Integer> answer;
    static int shortestCycle = 999999999;

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int vertices = stdin.nextInt() + 1;
        int edges = stdin.nextInt();
        node[] adjList = new node[vertices];
        for(int i = 1; i < vertices; i++){
            adjList[i] = new node();
        }
        visited = new boolean[vertices];
        int i = 0;
        while (i < edges) {
            int x = stdin.nextInt();//
            int y= stdin.nextInt();//
            adjList[x].add(y);//
            adjList[y].add(x);//
            i++;
        }
        ArrayList<Integer> tempAnswer = new ArrayList<>();
        for (int j = 1; j < vertices; j++) {
            //System.out.println("Running on vertex " + j);
            neoDFS(adjList,j,j, visited, -1, tempAnswer);
            visited[j] = true;
            tempAnswer.clear();
        }
        /*
        for(i = 1; i < vertices; i++){
            if(!visited[i]){
                tempAnswer.clear();
                tempcycleFound = false;
                dfs(adjList, i, visited, -1, tempAnswer, 1);
                if (tempcycleFound)
                    cycleFound = true;
            }
        } */

        if(cycleFound){
            System.out.println("Yes");
            System.out.println(shortestCycle);
            for (int j = 0; j < shortestCycle; j++) {
                System.out.print(answer.get(j) + " ");
            }
        }
        else
            System.out.println("No");
    }

    public static void dfs(node[] adjList, int index, boolean[] visited, int previous, ArrayList<Integer> tempAnswer, int depth){
        visited[index] = true;
        for (int i = 0; i < adjList[index].connectedTo.size(); i++) {
            if(tempcycleFound)
                return;
            if(!visited[adjList[index].connectedTo.get(i)]){
                tempAnswer.add(index);
                dfs(adjList,adjList[index].connectedTo.get(i), visited, index, tempAnswer, depth + 1);
            }
            else if(adjList[index].connectedTo.get(i) != previous){
                tempAnswer.add(index);
                if(tempcycleFound && depth < shortestCycle){
                    tempAnswer.subList(0, tempAnswer.indexOf(adjList[index].connectedTo.get(i))).clear();
                    //System.out.printf("Answer should be %d but is %d", depth, answer.size());
                    shortestCycle = depth;
                    answer = (ArrayList<Integer>)tempAnswer.clone();
                }
                else if(tempcycleFound && depth == shortestCycle){
                    int x = 0;
                    while(x < depth && Objects.equals(tempAnswer.get(x), answer.get(x))){
                        x++;
                    }
                    if(tempAnswer.get(x).compareTo(answer.get(x)) == 1){
                        //System.out.printf("Answer should be %d but is %d", depth, answer.size());
                        answer = (ArrayList<Integer>)tempAnswer.clone();
                    }
                }
                else if(!tempcycleFound){
                    tempcycleFound = true;
                    shortestCycle = depth;
                    System.out.printf("Index: %d depth: %d\n", index, depth);
                    tempAnswer.subList(0, tempAnswer.indexOf(adjList[index].connectedTo.get(i))).clear();
                    //System.out.printf("Answer should be %d but is %d", depth, answer.size());
                    answer = (ArrayList<Integer>)tempAnswer.clone();
                }
                //tempAnswer.clear();
                return;
            }
        }
    }

    public static void neoDFS(node[] adjList, int index, int start, boolean[] visited, int previous, ArrayList<Integer> tempAnswer){
        if(visited[index]){
            if(index == start){
                int depth = tempAnswer.size();
                if(!cycleFound){
                    cycleFound = true;
                    shortestCycle = depth;
                    if(tempAnswer.indexOf(index) == -1)
                        return;
                    tempAnswer.subList(0, tempAnswer.indexOf(index)).clear();
                    answer = (ArrayList<Integer>)tempAnswer.clone();
                }
                else if(cycleFound && depth < shortestCycle){
                    //System.out.println("New shortest!");
                    if(tempAnswer.indexOf(index) == -1)
                        return;
                    tempAnswer.subList(0, tempAnswer.indexOf(index)).clear();
                    shortestCycle = depth;
                    answer = (ArrayList<Integer>)tempAnswer.clone();
                }
                else if(cycleFound && depth == shortestCycle){
                    //System.out.println("Trying to find a minnne!");
                    int x = 0;
                    while(x < depth - 1 && Objects.equals(tempAnswer.get(x), answer.get(x))){
                        //System.out.println("Trying to find a min!");
                        x++;
                    }
                    if(tempAnswer.get(x).compareTo(answer.get(x)) == -1)
                        answer = (ArrayList<Integer>)tempAnswer.clone();
                }
            }
            return;
        }
        visited[index] = true;
        tempAnswer.add(index);
        for (int i = 0; i < adjList[index].connectedTo.size(); i++) {
            if(adjList[index].connectedTo.get(i) != previous){
               // System.out.printf("%d connecting to %d\n", index, adjList[index].connectedTo.get(i));
            neoDFS(adjList, adjList[index].connectedTo.get(i), start, visited, index, tempAnswer);}
        }
        if(tempAnswer.indexOf(index) != -1)
            tempAnswer.remove(tempAnswer.indexOf(index));
        visited[index] = false;
    }

    public static class node{
        ArrayList<Integer> connectedTo = new ArrayList<>();
        public void add(int i){
            connectedTo.add(i);
        }
    }

}
