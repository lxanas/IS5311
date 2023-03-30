package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph
{
    private int V;
    private List<List<Integer>> adj;
    private Set<Integer> visited;

    public Graph(String filename) throws FileNotFoundException
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
        visited = new HashSet<>();
    }

    public Graph(int V)
    {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }
        visited = new HashSet<>();
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

    public void addEdge(int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    public static void main(String[] args) throws FileNotFoundException
    {
        Graph g = new Graph("/Users/lixiang/IdeaProjects/IS5311/src/project/graph.txt");
        Graph tree = g.findSpanningTree(1);
        tree.printAdjacencyList();
        System.out.println("hello");
    }


    public Graph findSpanningTree(int root)
    {
        Graph spanningTree = new Graph(V);
        buildSpanningTreeRecur(spanningTree, root);

        for (int v = 0; v < V; v++)
        {
            if (!spanningTree.visited.contains(v))
            {
                System.out.println("The current graph is not connected.");
                return null;
            }
        }
        return spanningTree;
    }

    private void buildSpanningTreeRecur(Graph G, int u)
    {
        visited.add(u);
        G.visited.add(u);

        for (int v : adj.get(u))
        {
            if (!G.visited.contains(v))
            {
                G.addEdge(u, v);
                buildSpanningTreeRecur(G, v);
            }
            else if (!G.adj.get(u).contains(v))
            {
                System.out.println("There is a cycle.");
            }
        }
    }

    public void printAdjacencyList()
    {
        for (int i = 0; i < V; i++)
        {
            List<Integer> neighbors = adj.get(i);
            System.out.print("Vertex " + i + ":");
            for (int v : neighbors)
            {
                System.out.print(" -> " + v);
            }
            System.out.println();
        }
    }

//    public void findSpanningTree(int root)
//    {
//        List<List<Integer>> G = new ArrayList<>();
//        for (int i = 0; i < V; i++)
//        {
//            G.add(new ArrayList<>());
//        }
//        // Add the root vertex to G.
//        G.get(root).add(-1); // use -1 to represent a dummy parent for the root
//        // Build the spanning tree recursively.
//        buildSpanningTreeRecur(G, root);
//        // Check if every vertex is in G to ensure connectivity.
//        for (int i = 0; i < V; i++)
//        {
//            if (i != root && G.get(i).isEmpty())
//            {
//                System.out.println("The graph is not connected.");
//                return;
//            }
//        }
//        // Report the spanning tree.
//        System.out.println("The spanning tree is:");
//        for (int u = 0; u < V; u++)
//        {
//            for (int v : G.get(u))
//            {
//                if (v != -1)
//                {
//                    System.out.println(u + " - " + v);
//                }
//            }
//        }
//    }
//
//    private void buildSpanningTreeRecur(List<List<Integer>> G, int root)
//    {
//
//    }
}

