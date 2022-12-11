package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * API Class pulls data from APIs
 */
public class API {

    private static final String randomCountryUrl = "https://random-data-api.com/api/v2/addresses";
    private static final String restCountriesUrl = "https://restcountries.com/v3.1/name/";

    public static String getRandomAddress () throws IOException {
        return new Scanner(new URL(randomCountryUrl).openStream(), StandardCharsets.UTF_8).useDelimiter("\\A").next();
    }

    public static String getCountryData (String countryName) throws IOException {
        String countryData = "";

        try {
            countryData = new Scanner(new URL(restCountriesUrl + countryName.replaceAll(" ", "%20")).openStream(), StandardCharsets.UTF_8).useDelimiter("\\A").next();
        }catch (FileNotFoundException | MalformedURLException e){
            try {
                countryData = new Scanner(new URL(restCountriesUrl + countryName.split(" ")[0]).openStream(), StandardCharsets.UTF_8).useDelimiter("\\A").next();
            }catch (FileNotFoundException | MalformedURLException ex){
            }
        }
        return countryData;
    }

}
