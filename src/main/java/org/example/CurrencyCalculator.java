package org.example;

import java.util.Scanner;

public class CurrencyCalculator {



    public void run(){
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        double indicator = 1;


        while (running) {
            System.out.println("which currency do you want to use?\n (USD, CHF, EUR)");
            String currency = scanner.nextLine();

            boolean currencyBoolean = true;
            while(currencyBoolean){


                switch (currency.toLowerCase()) {
                    case "chf" -> {
                        indicator = 0.91;
                        currencyBoolean = false;
                    }
                    case "eur" -> {
                        indicator = 0.93;
                        currencyBoolean = false;
                    }
                    case "usd" -> currencyBoolean = false;
                    default -> {
                        System.out.println("Currency not supported please try again.");
                        System.out.println("which currency do you want to use?\n (USD, CHF, EUR)");
                        currency = scanner.nextLine();
                    }
                }
            }

            System.out.println("This shoe costs ???? " + currency.toUpperCase());
            double price = scanner.nextDouble();
            System.out.println("Transport and customs costs are:");
            double customs = scanner.nextDouble();

            boolean calculating = true;
            while(calculating) {

                System.out.println("Which currency do you want to transfer it to?\n (USD, CHF, EUR)");

                String transferringCurrency = scanner.nextLine();


                switch (transferringCurrency.toLowerCase()) {
                    case "chf" -> {
                        System.out.println((Math.round(((price + customs) * indicator)*0.91 * 1000)) /1000);
                        calculating = false;
                    }
                    case "eur" -> {
                        System.out.println((Math.round(((price + customs) * indicator)*0.93 * 1000)) /1000);
                        calculating = false;
                    }
                    case "usd" -> {
                        System.out.println((Math.round(((price + customs) * indicator) * 1000)) /1000);
                        calculating = false;
                    }
                    default -> {
                        System.out.println("invalid please try again");
                    }
                }
            }

            System.out.println("do you want to calculate again? [Y]\\[N]");
            String recalculation = scanner.nextLine();
            if (recalculation.equals("N")){
                running = false;
            }

        }

    }

}
