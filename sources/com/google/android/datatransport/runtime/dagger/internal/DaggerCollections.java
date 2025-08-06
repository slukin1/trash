package com.google.android.datatransport.runtime.dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class DaggerCollections {
    private static final int MAX_POWER_OF_TWO = 1073741824;

    private DaggerCollections() {
    }

    private static int calculateInitialCapacity(int i11) {
        if (i11 < 3) {
            return i11 + 1;
        }
        if (i11 < 1073741824) {
            return (int) ((((float) i11) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static boolean hasDuplicates(List<?> list) {
        if (list.size() < 2) {
            return false;
        }
        if (list.size() != new HashSet(list).size()) {
            return true;
        }
        return false;
    }

    public static <T> HashSet<T> newHashSetWithExpectedSize(int i11) {
        return new HashSet<>(calculateInitialCapacity(i11));
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i11) {
        return new LinkedHashMap<>(calculateInitialCapacity(i11));
    }

    public static <T> List<T> presizedList(int i11) {
        if (i11 == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i11);
    }
}
