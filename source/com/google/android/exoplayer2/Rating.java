package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;

public abstract class Rating implements Bundleable {
    public static final Bundleable.Creator<Rating> CREATOR = q0.f65972a;
    public static final int FIELD_RATING_TYPE = 0;
    public static final int RATING_TYPE_DEFAULT = -1;
    public static final int RATING_TYPE_HEART = 0;
    public static final int RATING_TYPE_PERCENTAGE = 1;
    public static final int RATING_TYPE_STAR = 2;
    public static final int RATING_TYPE_THUMB = 3;
    public static final float RATING_UNSET = -1.0f;

    /* access modifiers changed from: private */
    public static Rating fromBundle(Bundle bundle) {
        int i11 = bundle.getInt(keyForField(0), -1);
        if (i11 == 0) {
            return HeartRating.CREATOR.fromBundle(bundle);
        }
        if (i11 == 1) {
            return PercentageRating.CREATOR.fromBundle(bundle);
        }
        if (i11 == 2) {
            return StarRating.CREATOR.fromBundle(bundle);
        }
        if (i11 == 3) {
            return ThumbRating.CREATOR.fromBundle(bundle);
        }
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("Encountered unknown rating type: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }

    private static String keyForField(int i11) {
        return Integer.toString(i11, 36);
    }

    public abstract boolean isRated();
}
