package kotlinx.serialization.internal;

import com.sumsub.sns.internal.fingerprint.infoproviders.q;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.d0;

public final class j0 {

    public static final class a implements d0<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b<T> f57730a;

        public a(b<T> bVar) {
            this.f57730a = bVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlinx.serialization.b<?>[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public kotlinx.serialization.b<?>[] childSerializers() {
            /*
                r3 = this;
                r0 = 1
                kotlinx.serialization.b[] r0 = new kotlinx.serialization.b[r0]
                kotlinx.serialization.b<T> r1 = r3.f57730a
                r2 = 0
                r0[r2] = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.j0.a.childSerializers():kotlinx.serialization.b[]");
        }

        public T deserialize(c cVar) {
            throw new IllegalStateException(q.f34641a.toString());
        }

        public f getDescriptor() {
            throw new IllegalStateException(q.f34641a.toString());
        }

        public void serialize(d dVar, T t11) {
            throw new IllegalStateException(q.f34641a.toString());
        }

        public b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    public static final <T> f a(String str, b<T> bVar) {
        return new i0(str, new a(bVar));
    }
}
