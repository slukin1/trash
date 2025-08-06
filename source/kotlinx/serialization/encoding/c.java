package kotlinx.serialization.encoding;

import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.modules.d;

public interface c {

    public static final class a {
        public static <T> T a(c cVar, kotlinx.serialization.a<? extends T> aVar) {
            return aVar.deserialize(cVar);
        }
    }

    boolean A();

    boolean D();

    <T> T G(kotlinx.serialization.a<? extends T> aVar);

    byte H();

    d a();

    a b(f fVar);

    Void g();

    long h();

    short m();

    double n();

    char o();

    String q();

    int s(f fVar);

    int u();

    c x(f fVar);

    float y();
}
