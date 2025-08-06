package com.airbnb.lottie.model;

import com.airbnb.lottie.LottieComposition;
import i0.b;

public class LottieCompositionCache {
    private static final LottieCompositionCache INSTANCE = new LottieCompositionCache();
    private final b<String, LottieComposition> cache = new b<>(20);

    public static LottieCompositionCache getInstance() {
        return INSTANCE;
    }

    public void clear() {
        this.cache.evictAll();
    }

    public LottieComposition get(String str) {
        if (str == null) {
            return null;
        }
        return this.cache.get(str);
    }

    public void put(String str, LottieComposition lottieComposition) {
        if (str != null) {
            this.cache.put(str, lottieComposition);
        }
    }

    public void resize(int i11) {
        this.cache.resize(i11);
    }
}
