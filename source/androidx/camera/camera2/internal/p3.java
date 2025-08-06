package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.workaround.ExtraSupportedSurfaceCombinationsContainer;
import androidx.camera.camera2.internal.compat.workaround.ResolutionCorrector;
import androidx.camera.camera2.internal.compat.workaround.TargetAspectRatio;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraMode;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.core.util.h;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.l0;
import o.y;

public final class p3 {

    /* renamed from: a  reason: collision with root package name */
    public final List<SurfaceCombination> f5252a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<SurfaceCombination> f5253b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final List<SurfaceCombination> f5254c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Map<b, List<SurfaceCombination>> f5255d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final List<SurfaceCombination> f5256e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<SurfaceCombination> f5257f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final String f5258g;

    /* renamed from: h  reason: collision with root package name */
    public final d f5259h;

    /* renamed from: i  reason: collision with root package name */
    public final y f5260i;

    /* renamed from: j  reason: collision with root package name */
    public final ExtraSupportedSurfaceCombinationsContainer f5261j;

    /* renamed from: k  reason: collision with root package name */
    public final int f5262k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f5263l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f5264m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5265n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f5266o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5267p;

    /* renamed from: q  reason: collision with root package name */
    public SurfaceSizeDefinition f5268q;

    /* renamed from: r  reason: collision with root package name */
    public List<Integer> f5269r;

    /* renamed from: s  reason: collision with root package name */
    public final g2 f5270s;

    /* renamed from: t  reason: collision with root package name */
    public final TargetAspectRatio f5271t;

    /* renamed from: u  reason: collision with root package name */
    public final ResolutionCorrector f5272u;

    /* renamed from: v  reason: collision with root package name */
    public final h2 f5273v;

    public static class a {
        public static Size[] a(StreamConfigurationMap streamConfigurationMap, int i11) {
            return streamConfigurationMap.getHighResolutionOutputSizes(i11);
        }
    }

    @AutoValue
    public static abstract class b {
        public static b c(int i11, int i12) {
            return new c(i11, i12);
        }

        public abstract int a();

        public abstract int b();
    }

