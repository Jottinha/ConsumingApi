package com.alura.imersaojava.extractorapi;

import com.alura.imersaojava.apiclasses.ContentsApi;
import com.alura.imersaojava.connectapi.ConnectClient;
import com.alura.imersaojava.jsonmanipulating.JsonParse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbExtractor implements GlobalExtractor{

    public List<ContentsApi> extractor(String nameApi) {
        String json = new ConnectClient().apiData(nameApi);

        List<ContentsApi> imdbList = new ArrayList<>();
        List<Map<String, String>> contentsMap = new JsonParse().parse(json);

        for (Map<String, String> contents : contentsMap) {
            var newData = new ContentsApi(
                    contents.get("title"), contents.get("image"), contents.get("imDbRating"));
            imdbList.add(newData);
        }
        return imdbList;
    }
}
