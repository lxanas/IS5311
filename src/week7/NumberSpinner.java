package week7;

import java.util.Random;


import java.util.Random;

import java.util.Random;

public class NumberSpinner {

    private static final String[] NUMBERS = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String SEPARATOR = "-";
    private static final int SPINNER_SIZE = 8;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        int rotationTime = Integer.parseInt("5000");
        int selectedIndex = RANDOM.nextInt(NUMBERS.length);

        int offset = SPINNER_SIZE / 2;
        int selectedOffset = (NUMBERS.length - selectedIndex + offset) % NUMBERS.length;
        int difference = offset - selectedOffset;

        String spinner = getSpinner(selectedIndex, offset);
        System.out.printf("\r"+spinner);

        Thread.sleep(500);

        for (int i = 0; i < SPINNER_SIZE; i++) {
            int index = (i + selectedIndex - offset + NUMBERS.length) % NUMBERS.length;
            spinner = getSpinner(index, offset, difference);
            System.out.printf("\r"+spinner);
            Thread.sleep(rotationTime / SPINNER_SIZE);
        }

        System.out.println("Selected Number: " + NUMBERS[selectedIndex]);
    }

    private static String getSpinner(int selectedIndex, int offset) {
        StringBuilder builder = new StringBuilder();
        builder.append("|");
        for (int i = 0; i < SPINNER_SIZE; i++) {
            int index = (i + selectedIndex - offset + NUMBERS.length) % NUMBERS.length;
            if (i == offset) {
                builder.append("[").append(NUMBERS[index]).append("]");
            } else {
                builder.append(NUMBERS[index]);
            }

            if (i != SPINNER_SIZE - 1) {
                builder.append(SEPARATOR);
            }
        }
        builder.append("|");
        return builder.toString();
    }

    private static String getSpinner(int index, int offset, int difference) {
        StringBuilder builder = new StringBuilder();
        builder.append("|");
        for (int i = 0; i < SPINNER_SIZE; i++) {
            int currentIndex = (index + i - offset + NUMBERS.length) % NUMBERS.length;
            if (i == offset) {
                builder.append("[").append(NUMBERS[currentIndex]).append("]");
            } else {
                builder.append(NUMBERS[currentIndex]);
            }

            if (i != SPINNER_SIZE - 1) {
                builder.append(SEPARATOR);
            }
        }
        builder.append("|");
        return builder.toString();
    }
}




