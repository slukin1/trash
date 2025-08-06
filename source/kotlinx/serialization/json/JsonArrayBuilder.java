package kotlinx.serialization.json;

import java.util.ArrayList;
import java.util.List;

public final class JsonArrayBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final List<g> f57807a = new ArrayList();

    public final boolean a(g gVar) {
        this.f57807a.add(gVar);
        return true;
    }

    public final b b() {
        return new b(this.f57807a);
    }
}
