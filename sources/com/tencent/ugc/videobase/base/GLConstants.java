package com.tencent.ugc.videobase.base;

public interface GLConstants {
    public static final float[] CUBE_VERTICES_ARRAYS = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final boolean DEBUG = false;
    public static final int DEFAULT_OFFSCREEN_HEIGHT = 128;
    public static final int DEFAULT_OFFSCREEN_WIDTH = 128;
    public static final float[] IDENTITY_MATRIX_3X3 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public static final int INVALID_FRAMEBUFFER = -1;
    public static final int INVALID_PROGRAM_ID = -1;
    public static final int INVALID_SHADER_ID = -1;
    public static final int NO_TEXTURE = -1;
    public static final float[] TEXTURE_COORDS_NO_ROTATION = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] TEXTURE_COORDS_ROTATED_180 = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};
    public static final float[] TEXTURE_COORDS_ROTATE_LEFT = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public static final float[] TEXTURE_COORDS_ROTATE_RIGHT = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    public enum ColorRange {
        UNKNOWN(0),
        VIDEO_RANGE(1),
        FULL_RANGE(2);
        
        private final int mJniValue;

        private ColorRange(int i11) {
            this.mJniValue = i11;
        }

        public static ColorRange fromInteger(int i11) {
            for (ColorRange colorRange : values()) {
                if (colorRange.mJniValue == i11) {
                    return colorRange;
                }
            }
            return UNKNOWN;
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

        public static ColorSpace fromInteger(int i11) {
            for (ColorSpace colorSpace : values()) {
                if (colorSpace.mJniValue == i11) {
                    return colorSpace;
                }
            }
            return UNKNOWN;
        }

        public final int getValue() {
            return this.mJniValue;
        }
    }

    public enum GLScaleType {
        CENTER_CROP(0),
        FIT_CENTER(1),
        FILL(2);
        
        private static final GLScaleType[] VALUES = null;
        public int mValue;

        /* access modifiers changed from: public */
        static {
            VALUES = values();
        }

        private GLScaleType(int i11) {
            this.mValue = i11;
        }

        public static GLScaleType fromInt(int i11) {
            for (GLScaleType gLScaleType : VALUES) {
                if (gLScaleType.mValue == i11) {
                    return gLScaleType;
                }
            }
            return FIT_CENTER;
        }

        public final int asInt() {
            return this.mValue;
        }
    }

    public enum PixelBufferType {
        BYTE_BUFFER(0),
        TEXTURE_2D(1),
        TEXTURE_OES(2),
        BYTE_ARRAY(3);
        
        private static final PixelBufferType[] VALUES = null;
        public int mValue;

        /* access modifiers changed from: public */
        static {
            VALUES = values();
        }

        private PixelBufferType(int i11) {
            this.mValue = i11;
        }

        public static PixelBufferType fromInteger(int i11) {
            for (PixelBufferType pixelBufferType : VALUES) {
                if (pixelBufferType.mValue == i11) {
                    return pixelBufferType;
                }
            }
            return TEXTURE_2D;
        }

        public final int getValue() {
            return this.mValue;
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
        
        private static final PixelFormatType[] VALUES = null;
        private final int mJniValue;

        /* access modifiers changed from: public */
        static {
            VALUES = values();
        }

        private PixelFormatType(int i11) {
            this.mJniValue = i11;
        }

        public static PixelFormatType fromInteger(int i11) {
            for (PixelFormatType pixelFormatType : VALUES) {
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
}
