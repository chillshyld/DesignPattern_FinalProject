package spring;

public class Movies {
    private String title;
    private String description;
    private String releaseDate;

    public Movies(String title, String description, String releaseDate) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
