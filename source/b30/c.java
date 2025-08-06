package b30;

import io.flutter.plugin.common.MethodChannel;
import seo.dongu.heic_to_jpg.HeicToJpgPlugin;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f12320b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f12321c;

    public /* synthetic */ c(String str, MethodChannel.Result result) {
        this.f12320b = str;
        this.f12321c = result;
    }

    public final void run() {
        HeicToJpgPlugin.d(this.f12320b, this.f12321c);
    }
}
