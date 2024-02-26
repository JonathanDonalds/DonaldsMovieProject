public class Movie {
    private final String title;
    private final String cast;
    private final String director;
    private final String overview;
    private final String runtime;
    private final String userRating;

    public Movie(String title, String cast, String director, String overview, String runtime, String userRating) {
        this.title = title;
        this.cast = cast;
        this.director = director;
        this.overview = overview;
        this.runtime = runtime;
        this.userRating = userRating;
    }

    public String getTitle() {
        return title;
    }

    public String getCast() {
        return cast;
    }

    public String getDirector() {
        return director;
    }

    public String getOverview() {
        return overview;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getUserRating() {
        return userRating;
    }

    public String getInfo() {
        String info = "";
        info += "Title: " + title + "\n";
        info += "Runtime: " + runtime + " minutes\n";
        info += "Directed by: " + director + "\n";
        info += "Cast: " + cast + "\n";
        info += "Overview: " + overview + "\n";
        info += "User rating: " + userRating;
        return info;
    }

}