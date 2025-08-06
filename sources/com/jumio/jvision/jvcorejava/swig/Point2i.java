package com.jumio.jvision.jvcorejava.swig;

public class Point2i {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21263a;
    public transient boolean swigCMemOwn;

    public Point2i(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21263a = j11;
    }

    public static long getCPtr(Point2i point2i) {
        if (point2i == null) {
            return 0;
        }
        return point2i.f21263a;
    }

    public synchronized void delete() {
        long j11 = this.f21263a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Point2i(j11);
            }
            this.f21263a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getX() {
        return JVCoreJavaJNI.Point2i_getX(this.f21263a, this);
    }

    public int getY() {
        return JVCoreJavaJNI.Point2i_getY(this.f21263a, this);
    }

    public void setX(int i11) {
        JVCoreJavaJNI.Point2i_setX(this.f21263a, this, i11);
    }

    public void setY(int i11) {
        JVCoreJavaJNI.Point2i_setY(this.f21263a, this, i11);
    }

    public Point2i() {
        this(JVCoreJavaJNI.new_Point2i__SWIG_0(), true);
    }

    public Point2i(int i11, int i12) {
        this(JVCoreJavaJNI.new_Point2i__SWIG_1(i11, i12), true);
    }
}
