package bx;

import android.content.Context;
import android.media.AudioManager;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f23486a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f23487b;

    public b(Context context) {
        this.f23486a = context;
        this.f23487b = (AudioManager) context.getSystemService("audio");
    }

    public final double a() {
        double d11 = (double) 10000;
        return Math.rint((((double) this.f23487b.getStreamVolume(3)) / ((double) this.f23487b.getStreamMaxVolume(3))) * d11) / d11;
    }

    public final void b(double d11, boolean z11) {
        double d12 = 1.0d;
        if (d11 <= 1.0d) {
            d12 = d11;
        }
        if (d11 < 0.0d) {
            d12 = 0.0d;
        }
        this.f23487b.setStreamVolume(3, (int) Math.rint(d12 * ((double) this.f23487b.getStreamMaxVolume(3))), z11 ? 1 : 0);
    }
}
