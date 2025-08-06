package jumio.core;

import com.jumio.core.credentials.JCredentialCapabilities;
import d10.l;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

public final class g0 extends Lambda implements l<JSONObject, JCredentialCapabilities> {

    /* renamed from: a  reason: collision with root package name */
    public static final g0 f56205a = new g0();

    public g0() {
        super(1);
    }

    public final Object invoke(Object obj) {
        return JCredentialCapabilities.f39083a.fromJson((JSONObject) obj);
    }
}
