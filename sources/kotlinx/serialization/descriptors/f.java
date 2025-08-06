package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;

public interface f {

    public static final class a {
        public static List<Annotation> a(f fVar) {
            return CollectionsKt__CollectionsKt.k();
        }

        public static boolean b(f fVar) {
            return false;
        }

        public static boolean c(f fVar) {
            return false;
        }
    }

    boolean b();

    int c(String str);

    f d(int i11);

    int e();

    String f(int i11);

    List<Annotation> g(int i11);

    List<Annotation> getAnnotations();

    h getKind();

    String h();

    boolean i(int i11);

    boolean isInline();
}
