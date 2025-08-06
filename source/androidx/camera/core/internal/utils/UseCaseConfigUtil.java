package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.CameraOrientationUtil;

public final class UseCaseConfigUtil {
    private UseCaseConfigUtil() {
    }

    public static void updateTargetRotationAndRelatedConfigs(UseCaseConfig.Builder<?, ?, ?> builder, int i11) {
        Size targetResolution;
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) builder.getUseCaseConfig();
        int targetRotation = imageOutputConfig.getTargetRotation(-1);
        if (targetRotation == -1 || targetRotation != i11) {
            ((ImageOutputConfig.Builder) builder).setTargetRotation(i11);
        }
        if (targetRotation != -1 && i11 != -1 && targetRotation != i11) {
            if (Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(i11) - CameraOrientationUtil.surfaceRotationToDegrees(targetRotation)) % 180 == 90 && (targetResolution = imageOutputConfig.getTargetResolution((Size) null)) != null) {
                ((ImageOutputConfig.Builder) builder).setTargetResolution(new Size(targetResolution.getHeight(), targetResolution.getWidth()));
            }
        }
    }
}
