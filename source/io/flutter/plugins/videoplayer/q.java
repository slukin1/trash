package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;

public final /* synthetic */ class q implements VideoPlayerPlugin.KeyForAssetFn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginRegistry.Registrar f55249a;

    public /* synthetic */ q(PluginRegistry.Registrar registrar) {
        this.f55249a = registrar;
    }

    public final String get(String str) {
        return this.f55249a.lookupKeyForAsset(str);
    }
}
