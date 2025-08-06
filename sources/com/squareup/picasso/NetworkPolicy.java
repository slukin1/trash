package com.squareup.picasso;

public enum NetworkPolicy {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    
    public final int index;

    private NetworkPolicy(int i11) {
        this.index = i11;
    }

    public static boolean isOfflineOnly(int i11) {
        return (i11 & OFFLINE.index) != 0;
    }

    public static boolean shouldReadFromDiskCache(int i11) {
        return (i11 & NO_CACHE.index) == 0;
    }

    public static boolean shouldWriteToDiskCache(int i11) {
        return (i11 & NO_STORE.index) == 0;
    }
}
