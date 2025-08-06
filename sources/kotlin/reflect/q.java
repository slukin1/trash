package kotlin.reflect;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class q {

    /* renamed from: c  reason: collision with root package name */
    public static final a f56856c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final q f56857d = new q((KVariance) null, (p) null);

    /* renamed from: a  reason: collision with root package name */
    public final KVariance f56858a;

    /* renamed from: b  reason: collision with root package name */
    public final p f56859b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final q a(p pVar) {
            return new q(KVariance.INVARIANT, pVar);
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56860a;

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
                f56860a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.q.b.<clinit>():void");
        }
    }

    public q(KVariance kVariance, p pVar) {
        String str;
        this.f56858a = kVariance;
        this.f56859b = pVar;
        if (!((kVariance == null) != (pVar == null) ? false : true)) {
            if (kVariance == null) {
                str = "Star projection must have no type specified.";
            } else {
                str = "The projection variance " + kVariance + " requires type to be specified.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public final p a() {
        return this.f56859b;
    }

    public final KVariance b() {
        return this.f56858a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f56858a == qVar.f56858a && x.b(this.f56859b, qVar.f56859b);
    }

    public int hashCode() {
        KVariance kVariance = this.f56858a;
        int i11 = 0;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        p pVar = this.f56859b;
        if (pVar != null) {
            i11 = pVar.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        KVariance kVariance = this.f56858a;
        int i11 = kVariance == null ? -1 : b.f56860a[kVariance.ordinal()];
        if (i11 == -1) {
            return "*";
        }
        if (i11 == 1) {
            return String.valueOf(this.f56859b);
        }
        if (i11 == 2) {
            return "in " + this.f56859b;
        } else if (i11 == 3) {
            return "out " + this.f56859b;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
