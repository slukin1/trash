package q;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.camera.core.impl.Quirk;
import o.y;

public class a implements Quirk {

    /* renamed from: a  reason: collision with root package name */
    public final Range<Integer> f16372a;

    public a(y yVar) {
        this.f16372a = f((Range[]) yVar.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    public static boolean e(y yVar) {
        Integer num = (Integer) yVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    public final Range<Integer> c(Range<Integer> range) {
        int intValue = range.getUpper().intValue();
        int intValue2 = range.getLower().intValue();
        if (range.getUpper().intValue() >= 1000) {
            intValue = range.getUpper().intValue() / 1000;
        }
        if (range.getLower().intValue() >= 1000) {
            intValue2 = range.getLower().intValue() / 1000;
        }
        return new Range<>(Integer.valueOf(intValue2), Integer.valueOf(intValue));
    }

    public Range<Integer> d() {
        return this.f16372a;
    }

    public final Range<Integer> f(Range<Integer>[] rangeArr) {
        Range<Integer> range = null;
        if (!(rangeArr == null || rangeArr.length == 0)) {
            for (Range<Integer> c11 : rangeArr) {
                Range<Integer> c12 = c(c11);
                if (c12.getUpper().intValue() == 30 && (range == null || c12.getLower().intValue() < range.getLower().intValue())) {
                    range = c12;
                }
            }
        }
        return range;
    }
}
