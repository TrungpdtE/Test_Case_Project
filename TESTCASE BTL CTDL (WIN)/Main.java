import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static String MOVIE_DATASET_PATH = "movies.csv";
    public static String USER_DATASET_PATH = "users.csv";
    public static String RATING_DATASET_PATH = "ratings.csv";

    public static String[] REQUIREMENT_OUTPUT_FILES = new String[] {
            "Req1.txt",
            "Req2.txt",
            "Req3.txt",
            "Req4.txt",
            "Req5.txt",
            "Req6.txt",
            "Req7.txt"
    };

    public static void main(String[] args) {
        File f = new File(".\\output");
        if (!f.exists()) {
            f.mkdirs();
        }

        RatingManagement movieManagement = new RatingManagement(MOVIE_DATASET_PATH, RATING_DATASET_PATH,
                USER_DATASET_PATH);
        for (String arg : args) {
            switch (arg) {
                case "1":
                    // requirement 1
                    ArrayList<String> req1 = new ArrayList<>();
                    req1.add(String.valueOf(movieManagement.getMovies().size() + movieManagement.getUsers().size()));
                    req1.add(String.valueOf(movieManagement.getRating().size()));
                    writeFile(REQUIREMENT_OUTPUT_FILES[0], req1);
                    break;
                case "2":
                    // requirement 2
                    ArrayList<Movie> req2 = movieManagement.findMoviesByNameAndMatchRating(1, 5);
                    writeFile(REQUIREMENT_OUTPUT_FILES[1], req2);
                    break;
                case "3":
                    // requirement 3
                    ArrayList<User> req3 = movieManagement.findUsersHavingSameRatingWithUser(1, 1193);
                    writeFile(REQUIREMENT_OUTPUT_FILES[2], req3);
                    break;
                case "4":
                    // requirement 4
                    ArrayList<String> req4 = movieManagement.findMoviesNameHavingSameReputation();
                    writeFile(REQUIREMENT_OUTPUT_FILES[3], req4);
                    break;
                case "5":
                    // requirement 5
                    ArrayList<String> req5 = movieManagement.findMoviesMatchOccupationAndGender("Lawyer", "M", 20, 3);
                    writeFile(REQUIREMENT_OUTPUT_FILES[4], req5);
                    break;
                case "6":
                    // requirement 6
                    ArrayList<String> req6 = movieManagement.findMoviesByOccupationAndLessThanRating("Lawyer", 20, 2);
                    writeFile(REQUIREMENT_OUTPUT_FILES[5], req6);
                    break;
                case "7":
                    // requirement 7
                    ArrayList<String> req7 = movieManagement.findMoviesMatchLatestMovieOf(3, 3, 20);
                    writeFile(REQUIREMENT_OUTPUT_FILES[6], req7);
                    break;
            }
        }
    }

    public static <E> boolean writeFile(String path, ArrayList<E> rows) {
        try {
            FileWriter writer = new FileWriter(path);
            for (E row : rows) {
                writer.write(row.toString());
                writer.write("\r\n");
            }

            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error.");
            return false;
        } catch (Exception e) {
            System.out.println("Cannot write file");
            return false;
        }

        return true;
    }
}