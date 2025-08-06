package kotlinx.serialization.encoding;

import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.g;

public interface d {

    public static final class a {
        public static b a(d dVar, f fVar, int i11) {
            return dVar.b(fVar);
        }

        public static void b(d dVar) {
        }

        public static <T> void c(d dVar, g<? super T> gVar, T t11) {
            if (gVar.getDescriptor().b()) {
                dVar.e(gVar, t11);
            } else if (t11 == null) {
                dVar.B();
            } else {
                dVar.E();
                dVar.e(gVar, t11);
            }
        }

        public static <T> void d(d dVar, g<? super T> gVar, T t11) {
            gVar.serialize(dVar, t11);
        }
    }

    void A(long j11);

    void B();

    void D(char c11);

    void E();

    kotlinx.serialization.modules.d a();

    b b(f fVar);

    <T> void e(g<? super T> gVar, T t11);

    void f(byte b11);

    void g(f fVar, int i11);

    d h(f fVar);

    void k(short s11);

    void l(boolean z11);

    void m(float f11);

    void s(int i11);

    void v(String str);

    void x(double d11);

    b z(f fVar, int i11);
}
