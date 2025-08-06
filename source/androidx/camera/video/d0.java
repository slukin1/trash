package androidx.camera.video;

import androidx.camera.video.VideoOutput;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Recorder f5931b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VideoOutput.SourceState f5932c;

    public /* synthetic */ d0(Recorder recorder, VideoOutput.SourceState sourceState) {
        this.f5931b = recorder;
        this.f5932c = sourceState;
    }

    public final void run() {
        this.f5931b.J(this.f5932c);
    }
}
