public class Task5 {

    public static void main(String[] args) throws InterruptedException {

        FileSyncTask task = new FileSyncTask(
                "C:/temp/source",
                "C:/temp/target"
        );

        Thread thread = new Thread(task::start);
        thread.start();

        Thread.sleep(10000);

        task.stop();
    }
}