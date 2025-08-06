package kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.encoding.d;

public final class c implements b<b> {

    /* renamed from: a  reason: collision with root package name */
    public static final c f57832a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57833b = a.f57834b;

    public static final class a implements f {

        /* renamed from: b  reason: collision with root package name */
        public static final a f57834b = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final String f57835c = "kotlinx.serialization.json.JsonArray";

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f57836a = h10.a.h(JsonElementSerializer.f57821a).getDescriptor();

        public boolean b() {
            return this.f57836a.b();
        }

        public int c(String str) {
            return this.f57836a.c(str);
        }

        public f d(int i11) {
            return this.f57836a.d(i11);
        }

        public int e() {
            return this.f57836a.e();
        }

        public String f(int i11) {
            return this.f57836a.f(i11);
        }

        public List<Annotation> g(int i11) {
            return this.f57836a.g(i11);
        }

        public List<Annotation> getAnnotations() {
            return this.f57836a.getAnnotations();
        }

        public h getKind() {
            return this.f57836a.getKind();
        }

        public String h() {
            return f57835c;
        }

        public boolean i(int i11) {
            return this.f57836a.i(i11);
        }

        public boolean isInline() {
            return this.f57836a.isInline();
        }
    }

    /* renamed from: a */
    public b deserialize(kotlinx.serialization.encoding.c cVar) {
        j.g(cVar);
        return new b((List) h10.a.h(JsonElementSerializer.f57821a).deserialize(cVar));
    }

    /* renamed from: b */
    public void serialize(d dVar, b bVar) {
        j.h(dVar);
        h10.a.h(JsonElementSerializer.f57821a).serialize(dVar, bVar);
    }

    public f getDescriptor() {
        return f57833b;
    }
}
