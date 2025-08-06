package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.HttpUrl;

public abstract class k<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final l f10437c = new l((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final k<Integer> f10438d = new f();

    /* renamed from: e  reason: collision with root package name */
    public static final k<Integer> f10439e = new i();

    /* renamed from: f  reason: collision with root package name */
    public static final k<int[]> f10440f = new e();

    /* renamed from: g  reason: collision with root package name */
    public static final k<Long> f10441g = new h();

    /* renamed from: h  reason: collision with root package name */
    public static final k<long[]> f10442h = new g();

    /* renamed from: i  reason: collision with root package name */
    public static final k<Float> f10443i = new d();

    /* renamed from: j  reason: collision with root package name */
    public static final k<float[]> f10444j = new c();

    /* renamed from: k  reason: collision with root package name */
    public static final k<Boolean> f10445k = new b();

    /* renamed from: l  reason: collision with root package name */
    public static final k<boolean[]> f10446l = new a();

    /* renamed from: m  reason: collision with root package name */
    public static final k<String> f10447m = new C0052k();

    /* renamed from: n  reason: collision with root package name */
    public static final k<String[]> f10448n = new j();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f10449a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10450b = "nav_type";

    public static final class a extends k<boolean[]> {
        public a() {
            super(true);
        }

        public String b() {
            return "boolean[]";
        }

        /* renamed from: i */
        public boolean[] a(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        /* renamed from: j */
        public boolean[] f(String str) {
            return new boolean[]{k.f10445k.f(str).booleanValue()};
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r3 = kotlin.collections.ArraysKt___ArraysJvmKt.v(r3, j(r2));
         */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean[] g(java.lang.String r2, boolean[] r3) {
            /*
                r1 = this;
                if (r3 == 0) goto L_0x000c
                boolean[] r0 = r1.f(r2)
                boolean[] r3 = kotlin.collections.ArraysKt___ArraysJvmKt.v(r3, r0)
                if (r3 != 0) goto L_0x0010
            L_0x000c:
                boolean[] r3 = r1.f(r2)
            L_0x0010:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.k.a.g(java.lang.String, boolean[]):boolean[]");
        }

        /* renamed from: l */
        public void h(Bundle bundle, String str, boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    public static final class b extends k<Boolean> {
        public b() {
            super(false);
        }

        public String b() {
            return "boolean";
        }

        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            k(bundle, str, ((Boolean) obj).booleanValue());
        }

        /* renamed from: i */
        public Boolean a(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        /* renamed from: j */
        public Boolean f(String str) {
            boolean z11;
            if (x.b(str, "true")) {
                z11 = true;
            } else if (x.b(str, com.sumsub.sns.internal.core.analytics.d.f31895b)) {
                z11 = false;
            } else {
                throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
            }
            return Boolean.valueOf(z11);
        }

        public void k(Bundle bundle, String str, boolean z11) {
            bundle.putBoolean(str, z11);
        }
    }

    public static final class c extends k<float[]> {
        public c() {
            super(true);
        }

        public String b() {
            return "float[]";
        }

        /* renamed from: i */
        public float[] a(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        /* renamed from: j */
        public float[] f(String str) {
            return new float[]{k.f10443i.f(str).floatValue()};
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r3 = kotlin.collections.ArraysKt___ArraysJvmKt.r(r3, j(r2));
         */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public float[] g(java.lang.String r2, float[] r3) {
            /*
                r1 = this;
                if (r3 == 0) goto L_0x000c
                float[] r0 = r1.f(r2)
                float[] r3 = kotlin.collections.ArraysKt___ArraysJvmKt.r(r3, r0)
                if (r3 != 0) goto L_0x0010
            L_0x000c:
                float[] r3 = r1.f(r2)
            L_0x0010:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.k.c.g(java.lang.String, float[]):float[]");
        }

        /* renamed from: l */
        public void h(Bundle bundle, String str, float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    }

    public static final class d extends k<Float> {
        public d() {
            super(false);
        }

        public String b() {
            return "float";
        }

        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            k(bundle, str, ((Number) obj).floatValue());
        }

        /* renamed from: i */
        public Float a(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        /* renamed from: j */
        public Float f(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        public void k(Bundle bundle, String str, float f11) {
            bundle.putFloat(str, f11);
        }
    }

    public static final class e extends k<int[]> {
        public e() {
            super(true);
        }

        public String b() {
            return "integer[]";
        }

        /* renamed from: i */
        public int[] a(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        /* renamed from: j */
        public int[] f(String str) {
            return new int[]{k.f10438d.f(str).intValue()};
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r3 = kotlin.collections.ArraysKt___ArraysJvmKt.s(r3, j(r2));
         */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int[] g(java.lang.String r2, int[] r3) {
            /*
                r1 = this;
                if (r3 == 0) goto L_0x000c
                int[] r0 = r1.f(r2)
                int[] r3 = kotlin.collections.ArraysKt___ArraysJvmKt.s(r3, r0)
                if (r3 != 0) goto L_0x0010
            L_0x000c:
                int[] r3 = r1.f(r2)
            L_0x0010:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.k.e.g(java.lang.String, int[]):int[]");
        }

        /* renamed from: l */
        public void h(Bundle bundle, String str, int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    }

    public static final class f extends k<Integer> {
        public f() {
            super(false);
        }

        public String b() {
            return "integer";
        }

        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            k(bundle, str, ((Number) obj).intValue());
        }

        /* renamed from: i */
        public Integer a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        /* renamed from: j */
        public Integer f(String str) {
            int i11;
            if (StringsKt__StringsJVMKt.M(str, "0x", false, 2, (Object) null)) {
                i11 = Integer.parseInt(str.substring(2), CharsKt__CharJVMKt.a(16));
            } else {
                i11 = Integer.parseInt(str);
            }
            return Integer.valueOf(i11);
        }

        public void k(Bundle bundle, String str, int i11) {
            bundle.putInt(str, i11);
        }
    }

    public static final class g extends k<long[]> {
        public g() {
            super(true);
        }

        public String b() {
            return "long[]";
        }

        /* renamed from: i */
        public long[] a(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        /* renamed from: j */
        public long[] f(String str) {
            return new long[]{k.f10441g.f(str).longValue()};
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r3 = kotlin.collections.ArraysKt___ArraysJvmKt.t(r3, j(r2));
         */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long[] g(java.lang.String r2, long[] r3) {
            /*
                r1 = this;
                if (r3 == 0) goto L_0x000c
                long[] r0 = r1.f(r2)
                long[] r3 = kotlin.collections.ArraysKt___ArraysJvmKt.t(r3, r0)
                if (r3 != 0) goto L_0x0010
            L_0x000c:
                long[] r3 = r1.f(r2)
            L_0x0010:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.k.g.g(java.lang.String, long[]):long[]");
        }

        /* renamed from: l */
        public void h(Bundle bundle, String str, long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    }

    public static final class h extends k<Long> {
        public h() {
            super(false);
        }

        public String b() {
            return "long";
        }

        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            k(bundle, str, ((Number) obj).longValue());
        }

        /* renamed from: i */
        public Long a(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        /* renamed from: j */
        public Long f(String str) {
            long j11;
            String substring = StringsKt__StringsJVMKt.v(str, "L", false, 2, (Object) null) ? str.substring(0, str.length() - 1) : str;
            if (StringsKt__StringsJVMKt.M(str, "0x", false, 2, (Object) null)) {
                j11 = Long.parseLong(substring.substring(2), CharsKt__CharJVMKt.a(16));
            } else {
                j11 = Long.parseLong(substring);
            }
            return Long.valueOf(j11);
        }

        public void k(Bundle bundle, String str, long j11) {
            bundle.putLong(str, j11);
        }
    }

    public static final class i extends k<Integer> {
        public i() {
            super(false);
        }

        public String b() {
            return "reference";
        }

        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            k(bundle, str, ((Number) obj).intValue());
        }

        /* renamed from: i */
        public Integer a(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        /* renamed from: j */
        public Integer f(String str) {
            int i11;
            if (StringsKt__StringsJVMKt.M(str, "0x", false, 2, (Object) null)) {
                i11 = Integer.parseInt(str.substring(2), CharsKt__CharJVMKt.a(16));
            } else {
                i11 = Integer.parseInt(str);
            }
            return Integer.valueOf(i11);
        }

        public void k(Bundle bundle, String str, int i11) {
            bundle.putInt(str, i11);
        }
    }

    public static final class j extends k<String[]> {
        public j() {
            super(true);
        }

        public String b() {
            return "string[]";
        }

        /* renamed from: i */
        public String[] a(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        /* renamed from: j */
        public String[] f(String str) {
            return new String[]{str};
        }

        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r3 = (java.lang.String[]) kotlin.collections.ArraysKt___ArraysJvmKt.u(r3, j(r2));
         */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String[] g(java.lang.String r2, java.lang.String[] r3) {
            /*
                r1 = this;
                if (r3 == 0) goto L_0x000e
                java.lang.String[] r0 = r1.f(r2)
                java.lang.Object[] r3 = kotlin.collections.ArraysKt___ArraysJvmKt.u(r3, r0)
                java.lang.String[] r3 = (java.lang.String[]) r3
                if (r3 != 0) goto L_0x0012
            L_0x000e:
                java.lang.String[] r3 = r1.f(r2)
            L_0x0012:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.k.j.g(java.lang.String, java.lang.String[]):java.lang.String[]");
        }

        /* renamed from: l */
        public void h(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    /* renamed from: androidx.navigation.k$k  reason: collision with other inner class name */
    public static final class C0052k extends k<String> {
        public C0052k() {
            super(true);
        }

        public String b() {
            return "string";
        }

        /* renamed from: i */
        public String a(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        /* renamed from: j */
        public String f(String str) {
            if (x.b(str, OptionsBridge.NULL_VALUE)) {
                return null;
            }
            return str;
        }

        /* renamed from: k */
        public void h(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    }

    public static final class l {
        public l() {
        }

        public /* synthetic */ l(r rVar) {
            this();
        }

        public k<?> a(String str, String str2) {
            String str3;
            k<Integer> kVar = k.f10438d;
            if (x.b(kVar.b(), str)) {
                return kVar;
            }
            k<int[]> kVar2 = k.f10440f;
            if (x.b(kVar2.b(), str)) {
                return kVar2;
            }
            k<Long> kVar3 = k.f10441g;
            if (x.b(kVar3.b(), str)) {
                return kVar3;
            }
            k<long[]> kVar4 = k.f10442h;
            if (x.b(kVar4.b(), str)) {
                return kVar4;
            }
            k<Boolean> kVar5 = k.f10445k;
            if (x.b(kVar5.b(), str)) {
                return kVar5;
            }
            k<boolean[]> kVar6 = k.f10446l;
            if (x.b(kVar6.b(), str)) {
                return kVar6;
            }
            k<String> kVar7 = k.f10447m;
            if (x.b(kVar7.b(), str)) {
                return kVar7;
            }
            k<String[]> kVar8 = k.f10448n;
            if (x.b(kVar8.b(), str)) {
                return kVar8;
            }
            k<Float> kVar9 = k.f10443i;
            if (x.b(kVar9.b(), str)) {
                return kVar9;
            }
            k<float[]> kVar10 = k.f10444j;
            if (x.b(kVar10.b(), str)) {
                return kVar10;
            }
            k<Integer> kVar11 = k.f10439e;
            if (x.b(kVar11.b(), str)) {
                return kVar11;
            }
            if (str == null || str.length() == 0) {
                return kVar7;
            }
            try {
                if (!StringsKt__StringsJVMKt.M(str, InstructionFileId.DOT, false, 2, (Object) null) || str2 == null) {
                    str3 = str;
                } else {
                    str3 = str2 + str;
                }
                if (StringsKt__StringsJVMKt.v(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, false, 2, (Object) null)) {
                    str3 = str3.substring(0, str3.length() - 2);
                    Class<?> cls = Class.forName(str3);
                    if (Parcelable.class.isAssignableFrom(cls)) {
                        return new n(cls);
                    }
                    if (Serializable.class.isAssignableFrom(cls)) {
                        return new p(cls);
                    }
                } else {
                    Class<?> cls2 = Class.forName(str3);
                    if (Parcelable.class.isAssignableFrom(cls2)) {
                        return new o(cls2);
                    }
                    if (Enum.class.isAssignableFrom(cls2)) {
                        return new m(cls2);
                    }
                    if (Serializable.class.isAssignableFrom(cls2)) {
                        return new q(cls2);
                    }
                }
                throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException(e11);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r0 = androidx.navigation.k.f10445k;
            r0.f(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
            return androidx.navigation.k.f10447m;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r0 = androidx.navigation.k.f10441g;
            r0.f(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            r0 = androidx.navigation.k.f10443i;
            r0.f(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
            return r0;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0006 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.navigation.k<java.lang.Object> b(java.lang.String r2) {
            /*
                r1 = this;
                androidx.navigation.k<java.lang.Integer> r0 = androidx.navigation.k.f10438d     // Catch:{ IllegalArgumentException -> 0x0006 }
                r0.f(r2)     // Catch:{ IllegalArgumentException -> 0x0006 }
                return r0
            L_0x0006:
                androidx.navigation.k<java.lang.Long> r0 = androidx.navigation.k.f10441g     // Catch:{ IllegalArgumentException -> 0x000c }
                r0.f(r2)     // Catch:{ IllegalArgumentException -> 0x000c }
                return r0
            L_0x000c:
                androidx.navigation.k<java.lang.Float> r0 = androidx.navigation.k.f10443i     // Catch:{ IllegalArgumentException -> 0x0012 }
                r0.f(r2)     // Catch:{ IllegalArgumentException -> 0x0012 }
                return r0
            L_0x0012:
                androidx.navigation.k<java.lang.Boolean> r0 = androidx.navigation.k.f10445k     // Catch:{ IllegalArgumentException -> 0x0018 }
                r0.f(r2)     // Catch:{ IllegalArgumentException -> 0x0018 }
                return r0
            L_0x0018:
                androidx.navigation.k<java.lang.String> r2 = androidx.navigation.k.f10447m
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.k.l.b(java.lang.String):androidx.navigation.k");
        }

        public final k<Object> c(Object obj) {
            k<Object> qVar;
            if (obj instanceof Integer) {
                return k.f10438d;
            }
            if (obj instanceof int[]) {
                return k.f10440f;
            }
            if (obj instanceof Long) {
                return k.f10441g;
            }
            if (obj instanceof long[]) {
                return k.f10442h;
            }
            if (obj instanceof Float) {
                return k.f10443i;
            }
            if (obj instanceof float[]) {
                return k.f10444j;
            }
            if (obj instanceof Boolean) {
                return k.f10445k;
            }
            if (obj instanceof boolean[]) {
                return k.f10446l;
            }
            if ((obj instanceof String) || obj == null) {
                return k.f10447m;
            }
            if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
                return k.f10448n;
            }
            if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                qVar = new n<>(obj.getClass().getComponentType());
            } else if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                qVar = new p<>(obj.getClass().getComponentType());
            } else if (obj instanceof Parcelable) {
                qVar = new o<>(obj.getClass());
            } else if (obj instanceof Enum) {
                qVar = new m<>(obj.getClass());
            } else if (obj instanceof Serializable) {
                qVar = new q<>(obj.getClass());
            } else {
                throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
            }
            return qVar;
        }
    }

    public static final class m<D extends Enum<?>> extends q<D> {

        /* renamed from: p  reason: collision with root package name */
        public final Class<D> f10451p;

        public m(Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.f10451p = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
        }

        public String b() {
            return this.f10451p.getName();
        }

        /* renamed from: l */
        public D j(String str) {
            D d11;
            D[] enumConstants = this.f10451p.getEnumConstants();
            int length = enumConstants.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    d11 = null;
                    break;
                }
                d11 = enumConstants[i11];
                if (StringsKt__StringsJVMKt.w(((Enum) d11).name(), str, true)) {
                    break;
                }
                i11++;
            }
            D d12 = (Enum) d11;
            if (d12 != null) {
                return d12;
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.f10451p.getName() + '.');
        }
    }

    public static final class n<D extends Parcelable> extends k<D[]> {

        /* renamed from: o  reason: collision with root package name */
        public final Class<D[]> f10452o;

        public n(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.f10452o = Class.forName("[L" + cls.getName() + ';');
                } catch (ClassNotFoundException e11) {
                    throw new RuntimeException(e11);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Parcelable.").toString());
            }
        }

        public String b() {
            return this.f10452o.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !x.b(n.class, obj.getClass())) {
                return false;
            }
            return x.b(this.f10452o, ((n) obj).f10452o);
        }

        public int hashCode() {
            return this.f10452o.hashCode();
        }

        /* renamed from: i */
        public D[] a(Bundle bundle, String str) {
            return (Parcelable[]) bundle.get(str);
        }

        /* renamed from: j */
        public D[] f(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: k */
        public void h(Bundle bundle, String str, D[] dArr) {
            this.f10452o.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }
    }

    public static final class o<D> extends k<D> {

        /* renamed from: o  reason: collision with root package name */
        public final Class<D> f10453o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(Class<D> cls) {
            super(true);
            boolean z11 = true;
            if (!Parcelable.class.isAssignableFrom(cls) && !Serializable.class.isAssignableFrom(cls)) {
                z11 = false;
            }
            if (z11) {
                this.f10453o = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Parcelable or Serializable.").toString());
        }

        public D a(Bundle bundle, String str) {
            return bundle.get(str);
        }

        public String b() {
            return this.f10453o.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !x.b(o.class, obj.getClass())) {
                return false;
            }
            return x.b(this.f10453o, ((o) obj).f10453o);
        }

        public D f(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public void h(Bundle bundle, String str, D d11) {
            this.f10453o.cast(d11);
            if (d11 == null || (d11 instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d11);
            } else if (d11 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d11);
            }
        }

        public int hashCode() {
            return this.f10453o.hashCode();
        }
    }

    public static final class p<D extends Serializable> extends k<D[]> {

        /* renamed from: o  reason: collision with root package name */
        public final Class<D[]> f10454o;

        public p(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.f10454o = Class.forName("[L" + cls.getName() + ';');
                } catch (ClassNotFoundException e11) {
                    throw new RuntimeException(e11);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
        }

        public String b() {
            return this.f10454o.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !x.b(p.class, obj.getClass())) {
                return false;
            }
            return x.b(this.f10454o, ((p) obj).f10454o);
        }

        public int hashCode() {
            return this.f10454o.hashCode();
        }

        /* renamed from: i */
        public D[] a(Bundle bundle, String str) {
            return (Serializable[]) bundle.get(str);
        }

        /* renamed from: j */
        public D[] f(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* renamed from: k */
        public void h(Bundle bundle, String str, D[] dArr) {
            this.f10454o.cast(dArr);
            bundle.putSerializable(str, (Serializable) dArr);
        }
    }

    public k(boolean z11) {
        this.f10449a = z11;
    }

    public abstract T a(Bundle bundle, String str);

    public abstract String b();

    public boolean c() {
        return this.f10449a;
    }

    public final T d(Bundle bundle, String str, String str2) {
        T f11 = f(str2);
        h(bundle, str, f11);
        return f11;
    }

    public final T e(Bundle bundle, String str, String str2, T t11) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("There is no previous value in this bundle.");
        } else if (str2 == null) {
            return t11;
        } else {
            T g11 = g(str2, t11);
            h(bundle, str, g11);
            return g11;
        }
    }

    public abstract T f(String str);

    public T g(String str, T t11) {
        return f(str);
    }

    public abstract void h(Bundle bundle, String str, T t11);

    public String toString() {
        return b();
    }

    public static class q<D extends Serializable> extends k<D> {

        /* renamed from: o  reason: collision with root package name */
        public final Class<D> f10455o;

        public q(Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            } else if (true ^ cls.isEnum()) {
                this.f10455o = cls;
            } else {
                throw new IllegalArgumentException((cls + " is an Enum. You should use EnumType instead.").toString());
            }
        }

        public String b() {
            return this.f10455o.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof q)) {
                return false;
            }
            return x.b(this.f10455o, ((q) obj).f10455o);
        }

        public int hashCode() {
            return this.f10455o.hashCode();
        }

        /* renamed from: i */
        public D a(Bundle bundle, String str) {
            return (Serializable) bundle.get(str);
        }

        /* renamed from: j */
        public D f(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        /* renamed from: k */
        public void h(Bundle bundle, String str, D d11) {
            this.f10455o.cast(d11);
            bundle.putSerializable(str, d11);
        }

        public q(boolean z11, Class<D> cls) {
            super(z11);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.f10455o = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }
    }
}
