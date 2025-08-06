package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.e;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.List;

public class LensFacingCameraFilter implements CameraFilter {
    private final int mLensFacing;

    public LensFacingCameraFilter(int i11) {
        this.mLensFacing = i11;
    }

    public List<CameraInfo> filter(List<CameraInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (CameraInfo next : list) {
            h.b(next instanceof CameraInfoInternal, "The camera info doesn't contain internal implementation.");
            if (next.getLensFacing() == this.mLensFacing) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public /* synthetic */ Identifier getIdentifier() {
        return e.a(this);
    }

    public int getLensFacing() {
        return this.mLensFacing;
    }
}
