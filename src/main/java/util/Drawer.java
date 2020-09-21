package util;

import dataHandlers.LifeManager;
import dataHandlers.PropertiesHolder;

import java.util.List;

public class Drawer {

    public void drawLifeList(LifeManager lifeManager, PropertiesHolder propertiesHolder) {

        for (int y = (propertiesHolder.getHeight() - 1); y >= 0; y--) {
            for (int x = 0; x < propertiesHolder.getWidth(); x++) {
                if (lifeManager.getXYValue(x, y)) {
//                   TODO this is "magic" variable, move it to class variable and give a name
                    System.out.print("\u25A0");
                } else System.out.print("\u25A1");
            }
            System.out.println("");
        }
    }

    public void drawList(List<List<Boolean>> list, PropertiesHolder propertiesHolder) {

        for (int y = (propertiesHolder.getHeight() - 1); y >= 0; y--) {
            for (int x = 0; x < propertiesHolder.getWidth(); x++) {
                if (list.get(y).get(x)) {
                    System.out.print("\u25A0");
                } else System.out.print("\u25A1");
            }
            System.out.println("");
        }
    }
}
