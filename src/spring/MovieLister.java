package spring;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieLister {
    private ArrayList<Object> moviesList;
    private MovieFinder dbReader;

    public void setMoviesList(ArrayList<Object> moviesList) {
        this.moviesList = moviesList;
    }

    public void setDBReader(MovieFinder reader){
        this.dbReader = reader;
    }


    public void displayMovies(){
        this.moviesList = this.dbReader.readMoviesFile();
        System.out.println(this.moviesList);
    }
}














