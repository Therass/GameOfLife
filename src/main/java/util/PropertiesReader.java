package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

//    TODO why not private?
    Properties properties;

//    TODO do you use IDEA auto codestyle ? This looks not great , to many "/n"
    public PropertiesReader() {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("properties.properties")) {

            properties = new Properties();

            properties.load(inputStream);

//TODO again code style , one line can't be wider then 120 chars
            if ((Integer.parseInt(properties.getProperty("width")) * Integer.parseInt(properties.getProperty("height"))) < Integer.parseInt(properties.getProperty("initAliveCount"))) {
                throw new Exception("Initial alive count is more than height multiply by width");
            }
//TODO think about logs, it's about time to try it
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