package q;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.quirk.ProfileResolutionQuirk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import o.r0;
import o.y;

public class b implements ProfileResolutionQuirk {

    /* renamed from: a  reason: collision with root package name */
    public final r0 f16373a;

    /* renamed from: b  reason: collision with root package name */
    public List<Size> f16374b = null;

    public b(y yVar) {
        this.f16373a = yVar.b();
    }

    public static boolean c(y yVar) {
        Integer num = (Integer) yVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    public List<Size> getSupportedResolutions() {
        List<Size> list;
        if (this.f16374b == null) {
            Size[] b11 = this.f16373a.b(34);
            if (b11 != null) {
                list = Arrays.asList((Size[]) b11.clone());
            } else {
                list = Collections.emptyList();
            }
            this.f16374b = list;
            Logger.d("CamcorderProfileResolutionQuirk", "mSupportedResolutions = " + this.f16374b);
        }
        return new ArrayList(this.f16374b);
    }
}
