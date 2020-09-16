package dataHandlers;

import org.junit.Before;
import org.junit.Test;
import util.ListInitializer;
import util.PropertiesReader;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LifeManagerTest {

    PropertiesHolder propertiesHolder;
    PropertiesReader propertiesReader;
    LifeManager lifeManager;

    @Before
    public void setUp() throws Exception {

        propertiesReader = new PropertiesReader();
        propertiesHolder = new PropertiesHolder();
        propertiesReader.setPropertiesToHolder(propertiesHolder);

        lifeManager = new LifeManager(propertiesHolder);

        //fill all lists with "false"
        lifeManager.setAllDead();

    }


    @Test
    public void setXYValue() {

        lifeManager.setXYValue(0, 0, true);

        boolean actual = lifeManager.getFullLIst().get(0).get(0);

        assertEquals(true, actual);

    }

    @Test
    public void getXYValue() {

        boolean expected = false;
        boolean actual = lifeManager.getXYValue(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void getCountOfAliveAroundXY() {

        lifeManager.setXYValue(0, 1, true);
        lifeManager.setXYValue(2, 1, true);
        lifeManager.setXYValue(1, 2, true);
        lifeManager.setXYValue(1, 0, true);

        int actual = lifeManager.getCountOfAliveAroundXY(1, 1);
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    public void setAllDead() {

        boolean actual;

        for (int y = 0; y < propertiesHolder.getHeight(); y++) {
            for (int x = 0; x < propertiesHolder.getWidth(); x++) {
                lifeManager.setXYValue(x, y, true);
            }
        }

        lifeManager.setAllDead();

        for (int y = 0; y < propertiesHolder.getHeight(); y++) {
            for (int x = 0; x < propertiesHolder.getWidth(); x++) {

                actual = lifeManager.getXYValue(x, y);

                assertFalse(actual);

            }
        }
    }

    @Test
    public void getFullLIst() {

        lifeManager.setXYValue(0, 0, true);
        boolean actual = lifeManager.getFullLIst().get(0).get(0);

        assertTrue(actual);
    }

    @Test
    public void setListsOfAliveToList() {

        List<List<Boolean>> list1 = new ArrayList<>();
        List<List<Boolean>> list2 = new ArrayList<>();
        ListInitializer listInitializer = new ListInitializer();
        listInitializer.initListSize(list1, propertiesHolder);
        listInitializer.initListSize(list2, propertiesHolder);

        for (int y = 0; y < propertiesHolder.getHeight(); y++) {
            for (int x = 0; x < propertiesHolder.getWidth(); x++) {
                if ((x % 2) == 0 & (y % 2) == 0) {
                    list1.get(y).set(x, true);
                } else {
                    list2.get(y).set(x, true);
                }
            }
        }

        lifeManager.setListsOfAliveToList(list1, list2);

        boolean actual;
        for (int y = 0; y < propertiesHolder.getHeight(); y++) {
            for (int x = 0; x < propertiesHolder.getWidth(); x++) {

                actual = lifeManager.getXYValue(x, y);

                assertTrue(actual);

            }
        }


    }

    @Test
    public void returnCountOfAlive() {

        int actual = lifeManager.returnCountOfAlive();

        assertEquals(0, actual);
    }
}