package spring;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class TabDelimitedMovieFinder implements MovieFinder{
    public String inputFile;

    public TabDelimitedMovieFinder(String inputFile){
        this.inputFile = inputFile;
    }
    @Override
    public ArrayList<Object> readMoviesFile() {
        ArrayList<Object> movies = new ArrayList<>();
        Path inputPath = Paths.get(this.inputFile);
        try (Scanner scanner = new Scanner(inputPath)) {
            String movie;
            while (scanner.hasNextLine()){
                movie = scanner.nextLine();
                movies.add(movie);
            }
        }catch (IOException err){
            System.out.println("Error reading file: " + err);
        }
        return movies;
    }


}
