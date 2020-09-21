import dataHandlers.LifeManager;
import dataHandlers.PropertiesHolder;
import threads.LifeGiverThread;
import threads.LifeTakerThread;
import util.Drawer;
import util.PropertiesReader;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        TODO this can be not in the main class, but if you want it here use separate methods
        PropertiesReader propertiesReader = new PropertiesReader();
        PropertiesHolder propertiesHolder = new PropertiesHolder(
                propertiesReader.returnWidthProperty(),
                propertiesReader.returnHeightProperty(),
                propertiesReader.returnInitAliveCountProperty());

        LifeManager lifeManager = new LifeManager(propertiesHolder);


        LifeGiverThread lifeGiverThread = new LifeGiverThread();
        LifeTakerThread lifeTakerThread = new LifeTakerThread();

        Drawer drawer = new Drawer();
        drawer.drawLifeList(lifeManager, propertiesHolder);



        //System.out.println("");

//        for (int y = (propertiesHolder.getHeight()-1); y >= 0 ; y--){
//            for (int x=0; x< propertiesHolder.getWidth(); x++){
//                System.out.println("x = " + x + " y = "+ y + " " + lifeManager.getCountOfAliveAroundXY(x,y));
//            }
//
//        }
//
//        drawer.drawList(lifeGiverThread.giveLive(lifeManager, propertiesHolder), propertiesHolder);
//
//        System.out.println("");
//
        //     drawer.drawList(lifeTakerThread.takeLive(lifeManager, propertiesHolder), propertiesHolder);

//        TODO this can be not in the main class, but if you want it here use separate methods
        while (true) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            Thread.sleep(1);
            List<List<Boolean>> input1 = lifeTakerThread.takeLive(lifeManager, propertiesHolder);
            List<List<Boolean>> input2 = lifeGiverThread.giveLive(lifeManager, propertiesHolder);
            lifeManager.setAllDead();
            lifeManager.setListsOfAliveToList(input1, input2);
            drawer.drawLifeList(lifeManager, propertiesHolder);
            if (lifeManager.returnCountOfAlive() == 0) break;
            Thread.sleep(500);
        }

//        System.out.println("0.0 " + lifeManager.getCountOfAliveAroundXY(0,0));
//        System.out.println("19.9 " + lifeManager.getCountOfAliveAroundXY(19,9));
//        System.out.println("19.0 " + lifeManager.getCountOfAliveAroundXY(19,0));
//        System.out.println("0.9 " + lifeManager.getCountOfAliveAroundXY(0,9));
//        System.out.println("");
//        System.out.println("5.5 " + lifeManager.getCountOfAliveAroundXY(5,5));
//        System.out.println("");
//
//        System.out.println("5.9 " + lifeManager.getCountOfAliveAroundXY(5,9));
//        System.out.println("5.0 " + lifeManager.getCountOfAliveAroundXY(5,0));
//        System.out.println("0.5 " + lifeManager.getCountOfAliveAroundXY(0,5));
//        System.out.println("19.4 " + lifeManager.getCountOfAliveAroundXY(19,4));
//


    }
}