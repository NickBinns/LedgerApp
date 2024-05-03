package com.pluralsight;
import java.io.*;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.time.LocalDate;

// Home Screen
public class LedgerApp {
    public static void main(String[] args) throws IOException {
           Scanner userInput = new Scanner(System.in);

            String description = "";
            String vendor = "";
            Integer payment = 0;

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
                    payment = userInput.nextInt();
                    System.out.println("Transaction completed. Thank you");


                } else if (letter.equalsIgnoreCase("P")) {
                    System.out.println("Enter a description for your transaction: ");
                    description = userInput.nextLine();
                    System.out.println("Please enter your name/vendor: ");
                    vendor = userInput.nextLine();
                    System.out.println("How much would you like to pay today? ");
                    payment = userInput.nextInt();
                    System.out.println("Transaction completed. Thank you");

                } else if (letter.equalsIgnoreCase("L")) {
                    DisplayTwo(userInput);

                } else if (letter.equalsIgnoreCase("X")) {
                    System.exit(0);

                } else {
                    System.out.println("Option not valid, please try again");
                }

                try {

                    FileWriter fw = new FileWriter("transactions.csv", true);
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
        public static void DisplayTwo (Scanner userInput){

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
                        FileReader fr = new FileReader("transactions.csv");
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
                        FileReader fr = new FileReader("transactions.csv");
                        BufferedReader br = new BufferedReader(fr);
                        String input;
                        while ((input = br.readLine()) != null) {
                            String[] values = input.split("\\|");
                            System.out.println(values[4]);
                        }
                        br.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (letter2.equalsIgnoreCase("P")) {


                    try {
                        FileReader fr = new FileReader("transactions.csv");
                        BufferedReader br = new BufferedReader(fr);
                        String input;
                        while ((input = br.readLine()) != null) {
                            String[] values = input.split("\\|");
                            System.out.println(values[4]);
                        }
                        br.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (letter2.equalsIgnoreCase("R")) {
                    DisplayThree(userInput);

                } else if (letter2.equalsIgnoreCase("H")) {
                    break;

                } else {
                    System.out.println("Option not valid please try again");
                }

                {


                }
            }

            //Reports Screen
        }

        public static void DisplayThree (Scanner userInput){

            while (true) {

                System.out.println("""
                        1) Month To Date
                        2) Previous Month
                        3) Year To Date
                        4) Previous Year
                        5) Search By Vendor
                        0) Home
                        """);
                System.out.println("Choose a option: ");
                int choice = userInput.nextInt();
                userInput.nextLine();

                if (choice == 1) {

                    try {
                        FileReader fr = new FileReader("transactions.csv");
                        BufferedReader br = new BufferedReader(fr);
                        String input;
                        boolean skipLine = false;

                        while ((input = br.readLine()) != null) {

                            if (!skipLine) {
                                skipLine = true;
                                continue;
                            }

                            String[] values = input.split("\\|");
                            String dateString = values[0];

                            try {
                                LocalDate date = LocalDate.parse(dateString);

                                LocalDate currentDate = LocalDate.now();
                                YearMonth currentYM = YearMonth.from(currentDate);
                                YearMonth entryYM = YearMonth.from(date);

                                if (currentYM.equals(entryYM)) {
                                    System.out.println(input);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        br.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (choice == 2) {

                    try {
                        FileReader fr = new FileReader("transactions.csv");
                        BufferedReader br = new BufferedReader(fr);
                        String input;
                        boolean skipLine = false;

                        while ((input = br.readLine()) != null) {

                            if (!skipLine) {
                                skipLine = true;
                                continue;
                            }

                            String[] values = input.split("\\|");
                            String dateString = values[0];

                            try {
                                LocalDate date = LocalDate.parse(dateString);

                                LocalDate currentDate = LocalDate.now();
                                YearMonth currentYM = YearMonth.from(currentDate);
                                YearMonth previousMonth = currentYM.minusMonths(1);
                                YearMonth entryYM = YearMonth.from(date);

                                if (entryYM.equals(previousMonth)) {
                                    System.out.println(input);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        br.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (choice == 3) {

                    try {
                        FileReader fr = new FileReader("transactions.csv");
                        BufferedReader br = new BufferedReader(fr);
                        String input;
                        boolean skipLine = false;

                        while ((input = br.readLine()) != null) {

                            if (!skipLine) {
                                skipLine = true;
                                continue;
                            }

                            String[] values = input.split("\\|");
                            String dateString = values[0];

                            try {
                                LocalDate date = LocalDate.parse(dateString);

                                int currentYear = Year.now().getValue();
                                int entryYear = date.getYear();

                                if (currentYear == entryYear) {
                                    System.out.println(input);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        br.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (choice == 4) {

                    try {
                        FileReader fr = new FileReader("transactions.csv");
                        BufferedReader br = new BufferedReader(fr);
                        String input;
                        boolean skipLine = false;

                        while ((input = br.readLine()) != null) {

                            if (!skipLine) {
                                skipLine = true;
                                continue;
                            }

                            String[] values = input.split("\\|");
                            String dateString = values[0];

                            try {
                                LocalDate date = LocalDate.parse(dateString);

                                int currentYear = Year.now().getValue();
                                int previousYear = currentYear - 1;
                                int entryYear = date.getYear();

                                if (previousYear == entryYear) {
                                    System.out.println(input);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        br.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (choice == 5) {

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Search for vendor: ");
                    String searchTerm = scanner.nextLine();

                    try {

                        FileReader fr = new FileReader("transactions.csv");
                        BufferedReader br = new BufferedReader(fr);
                        String input;
                        boolean skipLine = false;

                        while ((input = br.readLine()) != null) {

                            if (!skipLine) {
                                skipLine = true;
                                continue;
                            }

                            String[] values = input.split("\\|");

                            for (String value : values) {
                                if (value.contains(searchTerm)) {
                                    System.out.println(input);
                                }
                            }

                        }

                        br.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else if (choice == 0) {
                    break;

                } else {
                   System.out.println("Not a valid option, please try again");

                }
            }
        }
    }














