package com.theagilemonkeys.workshop.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookIngestionService {

    /**
     * This function reads a book (file) and splits its content into chunks of 1000 characters or fewer.
     * Each chunk is added to a list which is then returned as output.
     * If the book (file) cannot be read due to an IOException, the stack trace of the exception is printed and an empty list is returned.
     */
    public static List<String> processBookByCharacters(String filePath) {
        List<String> chunks = new ArrayList<>();

        try {
            File file = new File(filePath);
            String content = new String(Files.readAllBytes(file.toPath()));
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
