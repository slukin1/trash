package org.joda.time.chrono;

import java.util.Locale;

public final class l extends c {
    public l(BasicChronology basicChronology) {
        super(basicChronology, 2);
    }

    public int a(String str, Locale locale) {
        return k.h(locale).r(str);
    }

    public String getAsShortText(int i11, Locale locale) {
        return k.h(locale).s(i11);
    }

    public String getAsText(int i11, Locale locale) {
        return k.h(locale).t(i11);
    }

    public int getMaximumShortTextLength(Locale locale) {
        return k.h(locale).m();
    }

    public int getMaximumTextLength(Locale locale) {
        return k.h(locale).n();
    }
}
