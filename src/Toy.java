public class Toy extends Thread {
    private Tumbler tumbler;
    private final int PAUSE = 2000;

    public Toy(String name, Tumbler tumbler) {
        super(name);
        this.tumbler =tumbler;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!tumbler.tumblerOff) {
                    System.out.println("Не нажимай! Переключаю обратно!");
                    tumbler.tumblerOff = true;
                    Thread.sleep(PAUSE);
                }
                if (isInterrupted()) {
                    System.out.println("Пока-пока!");
                    break;
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}