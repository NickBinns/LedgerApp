package com.pluralsight;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;

// Home Screen
public class LedgerApp {
    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);

        String description = "";
        String vendor = "";
        String payment = "";

        while (true) {

            System.out.println("""
                     D) Add Deposit
                     P) Make Payment
                     L) Ledger
                     X) Exit
                    """);
            System.out.print("Welcome user, please enter a letter to select a option: ");
            String letter = userInput.next();
            userInput.nextLine();

            if (letter.equalsIgnoreCase("D")) {
                System.out.println("Enter a description for your transaction: ");
                description = userInput.nextLine();
                System.out.println("Please enter your name/vendor");
                vendor = userInput.nextLine();
                System.out.println("How much would you like to deposit today? ");
                payment = userInput.nextLine();
                System.out.println("Transaction completed. Thank you");


            } else if (letter.equalsIgnoreCase("P")) {
                System.out.println("Enter a description for your transaction: ");
                description = userInput.nextLine();
                System.out.println("Please enter your name/vendor: ");
                vendor = userInput.nextLine();
                System.out.println("How much would you like to pay today? ");
                payment = userInput.nextLine();
                System.out.println("Transaction completed. Thank you");

            } else if (letter.equalsIgnoreCase("L")) {
                DisplayTwo(userInput);

            } else if (letter.equalsIgnoreCase("X")) {
                System.exit(0);

            } else {
                System.out.println("Option not valid, please try again");
            }

            try {

                FileWriter fw = new FileWriter("transactions2.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd" + "|" + "HH:mm:ss");
                String time = LocalDateTime.now().format(formatter);

                bw.write(time + "|" + description + "|" + vendor + "|" + payment);
                bw.newLine();
                bw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    // Ledger Screen
    public static void DisplayTwo(Scanner userInput) {

        while (true) {

            System.out.print("""
                    A) All
                    D) Deposits
                    P) Payments
                    R) Reports
                    H) Home
                    """);
            System.out.print("Choose a option: ");
            String letter2 = userInput.next();
            userInput.nextLine();

            if (letter2.equalsIgnoreCase("A")) {

                try {
                    FileReader fr = new FileReader("transactions2.csv");
                    BufferedReader br = new BufferedReader(fr);
                    String input;
                    while ((input = br.readLine()) != null) {
                        System.out.println(input);
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (letter2.equalsIgnoreCase("D")) {

                try {
                    FileReader fr = new FileReader("transactions2.csv");
                    BufferedReader br = new BufferedReader(fr);
                    String input;
                    while ((input = br.readLine()) != null) {
                        String[] values = input.split(",");
                    System.out.println(values[4]);
                    }
                    br.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            {


            }
        }
    }
}










