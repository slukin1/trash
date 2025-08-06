package androidx.core.os;

import com.tencent.qcloud.tuicore.TUIThemeManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

public final class i implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final Locale[] f8406c = new Locale[0];

    /* renamed from: d  reason: collision with root package name */
    public static final Locale f8407d = new Locale(TUIThemeManager.LANGUAGE_EN, "XA");

    /* renamed from: e  reason: collision with root package name */
    public static final Locale f8408e = new Locale("ar", "XB");

    /* renamed from: f  reason: collision with root package name */
    public static final Locale f8409f = LocaleListCompat.b("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    public final Locale[] f8410a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8411b;

    public i(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f8410a = f8406c;
            this.f8411b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        while (i11 < localeArr.length) {
            Locale locale = localeArr[i11];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    c(sb2, locale2);
                    if (i11 < localeArr.length - 1) {
                        sb2.append(',');
                    }
                    hashSet.add(locale2);
                }
                i11++;
            } else {
                throw new NullPointerException("list[" + i11 + "] is null");
            }
        }
        this.f8410a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f8411b = sb2.toString();
    }

    public static void c(StringBuilder sb2, Locale locale) {
        sb2.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb2.append('-');
            sb2.append(locale.getCountry());
        }
    }

    public String a() {
        return this.f8411b;
    }

    public Object b() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        Locale[] localeArr = ((i) obj).f8410a;
        if (this.f8410a.length != localeArr.length) {
            return false;
        }
        int i11 = 0;
        while (true) {
            Locale[] localeArr2 = this.f8410a;
            if (i11 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i11].equals(localeArr[i11])) {
                return false;
            }
            i11++;
        }
    }

    public Locale get(int i11) {
        if (i11 >= 0) {
            Locale[] localeArr = this.f8410a;
            if (i11 < localeArr.length) {
                return localeArr[i11];
            }
        }
        return null;
    }

    public int hashCode() {
        int i11 = 1;
        for (Locale hashCode : this.f8410a) {
            i11 = (i11 * 31) + hashCode.hashCode();
        }
        return i11;
    }

    public boolean isEmpty() {
        return this.f8410a.length == 0;
    }

    public int size() {
        return this.f8410a.length;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        int i11 = 0;
        while (true) {
            Locale[] localeArr = this.f8410a;
            if (i11 < localeArr.length) {
                sb2.append(localeArr[i11]);
                if (i11 < this.f8410a.length - 1) {
                    sb2.append(',');
                }
                i11++;
            } else {
                sb2.append("]");
                return sb2.toString();
            }
        }
    }
}
