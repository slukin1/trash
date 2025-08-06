package rx.internal.util.unsafe;

public interface MessagePassingQueue<M> {
    boolean isEmpty();

    boolean offer(M m11);

    M peek();

    M poll();

    int size();
}
