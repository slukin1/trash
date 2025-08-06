package com.huobi.woodpecker.kalle.secure;

public class Encryption {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(byte[] r6) {
        /*
            int r0 = r6.length
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r2 = r0 * 2
            r1.<init>(r2)
            r2 = 0
        L_0x0009:
            if (r2 >= r0) goto L_0x0025
            byte r3 = r6[r2]
        L_0x000d:
            if (r3 >= 0) goto L_0x0012
            int r3 = r3 + 256
            goto L_0x000d
        L_0x0012:
            r4 = 16
            if (r3 >= r4) goto L_0x001b
            java.lang.String r5 = "0"
            r1.append(r5)
        L_0x001b:
            java.lang.String r3 = java.lang.Integer.toString(r3, r4)
            r1.append(r3)
            int r2 = r2 + 1
            goto L_0x0009
        L_0x0025:
            java.lang.String r6 = r1.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.woodpecker.kalle.secure.Encryption.a(byte[]):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NoSuchAlgorithmException -> 0x0034 }
            r0.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x0034 }
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0034 }
            byte[] r2 = r6.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x0034 }
            byte[] r1 = r1.digest(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0034 }
            int r2 = r1.length     // Catch:{ NoSuchAlgorithmException -> 0x0034 }
            r3 = 0
        L_0x0015:
            if (r3 >= r2) goto L_0x0030
            byte r4 = r1[r3]     // Catch:{ NoSuchAlgorithmException -> 0x0034 }
            if (r4 >= 0) goto L_0x001d
            int r4 = r4 + 256
        L_0x001d:
            r5 = 16
            if (r4 >= r5) goto L_0x0026
            java.lang.String r5 = "0"
            r0.append(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0034 }
        L_0x0026:
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0034 }
            r0.append(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0034 }
            int r3 = r3 + 1
            goto L_0x0015
        L_0x0030:
            java.lang.String r6 = r0.toString()     // Catch:{ NoSuchAlgorithmException -> 0x0034 }
        L_0x0034:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.woodpecker.kalle.secure.Encryption.b(java.lang.String):java.lang.String");
    }

    public static byte[] c(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[(length / 2)];
        for (int i11 = 0; i11 < length; i11 += 2) {
            bArr[i11 / 2] = (byte) Integer.parseInt(new String(bytes, i11, 2), 16);
        }
        return bArr;
    }
}
