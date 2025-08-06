package com.sumsub.sns.internal.core.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.IntIterator;

public final class z0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f32327a = 16;

    public static final byte[] a(String str) {
        if (str.length() % 2 == 0) {
            List<String> k12 = StringsKt___StringsKt.k1(str, 2);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(k12, 10));
            for (String parseInt : k12) {
                arrayList.add(Byte.valueOf((byte) Integer.parseInt(parseInt, CharsKt__CharJVMKt.a(16))));
            }
            return CollectionsKt___CollectionsKt.E0(arrayList);
        }
        throw new IllegalStateException("Must have an even length".toString());
    }

    public static final String a(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(list.get(0).toLowerCase(Locale.ROOT));
        Iterator it2 = RangesKt___RangesKt.o(1, list.size()).iterator();
        while (it2.hasNext()) {
            int a11 = ((IntIterator) it2).a();
            String valueOf = String.valueOf(list.get(a11).charAt(0));
            Locale locale = Locale.ROOT;
            sb2.append(valueOf.toUpperCase(locale));
            sb2.append(list.get(a11).substring(1).toLowerCase(locale));
        }
        return sb2.toString();
    }
}
