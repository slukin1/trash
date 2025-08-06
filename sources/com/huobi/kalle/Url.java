package com.huobi.kalle;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.kalle.i;
import com.huobi.kalle.util.UrlEncode;
import java.net.URI;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Url {

    /* renamed from: a  reason: collision with root package name */
    public final String f74675a;

    /* renamed from: b  reason: collision with root package name */
    public final String f74676b;

    /* renamed from: c  reason: collision with root package name */
    public final int f74677c;

    /* renamed from: d  reason: collision with root package name */
    public final String f74678d;

    /* renamed from: e  reason: collision with root package name */
    public final String f74679e;

    /* renamed from: f  reason: collision with root package name */
    public final String f74680f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f74681a;

        /* renamed from: b  reason: collision with root package name */
        public String f74682b;

        /* renamed from: c  reason: collision with root package name */
        public int f74683c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f74684d;

        /* renamed from: e  reason: collision with root package name */
        public i.b f74685e;

        /* renamed from: f  reason: collision with root package name */
        public String f74686f;

        public a g(i iVar) {
            for (Map.Entry next : iVar.b()) {
                String str = (String) next.getKey();
                for (Object next2 : (List) next.getValue()) {
                    if (next2 != null && (next2 instanceof CharSequence)) {
                        h(str, next2.toString());
                    }
                }
            }
            return this;
        }

        public a h(String str, String str2) {
            this.f74685e.c(str, str2);
            return this;
        }

        public Url i() {
            return new Url(this);
        }

        public a j(String str) {
            this.f74686f = str;
            return this;
        }

        public a k(String str) {
            this.f74684d = Url.d(str);
            return this;
        }

        public a l(String str) {
            this.f74685e = Url.e(str).a();
            return this;
        }

        public a(String str) {
            URI create = URI.create(str);
            this.f74681a = create.getScheme();
            this.f74682b = create.getHost();
            this.f74683c = create.getPort();
            this.f74684d = Url.d(create.getPath());
            this.f74685e = Url.e(create.getQuery()).a();
            this.f74686f = create.getFragment();
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
        return e(this.f74679e);
    }

    public String h() {
        return this.f74678d;
    }

    public Url i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (URLUtil.isNetworkUrl(str)) {
            return j(str).i();
        }
        URI create = URI.create(str);
        if (str.startsWith("/")) {
            return c().k(create.getPath()).l(create.getQuery()).j(create.getFragment()).i();
        }
        if (str.contains("../")) {
            List<String> d11 = d(h());
            List<String> d12 = d(create.getPath());
            int lastIndexOf = d12.lastIndexOf("..");
            List<String> subList = d12.subList(lastIndexOf + 1, d12.size());
            if (!d11.isEmpty()) {
                List<String> subList2 = d11.subList(0, (d11.size() - lastIndexOf) - 2);
                subList2.addAll(subList);
                return c().k(TextUtils.join("/", subList2)).l(create.getQuery()).j(create.getFragment()).i();
            }
            return c().k(TextUtils.join("/", subList)).l(create.getQuery()).j(create.getFragment()).i();
        }
        List<String> d13 = d(h());
        d13.addAll(d(create.getPath()));
        return c().k(TextUtils.join("/", d13)).l(create.getQuery()).j(create.getFragment()).i();
    }

    public String toString() {
        return this.f74675a + "://" + this.f74676b + l(this.f74677c) + this.f74678d + this.f74679e + this.f74680f;
    }

    public Url(a aVar) {
        this.f74675a = aVar.f74681a;
        this.f74676b = aVar.f74682b;
        this.f74677c = aVar.f74683c;
        this.f74678d = k(aVar.f74684d);
        this.f74679e = m(aVar.f74685e.e());
        this.f74680f = f(aVar.f74686f);
    }
}
