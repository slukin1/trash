package com.huobi.woodpecker.kalle;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.woodpecker.kalle.util.UrlEncode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, List<Object>> f21094a;

    public static b f() {
        return new b();
    }

    public b a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : this.f21094a.entrySet()) {
            linkedHashMap.put((String) next.getKey(), new ArrayList((Collection) next.getValue()));
        }
        return new b(linkedHashMap);
    }

    public Set<Map.Entry<String, List<Object>>> b() {
        return this.f21094a.entrySet();
    }

    public List<Object> c(String str) {
        return this.f21094a.get(str);
    }

    public boolean d() {
        for (Map.Entry<String, List<Object>> value : b()) {
            List<Object> list = (List) value.getValue();
            if (list.size() > 0) {
                for (Object obj : list) {
                    if (obj instanceof b) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public Set<String> e() {
        return this.f21094a.keySet();
    }

    public f g() {
        return f.c().e(this).d();
    }

    public p h() {
        return p.b().e(this).d();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (String next : e()) {
            for (Object next2 : c(next)) {
                if (next2 != null && (next2 instanceof CharSequence)) {
                    String a11 = UrlEncode.a(next2.toString());
                    sb2.append(ContainerUtils.FIELD_DELIMITER);
                    sb2.append(next);
                    sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb2.append(a11);
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(0);
        }
        return sb2.toString();
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, List<Object>> f21095a;

        public b b(i iVar) {
            for (Map.Entry next : iVar.b()) {
                String str = (String) next.getKey();
                for (Object d11 : (List) next.getValue()) {
                    d(str, d11);
                }
            }
            return this;
        }

        public b c(String str, CharSequence charSequence) {
            return d(str, charSequence);
        }

        public final b d(String str, e eVar) {
            if (!TextUtils.isEmpty(str)) {
                if (!this.f21095a.containsKey(str)) {
                    this.f21095a.put(str, new ArrayList(1));
                }
                if (eVar == null) {
                    eVar = "";
                }
                if (eVar instanceof File) {
                    eVar = new e((File) eVar);
                }
                this.f21095a.get(str).add(eVar);
            }
            return this;
        }

        public i e() {
            return new i(this);
        }

        public b f() {
            this.f21095a.clear();
            return this;
        }

        public b g(i iVar) {
            return f().b(iVar);
        }

        public b() {
            this.f21095a = new LinkedHashMap();
        }

        public b(Map<String, List<Object>> map) {
            this.f21095a = map;
        }
    }

    public i(b bVar) {
        this.f21094a = bVar.f21095a;
    }
}
