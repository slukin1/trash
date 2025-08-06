package androidx.camera.core.processing;

import androidx.core.util.h;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class TargetUtils {
    private TargetUtils() {
    }

    public static void checkSupportedTargets(Collection<Integer> collection, int i11) {
        h.b(collection.contains(Integer.valueOf(i11)), String.format(Locale.US, "Effects target %s is not in the supported list %s.", new Object[]{getHumanReadableName(i11), getHumanReadableNames(collection)}));
    }

    public static String getHumanReadableName(int i11) {
        ArrayList arrayList = new ArrayList();
        if ((i11 & 4) != 0) {
            arrayList.add("IMAGE_CAPTURE");
        }
        if ((i11 & 1) != 0) {
            arrayList.add("PREVIEW");
        }
        if ((i11 & 2) != 0) {
            arrayList.add("VIDEO_CAPTURE");
        }
        return j0.a(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, arrayList);
    }

    private static String getHumanReadableNames(Collection<Integer> collection) {
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : collection) {
            arrayList.add(getHumanReadableName(intValue.intValue()));
        }
        return "[" + j0.a(", ", arrayList) + "]";
    }

    public static int getNumberOfTargets(int i11) {
        int i12 = 0;
        while (i11 != 0) {
            i12 += i11 & 1;
            i11 >>= 1;
        }
        return i12;
    }

    public static boolean isSuperset(int i11, int i12) {
        return (i11 & i12) == i12;
    }
}
