package re;

import android.content.res.Resources;
import com.hbg.module.libkt.custom.indicator.view.option.IndicatorOptions;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25625a = new a();

    public static final int a(float f11) {
        return (int) ((f11 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public final float b(IndicatorOptions indicatorOptions, float f11, int i11) {
        return (f11 / ((float) 2)) + ((indicatorOptions.f() + indicatorOptions.l()) * ((float) i11));
    }

    public final float c(float f11) {
        return f11 / ((float) 2);
    }
}
