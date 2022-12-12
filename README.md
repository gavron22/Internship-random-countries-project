# Internship-random-countries-project
A program in Java that returns data about random countries.


Hello and welcome to my program!


The program finds 5-20 random countries and presents their capital, population and languages.

You can run the program from terminal on Mac or command line on Windows.



# Download

You can download the program from my repository: Internship-random-countries-project.


Go to my GitHub: https://github.com/gavron22

Click on repositories at the top of the page.

Then click on the project’s name: Internship-random-countries-project.

Click on the green button “Code” at the top of the page and choose “Download ZIP”.

  

# Setup

  

Before you run the program, make sure you have the necessary tools set on your machine:

  

- JDK

- Maven

- Environmental variables JAVA_HOME and MAVEN_HOME

  

If you’re not sure, you can type in the command: `java -version` in the terminal/cmd.

You’ll also need Maven, again you can check it by typing the command: `mvn -version`

  

If you already have Java the terminal will show information about its version.

If nothing shows up on the terminal you have to install it.

  

Here are the links to download JDK and Maven with an installation tutorials:

https://www.oracle.com/java/technologies/downloads/
https://maven.apache.org/download.cgi

  

> - if you use Windows or Linux, see [here](https://developers.arcgis.com/enterprise-sdk/guide/java/install-java-and-maven/)

  

> - if you use MacOS, see [here](https://www.digitalocean.com/community/tutorials/install-maven-mac-os)

  

  

# Compiling the project

  

First, in order to get the `*.jar` file, you need to build the project.

Open the terminal / command line and go the folder containing the project. (InternshipRecruitmentCountries)

Use this command to change the directory:

`cd [path]`

After you make sure that you are in the right directory, build the project by executing this command:

  

`mvn package`

  

After a successful build there should be a new `*.jar` file in the `target` folder.

  

  

# Running the project

  

Then, change directory to target folder and start the project. You can choose 5-20 countries by passing `x` parameter at the end of the command . Start the program by running this formula:

  

`java -cp [*.jar file_name] org.example.Main [x]`

  

Where: `[*.jar]` is a name of the .jar file created during build and  `[x]` is an integer between 5 and 20.

  

The example command should look like:

`java -cp InternshipRecruitmentCountries-1.0-SNAPSHOT.jar org.example.Main 5`

  

The program will present a given number of countries with their capital, population and languages.
Have fun exploring!
