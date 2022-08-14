public class User extends Thread {
    private Tumbler tumbler;
    private final int WAIT = 2000;
    private final int TRY = 5;

    public User(String name, Tumbler tumbler) {
        super(name);
        this.tumbler = tumbler;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < TRY) {
            if (tumbler.tumblerOff) {
                System.out.println("Нажимаю кнопку!");
                tumbler.tumblerOff = false;
                count++;
                try {
                    Thread.sleep(WAIT);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        System.out.println("Надоело играть");
        Thread.currentThread().interrupt();
    }
}