package org.bouncycastle.asn1;

import com.tencent.qcloud.tuicore.TUIThemeManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class DateUtil {
    public static Locale EN_Locale = forEN();
    private static Long ZERO = longValueOf(0);
    private static final Map localeCache = new HashMap();

    public static Date epochAdjust(Date date) throws ParseException {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return date;
        }
        Map map = localeCache;
        synchronized (map) {
            Long l11 = (Long) map.get(locale);
            if (l11 == null) {
                long time = new SimpleDateFormat("yyyyMMddHHmmssz").parse("19700101000000GMT+00:00").getTime();
                l11 = time == 0 ? ZERO : longValueOf(time);
                map.put(locale, l11);
            }
            if (l11 == ZERO) {
                return date;
            }
            Date date2 = new Date(date.getTime() - l11.longValue());
            return date2;
        }
    }

    private static Locale forEN() {
        if (TUIThemeManager.LANGUAGE_EN.equalsIgnoreCase(Locale.getDefault().getLanguage())) {
            return Locale.getDefault();
        }
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (int i11 = 0; i11 != availableLocales.length; i11++) {
            if (TUIThemeManager.LANGUAGE_EN.equalsIgnoreCase(availableLocales[i11].getLanguage())) {
                return availableLocales[i11];
            }
        }
        return Locale.getDefault();
    }

    private static Long longValueOf(long j11) {
        return Long.valueOf(j11);
    }
}
