package r;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.core.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import q.d;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f16425a;

    /* renamed from: b  reason: collision with root package name */
    public final ExtraSupportedOutputSizeQuirk f16426b = ((ExtraSupportedOutputSizeQuirk) d.a(ExtraSupportedOutputSizeQuirk.class));

    /* renamed from: c  reason: collision with root package name */
    public final d f16427c;

    public i(String str) {
        this.f16425a = str;
        this.f16427c = new d(str);
    }

    public final void a(List<Size> list, int i11) {
        ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = this.f16426b;
        if (extraSupportedOutputSizeQuirk != null) {
            Size[] c11 = extraSupportedOutputSizeQuirk.c(i11);
            if (c11.length > 0) {
                list.addAll(Arrays.asList(c11));
            }
        }
    }

    public Size[] b(Size[] sizeArr, int i11) {
        ArrayList arrayList = new ArrayList(Arrays.asList(sizeArr));
        a(arrayList, i11);
        c(arrayList, i11);
        if (arrayList.isEmpty()) {
            Logger.w("OutputSizesCorrector", "Sizes array becomes empty after excluding problematic output sizes.");
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }

    public final void c(List<Size> list, int i11) {
        List<Size> a11 = this.f16427c.a(i11);
        if (!a11.isEmpty()) {
            list.removeAll(a11);
        }
    }
}
