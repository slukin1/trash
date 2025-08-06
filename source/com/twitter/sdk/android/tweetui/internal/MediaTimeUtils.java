package com.twitter.sdk.android.tweetui.internal;

import java.util.Locale;

final class MediaTimeUtils {
    private static final String TIME_FORMAT_LONG = "%1$d:%2$02d:%3$02d";
    private static final String TIME_FORMAT_SHORT = "%1$d:%2$02d";

    private MediaTimeUtils() {
    }

    public static String getPlaybackTime(long j11) {
        int i11 = (int) (j11 / 1000);
        int i12 = i11 % 60;
        int i13 = (i11 / 60) % 60;
        int i14 = i11 / 3600;
        if (i14 > 0) {
            return String.format(Locale.getDefault(), TIME_FORMAT_LONG, new Object[]{Integer.valueOf(i14), Integer.valueOf(i13), Integer.valueOf(i12)});
        }
        return String.format(Locale.getDefault(), TIME_FORMAT_SHORT, new Object[]{Integer.valueOf(i13), Integer.valueOf(i12)});
    }
}
