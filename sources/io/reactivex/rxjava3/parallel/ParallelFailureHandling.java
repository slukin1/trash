package io.reactivex.rxjava3.parallel;

import j00.c;

public enum ParallelFailureHandling implements c<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    public ParallelFailureHandling apply(Long l11, Throwable th2) {
        return this;
    }
}
