package labAnswer;

import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.io.IOException;

/*
* It is the simple word game, Hangman.
*/

public class Hangman {

	/**
		Task 1: Write a method for reading the list of words from the file argument
		Method name: 
			readWordListFile
		Parameter: 
			File wordListFile: The file descriptor of the word list file
		Return: 
			Type: 
				String[] 
			Value:
				The word list from the word list file
		On completion of this method:
			Uncomment the comment block/line right below the comment "-- Calls Task 1 --" in the main method
	*/
	public static String[] readWordListFile(File wordListFile) throws IOException {
		Scanner fileReader = new Scanner(wordListFile);
		int numWord = 0;
		while (fileReader.hasNext()) {
			fileReader.nextLine();
			numWord++;
		}
		fileReader.close();
		
		fileReader = new Scanner(wordListFile);
		String[] wordList = new String[numWord];
		int wordIndex = 0;
		while (fileReader.hasNext())
			wordList[wordIndex++] = fileReader.nextLine();
		return wordList;
	}

	/**
		Task 2: Write a method that converts a string into an array of char
		Method name:
			stringToCharArray
		Parameter:
			String s: The target string
		Return:
			Type: 
				char[]
			Value:
				The char array converted from the given string s argument.
		On completion of this method:
			Uncomment the comment block/line right below the comment "-- Calls Task 2 --" in the main method
	*/
	public static char[] stringToCharArray(String s) {
		char[] cArray = new char[s.length()];
		for (int i = 0; i < cArray.length; i++)
			cArray[i] = s.charAt(i);
		return cArray;
	}

	/**
		Task 3: Write a method that counts the number of wrong guesses
		Method name:
			getNumWrongs
		Parameter:
			char[] wrongs: The array that stores the wrongly guessed letters
		Return:
			Type: 
				int
			Value:
				The number of wrong guesses
		On completion:
			Uncomment the comment block/line right below the comment "-- Calls Task 3 --" in the printScreen method
		**Hint: Recall that the default initial value of every entry of an array is zero.**
	*/
	public static int getNumWrongs(char[] wrongs) {
		for (int i = 0; i < wrongs.length; i++) {
			if (wrongs[i] == 0)
				return i;
		}
		return wrongs.length;
	}

	/**
		Task 4: Write a method for checking whether a letter exists in a word.
		        E.g. if the word is baby, then a is in the word, b is in the word, 
				y is in the word, but c is not in the word.
		Method name: 
			isLetterInWord
		Parameters (in order):
			char letter: The target letter
			char[] word: The word to be checked whether it contains the target letter.
		Return: 
			Type: 
				boolean
			Value:
				true if letter in word, 
				false otherwise
		On completion of this method:
			Uncomment the comment block/line right below the comment "-- Calls Task 4 --" in the printScreen method
	*/
	public static boolean isLetterInWord(char letter, char[] word) {
		for (int i = 0; i < word.length; i++) {
			if (letter == word[i])
				return true;
		}
		return false;
	}
	
	/**
		Task 5: Write a method for checking whether all 
				letters in the secret word be guessed correctly
		Method name:
			isWordComplete
		Parameters:
			char[] secretWord: The secret word that the player is guessing
			char[] rights: The correctly guessed letters
		Return:
			Type: 
				boolean
			Value:
				true if all letters in the secret word be guessed correctly (i.e. exists in the char array rights), 
				false otherwise
	*/
	public static boolean isWordComplete(char[] secretWord, char[] rights) {
		for (int i = 0; i < secretWord.length; i++) {
			if (!isLetterInWord(secretWord[i], rights))
				return false;
		}
		return true;
	}

	/**
		Task 6: Write a method to insert a newly guessed letter into the corresponding array (i.e. rights or wrongs).
				Recall that: 
					The rights array has no duplicates
					The wrongs array may contain duplicates
		Method name:
			insertGuessToArray
		Parameters (in order):
			char guess: The newly guessed letter
			char[] rights: The array that stores the correctly guessed letters (no duplicate)
			char[] wrongs: The array that stores the wrongly guessed letters (may contain duplicates)
			char[] secretWord: The secret word that the player is guessing
		Return:
			Type: 
				void
		On completion of this method:
			Uncomment the line(s) right below the comment "-- Calls Task 6 --" in the main method
			IF tasks 7 and 8 are also done, then uncomment the comment block/line right below the comment "-- Calls Task 6, 7 and 8 --" in the main method.
		**Hint: Recall that the default initial value of every array entry is zero.**
	*/
	public static void insertGuessToArray(char guess, char[] rights, char[] wrongs, char[] secretWord) {
		char[] targetArray;
		if (isLetterInWord(guess, secretWord)) {
			if (isLetterInWord(guess, rights)) {
				return ;
			}
			targetArray = rights;
		} else {
			targetArray = wrongs;
		}

		for (int i = 0; i < targetArray.length; i++) {
			if (targetArray[i] == 0) {
				targetArray[i] = guess;
				return ;
			}
		}
	}

	/**
		Task 7: Write a method to determine whether the player wins
		Method name:
			isPlayerWin
		Parameters:
			char[] secretWord: The secret word that the player is guessing
			char[] rights: The letters that are guessed correctly
		Return:
			Type: 
				boolean
			Value:
				true if all letters in the secret word are correctly guessed, 
				false otherwise
		On completion:
			Uncomment the line(s) right below the comment "-- Calls Task 7 --" in the main method
			IF tasks 6 and 8 are also done, then uncomment the comment block/line right below the comment "-- Calls Task 6, 7 and 8 --" in the main method.
		Hint: Is there any other method that is equivalent to this method?
	*/
	public static boolean isPlayerWin(char[] secretWord, char[] rights) {
		return isWordComplete(secretWord, rights);
	}

	/**
		Task 8: Write a method to determine whether the player loses
		Method name:
			isPlayerLose
		Parameters:
			char[] wrongs: The letters that are guessed incorrectly
		Return:
			Type: 
				boolean
			Value:
				true if the number of incorrectly guessed letters is at least 6
				false otherwise
		On completion:
			IF tasks 6 and 7 are also done, then uncomment the comment block/line right below the comment "-- Calls Task 6, 7 and 8 --" in the main method.
			
	*/	
	public static boolean isPlayerLose(char[] wrongs) {
		return getNumWrongs(wrongs) >= 6;
	}

	/**
		This function prints the hangman based on the number of wrong guesses the
		player has made so far.
	*/
	public static void printHangman(int numOfWrongs) {
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
		This function prints an array of letters as a list of letters separated by
		spaces.
	*/
	public static void printLetters(char[] letters) {
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] > 0)
				System.out.print(letters[i] + " ");
		}
	}
	
	/**
		This function prints the screen of the game.
		If a letter in the secret word has been guessed correctly, the
		letter will be shown; otherwise, the letter will be shown as '_'.
	*/
	public static void printScreen(char[] rights, char[] wrongs, char[] secretWord) {

		// Print the hangman
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
		for (int i = 0; i < secretWord.length; i++) {
			if (isLetterInWord(secretWord[i], rights))
				System.out.print(secretWord[i] + " ");
			else
				System.out.print("_ ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) throws IOException {

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
		File wordListFile = new File("word-list.txt");
		
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
		while (!isPlayerWin(secretWord, rights) && !isPlayerLose(wrongs)) {
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
		if (isPlayerWin(secretWord, rights)) {
			System.out.print("You have won!\n");
		} else {
			System.out.print("You have lost!\n");
		}
		
	}
}
