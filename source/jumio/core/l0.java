package jumio.core;

import com.jumio.core.credentials.DeviceRiskVendor;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class l0 extends Lambda implements l<String, DeviceRiskVendor> {

    /* renamed from: a  reason: collision with root package name */
    public static final l0 f56242a = new l0();

    public l0() {
        super(1);
    }

    public final Object invoke(Object obj) {
        return DeviceRiskVendor.Companion.fromString((String) obj);
    }
}
