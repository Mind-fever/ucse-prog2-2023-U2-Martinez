import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class AsyncRandomSum {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(AsyncRandomSum::generarNumeroRandom);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(AsyncRandomSum::generarNumeroRandom);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(AsyncRandomSum::generarNumeroRandom);
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(AsyncRandomSum::generarNumeroRandom);

        CompletableFuture<Void> futures = CompletableFuture.allOf(future1, future2, future3, future4);
        futures.thenRun(() -> {
            try {
                int sum = future1.get() + future2.get() + future3.get() + future4.get();
                System.out.println("La suma de los 4 valores es: " + sum);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        futures.join();
    }

    private static int generarNumeroRandom() {
        int numRandom = ThreadLocalRandom.current().nextInt(100, 501);
        try {
            TimeUnit.MILLISECONDS.sleep(numRandom);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numRandom;
    }
}

