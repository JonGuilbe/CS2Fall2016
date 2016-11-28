/**
 * Created by reneg on 11/24/2016.
 */

import java.util.*;

public class Destroyer {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int vertices = stdin.nextInt() + 1;
        int edges = stdin.nextInt();
        int[][] adjList = new int[edges][3];
        int weightTotal = 0;
        for (int i = 0; i < edges; i++) {
            int x = stdin.nextInt();
            int y = stdin.nextInt();
            int weight = stdin.nextInt();
            adjList[i][0] = x;
            adjList[i][1] = y;
            adjList[i][2] = weight;
            weightTotal += weight;
        }
        System.out.println(weightTotal - getMSTCost(vertices, adjList));
    }

    public static int getMSTCost(int numVertices, int[][] edgeList) {
        // O(E log E)
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        // O(E * a^-1(V))
        int resultCost = 0;
        DisjointSet ds = new DisjointSet(numVertices);
        for (int i = edgeList.length-1; i >= 0; i--) {
            if(ds.union(edgeList[i][0],edgeList[i][1]))
                resultCost += edgeList[i][2];
        }
        return resultCost;
    }

    public static class DisjointSet {
        int size;
        int[] parent, rank;

        public DisjointSet(int size) {
            this.size = size;
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
            rank = new int[size];
            Arrays.fill(rank, 1);
        }

        int find(int i) {
            if (parent[i] == i)
                return i;
            parent[i] = find(parent[i]);
            return parent[i];
        }
        boolean union(int i, int j) {
            // Do union
            int root_i = find(i);
            int root_j = find(j);
            if (root_i == root_j)
                return false;

            if (rank[root_i] < rank[root_j]) {
                parent[root_i] = root_j;
                return true;
            } else if (rank[root_i] > rank[root_j]) {
                parent[root_j] = root_i;
                return true;
            }

            rank[root_i]++;
            parent[root_j] = root_i;
            return true;
        }
    }
}


