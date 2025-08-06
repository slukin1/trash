package io.flutter.plugins.videoplayer;

import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;

public final /* synthetic */ class p implements VideoPlayerPlugin.KeyForAssetFn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f55248a;

    public /* synthetic */ p(FlutterLoader flutterLoader) {
        this.f55248a = flutterLoader;
    }

    public final String get(String str) {
        return this.f55248a.getLookupKeyForAsset(str);
    }
}
