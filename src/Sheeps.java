import java.util.concurrent.ArrayBlockingQueue;

public class Sheeps implements queueOfShips {
    public static void CreateSheeps(){
        new Thread(() -> {
            while (true) {
                try {
                int i = (int) (1 + Math.random() * 20);
//                ArrayList<Item> Sheep = new ArrayList<>(i);
                    ArrayBlockingQueue<Item> Sheep = new ArrayBlockingQueue<>(i);
                queueOfShips.add(Sheep);
                System.out.println("Прибыл корабль вместимостью:" + i);
                System.out.println("КОРАБЛЕЙ В ОЧЕРЕДИ: "+ queueOfShips.size());
                Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();


    }
    public static void addItemToShip(Item item){
        try {
            ArrayBlockingQueue<Item> sheep = queueOfShips.get(0);
            try {
                sheep.add(item);
                System.out.println("На корабль загружен товар!");

            } catch (IllegalStateException e){
                System.out.println("Корабль загружен, ОТЧАЛИВАЕМ!");
                queueOfShips.remove(sheep);
            }

        } catch (IndexOutOfBoundsException e){
            System.out.println("Корабль еще не прибыл, некуда загружать товар!");
        }
    }

}
