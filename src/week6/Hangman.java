package week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.io.IOException;

/*
 * It is the simple word game, Hangman.
 */

public class Hangman
{

    /**
     * Task 1: Write a method for reading the list of words from the file argument
     * Method name:
     * readWordListFile
     * Parameter:
     * File wordListFile: The file descriptor of the word list file
     * Return:
     * Type:
     * String[]
     * Value:
     * The word list from the word list file
     * On completion of this method:
     * Uncomment the comment block/line right below the comment "-- Calls Task 1 --" in the main method
     */
    // Put your code for task 1 here
    public static String[] readWordListFile(File file) throws FileNotFoundException
    {
        Scanner in = new Scanner(file);

        int count = 0;
        while (in.hasNextLine())
        {
            count++;
            in.nextLine();
        }
        String[] list = new String[count];
        in = new Scanner(file);
        int i = 0;
        while (in.hasNextLine())
        {
            String line = in.nextLine();
            list[i++] = line;
        }
        return list;
    }

    /**
     * Task 2: Write a method that converts a string into an array of char
     * Method name:
     * stringToCharArray
     * Parameter:
     * String s: The target string
     * Return:
     * Type:
     * char[]
     * Value:
     * The char array converted from the given string s argument.
     * On completion of this method:
     * Uncomment the comment block/line right below the comment "-- Calls Task 2 --" in the main method
     */
    // Put your code for task 2 here
    public static char[] stringToCharArray(String s)
    {
        int len = s.length();
        char[] ca = new char[len];
        ca = s.toCharArray();
        return ca;
    }

    /**
     * Task 3: Write a method that counts the number of wrong guesses
     * Method name:
     * getNumWrongs
     * Parameter:
     * char[] wrongs: The array that stores the wrongly guessed letters
     * Return:
     * Type:
     * int
     * Value:
     * The number of wrong guesses
     * On completion:
     * Uncomment the comment block/line right below the comment "-- Calls Task 3 --" in the printScreen method
     * *Hint: Recall that the default initial value of every entry of an array is zero.**
     */
    // Put your code for task 3 here
    public static int getNumWrongs(char[] wrongs)
    {
        int num = 0;
        for (char c : wrongs)
        {
            num++;
        }
        return num;
    }

