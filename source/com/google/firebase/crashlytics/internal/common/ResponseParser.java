package com.google.firebase.crashlytics.internal.common;

public class ResponseParser {
    public static final int ResponseActionDiscard = 0;
    public static final int ResponseActionRetry = 1;

    public static int parse(int i11) {
        if (i11 < 200 || i11 > 299) {
            return ((i11 < 300 || i11 > 399) && i11 >= 400 && i11 <= 499) ? 0 : 1;
        }
        return 0;
    }
}
