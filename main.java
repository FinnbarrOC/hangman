import java.io.Console;
import java.util.Scanner;
import java.util.ArrayList;


class Main {

    public static void main(String[] args) {

        Console secretReader = System.console();

        System.out.println("\n\n*** Welcome to HANGMAN! ***");
        System.out.println("Hangman, what is your word?");

        char[] secret = secretReader.readPassword();

        ArrayList<Character> secretArray = new ArrayList<>();
        for (char secretLetter : secret) {
            secretArray.add(Character.toUpperCase(secretLetter));
        }

        ArrayList<Character> guessedArray = new ArrayList<>();
        Scanner guessReader = new Scanner(System.in);

        // This counts only the UNIQUE letters in the secret word
        int lettersToGuess = (int) secretArray.stream().distinct().count();
        char currentLetter;
        int lives = 7;
        while (lives > 0 && lettersToGuess > 0) {

            System.out.println("Guessers, what is your letter?");
            currentLetter = guessReader.nextLine().toUpperCase().charAt(0);

            if (secretArray.contains(currentLetter) && !guessedArray.contains(currentLetter)) {

                System.out.println("Congrats, the letter '" + currentLetter + "' is in the word!");

                lettersToGuess -= 1;
                guessedArray.add(currentLetter);
                printResults(secretArray, guessedArray, lives);
            } else if (guessedArray.contains(currentLetter)) {

                System.out.println("Try again; the letter '" + currentLetter + "' has already been guessed.\n");
            } else {

                System.out.println("Ouch, the letter '" + currentLetter + "' is NOT in the word!");

                lives -= 1;
                guessedArray.add(currentLetter);
                printResults(secretArray, guessedArray, lives);
            }
        }

        if (lives == 0) {
            System.out.println("The Hangman wins!!");
        } else if (lettersToGuess == 0) {
            System.out.println("The Guessers win!!");
        }

        System.out.println("The secret word is: '" + new String(secret).toUpperCase() + "'\n");
        guessReader.close();
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
