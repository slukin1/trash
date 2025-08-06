package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class l {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f9178b = true;

    /* renamed from: c  reason: collision with root package name */
    public static final Class<?> f9179c = c();

    /* renamed from: d  reason: collision with root package name */
    public static volatile l f9180d;

    /* renamed from: e  reason: collision with root package name */
    public static final l f9181e = new l(true);

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, GeneratedMessageLite.d<?, ?>> f9182a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f9183a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9184b;

        public a(Object obj, int i11) {
            this.f9183a = obj;
            this.f9184b = i11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f9183a == aVar.f9183a && this.f9184b == aVar.f9184b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f9183a) * 65535) + this.f9184b;
        }
    }

    public l() {
        this.f9182a = new HashMap();
    }

    public static l b() {
        l lVar = f9180d;
        if (lVar == null) {
            synchronized (l.class) {
                lVar = f9180d;
                if (lVar == null) {
                    lVar = f9178b ? k.a() : f9181e;
                    f9180d = lVar;
                }
            }
        }
        return lVar;
    }

    public static Class<?> c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public <ContainingType extends f0> GeneratedMessageLite.d<ContainingType, ?> a(ContainingType containingtype, int i11) {
        return this.f9182a.get(new a(containingtype, i11));
    }

    public l(boolean z11) {
        this.f9182a = Collections.emptyMap();
    }
}
