package vx;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import ox.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static c f29372a;

    /* renamed from: vx.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0258a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29373a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.nostra13.universalimageloader.core.assist.ViewScaleType[] r0 = com.nostra13.universalimageloader.core.assist.ViewScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29373a = r0
                com.nostra13.universalimageloader.core.assist.ViewScaleType r1 = com.nostra13.universalimageloader.core.assist.ViewScaleType.FIT_INSIDE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29373a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.nostra13.universalimageloader.core.assist.ViewScaleType r1 = com.nostra13.universalimageloader.core.assist.ViewScaleType.CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: vx.a.C0258a.<clinit>():void");
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        f29372a = new c(max, max);
    }

    public static int a(c cVar, c cVar2, ViewScaleType viewScaleType, boolean z11) {
        int i11;
        int b11 = cVar.b();
        int a11 = cVar.a();
        int b12 = cVar2.b();
        int a12 = cVar2.a();
        int i12 = C0258a.f29373a[viewScaleType.ordinal()];
        int i13 = 1;
        if (i12 != 1) {
            if (i12 != 2) {
                i11 = 1;
            } else if (z11) {
                int i14 = b11 / 2;
                int i15 = a11 / 2;
                i11 = 1;
                while (i14 / i11 > b12 && i15 / i11 > a12) {
                    i11 *= 2;
                }
            } else {
                i11 = Math.min(b11 / b12, a11 / a12);
            }
        } else if (z11) {
            int i16 = b11 / 2;
            int i17 = a11 / 2;
            int i18 = 1;
            while (true) {
                if (i16 / i11 <= b12 && i17 / i11 <= a12) {
                    break;
                }
                i18 = i11 * 2;
            }
        } else {
            i11 = Math.max(b11 / b12, a11 / a12);
        }
        if (i11 >= 1) {
            i13 = i11;
        }
        return d(b11, a11, i13, z11);
    }

    public static float b(c cVar, c cVar2, ViewScaleType viewScaleType, boolean z11) {
        int b11 = cVar.b();
        int a11 = cVar.a();
        int b12 = cVar2.b();
        int a12 = cVar2.a();
        float f11 = (float) b11;
        float f12 = f11 / ((float) b12);
        float f13 = (float) a11;
        float f14 = f13 / ((float) a12);
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f12 < f14) && (viewScaleType != ViewScaleType.CROP || f12 >= f14)) {
            b12 = (int) (f11 / f14);
        } else {
            a12 = (int) (f13 / f12);
        }
        if ((z11 || b12 >= b11 || a12 >= a11) && (!z11 || b12 == b11 || a12 == a11)) {
            return 1.0f;
        }
        return ((float) b12) / f11;
    }

    public static int c(c cVar) {
        int b11 = cVar.b();
        int a11 = cVar.a();
        return Math.max((int) Math.ceil((double) (((float) b11) / ((float) f29372a.b()))), (int) Math.ceil((double) (((float) a11) / ((float) f29372a.a()))));
    }

    public static int d(int i11, int i12, int i13, boolean z11) {
        int b11 = f29372a.b();
        int a11 = f29372a.a();
        while (true) {
            if (i11 / i13 <= b11 && i12 / i13 <= a11) {
                return i13;
            }
            i13 = z11 ? i13 * 2 : i13 + 1;
        }
    }

    public static c e(sx.a aVar, c cVar) {
        int width = aVar.getWidth();
        if (width <= 0) {
            width = cVar.b();
        }
        int height = aVar.getHeight();
        if (height <= 0) {
            height = cVar.a();
        }
        return new c(width, height);
    }
}
