package org.apache.commons.io.filefilter;

import java.util.ArrayList;
import java.util.List;
import t10.a;

public class FileFilterUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final a f58945a = d(a(b(), c("CVS")));

    /* renamed from: b  reason: collision with root package name */
    public static final a f58946b = d(a(b(), c(".svn")));

    public static a a(a... aVarArr) {
        return new AndFileFilter(e(aVarArr));
    }

    public static a b() {
        return DirectoryFileFilter.DIRECTORY;
    }

    public static a c(String str) {
        return new NameFileFilter(str);
    }

    public static a d(a aVar) {
        return new NotFileFilter(aVar);
    }

    public static List<a> e(a... aVarArr) {
        if (aVarArr != null) {
            ArrayList arrayList = new ArrayList(aVarArr.length);
            int i11 = 0;
            while (i11 < aVarArr.length) {
                if (aVarArr[i11] != null) {
                    arrayList.add(aVarArr[i11]);
                    i11++;
                } else {
                    throw new IllegalArgumentException("The filter[" + i11 + "] is null");
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("The filters must not be null");
    }
}
