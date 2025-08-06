package com.alibaba.fastjson.util;

public class IdentityHashMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final a<K, V>[] f14418a;

    /* renamed from: b  reason: collision with root package name */
    public final int f14419b;

    public static final class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final int f14420a;

        /* renamed from: b  reason: collision with root package name */
        public final K f14421b;

        /* renamed from: c  reason: collision with root package name */
        public V f14422c;

        /* renamed from: d  reason: collision with root package name */
        public final a<K, V> f14423d;

        public a(K k11, V v11, int i11, a<K, V> aVar) {
            this.f14421b = k11;
            this.f14422c = v11;
            this.f14423d = aVar;
            this.f14420a = i11;
        }
    }

    public IdentityHashMap() {
        this(1024);
    }

    public Class a(String str) {
        for (a<K, V> aVar : this.f14418a) {
            if (aVar != null) {
                for (a<K, V> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f14423d) {
                    K k11 = aVar.f14421b;
                    if (k11 instanceof Class) {
                        Class cls = (Class) k11;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    public final V b(K k11) {
        for (a<K, V> aVar = this.f14418a[System.identityHashCode(k11) & this.f14419b]; aVar != null; aVar = aVar.f14423d) {
            if (k11 == aVar.f14421b) {
                return aVar.f14422c;
            }
        }
        return null;
    }

    public boolean c(K k11, V v11) {
        int identityHashCode = System.identityHashCode(k11);
        int i11 = this.f14419b & identityHashCode;
        for (a<K, V> aVar = this.f14418a[i11]; aVar != null; aVar = aVar.f14423d) {
            if (k11 == aVar.f14421b) {
                aVar.f14422c = v11;
                return true;
            }
        }
        this.f14418a[i11] = new a<>(k11, v11, identityHashCode, this.f14418a[i11]);
        return false;
    }

    public IdentityHashMap(int i11) {
        this.f14419b = i11 - 1;
        this.f14418a = new a[i11];
    }
}
