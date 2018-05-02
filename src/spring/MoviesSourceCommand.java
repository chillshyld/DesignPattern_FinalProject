package spring;

public abstract class  MoviesSourceCommand {
    protected MovieLister theatre;
    public abstract void execute(MovieFinder dbSource);
}
