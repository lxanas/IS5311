package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Gra
{
    private int V;
    private HashMap<Integer, ArrayList<Integer>> adj;
    private HashSet<Integer> visited;

    public Gra()
    {
        V = 0;
        adj = new HashMap<>();
        visited = new HashSet<>();
    }

    public Gra(int V)
    {
        this.V = V;
        adj = new HashMap<>();
        visited = new HashSet<>();
    }

    public Gra(String filename) throws FileNotFoundException
    {
        visited = new HashSet<>();
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
        adj = new HashMap<>(max);
        in = new Scanner(file);
        int u = 0;
        while (in.hasNextLine())
        {
            String[] parts = in.nextLine().split(": ");
            u = Integer.parseInt(parts[0].trim());
            adj.put(u, new ArrayList<>());
            String[] neighbors = parts[1].split(", ");
            for (String neighbor : neighbors)
            {
                int v = Integer.parseInt(neighbor);
                adj.get(u).add(v);
            }
        }
        in.close();
    }

    public void addEdge(int u, int v)
    {
        if (!adj.containsKey(u))
        {
            adj.put(u, new ArrayList<>());
        }
        adj.get(u).add(v);
        if (!adj.containsKey(v))
        {
            adj.put(v, new ArrayList<>());
        }
        adj.get(v).add(u);
    }

    public int getV()
    {
        return V;
    }

    public int getE()
    {
        int E = 0;
        for (int u : adj.keySet())
        {
            E += adj.get(u).size();
        }
        return E / 2;
    }

    public Gra findSpanningTree(int root)
    {
        Gra spanningTree = new Gra(V);
        buildSpanningTreeRecur(spanningTree, root);
        for (int u : adj.keySet())
        {
            if (!spanningTree.visited.contains(u))
            {
                System.out.println("The current graph is not connected.");
                return null;
            }
        }
        return spanningTree;
    }

    private void buildSpanningTreeRecur(Gra g, int root)
    {
        visited.add(root);
        for(int v : adj.get(root))
        {
            if(!visited.contains(v))
            {
                g.addEdge(root, v);
                buildSpanningTreeRecur(g, v);
            }

        }

    }


    public static void main(String[] args) throws FileNotFoundException
    {
        Gra g = new Gra("/Users/lixiang/IdeaProjects/IS5311/src/project/graph.txt");

        System.out.println("hello");
    }
}
