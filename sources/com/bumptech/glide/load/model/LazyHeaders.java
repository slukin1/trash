package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s3.b;

public final class LazyHeaders implements b {

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, List<b>> f63961c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Map<String, String> f63962d;

    public static final class Builder {

        /* renamed from: d  reason: collision with root package name */
        public static final String f63963d;

        /* renamed from: e  reason: collision with root package name */
        public static final Map<String, List<b>> f63964e;

        /* renamed from: a  reason: collision with root package name */
        public boolean f63965a = true;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, List<b>> f63966b = f63964e;

        /* renamed from: c  reason: collision with root package name */
        public boolean f63967c = true;

        static {
            String b11 = b();
            f63963d = b11;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b11)) {
                hashMap.put("User-Agent", Collections.singletonList(new a(b11)));
            }
            f63964e = Collections.unmodifiableMap(hashMap);
        }

        public static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb2 = new StringBuilder(property.length());
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = property.charAt(i11);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    sb2.append(charAt);
                } else {
                    sb2.append('?');
                }
            }
            return sb2.toString();
        }

        public LazyHeaders a() {
            this.f63965a = true;
            return new LazyHeaders(this.f63966b);
        }
    }

    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f63968a;

        public a(String str) {
            this.f63968a = str;
        }

        public String a() {
            return this.f63968a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.f63968a.equals(((a) obj).f63968a);
            }
            return false;
        }

        public int hashCode() {
            return this.f63968a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f63968a + '\'' + '}';
        }
    }

    public LazyHeaders(Map<String, List<b>> map) {
        this.f63961c = Collections.unmodifiableMap(map);
    }

    public final String a(List<b> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            String a11 = list.get(i11).a();
            if (!TextUtils.isEmpty(a11)) {
                sb2.append(a11);
                if (i11 != list.size() - 1) {
                    sb2.append(',');
                }
            }
        }
        return sb2.toString();
    }

    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f63961c.entrySet()) {
            String a11 = a((List) next.getValue());
            if (!TextUtils.isEmpty(a11)) {
                hashMap.put(next.getKey(), a11);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f63961c.equals(((LazyHeaders) obj).f63961c);
        }
        return false;
    }

    public Map<String, String> getHeaders() {
        if (this.f63962d == null) {
            synchronized (this) {
                if (this.f63962d == null) {
                    this.f63962d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f63962d;
    }

    public int hashCode() {
        return this.f63961c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f63961c + '}';
    }
}
