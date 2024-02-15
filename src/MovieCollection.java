import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private static ArrayList<Movie> movies;
    private static ArrayList<String> wordList;
    public MovieCollection() {
        movies = new ArrayList<>();
        wordList = new ArrayList<>();
        start();
    }

    public static void importCSV() {
        try {
            Scanner input = new Scanner(new File("src\\movies_data.csv"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
                /*Movie movie = input.next();
                movies.add(movie);*/
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(wordList);
    }


    public void start() {
        System.out.println("Welcome to the movie collection!");
        importCSV();
    }
}
