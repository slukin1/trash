package com.jumio.jvision.jvcorejava.swig;

public class Quadrangle {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21264a;
    public transient boolean swigCMemOwn;

    public Quadrangle(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21264a = j11;
    }

    public static long getCPtr(Quadrangle quadrangle) {
        if (quadrangle == null) {
            return 0;
        }
        return quadrangle.f21264a;
    }

    public synchronized void delete() {
        long j11 = this.f21264a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Quadrangle(j11);
            }
            this.f21264a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public Point2f getBottomLeft() {
        return new Point2f(JVCoreJavaJNI.Quadrangle_getBottomLeft(this.f21264a, this), true);
    }

    public Point2f getBottomRight() {
        return new Point2f(JVCoreJavaJNI.Quadrangle_getBottomRight(this.f21264a, this), true);
    }

    public Point2f getTopLeft() {
        return new Point2f(JVCoreJavaJNI.Quadrangle_getTopLeft(this.f21264a, this), true);
    }

    public Point2f getTopRight() {
        return new Point2f(JVCoreJavaJNI.Quadrangle_getTopRight(this.f21264a, this), true);
    }

    public void setBottomLeft(Point2f point2f) {
        JVCoreJavaJNI.Quadrangle_setBottomLeft(this.f21264a, this, Point2f.getCPtr(point2f), point2f);
    }

    public void setBottomRight(Point2f point2f) {
        JVCoreJavaJNI.Quadrangle_setBottomRight(this.f21264a, this, Point2f.getCPtr(point2f), point2f);
    }

    public void setTopLeft(Point2f point2f) {
        JVCoreJavaJNI.Quadrangle_setTopLeft(this.f21264a, this, Point2f.getCPtr(point2f), point2f);
    }

    public void setTopRight(Point2f point2f) {
        JVCoreJavaJNI.Quadrangle_setTopRight(this.f21264a, this, Point2f.getCPtr(point2f), point2f);
    }

    public Quadrangle() {
        this(JVCoreJavaJNI.new_Quadrangle__SWIG_0(), true);
    }

    public Quadrangle(Point2f point2f, Point2f point2f2, Point2f point2f3, Point2f point2f4) {
        this(JVCoreJavaJNI.new_Quadrangle__SWIG_1(Point2f.getCPtr(point2f), point2f, Point2f.getCPtr(point2f2), point2f2, Point2f.getCPtr(point2f3), point2f3, Point2f.getCPtr(point2f4), point2f4), true);
    }
}
