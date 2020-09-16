package threads;

import dataHandlers.LifeManager;
import dataHandlers.PropertiesHolder;
import util.ListInitializer;

import java.util.ArrayList;
import java.util.List;

public class LifeGiverThread {

    private ListInitializer listInitializer = new ListInitializer();

    public List<List<Boolean>> giveLive(LifeManager lifeManager, PropertiesHolder propertiesHolder) {

        List<List<Boolean>> returnList = new ArrayList<>();

        listInitializer.initListSize(returnList, propertiesHolder);


        for (int y = 0; y < propertiesHolder.getHeight(); y++) {

            //Added ==4 cos lifecycle going loop
            for (int x = 0; x < propertiesHolder.getWidth(); x++) {
                if (!(lifeManager.getXYValue(x, y)) &
                        ((lifeManager.getCountOfAliveAroundXY(x, y) == 3) ||
                                (lifeManager.getCountOfAliveAroundXY(x, y) == 4))) {
                    returnList.get(y).set(x, true);
                }
            }
        }
        return returnList;
    }
}
