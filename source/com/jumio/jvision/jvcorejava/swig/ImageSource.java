package com.jumio.jvision.jvcorejava.swig;

public class ImageSource {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21258a;
    public transient boolean swigCMemOwn;

    public ImageSource(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21258a = j11;
    }

    public static ImageSource CreateFromEncodedByteArray(byte[] bArr) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_CreateFromEncodedByteArray(bArr), true);
    }

    public static ImageSource CreateFromFileSystem(String str) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_CreateFromFileSystem(str), true);
    }

    public static ImageSource CreateFromUncompressedByteArray(byte[] bArr, int i11, int i12, ImageFormat imageFormat, int i13) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_CreateFromUncompressedByteArray(bArr, i11, i12, imageFormat.swigValue(), i13), true);
    }

    public static ImageSource Crop(ImageSource imageSource, Rect2i rect2i) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_Crop(getCPtr(imageSource), imageSource, Rect2i.getCPtr(rect2i), rect2i), true);
    }

    public static ImageSource CropRotate(ImageSource imageSource, Rect2i rect2i, int i11) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_CropRotate(getCPtr(imageSource), imageSource, Rect2i.getCPtr(rect2i), rect2i, i11), true);
    }

    public static ImageSource CropRotateScale(ImageSource imageSource, Rect2i rect2i, int i11, Size2i size2i) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_CropRotateScale(getCPtr(imageSource), imageSource, Rect2i.getCPtr(rect2i), rect2i, i11, Size2i.getCPtr(size2i), size2i), true);
    }

    public static ImageSource Rotate(ImageSource imageSource, int i11) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_Rotate(getCPtr(imageSource), imageSource, i11), true);
    }

    public static ImageSource Warp(ImageSource imageSource, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, Size2i size2i) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_Warp__SWIG_0(getCPtr(imageSource), imageSource, f11, f12, f13, f14, f15, f16, f17, f18, Size2i.getCPtr(size2i), size2i), true);
    }

    public static long getCPtr(ImageSource imageSource) {
        if (imageSource == null) {
            return 0;
        }
        return imageSource.f21258a;
    }

    public int Height() {
        return JVCoreJavaJNI.ImageSource_Height(this.f21258a, this);
    }

    public int Length() {
        return JVCoreJavaJNI.ImageSource_Length(this.f21258a, this);
    }

    public int Stride() {
        return JVCoreJavaJNI.ImageSource_Stride(this.f21258a, this);
    }

    public int Width() {
        return JVCoreJavaJNI.ImageSource_Width(this.f21258a, this);
    }

    public synchronized void delete() {
        long j11 = this.f21258a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_ImageSource(j11);
            }
            this.f21258a = 0;
        }
    }

    public boolean empty() {
        return JVCoreJavaJNI.ImageSource_empty(this.f21258a, this);
    }

    public void finalize() {
        delete();
    }

    public Image getGray() {
        return new Image(JVCoreJavaJNI.ImageSource_getGray(this.f21258a, this), true);
    }

    public Image getImage() {
        return new Image(JVCoreJavaJNI.ImageSource_getImage(this.f21258a, this), true);
    }

    public Image getRGB() {
        return new Image(JVCoreJavaJNI.ImageSource_getRGB(this.f21258a, this), true);
    }

    public static ImageSource Warp(ImageSource imageSource, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, float f22, float f23, Size2i size2i) {
        return new ImageSource(JVCoreJavaJNI.ImageSource_Warp__SWIG_1(getCPtr(imageSource), imageSource, f11, f12, f13, f14, f15, f16, f17, f18, f19, f21, f22, f23, Size2i.getCPtr(size2i), size2i), true);
    }

    public ImageSource() {
        this(JVCoreJavaJNI.new_ImageSource__SWIG_0(), true);
    }

    public ImageSource(ImageSource imageSource) {
        this(JVCoreJavaJNI.new_ImageSource__SWIG_1(getCPtr(imageSource), imageSource), true);
    }
}
