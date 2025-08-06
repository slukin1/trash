package com.huochat.community.util;

import java.util.ArrayList;
import java.util.List;

public class CollectorsTool {
    public static <T> List<T> subList(List<T> list, int i11, int i12) {
        int size;
        if (list == null || list.isEmpty() || i12 >= (size = list.size())) {
            return list;
        }
        if (i11 >= size) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (i11 < i12) {
            arrayList.add(list.get(i11));
            i11++;
        }
        return arrayList;
    }
}
