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




        int userChoice = 1;
        while (userChoice != 0){
            System.out.println("Choose your movies source?");
            System.out.println("1. Text file");
            System.out.println("2. Database file");
            System.out.println("3. Exit");

            Scanner scanner = new Scanner(System.in);
            userChoice = scanner.nextInt();
            switch (userChoice){
                case 1:
                    theatre.setDBReader(textDB);
                    break;
                case 2:
                    theatre.setDBReader(apiDB);
                    break;
                case 3:
                    userChoice = 0;
                    break;
                default:
                    System.out.println("Wrong Input please try again");
                    userChoice = scanner.nextInt();
                    break;

            }
            if (userChoice != 0)
                //show movies
                theatre.displayMovies();

        }
        System.out.println("Thank you");
    }

}
