package kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.d0;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class s implements b<JsonObject> {

    /* renamed from: a  reason: collision with root package name */
    public static final s f57950a = new s();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57951b = a.f57952b;

    public static final class a implements f {

        /* renamed from: b  reason: collision with root package name */
        public static final a f57952b = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final String f57953c = "kotlinx.serialization.json.JsonObject";

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f57954a = h10.a.k(h10.a.I(d0.f56774a), JsonElementSerializer.f57821a).getDescriptor();

        public boolean b() {
            return this.f57954a.b();
        }

        public int c(String str) {
            return this.f57954a.c(str);
        }

        public f d(int i11) {
            return this.f57954a.d(i11);
        }

        public int e() {
            return this.f57954a.e();
        }

        public String f(int i11) {
            return this.f57954a.f(i11);
        }

        public List<Annotation> g(int i11) {
            return this.f57954a.g(i11);
        }

        public List<Annotation> getAnnotations() {
            return this.f57954a.getAnnotations();
        }

        public h getKind() {
            return this.f57954a.getKind();
        }

        public String h() {
            return f57953c;
        }

        public boolean i(int i11) {
            return this.f57954a.i(i11);
        }

        public boolean isInline() {
            return this.f57954a.isInline();
        }
    }

    /* renamed from: a */
    public JsonObject deserialize(c cVar) {
        j.g(cVar);
        return new JsonObject(h10.a.k(h10.a.I(d0.f56774a), JsonElementSerializer.f57821a).deserialize(cVar));
    }

    /* renamed from: b */
    public void serialize(d dVar, JsonObject jsonObject) {
        j.h(dVar);
        h10.a.k(h10.a.I(d0.f56774a), JsonElementSerializer.f57821a).serialize(dVar, jsonObject);
    }

    public f getDescriptor() {
        return f57951b;
    }
}
