package spring;

public class TextDBCommand extends MoviesSourceCommand {

    public TextDBCommand(MovieLister theatre) {
        this.theatre = theatre;
    }

    @Override
    public void execute(MovieFinder dbSource) {
        theatre.setDBReader(dbSource);
        theatre.displayMovies();
    }
}
