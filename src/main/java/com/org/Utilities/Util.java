package com.org.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Util {

    private static final Logger log = LoggerFactory.getLogger(Util.class);

    /**
     * DataProvider for logIn flow
     * @return login credentials
     */
    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        List<LoginTestData> data = JsonReader.getData();
        assert data != null;
        Object[][] testData = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            testData[i][0] = data.get(i);
        }
        return testData;
    }

    /**
     * Read the configurations from the file
     */
    private static final Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream("src/main/resources/Config.properties");
            properties.load(file);
        } catch (IOException e) {
            log.error("Error in loading the file: {}", e.getMessage(),e);
            throw new RuntimeException("Configuration could not be loaded", e);
        }
    }

    /**
     * Return the properties
     */

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
