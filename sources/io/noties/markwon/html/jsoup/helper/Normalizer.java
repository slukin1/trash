package io.noties.markwon.html.jsoup.helper;

import java.util.Locale;

public final class Normalizer {
    public static String a(String str) {
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }
}
