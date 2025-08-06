package com.twitter.sdk.android.core;

import okhttp3.Headers;

public class TwitterRateLimit {
    private static final String LIMIT_KEY = "x-rate-limit-limit";
    private static final String REMAINING_KEY = "x-rate-limit-remaining";
    private static final String RESET_KEY = "x-rate-limit-reset";
    private int remainingRequest;
    private int requestLimit;
    private long resetSeconds;

    public TwitterRateLimit(Headers headers) {
        if (headers != null) {
            for (int i11 = 0; i11 < headers.size(); i11++) {
                if (LIMIT_KEY.equals(headers.name(i11))) {
                    this.requestLimit = Integer.valueOf(headers.value(i11)).intValue();
                } else if (REMAINING_KEY.equals(headers.name(i11))) {
                    this.remainingRequest = Integer.valueOf(headers.value(i11)).intValue();
                } else if (RESET_KEY.equals(headers.name(i11))) {
                    this.resetSeconds = Long.valueOf(headers.value(i11)).longValue();
                }
            }
            return;
        }
        throw new IllegalArgumentException("headers must not be null");
    }

    public int getLimit() {
        return this.requestLimit;
    }

    public int getRemaining() {
        return this.remainingRequest;
    }

    public long getReset() {
        return this.resetSeconds;
    }
}
