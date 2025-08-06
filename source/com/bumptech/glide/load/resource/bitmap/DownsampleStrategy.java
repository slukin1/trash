package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;

public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f64053a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f64054b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f64055c = new e();

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f64056d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f64057e;

    /* renamed from: f  reason: collision with root package name */
    public static final DownsampleStrategy f64058f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final DownsampleStrategy f64059g;

    /* renamed from: h  reason: collision with root package name */
    public static final n3.d<DownsampleStrategy> f64060h;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f64061i = (Build.VERSION.SDK_INT >= 19);

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    public static class a extends DownsampleStrategy {
        public SampleSizeRounding a(int i11, int i12, int i13, int i14) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i11, int i12, int i13, int i14) {
            int min = Math.min(i12 / i14, i11 / i13);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }
    }

    public static class b extends DownsampleStrategy {
        public SampleSizeRounding a(int i11, int i12, int i13, int i14) {
            return SampleSizeRounding.MEMORY;
        }

        public float b(int i11, int i12, int i13, int i14) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i12) / ((float) i14), ((float) i11) / ((float) i13)));
            int i15 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i15 = 0;
            }
            return 1.0f / ((float) (max << i15));
        }
    }

    public static class c extends DownsampleStrategy {
        public SampleSizeRounding a(int i11, int i12, int i13, int i14) {
            if (b(i11, i12, i13, i14) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return DownsampleStrategy.f64055c.a(i11, i12, i13, i14);
        }

        public float b(int i11, int i12, int i13, int i14) {
            return Math.min(1.0f, DownsampleStrategy.f64055c.b(i11, i12, i13, i14));
        }
    }

    public static class d extends DownsampleStrategy {
        public SampleSizeRounding a(int i11, int i12, int i13, int i14) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i11, int i12, int i13, int i14) {
            return Math.max(((float) i13) / ((float) i11), ((float) i14) / ((float) i12));
        }
    }

    public static class e extends DownsampleStrategy {
        public SampleSizeRounding a(int i11, int i12, int i13, int i14) {
            if (DownsampleStrategy.f64061i) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }

        public float b(int i11, int i12, int i13, int i14) {
            if (DownsampleStrategy.f64061i) {
                return Math.min(((float) i13) / ((float) i11), ((float) i14) / ((float) i12));
            }
            int max = Math.max(i12 / i14, i11 / i13);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(max));
        }
    }

    public static class f extends DownsampleStrategy {
        public SampleSizeRounding a(int i11, int i12, int i13, int i14) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i11, int i12, int i13, int i14) {
            return 1.0f;
        }
    }

    static {
        d dVar = new d();
        f64057e = dVar;
        f64059g = dVar;
        f64060h = n3.d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
    }

    public abstract SampleSizeRounding a(int i11, int i12, int i13, int i14);

    public abstract float b(int i11, int i12, int i13, int i14);
}
