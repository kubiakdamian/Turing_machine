package pl.qbsapps;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TuringMachine turingMachine = new TuringMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String number;
            number = scanner.nextLine();
            number = number.replaceAll("\\s+", "");

            turingMachine.increaseBinaryNumberBy3(number);
        }
    }
}
