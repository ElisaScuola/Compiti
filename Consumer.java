public class Consumer extends Thread {

    private Scatola scatola;

    public Consumer(Scatola scatola) {
        this.scatola = scatola;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                scatola.semaforoProducer.acquire();

                int elemento = scatola.queue.remove();
                System.out.println("Consumanto -> " + elemento);

                scatola.semaforoConsumer.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}