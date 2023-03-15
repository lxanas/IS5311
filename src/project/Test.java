package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Welcome to this social network analysis system.");
        printMenu();
        chooseAction();
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

    public static void chooseAction() throws FileNotFoundException
    {
        System.out.printf("Please specify an action: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice)
        {
            case "1":
                load();
                break;
            case "2":
                findSpanningTree();
                break;
            case "3":
                containCycle();
                break;
            case "4":
                connected();
                break;
            case "5":
                addEdge();
                break;
            case "6":
                printAdjacencyList();
                break;
            case "7":
                saveAdjacencyList();
                break;
            case "8":
                exit();
                break;
            default:
                System.out.println("Invalid action.");
                chooseAction();
                break;
        }
    }

    public static void load() throws FileNotFoundException
    {
        String filepath = "/Users/lixiang/IdeaProjects/IS5311/src/project/graph.txt";
        Graph g = new Graph(filepath);
        int v = g.getV();
        int e = g.getE();
        System.out.println("#vertex: " + v + " #edge: " + e);
        chooseAction();
    }

    public static void findSpanningTree()
    {
        System.out.println("Please specify the root: ");
        Scanner input = new Scanner(System.in);
        int root = Integer.parseInt(input.nextLine());
        Graph g = new Graph();
        g.findSpanningTree(root);


    }

    public static void containCycle()
    {

    }

    public static void connected()
    {

    }

    public static void addEdge()
    {

    }

    public static void printAdjacencyList()
    {

    }

    public static void saveAdjacencyList()
    {

    }

    public static void exit()
    {
        System.out.println("Bye bye!");
        System.exit(0);
    }
}
