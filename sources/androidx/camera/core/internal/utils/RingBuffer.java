package androidx.camera.core.internal.utils;

public interface RingBuffer<T> {

    public interface OnRemoveCallback<T> {
        void onRemove(T t11);
    }

    T dequeue();

    void enqueue(T t11);

    int getMaxCapacity();

    boolean isEmpty();
}
