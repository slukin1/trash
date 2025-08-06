package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.i;
import f4.h;
import f4.i;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import n3.d;

public final class e {

    /* renamed from: f  reason: collision with root package name */
    public static final d<DecodeFormat> f64078f = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);

    /* renamed from: g  reason: collision with root package name */
    public static final d<PreferredColorSpace> f64079g = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public static final d<DownsampleStrategy> f64080h = DownsampleStrategy.f64060h;

    /* renamed from: i  reason: collision with root package name */
    public static final d<Boolean> f64081i;

    /* renamed from: j  reason: collision with root package name */
    public static final d<Boolean> f64082j;

    /* renamed from: k  reason: collision with root package name */
    public static final Set<String> f64083k = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));

    /* renamed from: l  reason: collision with root package name */
    public static final b f64084l = new a();

    /* renamed from: m  reason: collision with root package name */
    public static final Set<ImageHeaderParser.ImageType> f64085m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: n  reason: collision with root package name */
    public static final Queue<BitmapFactory.Options> f64086n = i.f(0);

    /* renamed from: a  reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f64087a;

    /* renamed from: b  reason: collision with root package name */
    public final DisplayMetrics f64088b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f64089c;

    /* renamed from: d  reason: collision with root package name */
    public final List<ImageHeaderParser> f64090d;

    /* renamed from: e  reason: collision with root package name */
    public final h f64091e = h.a();

    public class a implements b {
        public void a() {
        }

        public void b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        }
    }

    public interface b {
        void a();

        void b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) throws IOException;
    }

    static {
        Boolean bool = Boolean.FALSE;
        f64081i = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f64082j = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public e(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f64090d = list;
        this.f64088b = (DisplayMetrics) h.d(displayMetrics);
        this.f64087a = (com.bumptech.glide.load.engine.bitmap_recycle.e) h.d(eVar);
        this.f64089c = (com.bumptech.glide.load.engine.bitmap_recycle.b) h.d(bVar);
    }

    public static int a(double d11) {
        int l11 = l(d11);
        int x11 = x(((double) l11) * d11);
        return x((d11 / ((double) (((float) x11) / ((float) l11)))) * ((double) x11));
    }

    public static void c(ImageHeaderParser.ImageType imageType, i iVar, b bVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, DownsampleStrategy downsampleStrategy, int i11, int i12, int i13, int i14, int i15, BitmapFactory.Options options) throws IOException {
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        double d11;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i23 = i12;
        int i24 = i13;
        int i25 = i14;
        int i26 = i15;
        BitmapFactory.Options options2 = options;
        if (i23 <= 0 || i24 <= 0) {
            String str = "Downsampler";
            String str2 = "x";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to determine dimensions for: " + imageType2 + " with target [" + i25 + str2 + i26 + "]");
                return;
            }
            return;
        }
        if (r(i11)) {
            i16 = i23;
            i17 = i24;
        } else {
            i17 = i23;
            i16 = i24;
        }
        float b11 = downsampleStrategy2.b(i17, i16, i25, i26);
        if (b11 > 0.0f) {
            DownsampleStrategy.SampleSizeRounding a11 = downsampleStrategy2.a(i17, i16, i25, i26);
            if (a11 != null) {
                float f11 = (float) i17;
                float f12 = (float) i16;
                int x11 = i17 / x((double) (b11 * f11));
                int x12 = i16 / x((double) (b11 * f12));
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                if (a11 == sampleSizeRounding) {
                    i18 = Math.max(x11, x12);
                } else {
                    i18 = Math.min(x11, x12);
                }
                int i27 = Build.VERSION.SDK_INT;
                String str3 = "x";
                String str4 = "Downsampler";
                if (i27 > 23 || !f64083k.contains(options2.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(i18));
                    if (a11 == sampleSizeRounding && ((float) max) < 1.0f / b11) {
                        max <<= 1;
                    }
                    i19 = max;
                } else {
                    i19 = 1;
                }
                options2.inSampleSize = i19;
                if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                    float min = (float) Math.min(i19, 8);
                    i21 = (int) Math.ceil((double) (f11 / min));
                    i22 = (int) Math.ceil((double) (f12 / min));
                    int i28 = i19 / 8;
                    if (i28 > 0) {
                        i21 /= i28;
                        i22 /= i28;
                    }
                } else {
                    if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                        float f13 = (float) i19;
                        i21 = (int) Math.floor((double) (f11 / f13));
                        d11 = Math.floor((double) (f12 / f13));
                    } else if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                        if (i27 >= 24) {
                            float f14 = (float) i19;
                            i21 = Math.round(f11 / f14);
                            i22 = Math.round(f12 / f14);
                        } else {
                            float f15 = (float) i19;
                            i21 = (int) Math.floor((double) (f11 / f15));
                            d11 = Math.floor((double) (f12 / f15));
                        }
                    } else if (i17 % i19 == 0 && i16 % i19 == 0) {
                        i21 = i17 / i19;
                        i22 = i16 / i19;
                    } else {
                        int[] m11 = m(iVar, options2, bVar, eVar);
                        i21 = m11[0];
                        i22 = m11[1];
                    }
                    i22 = (int) d11;
                }
                double b12 = (double) downsampleStrategy2.b(i21, i22, i25, i26);
                if (i27 >= 19) {
                    options2.inTargetDensity = a(b12);
                    options2.inDensity = l(b12);
                }
                if (s(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                String str5 = str4;
                if (Log.isLoggable(str5, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calculate scaling, source: [");
                    sb2.append(i12);
                    String str6 = str3;
                    sb2.append(str6);
                    sb2.append(i13);
                    sb2.append("], degreesToRotate: ");
                    sb2.append(i11);
                    sb2.append(", target: [");
                    sb2.append(i25);
                    sb2.append(str6);
                    sb2.append(i26);
                    sb2.append("], power of two scaled: [");
                    sb2.append(i21);
                    sb2.append(str6);
                    sb2.append(i22);
                    sb2.append("], exact scale factor: ");
                    sb2.append(b11);
                    sb2.append(", power of 2 sample size: ");
                    sb2.append(i19);
                    sb2.append(", adjusted scale factor: ");
                    sb2.append(b12);
                    sb2.append(", target density: ");
                    sb2.append(options2.inTargetDensity);
                    sb2.append(", density: ");
                    sb2.append(options2.inDensity);
                    Log.v(str5, sb2.toString());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        int i29 = i23;
        String str7 = "x";
        throw new IllegalArgumentException("Cannot scale with factor: " + b11 + " from: " + downsampleStrategy2 + ", source: [" + i29 + str7 + i24 + "], target: [" + i25 + str7 + i26 + "]");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap i(com.bumptech.glide.load.resource.bitmap.i r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.e.b r7, com.bumptech.glide.load.engine.bitmap_recycle.e r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto L_0x000c
            r7.a()
            r5.a()
        L_0x000c:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.o.i()
            r4.lock()
            android.graphics.Bitmap r5 = r5.c(r6)     // Catch:{ IllegalArgumentException -> 0x0027 }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.o.i()
            r6.unlock()
            return r5
        L_0x0025:
            r5 = move-exception
            goto L_0x0050
        L_0x0027:
            r4 = move-exception
            java.io.IOException r1 = u(r4, r1, r2, r3, r6)     // Catch:{ all -> 0x0025 }
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch:{ all -> 0x0025 }
        L_0x0038:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x004f
            r8.c(r0)     // Catch:{ IOException -> 0x004e }
            r0 = 0
            r6.inBitmap = r0     // Catch:{ IOException -> 0x004e }
            android.graphics.Bitmap r5 = i(r5, r6, r7, r8)     // Catch:{ IOException -> 0x004e }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.o.i()
            r6.unlock()
            return r5
        L_0x004e:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x004f:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0050:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.o.i()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.e.i(com.bumptech.glide.load.resource.bitmap.i, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.e$b, com.bumptech.glide.load.engine.bitmap_recycle.e):android.graphics.Bitmap");
    }

    @TargetApi(19)
    public static String j(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    public static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options poll;
        synchronized (e.class) {
            Queue<BitmapFactory.Options> queue = f64086n;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                w(poll);
            }
        }
        return poll;
    }

    public static int l(double d11) {
        if (d11 > 1.0d) {
            d11 = 1.0d / d11;
        }
        return (int) Math.round(d11 * 2.147483647E9d);
    }

    public static int[] m(i iVar, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        i(iVar, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    public static boolean r(int i11) {
        return i11 == 90 || i11 == 270;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.inDensity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean s(android.graphics.BitmapFactory.Options r1) {
        /*
            int r0 = r1.inTargetDensity
            if (r0 <= 0) goto L_0x000c
            int r1 = r1.inDensity
            if (r1 <= 0) goto L_0x000c
            if (r0 == r1) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.e.s(android.graphics.BitmapFactory$Options):boolean");
    }

    public static void t(int i11, int i12, String str, BitmapFactory.Options options, Bitmap bitmap, int i13, int i14, long j11) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i11 + "x" + i12 + "] " + str + " with inBitmap " + n(options) + " for [" + i13 + "x" + i14 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + f4.e.a(j11));
    }

    public static IOException u(IllegalArgumentException illegalArgumentException, int i11, int i12, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i11 + ", outHeight: " + i12 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    public static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = f64086n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    public static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int x(double d11) {
        return (int) (d11 + 0.5d);
    }

    @TargetApi(26)
    public static void y(BitmapFactory.Options options, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, int i11, int i12) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.e(i11, i12, config);
    }

    public final void b(i iVar, DecodeFormat decodeFormat, boolean z11, boolean z12, BitmapFactory.Options options, int i11, int i12) {
        if (!this.f64091e.e(i11, i12, options, z11, z12)) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z13 = false;
            try {
                z13 = iVar.d().hasAlpha();
            } catch (IOException e11) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e11);
                }
            }
            Bitmap.Config config = z13 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    public r<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i11, int i12, Options options) throws IOException {
        return e(new i.b(parcelFileDescriptor, this.f64090d, this.f64089c), i11, i12, options, f64084l);
    }

    public final r<Bitmap> e(i iVar, int i11, int i12, Options options, b bVar) throws IOException {
        Options options2 = options;
        byte[] bArr = (byte[]) this.f64089c.c(65536, byte[].class);
        BitmapFactory.Options k11 = k();
        k11.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options2.a(f64078f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options2.a(f64079g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options2.a(DownsampleStrategy.f64060h);
        boolean booleanValue = ((Boolean) options2.a(f64081i)).booleanValue();
        d dVar = f64082j;
        try {
            return c.c(h(iVar, k11, downsampleStrategy, decodeFormat, preferredColorSpace, options2.a(dVar) != null && ((Boolean) options2.a(dVar)).booleanValue(), i11, i12, booleanValue, bVar), this.f64087a);
        } finally {
            v(k11);
            this.f64089c.put(bArr);
        }
    }

    public r<Bitmap> f(InputStream inputStream, int i11, int i12, Options options) throws IOException {
        return g(inputStream, i11, i12, options, f64084l);
    }

    public r<Bitmap> g(InputStream inputStream, int i11, int i12, Options options, b bVar) throws IOException {
        return e(new i.a(inputStream, this.f64090d, this.f64089c), i11, i12, options, bVar);
    }

    public final Bitmap h(i iVar, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z11, int i11, int i12, boolean z12, b bVar) throws IOException {
        int i13;
        int i14;
        e eVar;
        int i15;
        ColorSpace colorSpace;
        int i16;
        int i17;
        BitmapFactory.Options options2 = options;
        b bVar2 = bVar;
        long b11 = f4.e.b();
        int[] m11 = m(iVar, options2, bVar2, this.f64087a);
        boolean z13 = false;
        int i18 = m11[0];
        int i19 = m11[1];
        String str = options2.outMimeType;
        boolean z14 = (i18 == -1 || i19 == -1) ? false : z11;
        int b12 = iVar.b();
        int j11 = o.j(b12);
        boolean m12 = o.m(b12);
        int i21 = i11;
        if (i21 == Integer.MIN_VALUE) {
            i14 = i12;
            i13 = r(j11) ? i19 : i18;
        } else {
            i14 = i12;
            i13 = i21;
        }
        int i22 = i14 == Integer.MIN_VALUE ? r(j11) ? i18 : i19 : i14;
        ImageHeaderParser.ImageType d11 = iVar.d();
        com.bumptech.glide.load.engine.bitmap_recycle.e eVar2 = this.f64087a;
        ImageHeaderParser.ImageType imageType = d11;
        c(d11, iVar, bVar, eVar2, downsampleStrategy, j11, i18, i19, i13, i22, options);
        int i23 = b12;
        String str2 = str;
        int i24 = i19;
        int i25 = i18;
        b bVar3 = bVar2;
        BitmapFactory.Options options3 = options2;
        b(iVar, decodeFormat, z14, m12, options, i13, i22);
        int i26 = Build.VERSION.SDK_INT;
        boolean z15 = i26 >= 19;
        if (options3.inSampleSize == 1 || z15) {
            eVar = this;
            if (eVar.z(imageType)) {
                if (i25 < 0 || i24 < 0 || !z12 || !z15) {
                    float f11 = s(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int i27 = options3.inSampleSize;
                    float f12 = (float) i27;
                    float f13 = f11;
                    i17 = Math.round(((float) ((int) Math.ceil((double) (((float) i25) / f12)))) * f13);
                    i16 = Math.round(((float) ((int) Math.ceil((double) (((float) i24) / f12)))) * f13);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + i17 + "x" + i16 + "] for source [" + i25 + "x" + i24 + "], sampleSize: " + i27 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f13);
                    }
                } else {
                    i17 = i13;
                    i16 = i22;
                }
                if (i17 > 0 && i16 > 0) {
                    y(options3, eVar.f64087a, i17, i16);
                }
            }
        } else {
            eVar = this;
        }
        if (i26 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options3.outColorSpace) != null && colorSpace.isWideGamut()) {
                z13 = true;
            }
            options3.inPreferredColorSpace = ColorSpace.get(z13 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i26 >= 26) {
            options3.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap i28 = i(iVar, options3, bVar3, eVar.f64087a);
        bVar3.b(eVar.f64087a, i28);
        if (Log.isLoggable("Downsampler", 2)) {
            i15 = i23;
            t(i25, i24, str2, options, i28, i11, i12, b11);
        } else {
            i15 = i23;
        }
        Bitmap bitmap = null;
        if (i28 != null) {
            i28.setDensity(eVar.f64088b.densityDpi);
            bitmap = o.n(eVar.f64087a, i28, i15);
            if (!i28.equals(bitmap)) {
                eVar.f64087a.c(i28);
            }
        }
        return bitmap;
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.a();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }

    public final boolean z(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f64085m.contains(imageType);
    }
}
