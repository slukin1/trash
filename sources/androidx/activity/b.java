package androidx.activity;

import android.window.BackEvent;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f3665a = new b();

    public final BackEvent a(float f11, float f12, float f13, int i11) {
        return new BackEvent(f11, f12, f13, i11);
    }

    public final float b(BackEvent backEvent) {
        return backEvent.getProgress();
    }

    public final int c(BackEvent backEvent) {
        return backEvent.getSwipeEdge();
    }

    public final float d(BackEvent backEvent) {
        return backEvent.getTouchX();
    }

    public final float e(BackEvent backEvent) {
        return backEvent.getTouchY();
    }
}
