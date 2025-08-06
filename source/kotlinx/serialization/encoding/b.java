package kotlinx.serialization.encoding;

import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.g;

public interface b {

    public static final class a {
        public static boolean a(b bVar, f fVar, int i11) {
            return true;
        }
    }

    void C(f fVar, int i11, float f11);

    <T> void F(f fVar, int i11, g<? super T> gVar, T t11);

    void G(f fVar, int i11, double d11);

    void c(f fVar);

    void i(f fVar, int i11, char c11);

    void j(f fVar, int i11, byte b11);

    void n(f fVar, int i11, int i12);

    void o(f fVar, int i11, boolean z11);

    void p(f fVar, int i11, String str);

    boolean q(f fVar, int i11);

    void t(f fVar, int i11, short s11);

    void u(f fVar, int i11, long j11);

    d w(f fVar, int i11);

    <T> void y(f fVar, int i11, g<? super T> gVar, T t11);
}