    /**
     * Task 4: Write a method for checking whether a letter exists in a word.
     * E.g. if the word is baby, then a is in the word, b is in the word,
     * y is in the word, but c is not in the word.
     * Method name:
     * isLetterInWord
     * Parameters (in order):
     * char letter: The target letter
     * char[] word: The word to be checked whether it contains the target letter.
     * Return:
     * Type:
     * boolean
     * Value:
     * true if letter in word,
     * false otherwise
     * On completion of this method:
     * Uncomment the comment block/line right below the comment "-- Calls Task 4 --" in the printScreen method
     */
    // Put your code for task 4 here
    public static boolean isLetterInWord(char letter, char[] word)
    {
        boolean flag = false;
        for (char c : word)
        {
            if (c == letter)
            {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * Task 5: Write a method for checking whether all
     * letters in the secret word be guessed correctly
     * Method name:
     * isWordComplete
     * Parameters:
     * char[] secretWord: The secret word that the player is guessing
     * char[] rights: The correctly guessed letters
     * Return:
     * Type:
     * boolean
     * Value:
     * true if all letters in the secret word be guessed correctly (i.e. exists in the char array rights),
     * false otherwise
     */
    // Put your code for task 5 here
    public static boolean isWordComplete(char[] secretWord, char[] rights)
    {
        int a = secretWord.length, b = rights.length;
        int min = (a < b ? a : b);
        boolean flag = true;
        for (int i = 0; i < min; i++)
        {
            if (secretWord[i] != rights[i])
            {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * Task 6: Write a method to insert a newly guessed letter into the corresponding array (i.e. rights or wrongs).
     * Recall that:
     * The rights array has no duplicates
     * The wrongs array may contain duplicates
     * Method name:
     * insertGuessToArray
     * Parameters (in order):
     * char guess: The newly guessed letter
     * char[] rights: The array that stores the correctly guessed letters (no duplicate)
     * char[] wrongs: The array that stores the wrongly guessed letters (may contain duplicates)
     * char[] secretWord: The secret word that the player is guessing
     * Return:
     * Type:
     * void
     * On completion of this method:
     * Uncomment the line(s) right below the comment "-- Calls Task 6 --" in the main method
     * IF tasks 7 and 8 are also done, then uncomment the comment block/line right below the comment "-- Calls Task 6, 7 and 8 --" in the main method.
     * *Hint: Recall that the default initial value of every array entry is zero.**
     */
    // Put your code for task 6 here
    public static void insertGuessToArray(char guess, char[] rights, char[] wrongs, char[] secretWord)
    {
        boolean flag = false;
        for (char c : secretWord)
        {
            if (guess == c) flag = true;
        }
        if (flag)
        {
            for (int i = 0; i < rights.length; i++)
            {
                if (rights[i] == '\u0000')
                {
                    rights[i] = guess;
                    break;
                }
            }
        }
        else
        {
            for (int i = 0; i < wrongs.length; i++)
            {
                if (wrongs[i] == '\u0000')
                {
                    wrongs[i] = guess;
                    break;
                }
            }
        }
    }

    /**
     * Task 7: Write a method to determine whether the player wins
     * Method name:
     * isPlayerWin
     * Parameters:
     * char[] secretWord: The secret word that the player is guessing
     * char[] rights: The letters that are guessed correctly
     * Return:
     * Type:
     * boolean
     * Value:
     * true if all letters in the secret word are correctly guessed,
     * false otherwise
     * On completion:
     * Uncomment the line(s) right below the comment "-- Calls Task 7 --" in the main method
     * IF tasks 6 and 8 are also done, then uncomment the comment block/line right below the comment "-- Calls Task 6, 7 and 8 --" in the main method.
     * Hint: Is there any other method that is equivalent to this method?
     */
    // Put your code for task 7 here
    public static boolean isPlayerWin(char[] secretWord, char[] rights)
    {
        boolean flag1 = false, flag2 = false;
        for (char c : secretWord)
        {
            flag1 = false;
            for (int i = 0; rights[i] != '\u0000'; i++)
            {
                char c1 = rights[i];

                if (c1 == c)
                {
                    flag1 = true;
                }
            }
            if (flag1 == true)
            {
                flag2 = true;
            }
            else
            {
                flag2 = false;
                break;
            }
        }
        return flag2;
    }

    /**
     * Task 8: Write a method to determine whether the player loses
     * Method name:
     * isPlayerLose
     * Parameters:
     * char[] wrongs: The letters that are guessed incorrectly
     * Return:
     * Type:
     * boolean
     * Value:
     * true if the number of incorrectly guessed letters is at least 6
     * false otherwise
     * On completion:
     * IF tasks 6 and 7 are also done, then uncomment the comment block/line right below the comment "-- Calls Task 6, 7 and 8 --" in the main method.
     */
    // Put your code for task 8 here
    public static boolean isPlayerLose(char[] wrongs)
    {
        int sum = 0;
        for (int i = 0; wrongs[i] != '\u0000'; i++)
        {
            sum++;
        }
        if (sum >= 6)
            return true;
        else return false;
    }

    /**
     * This function prints the hangman based on the number of wrong guesses the
     * player has made so far.
     */
    public static void printHangman(int numOfWrongs)
    {
        // Line 1
        System.out.print("\t  _______\n");

        // Line 2
        System.out.print("\t  |     |\n");

        // Line 3
        System.out.print("\t  |     +\n");

        // Line 4 - left arm, head and right arm
        for (int i = 0; i < numOfWrongs; i++)
            System.out.println("\t  |     |");
        System.out.print("\t  |");
        System.out.print("   \\T_T/");
        System.out.print("\n");

        // Line 5 - body
        System.out.print("\t  |");
        System.out.print("     |");
        System.out.print("\n");

        // Line 6 - left leg and right leg
        System.out.print("\t  |");
        System.out.print("    /");
        System.out.print(" \\");
        System.out.print("\n");

        // Line 7
        for (int i = 0; i < 6 - numOfWrongs; i++)
            System.out.print("\t  |\n");

        // Line 8
        System.out.print("\t__|__^^^^^^^\n");
    }

    /**
     * This function prints an array of letters as a list of letters separated by
     * spaces.
     */
    public static void printLetters(char[] letters)
    {
        for (int i = 0; i < letters.length; i++)
        {
            if (letters[i] > 0)
                System.out.print(letters[i] + " ");
        }
    }

    /**
     * This function prints the screen of the game.
     * If a letter in the secret word has been guessed correctly, the
     * letter will be shown; otherwise, the letter will be shown as '_'.
     */
    public static void printScreen(char[] rights, char[] wrongs, char[] secretWord)
    {

        // Print the hangman
        // -- Calls Task 3 --
        printHangman(getNumWrongs(wrongs));

        // Print the correct and wrong guesses so far
        System.out.print("Correct guesses: ");
        printLetters(rights);
        System.out.println();
        System.out.print("Wrong guesses: ");
        printLetters(wrongs);
        System.out.println("\n\n");

        // Print the secret word
        System.out.print("\t");
        for (int i = 0; i < secretWord.length; i++)
        {
            // -- Calls Task 4 --

            if (isLetterInWord(secretWord[i], rights))
                System.out.print(secretWord[i] + " ");
            else
                System.out.print("_ ");

        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws IOException
    {

        // This array stores the distinct letters the player has guessed correctly so far
        char[] rights = new char[26];

        // This array stores the distinct letters the player has guessed incorrectly so far
        char[] wrongs = new char[7];

        // This value is used to put the current guess from the player in the game loop
        char guess;

        // This value stores the list of words
        // null will be introduced in later of this course
        // We set it here for avoiding the compilation error of
        // "no inital value to a variable" before you uncomment some codes
        String[] wordList = null;

        // This value stores the secret word to be guessed
        // null will be introduced in later of this course
        // We set it here for avoiding the compilation error of
        // "no inital value to a variable" before you uncomment some code
        char[] secretWord = null;

        Scanner keyboard = new Scanner(System.in);
        // This is the Random object for generating random word index
        Random rand = new Random();

        // Create file descriptor of the word list file
        File wordListFile = new File("/Users/lixiang/IdeaProjects/IS5311/src/week6/word-list.txt");

        // Get the word list from the file
        // -- Calls Task 1 --
        wordList = readWordListFile(wordListFile);

        // Randomly generate an index of a word of the word list
        int secretWordIndex = rand.nextInt(wordList.length);

        // Convert the secret word string into char[]
        // -- Calls Task 2 --
        secretWord = stringToCharArray(wordList[secretWordIndex]);

        // Repeatedly ask the user to input a letter until the game ends.
        // -- Calls Task 6, 7 and 8 --

        while (!isPlayerWin(secretWord, rights) && !isPlayerLose(wrongs))
        {
            // Print the hangman screen
            printScreen(rights, wrongs, secretWord);

            // Ask for the guess
            System.out.print("\nPlease enter your guess: ");
            guess = keyboard.nextLine().charAt(0);

            insertGuessToArray(guess, rights, wrongs, secretWord);
        }


        // Print the final hangman screen
        printScreen(rights, wrongs, secretWord);

        // -- Calls Task 7 --

        if (isPlayerWin(secretWord, rights))
        {
            System.out.print("You have won!\n");
        }
        else
        {
            System.out.print("You have lost!\n");
        }

    }
}

