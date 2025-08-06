package q;

import androidx.camera.camera2.internal.compat.quirk.AfRegionFlipHorizontallyQuirk;
import androidx.camera.camera2.internal.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.internal.compat.quirk.CameraNoResponseWhenEnablingFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.FlashTooSlowQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFlashNotFireQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureWashedOutImageQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureWithFlashUnderexposureQuirk;
import androidx.camera.camera2.internal.compat.quirk.JpegHalCorruptImageQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.YuvImageOnePixelShiftQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.ArrayList;
import o.y;

public class c {
    public static Quirks a(String str, y yVar) {
        ArrayList arrayList = new ArrayList();
        if (a.e(yVar)) {
            arrayList.add(new a(yVar));
        }
        if (AspectRatioLegacyApi21Quirk.d(yVar)) {
            arrayList.add(new AspectRatioLegacyApi21Quirk());
        }
        if (JpegHalCorruptImageQuirk.c(yVar)) {
            arrayList.add(new JpegHalCorruptImageQuirk());
        }
        if (b.c(yVar)) {
            arrayList.add(new b(yVar));
        }
        if (ImageCaptureWashedOutImageQuirk.c(yVar)) {
            arrayList.add(new ImageCaptureWashedOutImageQuirk());
        }
        if (CameraNoResponseWhenEnablingFlashQuirk.c(yVar)) {
            arrayList.add(new CameraNoResponseWhenEnablingFlashQuirk());
        }
        if (YuvImageOnePixelShiftQuirk.f(yVar)) {
            arrayList.add(new YuvImageOnePixelShiftQuirk());
        }
        if (FlashTooSlowQuirk.d(yVar)) {
            arrayList.add(new FlashTooSlowQuirk());
        }
        if (AfRegionFlipHorizontallyQuirk.c(yVar)) {
            arrayList.add(new AfRegionFlipHorizontallyQuirk());
        }
        if (ConfigureSurfaceToSecondarySessionFailQuirk.c(yVar)) {
            arrayList.add(new ConfigureSurfaceToSecondarySessionFailQuirk());
        }
        if (PreviewOrientationIncorrectQuirk.c(yVar)) {
            arrayList.add(new PreviewOrientationIncorrectQuirk());
        }
        if (CaptureSessionStuckQuirk.c(yVar)) {
            arrayList.add(new CaptureSessionStuckQuirk());
        }
        if (ImageCaptureFlashNotFireQuirk.c(yVar)) {
            arrayList.add(new ImageCaptureFlashNotFireQuirk());
        }
        if (ImageCaptureWithFlashUnderexposureQuirk.c(yVar)) {
            arrayList.add(new ImageCaptureWithFlashUnderexposureQuirk());
        }
        if (ImageCaptureFailWithAutoFlashQuirk.c(yVar)) {
            arrayList.add(new ImageCaptureFailWithAutoFlashQuirk());
        }
        return new Quirks(arrayList);
    }
}
