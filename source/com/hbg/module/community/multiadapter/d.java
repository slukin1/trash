package com.hbg.module.community.multiadapter;

import d10.p;

public interface d<T> {

    public static final class a {

        /* renamed from: com.hbg.module.community.multiadapter.d$a$a  reason: collision with other inner class name */
        public static final class C0125a implements b<T> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ p<Integer, T, Integer> f17247a;

            public C0125a(p<? super Integer, ? super T, Integer> pVar) {
                this.f17247a = pVar;
            }

            public int a(int i11, T t11) {
                return this.f17247a.invoke(Integer.valueOf(i11), t11).intValue();
            }
        }

        public static <T> void a(d<T> dVar, p<? super Integer, ? super T, Integer> pVar) {
            dVar.c(new C0125a(pVar));
        }
    }

    void b(p<? super Integer, ? super T, Integer> pVar);

    void c(b<T> bVar);
}
