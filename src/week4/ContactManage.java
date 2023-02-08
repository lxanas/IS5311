package week4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ContactManage
{
    public static void main(String[] args) throws IOException
    {
        int loop = 0;
        Scanner in = new Scanner(System.in);
        do
        {
            System.out.println("**Welcome to the contact list management system**\n1. Show all contacts\n" +
                    "2. Enquire for a contact\n" +
                    "3. Add contact\n" +
                    "4. Exit\n");
            System.out.printf("Please select an action: ");
            int action = 0;
            int tar = 0;
            String ori = in.nextLine();
            action = Integer.parseInt(ori);
            switch (action)
            {
                case 1:
                {
                    File raw = new File("/Users/lixiang/IdeaProjects/IS5311/src/week4/contact-list.txt");
                    Scanner read = new Scanner(raw);
                    String s;
                    while (read.hasNextLine())
                    {
                        s = read.nextLine();
                        System.out.println(s);
                    }
                    read.close();
                    break;
                }
                case 2:
                {
                    int flag = 0;
                    System.out.printf("Enter a contact name: ");
                    String name = in.nextLine();
                    File raw = new File("/Users/lixiang/IdeaProjects/IS5311/src/week4/contact-list.txt");
                    Scanner read = new Scanner(raw);
                    String phone = "";
                    int line = 1;
                    while (read.hasNext() && flag != 1)
                    {
                        if (read.nextLine().equals(name) && (line % 2 == 1))
                        {
                            if (read.hasNextLine()) phone = read.nextLine();
                            flag = 1;
                        }
                        line++;
                    }
                    if (flag == 1) System.out.println("Contact name: " + name + ", Phone number: " + phone);
                    else System.out.println("Contact doesn't exist");
                    read.close();
                    break;
                }
                case 3:
                {
                    System.out.printf("Enter a new contact name: ");
                    String name = in.nextLine();
                    System.out.printf("Enter a new phone number: ");
                    String phone = in.nextLine();
                    File raw = new File("/Users/lixiang/IdeaProjects/IS5311/src/week4/contact-list.txt");
                    FileWriter fw = new FileWriter(raw, true);
                    fw.write(name);
                    fw.write("\n");
                    fw.write(phone);
                    fw.write("\n");
                    fw.close();
                    break;
                }
                case 4:
                {
                    tar = 1;
                    loop = 0;
                }
            }
            if (tar == 0) System.out.printf("Go back to main menu [Y/N]? ");
            while (tar == 0)
            {
                String a = in.nextLine();
                if (a.equals("Y") || a.equals("y"))
                {
                    loop = 1;
                    tar = 1;
                }
                else if (a.equals("N") || a.equals("n"))
                {
                    loop = 0;
                    tar = 1;
                }
                else
                {
                    System.out.printf("Invalid input, please enter Y or N: ");
                }
            }
        } while (loop == 1);
    }
}
