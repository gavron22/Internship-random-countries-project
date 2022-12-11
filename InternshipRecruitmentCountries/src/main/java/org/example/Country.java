package org.example;

public class Country  implements Comparable<Country> {
    private final String countryName;
    private final String capital;
    private final String languages;
    private final int population;

    public Country (String countryName){
        this.countryName = countryName;
        this.capital = "";
        this.languages = "";
        this.population = 0;
    }

    public Country(String capital,String countryName, String languages, int population){
        this.capital = capital;
        this.countryName = countryName;
        this.languages = languages;
        this.population = population;
    }

    public String toString(){
        String result;
        if (this.capital == "" && this.languages == "" && this.population == 0){
            result = "Country: "+countryName+" - "+"No information found!";
        }else {
            result = "Country: " + countryName + " - " + "(" + capital + "-" + population + "-" + languages + ")";
        }
        return result;
    }

    @Override
    public int compareTo(Country o) {
        return population-o.population == 0 ? 0 : o.population-population;
    }
}
