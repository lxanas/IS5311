package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph
{
    private int V;
    private List<List<Integer>> adj;

    public Graph(String filename) throws FileNotFoundException
    {
        V = 0;
        int max = 0;
        File file = new File(filename);
        Scanner in = new Scanner(file);
        while (in.hasNextLine())
        {
            V++;
            String s = in.nextLine();
            int temp = Integer.parseInt(s.substring(0, s.indexOf(":")).trim());
            if (temp > max)
            {
                max = temp;
            }
        }
        in.close();
        adj = new ArrayList<>(max);
        for (int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }
        in = new Scanner(file);
        int u = 0;
        while (in.hasNextLine())
        {
            String[] parts = in.nextLine().split(": ");
//            System.out.println(parts[0]);
            u = Integer.parseInt(parts[0].trim()) - 1;
            String[] neighbors = parts[1].split(", ");
            for (String neighbor : neighbors)
            {
                int v = Integer.parseInt(neighbor) - 1;
                adj.get(u).add(v);
            }
        }
        in.close();
    }

    public Graph()
    {
        V = 0;
        adj = new ArrayList<>();
    }

    public int getV()
    {
        return V;
    }

    public int getE()
    {
        int E = 0;
        for (int i = 0; i < V; i++)
        {
            E += adj.get(i).size();
        }
        return E / 2;
    }

    public List<Integer> getAdj(int v)
    {
        return adj.get(v);
    }


    public static void main(String[] args) throws FileNotFoundException
    {
        Graph g = new Graph("/Users/lixiang/IdeaProjects/IS5311/src/project/graph.txt");
        g.findSpanningTree(0);
        System.out.println("hello");
    }

    /*Let currG denote the current graph.

Initialization(root) {
    // A spanning tree is also a graph.
    // We keep adding necessary vertices and edges to an initially empty graph for constructing the spanning tree.
    Create an empty graph G (i.e. no vertex and edge in G).
    Add root to G.
    Call buildSpanningTreeRecur(G, root);
    For every vertex v in currG:
        if v does not in G, report the currG is not connected if necessary.
    report the spanning tree G if necessary.
}

buildSpanningTreeRecur(G, u) {
    Get the neighbor list of u in currG.
    For each neighbor vertex v of u according to the ORDER of the neighbor list of u {
        if v does not in G {
            add the edge (u, v) to G (vertex v will be also be added to G).
            Call buildSpanningTreeRecur(G, v);
        } else if (u, v) is not an edge in G {
            report there is a cycle if necessary.
        }
    }
}*/
    public void findSpanningTree(int root)
    {
        List<List<Integer>> G = new ArrayList<>();
        for (int i = 0; i < V; i++)
        {
            G.add(new ArrayList<>());
        }
        // Add the root vertex to G.
        G.get(root).add(-1); // use -1 to represent a dummy parent for the root
        // Build the spanning tree recursively.
        buildSpanningTreeRecur(G, root);
        // Check if every vertex is in G to ensure connectivity.
        for (int i = 0; i < V; i++)
        {
            if (i != root && G.get(i).isEmpty())
            {
                System.out.println("The graph is not connected.");
                return;
            }
        }
        // Report the spanning tree.
        System.out.println("The spanning tree is:");
        for (int u = 0; u < V; u++)
        {
            for (int v : G.get(u))
            {
                if (v != -1)
                {
                    System.out.println(u + " - " + v);
                }
            }
        }
    }

    private void buildSpanningTreeRecur(List<List<Integer>> G, int root)
    {
    }
}

