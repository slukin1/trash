package androidx.camera.core.streamsharing;

import android.util.Size;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.List;
import java.util.Set;

class ResolutionUtils {
    private ResolutionUtils() {
    }

    public static List<Size> getMergedResolutions(List<Size> list, Size size, Set<UseCaseConfig<?>> set) {
        for (UseCaseConfig<?> retrieveOption : set) {
            List<Size> list2 = (List) retrieveOption.retrieveOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, null);
            if (list2 != null) {
                return list2;
            }
        }
        return list;
    }
}
