package jumio.core;

import com.jumio.commons.log.Log;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class o0 extends Lambda implements l<String, r1> {

    /* renamed from: a  reason: collision with root package name */
    public static final o0 f56289a = new o0();

    public o0() {
        super(1);
    }

    public static r1 a(String str) {
        try {
            return r1.valueOf(str);
        } catch (Exception unused) {
            Log.e(str + " is not a valid LivenessType");
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return a((String) obj);
    }
}
