package sd;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestOptions;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.Locale;
import kotlin.Unit;
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

    public static final void d(ImageView imageView, String str, int i11) {
        if (imageView != null && imageView.getContext() != null) {
            if (!(imageView.getContext() instanceof Activity) || !((Activity) imageView.getContext()).isFinishing()) {
                try {
                    com.bumptech.glide.a.v(imageView.getContext()).q(str).b((RequestOptions) ((RequestOptions) new RequestOptions().a0(i11)).l(i11)).D0(imageView);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    Unit unit = Unit.f56620a;
                }
            }
        }
    }
}
