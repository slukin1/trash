package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;

public abstract class h {

    public static final class a extends h {

        /* renamed from: a  reason: collision with root package name */
        public static final a f57645a = new a();

        public a() {
            super((r) null);
        }
    }

    public static final class b extends h {

        /* renamed from: a  reason: collision with root package name */
        public static final b f57646a = new b();

        public b() {
            super((r) null);
        }
    }

    public h() {
    }

    public /* synthetic */ h(r rVar) {
        this();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return Reflection.b(getClass()).f();
    }
}
