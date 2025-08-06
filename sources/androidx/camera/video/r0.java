package androidx.camera.video;

import android.media.MediaScannerConnection;
import android.net.Uri;
import androidx.camera.video.Recorder;

public final /* synthetic */ class r0 implements MediaScannerConnection.OnScanCompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ r0 f6345a = new r0();

    public final void onScanCompleted(String str, Uri uri) {
        Recorder.i.z(str, uri);
    }
}
