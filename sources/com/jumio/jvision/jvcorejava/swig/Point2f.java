package com.jumio.jvision.jvcorejava.swig;

public class Point2f {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21262a;
    public transient boolean swigCMemOwn;

    public Point2f(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21262a = j11;
    }

    public static long getCPtr(Point2f point2f) {
        if (point2f == null) {
            return 0;
        }
        return point2f.f21262a;
    }

    public synchronized void delete() {
        long j11 = this.f21262a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Point2f(j11);
            }
            this.f21262a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public float getX() {
        return JVCoreJavaJNI.Point2f_getX(this.f21262a, this);
    }

    public float getY() {
        return JVCoreJavaJNI.Point2f_getY(this.f21262a, this);
    }

    public void setX(float f11) {
        JVCoreJavaJNI.Point2f_setX(this.f21262a, this, f11);
    }

    public void setY(float f11) {
        JVCoreJavaJNI.Point2f_setY(this.f21262a, this, f11);
    }

    public Point2f() {
        this(JVCoreJavaJNI.new_Point2f__SWIG_0(), true);
    }

    public Point2f(float f11, float f12) {
        this(JVCoreJavaJNI.new_Point2f__SWIG_1(f11, f12), true);
    }
}
