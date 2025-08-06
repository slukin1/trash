package com.example.flutterimagecompress;

import android.content.Context;
import android.os.Build;
import com.example.flutterimagecompress.handle.heif.HeifHandler;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import o4.c;
import o4.e;

public final class FlutterImageCompressPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: d  reason: collision with root package name */
    public static final a f64984d = new a((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static boolean f64985e;

    /* renamed from: b  reason: collision with root package name */
    public Context f64986b;

    /* renamed from: c  reason: collision with root package name */
    public MethodChannel f64987c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final boolean a() {
            return FlutterImageCompressPlugin.f64985e;
        }
    }

    public FlutterImageCompressPlugin() {
        r4.a aVar = r4.a.f66597a;
        aVar.b(new t4.a(0));
        aVar.b(new t4.a(1));
        aVar.b(new HeifHandler());
        aVar.b(new t4.a(3));
    }

    public final int b(MethodCall methodCall) {
        f64985e = x.b((Boolean) methodCall.arguments(), Boolean.TRUE);
        return 1;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f64986b = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_image_compress");
        this.f64987c = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = this.f64987c;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.f64987c = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        if (str != null) {
            Context context = null;
            switch (str.hashCode()) {
                case -129880033:
                    if (str.equals("compressWithFileAndGetFile")) {
                        c cVar = new c(methodCall, result);
                        Context context2 = this.f64986b;
                        if (context2 != null) {
                            context = context2;
                        }
                        cVar.i(context);
                        return;
                    }
                    break;
                case 86054116:
                    if (str.equals("compressWithFile")) {
                        c cVar2 = new c(methodCall, result);
                        Context context3 = this.f64986b;
                        if (context3 != null) {
                            context = context3;
                        }
                        cVar2.g(context);
                        return;
                    }
                    break;
                case 86233094:
                    if (str.equals("compressWithList")) {
                        e eVar = new e(methodCall, result);
                        Context context4 = this.f64986b;
                        if (context4 != null) {
                            context = context4;
                        }
                        eVar.f(context);
                        return;
                    }
                    break;
                case 1262746611:
                    if (str.equals("getSystemVersion")) {
                        result.success(Integer.valueOf(Build.VERSION.SDK_INT));
                        return;
                    }
                    break;
                case 2067272455:
                    if (str.equals("showLog")) {
                        result.success(Integer.valueOf(b(methodCall)));
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }
}
