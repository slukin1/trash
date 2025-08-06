package jumio.liveness;

import com.jumio.core.extraction.JumioRect;
import java.util.ArrayList;
import kotlin.jvm.internal.r;

public final class s {
    public static final JumioRect a(ArrayList arrayList) {
        if (arrayList.size() != 4) {
            return new JumioRect(0, 0, 0, 0, 15, (r) null);
        }
        return new JumioRect(((Number) arrayList.get(0)).intValue(), ((Number) arrayList.get(1)).intValue(), ((Number) arrayList.get(2)).intValue() + ((Number) arrayList.get(0)).intValue(), ((Number) arrayList.get(3)).intValue() + ((Number) arrayList.get(1)).intValue());
    }
}
