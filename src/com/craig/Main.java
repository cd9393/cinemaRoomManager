package com.craig;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        char[][] cinema = new char[7][8];
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 1; i <= cinema.length; i++) {
            System.out.print(i);
            for (int j = 0; j < cinema[0].length; j++) {
                System.out.print(" " + 'S');
            }
            System.out.println();
        }
    }
}
