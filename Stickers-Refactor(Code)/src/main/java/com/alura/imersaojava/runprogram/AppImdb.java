package com.alura.imersaojava.runprogram;

import com.alura.imersaojava.extractorapi.ImdbExtractor;

import java.io.InputStream;
import java.net.URL;
public class AppImdb {
    public static void runAppImdb() {

        String apiName = "Imdb";
        var contents = new ImdbExtractor().extractor(apiName);

        for (int i = 0; i < 20; i++) {
            try{
                InputStream url = new URL(contents.get(i).getUrlImage()).openStream();
                String fileName = "Stickers-" + apiName +"/" + contents.get(i).getTitle().replace
                        (":", "-") + ".png";
                String rating = contents.get(i).getImdbRating();
                new com.alura.imersaojava.stickers.Stickers().createStickers(url, fileName, apiName, rating);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        System.out.println("Success " + apiName);
    }
}
