package com.org.Utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JsonReader {
    public static List<LoginTestData> getData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(
                    new File("src/main/resources/TestData.json"),
                    new TypeReference<>() {
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
