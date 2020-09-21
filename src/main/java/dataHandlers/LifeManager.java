//TODO package naming not according naming convention
package dataHandlers;

import util.ListInitializer;

import java.util.ArrayList;
import java.util.List;

public class LifeManager {

//    TODO codestyle , read about variables order, it's depends on how you initialize them, current order incorrect
    //Y holder of X-es
    private List<List<Boolean>> TwoDimensionListOfAlive = new ArrayList<List<Boolean>>();
    private PropertiesHolder propertiesHolder;
    private ListInitializer listInitializer = new ListInitializer();


    public LifeManager(PropertiesHolder propertiesHolder) {

        this.propertiesHolder = propertiesHolder;

        listInitializer.initListSize(TwoDimensionListOfAlive, propertiesHolder);
        listInitializer.initRandXYValues(TwoDimensionListOfAlive, propertiesHolder);
    }


    public void setXYValue(int x, int y, boolean value) {

        TwoDimensionListOfAlive.get(y).set(x, value);
    }

    public boolean getXYValue(int x, int y) {
        return TwoDimensionListOfAlive.get(y).get(x);
    }

    public int getCountOfAliveAroundXY(int x, int y) {
        int count = 0;
        for (int yLoop = 0; yLoop < propertiesHolder.getHeight(); yLoop++) {
            for (int xLoop = 0; xLoop < propertiesHolder.getWidth(); xLoop++) {
//TODO this look like a mess, code reducing make this really hard to read, not necessary make code short, make it readable
                if ((x - 1 == xLoop) & (y - 1 == yLoop)) if (getXYValue(xLoop, yLoop)) count++;
                if ((x - 1 == xLoop) & (y == yLoop)) if (getXYValue(xLoop, yLoop)) count++;
                if ((x - 1 == xLoop) & (y + 1 == yLoop)) if (getXYValue(xLoop, yLoop)) count++;
                if ((x == xLoop) & (y + 1 == yLoop)) if (getXYValue(xLoop, yLoop)) count++;
                if ((x + 1 == xLoop) & (y + 1 == yLoop)) if (getXYValue(xLoop, yLoop)) count++;
                if ((x + 1 == xLoop) & (y == yLoop)) if (getXYValue(xLoop, yLoop)) count++;
                if ((x + 1 == xLoop) & (y - 1 == yLoop)) if (getXYValue(xLoop, yLoop)) count++;
                if ((x == xLoop) & (y - 1 == yLoop)) if (getXYValue(xLoop, yLoop)) count++;
            }
        }

//        if ( (x>0) & (x < (propertiesHolder.getWidth()-1)) & (y > 0) & ( y < (propertiesHolder.getHeight()-1))) {
//            if (getXYValue(x - 1, y + 1)) count++;
//            if (getXYValue(x, y + 1)) count++;
//            if (getXYValue(x + 1, y + 1)) count++;
//            if (getXYValue(x + 1, y)) count++;
//            if (getXYValue(x + 1, y - 1)) count++;
//            if (getXYValue(x, y - 1)) count++;
//            if (getXYValue(x - 1, y - 1)) count++;
//            if (getXYValue(x, y - 1)) count++;
//        }else if ( (x == 0) & ( y == 0)){
//            if (getXYValue(x , y +1)) count++;
//            if (getXYValue(x+1, y + 1)) count++;
//            if (getXYValue(x+1, y )) count++;
//        }else if ( (x == 0) & (y== (propertiesHolder.getHeight()-1))){
//            if (getXYValue(x, y - 1)) count++;
//            if (getXYValue(x+1, y - 1)) count++;
//            if (getXYValue(x + 1, y )) count++;
//        }else if ( x== (propertiesHolder.getWidth()-1) & (y ==0)){
//            if (getXYValue(x -1, y )) count++;
//            if (getXYValue(x-1, y+1 )) count++;
//            if (getXYValue(x, y+1 )) count++;
//        }else if (x== (propertiesHolder.getWidth()-1) & (y== (propertiesHolder.getHeight()-1))){
//            if (getXYValue(x-1, y )) count++;
//            if (getXYValue(x-1, y-1 )) count++;
//            if (getXYValue(x, y-1 )) count++;
//        }else if (x ==0){
//            if (getXYValue(x, y+1 )) count++;
//            if (getXYValue(x+1, y+1 )) count++;
//            if (getXYValue(x+1, y )) count++;
//            if (getXYValue(x+1, y-1 )) count++;
//            if (getXYValue(x, y-1 )) count++;
//        }else if (y== (propertiesHolder.getHeight()-1)){
//            if (getXYValue(x-1, y )) count++;
//            if (getXYValue(x-1, y-1 )) count++;
//            if (getXYValue(x, y-1 )) count++;
//            if (getXYValue(x+1, y-1 )) count++;
//            if (getXYValue(x+1, y )) count++;
//        }else if ( x == (propertiesHolder.getWidth()-1)){
//            if (getXYValue(x, y+1 )) count++;
//            if (getXYValue(x-1, y+1 )) count++;
//            if (getXYValue(x-1, y )) count++;
//            if (getXYValue(x-1, y-1 )) count++;
//            if (getXYValue(x, y-1 )) count++;
//        }else if ( y == 0){
//            if (getXYValue(x-1, y )) count++;
//            if (getXYValue(x-1, y+1 )) count++;
//            if (getXYValue(x, y+1 )) count++;
//            if (getXYValue(x+1, y+1 )) count++;
//            if (getXYValue(x+1, y )) count++;
//        }

        return count;
    }

    public void setAllDead() {
        for (int y = 0; y < propertiesHolder.getHeight(); y++) {

            for (int x = 0; x < propertiesHolder.getWidth(); x++) {
                setXYValue(x, y, false);
            }
        }

    }

    public List<List<Boolean>> getFullLIst() {
        return TwoDimensionListOfAlive;
    }

    public void setListsOfAliveToList(List<List<Boolean>> inputList1, List<List<Boolean>> inputList2) {

        for (int y = 0; y < propertiesHolder.getHeight(); y++) {

            for (int x = 0; x < propertiesHolder.getWidth(); x++) {
                if (inputList1.get(y).get(x)) setXYValue(x, y, inputList1.get(y).get(x));
                if (inputList2.get(y).get(x)) setXYValue(x, y, inputList2.get(y).get(x));
            }
        }
    }

    public int returnCountOfAlive() {

        int count = 0;

        for (int y = 0; y < propertiesHolder.getHeight(); y++) {
            for (int x = 0; x < propertiesHolder.getWidth(); x++) {

                if (getXYValue(x, y)) count++;
            }
        }
        return count;
    }


}



