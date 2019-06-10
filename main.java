import java.util.Scanner;
import java.util.ArrayList;


class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("*** Welcome to HANGMAN! ***");
        System.out.println("Hangman, what is your word?");

        String secret = reader.nextLine().toUpperCase();
        System.out.println("\n\n");

        ArrayList<Character> secretArray = new ArrayList<>();
        for (char secretLetter : secret.toCharArray()) {
            secretArray.add(secretLetter);
        }

        ArrayList<Character> guessedArray = new ArrayList<>();

        // This counts only the UNIQUE letters in the secret word
        int lettersToGuess = (int) secretArray.stream().distinct().count();
        int lives = 5;
        char currentLetter;
        while (lives > 0 && lettersToGuess > 0) {

            System.out.println("Guessers, what is your letter?");
            currentLetter = reader.nextLine().toUpperCase().charAt(0);

            if (secretArray.contains(currentLetter) && !guessedArray.contains(currentLetter)) {

                System.out.println("Congrats, the letter '" + currentLetter + "' is in the word!");

                lettersToGuess -= 1;
                guessedArray.add(currentLetter);
                printResults(secretArray, guessedArray);
            }

            else if (guessedArray.contains(currentLetter)) {

                System.out.println("Try again; the letter '" + currentLetter + "' has already been guessed.\n");
            }

            else {

                System.out.println("Ouch, the letter '" + currentLetter + "' is NOT in the word!");

                lives -= 1;
                guessedArray.add(currentLetter);
                printResults(secretArray, guessedArray);
            }
        }

        if (lives == 0) {
            System.out.println("The Hangman wins!!");
        }
        else if (lettersToGuess == 0) {
            System.out.println("The Guessers win!!");
        }

        System.out.println("The secret word is: '" + secret + "'\n");
        reader.close();

    }

    private static void printResults(ArrayList<Character> secretArray, ArrayList<Character> guessedArray) {
        for (char secretLetter : secretArray) {

            if (guessedArray.contains(secretLetter)) {
                System.out.print(secretLetter + " ");
            }
            else {
                System.out.print("_ ");
            }
        }

        System.out.println("\n");
    }
}
