package qe;

import com.hbg.module.libkt.custom.indicator.view.option.IndicatorOptions;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f25612a = new d();

    public final f a(IndicatorOptions indicatorOptions) {
        int d11 = indicatorOptions.d();
        if (d11 == 2) {
            return new c(indicatorOptions);
        }
        if (d11 != 4) {
            return new b(indicatorOptions);
        }
        return new h(indicatorOptions);
    }
}
