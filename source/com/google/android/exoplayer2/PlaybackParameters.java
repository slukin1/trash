package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class PlaybackParameters implements Bundleable {
    public static final Bundleable.Creator<PlaybackParameters> CREATOR = m0.f65930a;
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    private static final int FIELD_PITCH = 1;
    private static final int FIELD_SPEED = 0;
    public final float pitch;
    private final int scaledUsPerMs;
    public final float speed;

    public PlaybackParameters(float f11) {
        this(f11, 1.0f);
    }

    private static String keyForField(int i11) {
        return Integer.toString(i11, 36);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ PlaybackParameters lambda$static$0(Bundle bundle) {
        return new PlaybackParameters(bundle.getFloat(keyForField(0), 1.0f), bundle.getFloat(keyForField(1), 1.0f));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PlaybackParameters.class != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        if (this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch) {
            return true;
        }
        return false;
    }

    public long getMediaTimeUsForPlayoutTimeMs(long j11) {
        return j11 * ((long) this.scaledUsPerMs);
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.speed)) * 31) + Float.floatToRawIntBits(this.pitch);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat(keyForField(0), this.speed);
        bundle.putFloat(keyForField(1), this.pitch);
        return bundle;
    }

    public String toString() {
        return Util.formatInvariant("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.speed), Float.valueOf(this.pitch));
    }

    public PlaybackParameters withSpeed(float f11) {
        return new PlaybackParameters(f11, this.pitch);
    }

    public PlaybackParameters(float f11, float f12) {
        boolean z11 = true;
        Assertions.checkArgument(f11 > 0.0f);
        Assertions.checkArgument(f12 <= 0.0f ? false : z11);
        this.speed = f11;
        this.pitch = f12;
        this.scaledUsPerMs = Math.round(f11 * 1000.0f);
    }
}
