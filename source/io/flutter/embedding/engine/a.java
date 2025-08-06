package io.flutter.embedding.engine;

import android.graphics.ImageDecoder;

public final /* synthetic */ class a implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f55128a;

    public /* synthetic */ a(long j11) {
        this.f55128a = j11;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        FlutterJNI.lambda$decodeImage$0(this.f55128a, imageDecoder, imageInfo, source);
    }
}
