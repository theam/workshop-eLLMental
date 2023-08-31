package com.theagilemonkeys.workshop.utils;

import java.util.ArrayList;
import java.util.List;

public class StringSegmentationUtils {

    /**
     * Splits a string into chunks of a given size.
     *
     * @param str          The string to split.
     * @param maxChunkSize The maximum size of each chunk.
     * @return A list of strings, each one representing a chunk of the original string.
     */
    public static List<String> segmentByCharacters(String str, int maxChunkSize) {
        List<String> chunks = new ArrayList<>();

        for (int index = 0; index < str.length(); index += maxChunkSize) {
            int chunkSize = Math.min(index + maxChunkSize, str.length());
            String nextChunk = str.substring(index, chunkSize);
            chunks.add(nextChunk);
        }

        return chunks;
    }
}
