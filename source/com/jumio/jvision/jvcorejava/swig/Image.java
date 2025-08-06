package com.jumio.jvision.jvcorejava.swig;

public class Image {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21254a;
    public transient boolean swigCMemOwn;

    public Image(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21254a = j11;
    }

    public static long getCPtr(Image image) {
        if (image == null) {
            return 0;
        }
        return image.f21254a;
    }

    public int channelDepth() {
        return JVCoreJavaJNI.Image_channelDepth(this.f21254a, this);
    }

    public int channels() {
        return JVCoreJavaJNI.Image_channels(this.f21254a, this);
    }

    public synchronized void delete() {
        long j11 = this.f21254a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Image(j11);
            }
            this.f21254a = 0;
        }
    }

    public boolean empty() {
        return JVCoreJavaJNI.Image_empty(this.f21254a, this);
    }

    public void finalize() {
        delete();
    }

    public ImageFormat format() {
        return ImageFormat.swigToEnum(JVCoreJavaJNI.Image_format(this.f21254a, this));
    }

    public void getBytes(byte[] bArr) {
        JVCoreJavaJNI.Image_getBytes(this.f21254a, this, bArr);
    }

    public int height() {
        return JVCoreJavaJNI.Image_height(this.f21254a, this);
    }

    public int length() {
        return JVCoreJavaJNI.Image_length(this.f21254a, this);
    }

    public int stride() {
        return JVCoreJavaJNI.Image_stride(this.f21254a, this);
    }

    public byte[] toBytes() {
        byte[] bArr = new byte[length()];
        getBytes(bArr);
        return bArr;
    }

    public int width() {
        return JVCoreJavaJNI.Image_width(this.f21254a, this);
    }

    public Image() {
        this(JVCoreJavaJNI.new_Image(), true);
    }
}
