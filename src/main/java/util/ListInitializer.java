package util;

import dataHandlers.PropertiesHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListInitializer {

    public void initListSize(List<List<Boolean>> list, PropertiesHolder propertiesHolder) {

        for (int y = 0; y < propertiesHolder.getHeight(); y++) {
            list.add(y, new ArrayList<Boolean>());
            for (int x = 0; x < propertiesHolder.getWidth(); x++) {
                list.get(y).add(x, new Boolean(false));
            }
        }
    }

    public void initRandXYValues(List<List<Boolean>> list, PropertiesHolder propertiesHolder) {

        Random rand = new Random();

        for (int i = 1; i <= propertiesHolder.getInitAliveCount(); i++) {

            int x = rand.nextInt((propertiesHolder.getWidth()));
            int y = rand.nextInt((propertiesHolder.getHeight()));
            //System.out.println("x= " + x + " y= " + y);
            if (list.get(y).get(x)) {
                i--;
            } else {
                list.get(y).set(x, true);
            }
        }
    }
}
