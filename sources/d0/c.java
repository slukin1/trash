package d0;

import android.util.Range;
import android.util.Size;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.encoder.k1;
import androidx.core.util.h;
import java.util.HashSet;
import java.util.Set;

public class c implements k1 {

    /* renamed from: a  reason: collision with root package name */
    public final k1 f15607a;

    /* renamed from: b  reason: collision with root package name */
    public final Range<Integer> f15608b;

    /* renamed from: c  reason: collision with root package name */
    public final Range<Integer> f15609c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<Size> f15610d;

    public c(k1 k1Var, Size size) {
        HashSet hashSet = new HashSet();
        this.f15610d = hashSet;
        this.f15607a = k1Var;
        int h11 = k1Var.h();
        this.f15608b = Range.create(Integer.valueOf(h11), Integer.valueOf(((int) Math.ceil(4096.0d / ((double) h11))) * h11));
        int f11 = k1Var.f();
        this.f15609c = Range.create(Integer.valueOf(f11), Integer.valueOf(((int) Math.ceil(2160.0d / ((double) f11))) * f11));
        if (size != null) {
            hashSet.add(size);
        }
        hashSet.addAll(MediaCodecInfoReportIncorrectInfoQuirk.c());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.camera.video.internal.encoder.k1 i(androidx.camera.video.internal.encoder.k1 r4, android.util.Size r5) {
        /*
            boolean r0 = r4 instanceof d0.c
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0008
        L_0x0006:
            r1 = r2
            goto L_0x003e
        L_0x0008:
            java.lang.Class<androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk> r0 = androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk.class
            androidx.camera.core.impl.Quirk r0 = a0.a.a(r0)
            if (r0 == 0) goto L_0x0011
            goto L_0x003e
        L_0x0011:
            if (r5 == 0) goto L_0x0006
            int r0 = r5.getWidth()
            int r3 = r5.getHeight()
            boolean r0 = r4.g(r0, r3)
            if (r0 != 0) goto L_0x0006
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r5
            android.util.Range r2 = r4.d()
            r0[r1] = r2
            r2 = 2
            android.util.Range r3 = r4.e()
            r0[r2] = r3
            java.lang.String r2 = "Detected that the device does not support a size %s that should be valid in widths/heights = %s/%s"
            java.lang.String r0 = java.lang.String.format(r2, r0)
            java.lang.String r2 = "VideoEncoderInfoWrapper"
            androidx.camera.core.Logger.w(r2, r0)
        L_0x003e:
            if (r1 == 0) goto L_0x0046
            d0.c r0 = new d0.c
            r0.<init>(r4, r5)
            r4 = r0
        L_0x0046:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.c.i(androidx.camera.video.internal.encoder.k1, android.util.Size):androidx.camera.video.internal.encoder.k1");
    }

    public Range<Integer> a(int i11) {
        boolean z11 = this.f15609c.contains(Integer.valueOf(i11)) && i11 % this.f15607a.f() == 0;
        h.b(z11, "Not supported height: " + i11 + " which is not in " + this.f15609c + " or can not be divided by alignment " + this.f15607a.f());
        return this.f15608b;
    }

    public Range<Integer> b() {
        return this.f15607a.b();
    }

    public Range<Integer> c(int i11) {
        boolean z11 = this.f15608b.contains(Integer.valueOf(i11)) && i11 % this.f15607a.h() == 0;
        h.b(z11, "Not supported width: " + i11 + " which is not in " + this.f15608b + " or can not be divided by alignment " + this.f15607a.h());
        return this.f15609c;
    }

    public Range<Integer> d() {
        return this.f15608b;
    }

    public Range<Integer> e() {
        return this.f15609c;
    }

    public int f() {
        return this.f15607a.f();
    }

    public boolean g(int i11, int i12) {
        if (!this.f15610d.isEmpty() && this.f15610d.contains(new Size(i11, i12))) {
            return true;
        }
        if (!this.f15608b.contains(Integer.valueOf(i11)) || !this.f15609c.contains(Integer.valueOf(i12)) || i11 % this.f15607a.h() != 0 || i12 % this.f15607a.f() != 0) {
            return false;
        }
        return true;
    }

    public int h() {
        return this.f15607a.h();
    }
}
