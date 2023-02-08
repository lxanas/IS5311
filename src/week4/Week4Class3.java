package week4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Week4Class3
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        String s = "";
        File out = new File("/Users/lixiang/IdeaProjects/IS5311/src/week4/user-input.txt");
        FileWriter writer = new FileWriter(out);
        do
        {
            s = in.nextLine();
            writer.write(s);
            writer.write("\n");
        } while (!s.toLowerCase().equals("end"));
        writer.close();
    }
}
