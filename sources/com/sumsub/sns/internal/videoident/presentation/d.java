package com.sumsub.sns.internal.videoident.presentation;

import com.sumsub.sns.internal.core.common.n0;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.x;

public final class d {
    public static final List<String> b(String str, String str2, String str3, String str4, String str5) {
        String[] strArr = new String[5];
        strArr[0] = String.format(n0.j.a.f32239t, Arrays.copyOf(new Object[]{str, str2, str3, str4, str5}, 5));
        strArr[1] = String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{str, str2, str3, str4}, 4));
        strArr[2] = String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{n0.j.a.f32226g, str2, str3, str4}, 4));
        Object[] objArr = new Object[2];
        objArr[0] = str;
        String str6 = !x.b(str4, "text") ? str4 : null;
        String str7 = n0.j.a.f32233n;
        if (str6 == null) {
            str6 = str7;
        }
        objArr[1] = str6;
        strArr[3] = String.format(n0.j.a.f32235p, Arrays.copyOf(objArr, 2));
        Object[] objArr2 = new Object[2];
        objArr2[0] = n0.j.a.f32226g;
        if (x.b(str4, "text")) {
            str4 = null;
        }
        if (str4 != null) {
            str7 = str4;
        }
        objArr2[1] = str7;
        strArr[4] = String.format(n0.j.a.f32235p, Arrays.copyOf(objArr2, 2));
        return CollectionsKt__CollectionsKt.n(strArr);
    }

    public static final List<String> b(String str, String str2, String str3) {
        String[] strArr = new String[4];
        strArr[0] = String.format(n0.j.a.f32236q, Arrays.copyOf(new Object[]{str, str2, str3}, 3));
        strArr[1] = String.format(n0.j.a.f32236q, Arrays.copyOf(new Object[]{n0.j.a.f32226g, str2, str3}, 3));
        Object[] objArr = new Object[2];
        objArr[0] = str;
        String str4 = !x.b(str3, "text") ? str3 : null;
        String str5 = n0.j.a.f32233n;
        if (str4 == null) {
            str4 = str5;
        }
        objArr[1] = str4;
        strArr[2] = String.format(n0.j.a.f32235p, Arrays.copyOf(objArr, 2));
        Object[] objArr2 = new Object[2];
        objArr2[0] = n0.j.a.f32226g;
        if (x.b(str3, "text")) {
            str3 = null;
        }
        if (str3 != null) {
            str5 = str3;
        }
        objArr2[1] = str5;
        strArr[3] = String.format(n0.j.a.f32235p, Arrays.copyOf(objArr2, 2));
        return CollectionsKt__CollectionsKt.n(strArr);
    }
}
