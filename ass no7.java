NAME : RAHUL DHANAJI HILE 
    PRN NO -123B1F031
    DATE -15/09/25


import java.util.*;

public class Assigment7_DAA {

    
    static void addEdge(List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }


    static void greedyColoring(List<List<Integer>> graph, int numCourses) {
        int[] result = new int[numCourses];
        Arrays.fill(result, -1);

        result[0] = 0;

   
        boolean[] available = new boolean[numCourses];

        for (int u = 1; u < numCourses; u++) {
            Arrays.fill(available, true);

            for (int adj : graph.get(u)) {
                if (result[adj] != -1)
                    available[result[adj]] = false;
            }

          
            int color;
            for (color = 0; color < numCourses; color++) {
                if (available[color]) break;
            }

            result[u] = color;
        }

      
        System.out.println("Exam Slot Assignment (Greedy Coloring):");
        for (int u = 0; u < numCourses; u++) {
            System.out.println("Course " + u + " → Slot " + result[u]);
        }

        int maxColor = Arrays.stream(result).max().getAsInt();
        System.out.println("\nTotal Exam Slots Used: " + (maxColor + 1));
    }

    public static void main(String[] args) {
     
        int numCourses = 6;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

      

       
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 3, 5);
        addEdge(graph, 0, 5);

       
        greedyColoring(graph, numCourses);
    }
}
