package org.cybergarage.xml;

public class XML {
    public static final String a(String str) {
        return b(str, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String b(java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            int r2 = r9.length()
            char[] r3 = new char[r2]
            r4 = 0
            r9.getChars(r4, r2, r3, r4)
            r6 = r0
            r5 = r4
        L_0x0015:
            if (r4 < r2) goto L_0x0023
            if (r5 != 0) goto L_0x001a
            return r9
        L_0x001a:
            int r2 = r2 - r5
            r1.append(r3, r5, r2)
            java.lang.String r9 = r1.toString()
            return r9
        L_0x0023:
            char r7 = r3[r4]
            r8 = 34
            if (r7 == r8) goto L_0x0048
            r8 = 60
            if (r7 == r8) goto L_0x0045
            r8 = 62
            if (r7 == r8) goto L_0x0042
            r8 = 38
            if (r7 == r8) goto L_0x003f
            r8 = 39
            if (r7 == r8) goto L_0x003a
            goto L_0x004c
        L_0x003a:
            if (r10 == 0) goto L_0x0048
            java.lang.String r6 = "&apos;"
            goto L_0x004c
        L_0x003f:
            java.lang.String r6 = "&amp;"
            goto L_0x004c
        L_0x0042:
            java.lang.String r6 = "&gt;"
            goto L_0x004c
        L_0x0045:
            java.lang.String r6 = "&lt;"
            goto L_0x004c
        L_0x0048:
            if (r10 == 0) goto L_0x004c
            java.lang.String r6 = "&quot;"
        L_0x004c:
            if (r6 == 0) goto L_0x0059
            int r7 = r4 - r5
            r1.append(r3, r5, r7)
            r1.append(r6)
            int r5 = r4 + 1
            r6 = r0
        L_0x0059:
            int r4 = r4 + 1
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cybergarage.xml.XML.b(java.lang.String, boolean):java.lang.String");
    }
}
