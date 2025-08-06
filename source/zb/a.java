package zb;

import android.content.res.Resources;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.Locale;
import kotlin.jvm.internal.x;

public final class a {
    public static final int a(float f11) {
        return (int) ((f11 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final int b(Float f11) {
        return a(f11 != null ? f11.floatValue() : 0.0f);
    }

    public static final boolean c(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                if (!(StringsKt__StringsKt.i1(str).toString().length() == 0) && !x.b(str.toLowerCase(Locale.ROOT), OptionsBridge.NULL_VALUE)) {
                    return false;
                }
            }
        }
        return true;
    }
}
