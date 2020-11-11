package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int nrRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int nrSeats = scanner.nextInt();
        int totalSeats = nrRows * nrSeats;
        String[][] cinemaRoom = new String[nrRows + 1][nrSeats + 1];
        int countX = 1;
        int countY = 1;
        int totalIncome;

        for (int i = 1; i <= nrRows; i++) {
            for (int j = 1; j <= nrSeats; j++) {
                cinemaRoom[i][j] = "S ";
            }
        }
        cinemaRoom[0][0] = "  ";
        for (int i = 1; i <= nrSeats; i++) {
            cinemaRoom[0][i] = countX + " ";
            countX++;
        }
        for (int i = 1; i <= nrRows; i++) {
            cinemaRoom[i][0] = countY + " ";
            countY++;
        }

        if (totalSeats < 60) {
            totalIncome = totalSeats * 10;
        } else {
            totalIncome = ((nrRows / 2) * 10 + (nrRows/ 2 + 1) * 8 ) * nrSeats;
        }

        action(scanner, nrRows, nrSeats, totalSeats, cinemaRoom, totalIncome);
    }

    private static void action(Scanner scanner, int nrRows, int nrSeats, int totalSeats, String[][] cinemaRoom, int totalIncome) {
        boolean state = true;
        while (state) {
            System.out.println();
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int actionNumber = scanner.nextInt();
            switch (actionNumber) {
                case 1:
                    displayRoom(cinemaRoom);
                    break;
                case 2:
                    calculatePrice(scanner, nrRows, nrSeats, totalSeats, cinemaRoom);
                    break;
                case 3:
                    statistics(nrRows,nrSeats, totalSeats, cinemaRoom, totalIncome);
                    break;
                case 0:
                    state = false;
            }
        }
    }

    private static void calculatePrice(Scanner scanner, int nrRows, int nrSeats, int totalSeats, String[][] cinemaRoom) {
        int price;
        boolean state = true;

        while (state) {
            System.out.println("Enter a row number:");
            int positionRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int positionSeat = scanner.nextInt();

            if (positionRow > nrRows || positionSeat > nrSeats) {
                System.out.println("Wrong input!\n");
                continue;
            }
            if (!cinemaRoom[positionRow][positionSeat].equals("B ")) {
                cinemaRoom[positionRow][positionSeat] = "B ";
            } else {
                System.out.println("That ticket has already been purchased\n");
                continue;
            }
            if (totalSeats < 60) {
                price = 10;
                state = false;
            } else if (positionRow <= nrRows / 2) {
                price = 10;
                state = false;
            } else {
                price = 8;
                state = false;
            }
            System.out.println("Ticket price: $" + price);
        }
    }

    private static void displayRoom(String[][] cinemaRoom) {
        System.out.println("Cinema:");
        for (String[] strings : cinemaRoom) {
            for (int j = 0; j < cinemaRoom[0].length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }

    private static void statistics(int nrRows,int nrSeats, int totalSeats, String[][] cinemaRoom, int totalIncome) {
        double countB = 0;
        double percentage;
        int currentIncome = 0;

        for (int i = 1; i <= nrRows; i++) {
            for (int j = 1; j <= nrSeats; j++) {
                if (cinemaRoom[i][j].equals("B ")){
                    if (i <= nrRows / 2) {
                       currentIncome += 10;
                    } else {
                        currentIncome += 8;
                    }
                    countB++;
                }
            }
        }
        percentage = (countB / totalSeats) * 100;
        countB = (int) countB;
        
        System.out.printf("Number of purchased tickets: %.0f\n", countB);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}