package androidx.camera.video;

public final /* synthetic */ class f1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoCapture f5952b;

    public /* synthetic */ f1(VideoCapture videoCapture) {
        this.f5952b = videoCapture;
    }

    public final void run() {
        this.f5952b.notifyReset();
    }
}
