
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final private int BOTTOM_BORDER = 0;
    static final private int TOP_BORDER = 20;
    static final private String EXIT_SYMBOL = "q";

    public static void main(String[] args) {
        play();
    }

    private static int newGame() {
        Random random = new Random();
        int newMagicNumber = random.nextInt(TOP_BORDER) + 1;
        //    System.out.println("==================    " + newMagicNumber + "    =====================");
        System.out.println("==================     The new game is started!    ==================");
        System.out.println("Guess the number from " + BOTTOM_BORDER + " to " + TOP_BORDER);
        System.out.println("Input 'q' for exit.");
        return newMagicNumber;
    }

    private static void play() {
        Scanner scanner = new Scanner(System.in);
        int magicNumber = newGame();
        int attemptCount = 0;
        while (true) {
            String input = scanner.next();
            if (isExit(input)) {
                finish(magicNumber);
                return;
            }
            attemptCount++;
            if (isGuessNumber(magicNumber, Integer.parseInt(input))) {
                System.out.println("Congrats! You guess from " + attemptCount + " attempt!!!");
                magicNumber = newGame();
                attemptCount = 0;
            }
        }
    }

    private static void finish(int magicNumber) {
        System.out.println("Magic number is " + magicNumber);
        System.out.println("Game over! Bye!");
    }

    private static boolean isGuessNumber(int magicNumber, int userInput) {
        if (userInput > magicNumber) {
            System.out.println("Your number is more then magic number. Try again!");
            return false;
        }
        if (userInput < magicNumber) {
            System.out.println("Your number is less then magic number. Try again!");
            return false;
        }
        return true;
    }

    private static boolean isExit(String userInput) {
        return userInput.equals(EXIT_SYMBOL);
    }

}
