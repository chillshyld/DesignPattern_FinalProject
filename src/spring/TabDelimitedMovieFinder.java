package spring;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TabDelimitedMovieFinder implements MovieFinder{
    public String inputFile;

    public TabDelimitedMovieFinder(String inputFile){
        this.inputFile = inputFile;
    }
    @Override
    public ArrayList<Movies> readMoviesFile() {
        ArrayList<Movies> moviesList = new ArrayList<Movies>();
        Path inputPath = Paths.get(this.inputFile);

        try (Scanner scanner = new Scanner(inputPath)) {
            String moviesTitle;
            String moviesDesription;
            String moviesReleaseDate;
            String line;
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line,",");
                moviesTitle = tokenizer.nextToken();
                moviesDesription = tokenizer.nextToken();
                moviesReleaseDate = tokenizer.nextToken();
                moviesList.add(new Movies(moviesTitle,moviesDesription,moviesReleaseDate));
            }
        }catch (IOException err){
            System.out.println("Error reading file: " + err);
        }
        return moviesList;
    }


}
