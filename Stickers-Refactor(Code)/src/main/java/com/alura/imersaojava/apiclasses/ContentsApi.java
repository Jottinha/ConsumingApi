package com.alura.imersaojava.apiclasses;

public class ContentsApi {

    private String title;
    private String urlImage;
    private String imdbRating;

    public ContentsApi(String title, String urlImage, String imdbRating) {
        this.title = title;
        this.urlImage = urlImage;
        this.imdbRating = imdbRating;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getImdbRating() {
        return imdbRating;
    }
}
