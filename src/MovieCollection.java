import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MovieCollection {
    private static ArrayList<Movie> movies;

    public MovieCollection() {
        movies = new ArrayList<>();
        start();
    }

    public static void importCSV() {
        ArrayList<String> title = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("src//movies_data.csv"));
            input.nextLine();
            while (input.hasNext()) {
                String word = input.nextLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(title);
    }


    public void start() {
        System.out.println("Welcome to the movie collection!");
        importCSV();
    }
}