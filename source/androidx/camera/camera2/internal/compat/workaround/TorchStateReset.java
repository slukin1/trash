package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.List;
import q.d;

public class TorchStateReset {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5074a;

    public TorchStateReset() {
        this.f5074a = d.a(TorchIsClosedAfterImageCapturingQuirk.class) != null;
    }

    public CaptureConfig a(CaptureConfig captureConfig) {
        CaptureConfig.Builder builder = new CaptureConfig.Builder();
        builder.setTemplateType(captureConfig.getTemplateType());
        for (DeferrableSurface addSurface : captureConfig.getSurfaces()) {
            builder.addSurface(addSurface);
        }
        builder.addImplementationOptions(captureConfig.getImplementationOptions());
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.c(CaptureRequest.FLASH_MODE, 0);
        builder.addImplementationOptions(builder2.build());
        return builder.build();
    }

    public boolean b(List<CaptureRequest> list, boolean z11) {
        if (!this.f5074a || !z11) {
            return false;
        }
        for (CaptureRequest captureRequest : list) {
            Integer num = (Integer) captureRequest.get(CaptureRequest.FLASH_MODE);
            if (num != null && num.intValue() == 2) {
                return true;
            }
        }
        return false;
    }
}
