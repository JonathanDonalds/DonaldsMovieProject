public record Movie(String title, String cast, String director, String overview, String runtime, String userRating) {

    public String getInfo() {
        String info = "\n";
        info += "Title: " + title + "\n";
        info += "Runtime: " + runtime + " minutes\n";
        info += "Directed by: " + director + "\n";
        info += "Cast: " + cast + "\n";
        info += "Overview: " + overview + "\n";
        info += "User rating: " + userRating;
        return info;
    }

}