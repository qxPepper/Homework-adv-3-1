public class UselessBox {
    private static volatile boolean toggleSwitch;

    private final long start = System.currentTimeMillis();
    private long finish;
    private long current;

    private final static int TIME_SLEEP_USER = 3000;
    private final static int TIME_SLEEP_TOY = 1000;
    private final static int SEC_TO_MIL = 1000;
    private final static int NUMBER_OF_ITERATIONS = 5;

    public void methodUser() {
        int count = 0;
        while (count < NUMBER_OF_ITERATIONS) {
            try {
                Thread.sleep(TIME_SLEEP_USER);
                finish = System.currentTimeMillis();
                current = (finish - start) / SEC_TO_MIL;

                toggleSwitch = true;
                System.out.println("Пользователь включил коробку через " + current + " секунд.");

                count++;

            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }

    public void methodToy() {
        try {
        while(true) {
                    Thread.sleep(TIME_SLEEP_TOY);

                    if (toggleSwitch) {
                        finish = System.currentTimeMillis();
                        current = (finish - start) / SEC_TO_MIL;

                        toggleSwitch = false;
                        System.out.println("Игрушка сразу же выключила коробку.");
                    } else {
                        System.out.println("Отключено.");
                    }

                    //Завершается после включения, но не выключая, потому что
                    //цитата: Главный поток (main) после завершения потока-пользователя, останавливает поток-игрушку.

                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
            }

        } catch (Exception exception) {

        }
    }
}