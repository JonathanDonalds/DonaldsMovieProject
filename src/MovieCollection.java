import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MovieCollection {
    private static ArrayList<Movie> movies;
    private static Scanner scan;


    public MovieCollection() {
        movies = new ArrayList<>();
        scan = new Scanner(System.in);
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
        ArrayList<String> titles = new ArrayList<>();
        String term;
        System.out.print("Enter a title search term: ");
        term = scan.nextLine();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(term.toLowerCase()) || movie.getTitle().toUpperCase().contains(term.toUpperCase())) {
                titles.add(movie.getTitle());
            }
        }
        if (titles.isEmpty()) {
            System.out.println();
            System.out.println("No movie titles match that search term!");
        } else {
            sort(titles);
            for (int i = 0; i < titles.size(); i++) {
                System.out.println((i + 1) + ". " + titles.get(i));
            }
            System.out.println("Which movie would you like to learn more about?");
            System.out.print("Enter number: ");
            int num = scan.nextInt();
            scan.nextLine();
            System.out.println();
            System.out.println(titles.get(num - 1));
            for (Movie movie : movies) {
                if (movie.getTitle().equals(titles.get(num - 1))) {
                    System.out.println(movie.getInfo());
                }
            }
        }
    }

    public void sort(ArrayList<String> titles) {
        for (int i = 1; i < titles.size(); i++) {
            while (i != 0 && titles.get(i).compareTo(titles.get(i - 1)) < 0) {
                String temp = titles.get(i);
                titles.set(i, titles.get(i - 1));
                titles.set(i - 1, temp);
                i--;
            }
        }
    }

    public void searchCast() {
        ArrayList<String> cast = new ArrayList<>();
        String term;
        System.out.print("Enter a person to search for (first and last name): ");
        term = scan.nextLine();
        for (Movie movie : movies) {
            String str = movie.getCast();
            String[] array = str.split("\\|");
            for (String member : array) {
                if ((member.toLowerCase().contains(term.toLowerCase()) || member.toUpperCase().contains(term.toUpperCase())) && !cast.contains(member)) {
                    cast.add(member);
                }
            }
        }
        if (cast.isEmpty()) {
            System.out.println();
            System.out.println("No results match your search");
        } else {
            sort(cast);
            for (int i = 0; i < cast.size(); i++) {
                System.out.println((i + 1) + ". " + cast.get(i));
            }
            System.out.println("Which would you like to see all movies for?");
            System.out.print("Enter number: ");
            int num = scan.nextInt();
            scan.nextLine();
            ArrayList<String> list = new ArrayList<>();
            for (Movie movie : movies) {
                if (movie.getCast().contains(cast.get(num - 1))) {
                    list.add(movie.getTitle());
                }
            }
            sort(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
            System.out.println("Which movie would you like to learn more about?");
            System.out.print("Enter number: ");
            int number = scan.nextInt();
            scan.nextLine();
            System.out.println();
            for (Movie movie : movies) {
                if (movie.getTitle().equals(list.get(number - 1))) {
                    System.out.println(movie.getInfo());
                }
            }
        }
    }
}