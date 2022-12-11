package org.example;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  This class is an ArrayList of Country objects.
 *  It gets a random country name, its capital, population and languages from the API.
 */
public class RandomCountries extends ArrayList<Country> {

    private final String numCountries;

    // Regex patterns to find capital, population and languages in the data pulled from an API
    Pattern[] countryInfoPatterns = {Pattern.compile("\42capital\42:\\\133\42(.*?)\42\135"), Pattern.compile("\42population\42:(.*?)\54"),
            Pattern.compile("\42languages\42:\\{(.*?)\175"), Pattern.compile("\42:\42(.*?)\42")};

    // Regex pattern to get country name from random address
    Pattern countryNamePattern = Pattern.compile("\42country\42:\42(.*?)\42");

    /**
     * This constructor creates an ArrayList with given number of Country objects
     *
     * @param numCountries - a number of random countries to find
     * @throws IOException
     */
    public RandomCountries(String numCountries) throws IOException {
        this.numCountries = numCountries;
        getCountryInfo();
    }

    /**
     * This method gets a country name from a random address pulled from the API.
     *
     * @return country name
     * @throws IOException
     */
    public String getRandomCountry() throws IOException {
        String randomAddress = API.getRandomAddress();

        Matcher matcher = countryNamePattern.matcher(randomAddress);
        matcher.find();
        String randomCountryName= matcher.group(1);

        return randomCountryName;
    }

    /**
     * This method checks capital, population and languages for a given number of unique countries.
     * For each country it creates a Country object and adds to RandomCountries object
     *
     * @throws IOException
     */
    public void getCountryInfo() throws IOException {
        String capital = "";
        int population = 0;
        String countryInfo = "";

        Set<String> countriesSet = new HashSet();

        // Repeat until the data for all unique countries are found
        while (countriesSet.size() < Integer.parseInt(this.numCountries)) {
            String languages = "";
            String countryName = getRandomCountry();

            // Check for not unique countries
            if (countriesSet.contains(countryName)) {
                continue;
            }

            // Pull data from the API
            countryInfo = API.getCountryData(countryName);

            // Check for countries with no information
            if (countryInfo == "") {
                countriesSet.add(countryName);
                this.add(new Country(countryName));
                continue;
            }

            // Find capital, population and languages
            for (int i = 0; i < 3; i++) {
                Matcher matcher = countryInfoPatterns[i].matcher(countryInfo);
                matcher.find();
                switch (i) {
                    // find capital
                    case 0 -> {
                        try {
                            capital = matcher.group(1);
                        } catch (IllegalStateException e) {
                            capital = "no capital";
                        }
                    }
                    // find population
                    case 1 -> population = Integer.parseInt(matcher.group(1));
                    // find languages
                    case 2 -> {
                        try {
                            //check for countries with multiple languages
                            if (matcher.group(1).length() > 10) {
                                String[] tmpLanguages = matcher.group(1).split(",");
                                for (int numLanguage = 0; numLanguage < tmpLanguages.length; numLanguage++) {
                                    matcher = countryInfoPatterns[3].matcher(tmpLanguages[numLanguage]);
                                    matcher.find();
                                    if (numLanguage != tmpLanguages.length - 1) {
                                        languages += matcher.group(1) + ",";
                                    } else {
                                        languages += matcher.group(1);
                                    }
                                }
                                // countries with one language
                            } else {
                                languages = matcher.group(1);
                            }
                        } catch (IllegalStateException e) {
                            languages = "no languages";
                        }
                    }
                }
            }
            countriesSet.add(countryName);
            this.add(new Country(capital, countryName, languages, population));
        }

    }
}