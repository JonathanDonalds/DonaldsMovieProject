import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private static ArrayList<Movie> movies;
    private static ArrayList<String> titles;
    private static Scanner scan;


    public MovieCollection() {
        movies = new ArrayList<>();
        scan = new Scanner(System.in);
        titles = new ArrayList<>();
        start();
    }

    public static void importCSV() {
        try {
            Scanner input = new Scanner(new File("src//movies_data.csv"));
            input.nextLine();
            movies = new ArrayList<>();
            while (input.hasNext()) {
                String line = input.nextLine();
                String title = line.split(",")[0];
                String cast = line.split(",")[1];
                String director = line.split(",")[2];
                String overview = line.split(",")[3];
                String runtime = line.split(",")[4];
                String userRating = line.split(",")[5];
                movies.add(new Movie(title, cast, director, overview, runtime, userRating));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void start() {
        scan = new Scanner(System.in);
        System.out.println("Welcome to the movie collection!");
        importCSV();
        String menuOption = "";

        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = scan.nextLine();

            if (menuOption.equals("t")) {
                searchTitles();
            } else if (menuOption.equals("c")) {
                searchCast();
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    public void searchTitles() {
        String term = "";
        System.out.print("Enter a title search term: ");
        term = scan.nextLine();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().contains(term)) {
                titles.add(movies.get(i).getTitle());
            }
        }
        sort(titles);
    }

    public void sort(ArrayList<String> titles) {

    }

    public void searchCast() {

    }
}