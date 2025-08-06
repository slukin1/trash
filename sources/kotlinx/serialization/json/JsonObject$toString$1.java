package kotlinx.serialization.json;

import d10.l;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.internal.n0;

public final class JsonObject$toString$1 extends Lambda implements l<Map.Entry<? extends String, ? extends g>, CharSequence> {
    public static final JsonObject$toString$1 INSTANCE = new JsonObject$toString$1();

    public JsonObject$toString$1() {
        super(1);
    }

    public final CharSequence invoke(Map.Entry<String, ? extends g> entry) {
        StringBuilder sb2 = new StringBuilder();
        n0.c(sb2, entry.getKey());
        sb2.append(':');
        sb2.append((g) entry.getValue());
        return sb2.toString();
    }
}
