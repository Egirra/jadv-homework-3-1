public class Main {

    public static void main(String[] args) throws InterruptedException {
        Tumbler tumbler = new Tumbler();
        Thread userThread = new User("Пользователь", tumbler);
        Thread toyThread = new Toy("Игрушка", tumbler);

        userThread.start();
        toyThread.start();

        userThread.join();
        toyThread.interrupt();
    }
}