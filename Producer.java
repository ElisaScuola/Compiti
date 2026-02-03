import java.util.Random;

public class Producer extends Thread {

    private Scatola scatola;
    private Random random;

    public Producer(Scatola scatola) {
        this.scatola = scatola;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                scatola.semaforoConsumer.acquire();

                int numero = random.nextInt(100);
                scatola.queue.add(numero);
                System.out.println("Prodotto -> " + numero);

                scatola.semaforoProducer.release();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}