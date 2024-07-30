import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class AsyncRandomSumFastest {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(AsyncRandomSumFastest::generarNumeroRandom);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(AsyncRandomSumFastest::generarNumeroRandom);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(AsyncRandomSumFastest::generarNumeroRandom);
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(AsyncRandomSumFastest::generarNumeroRandom);

        CompletableFuture<Object> tareaMasRapida = CompletableFuture.anyOf(future1, future2, future3, future4);
        tareaMasRapida.thenAccept(result -> {
            System.out.println("El valor de la tarea mas rapida es: " + result);
        }).join();
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