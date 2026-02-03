public class Main {

    public static void main(String[] args) {

        Scatola scatola = new Scatola();

        Producer producer = new Producer(scatola);
        Consumer consumer = new Consumer(scatola);

        producer.start();
        consumer.start();
    }
}