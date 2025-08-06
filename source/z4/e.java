package z4;

import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.r;

public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static final a f66725d = new a((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static final Handler f66726e = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public MethodChannel.Result f66727a;

    /* renamed from: b  reason: collision with root package name */
    public final MethodCall f66728b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66729c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public e(MethodChannel.Result result, MethodCall methodCall) {
        this.f66727a = result;
        this.f66728b = methodCall;
        f66726e.hasMessages(0);
    }

    public static final void g(MethodChannel.Result result) {
        if (result != null) {
            result.notImplemented();
        }
    }

    public static final void i(MethodChannel.Result result, Object obj) {
        if (result != null) {
            try {
                result.success(obj);
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static /* synthetic */ void k(e eVar, String str, String str2, Object obj, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            obj = null;
        }
        eVar.j(str, str2, obj);
    }

    public static final void l(MethodChannel.Result result, String str, String str2, Object obj) {
        if (result != null) {
            result.error(str, str2, obj);
        }
    }

    public final MethodCall d() {
        return this.f66728b;
    }

    public final MethodChannel.Result e() {
        return this.f66727a;
    }

    public final void f() {
        if (!this.f66729c) {
            this.f66729c = true;
            MethodChannel.Result result = this.f66727a;
            this.f66727a = null;
            f66726e.post(new b(result));
        }
    }

    public final void h(Object obj) {
        if (!this.f66729c) {
            this.f66729c = true;
            MethodChannel.Result result = this.f66727a;
            this.f66727a = null;
            f66726e.post(new c(result, obj));
        }
    }

    public final void j(String str, String str2, Object obj) {
        if (!this.f66729c) {
            this.f66729c = true;
            MethodChannel.Result result = this.f66727a;
            this.f66727a = null;
            f66726e.post(new d(result, str, str2, obj));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(MethodChannel.Result result, MethodCall methodCall, int i11, r rVar) {
        this(result, (i11 & 2) != 0 ? null : methodCall);
    }
}
