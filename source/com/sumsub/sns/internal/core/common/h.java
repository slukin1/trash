package com.sumsub.sns.internal.core.common;

import java.util.ArrayList;
import java.util.List;

public final class h {
    public static final String[] a(CharSequence charSequence) {
        List<String> K0 = StringsKt__StringsKt.K0(charSequence, new char[]{',', ';', '|', ':'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(K0, 10));
        for (String i12 : K0) {
            arrayList.add(StringsKt__StringsKt.i1(i12).toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
