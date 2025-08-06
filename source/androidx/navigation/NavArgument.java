package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.internal.x;

public final class NavArgument {

    /* renamed from: a  reason: collision with root package name */
    public final k<Object> f10226a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f10227b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f10228c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f10229d;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public k<Object> f10230a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f10231b;

        /* renamed from: c  reason: collision with root package name */
        public Object f10232c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f10233d;

        public final NavArgument a() {
            k<Object> kVar = this.f10230a;
            if (kVar == null) {
                kVar = k.f10437c.c(this.f10232c);
            }
            return new NavArgument(kVar, this.f10231b, this.f10232c, this.f10233d);
        }

        public final Builder b(Object obj) {
            this.f10232c = obj;
            this.f10233d = true;
            return this;
        }

        public final Builder c(boolean z11) {
            this.f10231b = z11;
            return this;
        }

        public final <T> Builder d(k<T> kVar) {
            this.f10230a = kVar;
            return this;
        }
    }

    public NavArgument(k<Object> kVar, boolean z11, Object obj, boolean z12) {
        boolean z13 = false;
        if (kVar.c() || !z11) {
            if ((z11 || !z12 || obj != null) ? true : z13) {
                this.f10226a = kVar;
                this.f10227b = z11;
                this.f10229d = obj;
                this.f10228c = z12;
                return;
            }
            throw new IllegalArgumentException(("Argument with type " + kVar.b() + " has null value but is not nullable.").toString());
        }
        throw new IllegalArgumentException((kVar.b() + " does not allow nullable values").toString());
    }

    public final k<Object> a() {
        return this.f10226a;
    }

    public final boolean b() {
        return this.f10228c;
    }

    public final boolean c() {
        return this.f10227b;
    }

    public final void d(String str, Bundle bundle) {
        if (this.f10228c) {
            this.f10226a.h(bundle, str, this.f10229d);
        }
    }

    public final boolean e(String str, Bundle bundle) {
        if (!this.f10227b && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.f10226a.a(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !x.b(NavArgument.class, obj.getClass())) {
            return false;
        }
        NavArgument navArgument = (NavArgument) obj;
        if (this.f10227b != navArgument.f10227b || this.f10228c != navArgument.f10228c || !x.b(this.f10226a, navArgument.f10226a)) {
            return false;
        }
        Object obj2 = this.f10229d;
        if (obj2 != null) {
            return x.b(obj2, navArgument.f10229d);
        }
        if (navArgument.f10229d == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f10226a.hashCode() * 31) + (this.f10227b ? 1 : 0)) * 31) + (this.f10228c ? 1 : 0)) * 31;
        Object obj = this.f10229d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(NavArgument.class.getSimpleName());
        sb2.append(" Type: " + this.f10226a);
        sb2.append(" Nullable: " + this.f10227b);
        if (this.f10228c) {
            sb2.append(" DefaultValue: " + this.f10229d);
        }
        return sb2.toString();
    }
}
