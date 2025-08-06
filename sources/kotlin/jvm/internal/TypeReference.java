package kotlin.jvm.internal;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.c;
import kotlin.reflect.e;
import kotlin.reflect.p;
import kotlin.reflect.q;

public final class TypeReference implements p {

    /* renamed from: f  reason: collision with root package name */
    public static final a f56756f = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final e f56757b;

    /* renamed from: c  reason: collision with root package name */
    public final List<q> f56758c;

    /* renamed from: d  reason: collision with root package name */
    public final p f56759d;

    /* renamed from: e  reason: collision with root package name */
    public final int f56760e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56761a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.reflect.KVariance[] r0 = kotlin.reflect.KVariance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.INVARIANT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.IN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.OUT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f56761a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.TypeReference.b.<clinit>():void");
        }
    }

    public TypeReference(e eVar, List<q> list, p pVar, int i11) {
        this.f56757b = eVar;
        this.f56758c = list;
        this.f56759d = pVar;
        this.f56760e = i11;
    }

    public boolean b() {
        return (this.f56760e & 1) != 0;
    }

    public e c() {
        return this.f56757b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            return x.b(c(), typeReference.c()) && x.b(g(), typeReference.g()) && x.b(this.f56759d, typeReference.f56759d) && this.f56760e == typeReference.f56760e;
        }
    }

    public List<q> g() {
        return this.f56758c;
    }

    public final String h(q qVar) {
        String str;
        if (qVar.b() == null) {
            return "*";
        }
        p a11 = qVar.a();
        TypeReference typeReference = a11 instanceof TypeReference ? (TypeReference) a11 : null;
        if (typeReference == null || (str = typeReference.i(true)) == null) {
            str = String.valueOf(qVar.a());
        }
        int i11 = b.f56761a[qVar.b().ordinal()];
        if (i11 == 1) {
            return str;
        }
        if (i11 == 2) {
            return "in " + str;
        } else if (i11 == 3) {
            return "out " + str;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public int hashCode() {
        return (((c().hashCode() * 31) + g().hashCode()) * 31) + this.f56760e;
    }

    public final String i(boolean z11) {
        String str;
        String str2;
        e c11 = c();
        Class cls = null;
        c cVar = c11 instanceof c ? (c) c11 : null;
        if (cVar != null) {
            cls = c10.a.a(cVar);
        }
        if (cls == null) {
            str = c().toString();
        } else if ((this.f56760e & 4) != 0) {
            str = "kotlin.Nothing";
        } else if (cls.isArray()) {
            str = j(cls);
        } else if (!z11 || !cls.isPrimitive()) {
            str = cls.getName();
        } else {
            str = c10.a.b((c) c()).getName();
        }
        String str3 = "";
        if (g().isEmpty()) {
            str2 = str3;
        } else {
            str2 = CollectionsKt___CollectionsKt.k0(g(), ", ", "<", ">", 0, (CharSequence) null, new TypeReference$asString$args$1(this), 24, (Object) null);
        }
        if (b()) {
            str3 = "?";
        }
        String str4 = str + str2 + str3;
        p pVar = this.f56759d;
        if (!(pVar instanceof TypeReference)) {
            return str4;
        }
        String i11 = ((TypeReference) pVar).i(true);
        if (x.b(i11, str4)) {
            return str4;
        }
        if (x.b(i11, str4 + '?')) {
            return str4 + '!';
        }
        return '(' + str4 + ".." + i11 + ')';
    }

    public final String j(Class<?> cls) {
        if (x.b(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (x.b(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (x.b(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (x.b(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (x.b(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (x.b(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (x.b(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        return x.b(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public final int k() {
        return this.f56760e;
    }

    public String toString() {
        return i(false) + " (Kotlin reflection is not available)";
    }

    public TypeReference(e eVar, List<q> list, boolean z11) {
        this(eVar, list, (p) null, z11 ? 1 : 0);
    }
}
