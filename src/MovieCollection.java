import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<String> title = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("src//movies_data.csv"));
            input.nextLine();
            while (input.hasNext()) {
                String word = input.nextLine();
                wordList.add(word);
                /*Movie movie = input.next();
                movies.add(movie);*/
            }
            /*title = new ArrayList<>();
            for (int i = 0; i < wordList.size(); i++) {
                title.add(wordList.get(i).substring(0, wordList.get(i).indexOf(",")));
            }*/

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