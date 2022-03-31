public class supplier implements Backroom {
    public static void supplier (){


        new Thread(() -> {
            while (true){
                try {
                int i = (int) (Math.random()*500);
                Backroom.put(new Item(i));
                    Thread.sleep(500);
//                    System.out.println("Завезли товар на склад");
//                    System.out.println("На складе "+ Backroom.size()+ " товара");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }


        }).start();
    }
}
