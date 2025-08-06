package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.RepeatingStreamConstraintForVideoRecordingQuirk;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import java.util.ArrayList;
import java.util.Comparator;
import q.d;

public class SupportedRepeatingSurfaceSize {

    /* renamed from: b  reason: collision with root package name */
    public static final Size f5071b = new Size(320, 240);

    /* renamed from: c  reason: collision with root package name */
    public static final Comparator<Size> f5072c = new CompareSizesByArea();

    /* renamed from: a  reason: collision with root package name */
    public final RepeatingStreamConstraintForVideoRecordingQuirk f5073a = ((RepeatingStreamConstraintForVideoRecordingQuirk) d.a(RepeatingStreamConstraintForVideoRecordingQuirk.class));

    public Size[] a(Size[] sizeArr) {
        if (this.f5073a == null || !RepeatingStreamConstraintForVideoRecordingQuirk.c()) {
            return sizeArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : sizeArr) {
            if (f5072c.compare(size, f5071b) >= 0) {
                arrayList.add(size);
            }
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }
}
