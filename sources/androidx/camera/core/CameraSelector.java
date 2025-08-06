package androidx.camera.core;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LensFacingCameraFilter;
import androidx.core.util.h;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class CameraSelector {
    public static final CameraSelector DEFAULT_BACK_CAMERA = new Builder().requireLensFacing(1).build();
    public static final CameraSelector DEFAULT_FRONT_CAMERA = new Builder().requireLensFacing(0).build();
    public static final int LENS_FACING_BACK = 1;
    @ExperimentalLensFacing
    public static final int LENS_FACING_EXTERNAL = 2;
    public static final int LENS_FACING_FRONT = 0;
    public static final int LENS_FACING_UNKNOWN = -1;
    private LinkedHashSet<CameraFilter> mCameraFilterSet;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LensFacing {
    }

    public CameraSelector(LinkedHashSet<CameraFilter> linkedHashSet) {
        this.mCameraFilterSet = linkedHashSet;
    }

    public List<CameraInfo> filter(List<CameraInfo> list) {
        List<CameraInfo> arrayList = new ArrayList<>(list);
        Iterator it2 = this.mCameraFilterSet.iterator();
        while (it2.hasNext()) {
            arrayList = ((CameraFilter) it2.next()).filter(Collections.unmodifiableList(arrayList));
        }
        arrayList.retainAll(list);
        return arrayList;
    }

    public LinkedHashSet<CameraFilter> getCameraFilterSet() {
        return this.mCameraFilterSet;
    }

    public Integer getLensFacing() {
        Iterator it2 = this.mCameraFilterSet.iterator();
        Integer num = null;
        while (it2.hasNext()) {
            CameraFilter cameraFilter = (CameraFilter) it2.next();
            if (cameraFilter instanceof LensFacingCameraFilter) {
                Integer valueOf = Integer.valueOf(((LensFacingCameraFilter) cameraFilter).getLensFacing());
                if (num == null) {
                    num = valueOf;
                } else if (!num.equals(valueOf)) {
                    throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
                }
            }
        }
        return num;
    }

    public CameraInternal select(LinkedHashSet<CameraInternal> linkedHashSet) {
        Iterator it2 = filter(linkedHashSet).iterator();
        if (it2.hasNext()) {
            return (CameraInternal) it2.next();
        }
        throw new IllegalArgumentException("No available camera can be found");
    }

    public static final class Builder {
        private final LinkedHashSet<CameraFilter> mCameraFilterSet;

        public Builder() {
            this.mCameraFilterSet = new LinkedHashSet<>();
        }

        public static Builder fromSelector(CameraSelector cameraSelector) {
            return new Builder(cameraSelector.getCameraFilterSet());
        }

        public Builder addCameraFilter(CameraFilter cameraFilter) {
            this.mCameraFilterSet.add(cameraFilter);
            return this;
        }

        public CameraSelector build() {
            return new CameraSelector(this.mCameraFilterSet);
        }

        public Builder requireLensFacing(int i11) {
            h.j(i11 != -1, "The specified lens facing is invalid.");
            this.mCameraFilterSet.add(new LensFacingCameraFilter(i11));
            return this;
        }

        private Builder(LinkedHashSet<CameraFilter> linkedHashSet) {
            this.mCameraFilterSet = new LinkedHashSet<>(linkedHashSet);
        }
    }

    public LinkedHashSet<CameraInternal> filter(LinkedHashSet<CameraInternal> linkedHashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(((CameraInternal) it2.next()).getCameraInfo());
        }
        List<CameraInfo> filter = filter((List<CameraInfo>) arrayList);
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>();
        Iterator it3 = linkedHashSet.iterator();
        while (it3.hasNext()) {
            CameraInternal cameraInternal = (CameraInternal) it3.next();
            if (filter.contains(cameraInternal.getCameraInfo())) {
                linkedHashSet2.add(cameraInternal);
            }
        }
        return linkedHashSet2;
    }
}
