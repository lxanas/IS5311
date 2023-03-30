package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Try
{

    public static void main(String[] args)
    {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        adj.put(1, new ArrayList<>());
        adj.put(2, new ArrayList<>());
        adj.get(1).add(2);
        System.out.println(adj.get(1).contains(2));

    }
}
