import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class IndividualProject
{
    private int V;
    private HashMap<Integer, ArrayList<Integer>> adj;
    private HashSet<Integer> visited;

    private boolean flag = false;

    private boolean cycle = false;

    private boolean connected = true;

    public IndividualProject()
    {
        V = 0;
        adj = new HashMap<>();
        visited = new HashSet<>();
    }

    public IndividualProject(int V)
    {
        this.V = V;
        adj = new HashMap<>();
        visited = new HashSet<>();
    }

    public IndividualProject(String filename) throws Exception
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
        if (adj.get(u).contains(v))
        {
            return;
        }
        adj.get(u).add(v);
        if (!adj.containsKey(v))
        {
            adj.put(v, new ArrayList<>());
        }
        adj.get(v).add(u);
        flag = true;
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

    public IndividualProject findSpanningTree(int root)
    {
        IndividualProject spanningTree = new IndividualProject(V);
        buildSpanningTreeRecur(spanningTree, root);
        for (int u : adj.keySet())
        {
            if (spanningTree.adj.get(u) == null)
            {
                this.connected = false;
                return null;
            }
        }
        return spanningTree;
    }


    private void buildSpanningTreeRecur(IndividualProject g, int root)
    {
        for (int v : adj.get(root))
        {
            if (!g.adj.containsKey(v))
            {
                g.addEdge(root, v);
                buildSpanningTreeRecur(g, v);
            }
            else if (!g.adj.get(root).contains(v))
            {
                this.cycle = true;
            }
        }
    }

    private void isCycle() throws Exception
    {
        if (this.adj.isEmpty())
        {
            System.out.println("The graph is not loaded yet.");
            chooseAction(this);
            return;
        }
        if (this.cycle)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
        chooseAction(this);
    }

    private void isConnected() throws Exception
    {
        if (this.adj.isEmpty())
        {
            System.out.println("The graph is not loaded yet.");
            chooseAction(this);
            return;
        }
        if (this.connected)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
        chooseAction(this);
    }

    private void printGraph() throws Exception
    {
        if (this.adj.isEmpty())
        {
            System.out.println("The graph is not loaded yet.");
            chooseAction(this);
            return;
        }
        ArrayList<Integer> list = new ArrayList<>(adj.keySet());
        Collections.sort(list);
        for (int u : list)
        {
            System.out.print(u + ": ");
            ArrayList<Integer> neighbors = adj.get(u);
            int n = neighbors.size();
            for (int i = 0; i < n; i++)
            {
                int v = neighbors.get(i);
                System.out.print(v);
                if (i < n - 1)
                {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        chooseAction(this);
    }

    private void printGraph(IndividualProject g) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>(g.adj.keySet());
        Collections.sort(list);
        for (int u : list)
        {
            System.out.print(u + ": ");
            ArrayList<Integer> neighbors = adj.get(u);
            int n = neighbors.size();
            for (int i = 0; i < n; i++)
            {
                int v = neighbors.get(i);
                System.out.print(v);
                if (i < n - 1)
                {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    private void saveGraph(String filename) throws IOException
    {
        File file = new File(filename);
        if (!file.exists())
        {
            file.createNewFile();
        }
        PrintWriter out = new PrintWriter(file);
        ArrayList<Integer> list = new ArrayList<>(adj.keySet());
        Collections.sort(list);
        for (int u : list)
        {
            out.print(u + ": ");
            ArrayList<Integer> neighbors = adj.get(u);
            int n = neighbors.size();
            for (int i = 0; i < n; i++)
            {
                int v = neighbors.get(i);
                out.print(v);
                if (i < n - 1)
                {
                    out.print(", ");
                }
            }
            out.println();
        }
        out.close();
    }

    public static void printMenu()
    {
        System.out.println(" ");
        System.out.println("Action Menu:");
        System.out.println("1. Load the graph from graph.txt");
        System.out.println("2. Find a spanning tree of the current graph with a specified root");
        System.out.println("3. Is the current graph cotains cycle?");
        System.out.println("4. Is the current graph connected?");
        System.out.println("5. Add an edge to the current graph.");
        System.out.println("6. Print the adjacency list of the current graph.");
        System.out.println("7. Save the adjacency list of the current graph.");
        System.out.println("8. Exit");
        System.out.println(" ");
    }

    public static void exit()
    {
        System.out.println("Bye bye!");
        System.exit(0);
    }

    public void addEdge() throws Exception
    {
        if (this.adj.isEmpty())
        {
            System.out.println("The graph is not loaded yet.");
            chooseAction(this);
            return;
        }
        System.out.print("Enter the first endpoint: ");
        Scanner input = new Scanner(System.in);
        int u = Integer.parseInt(input.nextLine());
        System.out.print("Enter the second endpoint: ");
        int v = Integer.parseInt(input.nextLine());
        addEdge(u, v);
        if (flag)
            System.out.println("New edge is added successfully");
        else
        {
            System.out.println("Edge already exists.");
        }
        flag = false;
        findSpanningTree(this.adj.keySet().iterator().next());
        chooseAction(this);
    }

    public static void chooseAction(IndividualProject g) throws Exception
    {
        printMenu();
        System.out.printf("Please specify an action: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice)
        {
            case "1":
                load();
                break;
            case "2":
                g.findSpanningTree();
                break;
            case "3":
                g.isCycle();
                break;
            case "4":
                g.isConnected();
                break;
            case "5":
                g.addEdge();
                break;
            case "6":
                g.printGraph();
                break;
            case "7":
                g.saveGraph();
                break;
            case "8":
                exit();
                break;
            default:
                System.out.println("Invalid action.");
                chooseAction(g);
                break;
        }
    }

    public void findSpanningTree() throws Exception
    {
        IndividualProject temp = this;
        if (this.adj.isEmpty())
        {
            System.out.println("The graph is not loaded yet.");
            chooseAction(this);
            return;
        }
        System.out.print("Please specify a root: ");
        Scanner input = new Scanner(System.in);
        int root = Integer.parseInt(input.nextLine());
        IndividualProject a = findSpanningTree(root);
        if (a == null)
        {
            System.out.println("Spanning tree cannot be found because the graph is not connected.");
        }
        else
        {
            a.printGraph(a);
        }
        chooseAction(temp);
    }

    public void saveGraph() throws Exception
    {
        if (this.adj.isEmpty())
        {
            System.out.println("The graph is not loaded yet.");
            chooseAction(this);
            return;
        }
        System.out.print("Where to save the adjacency list of the current graph? ");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        saveGraph(filename);
        System.out.println("The adjacency list is successfully saved to the specified file.");
        chooseAction(this);
    }

    public static void load() throws Exception
    {
        try
        {
            String filepath = "graph.txt";
            IndividualProject g = new IndividualProject(filepath);
            int v = g.getV();
            int e = g.getE();
            System.out.println("#vertex: " + v + " #edge: " + e);
            g.findSpanningTree(g.adj.keySet().iterator().next());
            chooseAction(g);
        } catch (Exception e)
        {
            e.printStackTrace();
            IndividualProject g = new IndividualProject();
            chooseAction(g);
        }
    }


    public static void main(String[] args) throws Exception
    {
        System.out.println("Welcome to this social network analysis system.");
        IndividualProject g = new IndividualProject();
        chooseAction(g);
    }
}
