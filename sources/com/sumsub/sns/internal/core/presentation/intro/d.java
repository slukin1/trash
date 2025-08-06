package com.sumsub.sns.internal.core.presentation.intro;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import java.util.Arrays;

public final class d {
    public static final String a(b.c cVar, f fVar, Label label) {
        String c11 = fVar.c();
        String b11 = fVar.b();
        String a11 = fVar.a();
        if (a11 == null) {
            a11 = "";
        }
        return cVar.a(a(c11, b11, label, a11), a(fVar.c(), fVar.b(), label, ""), a(n0.j.a.f32226g, fVar.b(), label, ""));
    }

    public static final e b(f fVar, b.c cVar) {
        return new e(a("title", cVar, fVar), a(MessengerShareContentUtility.SUBTITLE, cVar, fVar), (c) null, (c) null, (c) null, a("header_image", cVar, fVar), a("header_title", cVar, fVar), a("instructions_text", cVar, fVar), a("action_continue", cVar, fVar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0045, code lost:
        if (r5 == null) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String a(java.lang.String r5, java.lang.String r6, com.sumsub.sns.internal.core.presentation.intro.Label r7, java.lang.String r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 4
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r5
            r5 = 1
            r2[r5] = r6
            r6 = 2
            java.lang.String r4 = "instructions"
            r2[r6] = r4
            java.lang.String r6 = r7.name()
            r7 = 3
            r2[r7] = r6
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r2, r1)
            java.lang.String r7 = "sns_step_%s_%s_%s_%s"
            java.lang.String r6 = java.lang.String.format(r7, r6)
            r0.append(r6)
            int r6 = r8.length()
            if (r6 <= 0) goto L_0x002e
            r3 = r5
        L_0x002e:
            if (r3 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r8 = 0
        L_0x0032:
            if (r8 == 0) goto L_0x0047
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "::"
            r5.append(r6)
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            if (r5 != 0) goto L_0x0049
        L_0x0047:
            java.lang.String r5 = ""
        L_0x0049:
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.intro.d.a(java.lang.String, java.lang.String, com.sumsub.sns.internal.core.presentation.intro.Label, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.internal.core.presentation.intro.e a(com.sumsub.sns.internal.core.presentation.intro.f r11, com.sumsub.sns.internal.core.data.source.dynamic.b.c r12) {
        /*
            com.sumsub.sns.internal.core.presentation.intro.Label r0 = com.sumsub.sns.internal.core.presentation.intro.Label.action_continue
            java.lang.String r10 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r0)
            com.sumsub.sns.internal.core.presentation.intro.Label r0 = com.sumsub.sns.internal.core.presentation.intro.Label.title
            java.lang.String r2 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r0)
            com.sumsub.sns.internal.core.presentation.intro.Label r0 = com.sumsub.sns.internal.core.presentation.intro.Label.subtitle
            java.lang.String r3 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r0)
            com.sumsub.sns.internal.core.presentation.intro.Label r0 = com.sumsub.sns.internal.core.presentation.intro.Label.header
            java.lang.String r0 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r0)
            int r1 = r0.length()
            r4 = 1
            r5 = 0
            if (r1 <= 0) goto L_0x0022
            r1 = r4
            goto L_0x0023
        L_0x0022:
            r1 = r5
        L_0x0023:
            if (r1 == 0) goto L_0x0049
            com.sumsub.sns.internal.core.presentation.intro.Label r1 = com.sumsub.sns.internal.core.presentation.intro.Label.doHeader
            java.lang.String r1 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r1)
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0033
            r1 = r4
            goto L_0x0034
        L_0x0033:
            r1 = r5
        L_0x0034:
            if (r1 == 0) goto L_0x0049
            com.sumsub.sns.internal.core.presentation.intro.Label r1 = com.sumsub.sns.internal.core.presentation.intro.Label.dontHeader
            java.lang.String r1 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r1)
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0044
            r1 = r4
            goto L_0x0045
        L_0x0044:
            r1 = r5
        L_0x0045:
            if (r1 == 0) goto L_0x0049
            r1 = r4
            goto L_0x004a
        L_0x0049:
            r1 = r5
        L_0x004a:
            r6 = 0
            if (r1 == 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r0 = r6
        L_0x004f:
            if (r0 == 0) goto L_0x0064
            com.sumsub.sns.internal.core.presentation.intro.c r1 = new com.sumsub.sns.internal.core.presentation.intro.c
            com.sumsub.sns.internal.core.presentation.intro.Label r7 = com.sumsub.sns.internal.core.presentation.intro.Label.text
            java.lang.String r7 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r7)
            com.sumsub.sns.internal.core.presentation.intro.Label r8 = com.sumsub.sns.internal.core.presentation.intro.Label.image
            java.lang.String r8 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r8)
            r1.<init>(r0, r7, r8)
            r0 = r1
            goto L_0x0065
        L_0x0064:
            r0 = r6
        L_0x0065:
            com.sumsub.sns.internal.core.presentation.intro.Label r1 = com.sumsub.sns.internal.core.presentation.intro.Label.doHeader
            java.lang.String r1 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r1)
            int r7 = r1.length()
            if (r7 <= 0) goto L_0x0073
            r7 = r4
            goto L_0x0074
        L_0x0073:
            r7 = r5
        L_0x0074:
            if (r7 == 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r1 = r6
        L_0x0078:
            if (r1 == 0) goto L_0x008c
            com.sumsub.sns.internal.core.presentation.intro.c r7 = new com.sumsub.sns.internal.core.presentation.intro.c
            com.sumsub.sns.internal.core.presentation.intro.Label r8 = com.sumsub.sns.internal.core.presentation.intro.Label.doText
            java.lang.String r8 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r8)
            com.sumsub.sns.internal.core.presentation.intro.Label r9 = com.sumsub.sns.internal.core.presentation.intro.Label.doImage
            java.lang.String r9 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r9)
            r7.<init>(r1, r8, r9)
            goto L_0x008d
        L_0x008c:
            r7 = r6
        L_0x008d:
            com.sumsub.sns.internal.core.presentation.intro.Label r1 = com.sumsub.sns.internal.core.presentation.intro.Label.dontHeader
            java.lang.String r1 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r1)
            int r8 = r1.length()
            if (r8 <= 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r4 = r5
        L_0x009b:
            if (r4 == 0) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r1 = r6
        L_0x009f:
            if (r1 == 0) goto L_0x00b3
            com.sumsub.sns.internal.core.presentation.intro.c r4 = new com.sumsub.sns.internal.core.presentation.intro.c
            com.sumsub.sns.internal.core.presentation.intro.Label r5 = com.sumsub.sns.internal.core.presentation.intro.Label.dontText
            java.lang.String r5 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r5)
            com.sumsub.sns.internal.core.presentation.intro.Label r6 = com.sumsub.sns.internal.core.presentation.intro.Label.dontImage
            java.lang.String r11 = a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12, (com.sumsub.sns.internal.core.presentation.intro.f) r11, (com.sumsub.sns.internal.core.presentation.intro.Label) r6)
            r4.<init>(r1, r5, r11)
            r6 = r4
        L_0x00b3:
            com.sumsub.sns.internal.core.presentation.intro.e r11 = new com.sumsub.sns.internal.core.presentation.intro.e
            r12 = 0
            r8 = 0
            r9 = 0
            r1 = r11
            r4 = r0
            r5 = r7
            r7 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.intro.d.a(com.sumsub.sns.internal.core.presentation.intro.f, com.sumsub.sns.internal.core.data.source.dynamic.b$c):com.sumsub.sns.internal.core.presentation.intro.e");
    }

    public static final String a(String str, b.c cVar, f fVar) {
        return cVar.a(a(fVar.c(), str));
    }

    public static final String a(String str, String str2) {
        return String.format(n0.j.a.f32238s, Arrays.copyOf(new Object[]{str, str2}, 2));
    }
}
