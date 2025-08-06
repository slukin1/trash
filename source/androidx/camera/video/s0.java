package androidx.camera.video;

import android.media.MediaMuxer;
import android.os.ParcelFileDescriptor;
import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;

public final /* synthetic */ class s0 implements Recorder.i.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t f6349a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ParcelFileDescriptor f6350b;

    public /* synthetic */ s0(t tVar, ParcelFileDescriptor parcelFileDescriptor) {
        this.f6349a = tVar;
        this.f6350b = parcelFileDescriptor;
    }

    public final MediaMuxer a(int i11, Consumer consumer) {
        return Recorder.i.x(this.f6349a, this.f6350b, i11, consumer);
    }
}
