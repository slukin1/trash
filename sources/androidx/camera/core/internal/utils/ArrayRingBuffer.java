package androidx.camera.core.internal.utils;

import androidx.camera.core.internal.utils.RingBuffer;
import java.util.ArrayDeque;

public class ArrayRingBuffer<T> implements RingBuffer<T> {
    private static final String TAG = "ZslRingBuffer";
    private final ArrayDeque<T> mBuffer;
    private final Object mLock;
    public final RingBuffer.OnRemoveCallback<T> mOnRemoveCallback;
    private final int mRingBufferCapacity;

    public ArrayRingBuffer(int i11) {
        this(i11, (RingBuffer.OnRemoveCallback) null);
    }

    public T dequeue() {
        T removeLast;
        synchronized (this.mLock) {
            removeLast = this.mBuffer.removeLast();
        }
        return removeLast;
    }

    public void enqueue(T t11) {
        Object dequeue;
        synchronized (this.mLock) {
            dequeue = this.mBuffer.size() >= this.mRingBufferCapacity ? dequeue() : null;
            this.mBuffer.addFirst(t11);
        }
        RingBuffer.OnRemoveCallback<T> onRemoveCallback = this.mOnRemoveCallback;
        if (onRemoveCallback != null && dequeue != null) {
            onRemoveCallback.onRemove(dequeue);
        }
    }

    public int getMaxCapacity() {
        return this.mRingBufferCapacity;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mLock) {
            isEmpty = this.mBuffer.isEmpty();
        }
        return isEmpty;
    }

    public ArrayRingBuffer(int i11, RingBuffer.OnRemoveCallback<T> onRemoveCallback) {
        this.mLock = new Object();
        this.mRingBufferCapacity = i11;
        this.mBuffer = new ArrayDeque<>(i11);
        this.mOnRemoveCallback = onRemoveCallback;
    }
}
