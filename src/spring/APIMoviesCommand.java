package spring;

public class APIMoviesCommand extends MoviesSourceCommand {

    public APIMoviesCommand(MovieLister theatre) {
        this.theatre = theatre;
    }

    @Override
    public void execute(MovieFinder dbSource) {
        this.theatre.setDBReader(dbSource);
        this.theatre.displayMovies();
    }
}
