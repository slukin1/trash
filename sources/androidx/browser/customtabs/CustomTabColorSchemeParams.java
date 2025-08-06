package androidx.browser.customtabs;

import android.os.Bundle;

public final class CustomTabColorSchemeParams {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f4851a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f4852b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f4853c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f4854d;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Integer f4855a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f4856b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f4857c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f4858d;

        public CustomTabColorSchemeParams a() {
            return new CustomTabColorSchemeParams(this.f4855a, this.f4856b, this.f4857c, this.f4858d);
        }
    }

    public CustomTabColorSchemeParams(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f4851a = num;
        this.f4852b = num2;
        this.f4853c = num3;
        this.f4854d = num4;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f4851a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f4852b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f4853c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f4854d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
