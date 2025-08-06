package kotlin.jvm.internal;

import d10.b;
import d10.d;
import d10.e;
import d10.g;
import d10.h;
import d10.i;
import d10.j;
import d10.k;
import d10.l;
import d10.m;
import d10.n;
import d10.o;
import d10.q;
import d10.r;
import d10.s;
import d10.t;
import d10.u;
import d10.v;
import d10.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.f;
import kotlin.reflect.c;

public final class p implements c<Object>, o {

    /* renamed from: c  reason: collision with root package name */
    public static final a f56788c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final Map<Class<? extends f<?>>, Integer> f56789d;

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, String> f56790e;

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, String> f56791f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, String> f56792g;

    /* renamed from: h  reason: collision with root package name */
    public static final Map<String, String> f56793h;

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f56794b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final String a(Class<?> cls) {
            String str;
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (str = (String) p.f56792g.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "kotlin.Array";
                }
                return str2;
            }
            String str3 = (String) p.f56792g.get(cls.getName());
            return str3 == null ? cls.getCanonicalName() : str3;
        }

        public final String b(Class<?> cls) {
            String str;
            String str2 = null;
            if (!cls.isAnonymousClass()) {
                if (cls.isLocalClass()) {
                    String simpleName = cls.getSimpleName();
                    Method enclosingMethod = cls.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        String W0 = StringsKt__StringsKt.W0(simpleName, enclosingMethod.getName() + DecodedChar.FNC1, (String) null, 2, (Object) null);
                        if (W0 != null) {
                            return W0;
                        }
                    }
                    Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                    if (enclosingConstructor == null) {
                        return StringsKt__StringsKt.V0(simpleName, DecodedChar.FNC1, (String) null, 2, (Object) null);
                    }
                    return StringsKt__StringsKt.W0(simpleName, enclosingConstructor.getName() + DecodedChar.FNC1, (String) null, 2, (Object) null);
                } else if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) p.f56793h.get(componentType.getName())) != null) {
                        str2 = str + "Array";
                    }
                    if (str2 == null) {
                        return "Array";
                    }
                } else {
                    String str3 = (String) p.f56793h.get(cls.getName());
                    return str3 == null ? cls.getSimpleName() : str3;
                }
            }
            return str2;
        }

        public final boolean c(Object obj, Class<?> cls) {
            Integer num = (Integer) p.f56789d.get(cls);
            if (num != null) {
                return TypeIntrinsics.k(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = c10.a.b(c10.a.c(cls));
            }
            return cls.isInstance(obj);
        }
    }

    static {
        int i11 = 0;
        List n11 = CollectionsKt__CollectionsKt.n(d10.a.class, l.class, d10.p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, b.class, d10.c.class, d.class, e.class, d10.f.class, g.class, h.class, i.class, j.class, k.class, m.class, n.class, o.class);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(n11, 10));
        for (Object next : n11) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            arrayList.add(kotlin.l.a((Class) next, Integer.valueOf(i11)));
            i11 = i12;
        }
        f56789d = MapsKt__MapsKt.s(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f56790e = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f56791f = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        for (String str : hashMap.values()) {
            Pair a11 = kotlin.l.a("kotlin.jvm.internal." + StringsKt__StringsKt.Z0(str, '.', (String) null, 2, (Object) null) + "CompanionObject", str + ".Companion");
            hashMap3.put(a11.getFirst(), a11.getSecond());
        }
        for (Map.Entry next2 : f56789d.entrySet()) {
            int intValue = ((Number) next2.getValue()).intValue();
            hashMap3.put(((Class) next2.getKey()).getName(), "kotlin.Function" + intValue);
        }
        f56792g = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.d(hashMap3.size()));
        for (Map.Entry entry : hashMap3.entrySet()) {
            linkedHashMap.put(entry.getKey(), StringsKt__StringsKt.Z0((String) entry.getValue(), '.', (String) null, 2, (Object) null));
        }
        f56793h = linkedHashMap;
    }

    public p(Class<?> cls) {
        this.f56794b = cls;
    }

    public String a() {
        return f56788c.a(e());
    }

    public boolean d(Object obj) {
        return f56788c.c(obj, e());
    }

    public Class<?> e() {
        return this.f56794b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof p) && x.b(c10.a.b(this), c10.a.b((c) obj));
    }

    public String f() {
        return f56788c.b(e());
    }

    public int hashCode() {
        return c10.a.b(this).hashCode();
    }

    public String toString() {
        return e().toString() + " (Kotlin reflection is not available)";
    }
}
