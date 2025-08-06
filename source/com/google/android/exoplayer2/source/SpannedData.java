package com.google.android.exoplayer2.source;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Consumer;

final class SpannedData<V> {
    private int memoizedReadIndex;
    private final Consumer<V> removeCallback;
    private final SparseArray<V> spans;

    public SpannedData() {
        this(u.f66052a);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(Object obj) {
    }

    public void appendSpan(int i11, V v11) {
        boolean z11 = false;
        if (this.memoizedReadIndex == -1) {
            Assertions.checkState(this.spans.size() == 0);
            this.memoizedReadIndex = 0;
        }
        if (this.spans.size() > 0) {
            SparseArray<V> sparseArray = this.spans;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            if (i11 >= keyAt) {
                z11 = true;
            }
            Assertions.checkArgument(z11);
            if (keyAt == i11) {
                Consumer<V> consumer = this.removeCallback;
                SparseArray<V> sparseArray2 = this.spans;
                consumer.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.spans.append(i11, v11);
    }

    public void clear() {
        for (int i11 = 0; i11 < this.spans.size(); i11++) {
            this.removeCallback.accept(this.spans.valueAt(i11));
        }
        this.memoizedReadIndex = -1;
        this.spans.clear();
    }

    public void discardFrom(int i11) {
        int size = this.spans.size() - 1;
        while (size >= 0 && i11 < this.spans.keyAt(size)) {
            this.removeCallback.accept(this.spans.valueAt(size));
            this.spans.removeAt(size);
            size--;
        }
        this.memoizedReadIndex = this.spans.size() > 0 ? Math.min(this.memoizedReadIndex, this.spans.size() - 1) : -1;
    }

    public void discardTo(int i11) {
        int i12 = 0;
        while (i12 < this.spans.size() - 1) {
            int i13 = i12 + 1;
            if (i11 >= this.spans.keyAt(i13)) {
                this.removeCallback.accept(this.spans.valueAt(i12));
                this.spans.removeAt(i12);
                int i14 = this.memoizedReadIndex;
                if (i14 > 0) {
                    this.memoizedReadIndex = i14 - 1;
                }
                i12 = i13;
            } else {
                return;
            }
        }
    }

    public V get(int i11) {
        if (this.memoizedReadIndex == -1) {
            this.memoizedReadIndex = 0;
        }
        while (true) {
            int i12 = this.memoizedReadIndex;
            if (i12 > 0 && i11 < this.spans.keyAt(i12)) {
                this.memoizedReadIndex--;
            }
        }
        while (this.memoizedReadIndex < this.spans.size() - 1 && i11 >= this.spans.keyAt(this.memoizedReadIndex + 1)) {
            this.memoizedReadIndex++;
        }
        return this.spans.valueAt(this.memoizedReadIndex);
    }

    public V getEndValue() {
        SparseArray<V> sparseArray = this.spans;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public boolean isEmpty() {
        return this.spans.size() == 0;
    }

    public SpannedData(Consumer<V> consumer) {
        this.spans = new SparseArray<>();
        this.removeCallback = consumer;
        this.memoizedReadIndex = -1;
    }
}
