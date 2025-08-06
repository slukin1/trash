package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Objects;

public final class StarRating extends Rating {
    public static final Bundleable.Creator<StarRating> CREATOR = t0.f66056a;
    private static final int FIELD_MAX_STARS = 1;
    private static final int FIELD_STAR_RATING = 2;
    private static final int MAX_STARS_DEFAULT = 5;
    private static final int TYPE = 2;
    private final int maxStars;
    private final float starRating;

    public StarRating(int i11) {
        Assertions.checkArgument(i11 > 0, "maxStars must be a positive integer");
        this.maxStars = i11;
        this.starRating = -1.0f;
    }

    /* access modifiers changed from: private */
    public static StarRating fromBundle(Bundle bundle) {
        boolean z11 = false;
        if (bundle.getInt(keyForField(0), -1) == 2) {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        int i11 = bundle.getInt(keyForField(1), 5);
        float f11 = bundle.getFloat(keyForField(2), -1.0f);
        if (f11 == -1.0f) {
            return new StarRating(i11);
        }
        return new StarRating(i11, f11);
    }

    private static String keyForField(int i11) {
        return Integer.toString(i11, 36);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StarRating)) {
            return false;
        }
        StarRating starRating2 = (StarRating) obj;
        if (this.maxStars == starRating2.maxStars && this.starRating == starRating2.starRating) {
            return true;
        }
        return false;
    }

    public int getMaxStars() {
        return this.maxStars;
    }

    public float getStarRating() {
        return this.starRating;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.maxStars), Float.valueOf(this.starRating));
    }

    public boolean isRated() {
        return this.starRating != -1.0f;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(0), 2);
        bundle.putInt(keyForField(1), this.maxStars);
        bundle.putFloat(keyForField(2), this.starRating);
        return bundle;
    }

    public StarRating(int i11, float f11) {
        boolean z11 = true;
        Assertions.checkArgument(i11 > 0, "maxStars must be a positive integer");
        Assertions.checkArgument((f11 < 0.0f || f11 > ((float) i11)) ? false : z11, "starRating is out of range [0, maxStars]");
        this.maxStars = i11;
        this.starRating = f11;
    }
}
