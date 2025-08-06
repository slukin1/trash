package com.google.android.gms.common.data;

import java.util.ArrayList;

public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        ArrayList<T> arrayList2 = new ArrayList<>(arrayList.size());
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList2.add(((Freezable) arrayList.get(i11)).freeze());
        }
        return arrayList2;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (E freeze : iterable) {
            arrayList.add(freeze.freeze());
        }
        return arrayList;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        ArrayList<T> arrayList = new ArrayList<>(eArr.length);
        for (E freeze : eArr) {
            arrayList.add(freeze.freeze());
        }
        return arrayList;
    }
}
