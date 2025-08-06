package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class z {
    static {
        int i11 = ImageOutputConfig.INVALID_ROTATION;
    }

    public static int a(ImageOutputConfig imageOutputConfig, int i11) {
        return ((Integer) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_APP_TARGET_ROTATION, Integer.valueOf(i11))).intValue();
    }

    public static List b(ImageOutputConfig imageOutputConfig) {
        List list = (List) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS);
        Objects.requireNonNull(list);
        return new ArrayList(list);
    }

    public static List c(ImageOutputConfig imageOutputConfig, List list) {
        List list2 = (List) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, list);
        if (list2 != null) {
            return new ArrayList(list2);
        }
        return null;
    }

    public static Size d(ImageOutputConfig imageOutputConfig) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION);
    }

    public static Size e(ImageOutputConfig imageOutputConfig, Size size) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
    }

    public static Size f(ImageOutputConfig imageOutputConfig) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION);
    }

    public static Size g(ImageOutputConfig imageOutputConfig, Size size) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
    }

    public static int h(ImageOutputConfig imageOutputConfig, int i11) {
        return ((Integer) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_MIRROR_MODE, Integer.valueOf(i11))).intValue();
    }

    public static ResolutionSelector i(ImageOutputConfig imageOutputConfig) {
        return (ResolutionSelector) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR);
    }

    public static ResolutionSelector j(ImageOutputConfig imageOutputConfig, ResolutionSelector resolutionSelector) {
        return (ResolutionSelector) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
    }

    public static List k(ImageOutputConfig imageOutputConfig) {
        return (List) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS);
    }

    public static List l(ImageOutputConfig imageOutputConfig, List list) {
        return (List) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
    }

    public static int m(ImageOutputConfig imageOutputConfig) {
        return ((Integer) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO)).intValue();
    }

    public static Size n(ImageOutputConfig imageOutputConfig) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION);
    }

    public static Size o(ImageOutputConfig imageOutputConfig, Size size) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
    }

    public static int p(ImageOutputConfig imageOutputConfig) {
        return ((Integer) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION)).intValue();
    }

    public static int q(ImageOutputConfig imageOutputConfig, int i11) {
        return ((Integer) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i11))).intValue();
    }

    public static boolean r(ImageOutputConfig imageOutputConfig) {
        return imageOutputConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
    }

    public static void s(ImageOutputConfig imageOutputConfig) {
        boolean hasTargetAspectRatio = imageOutputConfig.hasTargetAspectRatio();
        boolean z11 = imageOutputConfig.getTargetResolution((Size) null) != null;
        if (hasTargetAspectRatio && z11) {
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        } else if (imageOutputConfig.getResolutionSelector((ResolutionSelector) null) == null) {
        } else {
            if (hasTargetAspectRatio || z11) {
                throw new IllegalArgumentException("Cannot use setTargetResolution or setTargetAspectRatio with setResolutionSelector on the same config.");
            }
        }
    }
}
