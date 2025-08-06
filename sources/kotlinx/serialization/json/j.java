package kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class j {

    public static final class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final i f57942a;

        public a(d10.a<? extends f> aVar) {
            this.f57942a = LazyKt__LazyJVMKt.a(aVar);
        }

        public final f a() {
            return (f) this.f57942a.getValue();
        }

        public boolean b() {
            return f.a.c(this);
        }

        public int c(String str) {
            return a().c(str);
        }

        public f d(int i11) {
            return a().d(i11);
        }

        public int e() {
            return a().e();
        }

        public String f(int i11) {
            return a().f(i11);
        }

        public List<Annotation> g(int i11) {
            return a().g(i11);
        }

        public List<Annotation> getAnnotations() {
            return f.a.a(this);
        }

        public h getKind() {
            return a().getKind();
        }

        public String h() {
            return a().h();
        }

        public boolean i(int i11) {
            return a().i(i11);
        }

        public boolean isInline() {
            return f.a.b(this);
        }
    }

    public static final f d(c cVar) {
        f fVar = cVar instanceof f ? (f) cVar : null;
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + Reflection.b(cVar.getClass()));
    }

    public static final k e(d dVar) {
        k kVar = dVar instanceof k ? (k) dVar : null;
        if (kVar != null) {
            return kVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + Reflection.b(dVar.getClass()));
    }

    public static final f f(d10.a<? extends f> aVar) {
        return new a(aVar);
    }

    public static final void g(c cVar) {
        d(cVar);
    }

    public static final void h(d dVar) {
        e(dVar);
    }
}
