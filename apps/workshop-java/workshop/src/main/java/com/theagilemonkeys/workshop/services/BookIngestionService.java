package com.theagilemonkeys.workshop.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class BookIngestionService {

    private final String file_path;
    public BookIngestionService (String file_path) {
        this.file_path = file_path;
    }

    /**
     * This function reads a book (file) and splits its content into chunks of 1000 characters or less.
     * Each chunk is added to a list which is then returned as output.
     * If the book (file) cannot be read due to an IOException, the stack trace of the exception is printed and an empty list is returned.
     */
    public List<String> ProcessBookByCharacters() {
        List<String> chunks = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(new File(this.file_path).toPath()));
            int index = 0;
            while (index < content.length()) {
                chunks.add(content.substring(index, Math.min(index + 1000, content.length())));
                index += 1000;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return chunks;
    }

}
