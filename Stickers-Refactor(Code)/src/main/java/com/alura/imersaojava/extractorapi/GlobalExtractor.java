package com.alura.imersaojava.extractorapi;

import com.alura.imersaojava.apiclasses.ContentsApi;

import java.util.List;

public interface GlobalExtractor {
    List<ContentsApi> extractor(String nameApi);
}
