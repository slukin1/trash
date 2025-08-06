package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Strings;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@GwtCompatible(emulated = true)
final class Platform {
    private static final String GWT_RPC_PROPERTY_NAME = "guava.gwt.emergency_reenable_rpc";

    private Platform() {
    }

    public static void checkGwtRpcEnabled() {
        if (!Boolean.parseBoolean(System.getProperty(GWT_RPC_PROPERTY_NAME, "true"))) {
            throw new UnsupportedOperationException(Strings.lenientFormat("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", GWT_RPC_PROPERTY_NAME, "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ"));
        }
    }

    public static <T> T[] copy(Object[] objArr, int i11, int i12, T[] tArr) {
        return Arrays.copyOfRange(objArr, i11, i12, tArr.getClass());
    }

    public static <T> T[] newArray(T[] tArr, int i11) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i11);
    }

    public static <K, V> Map<K, V> newHashMapWithExpectedSize(int i11) {
        return CompactHashMap.createWithExpectedSize(i11);
    }

    public static <E> Set<E> newHashSetWithExpectedSize(int i11) {
        return CompactHashSet.createWithExpectedSize(i11);
    }

    public static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int i11) {
        return CompactLinkedHashMap.createWithExpectedSize(i11);
    }

    public static <E> Set<E> newLinkedHashSetWithExpectedSize(int i11) {
        return CompactLinkedHashSet.createWithExpectedSize(i11);
    }

    public static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return CompactHashSet.create();
    }

    public static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }

    public static int reduceExponentIfGwt(int i11) {
        return i11;
    }

    public static int reduceIterationsIfGwt(int i11) {
        return i11;
    }

    public static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }
}
