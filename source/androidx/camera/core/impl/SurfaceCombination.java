package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class SurfaceCombination {
    private final List<SurfaceConfig> mSurfaceConfigList = new ArrayList();

    private static void generateArrangements(List<int[]> list, int i11, int[] iArr, int i12) {
        boolean z11;
        if (i12 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = 0;
            while (true) {
                if (i14 >= i12) {
                    z11 = false;
                    break;
                } else if (i13 == iArr[i14]) {
                    z11 = true;
                    break;
                } else {
                    i14++;
                }
            }
            if (!z11) {
                iArr[i12] = i13;
                generateArrangements(list, i11, iArr, i12 + 1);
            }
        }
    }

    private List<int[]> getElementsArrangements(int i11) {
        ArrayList arrayList = new ArrayList();
        generateArrangements(arrayList, i11, new int[i11], 0);
        return arrayList;
    }

    public boolean addSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.add(surfaceConfig);
    }

    public List<SurfaceConfig> getOrderedSupportedSurfaceConfigList(List<SurfaceConfig> list) {
        int i11;
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list.size() != this.mSurfaceConfigList.size()) {
            return null;
        }
        List<int[]> elementsArrangements = getElementsArrangements(this.mSurfaceConfigList.size());
        SurfaceConfig[] surfaceConfigArr = new SurfaceConfig[list.size()];
        Iterator<int[]> it2 = elementsArrangements.iterator();
        while (true) {
            i11 = 0;
            if (!it2.hasNext()) {
                break;
            }
            int[] next = it2.next();
            boolean z11 = true;
            while (i11 < this.mSurfaceConfigList.size()) {
                if (next[i11] < list.size()) {
                    z11 &= this.mSurfaceConfigList.get(i11).isSupported(list.get(next[i11]));
                    if (!z11) {
                        continue;
                        break;
                    }
                    surfaceConfigArr[next[i11]] = this.mSurfaceConfigList.get(i11);
                }
                i11++;
            }
            if (z11) {
                i11 = 1;
                break;
            }
        }
        if (i11 != 0) {
            return Arrays.asList(surfaceConfigArr);
        }
        return null;
    }

    public List<SurfaceConfig> getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    public boolean removeSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.remove(surfaceConfig);
    }
}
