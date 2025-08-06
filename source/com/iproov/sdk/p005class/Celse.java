package com.iproov.sdk.p005class;

import java.util.HashSet;
import java.util.Set;

/* renamed from: com.iproov.sdk.class.else  reason: invalid class name and invalid package */
public enum Celse {
    AVC("h264", Cgoto.f198do, 2),
    HEVC("h265", Cgoto.f200if, 1),
    VP9("vp9", Cgoto.f199for, 3),
    VP8("vp8", Cgoto.f201new, 4);
    

    /* renamed from: goto  reason: not valid java name */
    private static Set<String> f186goto;

    /* renamed from: do  reason: not valid java name */
    public final String f190do;

    /* renamed from: for  reason: not valid java name */
    public final int f191for;

    /* renamed from: if  reason: not valid java name */
    public final String f192if;

    /* access modifiers changed from: public */
    static {
        int i11;
        f186goto = new HashSet();
        for (Celse elseR : values()) {
            f186goto.add(elseR.f192if);
        }
    }

    private Celse(String str, String str2, int i11) {
        this.f190do = str;
        this.f192if = str2;
        this.f191for = i11;
    }

    /* renamed from: do  reason: not valid java name */
    public static Celse m270do(String str) {
        if (str == null || str.isEmpty()) {
            return AVC;
        }
        for (Celse elseR : values()) {
            if (elseR.f190do.equals(str)) {
                return elseR;
            }
        }
        throw new IllegalArgumentException(str + " is incorrect encoder name");
    }

    /* renamed from: for  reason: not valid java name */
    public static boolean m271for(String str) {
        return f186goto.contains(str);
    }

    /* renamed from: if  reason: not valid java name */
    public static Celse m272if(String str) {
        for (Celse elseR : values()) {
            if (elseR.f192if.equals(str)) {
                return elseR;
            }
        }
        throw new IllegalArgumentException(str + " is incorrect encoder name");
    }
}
