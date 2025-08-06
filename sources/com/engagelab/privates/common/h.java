package com.engagelab.privates.common;

import android.content.Context;
import android.os.Build;
import com.engagelab.privates.common.cache.MTCommonConfig;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObservable;
import com.engagelab.privates.common.observer.MTObserver;
import com.engagelab.privates.common.utils.DeviceUtil;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.common.utils.SystemUtil;
import com.engagelab.privates.core.api.Outputer;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.Iterator;

public class h {
    public static int a(Context context, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        short s11 = wrap.getShort();
        g.a(context, (int) s11);
        if (s11 == 0) {
            int i11 = wrap.getInt();
            wrap.getShort();
            StringUtil.getTlv2(wrap);
            int i12 = wrap.getInt();
            wrap.get();
            g.c(context, i11);
            g.a(context, (long) i12);
            MTCommonLog.d("MTCoreProtocol", "onLoginSuccess seedId:" + i11 + ", serverTime:" + i12);
        } else if (s11 != 108) {
            String tlv2 = StringUtil.getTlv2(wrap);
            MTCommonLog.e("MTCoreProtocol", "login failed code:" + s11 + ", message:" + tlv2);
        } else {
            g.b(context, 0);
            g.b(context, "");
            g.a(context, "");
            g.c(context, 0);
            g.a(context, 0);
            MTCommonLog.e("MTCoreProtocol", "onLoginFailed, will re-register");
        }
        return s11;
    }

    public static int b(Context context, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        short s11 = wrap.getShort();
        g.b(context, (int) s11);
        if (s11 != 0) {
            String tlv2 = StringUtil.getTlv2(wrap);
            MTCommonLog.e("MTCoreProtocol", "onRegisterFailed code:" + s11 + ", message:" + tlv2);
        } else {
            long j11 = wrap.getLong();
            String tlv22 = StringUtil.getTlv2(wrap);
            String tlv23 = StringUtil.getTlv2(wrap);
            g.b(context, j11);
            g.b(context, tlv23);
            g.a(context, tlv22);
            MTCommonLog.d("MTCoreProtocol", "onRegisterSuccess uid:" + j11 + ", registrationId:" + tlv23 + ", password:" + tlv22);
        }
        return s11;
    }

    public static byte[] c(Context context) {
        Outputer outputer = new Outputer(1);
        outputer.writeU8(c());
        return outputer.toByteArray();
    }

    public static byte[] d(Context context) {
        String md5 = StringUtil.toMD5(g.d(context));
        String a11 = a();
        String str = StringUtil.get32MD5String(MTGlobal.getAppKey(context));
        short c11 = c();
        byte e11 = g.e(context);
        int networkType = MTGlobal.getNetworkType();
        String deviceId = MTCommonConfig.getDeviceId(context);
        String countryCode = MTGlobal.getCountryCode(context);
        MTCommonLog.e("MTCoreProtocol", "login with uid:" + g.m(context) + ", registrationId:" + g.g(context) + ", platform:" + e11);
        byte[] bytes = md5.getBytes();
        byte[] bytes2 = a11.getBytes();
        byte[] bytes3 = str.getBytes();
        byte[] bytes4 = deviceId.getBytes();
        byte[] bytes5 = "".getBytes();
        byte[] bytes6 = countryCode.getBytes();
        byte[] bytes7 = "".getBytes();
        Outputer outputer = new Outputer(bytes.length + 4 + bytes2.length + bytes3.length + 1 + 4 + 1 + 1 + bytes4.length + bytes5.length + bytes6.length + bytes7.length);
        outputer.writeU8(97);
        outputer.writeU8(0);
        outputer.writeU16(0);
        outputer.writeByteArrayIncludeLength(bytes);
        outputer.writeByteArrayIncludeLength(bytes2);
        outputer.writeByteArrayIncludeLength(bytes3);
        outputer.writeU8(0);
        outputer.writeU32((long) c11);
        outputer.writeU8(e11);
        outputer.writeU8(networkType);
        outputer.writeByteArrayIncludeLength(bytes4);
        outputer.writeByteArrayIncludeLength(bytes5);
        outputer.writeByteArrayIncludeLength(bytes6);
        outputer.writeByteArrayIncludeLength(bytes7);
        return outputer.toByteArray();
    }

