package com.sumsub.sns.internal.core.common;

import java.util.Locale;

public final class d {
    public static final int a(int i11, int i12) {
        return (i11 >> 1) | (1 << (i12 - 1));
    }

    public static /* synthetic */ b a(String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return a(str, z11);
    }

    public static final b a(String str, boolean z11) {
        b bVar = new b();
        if (z11) {
            str = str.toLowerCase(Locale.ROOT);
        }
        int i11 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            bVar.put(Character.valueOf(str.charAt(i12)), 0);
        }
        int i13 = 0;
        while (i11 < str.length()) {
            char charAt = str.charAt(i11);
            bVar.put(Character.valueOf(charAt), Integer.valueOf((1 << ((str.length() - i13) - 1)) | ((Number) bVar.get(Character.valueOf(charAt))).intValue()));
            i11++;
            i13++;
        }
        return bVar;
    }
}
