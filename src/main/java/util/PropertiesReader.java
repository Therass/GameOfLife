package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    Properties properties;

    public PropertiesReader() {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("properties.properties")) {

            properties = new Properties();

            properties.load(inputStream);


            if ((Integer.parseInt(properties.getProperty("width")) * Integer.parseInt(properties.getProperty("height"))) < Integer.parseInt(properties.getProperty("initAliveCount"))) {
                throw new Exception("Initial alive count is more than height multiply by width");
            }

        } catch (IOException | NullPointerException exception) {
            exception.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public int returnWidthProperty(){
        return Integer.parseInt(properties.getProperty("width"));
    }

    public int returnHeightProperty(){
        return Integer.parseInt(properties.getProperty("height"));
    }

    public int returnInitAliveCountProperty(){
        return Integer.parseInt(properties.getProperty("initAliveCount"));
    }
}