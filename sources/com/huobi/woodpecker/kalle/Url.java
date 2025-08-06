package com.huobi.woodpecker.kalle;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.woodpecker.kalle.i;
import com.huobi.woodpecker.kalle.util.UrlEncode;
import java.net.URI;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Url {

    /* renamed from: a  reason: collision with root package name */
    public final String f21033a;

    /* renamed from: b  reason: collision with root package name */
    public final String f21034b;

    /* renamed from: c  reason: collision with root package name */
    public final int f21035c;

    /* renamed from: d  reason: collision with root package name */
    public final String f21036d;

    /* renamed from: e  reason: collision with root package name */
    public final String f21037e;

    /* renamed from: f  reason: collision with root package name */
    public final String f21038f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f21039a;

        /* renamed from: b  reason: collision with root package name */
        public String f21040b;

        /* renamed from: c  reason: collision with root package name */
        public int f21041c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f21042d;

        /* renamed from: e  reason: collision with root package name */
        public i.b f21043e;

        /* renamed from: f  reason: collision with root package name */
        public String f21044f;

        public a g(i iVar) {
            for (Map.Entry next : iVar.b()) {
                String str = (String) next.getKey();
                for (Object next2 : (List) next.getValue()) {
                    if (next2 != null && (next2 instanceof CharSequence)) {
                        i(str, next2.toString());
                    }
                }
            }
            return this;
        }

        public a h(String str, int i11) {
            return i(str, Integer.toString(i11));
        }

        public a i(String str, String str2) {
            this.f21043e.c(str, str2);
            return this;
        }

        public Url j() {
            return new Url(this);
        }

        public a k(String str) {
            this.f21044f = str;
            return this;
        }

        public a l(String str) {
            this.f21042d = Url.d(str);
            return this;
        }

        public a m(String str) {
            this.f21043e = Url.e(str).a();
            return this;
        }

        public a(String str) {
            URI create = URI.create(str);
            this.f21039a = create.getScheme();
            this.f21040b = create.getHost();
            this.f21041c = create.getPort();
            this.f21042d = Url.d(create.getPath());
            this.f21043e = Url.e(create.getQuery()).a();
            this.f21044f = create.getFragment();
        }
    }

    public static List<String> d(String str) {
        AnonymousClass1 r02 = new LinkedList<String>() {
            public boolean add(String str) {
                return !TextUtils.isEmpty(str) && super.add(str);
            }

            public void add(int i11, String str) {
                if (!TextUtils.isEmpty(str)) {
                    super.add(i11, str);
                }
            }
        };
        if (!TextUtils.isEmpty(str)) {
            while (str.startsWith("/")) {
                str = str.substring(1);
            }
            while (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            Collections.addAll(r02, str.split("/"));
        }
        return r02;
    }

    public static i e(String str) {
        i.b f11 = i.f();
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("?")) {
                str = str.substring(1);
            }
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                String str3 = "";
                if (indexOf > 0) {
                    String substring = str2.substring(0, indexOf);
                    if (indexOf < str2.length() - 1) {
                        str3 = str2.substring(indexOf + 1, str2.length());
                    }
                    str2 = substring;
                }
                f11.c(str2, str3);
            }
        }
        return f11.e();
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.format("#%s", new Object[]{UrlEncode.a(str)});
    }

    public static a j(String str) {
        return new a(str);
    }

    public static String k(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (String a11 : list) {
            sb2.append("/");
            sb2.append(UrlEncode.a(a11));
        }
        return sb2.toString();
    }

    public static String l(int i11) {
        if (i11 < 0) {
            return "";
        }
        return String.format(Locale.getDefault(), ":%d", new Object[]{Integer.valueOf(i11)});
    }

    public static String m(i iVar) {
        String iVar2 = iVar.toString();
        if (TextUtils.isEmpty(iVar2)) {
            return "";
        }
        return String.format("?%s", new Object[]{iVar2});
    }

    public a c() {
        return new a(toString());
    }

    public i g() {
        return e(this.f21037e);
    }

    public String h() {
        return this.f21036d;
    }

    public Url i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (URLUtil.isNetworkUrl(str)) {
            return j(str).j();
        }
        URI create = URI.create(str);
        if (str.startsWith("/")) {
            return c().l(create.getPath()).m(create.getQuery()).k(create.getFragment()).j();
        }
        if (str.contains("../")) {
            List<String> d11 = d(h());
            List<String> d12 = d(create.getPath());
            int lastIndexOf = d12.lastIndexOf("..");
            List<String> subList = d12.subList(lastIndexOf + 1, d12.size());
            if (!d11.isEmpty()) {
                List<String> subList2 = d11.subList(0, (d11.size() - lastIndexOf) - 2);
                subList2.addAll(subList);
                return c().l(TextUtils.join("/", subList2)).m(create.getQuery()).k(create.getFragment()).j();
            }
            return c().l(TextUtils.join("/", subList)).m(create.getQuery()).k(create.getFragment()).j();
        }
        List<String> d13 = d(h());
        d13.addAll(d(create.getPath()));
        return c().l(TextUtils.join("/", d13)).m(create.getQuery()).k(create.getFragment()).j();
    }

    public String toString() {
        return this.f21033a + "://" + this.f21034b + l(this.f21035c) + this.f21036d + this.f21037e + this.f21038f;
    }

    public Url(a aVar) {
        this.f21033a = aVar.f21039a;
        this.f21034b = aVar.f21040b;
        this.f21035c = aVar.f21041c;
        this.f21036d = k(aVar.f21042d);
        this.f21037e = m(aVar.f21043e.e());
        this.f21038f = f(aVar.f21044f);
    }
}
