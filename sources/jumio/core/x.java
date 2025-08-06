package jumio.core;

import com.jumio.sdk.consent.JumioConsentItem;
import java.util.Map;
import kotlin.l;

public final class x {
    public static final Map<String, Object> a(JumioConsentItem jumioConsentItem, Long l11) {
        Map m11 = MapsKt__MapsKt.m(l.a("id", jumioConsentItem.getId()), l.a("displayType", jumioConsentItem.getType().name()));
        if (l11 != null) {
            m11.put("timestamp", Long.valueOf(l11.longValue()));
        }
        return MapsKt__MapsKt.u(m11);
    }
}
