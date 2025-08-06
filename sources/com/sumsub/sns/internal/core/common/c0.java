package com.sumsub.sns.internal.core.common;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f32001a = new c0();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f32002b = SetsKt__SetsKt.f("zh-tw", "pt-br");

    /* renamed from: c  reason: collision with root package name */
    public static final i f32003c = LazyKt__LazyJVMKt.a(a.f32004a);

    public static final class a extends Lambda implements d10.a<HashMap<String, Locale>> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32004a = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final HashMap<String, Locale> invoke() {
            String[] iSOCountries = Locale.getISOCountries();
            HashMap<String, Locale> hashMap = new HashMap<>(iSOCountries.length);
            for (String locale : iSOCountries) {
                Locale locale2 = new Locale("", locale);
                hashMap.put(locale2.getISO3Country().toUpperCase(Locale.ROOT), locale2);
            }
            hashMap.put("RKS", new Locale("", "XK"));
            hashMap.put("ANT", new Locale("", "NL"));
            return hashMap;
        }
    }

    public final Map<String, Locale> a() {
        return (Map) f32003c.getValue();
    }

    public final String a(String str) {
        Locale locale = a().get(str);
        String country = locale != null ? locale.getCountry() : null;
        return country == null ? str : country;
    }

    public final String a(Locale locale) {
        if (!StringsKt__StringsJVMKt.z(locale.getCountry())) {
            String str = locale.getLanguage() + '-' + locale.getCountry().toLowerCase(Locale.ROOT);
            if (f32002b.contains(str)) {
                return str;
            }
        }
        return locale.getLanguage();
    }
}
