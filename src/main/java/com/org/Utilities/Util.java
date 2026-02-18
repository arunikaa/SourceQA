package com.org.Utilities;

import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class Util {

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
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream("src/main/resources/Config.properties");
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Return the properties
      */

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
