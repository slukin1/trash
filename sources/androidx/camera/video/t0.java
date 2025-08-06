package androidx.camera.video;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;

public final /* synthetic */ class t0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ParcelFileDescriptor f6354b;

    public /* synthetic */ t0(ParcelFileDescriptor parcelFileDescriptor) {
        this.f6354b = parcelFileDescriptor;
    }

    public final void accept(Object obj) {
        Recorder.i.B(this.f6354b, (Uri) obj);
    }
}
