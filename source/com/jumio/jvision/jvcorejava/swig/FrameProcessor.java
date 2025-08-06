package com.jumio.jvision.jvcorejava.swig;

public class FrameProcessor {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21251a;
    public transient boolean swigCMemOwn;

    public FrameProcessor(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21251a = j11;
    }

    public static long getCPtr(FrameProcessor frameProcessor) {
        if (frameProcessor == null) {
            return 0;
        }
        return frameProcessor.f21251a;
    }

    public synchronized void delete() {
        long j11 = this.f21251a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_FrameProcessor(j11);
            }
            this.f21251a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public void processFrame() {
        if (getClass() == FrameProcessor.class) {
            JVCoreJavaJNI.FrameProcessor_processFrame(this.f21251a, this);
        } else {
            JVCoreJavaJNI.FrameProcessor_processFrameSwigExplicitFrameProcessor(this.f21251a, this);
        }
    }

    public void pushFrame(int i11, ImageSource imageSource) {
        if (getClass() == FrameProcessor.class) {
            JVCoreJavaJNI.FrameProcessor_pushFrame(this.f21251a, this, i11, ImageSource.getCPtr(imageSource), imageSource);
            return;
        }
        JVCoreJavaJNI.FrameProcessor_pushFrameSwigExplicitFrameProcessor(this.f21251a, this, i11, ImageSource.getCPtr(imageSource), imageSource);
    }

    public void reset() {
        JVCoreJavaJNI.FrameProcessor_reset(this.f21251a, this);
    }

    public void resetState() {
        if (getClass() == FrameProcessor.class) {
            JVCoreJavaJNI.FrameProcessor_resetState(this.f21251a, this);
        } else {
            JVCoreJavaJNI.FrameProcessor_resetStateSwigExplicitFrameProcessor(this.f21251a, this);
        }
    }

    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        JVCoreJavaJNI.FrameProcessor_change_ownership(this, this.f21251a, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        JVCoreJavaJNI.FrameProcessor_change_ownership(this, this.f21251a, true);
    }

    public FrameProcessor(int i11) {
        this(JVCoreJavaJNI.new_FrameProcessor(i11), true);
        JVCoreJavaJNI.FrameProcessor_director_connect(this, this.f21251a, true, true);
    }
}
