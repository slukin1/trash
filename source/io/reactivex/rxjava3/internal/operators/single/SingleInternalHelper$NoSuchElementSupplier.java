package io.reactivex.rxjava3.internal.operators.single;

import j00.k;
import java.util.NoSuchElementException;

enum SingleInternalHelper$NoSuchElementSupplier implements k<NoSuchElementException> {
    INSTANCE;

    public NoSuchElementException get() {
        return new NoSuchElementException();
    }
}
