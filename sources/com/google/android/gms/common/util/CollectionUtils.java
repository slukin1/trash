package com.google.android.gms.common.util;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.InlineMe;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepForSdk
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @InlineMe(imports = {"java.util.Collections"}, replacement = "Collections.emptyList()")
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k11, V v11, K k12, V v12, K k13, V v13) {
        Map zza = zza(3, false);
        zza.put(k11, v11);
        zza.put(k12, v12);
        zza.put(k13, v13);
        return Collections.unmodifiableMap(zza);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] kArr, V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        } else if (length == 0) {
            return Collections.emptyMap();
        } else {
            if (length == 1) {
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            Map zza = zza(length, false);
            for (int i11 = 0; i11 < kArr.length; i11++) {
                zza.put(kArr[i11], vArr[i11]);
            }
            return Collections.unmodifiableMap(zza);
        }
    }

    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i11) {
        if (i11 == 0) {
            return new ArraySet();
        }
        return zzb(i11, true);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T t11, T t12, T t13) {
        Set zzb = zzb(3, false);
        zzb.add(t11);
        zzb.add(t12);
        zzb.add(t13);
        return Collections.unmodifiableSet(zzb);
    }

    private static Map zza(int i11, boolean z11) {
        if (i11 <= 256) {
            return new ArrayMap(i11);
        }
        return new HashMap(i11, 1.0f);
    }

    private static Set zzb(int i11, boolean z11) {
        if (i11 <= (true != z11 ? 256 : 128)) {
            return new ArraySet(i11);
        }
        return new HashSet(i11, true != z11 ? 1.0f : 0.75f);
    }

    @InlineMe(imports = {"java.util.Collections"}, replacement = "Collections.singletonList(item)")
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T t11) {
        return Collections.singletonList(t11);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return Collections.singletonList(tArr[0]);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16) {
        Map zza = zza(6, false);
        zza.put(k11, v11);
        zza.put(k12, v12);
        zza.put(k13, v13);
        zza.put(k14, v14);
        zza.put(k15, v15);
        zza.put(k16, v16);
        return Collections.unmodifiableMap(zza);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t11 = tArr[0];
            T t12 = tArr[1];
            Set zzb = zzb(2, false);
            zzb.add(t11);
            zzb.add(t12);
            return Collections.unmodifiableSet(zzb);
        } else if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        } else {
            if (length != 4) {
                Set zzb2 = zzb(length, false);
                Collections.addAll(zzb2, tArr);
                return Collections.unmodifiableSet(zzb2);
            }
            T t13 = tArr[0];
            T t14 = tArr[1];
            T t15 = tArr[2];
            T t16 = tArr[3];
            Set zzb3 = zzb(4, false);
            zzb3.add(t13);
            zzb3.add(t14);
            zzb3.add(t15);
            zzb3.add(t16);
            return Collections.unmodifiableSet(zzb3);
        }
    }
}
