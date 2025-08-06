package com.tencent.mm.a;

import com.huochat.community.util.FileTool;
import java.security.MessageDigest;

public final class b {
    public static final String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(bArr);
            char[] cArr2 = new char[(r1 * 2)];
            int i11 = 0;
            for (byte b11 : instance.digest()) {
                int i12 = i11 + 1;
                cArr2[i11] = cArr[(b11 >>> 4) & 15];
                i11 = i12 + 1;
                cArr2[i12] = cArr[b11 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }
}
