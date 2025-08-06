package com.jumio.jvision.jvcorejava.swig;

import java.util.AbstractList;
import java.util.RandomAccess;

public class ImageSourceVector extends AbstractList<ImageSource> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21259a;
    public transient boolean swigCMemOwn;

    public ImageSourceVector(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21259a = j11;
    }

    public static long getCPtr(ImageSourceVector imageSourceVector) {
        if (imageSourceVector == null) {
            return 0;
        }
        return imageSourceVector.f21259a;
    }

    public long capacity() {
        return JVCoreJavaJNI.ImageSourceVector_capacity(this.f21259a, this);
    }

    public void clear() {
        JVCoreJavaJNI.ImageSourceVector_clear(this.f21259a, this);
    }

    public synchronized void delete() {
        long j11 = this.f21259a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_ImageSourceVector(j11);
            }
            this.f21259a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public boolean isEmpty() {
        return JVCoreJavaJNI.ImageSourceVector_isEmpty(this.f21259a, this);
    }

    public void removeRange(int i11, int i12) {
        this.modCount++;
        JVCoreJavaJNI.ImageSourceVector_doRemoveRange(this.f21259a, this, i11, i12);
    }

    public void reserve(long j11) {
        JVCoreJavaJNI.ImageSourceVector_reserve(this.f21259a, this, j11);
    }

    public int size() {
        return JVCoreJavaJNI.ImageSourceVector_doSize(this.f21259a, this);
    }

    public ImageSource get(int i11) {
        return new ImageSource(JVCoreJavaJNI.ImageSourceVector_doGet(this.f21259a, this, i11), false);
    }

    public ImageSource remove(int i11) {
        this.modCount++;
        return new ImageSource(JVCoreJavaJNI.ImageSourceVector_doRemove(this.f21259a, this, i11), true);
    }

    public ImageSource set(int i11, ImageSource imageSource) {
        return new ImageSource(JVCoreJavaJNI.ImageSourceVector_doSet(this.f21259a, this, i11, ImageSource.getCPtr(imageSource), imageSource), true);
    }

    public boolean add(ImageSource imageSource) {
        this.modCount++;
        JVCoreJavaJNI.ImageSourceVector_doAdd__SWIG_0(this.f21259a, this, ImageSource.getCPtr(imageSource), imageSource);
        return true;
    }

    public ImageSourceVector(ImageSource[] imageSourceArr) {
        this();
        reserve((long) imageSourceArr.length);
        for (ImageSource add : imageSourceArr) {
            add(add);
        }
    }

    public void add(int i11, ImageSource imageSource) {
        this.modCount++;
        JVCoreJavaJNI.ImageSourceVector_doAdd__SWIG_1(this.f21259a, this, i11, ImageSource.getCPtr(imageSource), imageSource);
    }

    public ImageSourceVector(Iterable<ImageSource> iterable) {
        this();
        for (ImageSource add : iterable) {
            add(add);
        }
    }

    public ImageSourceVector() {
        this(JVCoreJavaJNI.new_ImageSourceVector__SWIG_0(), true);
    }

    public ImageSourceVector(ImageSourceVector imageSourceVector) {
        this(JVCoreJavaJNI.new_ImageSourceVector__SWIG_1(getCPtr(imageSourceVector), imageSourceVector), true);
    }

    public ImageSourceVector(int i11, ImageSource imageSource) {
        this(JVCoreJavaJNI.new_ImageSourceVector__SWIG_2(i11, ImageSource.getCPtr(imageSource), imageSource), true);
    }
}
