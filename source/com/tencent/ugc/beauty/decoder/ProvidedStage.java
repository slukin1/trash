package com.tencent.ugc.beauty.decoder;

import com.tencent.ugc.beauty.decoder.Stage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class ProvidedStage<T> extends Stage implements Provider<T> {
    public int mBufferOutedCount = 0;
    public final Queue<T> mRecycledBuffers = new LinkedList();
    public final Queue<T> mWaitOutBuffers = new LinkedList();

    public T dequeueOutputBuffer() {
        T poll;
        synchronized (this) {
            poll = this.mWaitOutBuffers.poll();
            if (poll != null) {
                this.mBufferOutedCount++;
            }
        }
        return poll;
    }

    public void drainOutputBuffers() {
        Object dequeueOutputBuffer = dequeueOutputBuffer();
        if (dequeueOutputBuffer != null) {
            enqueueOutputBuffer(dequeueOutputBuffer);
        }
    }

    public void enqueueOutputBuffer(T t11) {
        synchronized (this) {
            this.mBufferOutedCount--;
            this.mRecycledBuffers.add(t11);
        }
    }

    public boolean noBufferKeepByUs() {
        boolean z11;
        synchronized (this) {
            z11 = this.mRecycledBuffers.isEmpty() && this.mWaitOutBuffers.isEmpty() && this.mBufferOutedCount == 0;
        }
        return z11;
    }

    public void processFrame() throws ProcessException {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.mRecycledBuffers);
            this.mRecycledBuffers.clear();
        }
        recycleBuffers(arrayList);
        synchronized (this) {
            if (isAllDataReady() && noBufferKeepByUs()) {
                setState(Stage.State.DONE);
            }
        }
    }

    public abstract void recycleBuffers(List<T> list);
}
