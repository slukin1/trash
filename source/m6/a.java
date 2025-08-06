package m6;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.lang.BaseLang;
import com.hbg.lib.core.lang.DynamicLang;
import com.hbg.lib.core.lang.EnLang;
import com.hbg.lib.core.lang.JaJpLang;
import com.hbg.lib.core.lang.KoKrLang;
import com.hbg.lib.core.lang.LocalLang;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huobi.utils.GsonHelper;
import com.xiaomi.mipush.sdk.Constants;
import e6.h;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static BaseLang f69014a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, BaseLang> f69015b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static DynamicLang f69016c;

    /* renamed from: d  reason: collision with root package name */
    public static List<LocalLang> f69017d;

    /* renamed from: m6.a$a  reason: collision with other inner class name */
    public class C0745a extends TypeToken<List<LocalLang>> {
    }

    static {
        h.r().j();
        List<LocalLang> list = (List) GsonHelper.a().fromJson(h.r().s("HBLocalLanguage"), new C0745a().getType());
        f69017d = list;
        for (LocalLang next : list) {
            next.setLocale(next.getLocalLang(), next.getLocalCountry());
            f69015b.put(next.getLocale().toString(), next);
        }
    }

    public static Locale a() {
        return d().getLocale();
    }

    public static String b() {
        return d().getCurAppLocaleName();
    }

    public static DynamicLang c() {
        if (!k()) {
            return null;
        }
        BaseLang d11 = d();
        if (d11 instanceof DynamicLang) {
            return (DynamicLang) d11;
        }
        return null;
    }

    public static BaseLang d() {
        BaseLang baseLang = f69014a;
        if (baseLang != null) {
            return baseLang;
        }
        BaseLang baseLang2 = f69015b.get(ConfigPreferences.e("user_config", "config_app_language", Locale.ENGLISH.toString()));
        f69014a = baseLang2;
        if (baseLang2 == null) {
            f69014a = m(Locale.getDefault());
        }
        return f69014a;
    }

    public static BaseLang e(Locale locale) {
        BaseLang baseLang = f69015b.get(locale.toString());
        return baseLang == null ? f69016c : baseLang;
    }

    public static String f() {
        return d().getLanguageHeader();
    }

    public static String g() {
        String[] split = d().getLanguageHeader().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split == null || split.length <= 0) {
            return d().getLanguageHeader();
        }
        return split[0];
    }

    public static String h() {
        return d().getLanguageUrlPath();
    }

    public static String i() {
        String curAppLocaleName = d().getCurAppLocaleName();
        return TextUtils.isEmpty(curAppLocaleName) ? EnLang.getInstance().getSensorsLanguage() : curAppLocaleName;
    }

    public static String j() {
        return d().getZendeskLocaleStr();
    }

    public static boolean k() {
        return d().isDynamicLang();
    }

    public static boolean l() {
        Locale a11 = a();
        return a11 == KoKrLang.getInstance().getLocale() || a11 == JaJpLang.getInstance().getLocale();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.hbg.lib.core.lang.BaseLang} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.hbg.lib.core.lang.BaseLang m(java.util.Locale r7) {
        /*
            if (r7 != 0) goto L_0x000a
            com.hbg.lib.core.util.AppLanguageHelper r7 = com.hbg.lib.core.util.AppLanguageHelper.getInstance()
            java.util.Locale r7 = r7.getSystemLocale()
        L_0x000a:
            java.lang.String r0 = r7.getLanguage()
            java.lang.String r7 = r7.getCountry()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "matchLang:"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r2 = ", matchCountry:"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "CurrLangHolder"
            android.util.Log.d(r2, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List<com.hbg.lib.core.lang.LocalLang> r2 = f69017d
            java.util.Iterator r2 = r2.iterator()
            r3 = 0
            r4 = r3
        L_0x003d:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0062
            java.lang.Object r5 = r2.next()
            com.hbg.lib.core.lang.LocalLang r5 = (com.hbg.lib.core.lang.LocalLang) r5
            java.util.Locale r6 = r5.getLocale()
            java.lang.String r6 = r6.getLanguage()
            boolean r6 = android.text.TextUtils.equals(r6, r0)
            if (r6 == 0) goto L_0x005a
            r1.add(r5)
        L_0x005a:
            boolean r6 = r5.isDefaultLanguage()
            if (r6 == 0) goto L_0x003d
            r4 = r5
            goto L_0x003d
        L_0x0062:
            java.util.Iterator r0 = r1.iterator()
        L_0x0066:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0081
            java.lang.Object r2 = r0.next()
            com.hbg.lib.core.lang.LocalLang r2 = (com.hbg.lib.core.lang.LocalLang) r2
            java.util.Locale r5 = r2.getLocale()
            java.lang.String r5 = r5.getCountry()
            boolean r5 = android.text.TextUtils.equals(r5, r7)
            if (r5 == 0) goto L_0x0066
            r3 = r2
        L_0x0081:
            r7 = 0
            if (r3 != 0) goto L_0x0091
            int r0 = r1.size()
            if (r0 <= 0) goto L_0x0091
            java.lang.Object r0 = r1.get(r7)
            r3 = r0
            com.hbg.lib.core.lang.BaseLang r3 = (com.hbg.lib.core.lang.BaseLang) r3
        L_0x0091:
            if (r3 != 0) goto L_0x00a0
            if (r4 == 0) goto L_0x0096
            goto L_0x00a1
        L_0x0096:
            java.util.List<com.hbg.lib.core.lang.LocalLang> r0 = f69017d
            java.lang.Object r7 = r0.get(r7)
            r4 = r7
            com.hbg.lib.core.lang.BaseLang r4 = (com.hbg.lib.core.lang.BaseLang) r4
            goto L_0x00a1
        L_0x00a0:
            r4 = r3
        L_0x00a1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m6.a.m(java.util.Locale):com.hbg.lib.core.lang.BaseLang");
    }

    public static Locale n(Locale locale) {
        return m(locale).locale;
    }

    public static void o(BaseLang baseLang) {
        boolean z11 = baseLang instanceof DynamicLang;
        if (z11) {
            n6.a.c((DynamicLang) baseLang);
        }
        if (k()) {
            f69016c = null;
        }
        if (z11) {
            f69016c = (DynamicLang) baseLang;
        }
    }

    public static void p(Locale locale) {
        f69014a = e(locale);
        ConfigPreferences.m("user_config", "config_app_language", locale.toString());
        ConfigPreferences.m("user_config", "config_app_language_header", f());
    }
}
