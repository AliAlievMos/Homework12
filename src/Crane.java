public class Crane implements Backroom, queueOfShips {

    public static void Crane(){
        new Thread(() -> {
            while (true) {

                try {
                    Sheeps.addItemToShip(Backroom.take());
                    Thread.sleep(2000);
                    System.out.println("Кран переместил товар на корбаль");
//                    System.out.println("На складе " + Backroom.size() + " товара");


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }


        }).start();

    }
}
