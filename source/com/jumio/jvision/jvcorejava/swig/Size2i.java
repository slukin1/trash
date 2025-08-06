package com.jumio.jvision.jvcorejava.swig;

public class Size2i {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21266a;
    public transient boolean swigCMemOwn;

    public Size2i(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21266a = j11;
    }

    public static long getCPtr(Size2i size2i) {
        if (size2i == null) {
            return 0;
        }
        return size2i.f21266a;
    }

    public synchronized void delete() {
        long j11 = this.f21266a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Size2i(j11);
            }
            this.f21266a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getHeight() {
        return JVCoreJavaJNI.Size2i_getHeight(this.f21266a, this);
    }

    public int getWidth() {
        return JVCoreJavaJNI.Size2i_getWidth(this.f21266a, this);
    }

    public void setHeight(int i11) {
        JVCoreJavaJNI.Size2i_setHeight(this.f21266a, this, i11);
    }

    public void setWidth(int i11) {
        JVCoreJavaJNI.Size2i_setWidth(this.f21266a, this, i11);
    }

    public Size2i() {
        this(JVCoreJavaJNI.new_Size2i__SWIG_0(), true);
    }

    public Size2i(int i11, int i12) {
        this(JVCoreJavaJNI.new_Size2i__SWIG_1(i11, i12), true);
    }
}
