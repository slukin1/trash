package d0;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.h1;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final h1 f15611a;

    /* renamed from: b  reason: collision with root package name */
    public long f15612b = -1;

    /* renamed from: c  reason: collision with root package name */
    public Timebase f15613c;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f15614a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.camera.core.impl.Timebase[] r0 = androidx.camera.core.impl.Timebase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15614a = r0
                androidx.camera.core.impl.Timebase r1 = androidx.camera.core.impl.Timebase.REALTIME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15614a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.impl.Timebase r1 = androidx.camera.core.impl.Timebase.UPTIME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d0.d.a.<clinit>():void");
        }
    }

    public d(h1 h1Var, Timebase timebase) {
        this.f15611a = h1Var;
        this.f15613c = timebase;
    }

    public final long a() {
        long j11 = Long.MAX_VALUE;
        long j12 = 0;
        for (int i11 = 0; i11 < 3; i11++) {
            long b11 = this.f15611a.b();
            long a11 = this.f15611a.a();
            long b12 = this.f15611a.b();
            long j13 = b12 - b11;
            if (i11 == 0 || j13 < j11) {
                j12 = a11 - ((b11 + b12) >> 1);
                j11 = j13;
            }
        }
        return Math.max(0, j12);
    }

    public long b(long j11) {
        if (this.f15613c == null) {
            if (c(j11)) {
                this.f15613c = Timebase.REALTIME;
            } else {
                this.f15613c = Timebase.UPTIME;
            }
            Logger.d("VideoTimebaseConverter", "Detect input timebase = " + this.f15613c);
        }
        int i11 = a.f15614a[this.f15613c.ordinal()];
        if (i11 == 1) {
            if (this.f15612b == -1) {
                this.f15612b = a();
                Logger.d("VideoTimebaseConverter", "mUptimeToRealtimeOffsetUs = " + this.f15612b);
            }
            return j11 - this.f15612b;
        } else if (i11 == 2) {
            return j11;
        } else {
            throw new AssertionError("Unknown timebase: " + this.f15613c);
        }
    }

    public final boolean c(long j11) {
        return Math.abs(j11 - this.f15611a.a()) < Math.abs(j11 - this.f15611a.b());
    }
}
