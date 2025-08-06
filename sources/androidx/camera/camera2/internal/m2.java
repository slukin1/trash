package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import android.util.Rational;
import androidx.camera.core.ExposureState;
import o.y;

public class m2 implements ExposureState {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5203a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final y f5204b;

    /* renamed from: c  reason: collision with root package name */
    public int f5205c;

    public m2(y yVar, int i11) {
        this.f5204b = yVar;
        this.f5205c = i11;
    }

    public void a(int i11) {
        synchronized (this.f5203a) {
            this.f5205c = i11;
        }
    }

    public int getExposureCompensationIndex() {
        int i11;
        synchronized (this.f5203a) {
            i11 = this.f5205c;
        }
        return i11;
    }

    public Range<Integer> getExposureCompensationRange() {
        return (Range) this.f5204b.a(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
    }

    public Rational getExposureCompensationStep() {
        if (!isExposureCompensationSupported()) {
            return Rational.ZERO;
        }
        return (Rational) this.f5204b.a(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
    }

    public boolean isExposureCompensationSupported() {
        Range range = (Range) this.f5204b.a(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        return (range == null || ((Integer) range.getLower()).intValue() == 0 || ((Integer) range.getUpper()).intValue() == 0) ? false : true;
    }
}
