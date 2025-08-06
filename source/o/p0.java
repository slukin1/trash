package o;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.Set;

public class p0 extends o0 {
    public p0(Context context) {
        super(context);
    }

    public Set<Set<String>> d() throws CameraAccessExceptionCompat {
        try {
            return this.f16202a.getConcurrentCameraIds();
        } catch (CameraAccessException e11) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e11);
        }
    }
}
