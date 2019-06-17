import java.io.Console;
import java.util.Scanner;
import java.util.ArrayList;


class Main {

    public static void main(String[] args) {

        Console secretReader = System.console();

        System.out.println("\n\n*** Welcome to HANGMAN! ***");
        System.out.println("Hangman, what is your word?");

        char[] secret = secretReader.readPassword();

        Scanner guessReader = new Scanner(System.in);
        int lettersToGuess = countUniqueLetters(secretArray);

        // TODO: main gameplay loop goes here

        guessReader.close();
    }

    // You must fill this out:
    // It needs to count the number of UNIQUE letters in secretArray,
    // i.e. repeated letters do not count
    private static int countUniqueLetters(ArrayList<Character> secretArray) {

      // TODO: complete this function

      return numUniqueLetters;
    }

    private static void printResults(ArrayList<Character> secretArray, ArrayList<Character> guessedArray, int lives) {

        // Prints the platform and prisoner
        System.out.println("     _______");
        System.out.println("     |     :");

        if (lives < 7) {
            System.out.println("     |     @");
        } else {
            System.out.println("     |");
        }

        if (lives < 4) {
            System.out.println("     |    /|\\");
        } else if (lives < 5) {
            System.out.println("     |    /|");
        } else if (lives < 6) {
            System.out.println("     |     |");
        } else {
            System.out.println("     |");
        }

        if (lives < 3) {
            System.out.println("     |     |");
        } else {
            System.out.println("     |");
        }

        if (lives < 1) {
            System.out.println("     |    / \\");
        } else if (lives < 2) {
            System.out.println("     |    /");
        } else {
            System.out.println("     |");
        }

        System.out.println("     |");
        System.out.println(" ____|______________ ");
        System.out.println("| " + lives + " LIVES REMAINING |");

        // Prints the word so far
        System.out.print(" WORD:  ");
        for (char secretLetter : secretArray) {

            if (guessedArray.contains(secretLetter)) {
                System.out.print(secretLetter + " ");
            } else {
                System.out.print("_ ");
            }
        }

        System.out.println("\n");
    }
}
