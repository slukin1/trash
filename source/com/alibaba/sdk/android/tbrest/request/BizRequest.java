package com.alibaba.sdk.android.tbrest.request;

import android.content.Context;
import android.content.pm.PackageManager;
import com.alibaba.sdk.android.tbrest.SendService;
import com.alibaba.sdk.android.tbrest.utils.ByteUtils;
import com.alibaba.sdk.android.tbrest.utils.GzipUtils;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.facebook.internal.AnalyticsEvents;
import com.ut.device.UTDevice;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public class BizRequest {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14711a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f14712b;

    /* renamed from: c  reason: collision with root package name */
    public static long f14713c;

    public static String a(SendService sendService, String str, Context context) {
        String str2;
        String str3 = sendService.f14690e;
        String str4 = "";
        if (str3 == null) {
            str3 = str4;
        }
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        String str5 = sendService.f14691f;
        if (str5 != null) {
            str4 = str5;
        }
        String format = String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s", new Object[]{str, str3, str2, str4, UTDevice.a(context), "6.5.1.3"});
        LogUtil.d("send url :" + format);
        return format;
    }

    public static byte[] b(SendService sendService, String str, Context context, Map<String, String> map) throws Exception {
        return c(sendService, str, context, map, 1);
    }

    public static byte[] c(SendService sendService, String str, Context context, Map<String, String> map, int i11) throws Exception {
        byte[] a11 = GzipUtils.a(d(sendService, str, context, map));
        if (a11 == null || a11.length >= 16777216) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(1);
        byteArrayOutputStream.write(ByteUtils.d(a11.length));
        byteArrayOutputStream.write(i11);
        byte b11 = (byte) 9;
        if (f14711a) {
            b11 = (byte) (b11 | 32);
        }
        byteArrayOutputStream.write(b11);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(a11);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e11) {
            LogUtil.b(e11.toString());
        }
        return byteArray;
    }

    public static byte[] d(SendService sendService, String str, Context context, Map<String, String> map) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String a11 = a(sendService, str, context);
        if (a11 == null || a11.length() <= 0) {
            byteArrayOutputStream.write(ByteUtils.c(0));
        } else {
            byteArrayOutputStream.write(ByteUtils.c(a11.getBytes().length));
            byteArrayOutputStream.write(a11.getBytes());
        }
        if (map != null && map.size() > 0) {
            for (String next : map.keySet()) {
                byteArrayOutputStream.write(ByteUtils.e(Integer.valueOf(next).intValue()));
                String str2 = map.get(next);
                if (str2 != null) {
                    byteArrayOutputStream.write(ByteUtils.e(str2.getBytes().length));
                    byteArrayOutputStream.write(str2.getBytes());
                } else {
                    byteArrayOutputStream.write(ByteUtils.e(0));
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e11) {
            LogUtil.b(e11.toString());
        }
        return byteArray;
    }

    public static int e(byte[] bArr) {
        int i11 = -1;
        if (bArr == null || bArr.length < 12) {
            LogUtil.b("recv errCode UNKNOWN_ERROR");
        } else {
            f14713c = (long) bArr.length;
            boolean z11 = true;
            if (ByteUtils.b(bArr, 1, 3) + 8 != bArr.length) {
                LogUtil.b("recv len error");
            } else {
                if (1 != (bArr[5] & 1)) {
                    z11 = false;
                }
                i11 = ByteUtils.b(bArr, 8, 4);
                int length = bArr.length - 12 >= 0 ? bArr.length - 12 : 0;
                if (length <= 0) {
                    f14712b = null;
                } else if (z11) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, 12, bArr2, 0, length);
                    byte[] b11 = GzipUtils.b(bArr2);
                    f14712b = new String(b11, 0, b11.length);
                } else {
                    f14712b = new String(bArr, 12, length);
                }
            }
        }
        LogUtil.a("errCode:" + i11);
        return i11;
    }
}
