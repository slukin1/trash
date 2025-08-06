package com.sumsub.sns.internal.core.widget.autocompletePhone.util;

import d10.l;
import java.util.Collection;

public final class a {
    public static final <T> String a(Collection<? extends T> collection) {
        return CollectionsKt___CollectionsKt.k0(collection, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null);
    }

    public static final boolean a(String str) {
        int i11 = 0;
        int i12 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i11);
            if (charAt != '#' && !Character.isDigit(charAt)) {
                z11 = false;
            }
            if (z11) {
                i12++;
            }
            i11++;
        }
        return 7 <= i12 && i12 < 16;
    }
}
