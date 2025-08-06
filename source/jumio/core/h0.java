package jumio.core;

import com.jumio.core.credentials.RequiredPart;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class h0 extends Lambda implements l<String, RequiredPart> {

    /* renamed from: a  reason: collision with root package name */
    public static final h0 f56214a = new h0();

    public h0() {
        super(1);
    }

    public final Object invoke(Object obj) {
        return RequiredPart.Companion.fromString((String) obj);
    }
}
