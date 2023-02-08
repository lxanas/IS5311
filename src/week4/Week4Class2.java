package week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Week4Class2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File myfile = new File("/Users/lixiang/IdeaProjects/IS5311/src/week4/in-class-ex2.txt");
        Scanner infile = new Scanner(myfile);
        String s;
        int line = 0;
        while (infile.hasNextLine())
        {
            s = infile.nextLine();
            System.out.println(s);
            line++;
        }
        System.out.println(line);
    }
}
