import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private static ArrayList<Movie> movies;
    public MovieCollection() {
        movies = new ArrayList<>();
        start();
    }

    public static void importCSV() {
        try {
            Scanner input = new Scanner(new File("src\\words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void start() {
        System.out.println("Welcome to the movie collection!");
        importCSV();
    }
}
