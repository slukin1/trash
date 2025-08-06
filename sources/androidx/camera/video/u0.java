package androidx.camera.video;

import android.net.Uri;
import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;

public final /* synthetic */ class u0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f6364b;

    public /* synthetic */ u0(s sVar) {
        this.f6364b = sVar;
    }

    public final void accept(Object obj) {
        Recorder.i.y(this.f6364b, (Uri) obj);
    }
}
