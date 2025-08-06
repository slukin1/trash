package s;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.l0;
import t.g;

public class b implements CameraCoordinator {

    /* renamed from: a  reason: collision with root package name */
    public final l0 f16451a;

    /* renamed from: b  reason: collision with root package name */
    public final List<CameraCoordinator.ConcurrentCameraModeListener> f16452b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, List<String>> f16453c;

    /* renamed from: d  reason: collision with root package name */
    public List<CameraInfo> f16454d;

    /* renamed from: e  reason: collision with root package name */
    public Set<Set<String>> f16455e;

    /* renamed from: f  reason: collision with root package name */
    public int f16456f = 0;

    public b(l0 l0Var) {
        this.f16451a = l0Var;
        this.f16453c = new HashMap();
        this.f16455e = new HashSet();
        this.f16452b = new ArrayList();
        this.f16454d = new ArrayList();
        d();
    }

    public static CameraSelector b(l0 l0Var, String str) {
        CameraSelector.Builder addCameraFilter = new CameraSelector.Builder().addCameraFilter(new a(str));
        try {
            addCameraFilter.requireLensFacing(((Integer) l0Var.c(str).a(CameraCharacteristics.LENS_FACING)).intValue());
            return addCameraFilter.build();
        } catch (CameraAccessExceptionCompat e11) {
            throw new RuntimeException(e11);
        }
    }

    public static /* synthetic */ List c(String str, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            CameraInfo cameraInfo = (CameraInfo) it2.next();
            if (str.equals(g.a(cameraInfo).b())) {
                return Collections.singletonList(cameraInfo);
            }
        }
        throw new IllegalArgumentException("No camera can be find for id: " + str);
    }

    public void addListener(CameraCoordinator.ConcurrentCameraModeListener concurrentCameraModeListener) {
        this.f16452b.add(concurrentCameraModeListener);
    }

    public final void d() {
        try {
            this.f16455e = this.f16451a.e();
        } catch (CameraAccessExceptionCompat unused) {
            Logger.e("Camera2CameraCoordinator", "Failed to get concurrent camera ids");
        }
        for (Set<String> arrayList : this.f16455e) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            if (arrayList2.size() >= 2) {
                String str = (String) arrayList2.get(0);
                String str2 = (String) arrayList2.get(1);
                if (!this.f16453c.containsKey(str)) {
                    this.f16453c.put(str, new ArrayList());
                }
                if (!this.f16453c.containsKey(str2)) {
                    this.f16453c.put(str2, new ArrayList());
                }
                this.f16453c.get(str).add((String) arrayList2.get(1));
                this.f16453c.get(str2).add((String) arrayList2.get(0));
            }
        }
    }

    public List<CameraInfo> getActiveConcurrentCameraInfos() {
        return this.f16454d;
    }

    public int getCameraOperatingMode() {
        return this.f16456f;
    }

    public List<List<CameraSelector>> getConcurrentCameraSelectors() {
        ArrayList arrayList = new ArrayList();
        for (Set<String> it2 : this.f16455e) {
            ArrayList arrayList2 = new ArrayList();
            for (String b11 : it2) {
                arrayList2.add(b(this.f16451a, b11));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public String getPairedConcurrentCameraId(String str) {
        if (!this.f16453c.containsKey(str)) {
            return null;
        }
        for (String str2 : this.f16453c.get(str)) {
            Iterator<CameraInfo> it2 = this.f16454d.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (str2.equals(g.a(it2.next()).b())) {
                        return str2;
                    }
                }
            }
        }
        return null;
    }

    public void removeListener(CameraCoordinator.ConcurrentCameraModeListener concurrentCameraModeListener) {
        this.f16452b.remove(concurrentCameraModeListener);
    }

    public void setActiveConcurrentCameraInfos(List<CameraInfo> list) {
        this.f16454d = new ArrayList(list);
    }

    public void setCameraOperatingMode(int i11) {
        if (i11 != this.f16456f) {
            for (CameraCoordinator.ConcurrentCameraModeListener onCameraOperatingModeUpdated : this.f16452b) {
                onCameraOperatingModeUpdated.onCameraOperatingModeUpdated(this.f16456f, i11);
            }
        }
        if (this.f16456f == 2 && i11 != 2) {
            this.f16454d.clear();
        }
        this.f16456f = i11;
    }

    public void shutdown() {
        this.f16452b.clear();
        this.f16453c.clear();
        this.f16454d.clear();
        this.f16455e.clear();
        this.f16456f = 0;
    }
}
