package z4;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f62000b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62001c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62002d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f62003e;

    public /* synthetic */ d(MethodChannel.Result result, String str, String str2, Object obj) {
        this.f62000b = result;
        this.f62001c = str;
        this.f62002d = str2;
        this.f62003e = obj;
    }

    public final void run() {
        e.l(this.f62000b, this.f62001c, this.f62002d, this.f62003e);
    }
}
