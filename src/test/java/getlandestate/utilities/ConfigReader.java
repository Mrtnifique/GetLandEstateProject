package getlandestate.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String key) {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }


}
