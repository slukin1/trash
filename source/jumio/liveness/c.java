package jumio.liveness;

import com.jumio.core.extraction.ExtractionUpdateInterface;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.core.extraction.liveness.extraction.LivenessUpdateState;
import java.util.LinkedHashMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public b f56442a;

    /* renamed from: b  reason: collision with root package name */
    public Long f56443b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedHashMap f56444c = new LinkedHashMap();

    public final void a(ExtractionUpdateInterface<?> extractionUpdateInterface) {
        b bVar;
        Integer state = extractionUpdateInterface.getState();
        if (state != null) {
            int intValue = state.intValue();
            LivenessUpdateState livenessUpdateState = LivenessUpdateState.INSTANCE;
            if (intValue == livenessUpdateState.getCenterFace()) {
                bVar = b.CENTER_FACE;
            } else if (intValue == livenessUpdateState.getFaceTooClose()) {
                bVar = b.FACE_TOO_CLOSE;
            } else if (intValue == livenessUpdateState.getMoveFaceCloser()) {
                bVar = b.MOVE_FACE_CLOSER;
            } else if (intValue == livenessUpdateState.getLevelEyesAndDevice()) {
                bVar = b.LEVEL_EYES_AND_DEVICE;
            } else {
                bVar = intValue == ExtractionUpdateState.holdStill ? b.HOLD_STILL : null;
            }
            if (bVar != null) {
                a();
                this.f56442a = bVar;
            }
        }
    }

    public final void a() {
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this.f56442a;
        if (bVar != null) {
            Long l11 = (Long) this.f56444c.get(bVar);
            long longValue = l11 != null ? l11.longValue() : 0;
            Long l12 = this.f56443b;
            if (l12 != null) {
                this.f56444c.put(bVar, Long.valueOf((longValue + currentTimeMillis) - l12.longValue()));
            }
        }
        this.f56443b = Long.valueOf(currentTimeMillis);
    }
}
