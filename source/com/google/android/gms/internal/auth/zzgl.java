package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzgl implements Iterator {
    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
