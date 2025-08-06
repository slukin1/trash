package kotlinx.serialization.modules;

import d10.l;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class a {

    /* renamed from: kotlinx.serialization.modules.a$a  reason: collision with other inner class name */
    public static final class C0672a extends a {

        /* renamed from: a  reason: collision with root package name */
        public final kotlinx.serialization.b<?> f57962a;

        public C0672a(kotlinx.serialization.b<?> bVar) {
            super((r) null);
            this.f57962a = bVar;
        }

        public kotlinx.serialization.b<?> a(List<? extends kotlinx.serialization.b<?>> list) {
            return this.f57962a;
        }

        public final kotlinx.serialization.b<?> b() {
            return this.f57962a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C0672a) && x.b(((C0672a) obj).f57962a, this.f57962a);
        }

        public int hashCode() {
            return this.f57962a.hashCode();
        }
    }

    public static final class b extends a {

        /* renamed from: a  reason: collision with root package name */
        public final l<List<? extends kotlinx.serialization.b<?>>, kotlinx.serialization.b<?>> f57963a;

        public b(l<? super List<? extends kotlinx.serialization.b<?>>, ? extends kotlinx.serialization.b<?>> lVar) {
            super((r) null);
            this.f57963a = lVar;
        }

        public kotlinx.serialization.b<?> a(List<? extends kotlinx.serialization.b<?>> list) {
            return this.f57963a.invoke(list);
        }

        public final l<List<? extends kotlinx.serialization.b<?>>, kotlinx.serialization.b<?>> b() {
            return this.f57963a;
        }
    }

    public a() {
    }

    public /* synthetic */ a(r rVar) {
        this();
    }

    public abstract kotlinx.serialization.b<?> a(List<? extends kotlinx.serialization.b<?>> list);
}
