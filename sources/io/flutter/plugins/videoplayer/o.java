package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;

public final /* synthetic */ class o implements VideoPlayerPlugin.KeyForAssetAndPackageName {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginRegistry.Registrar f55247a;

    public /* synthetic */ o(PluginRegistry.Registrar registrar) {
        this.f55247a = registrar;
    }

    public final String get(String str, String str2) {
        return this.f55247a.lookupKeyForAsset(str, str2);
    }
}
