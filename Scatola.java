import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Scatola {

    private static final int DIMENSIONE = 5;

    Queue<Integer> queue;
    Semaphore semaforoConsumer;
    Semaphore semaforoProducer;

    public Scatola() {
        queue = new LinkedList<Integer>();
        semaforoProducer = new Semaphore(0);
        semaforoConsumer = new Semaphore(DIMENSIONE);
    }
}