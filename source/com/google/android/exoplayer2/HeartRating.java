package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Objects;

public final class HeartRating extends Rating {
    public static final Bundleable.Creator<HeartRating> CREATOR = e0.f65887a;
    private static final int FIELD_IS_HEART = 2;
    private static final int FIELD_RATED = 1;
    private static final int TYPE = 0;
    private final boolean isHeart;
    private final boolean rated;

    public HeartRating() {
        this.rated = false;
        this.isHeart = false;
    }

    /* access modifiers changed from: private */
    public static HeartRating fromBundle(Bundle bundle) {
        Assertions.checkArgument(bundle.getInt(keyForField(0), -1) == 0);
        if (bundle.getBoolean(keyForField(1), false)) {
            return new HeartRating(bundle.getBoolean(keyForField(2), false));
        }
        return new HeartRating();
    }

    private static String keyForField(int i11) {
        return Integer.toString(i11, 36);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HeartRating)) {
            return false;
        }
        HeartRating heartRating = (HeartRating) obj;
        if (this.isHeart == heartRating.isHeart && this.rated == heartRating.rated) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.rated), Boolean.valueOf(this.isHeart));
    }

    public boolean isHeart() {
        return this.isHeart;
    }

    public boolean isRated() {
        return this.rated;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(0), 0);
        bundle.putBoolean(keyForField(1), this.rated);
        bundle.putBoolean(keyForField(2), this.isHeart);
        return bundle;
    }

    public HeartRating(boolean z11) {
        this.rated = true;
        this.isHeart = z11;
    }
}
