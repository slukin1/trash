package com.sumsub.sns.internal.core.theme;

import com.huobi.view.roundimg.RoundedDrawable;
import kotlin.jvm.internal.r;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0384a f34034a = new C0384a((r) null);

    /* renamed from: com.sumsub.sns.internal.core.theme.a$a  reason: collision with other inner class name */
    public static final class C0384a {
        public /* synthetic */ C0384a(r rVar) {
            this();
        }

        public final int a(String str) {
            int parseInt;
            int i11;
            int parseInt2;
            int parseInt3;
            int parseInt4;
            int i12;
            int i13;
            int i14;
            int i15;
            if (str.charAt(0) == '#' && str.length() > 5) {
                int parseInt5 = Integer.parseInt(str.subSequence(1, 3).toString(), 16);
                int parseInt6 = Integer.parseInt(str.subSequence(3, 5).toString(), 16);
                int parseInt7 = Integer.parseInt(str.subSequence(5, 7).toString(), 16);
                i14 = (((str.length() > 7 ? Integer.parseInt(str.subSequence(7, 9).toString(), 16) : 255) & 255) << 24) | ((parseInt5 & 255) << 16) | ((parseInt6 & 255) << 8);
                i15 = parseInt7 & 255;
            } else if (str.charAt(0) != '#' || str.length() > 5) {
                if (StringsKt__StringsJVMKt.M(str, "0x", false, 2, (Object) null) && str.length() == 5) {
                    parseInt2 = Integer.parseInt(str.subSequence(2, 3).toString(), 16);
                    parseInt3 = Integer.parseInt(str.subSequence(3, 4).toString(), 16);
                    parseInt4 = Integer.parseInt(str.subSequence(4, 5).toString(), 16);
                } else if (StringsKt__StringsJVMKt.M(str, "0x", false, 2, (Object) null) && str.length() == 6) {
                    int parseInt8 = Integer.parseInt(str.subSequence(2, 3).toString(), 16);
                    int parseInt9 = Integer.parseInt(str.subSequence(3, 4).toString(), 16);
                    int parseInt10 = Integer.parseInt(str.subSequence(4, 5).toString(), 16);
                    parseInt4 = Integer.parseInt(str.subSequence(5, 6).toString(), 16);
                    i12 = ((parseInt8 | ((parseInt8 & 15) << 4)) << 24) | (((parseInt9 | ((parseInt9 & 15) << 4)) & 255) << 16);
                    i13 = ((parseInt10 & 15) << 4) | parseInt10;
                    i11 = i12 | ((i13 & 255) << 8);
                    parseInt = parseInt4 | ((parseInt4 & 15) << 4);
                    return (parseInt & 255) | i11;
                } else if (StringsKt__StringsJVMKt.M(str, "0x", false, 2, (Object) null) && str.length() == 8) {
                    parseInt2 = Integer.parseInt(str.subSequence(2, 4).toString(), 16);
                    parseInt3 = Integer.parseInt(str.subSequence(4, 6).toString(), 16);
                    parseInt4 = Integer.parseInt(str.subSequence(6, 8).toString(), 16);
                } else if (!StringsKt__StringsJVMKt.M(str, "0x", false, 2, (Object) null) || str.length() <= 8) {
                    throw new IllegalArgumentException("Can't parse " + str);
                } else {
                    int parseInt11 = Integer.parseInt(str.subSequence(2, 4).toString(), 16);
                    int parseInt12 = Integer.parseInt(str.subSequence(4, 6).toString(), 16);
                    int parseInt13 = Integer.parseInt(str.subSequence(6, 8).toString(), 16);
                    parseInt = Integer.parseInt(str.subSequence(8, 10).toString(), 16);
                    i11 = ((parseInt11 & 255) << 24) | ((parseInt12 & 255) << 16) | ((parseInt13 & 255) << 8);
                    return (parseInt & 255) | i11;
                }
                i12 = (((parseInt2 | ((parseInt2 & 15) << 4)) & 255) << 16) | RoundedDrawable.DEFAULT_BORDER_COLOR;
                i13 = parseInt3 | ((parseInt3 & 15) << 4);
                i11 = i12 | ((i13 & 255) << 8);
                parseInt = parseInt4 | ((parseInt4 & 15) << 4);
                return (parseInt & 255) | i11;
            } else {
                int parseInt14 = Integer.parseInt(str.subSequence(1, 2).toString(), 16);
                int parseInt15 = Integer.parseInt(str.subSequence(2, 3).toString(), 16);
                int parseInt16 = Integer.parseInt(str.subSequence(3, 4).toString(), 16);
                int parseInt17 = str.length() == 5 ? Integer.parseInt(str.subSequence(4, 5).toString(), 16) : 15;
                i14 = ((parseInt17 | ((parseInt17 & 15) << 4)) << 24) | (((parseInt14 | ((parseInt14 & 15) << 4)) & 255) << 16) | (((((parseInt15 & 15) << 4) | parseInt15) & 255) << 8);
                i15 = (((parseInt16 & 15) << 4) | parseInt16) & 255;
            }
            return i14 | i15;
        }

        public C0384a() {
        }
    }
}
