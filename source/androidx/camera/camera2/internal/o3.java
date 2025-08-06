package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.p3;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.streamsharing.StreamSharingConfig;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.y;

public final class o3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Config.Option<Long> f5243a = Config.Option.create("camera2.streamSpec.streamUseCase", Long.TYPE);

    /* renamed from: b  reason: collision with root package name */
    public static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> f5244b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> f5245c;

    static {
        HashMap hashMap = new HashMap();
        f5244b = hashMap;
        HashMap hashMap2 = new HashMap();
        f5245c = hashMap2;
        if (Build.VERSION.SDK_INT >= 33) {
            HashSet hashSet = new HashSet();
            UseCaseConfigFactory.CaptureType captureType = UseCaseConfigFactory.CaptureType.PREVIEW;
            hashSet.add(captureType);
            hashMap.put(4L, hashSet);
            HashSet hashSet2 = new HashSet();
            hashSet2.add(captureType);
            hashSet2.add(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS);
            hashMap.put(1L, hashSet2);
            HashSet hashSet3 = new HashSet();
            UseCaseConfigFactory.CaptureType captureType2 = UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE;
            hashSet3.add(captureType2);
            hashMap.put(2L, hashSet3);
            HashSet hashSet4 = new HashSet();
            UseCaseConfigFactory.CaptureType captureType3 = UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
            hashSet4.add(captureType3);
            hashMap.put(3L, hashSet4);
            HashSet hashSet5 = new HashSet();
            hashSet5.add(captureType);
            hashSet5.add(captureType2);
            hashSet5.add(captureType3);
            hashMap2.put(4L, hashSet5);
            HashSet hashSet6 = new HashSet();
            hashSet6.add(captureType);
            hashSet6.add(captureType3);
            hashMap2.put(3L, hashSet6);
        }
    }

    public static boolean a(Map<Integer, AttachedSurfaceInfo> map, Map<Integer, UseCaseConfig<?>> map2, List<SurfaceConfig> list) {
        List<UseCaseConfigFactory.CaptureType> list2;
        UseCaseConfigFactory.CaptureType captureType;
        for (int i11 = 0; i11 < list.size(); i11++) {
            long streamUseCase = list.get(i11).getStreamUseCase();
            if (map.containsKey(Integer.valueOf(i11))) {
                AttachedSurfaceInfo attachedSurfaceInfo = map.get(Integer.valueOf(i11));
                if (attachedSurfaceInfo.getCaptureTypes().size() == 1) {
                    captureType = attachedSurfaceInfo.getCaptureTypes().get(0);
                } else {
                    captureType = UseCaseConfigFactory.CaptureType.STREAM_SHARING;
                }
                if (!g(captureType, streamUseCase, attachedSurfaceInfo.getCaptureTypes())) {
                    return false;
                }
            } else if (map2.containsKey(Integer.valueOf(i11))) {
                UseCaseConfig useCaseConfig = map2.get(Integer.valueOf(i11));
                UseCaseConfigFactory.CaptureType captureType2 = useCaseConfig.getCaptureType();
                if (useCaseConfig.getCaptureType() == UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
                    list2 = ((StreamSharingConfig) useCaseConfig).getCaptureTypes();
                } else {
                    list2 = Collections.emptyList();
                }
                if (!g(captureType2, streamUseCase, list2)) {
                    return false;
                }
            } else {
                throw new AssertionError("SurfaceConfig does not map to any use case");
            }
        }
        return true;
    }

    public static boolean b(Set<Long> set, Set<Long> set2) {
        for (Long contains : set2) {
            if (!set.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(y yVar, List<SurfaceConfig> list) {
        long[] jArr;
        if (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) yVar.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (long valueOf : jArr) {
            hashSet.add(Long.valueOf(valueOf));
        }
        for (SurfaceConfig streamUseCase : list) {
            if (!hashSet.contains(Long.valueOf(streamUseCase.getStreamUseCase()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(List<AttachedSurfaceInfo> list, List<UseCaseConfig<?>> list2) {
        for (AttachedSurfaceInfo next : list) {
            if (j(next.getImplementationOptions(), next.getCaptureTypes().get(0))) {
                return true;
            }
        }
        for (UseCaseConfig next2 : list2) {
            if (j(next2, next2.getCaptureType())) {
                return true;
            }
        }
        return false;
    }

    public static Camera2ImplConfig e(UseCaseConfig<?> useCaseConfig) {
        MutableOptionsBundle create = MutableOptionsBundle.create();
        Config.Option<Long> option = Camera2ImplConfig.f4891c;
        if (useCaseConfig.containsOption(option)) {
            create.insertOption(option, (Long) useCaseConfig.retrieveOption(option));
        }
        Config.Option<Boolean> option2 = UseCaseConfig.OPTION_ZSL_DISABLED;
        if (useCaseConfig.containsOption(option2)) {
            create.insertOption(option2, (Boolean) useCaseConfig.retrieveOption(option2));
        }
        Config.Option<Integer> option3 = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        if (useCaseConfig.containsOption(option3)) {
            create.insertOption(option3, (Integer) useCaseConfig.retrieveOption(option3));
        }
        Config.Option<Integer> option4 = ImageInputConfig.OPTION_INPUT_FORMAT;
        if (useCaseConfig.containsOption(option4)) {
            create.insertOption(option4, (Integer) useCaseConfig.retrieveOption(option4));
        }
        return new Camera2ImplConfig(create);
    }

    public static Config f(Config config, long j11) {
        Config.Option<Long> option = f5243a;
        if (config.containsOption(option) && ((Long) config.retrieveOption(option)).longValue() == j11) {
            return null;
        }
        MutableOptionsBundle from = MutableOptionsBundle.from(config);
        from.insertOption(option, Long.valueOf(j11));
        return new Camera2ImplConfig(from);
    }

    public static boolean g(UseCaseConfigFactory.CaptureType captureType, long j11, List<UseCaseConfigFactory.CaptureType> list) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        if (captureType == UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
            Map<Long, Set<UseCaseConfigFactory.CaptureType>> map = f5245c;
            if (!map.containsKey(Long.valueOf(j11))) {
                return false;
            }
            Set set = map.get(Long.valueOf(j11));
            if (list.size() != set.size()) {
                return false;
            }
            for (UseCaseConfigFactory.CaptureType contains : list) {
                if (!set.contains(contains)) {
                    return false;
                }
            }
            return true;
        }
        Map<Long, Set<UseCaseConfigFactory.CaptureType>> map2 = f5244b;
        if (!map2.containsKey(Long.valueOf(j11)) || !map2.get(Long.valueOf(j11)).contains(captureType)) {
            return false;
        }
        return true;
    }

    public static boolean h(y yVar) {
        long[] jArr;
        if (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) yVar.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) {
            return false;
        }
        return true;
    }

    public static boolean i(List<AttachedSurfaceInfo> list, List<UseCaseConfig<?>> list2, Set<Long> set) {
        boolean z11;
        boolean z12;
        HashSet hashSet = new HashSet();
        Iterator<AttachedSurfaceInfo> it2 = list.iterator();
        if (it2.hasNext()) {
            AttachedSurfaceInfo next = it2.next();
            Config implementationOptions = next.getImplementationOptions();
            Config.Option<Long> option = Camera2ImplConfig.f4891c;
            if (implementationOptions.containsOption(option) && ((Long) next.getImplementationOptions().retrieveOption(option)).longValue() != 0) {
                z12 = false;
                z11 = true;
            } else {
                z11 = false;
                z12 = true;
            }
        } else {
            z11 = false;
            z12 = false;
        }
        for (UseCaseConfig next2 : list2) {
            Config.Option<Long> option2 = Camera2ImplConfig.f4891c;
            if (next2.containsOption(option2)) {
                long longValue = ((Long) next2.retrieveOption(option2)).longValue();
                if (longValue != 0) {
                    if (z12) {
                        o();
                    }
                    hashSet.add(Long.valueOf(longValue));
                    z11 = true;
                } else if (z11) {
                    o();
                }
            } else if (z11) {
                o();
            }
            z12 = true;
        }
        if (z12 || !b(set, hashSet)) {
            return false;
        }
        return true;
    }

    public static boolean j(Config config, UseCaseConfigFactory.CaptureType captureType) {
        if (((Boolean) config.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.FALSE)).booleanValue()) {
            return false;
        }
        Config.Option<Integer> option = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        if (config.containsOption(option) && d4.b(captureType, ((Integer) config.retrieveOption(option)).intValue()) == 5) {
            return true;
        }
        return false;
    }

    public static boolean k(y yVar, List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, StreamSpec> map, Map<AttachedSurfaceInfo, StreamSpec> map2) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        ArrayList<UseCaseConfig> arrayList = new ArrayList<>(map.keySet());
        for (AttachedSurfaceInfo implementationOptions : list) {
            h.g(implementationOptions.getImplementationOptions());
        }
        for (UseCaseConfig useCaseConfig : arrayList) {
            h.g(((StreamSpec) h.g(map.get(useCaseConfig))).getImplementationOptions());
        }
        long[] jArr = (long[]) yVar.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
        if (!(jArr == null || jArr.length == 0)) {
            HashSet hashSet = new HashSet();
            for (long valueOf : jArr) {
                hashSet.add(Long.valueOf(valueOf));
            }
            if (i(list, arrayList, hashSet)) {
                for (AttachedSurfaceInfo next : list) {
                    Config implementationOptions2 = next.getImplementationOptions();
                    Config f11 = f(implementationOptions2, ((Long) implementationOptions2.retrieveOption(Camera2ImplConfig.f4891c)).longValue());
                    if (f11 != null) {
                        map2.put(next, next.toStreamSpec(f11));
                    }
                }
                for (UseCaseConfig useCaseConfig2 : arrayList) {
                    StreamSpec streamSpec = map.get(useCaseConfig2);
                    Config implementationOptions3 = streamSpec.getImplementationOptions();
                    Config f12 = f(implementationOptions3, ((Long) implementationOptions3.retrieveOption(Camera2ImplConfig.f4891c)).longValue());
                    if (f12 != null) {
                        map.put(useCaseConfig2, streamSpec.toBuilder().setImplementationOptions(f12).build());
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void l(Map<UseCaseConfig<?>, StreamSpec> map, Map<AttachedSurfaceInfo, StreamSpec> map2, Map<Integer, AttachedSurfaceInfo> map3, Map<Integer, UseCaseConfig<?>> map4, List<SurfaceConfig> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            long streamUseCase = list.get(i11).getStreamUseCase();
            if (map3.containsKey(Integer.valueOf(i11))) {
                AttachedSurfaceInfo attachedSurfaceInfo = map3.get(Integer.valueOf(i11));
                Config f11 = f(attachedSurfaceInfo.getImplementationOptions(), streamUseCase);
                if (f11 != null) {
                    map2.put(attachedSurfaceInfo, attachedSurfaceInfo.toStreamSpec(f11));
                }
            } else if (map4.containsKey(Integer.valueOf(i11))) {
                UseCaseConfig useCaseConfig = map4.get(Integer.valueOf(i11));
                StreamSpec streamSpec = map.get(useCaseConfig);
                Config f12 = f(streamSpec.getImplementationOptions(), streamUseCase);
                if (f12 != null) {
                    map.put(useCaseConfig, streamSpec.toBuilder().setImplementationOptions(f12).build());
                }
            } else {
                throw new AssertionError("SurfaceConfig does not map to any use case");
            }
        }
    }

    public static void m(Collection<SessionConfig> collection, Collection<UseCaseConfig<?>> collection2, Map<DeferrableSurface, Long> map) {
        boolean z11;
        ArrayList arrayList = new ArrayList(collection2);
        Iterator<SessionConfig> it2 = collection.iterator();
        while (true) {
            z11 = true;
            if (!it2.hasNext()) {
                z11 = false;
                break;
            }
            SessionConfig next = it2.next();
            Config implementationOptions = next.getImplementationOptions();
            Config.Option<Long> option = f5243a;
            if (!implementationOptions.containsOption(option) || next.getSurfaces().size() == 1) {
                if (next.getImplementationOptions().containsOption(option)) {
                    break;
                }
            } else {
                Logger.e("Camera2CameraImpl", String.format("SessionConfig has stream use case but also contains %d surfaces, abort populateSurfaceToStreamUseCaseMapping().", new Object[]{Integer.valueOf(next.getSurfaces().size())}));
                return;
            }
        }
        if (z11) {
            int i11 = 0;
            for (SessionConfig next2 : collection) {
                if (((UseCaseConfig) arrayList.get(i11)).getCaptureType() == UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                    map.put(next2.getSurfaces().get(0), 1L);
                } else {
                    Config implementationOptions2 = next2.getImplementationOptions();
                    Config.Option<Long> option2 = f5243a;
                    if (implementationOptions2.containsOption(option2)) {
                        map.put(next2.getSurfaces().get(0), (Long) next2.getImplementationOptions().retrieveOption(option2));
                    }
                }
                i11++;
            }
        }
    }

    public static boolean n(p3.b bVar) {
        return bVar.a() == 0 && bVar.b() == 8;
    }

    public static void o() {
        throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
    }
}
