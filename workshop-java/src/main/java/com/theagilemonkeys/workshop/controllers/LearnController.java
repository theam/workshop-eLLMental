package com.theagilemonkeys.workshop.controllers;

import com.theagilemonkeys.workshop.services.SemanticSearchService;
import com.theagilemonkeys.workshop.utils.StringSegmentationUtils;
import kotlin.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class LearnController {
    private final SemanticSearchService semanticSearchService;

    @Autowired
    public LearnController(SemanticSearchService semanticSearchService) {
        this.semanticSearchService = semanticSearchService;
    }

    @PostMapping(value = "/learn", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseBody
    public CompletableFuture<Unit> learn(@RequestParam MultipartFile file) throws IOException {
        // TODO: implement the search functionality using the SemanticSearchService
        String fileContent = new String(file.getBytes());
        List<String> chunks = StringSegmentationUtils.segmentByCharacters(fileContent, 2000);
        throw new UnsupportedOperationException("TODO");
    }
}
