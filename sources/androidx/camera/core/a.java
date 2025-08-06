package androidx.camera.core;

import android.media.ImageReader;
import androidx.camera.core.impl.ImageReaderProxy;
import java.util.concurrent.Executor;

public final /* synthetic */ class a implements ImageReader.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidImageReaderProxy f5493a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f5494b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageReaderProxy.OnImageAvailableListener f5495c;

    public /* synthetic */ a(AndroidImageReaderProxy androidImageReaderProxy, Executor executor, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f5493a = androidImageReaderProxy;
        this.f5494b = executor;
        this.f5495c = onImageAvailableListener;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        this.f5493a.lambda$setOnImageAvailableListener$1(this.f5494b, this.f5495c, imageReader);
    }
}