    public p3(Context context, String str, l0 l0Var, d dVar) throws CameraUnavailableException {
        this.f5263l = false;
        this.f5264m = false;
        this.f5265n = false;
        this.f5266o = false;
        this.f5267p = false;
        this.f5269r = new ArrayList();
        this.f5271t = new TargetAspectRatio();
        this.f5272u = new ResolutionCorrector();
        String str2 = (String) h.g(str);
        this.f5258g = str2;
        this.f5259h = (d) h.g(dVar);
        this.f5261j = new ExtraSupportedSurfaceCombinationsContainer();
        this.f5270s = g2.c(context);
        try {
            y c11 = l0Var.c(str2);
            this.f5260i = c11;
            Integer num = (Integer) c11.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            this.f5262k = num != null ? num.intValue() : 2;
            int[] iArr = (int[]) c11.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i11 : iArr) {
                    if (i11 == 3) {
                        this.f5263l = true;
                    } else if (i11 == 6) {
                        this.f5264m = true;
                    } else if (Build.VERSION.SDK_INT >= 31 && i11 == 16) {
                        this.f5267p = true;
                    }
                }
            }
            h2 h2Var = new h2(this.f5260i);
            this.f5273v = h2Var;
            j();
            if (this.f5267p) {
                l();
            }
            boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
            this.f5265n = hasSystemFeature;
            if (hasSystemFeature) {
                h();
            }
            if (h2Var.d()) {
                g();
            }
            boolean h11 = o3.h(this.f5260i);
            this.f5266o = h11;
            if (h11) {
                i();
            }
            k();
            b();
        } catch (CameraAccessExceptionCompat e11) {
            throw v1.a(e11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Range<java.lang.Integer> d(android.util.Range<java.lang.Integer> r8, android.util.Range<java.lang.Integer> r9, android.util.Range<java.lang.Integer> r10) {
        /*
            android.util.Range r0 = r9.intersect(r8)
            int r0 = t(r0)
            double r0 = (double) r0
            android.util.Range r8 = r10.intersect(r8)
            int r8 = t(r8)
            double r2 = (double) r8
            int r8 = t(r10)
            double r4 = (double) r8
            double r4 = r2 / r4
            int r8 = t(r9)
            double r6 = (double) r8
            double r6 = r0 / r6
            int r8 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            r0 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            if (r8 <= 0) goto L_0x002f
            int r8 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x002e
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0058
        L_0x002e:
            return r10
        L_0x002f:
            if (r8 != 0) goto L_0x004f
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0036
            return r10
        L_0x0036:
            if (r8 != 0) goto L_0x0058
            java.lang.Comparable r8 = r10.getLower()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Comparable r0 = r9.getLower()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r8 <= r0) goto L_0x0058
            return r10
        L_0x004f:
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x0058
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0058
            return r10
        L_0x0058:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.p3.d(android.util.Range, android.util.Range, android.util.Range):android.util.Range");
    }

    public static int o(y yVar, int i11, Size size) {
        try {
            return (int) (1.0E9d / ((double) ((StreamConfigurationMap) yVar.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(i11, size)));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int s(Range<Integer> range, Range<Integer> range2) {
        h.j(!range.contains(range2.getUpper()) && !range.contains(range2.getLower()), "Ranges must not intersect");
        if (range.getLower().intValue() > range2.getUpper().intValue()) {
            return range.getLower().intValue() - range2.getUpper().intValue();
        }
        return range2.getLower().intValue() - range.getUpper().intValue();
    }

    public static int t(Range<Integer> range) {
        return (range.getUpper().intValue() - range.getLower().intValue()) + 1;
    }

    public static int x(Map<UseCaseConfig<?>, DynamicRange> map) {
        for (DynamicRange bitDepth : map.values()) {
            if (bitDepth.getBitDepth() == 10) {
                return 10;
            }
        }
        return 8;
    }

    public final Pair<List<SurfaceConfig>, Integer> A(int i11, List<AttachedSurfaceInfo> list, List<Size> list2, List<UseCaseConfig<?>> list3, List<Integer> list4, int i12, Map<Integer, AttachedSurfaceInfo> map, Map<Integer, UseCaseConfig<?>> map2) {
        ArrayList arrayList = new ArrayList();
        for (AttachedSurfaceInfo next : list) {
            arrayList.add(next.getSurfaceConfig());
            if (map != null) {
                map.put(Integer.valueOf(arrayList.size() - 1), next);
            }
        }
        for (int i13 = 0; i13 < list2.size(); i13++) {
            Size size = list2.get(i13);
            UseCaseConfig useCaseConfig = list3.get(list4.get(i13).intValue());
            int inputFormat = useCaseConfig.getInputFormat();
            arrayList.add(SurfaceConfig.transformSurfaceConfig(i11, inputFormat, size, D(inputFormat)));
            if (map2 != null) {
                map2.put(Integer.valueOf(arrayList.size() - 1), useCaseConfig);
            }
            i12 = C(i12, useCaseConfig.getInputFormat(), size);
        }
        return new Pair<>(arrayList, Integer.valueOf(i12));
    }

    public final Range<Integer> B(List<AttachedSurfaceInfo> list, List<UseCaseConfig<?>> list2, List<Integer> list3) {
        Range<Integer> range = null;
        for (AttachedSurfaceInfo targetFrameRate : list) {
            range = E(targetFrameRate.getTargetFrameRate(), range);
        }
        for (Integer intValue : list3) {
            range = E(list2.get(intValue.intValue()).getTargetFrameRate((Range<Integer>) null), range);
        }
        return range;
    }

    public final int C(int i11, int i12, Size size) {
        return Math.min(i11, o(this.f5260i, i12, size));
    }

    public SurfaceSizeDefinition D(int i11) {
        if (!this.f5269r.contains(Integer.valueOf(i11))) {
            K(this.f5268q.getS720pSizeMap(), SizeUtil.RESOLUTION_720P, i11);
            K(this.f5268q.getS1440pSizeMap(), SizeUtil.RESOLUTION_1440P, i11);
            J(this.f5268q.getMaximumSizeMap(), i11);
            L(this.f5268q.getUltraMaximumSizeMap(), i11);
            this.f5269r.add(Integer.valueOf(i11));
        }
        return this.f5268q;
    }

    public final Range<Integer> E(Range<Integer> range, Range<Integer> range2) {
        if (range2 == null) {
            return range;
        }
        if (range != null) {
            try {
                return range2.intersect(range);
            } catch (IllegalArgumentException unused) {
            }
        }
        return range2;
    }

    public final List<Integer> F(List<UseCaseConfig<?>> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (UseCaseConfig<?> surfaceOccupancyPriority : list) {
            int surfaceOccupancyPriority2 = surfaceOccupancyPriority.getSurfaceOccupancyPriority(0);
            if (!arrayList2.contains(Integer.valueOf(surfaceOccupancyPriority2))) {
                arrayList2.add(Integer.valueOf(surfaceOccupancyPriority2));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        for (Integer intValue : arrayList2) {
            int intValue2 = intValue.intValue();
            for (UseCaseConfig next : list) {
                if (intValue2 == next.getSurfaceOccupancyPriority(0)) {
                    arrayList.add(Integer.valueOf(list.indexOf(next)));
                }
            }
        }
        return arrayList;
    }

    public final boolean G(b bVar, List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, List<Size>> map) {
        ArrayList arrayList = new ArrayList();
        for (AttachedSurfaceInfo surfaceConfig : list) {
            arrayList.add(surfaceConfig.getSurfaceConfig());
        }
        CompareSizesByArea compareSizesByArea = new CompareSizesByArea();
        for (UseCaseConfig next : map.keySet()) {
            List list2 = map.get(next);
            boolean z11 = list2 != null && !list2.isEmpty();
            h.b(z11, "No available output size is found for " + next + InstructionFileId.DOT);
            int inputFormat = next.getInputFormat();
            arrayList.add(SurfaceConfig.transformSurfaceConfig(bVar.a(), inputFormat, (Size) Collections.min(list2, compareSizesByArea), D(inputFormat)));
        }
        return c(bVar, arrayList);
    }

    public final void H() {
        this.f5270s.g();
        if (this.f5268q == null) {
            k();
            return;
        }
        this.f5268q = SurfaceSizeDefinition.create(this.f5268q.getAnalysisSize(), this.f5268q.getS720pSizeMap(), this.f5270s.f(), this.f5268q.getS1440pSizeMap(), this.f5268q.getRecordSize(), this.f5268q.getMaximumSizeMap(), this.f5268q.getUltraMaximumSizeMap());
    }

    public SurfaceConfig I(int i11, int i12, Size size) {
        return SurfaceConfig.transformSurfaceConfig(i11, i12, size, D(i12));
    }

    public final void J(Map<Integer, Size> map, int i11) {
        Size p11 = p(this.f5260i.b().c(), i11, true);
        if (p11 != null) {
            map.put(Integer.valueOf(i11), p11);
        }
    }

    public final void K(Map<Integer, Size> map, Size size, int i11) {
        if (this.f5265n) {
            Size p11 = p(this.f5260i.b().c(), i11, false);
            Integer valueOf = Integer.valueOf(i11);
            if (p11 != null) {
                size = (Size) Collections.min(Arrays.asList(new Size[]{size, p11}), new CompareSizesByArea());
            }
            map.put(valueOf, size);
        }
    }

    public final void L(Map<Integer, Size> map, int i11) {
        StreamConfigurationMap streamConfigurationMap;
        if (Build.VERSION.SDK_INT >= 31 && this.f5267p && (streamConfigurationMap = (StreamConfigurationMap) this.f5260i.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION)) != null) {
            map.put(Integer.valueOf(i11), p(streamConfigurationMap, i11, true));
        }
    }

    public List<Size> a(List<Size> list, int i11) {
        int a11 = this.f5271t.a(this.f5258g, this.f5260i);
        Rational rational = null;
        if (a11 == 0) {
            rational = AspectRatioUtil.ASPECT_RATIO_4_3;
        } else if (a11 == 1) {
            rational = AspectRatioUtil.ASPECT_RATIO_16_9;
        } else if (a11 == 2) {
            Size maximumSize = D(256).getMaximumSize(256);
            rational = new Rational(maximumSize.getWidth(), maximumSize.getHeight());
        }
        if (rational != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Size next : list) {
                if (AspectRatioUtil.hasMatchingAspectRatio(next, rational)) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
            arrayList2.addAll(0, arrayList);
            list = arrayList2;
        }
        return this.f5272u.a(SurfaceConfig.getConfigType(i11), list);
    }

    public final void b() {
    }

    public boolean c(b bVar, List<SurfaceConfig> list) {
        boolean z11 = false;
        for (SurfaceCombination orderedSupportedSurfaceConfigList : z(bVar)) {
            if (orderedSupportedSurfaceConfigList.getOrderedSupportedSurfaceConfigList(list) != null) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        return z11;
    }

    public final b e(int i11, Map<UseCaseConfig<?>, DynamicRange> map) {
        int x11 = x(map);
        if (i11 == 0 || x11 != 10) {
            return b.c(i11, x11);
        }
        throw new IllegalArgumentException(String.format("Camera device id is %s. 10 bit dynamic range is not currently supported in %s camera mode.", new Object[]{this.f5258g, CameraMode.toLabelString(i11)}));
    }

    public final Map<UseCaseConfig<?>, List<Size>> f(Map<UseCaseConfig<?>, List<Size>> map, b bVar, Range<Integer> range) {
        HashMap hashMap = new HashMap();
        for (UseCaseConfig next : map.keySet()) {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap2 = new HashMap();
            for (Size size : map.get(next)) {
                int inputFormat = next.getInputFormat();
                SurfaceConfig.ConfigSize configSize = SurfaceConfig.transformSurfaceConfig(bVar.a(), inputFormat, size, D(inputFormat)).getConfigSize();
                int i11 = Integer.MAX_VALUE;
                if (range != null) {
                    i11 = o(this.f5260i, inputFormat, size);
                }
                Set set = (Set) hashMap2.get(configSize);
                if (set == null) {
                    set = new HashSet();
                    hashMap2.put(configSize, set);
                }
                if (!set.contains(Integer.valueOf(i11))) {
                    arrayList.add(size);
                    set.add(Integer.valueOf(i11));
                }
            }
            hashMap.put(next, arrayList);
        }
        return hashMap;
    }

    public final void g() {
        this.f5256e.addAll(z2.b());
    }

    public final void h() {
        this.f5254c.addAll(z2.d());
    }

    public final void i() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.f5257f.addAll(z2.j());
        }
    }

    public final void j() {
        this.f5252a.addAll(z2.a(this.f5262k, this.f5263l, this.f5264m));
        this.f5252a.addAll(this.f5261j.a(this.f5258g, this.f5262k));
    }

    public final void k() {
        this.f5268q = SurfaceSizeDefinition.create(SizeUtil.RESOLUTION_VGA, new HashMap(), this.f5270s.f(), new HashMap(), u(), new HashMap(), new HashMap());
    }

    public final void l() {
        this.f5253b.addAll(z2.k());
    }

    public final List<List<Size>> m(List<List<Size>> list) {
        int i11 = 1;
        for (List<Size> size : list) {
            i11 *= size.size();
        }
        if (i11 != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList.add(new ArrayList());
            }
            int size2 = i11 / list.get(0).size();
            int i13 = i11;
            for (int i14 = 0; i14 < list.size(); i14++) {
                List list2 = list.get(i14);
                for (int i15 = 0; i15 < i11; i15++) {
                    ((List) arrayList.get(i15)).add((Size) list2.get((i15 % i13) / size2));
                }
                if (i14 < list.size() - 1) {
                    i13 = size2;
                    size2 /= list.get(i14 + 1).size();
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("Failed to find supported resolutions.");
    }

    public final Range<Integer> n(Range<Integer> range, int i11) {
        if (range == null) {
            return StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        }
        Range<Integer>[] rangeArr = (Range[]) this.f5260i.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (rangeArr == null) {
            return StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        }
        Range range2 = new Range(Integer.valueOf(Math.min(range.getLower().intValue(), i11)), Integer.valueOf(Math.min(range.getUpper().intValue(), i11)));
        Range<Integer> range3 = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        int i12 = 0;
        for (Range<Integer> range4 : rangeArr) {
            if (i11 >= range4.getLower().intValue()) {
                if (range3.equals(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
                    range3 = range4;
                }
                if (range4.equals(range2)) {
                    return range4;
                }
                try {
                    int t11 = t(range4.intersect(range2));
                    if (i12 == 0) {
                        i12 = t11;
                    } else {
                        if (t11 >= i12) {
                            range3 = d(range2, range3, range4);
                            i12 = t(range2.intersect(range3));
                        }
                        range4 = range3;
                    }
                } catch (IllegalArgumentException unused) {
                    if (i12 == 0) {
                        if (s(range4, range2) >= s(range3, range2)) {
                            if (s(range4, range2) == s(range3, range2)) {
                                if (range4.getLower().intValue() <= range3.getUpper().intValue() && t(range4) >= t(range3)) {
                                }
                            }
                        }
                    }
                }
                range3 = range4;
            }
        }
        return range3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.util.Size} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Size p(android.hardware.camera2.params.StreamConfigurationMap r6, int r7, boolean r8) {
        /*
            r5 = this;
            r0 = 34
            if (r7 != r0) goto L_0x000b
            java.lang.Class<android.graphics.SurfaceTexture> r0 = android.graphics.SurfaceTexture.class
            android.util.Size[] r0 = r6.getOutputSizes(r0)
            goto L_0x000f
        L_0x000b:
            android.util.Size[] r0 = r6.getOutputSizes(r7)
        L_0x000f:
            if (r0 == 0) goto L_0x0056
            int r1 = r0.length
            if (r1 != 0) goto L_0x0015
            goto L_0x0056
        L_0x0015:
            androidx.camera.core.impl.utils.CompareSizesByArea r1 = new androidx.camera.core.impl.utils.CompareSizesByArea
            r1.<init>()
            java.util.List r0 = java.util.Arrays.asList(r0)
            java.lang.Object r0 = java.util.Collections.max(r0, r1)
            android.util.Size r0 = (android.util.Size) r0
            android.util.Size r2 = androidx.camera.core.internal.utils.SizeUtil.RESOLUTION_ZERO
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r3 < r4) goto L_0x0042
            if (r8 == 0) goto L_0x0042
            android.util.Size[] r6 = androidx.camera.camera2.internal.p3.a.a(r6, r7)
            if (r6 == 0) goto L_0x0042
            int r7 = r6.length
            if (r7 <= 0) goto L_0x0042
            java.util.List r6 = java.util.Arrays.asList(r6)
            java.lang.Object r6 = java.util.Collections.max(r6, r1)
            r2 = r6
            android.util.Size r2 = (android.util.Size) r2
        L_0x0042:
            r6 = 2
            android.util.Size[] r6 = new android.util.Size[r6]
            r7 = 0
            r6[r7] = r0
            r7 = 1
            r6[r7] = r2
            java.util.List r6 = java.util.Arrays.asList(r6)
            java.lang.Object r6 = java.util.Collections.max(r6, r1)
            android.util.Size r6 = (android.util.Size) r6
            return r6
        L_0x0056:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.p3.p(android.hardware.camera2.params.StreamConfigurationMap, int, boolean):android.util.Size");
    }

    public final int q(List<AttachedSurfaceInfo> list) {
        int i11 = Integer.MAX_VALUE;
        for (AttachedSurfaceInfo next : list) {
            i11 = C(i11, next.getImageFormat(), next.getSize());
        }
        return i11;
    }

    public List<SurfaceConfig> r(b bVar, List<SurfaceConfig> list) {
        if (!o3.n(bVar)) {
            return null;
        }
        for (SurfaceCombination orderedSupportedSurfaceConfigList : this.f5257f) {
            List<SurfaceConfig> orderedSupportedSurfaceConfigList2 = orderedSupportedSurfaceConfigList.getOrderedSupportedSurfaceConfigList(list);
            if (orderedSupportedSurfaceConfigList2 != null) {
                return orderedSupportedSurfaceConfigList2;
            }
        }
        return null;
    }

    public final Size u() {
        try {
            int parseInt = Integer.parseInt(this.f5258g);
            CamcorderProfile camcorderProfile = null;
            if (this.f5259h.b(parseInt, 1)) {
                camcorderProfile = this.f5259h.a(parseInt, 1);
            }
            if (camcorderProfile != null) {
                return new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            }
            return v(parseInt);
        } catch (NumberFormatException unused) {
            return w();
        }
    }

    public final Size v(int i11) {
        CamcorderProfile camcorderProfile;
        Size size = SizeUtil.RESOLUTION_480P;
        if (this.f5259h.b(i11, 10)) {
            camcorderProfile = this.f5259h.a(i11, 10);
        } else if (this.f5259h.b(i11, 8)) {
            camcorderProfile = this.f5259h.a(i11, 8);
        } else if (this.f5259h.b(i11, 12)) {
            camcorderProfile = this.f5259h.a(i11, 12);
        } else if (this.f5259h.b(i11, 6)) {
            camcorderProfile = this.f5259h.a(i11, 6);
        } else if (this.f5259h.b(i11, 5)) {
            camcorderProfile = this.f5259h.a(i11, 5);
        } else {
            camcorderProfile = this.f5259h.b(i11, 4) ? this.f5259h.a(i11, 4) : null;
        }
        return camcorderProfile != null ? new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight) : size;
    }

    public final Size w() {
        Size[] outputSizes = this.f5260i.b().c().getOutputSizes(MediaRecorder.class);
        if (outputSizes == null) {
            return SizeUtil.RESOLUTION_480P;
        }
        Arrays.sort(outputSizes, new CompareSizesByArea(true));
        for (Size size : outputSizes) {
            int width = size.getWidth();
            Size size2 = SizeUtil.RESOLUTION_1080P;
            if (width <= size2.getWidth() && size.getHeight() <= size2.getHeight()) {
                return size;
            }
        }
        return SizeUtil.RESOLUTION_480P;
    }

    public Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> y(int i11, List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, List<Size>> map) {
        List<Integer> list2;
        int i12;
        Range<Integer> range;
        HashMap hashMap;
        HashMap hashMap2;
        Map<UseCaseConfig<?>, DynamicRange> map2;
        String str;
        String str2;
        List<SurfaceConfig> list3;
        HashMap hashMap3;
        HashMap hashMap4;
        String str3;
        String str4;
        HashMap hashMap5;
        HashMap hashMap6;
        List list4;
        List list5;
        HashMap hashMap7;
        int i13;
        int i14;
        String str5;
        List<AttachedSurfaceInfo> list6 = list;
        Map<UseCaseConfig<?>, List<Size>> map3 = map;
        H();
        ArrayList arrayList = new ArrayList(map.keySet());
        List<Integer> F = F(arrayList);
        Map<UseCaseConfig<?>, DynamicRange> g11 = this.f5273v.g(list6, arrayList, F);
        b e11 = e(i11, g11);
        boolean G = G(e11, list6, map3);
        String str6 = ".  May be attempting to bind too many use cases. Existing surfaces: ";
        String str7 = " New configs: ";
        String str8 = "No supported surface combination is found for camera device - Id : ";
        if (G) {
            Range<Integer> B = B(list6, arrayList, F);
            Map<UseCaseConfig<?>, List<Size>> f11 = f(map3, e11, B);
            ArrayList arrayList2 = new ArrayList();
            for (Integer intValue : F) {
                UseCaseConfig useCaseConfig = (UseCaseConfig) arrayList.get(intValue.intValue());
                arrayList2.add(a(f11.get(useCaseConfig), useCaseConfig.getInputFormat()));
            }
            List<List<Size>> m11 = m(arrayList2);
            HashMap hashMap8 = new HashMap();
            HashMap hashMap9 = new HashMap();
            HashMap hashMap10 = new HashMap();
            HashMap hashMap11 = new HashMap();
            boolean d11 = o3.d(list6, arrayList);
            int q11 = q(list6);
            HashMap hashMap12 = hashMap11;
            Range<Integer> range2 = null;
            if (!this.f5266o || d11) {
                hashMap3 = hashMap10;
                hashMap2 = hashMap9;
                hashMap = hashMap8;
                range = B;
                list2 = F;
                map2 = g11;
                i12 = q11;
                str2 = str8;
                str = str7;
                hashMap4 = hashMap12;
                list3 = null;
            } else {
                Iterator<List<Size>> it2 = m11.iterator();
                List<SurfaceConfig> list7 = null;
                while (true) {
                    if (!it2.hasNext()) {
                        hashMap2 = hashMap9;
                        hashMap = hashMap8;
                        range = B;
                        list2 = F;
                        map2 = g11;
                        i12 = q11;
                        str2 = str8;
                        str = str7;
                        str5 = str6;
                        hashMap4 = hashMap12;
                        hashMap3 = hashMap10;
                        break;
                    }
                    HashMap hashMap13 = hashMap12;
                    HashMap hashMap14 = hashMap10;
                    hashMap2 = hashMap9;
                    hashMap = hashMap8;
                    map2 = g11;
                    range = B;
                    str2 = str8;
                    int i15 = q11;
                    i12 = q11;
                    str = str7;
                    list2 = F;
                    str5 = str6;
                    list7 = r(e11, (List) A(i11, list, it2.next(), arrayList, F, i15, hashMap14, hashMap13).first);
                    hashMap3 = hashMap14;
                    hashMap4 = hashMap13;
                    if (list7 != null && !o3.a(hashMap3, hashMap4, list7)) {
                        list7 = null;
                    }
                    if (list7 != null) {
                        if (o3.c(this.f5260i, list7)) {
                            break;
                        }
                        list7 = null;
                    }
                    hashMap3.clear();
                    hashMap4.clear();
                    hashMap12 = hashMap4;
                    hashMap10 = hashMap3;
                    str6 = str5;
                    str8 = str2;
                    str7 = str;
                    g11 = map2;
                    hashMap9 = hashMap2;
                    hashMap8 = hashMap;
                    B = range;
                    q11 = i12;
                    F = list2;
                }
                if (list7 != null || G) {
                    list3 = list7;
                } else {
                    throw new IllegalArgumentException(str2 + this.f5258g + str5 + list6 + str + arrayList);
                }
            }
            Iterator<List<Size>> it3 = m11.iterator();
            boolean z11 = false;
            int i16 = Integer.MAX_VALUE;
            int i17 = Integer.MAX_VALUE;
            boolean z12 = false;
            boolean z13 = false;
            List list8 = null;
            List list9 = null;
            while (true) {
                if (!it3.hasNext()) {
                    int i18 = i16;
                    int i19 = i17;
                    str3 = str2;
                    str4 = str;
                    hashMap5 = hashMap4;
                    hashMap6 = hashMap3;
                    list4 = list8;
                    list5 = list9;
                    break;
                }
                List next = it3.next();
                int i21 = i16;
                int i22 = i17;
                str4 = str;
                hashMap5 = hashMap4;
                str3 = str2;
                hashMap6 = hashMap3;
                Pair<List<SurfaceConfig>, Integer> A = A(i11, list, next, arrayList, list2, i12, (Map<Integer, AttachedSurfaceInfo>) null, (Map<Integer, UseCaseConfig<?>>) null);
                List list10 = (List) A.first;
                i17 = ((Integer) A.second).intValue();
                int i23 = i12;
                boolean z14 = range == null || i23 <= i17 || i17 >= range.getLower().intValue();
                if (z12 || !c(e11, list10)) {
                    i13 = i22;
                    i14 = Integer.MAX_VALUE;
                } else {
                    i13 = i22;
                    i14 = Integer.MAX_VALUE;
                    if (i13 == Integer.MAX_VALUE || i13 < i17) {
                        i13 = i17;
                        list8 = next;
                    }
                    if (z14) {
                        if (z13) {
                            list5 = list9;
                            list4 = next;
                            i16 = i21;
                            break;
                        }
                        i13 = i17;
                        z12 = true;
                        list8 = next;
                    }
                }
                if (list3 == null || z13 || r(e11, list10) == null) {
                    i16 = i21;
                } else {
                    int i24 = i21;
                    if (i24 != i14 && i24 >= i17) {
                        i16 = i24;
                    } else {
                        i16 = i17;
                        list9 = next;
                    }
                    if (z14) {
                        i16 = i17;
                        if (z12) {
                            i17 = i13;
                            list4 = list8;
                            list5 = next;
                            break;
                        }
                        z13 = true;
                        list9 = next;
                    } else {
                        continue;
                    }
                }
                i12 = i23;
                i17 = i13;
                hashMap3 = hashMap6;
                hashMap4 = hashMap5;
                str2 = str3;
                str = str4;
                int i25 = i14;
            }
            if (list4 != null) {
                if (range != null) {
                    range2 = n(range, i17);
                }
                Range<Integer> range3 = range2;
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    UseCaseConfig useCaseConfig2 = (UseCaseConfig) it4.next();
                    List<Integer> list11 = list2;
                    Map<UseCaseConfig<?>, DynamicRange> map4 = map2;
                    Iterator it5 = it4;
                    StreamSpec.Builder implementationOptions = StreamSpec.builder((Size) list4.get(list11.indexOf(Integer.valueOf(arrayList.indexOf(useCaseConfig2))))).setDynamicRange((DynamicRange) h.g(map4.get(useCaseConfig2))).setImplementationOptions(o3.e(useCaseConfig2));
                    if (range3 != null) {
                        implementationOptions.setExpectedFrameRateRange(range3);
                    }
                    hashMap2.put(useCaseConfig2, implementationOptions.build());
                    it4 = it5;
                    list2 = list11;
                    map2 = map4;
                }
                HashMap hashMap15 = hashMap2;
                if (list3 != null && i17 == i16 && list4.size() == list5.size()) {
                    int i26 = 0;
                    while (true) {
                        if (i26 >= list4.size()) {
                            break;
                        } else if (!((Size) list4.get(i26)).equals(list5.get(i26))) {
                            z11 = true;
                            break;
                        } else {
                            i26++;
                        }
                    }
                    if (!z11) {
                        hashMap7 = hashMap;
                        if (!o3.k(this.f5260i, list6, hashMap15, hashMap7)) {
                            o3.l(hashMap15, hashMap7, hashMap6, hashMap5, list3);
                        }
                        return new Pair<>(hashMap15, hashMap7);
                    }
                }
                hashMap7 = hashMap;
                return new Pair<>(hashMap15, hashMap7);
            }
            throw new IllegalArgumentException(str3 + this.f5258g + " and Hardware level: " + this.f5262k + ". May be the specified resolution is too large and not supported. Existing surfaces: " + list6 + str4 + arrayList);
        }
        throw new IllegalArgumentException(str8 + this.f5258g + str6 + list6 + str7 + arrayList);
    }

    public final List<SurfaceCombination> z(b bVar) {
        if (this.f5255d.containsKey(bVar)) {
            return this.f5255d.get(bVar);
        }
        List<SurfaceCombination> arrayList = new ArrayList<>();
        if (bVar.b() == 8) {
            int a11 = bVar.a();
            if (a11 == 1) {
                arrayList = this.f5254c;
            } else if (a11 != 2) {
                arrayList.addAll(this.f5252a);
            } else {
                arrayList.addAll(this.f5253b);
                arrayList.addAll(this.f5252a);
            }
        } else if (bVar.b() == 10 && bVar.a() == 0) {
            arrayList.addAll(this.f5256e);
        }
        this.f5255d.put(bVar, arrayList);
        return arrayList;
    }
}
