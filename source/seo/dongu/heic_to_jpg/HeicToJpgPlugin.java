package seo.dongu.heic_to_jpg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b30.b;
import b30.c;
import com.luck.picture.lib.config.PictureMimeType;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class HeicToJpgPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public static final a f60121b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static Context f60122c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final void c(MethodCall methodCall, Handler handler, MethodChannel.Result result) {
        String str = (String) methodCall.argument("jpgPath");
        if (str == null || str.length() == 0) {
            StringBuilder sb2 = new StringBuilder();
            Context context = f60122c;
            sb2.append(context != null ? context.getCacheDir() : null);
            sb2.append('/');
            sb2.append(System.currentTimeMillis());
            sb2.append(PictureMimeType.JPG);
            str = sb2.toString();
        }
        handler.post(new c(b30.a.a((String) methodCall.argument("heicPath"), str), result));
    }

    public static final void d(String str, MethodChannel.Result result) {
        if (str != null) {
            result.success(str);
        } else {
            result.error("error", "output path is null", (Object) null);
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        f60122c = flutterPluginBinding.getApplicationContext();
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "heic_to_jpg").setMethodCallHandler(new HeicToJpgPlugin());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (x.b(methodCall.method, "convert")) {
            if (methodCall.hasArgument("heicPath")) {
                CharSequence charSequence = (CharSequence) methodCall.argument("heicPath");
                if (!(charSequence == null || charSequence.length() == 0)) {
                    new Thread(new b(methodCall, new Handler(Looper.getMainLooper()), result)).start();
                    return;
                }
            }
            result.error("illegalArgument", "heicPath is null or Empty.", (Object) null);
            return;
        }
        result.notImplemented();
    }
}
