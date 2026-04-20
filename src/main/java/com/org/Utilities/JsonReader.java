package com.org.Utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class JsonReader {
    private static final Logger logger = LoggerFactory.getLogger(JsonReader.class);
    public static List<LoginTestData> getData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(
                    new File("src/main/resources/TestData.json"),
                    new TypeReference<>() {
                    }
            );
        } catch (IOException e) {
            logger.error("Unable to read the file:{}", e.getMessage(),e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
