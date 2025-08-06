package com.jumio.jvision.jvcorejava.swig;

public final class ImageFormat {
    public static final ImageFormat BGR;
    public static final ImageFormat BGRA;
    public static final ImageFormat GRAY;
    public static final ImageFormat RGB;
    public static final ImageFormat RGBA;
    public static final ImageFormat YUVNV21;
    public static final ImageFormat YUVYV12;

    /* renamed from: c  reason: collision with root package name */
    public static final ImageFormat[] f21255c;

    /* renamed from: a  reason: collision with root package name */
    public final int f21256a;

    /* renamed from: b  reason: collision with root package name */
    public final String f21257b;

    static {
        ImageFormat imageFormat = new ImageFormat("GRAY", JVCoreJavaJNI.ImageFormat_GRAY_get());
        GRAY = imageFormat;
        ImageFormat imageFormat2 = new ImageFormat("RGB", JVCoreJavaJNI.ImageFormat_RGB_get());
        RGB = imageFormat2;
        ImageFormat imageFormat3 = new ImageFormat("BGR", JVCoreJavaJNI.ImageFormat_BGR_get());
        BGR = imageFormat3;
        ImageFormat imageFormat4 = new ImageFormat("RGBA", JVCoreJavaJNI.ImageFormat_RGBA_get());
        RGBA = imageFormat4;
        ImageFormat imageFormat5 = new ImageFormat("BGRA", JVCoreJavaJNI.ImageFormat_BGRA_get());
        BGRA = imageFormat5;
        ImageFormat imageFormat6 = new ImageFormat("YUVNV21", JVCoreJavaJNI.ImageFormat_YUVNV21_get());
        YUVNV21 = imageFormat6;
        ImageFormat imageFormat7 = new ImageFormat("YUVYV12", JVCoreJavaJNI.ImageFormat_YUVYV12_get());
        YUVYV12 = imageFormat7;
        f21255c = new ImageFormat[]{imageFormat, imageFormat2, imageFormat3, imageFormat4, imageFormat5, imageFormat6, imageFormat7};
    }

    public ImageFormat(String str, int i11) {
        this.f21257b = str;
        this.f21256a = i11;
    }

    public static ImageFormat swigToEnum(int i11) {
        ImageFormat[] imageFormatArr = f21255c;
        if (i11 < imageFormatArr.length && i11 >= 0) {
            ImageFormat imageFormat = imageFormatArr[i11];
            if (imageFormat.f21256a == i11) {
                return imageFormat;
            }
        }
        int i12 = 0;
        while (true) {
            ImageFormat[] imageFormatArr2 = f21255c;
            if (i12 < imageFormatArr2.length) {
                ImageFormat imageFormat2 = imageFormatArr2[i12];
                if (imageFormat2.f21256a == i11) {
                    return imageFormat2;
                }
                i12++;
            } else {
                throw new IllegalArgumentException("No enum " + ImageFormat.class + " with value " + i11);
            }
        }
    }

    public final int swigValue() {
        return this.f21256a;
    }

    public String toString() {
        return this.f21257b;
    }
}
