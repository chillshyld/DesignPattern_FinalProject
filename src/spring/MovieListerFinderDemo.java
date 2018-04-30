package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MovieListerFinderDemo {
    public static void main(String args[]){
        System.out.println("MovieListerFinder Demo");
        ApplicationContext context= new ClassPathXmlApplicationContext("conf/beans.xml");
        MovieLister theatre = (MovieLister) context.getBean("movieLister");
        TabDelimitedMovieFinder textDB = (TabDelimitedMovieFinder) context.getBean("tabDelimitedMovieFinder");
        DBMovieFinder apiDB = (DBMovieFinder) context.getBean("dbMovieFinder");





        System.out.println("Choose your movies source?");
        System.out.println("1. Text file");
        System.out.println("2. Database file");
        int userChoice = 1;
        while (userChoice != 0){
            Scanner scanner = new Scanner(System.in);
            userChoice = scanner.nextInt();
            if (userChoice == 1){
                System.out.println("textFile");
                theatre.setDBReader(textDB);
            }else if (userChoice == 2){
                theatre.setDBReader(apiDB);
                System.out.println("dbFile");

            }else{
                System.out.println("Wrong input");
            }
            //show movies
            theatre.displayMovies();

            //Pop user want to continue?
            userChoice = 0;
        }







    }

}
