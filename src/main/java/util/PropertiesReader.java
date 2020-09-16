package util;

import dataHandlers.PropertiesHolder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public void setPropertiesToHolder(PropertiesHolder propertiesHolder) {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("properties.properties")) {

            Properties properties = new Properties();

            properties.load(inputStream);

            propertiesHolder.setWidth(Integer.parseInt(properties.getProperty("width")));
            propertiesHolder.setHeight(Integer.parseInt(properties.getProperty("height")));
            propertiesHolder.setInitAliveCount(Integer.parseInt(properties.getProperty("initAliveCount")));

            if ((propertiesHolder.getWidth() * propertiesHolder.getHeight()) < propertiesHolder.getInitAliveCount()) {
                throw new Exception("Initial alive count is more than height multiply by width");
            }

        } catch (IOException | NullPointerException exception) {
            exception.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}