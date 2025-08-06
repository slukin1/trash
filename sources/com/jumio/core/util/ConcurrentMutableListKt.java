package com.jumio.core.util;

public final class ConcurrentMutableListKt {
    public static final <T> ConcurrentMutableList<T> concurrentMutableListOf() {
        return new ConcurrentMutableList<>();
    }
}
