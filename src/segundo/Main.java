package segundo;

public class Main {
    public static void main(String[] args) {
        Runnable app = new App();
        Thread thread = new Thread(app);
        thread.start();
    }
}