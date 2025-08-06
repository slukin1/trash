package com.jumio.jvision.jvcorejava.swig;

public class Rect2i {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21265a;
    public transient boolean swigCMemOwn;

    public Rect2i(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21265a = j11;
    }

    public static long getCPtr(Rect2i rect2i) {
        if (rect2i == null) {
            return 0;
        }
        return rect2i.f21265a;
    }

    public int area() {
        return JVCoreJavaJNI.Rect2i_area(this.f21265a, this);
    }

    public synchronized void delete() {
        long j11 = this.f21265a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Rect2i(j11);
            }
            this.f21265a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getHeight() {
        return JVCoreJavaJNI.Rect2i_getHeight(this.f21265a, this);
    }

    public int getWidth() {
        return JVCoreJavaJNI.Rect2i_getWidth(this.f21265a, this);
    }

    public int getX() {
        return JVCoreJavaJNI.Rect2i_getX(this.f21265a, this);
    }

    public int getY() {
        return JVCoreJavaJNI.Rect2i_getY(this.f21265a, this);
    }

    public void setHeight(int i11) {
        JVCoreJavaJNI.Rect2i_setHeight(this.f21265a, this, i11);
    }

    public void setWidth(int i11) {
        JVCoreJavaJNI.Rect2i_setWidth(this.f21265a, this, i11);
    }

    public void setX(int i11) {
        JVCoreJavaJNI.Rect2i_setX(this.f21265a, this, i11);
    }

    public void setY(int i11) {
        JVCoreJavaJNI.Rect2i_setY(this.f21265a, this, i11);
    }

    public Rect2i() {
        this(JVCoreJavaJNI.new_Rect2i__SWIG_0(), true);
    }

    public Rect2i(int i11, int i12, int i13, int i14) {
        this(JVCoreJavaJNI.new_Rect2i__SWIG_1(i11, i12, i13, i14), true);
    }
}
