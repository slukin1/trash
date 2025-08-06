package kotlinx.serialization.json;

import com.iproov.sdk.bridge.OptionsBridge;
import kotlin.LazyThreadSafetyMode;
import kotlin.i;
import kotlin.jvm.internal.r;
import kotlinx.serialization.b;
import kotlinx.serialization.f;

@f(with = r.class)
public final class JsonNull extends t {
    public static final JsonNull INSTANCE = new JsonNull();

    /* renamed from: a  reason: collision with root package name */
    public static final String f57823a = OptionsBridge.NULL_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ i<b<Object>> f57824b = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.PUBLICATION, JsonNull$$cachedSerializer$delegate$1.INSTANCE);

    public JsonNull() {
        super((r) null);
    }

    private final /* synthetic */ i d() {
        return f57824b;
    }

    public String a() {
        return f57823a;
    }

    public boolean c() {
        return false;
    }

    public final b<JsonNull> serializer() {
        return (b) d().getValue();
    }
}
