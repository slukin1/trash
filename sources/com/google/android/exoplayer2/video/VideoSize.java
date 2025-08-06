package com.google.android.exoplayer2.video;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;

public final class VideoSize implements Bundleable {
    public static final Bundleable.Creator<VideoSize> CREATOR = m.f66120a;
    private static final int DEFAULT_HEIGHT = 0;
    private static final float DEFAULT_PIXEL_WIDTH_HEIGHT_RATIO = 1.0f;
    private static final int DEFAULT_UNAPPLIED_ROTATION_DEGREES = 0;
    private static final int DEFAULT_WIDTH = 0;
    private static final int FIELD_HEIGHT = 1;
    private static final int FIELD_PIXEL_WIDTH_HEIGHT_RATIO = 3;
    private static final int FIELD_UNAPPLIED_ROTATION_DEGREES = 2;
    private static final int FIELD_WIDTH = 0;
    public static final VideoSize UNKNOWN = new VideoSize(0, 0);
    public final int height;
    public final float pixelWidthHeightRatio;
    public final int unappliedRotationDegrees;
    public final int width;

    public VideoSize(int i11, int i12) {
        this(i11, i12, 0, 1.0f);
    }

    private static String keyForField(int i11) {
        return Integer.toString(i11, 36);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ VideoSize lambda$static$0(Bundle bundle) {
        return new VideoSize(bundle.getInt(keyForField(0), 0), bundle.getInt(keyForField(1), 0), bundle.getInt(keyForField(2), 0), bundle.getFloat(keyForField(3), 1.0f));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        if (this.width == videoSize.width && this.height == videoSize.height && this.unappliedRotationDegrees == videoSize.unappliedRotationDegrees && this.pixelWidthHeightRatio == videoSize.pixelWidthHeightRatio) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((217 + this.width) * 31) + this.height) * 31) + this.unappliedRotationDegrees) * 31) + Float.floatToRawIntBits(this.pixelWidthHeightRatio);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(0), this.width);
        bundle.putInt(keyForField(1), this.height);
        bundle.putInt(keyForField(2), this.unappliedRotationDegrees);
        bundle.putFloat(keyForField(3), this.pixelWidthHeightRatio);
        return bundle;
    }

    public VideoSize(int i11, int i12, int i13, float f11) {
        this.width = i11;
        this.height = i12;
        this.unappliedRotationDegrees = i13;
        this.pixelWidthHeightRatio = f11;
    }
}
