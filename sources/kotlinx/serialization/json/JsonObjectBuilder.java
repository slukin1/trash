package kotlinx.serialization.json;

import java.util.LinkedHashMap;
import java.util.Map;

public final class JsonObjectBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, g> f57826a = new LinkedHashMap();

    public final JsonObject a() {
        return new JsonObject(this.f57826a);
    }

    public final g b(String str, g gVar) {
        return this.f57826a.put(str, gVar);
    }
}
