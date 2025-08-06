package jumio.core;

import com.jumio.core.credentials.DeviceRiskVendor;
import com.jumio.core.credentials.JCredentialCapabilities;
import com.jumio.core.credentials.RequiredPart;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import java.util.List;

public final class b0 extends c0 {

    /* renamed from: h  reason: collision with root package name */
    public final List<DeviceRiskVendor> f56137h;

    public b0(String str, List<? extends JCredentialCapabilities> list, List<? extends RequiredPart> list2, List<? extends DeviceRiskVendor> list3) {
        super(str, JumioCredentialCategory.DATA, list, list2);
        this.f56137h = list3;
    }

    public final List<DeviceRiskVendor> d() {
        return this.f56137h;
    }

    public b0() {
        this("", CollectionsKt__CollectionsKt.k(), CollectionsKt__CollectionsKt.k(), CollectionsKt__CollectionsKt.k());
    }
}
