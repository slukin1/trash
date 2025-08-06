package com.hbg.lib.common.utils;

import java.util.Collection;
import java.util.List;

public class UtilCollections {

    public interface a {
        void init();
    }

    public interface b<T> {
        void a(int i11, T t11);
    }

    public interface c {
        void a(int i11, float f11);
    }

    public static <T> void a(List<T> list, int i11, int i12, a aVar, b<T> bVar) {
        if (!f(list) && h(list, i11) && h(list, i12)) {
            if (aVar != null) {
                aVar.init();
            }
            while (i11 <= i12) {
                bVar.a(i11, list.get(i11));
                i11++;
            }
        }
    }

    public static <T> void b(List<T> list, int i11, int i12, b<T> bVar) {
        if (!f(list) && h(list, i11) && h(list, i12)) {
            while (i11 <= i12) {
                bVar.a(i11, list.get(i11));
                i11++;
            }
        }
    }

    public static <T> void c(List<T> list, b<T> bVar) {
        if (!f(list)) {
            b(list, 0, list.size() - 1, bVar);
        }
    }

    public static void d(float[] fArr, int i11, int i12, int i13, c cVar) {
        if (!g(fArr) && i(fArr, i11) && i(fArr, i12)) {
            while (i11 <= i12) {
                cVar.a(i11, fArr[i11]);
                i11 += i13;
            }
        }
    }

    public static void e(float[] fArr, int i11, c cVar) {
        if (!g(fArr)) {
            d(fArr, 0, fArr.length - 1, i11, cVar);
        }
    }

    public static boolean f(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean g(float[] fArr) {
        return fArr == null || fArr.length == 0;
    }

    public static boolean h(Collection collection, int i11) {
        return collection != null && i11 >= 0 && i11 < collection.size();
    }

    public static boolean i(float[] fArr, int i11) {
        return fArr != null && i11 >= 0 && i11 < fArr.length;
    }
}
