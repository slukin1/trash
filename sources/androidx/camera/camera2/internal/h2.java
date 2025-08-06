package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.text.TextUtils;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import o.y;
import p.b;

public final class h2 {

    /* renamed from: a  reason: collision with root package name */
    public final y f5138a;

    /* renamed from: b  reason: collision with root package name */
    public final b f5139b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5140c;

    public static final class a {
        public static DynamicRange a(y yVar) {
            Long l11 = (Long) yVar.a(CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE);
            if (l11 != null) {
                return p.a.b(l11.longValue());
            }
            return null;
        }
    }

    public h2(y yVar) {
        this.f5138a = yVar;
        this.f5139b = b.a(yVar);
        int[] iArr = (int[]) yVar.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        boolean z11 = false;
        if (iArr != null) {
            int length = iArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                } else if (iArr[i11] == 18) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
        }
        this.f5140c = z11;
    }

    public static boolean a(DynamicRange dynamicRange, DynamicRange dynamicRange2) {
        h.j(dynamicRange2.isFullySpecified(), "Fully specified range is not actually fully specified.");
        if (dynamicRange.getEncoding() == 2 && dynamicRange2.getEncoding() == 1) {
            return false;
        }
        if (dynamicRange.getEncoding() != 2 && dynamicRange.getEncoding() != 0 && dynamicRange.getEncoding() != dynamicRange2.getEncoding()) {
            return false;
        }
        if (dynamicRange.getBitDepth() == 0 || dynamicRange.getBitDepth() == dynamicRange2.getBitDepth()) {
            return true;
        }
        return false;
    }

    public static boolean b(DynamicRange dynamicRange, DynamicRange dynamicRange2, Set<DynamicRange> set) {
        if (set.contains(dynamicRange2)) {
            return a(dynamicRange, dynamicRange2);
        }
        Logger.d("DynamicRangeResolver", String.format("Candidate Dynamic range is not within constraints.\nDynamic range to resolve:\n  %s\nCandidate dynamic range:\n  %s", new Object[]{dynamicRange, dynamicRange2}));
        return false;
    }

    public static DynamicRange c(DynamicRange dynamicRange, Collection<DynamicRange> collection, Set<DynamicRange> set) {
        if (dynamicRange.getEncoding() == 1) {
            return null;
        }
        for (DynamicRange next : collection) {
            h.h(next, "Fully specified DynamicRange cannot be null.");
            int encoding = next.getEncoding();
            h.j(next.isFullySpecified(), "Fully specified DynamicRange must have fully defined encoding.");
            if (encoding != 1 && b(dynamicRange, next, set)) {
                return next;
            }
        }
        return null;
    }

    public static boolean e(DynamicRange dynamicRange) {
        return Objects.equals(dynamicRange, DynamicRange.UNSPECIFIED);
    }

    public static boolean f(DynamicRange dynamicRange) {
        return dynamicRange.getEncoding() == 2 || (dynamicRange.getEncoding() != 0 && dynamicRange.getBitDepth() == 0) || (dynamicRange.getEncoding() == 0 && dynamicRange.getBitDepth() != 0);
    }

    public static void j(Set<DynamicRange> set, DynamicRange dynamicRange, b bVar) {
        h.j(!set.isEmpty(), "Cannot update already-empty constraints.");
        Set<DynamicRange> b11 = bVar.b(dynamicRange);
        if (!b11.isEmpty()) {
            HashSet hashSet = new HashSet(set);
            set.retainAll(b11);
            if (set.isEmpty()) {
                throw new IllegalArgumentException(String.format("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  %s\nConstraints:\n  %s\nExisting constraints:\n  %s", new Object[]{dynamicRange, TextUtils.join("\n  ", b11), TextUtils.join("\n  ", hashSet)}));
            }
        }
    }

    public boolean d() {
        return this.f5140c;
    }

    public Map<UseCaseConfig<?>, DynamicRange> g(List<AttachedSurfaceInfo> list, List<UseCaseConfig<?>> list2, List<Integer> list3) {
        LinkedHashSet<DynamicRange> linkedHashSet = new LinkedHashSet<>();
        for (AttachedSurfaceInfo dynamicRange : list) {
            linkedHashSet.add(dynamicRange.getDynamicRange());
        }
        Set<DynamicRange> c11 = this.f5139b.c();
        HashSet hashSet = new HashSet(c11);
        for (DynamicRange j11 : linkedHashSet) {
            j(hashSet, j11, this.f5139b);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Integer intValue : list3) {
            UseCaseConfig useCaseConfig = list2.get(intValue.intValue());
            DynamicRange dynamicRange2 = useCaseConfig.getDynamicRange();
            if (e(dynamicRange2)) {
                arrayList3.add(useCaseConfig);
            } else if (f(dynamicRange2)) {
                arrayList2.add(useCaseConfig);
            } else {
                arrayList.add(useCaseConfig);
            }
        }
        HashMap hashMap = new HashMap();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList<UseCaseConfig> arrayList4 = new ArrayList<>();
        arrayList4.addAll(arrayList);
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        for (UseCaseConfig useCaseConfig2 : arrayList4) {
            DynamicRange i11 = i(c11, linkedHashSet, linkedHashSet2, useCaseConfig2, hashSet);
            hashMap.put(useCaseConfig2, i11);
            if (!linkedHashSet.contains(i11)) {
                linkedHashSet2.add(i11);
            }
        }
        return hashMap;
    }

    public final DynamicRange h(DynamicRange dynamicRange, Set<DynamicRange> set, Set<DynamicRange> set2, Set<DynamicRange> set3, String str) {
        DynamicRange dynamicRange2;
        if (!dynamicRange.isFullySpecified()) {
            int encoding = dynamicRange.getEncoding();
            int bitDepth = dynamicRange.getBitDepth();
            if (encoding == 1 && bitDepth == 0) {
                DynamicRange dynamicRange3 = DynamicRange.SDR;
                if (set.contains(dynamicRange3)) {
                    return dynamicRange3;
                }
                return null;
            }
            DynamicRange c11 = c(dynamicRange, set2, set);
            if (c11 != null) {
                Logger.d("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from existing attached surface.\n%s\n->\n%s", new Object[]{str, dynamicRange, c11}));
                return c11;
            }
            DynamicRange c12 = c(dynamicRange, set3, set);
            if (c12 != null) {
                Logger.d("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from concurrently bound use case.\n%s\n->\n%s", new Object[]{str, dynamicRange, c12}));
                return c12;
            }
            DynamicRange dynamicRange4 = DynamicRange.SDR;
            if (b(dynamicRange, dynamicRange4, set)) {
                Logger.d("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s to no compatible HDR dynamic ranges.\n%s\n->\n%s", new Object[]{str, dynamicRange, dynamicRange4}));
                return dynamicRange4;
            }
            if (encoding == 2 && (bitDepth == 10 || bitDepth == 0)) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (Build.VERSION.SDK_INT >= 33) {
                    dynamicRange2 = a.a(this.f5138a);
                    if (dynamicRange2 != null) {
                        linkedHashSet.add(dynamicRange2);
                    }
                } else {
                    dynamicRange2 = null;
                }
                linkedHashSet.add(DynamicRange.HLG_10_BIT);
                DynamicRange c13 = c(dynamicRange, linkedHashSet, set);
                if (c13 != null) {
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = c13.equals(dynamicRange2) ? "recommended" : "required";
                    objArr[2] = dynamicRange;
                    objArr[3] = c13;
                    Logger.d("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from %s 10-bit supported dynamic range.\n%s\n->\n%s", objArr));
                    return c13;
                }
            }
            for (DynamicRange next : set) {
                h.j(next.isFullySpecified(), "Candidate dynamic range must be fully specified.");
                if (!next.equals(DynamicRange.SDR) && a(dynamicRange, next)) {
                    Logger.d("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from validated dynamic range constraints or supported HDR dynamic ranges.\n%s\n->\n%s", new Object[]{str, dynamicRange, next}));
                    return next;
                }
            }
            return null;
        } else if (set.contains(dynamicRange)) {
            return dynamicRange;
        } else {
            return null;
        }
    }

    public final DynamicRange i(Set<DynamicRange> set, Set<DynamicRange> set2, Set<DynamicRange> set3, UseCaseConfig<?> useCaseConfig, Set<DynamicRange> set4) {
        DynamicRange dynamicRange = useCaseConfig.getDynamicRange();
        DynamicRange h11 = h(dynamicRange, set4, set2, set3, useCaseConfig.getTargetName());
        if (h11 != null) {
            j(set4, h11, this.f5139b);
            return h11;
        }
        throw new IllegalArgumentException(String.format("Unable to resolve supported dynamic range. The dynamic range may not be supported on the device or may not be allowed concurrently with other attached use cases.\nUse case:\n  %s\nRequested dynamic range:\n  %s\nSupported dynamic ranges:\n  %s\nConstrained set of concurrent dynamic ranges:\n  %s", new Object[]{useCaseConfig.getTargetName(), dynamicRange, TextUtils.join("\n  ", set), TextUtils.join("\n  ", set4)}));
    }
}
