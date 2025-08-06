package kotlinx.serialization.encoding;

import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.modules.d;

public interface a {

    /* renamed from: kotlinx.serialization.encoding.a$a  reason: collision with other inner class name */
    public static final class C0670a {
        public static int a(a aVar, f fVar) {
            return -1;
        }

        public static boolean b(a aVar) {
            return false;
        }

        public static /* synthetic */ Object c(a aVar, f fVar, int i11, kotlinx.serialization.a aVar2, Object obj, int i12, Object obj2) {
            if (obj2 == null) {
                if ((i12 & 8) != 0) {
                    obj = null;
                }
                return aVar.p(fVar, i11, aVar2, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
        }
    }

    byte B(f fVar, int i11);

    boolean C(f fVar, int i11);

    short E(f fVar, int i11);

    double F(f fVar, int i11);

    d a();

    void c(f fVar);

    long e(f fVar, int i11);

    int f(f fVar, int i11);

    String i(f fVar, int i11);

    <T> T j(f fVar, int i11, kotlinx.serialization.a<? extends T> aVar, T t11);

    boolean k();

    c l(f fVar, int i11);

    <T> T p(f fVar, int i11, kotlinx.serialization.a<? extends T> aVar, T t11);

    char r(f fVar, int i11);

    int v(f fVar);

    int w(f fVar);

    float z(f fVar, int i11);
}
