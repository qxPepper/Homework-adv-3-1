public class Main {
    public static void main(String[] args) {
        UselessBox box = new UselessBox();

        Thread user = new Thread(box::methodUser, "Пользователь");
        Thread toy = new Thread(box::methodToy, "Игрушка");

        toy.start();
        user.start();

        try {
            user.join();
            toy.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
