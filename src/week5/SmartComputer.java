package week5;

import java.util.Scanner;

public class SmartComputer
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int m, n;
        System.out.printf("Enter the size: ");
        m = Integer.parseInt(in.nextLine());
//        System.out.printf("Enter the number of columns: ");
        n = m;
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                board[i][j] = 'O';
            }
        }
        board[m - 1][n - 1] = 'X';
        for (int i = 0; i < m; i++)
        {
            System.out.printf("|");
            for (int j = 0; j < n; j++)
            {
                System.out.printf(String.valueOf(board[i][j]));
                System.out.printf("|");
            }
            System.out.printf("\n");
        }
        int end = 0;
        int flag = 0;
        int m1 = 0, n1 = 0;
        while (end == 0)
        {
            for (int i = 1; i < 3; i++)
            {
                if (i == 1)
                {
                    System.out.println("Computer's turn:");
                    System.out.printf("Enter the number of rows: ");
                    if (flag == 0)
                    {
                        m1 = m - 1;
                        n1 = m1;
                        flag = 1;
                    }
                    int temp = m1;
                    m1 = n1;
                    System.out.println(m1);
                    System.out.printf("Enter the number of columns: ");
                    n1 = temp;
                    System.out.println(n1);
                    for (int j = 0; j < m1; j++)
                    {
                        for (int k = 0; k < n1; k++)
                        {
                            if (board[j][k] == 'O' || board[j][k] == 'X')
                                board[j][k] = (char) (i + 48);
                        }
                    }
                    for (int j = 0; j < m; j++)
                    {
                        System.out.printf("|");
                        for (int k = 0; k < n; k++)
                        {
                            System.out.printf(String.valueOf(board[j][k]));
                            System.out.printf("|");
                        }
                        System.out.printf("\n");
                    }
                    if (board[m - 1][n - 1] == (char) (i + 48))
                    {
                        if (i == 1)
                        {
                            System.out.printf("Game ended! Computer ate the poison cake! ");
                            System.out.printf("Player wins!\n");
                            end = 1;
                            break;
                        }
                        else
                        {
                            System.out.printf("Game ended! Player ate the poison cake! ");
                            System.out.printf("Computer wins!\n");
                            end = 1;
                            break;
                        }
                    }
                }
                else
                {
                    System.out.println("Player's turn:");
                    System.out.printf("Enter the number of rows: ");
                    m1 = in.nextInt();
                    in.nextLine();
                    System.out.printf("Enter the number of columns: ");
                    n1 = in.nextInt();
                    in.nextLine();
                    for (int j = 0; j < m1; j++)
                    {
                        for (int k = 0; k < n1; k++)
                        {
                            if (board[j][k] == 'O' || board[j][k] == 'X')
                                board[j][k] = (char) (i + 48);
                        }
                    }
                    for (int j = 0; j < m; j++)
                    {
                        System.out.printf("|");
                        for (int k = 0; k < n; k++)
                        {
                            System.out.printf(String.valueOf(board[j][k]));
                            System.out.printf("|");
                        }
                        System.out.printf("\n");
                    }
                    if (board[m - 1][n - 1] == (char) (i + 48))
                    {

                        if (i == 1)
                        {
                            System.out.printf("Game ended! Computer ate the poison cake! ");
                            System.out.printf("Player wins!\n");
                            end = 1;
                            break;
                        }
                        else
                        {
                            System.out.printf("Game ended! Player ate the poison cake! ");
                            System.out.printf("Computer wins!\n");
                            end = 1;
                            break;
                        }
                    }
                }
            }
        }
    }
}
