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
        System.out.println("hello");
    }

    public void findSpanningTree(int root)
    {

    }
}

