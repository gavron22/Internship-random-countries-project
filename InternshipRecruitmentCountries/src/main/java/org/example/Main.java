package org.example;

import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello! Here are data about random countries.");
        System.out.println("The program shows country name : (capital - population - languages)");
        System.out.println("Countries are ordered by population in a descending order.");
        System.out.println();
        // Check if there is only 1 argument given
        if(args.length != 1) {
            throw new Exception("Please enter 1 argument");
            // Check if the arguments value is between 5 and 20
        }else if (Integer.parseInt(args[0])>20 || Integer.parseInt(args[0])<5) {
            throw new Exception("Arguments value has to be between 5 and 20");
        }else{
            RandomCountries randomCountries = new RandomCountries(args[0]);
            Collections.sort(randomCountries);
            for (Country country : randomCountries) {
                System.out.println(country);
            }
        }
    }
}
