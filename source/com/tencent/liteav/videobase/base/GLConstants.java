package com.tencent.liteav.videobase.base;

public interface GLConstants {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f22071a = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f22072b = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f22073c = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f22074d = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: e  reason: collision with root package name */
    public static final float[] f22075e = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: f  reason: collision with root package name */
    public static final float[] f22076f = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f22077g = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f22078h = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    public enum ColorRange {
        UNKNOWN(0),
        VIDEO_RANGE(1),
        FULL_RANGE(2);
        
        private final int mJniValue;

        private ColorRange(int i11) {
            this.mJniValue = i11;
        }

        public final int getValue() {
            return this.mJniValue;
        }
    }

    public enum ColorSpace {
        UNKNOWN(0),
        BT601(1),
        BT709(2);
        
        private final int mJniValue;

        private ColorSpace(int i11) {
            this.mJniValue = i11;
        }

        public final int getValue() {
            return this.mJniValue;
        }
    }

    public enum GLScaleType {
        CENTER_CROP(0),
        FIT_CENTER(1),
        FILL(2);
        

        /* renamed from: d  reason: collision with root package name */
        private static final GLScaleType[] f22090d = null;
        public int mValue;

        /* access modifiers changed from: public */
        static {
            f22090d = values();
        }

        private GLScaleType(int i11) {
            this.mValue = i11;
        }

        public static GLScaleType a(int i11) {
            for (GLScaleType gLScaleType : f22090d) {
                if (gLScaleType.mValue == i11) {
                    return gLScaleType;
                }
            }
            return FIT_CENTER;
        }
    }

    public enum PixelFormatType {
        I420(0),
        NV12(1),
        NV21(2),
        RGB(3),
        YUY2(4),
        RGBA(5),
        BGR(6),
        YV12(7),
        BGRA(8),
        ARGB(9),
        YUV422P(10),
        UYVY(11),
        YUYV(12),
        JPG(13),
        H264(14),
        MAX(100);
        

        /* renamed from: q  reason: collision with root package name */
        private static final PixelFormatType[] f22108q = null;
        private final int mJniValue;

        /* access modifiers changed from: public */
        static {
            f22108q = values();
        }

        private PixelFormatType(int i11) {
            this.mJniValue = i11;
        }

        public static PixelFormatType a(int i11) {
            for (PixelFormatType pixelFormatType : f22108q) {
                if (pixelFormatType.mJniValue == i11) {
                    return pixelFormatType;
                }
            }
            return null;
        }

        public final int getValue() {
            return this.mJniValue;
        }
    }

    public enum a {
        BYTE_BUFFER(0),
        TEXTURE_2D(1),
        TEXTURE_OES(2),
        BYTE_ARRAY(3);
        

        /* renamed from: e  reason: collision with root package name */
        private static final a[] f22114e = null;
        public int mValue;

        /* access modifiers changed from: public */
        static {
            f22114e = values();
        }

        private a(int i11) {
            this.mValue = i11;
        }

        public static a a(int i11) {
            for (a aVar : f22114e) {
                if (aVar.mValue == i11) {
                    return aVar;
                }
            }
            return TEXTURE_2D;
        }
    }
}
