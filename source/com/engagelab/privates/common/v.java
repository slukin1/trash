package com.engagelab.privates.common;

import android.text.TextUtils;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.core.api.Outputer;

public class v {
    public static byte[] a(int i11, int i12) {
        Outputer outputer = new Outputer(11);
        outputer.writeU16(0);
        outputer.writeU8((byte) i11);
        outputer.writeU64((long) i12);
        return outputer.toByteArray();
    }

    public static byte[] b(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            Outputer outputer = new Outputer(bytes.length);
            outputer.writeByteArrayIncludeLength(bytes);
            return outputer.toByteArray();
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushProtocol", "packageAliasRequest failed " + th2.getMessage());
            return null;
        }
    }

    public static byte[] a(byte b11, String str, String str2) {
        int i11;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte[] bytes2 = !TextUtils.isEmpty(str2) ? str2.getBytes("UTF-8") : null;
            if (bytes2 == null || bytes2.length <= 0) {
                i11 = bytes.length + 1;
            } else {
                i11 = bytes.length + 1 + bytes2.length;
            }
            Outputer outputer = new Outputer(i11);
            outputer.writeByteArrayIncludeLength(bytes);
            outputer.writeU8(b11);
            if (bytes2 != null && bytes2.length > 0) {
                outputer.writeByteArrayIncludeLength(bytes2);
            }
            return outputer.toByteArray();
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushProtocol", "packagePlatformTokenBody failed " + th2.getMessage());
            return null;
        }
    }

    public static byte[] a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            Outputer outputer = new Outputer(bytes.length + 1 + 1);
            outputer.writeU8(7);
            outputer.writeU8(1);
            outputer.writeByteArrayIncludeLength(bytes);
            return outputer.toByteArray();
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushProtocol", "packageMobileNumberBody failed " + th2.getMessage());
            return null;
        }
    }
}
