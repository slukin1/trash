package com.jumio.core.util;

import com.jumio.sdk.util.IsoCountryConverter;
import java.util.Locale;

public final class LocaleUtilKt {
    public static final String getAlpha3Country(Locale locale) {
        String convertToAlpha3;
        String country = locale.getCountry();
        if (!(country.length() == 2)) {
            country = null;
        }
        return (country == null || (convertToAlpha3 = IsoCountryConverter.convertToAlpha3(country)) == null) ? "" : convertToAlpha3;
    }

    public static final String getBcp47(Locale locale) {
        return locale.toLanguageTag();
    }
}
