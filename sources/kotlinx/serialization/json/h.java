package kotlinx.serialization.json;

import d10.l;
import kotlin.Unit;

public final class h {
    public static final boolean a(JsonArrayBuilder jsonArrayBuilder, Boolean bool) {
        return jsonArrayBuilder.a(i.a(bool));
    }

    public static final boolean b(JsonArrayBuilder jsonArrayBuilder, Number number) {
        return jsonArrayBuilder.a(i.b(number));
    }

    public static final boolean c(JsonArrayBuilder jsonArrayBuilder, String str) {
        return jsonArrayBuilder.a(i.c(str));
    }

    public static final g d(JsonObjectBuilder jsonObjectBuilder, String str, Boolean bool) {
        return jsonObjectBuilder.b(str, i.a(bool));
    }

    public static final g e(JsonObjectBuilder jsonObjectBuilder, String str, Number number) {
        return jsonObjectBuilder.b(str, i.b(number));
    }

    public static final g f(JsonObjectBuilder jsonObjectBuilder, String str, String str2) {
        return jsonObjectBuilder.b(str, i.c(str2));
    }

    public static final g g(JsonObjectBuilder jsonObjectBuilder, String str, l<? super JsonArrayBuilder, Unit> lVar) {
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        lVar.invoke(jsonArrayBuilder);
        return jsonObjectBuilder.b(str, jsonArrayBuilder.b());
    }

    public static final g h(JsonObjectBuilder jsonObjectBuilder, String str, l<? super JsonObjectBuilder, Unit> lVar) {
        JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
        lVar.invoke(jsonObjectBuilder2);
        return jsonObjectBuilder.b(str, jsonObjectBuilder2.a());
    }
}
