package spring;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieLister {
    private ArrayList<Movies> moviesList;
    private MovieFinder dbReader;

    public void setMoviesList(ArrayList<Movies> moviesList) {
        this.moviesList = moviesList;
    }

    public void setDBReader(MovieFinder reader){
        this.dbReader = reader;
    }


    public void displayMovies(){
        this.moviesList = this.dbReader.readMoviesFile();
        for (Movies movies : this.moviesList){
            System.out.println("title: " + movies.getTitle());
            System.out.println("description: " + movies.getDescription());
            System.out.println("release_date: " + movies.getReleaseDate());
            System.out.println();
        }
    }
}














