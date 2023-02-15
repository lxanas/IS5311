package week5;

import java.util.Scanner;

public class PoisonCake
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int m, n;
        System.out.printf("Enter the number of rows: ");
        m = in.nextInt();
        in.nextLine();
        System.out.printf("Enter the number of columns: ");
        n = in.nextInt();
        in.nextLine();
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
        int m1, n1;
        while (end == 0)
        {
            for (int i = 1; i < 3; i++)
            {
                System.out.println("Player" + i + "'s turn:");
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
                    System.out.printf("Game ended! Player " + (i) + " ate the poison cake! ");
                    if (i == 1)
                    {
                        System.out.printf("Player 2 wins!\n");
                        end = 1;
                        break;
                    }
                    else
                    {
                        System.out.printf("Player 1 wins!\n");
                        end = 1;
                        break;
                    }
                }
            }
        }
    }
}
