package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieListerFinderDemo {
    public static void main(String args[]){
        System.out.println("MovieListerFinder Demo");
        ApplicationContext context= new ClassPathXmlApplicationContext("conf/beans.xml");
        MovieLister theatre = (MovieLister) context.getBean("movieLister");
        theatre.displayMovies();




    }

}
