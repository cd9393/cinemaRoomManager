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
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int chosenMenu = scanner.nextInt();

            switch (chosenMenu) {
                case 0:
                    running = false;
                    break;
                case 1:
                    printCinema(cinema);
                    break;
                case 2:
                    buyATicket(cinema);
                    break;
                case 3:
                    showStatistics(cinema, numberOfSeats);
                    break;
                default:
                    running = false;
                    break;
            }

        }

    }

    public static void showStatistics(char[][] cinema, int numberOfSeats) {
        int numberOfSoldTickets = findSoldTickets(cinema);
        percentageSold(numberOfSoldTickets,numberOfSeats);
        currentIncome(cinema);
        totalIncome(cinema);
    }

    public static void percentageSold(int numberOfSoldTickets, int numberOfSeats) {
        float percentageOfSold = numberOfSoldTickets / numberOfSeats * 100;
        System.out.println("Number of purchased tickets: " + numberOfSoldTickets);
        System.out.print("Percentage: ");
        System.out.printf("%.2f", percentageOfSold);
        System.out.print("%");
        System.out.println();
    }

    public static void currentIncome(char[][] cinema) {
        int currentIncome = 0;
        int numberOfSeats = cinema.length * cinema[0].length;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (cinema[i][j] == 'B') {
                    if (i <= cinema.length / 2 || numberOfSeats <= 60) {
                        currentIncome += 10;
                    } else {
                        currentIncome += 8;
                    }
                }
            }
        }
        System.out.println("Current income: $" + currentIncome);
    }

    public static void totalIncome(char[][] cinema) {
        int numberOfRows = cinema.length;
        int totalIncome = 0;
        if (cinema.length * cinema[0].length < 60) {
            totalIncome = cinema.length * cinema[0].length * 10;
        } else {
            for (int i = 0; i < cinema.length; i++) {
                for (int j = 0; j < cinema[i].length; j++) {
                    if (i < (cinema.length / 2)) {
                        totalIncome += 10;
                    } else {
                        totalIncome += 8;
                    }
                }
            }
        }
        System.out.println("Total income: $" + totalIncome);
    }

    public static int findSoldTickets(char[][] cinema) {
        int numberOfSoldTickets = 0;
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                if (cinema[i][j] == 'B') {
                    numberOfSoldTickets++;
                }
            }
        }
        return numberOfSoldTickets;
    }

    public static void buyATicket(char[][] cinema) {
        boolean seatChosen = false;
        while (!seatChosen) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a row number:");
            int rowNumber = scanner.nextInt();

            System.out.println("Enter a seat number in that row:");
            int seatNumber = scanner.nextInt();

            if ((rowNumber > cinema.length || rowNumber < 0) || (seatNumber > cinema[0].length || seatNumber < 0)) {
                System.out.println("Wrong input!");
            } else {
                if (cinema[rowNumber - 1][seatNumber - 1] == 'B') {
                    System.out.println("That ticket has already been purchased!");
                } else {
                    printTicketPrice(cinema.length * cinema[0].length, cinema.length, rowNumber);
                    cinema[rowNumber - 1][seatNumber - 1] = 'B';
                    seatChosen = true;
                    break;
                }
            }
        }
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

    public static void populateCinema(char[][] cinema) {

        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[0].length; j++) {
                cinema[i][j] = 'S';
            }
        }
    }

    public static void printCinema(char[][] cinema) {
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
