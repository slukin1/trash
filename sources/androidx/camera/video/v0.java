package androidx.camera.video;

import android.content.Context;
import android.net.Uri;
import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;

public final /* synthetic */ class v0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f6374b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f6375c;

    public /* synthetic */ v0(s sVar, Context context) {
        this.f6374b = sVar;
        this.f6375c = context;
    }

    public final void accept(Object obj) {
        Recorder.i.A(this.f6374b, this.f6375c, (Uri) obj);
    }
}