    public static byte[] e(Context context) {
        g.b(context, 0);
        g.b(context, "");
        g.a(context, "");
        g.c(context, 0);
        g.a(context, 0);
        String str = " $$ $$" + context.getPackageName() + "$$" + MTGlobal.getAppKey(context);
        String appVersionName = MTGlobal.getAppVersionName(context);
        String a11 = a(context);
        String b11 = b(context);
        short c11 = c();
        MTCommonLog.d("MTCoreProtocol", "register with clientInfo:" + a11 + ", deviceInfo:" + b11);
        byte[] bytes = str.getBytes();
        byte[] bytes2 = appVersionName.getBytes();
        byte[] bytes3 = a11.getBytes();
        byte[] bytes4 = b11.getBytes();
        byte[] bytes5 = "".getBytes();
        Outputer outputer = new Outputer(bytes.length + bytes2.length + bytes3.length + 1 + bytes4.length + 4 + bytes5.length);
        outputer.writeByteArrayIncludeLength(bytes);
        outputer.writeByteArrayIncludeLength(bytes2);
        outputer.writeByteArrayIncludeLength(bytes3);
        outputer.writeU8(0);
        outputer.writeByteArrayIncludeLength(bytes4);
        outputer.writeU32((long) c11);
        outputer.writeByteArrayIncludeLength(bytes5);
        return outputer.toByteArray();
    }

    public static short c() {
        int sdkPriority;
        Iterator<MTObserver> it2 = MTObservable.getInstance().observeQueue.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            MTObserver next = it2.next();
            if (next.isSdk() && i11 < (sdkPriority = next.getSdkPriority())) {
                i11 = sdkPriority;
            }
        }
        short s11 = 0;
        for (int i12 = 0; i12 <= i11; i12++) {
            Iterator<MTObserver> it3 = MTObservable.getInstance().observeQueue.iterator();
            while (it3.hasNext()) {
                MTObserver next2 = it3.next();
                if (next2.isSdk() && next2.getSdkPriority() == i12) {
                    s11 = (short) (s11 | next2.getSdkFlag());
                }
            }
        }
        return s11;
    }

    public static String b(Context context) {
        String deviceId = MTGlobal.getDeviceId(context);
        return "0$$" + deviceId + "$$ $$ $$ $$ ";
    }

    public static String b() {
        int sdkPriority;
        Iterator<MTObserver> it2 = MTObservable.getInstance().observeQueue.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            MTObserver next = it2.next();
            if (next.isSdk() && i11 < (sdkPriority = next.getSdkPriority())) {
                i11 = sdkPriority;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 <= i11; i12++) {
            Iterator<MTObserver> it3 = MTObservable.getInstance().observeQueue.iterator();
            while (it3.hasNext()) {
                MTObserver next2 = it3.next();
                if (next2.isSdk() && next2.getSdkPriority() == i12) {
                    sb2.append(next2.getSdkVersion());
                    sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                }
            }
        }
        return sb2.substring(0, sb2.length() - 1);
    }

    public static String a(Context context) {
        return Build.VERSION.RELEASE.toLowerCase() + Constants.ACCEPT_TIME_SEPARATOR_SP + Build.VERSION.SDK_INT + "$$" + Build.MODEL.toLowerCase() + "$$" + "" + "$$" + Build.DEVICE.toLowerCase() + "$$" + MTGlobal.getAppChannel(context) + "$$" + b() + "$$" + SystemUtil.isSystemApp(context) + "$$" + DeviceUtil.getResolution(context) + "$$" + Build.MANUFACTURER.toLowerCase();
    }

    public static String a() {
        int sdkPriority;
        Iterator<MTObserver> it2 = MTObservable.getInstance().observeQueue.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            MTObserver next = it2.next();
            if (next.isSdk() && i11 < (sdkPriority = next.getSdkPriority())) {
                i11 = sdkPriority;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 1; i12 <= i11; i12++) {
            Iterator<MTObserver> it3 = MTObservable.getInstance().observeQueue.iterator();
            while (it3.hasNext()) {
                MTObserver next2 = it3.next();
                if (next2.isSdk() && next2.getSdkPriority() == i12) {
                    String[] split = next2.getSdkVersion().split("\\.");
                    sb2.append((Integer.parseInt(split[0]) << 16) + (Integer.parseInt(split[1]) << 8) + Integer.parseInt(split[2]));
                }
            }
        }
        return sb2.toString();
    }
}
