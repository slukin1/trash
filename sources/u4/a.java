package u4;

import android.util.Log;
import com.example.flutterimagecompress.FlutterImageCompressPlugin;
import com.iproov.sdk.bridge.OptionsBridge;

public final class a {
    public static final void a(Object obj, Object obj2) {
        String str;
        if (FlutterImageCompressPlugin.f64984d.a()) {
            if (obj2 == null || (str = obj2.toString()) == null) {
                str = OptionsBridge.NULL_VALUE;
            }
            Log.i("flutter_image_compress", str);
        }
    }
}
