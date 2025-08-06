package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Objects;

public final class PercentageRating extends Rating {
    public static final Bundleable.Creator<PercentageRating> CREATOR = l0.f65927a;
    private static final int FIELD_PERCENT = 1;
    private static final int TYPE = 1;
    private final float percent;

    public PercentageRating() {
        this.percent = -1.0f;
    }

    /* access modifiers changed from: private */
    public static PercentageRating fromBundle(Bundle bundle) {
        boolean z11 = false;
        if (bundle.getInt(keyForField(0), -1) == 1) {
            z11 = true;
        }
        Assertions.checkArgument(z11);
        float f11 = bundle.getFloat(keyForField(1), -1.0f);
        return f11 == -1.0f ? new PercentageRating() : new PercentageRating(f11);
    }

    private static String keyForField(int i11) {
        return Integer.toString(i11, 36);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof PercentageRating) && this.percent == ((PercentageRating) obj).percent) {
            return true;
        }
        return false;
    }

    public float getPercent() {
        return this.percent;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.percent));
    }

    public boolean isRated() {
        return this.percent != -1.0f;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(0), 1);
        bundle.putFloat(keyForField(1), this.percent);
        return bundle;
    }

    public PercentageRating(float f11) {
        Assertions.checkArgument(f11 >= 0.0f && f11 <= 100.0f, "percent must be in the range of [0, 100]");
        this.percent = f11;
    }
}
