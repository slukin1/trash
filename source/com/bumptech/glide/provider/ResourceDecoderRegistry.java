package com.bumptech.glide.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import n3.e;

public class ResourceDecoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f64176a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, List<a<?, ?>>> f64177b = new HashMap();

    public static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<T> f64178a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<R> f64179b;

        /* renamed from: c  reason: collision with root package name */
        public final e<T, R> f64180c;

        public a(Class<T> cls, Class<R> cls2, e<T, R> eVar) {
            this.f64178a = cls;
            this.f64179b = cls2;
            this.f64180c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f64178a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f64179b);
        }
    }

    public synchronized <T, R> void a(String str, e<T, R> eVar, Class<T> cls, Class<R> cls2) {
        c(str).add(new a(cls, cls2, eVar));
    }

    public synchronized <T, R> List<e<T, R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f64176a) {
            List<a> list = this.f64177b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f64180c);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized List<a<?, ?>> c(String str) {
        List<a<?, ?>> list;
        if (!this.f64176a.contains(str)) {
            this.f64176a.add(str);
        }
        list = this.f64177b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f64177b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> List<Class<R>> d(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f64176a) {
            List<a> list = this.f64177b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f64179b)) {
                        arrayList.add(aVar.f64179b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f64176a);
        this.f64176a.clear();
        for (String add : list) {
            this.f64176a.add(add);
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f64176a.add(str);
            }
        }
    }
}
