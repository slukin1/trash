package jumio.liveness;

import com.jumio.liveness.image.LivenessImageData;
import java.util.Comparator;

public final class n<T> implements Comparator {
    public final int compare(T t11, T t12) {
        Integer iod = ((LivenessImageData) t12).getIod();
        int i11 = Integer.MAX_VALUE;
        Integer valueOf = Integer.valueOf(iod != null ? iod.intValue() : Integer.MAX_VALUE);
        Integer iod2 = ((LivenessImageData) t11).getIod();
        if (iod2 != null) {
            i11 = iod2.intValue();
        }
        return ComparisonsKt__ComparisonsKt.a(valueOf, Integer.valueOf(i11));
    }
}
