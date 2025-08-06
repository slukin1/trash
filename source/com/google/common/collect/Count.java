package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
final class Count implements Serializable {
    private int value;

    public Count(int i11) {
        this.value = i11;
    }

    public void add(int i11) {
        this.value += i11;
    }

    public int addAndGet(int i11) {
        int i12 = this.value + i11;
        this.value = i12;
        return i12;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Count) && ((Count) obj).value == this.value;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int i11) {
        int i12 = this.value;
        this.value = i11;
        return i12;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int i11) {
        this.value = i11;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
