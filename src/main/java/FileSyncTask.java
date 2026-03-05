import java.io.IOException;
import java.nio.file.*;

public class FileSyncTask implements Task {

    private final Path sourceDir;
    private final Path targetDir;

    private volatile boolean running = false;

    public FileSyncTask(String source, String target) {
        this.sourceDir = Paths.get(source);
        this.targetDir = Paths.get(target);
    }

    @Override
    public void start() {
        running = true;

        System.out.println("Синхронизация началась...");

        while (running) {
            try {
                syncFiles();
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stop() {
        running = false;
        System.out.println("Синхронизация остановлена.");
    }

    private void syncFiles() throws IOException {

        if (!Files.exists(sourceDir)) {
            System.out.println("Источник не существует");
            return;
        }

        if (!Files.exists(targetDir)) {
            Files.createDirectories(targetDir);
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDir)) {

            for (Path file : stream) {

                Path targetFile = targetDir.resolve(file.getFileName());

                if (Files.isRegularFile(file)) {

                    Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("Синхронизирован файл: " + file.getFileName());
                }
            }
        }
    }
}