package b30;

import android.os.Handler;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import seo.dongu.heic_to_jpg.HeicToJpgPlugin;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodCall f12317b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Handler f12318c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f12319d;

    public /* synthetic */ b(MethodCall methodCall, Handler handler, MethodChannel.Result result) {
        this.f12317b = methodCall;
        this.f12318c = handler;
        this.f12319d = result;
    }

    public final void run() {
        HeicToJpgPlugin.c(this.f12317b, this.f12318c, this.f12319d);
    }
}
