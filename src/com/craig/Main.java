package com.craig;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInARow = scanner.nextInt();
        int numberOfSeats = seatsInARow * numberOfRows;

        char[][] cinema = new char[numberOfRows][seatsInARow];
        populateCinema(cinema);

        boolean running = true;
        while (running) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            int chosenMenu = scanner.nextInt();

            switch (chosenMenu) {
                case 1:
                    printCinema(cinema);
                    break;
                case 2:
                    buyATicket(cinema);
                    break;
                default:
                    running=false;
                    break;
            }

        }

    }

    public static void buyATicket(char[][]cinema) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        printTicketPrice(cinema.length * cinema[0].length,cinema.length,rowNumber);
        cinema[rowNumber - 1][seatNumber - 1] = 'B';
    }

    public static void printTicketPrice(int numberOfSeats, int numberOfRows, int rowNumber) {
        if (numberOfSeats <= 60) {
            System.out.println("Ticket price: $" + 10);
        } else if (rowNumber <= numberOfRows / 2) {
            System.out.println("Ticket price: $" + 10);
        } else {
            System.out.println("Ticket price: $" + 8);
        }
    }

    public static void populateCinema(char[][]cinema) {

        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[0].length; j++) {
                cinema[i][j] = 'S';
            }
        }
    }

    public static void printCinema(char[][]cinema) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= cinema[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < cinema.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cinema[0].length; j++) {
                System.out.print(" " + cinema[i][j]);
            }
            System.out.println();
        }
    }
}
