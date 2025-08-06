package com.jumio.jvision.jvcorejava.swig;

public class FrameQueue {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21253a;
    public transient boolean swigCMemOwn;

    public FrameQueue(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21253a = j11;
    }

    public static long getCPtr(FrameQueue frameQueue) {
        if (frameQueue == null) {
            return 0;
        }
        return frameQueue.f21253a;
    }

    public void clear() {
        JVCoreJavaJNI.FrameQueue_clear(this.f21253a, this);
    }

    public synchronized void delete() {
        long j11 = this.f21253a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_FrameQueue(j11);
            }
            this.f21253a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public void getAllFrames(ImageSourceVector imageSourceVector) {
        JVCoreJavaJNI.FrameQueue_getAllFrames(this.f21253a, this, ImageSourceVector.getCPtr(imageSourceVector), imageSourceVector);
    }

    public ImageSource getFrameByID(int i11) {
        return new ImageSource(JVCoreJavaJNI.FrameQueue_getFrameByID(this.f21253a, this, i11), true);
    }

    public void getFramesInRange(int i11, int i12, ImageSourceVector imageSourceVector) {
        JVCoreJavaJNI.FrameQueue_getFramesInRange(this.f21253a, this, i11, i12, ImageSourceVector.getCPtr(imageSourceVector), imageSourceVector);
    }

    public ImageSource lastFrame() {
        return new ImageSource(JVCoreJavaJNI.FrameQueue_lastFrame(this.f21253a, this), false);
    }

    public void pushFrame(int i11, ImageSource imageSource) {
        JVCoreJavaJNI.FrameQueue_pushFrame(this.f21253a, this, i11, ImageSource.getCPtr(imageSource), imageSource);
    }

    public boolean removeFrameByID(int i11) {
        return JVCoreJavaJNI.FrameQueue_removeFrameByID(this.f21253a, this, i11);
    }

    public long size() {
        return JVCoreJavaJNI.FrameQueue_size(this.f21253a, this);
    }

    public FrameQueue(long j11) {
        this(JVCoreJavaJNI.new_FrameQueue(j11), true);
    }
}
