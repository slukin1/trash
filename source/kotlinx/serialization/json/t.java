package kotlinx.serialization.json;

import kotlin.jvm.internal.r;
import kotlinx.serialization.b;
import kotlinx.serialization.f;

@f(with = u.class)
public abstract class t extends g {
    public static final a Companion = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final b<t> serializer() {
            return u.f57955a;
        }
    }

    public t() {
        super((r) null);
    }

    public /* synthetic */ t(r rVar) {
        this();
    }

    public abstract String a();

    public abstract boolean c();

    public String toString() {
        return a();
    }
}
