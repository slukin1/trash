package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;

public final /* synthetic */ class m implements PluginRegistry.ViewDestroyListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoPlayerPlugin f55245b;

    public /* synthetic */ m(VideoPlayerPlugin videoPlayerPlugin) {
        this.f55245b = videoPlayerPlugin;
    }

    public final boolean onViewDestroy(FlutterNativeView flutterNativeView) {
        return this.f55245b.onDestroy();
    }
}
