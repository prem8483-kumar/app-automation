package co.huru.configs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvConfig {

    public static Properties properties;

    static
    {
        String fileName = System.getenv("env") == null ? "env.properties" : System.getenv("env") + ".properties";

        properties = new Properties();
        InputStream inputStream = EnvConfig.class.getClassLoader().getResourceAsStream(fileName);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  String getProperty(String key) {
        return properties.getProperty(key);
    }
}
