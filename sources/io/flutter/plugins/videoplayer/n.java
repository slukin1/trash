package io.flutter.plugins.videoplayer;

import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;

public final /* synthetic */ class n implements VideoPlayerPlugin.KeyForAssetAndPackageName {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f55246a;

    public /* synthetic */ n(FlutterLoader flutterLoader) {
        this.f55246a = flutterLoader;
    }

    public final String get(String str, String str2) {
        return this.f55246a.getLookupKeyForAsset(str, str2);
    }
}
