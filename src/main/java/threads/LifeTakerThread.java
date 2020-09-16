package threads;

import dataHandlers.LifeManager;
import dataHandlers.PropertiesHolder;
import util.ListInitializer;

import java.util.ArrayList;
import java.util.List;

public class LifeTakerThread {

    private ListInitializer listInitializer = new ListInitializer();

    public List<List<Boolean>> takeLive(LifeManager lifeManager, PropertiesHolder propertiesHolder) {

        List<List<Boolean>> returnList = new ArrayList<>();

        listInitializer.initListSize(returnList, propertiesHolder);

        for (int y = 0; y < propertiesHolder.getHeight(); y++) {

            for (int x = 0; x < propertiesHolder.getWidth(); x++) {
                if (lifeManager.getXYValue(x, y) == true) {
                    returnList.get(y).set(x, true);
                }
                if ((lifeManager.getXYValue(x, y) == true) &&
                        ((lifeManager.getCountOfAliveAroundXY(x, y) < 2) |
                                (lifeManager.getCountOfAliveAroundXY(x, y) > 4))) {
                    returnList.get(y).set(x, false);
                }
            }
        }
        return returnList;
    }

}
