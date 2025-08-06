package com.engagelab.privates.common;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObserver;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.core.api.MTReporter;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;
import com.engagelab.privates.push.api.PlatformTokenMessage;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.google.common.base.Ascii;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONObject;

public class o extends l {

    /* renamed from: c  reason: collision with root package name */
    public static volatile o f64972c;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMap<Long, PlatformTokenMessage> f64973b = new ConcurrentHashMap();

    public static o b() {
        if (f64972c == null) {
            synchronized (o.class) {
                f64972c = new o();
            }
        }
        return f64972c;
    }

    public void a(Context context) {
        MTCommonLog.d("MTPlatformBusiness", "on_tcp_connected init");
        try {
            int b11 = u.b(context);
            MTCommonLog.d("MTPlatformBusiness", "lastFrom:" + b11);
            if (b11 > 0) {
                String a11 = u.a(context);
                if (!TextUtils.isEmpty(a11)) {
                    String[] split = a11.split("_");
                    byte parseByte = Byte.parseByte(split[0]);
                    int intValue = Integer.valueOf(split[1]).intValue();
                    int intValue2 = Integer.valueOf(split[2]).intValue();
                    MTCommonLog.d("MTPlatformBusiness", "init lastPlatformNode platform=" + parseByte + " code=" + intValue + " m_code=" + intValue2);
                    a(context, parseByte, intValue, intValue2, "");
                    u.a(context, "");
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTPlatformBusiness", "lastFrom failed " + th2.getMessage());
        }
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (!TextUtils.isEmpty(lowerCase)) {
            String countryCode = MTGlobal.getCountryCode(context);
            MTCommonLog.d("MTPlatformBusiness", "manufacturer is " + lowerCase + ", countryCode:" + countryCode);
            b(context);
            d(context, countryCode);
            e(context, lowerCase);
            f(context, lowerCase);
            c(context, lowerCase);
            g(context, lowerCase);
            h(context, lowerCase);
            i(context, lowerCase);
            MTCommonPrivatesApi.sendMessageToMainProcess(context, 3101, (Bundle) null);
        }
    }

    public final void c(Context context, String str) {
        if (TextUtils.equals(str, "xiaomi") || TextUtils.equals(str, MTPushConstants.Manufacturer.BLACKSHARK)) {
            try {
                MTCommonPrivatesApi.observer(context, (MTObserver) Class.forName("com.engagelab.privates.push.platform.mi.global.MTMiGlobal").newInstance());
            } catch (Throwable unused) {
                MTCommonLog.d("MTPlatformBusiness", "not integrated global mi.aar");
                a(context, (byte) 1, 3001, 0, "");
            }
        }
    }

    public final void d(Context context, String str) {
        try {
            if (!TextUtils.equals(str, "CN")) {
                MTCommonPrivatesApi.observer(context, (MTObserver) Class.forName("com.engagelab.privates.push.platform.google.MTGoogle").newInstance());
            }
        } catch (Throwable unused) {
            MTCommonLog.d("MTPlatformBusiness", "not integrated google.aar");
            a(context, (byte) 8, 3001, 0, "");
        }
    }

    public final void e(Context context, String str) {
        if (TextUtils.equals(str, MTPushConstants.Manufacturer.HUAWEI) || TextUtils.equals(str, MTPushConstants.Manufacturer.HONOR)) {
            try {
                MTCommonPrivatesApi.observer(context, (MTObserver) Class.forName("com.engagelab.privates.push.platform.huawei.MTHuawei").newInstance());
            } catch (Throwable unused) {
                MTCommonLog.d("MTPlatformBusiness", "not integrated huawei.aar");
                a(context, (byte) 2, 3001, 0, "");
            }
        }
    }

    public final void f(Context context, String str) {
        if (TextUtils.equals(str, "xiaomi") || TextUtils.equals(str, MTPushConstants.Manufacturer.BLACKSHARK)) {
            try {
                MTCommonPrivatesApi.observer(context, (MTObserver) Class.forName("com.engagelab.privates.push.platform.mi.MTMi").newInstance());
            } catch (Throwable unused) {
                MTCommonLog.d("MTPlatformBusiness", "not integrated mi.aar");
                a(context, (byte) 1, 3001, 0, "");
            }
        }
    }

    public final void g(Context context, String str) {
        if (TextUtils.equals(str, MTPushConstants.Manufacturer.MEIZU)) {
            try {
                MTCommonPrivatesApi.observer(context, (MTObserver) Class.forName("com.engagelab.privates.push.platform.meizu.MTMeizu").newInstance());
            } catch (Throwable unused) {
                MTCommonLog.d("MTPlatformBusiness", "not integrated meizu.aar");
                a(context, (byte) 3, 3001, 0, "");
            }
        }
    }

    public final void h(Context context, String str) {
        if (TextUtils.equals(str, MTPushConstants.Manufacturer.OPPO) || TextUtils.equals(str, MTPushConstants.Manufacturer.REALME) || TextUtils.equals(str, MTPushConstants.Manufacturer.ONEPLUS)) {
            try {
                MTCommonPrivatesApi.observer(context, (MTObserver) Class.forName("com.engagelab.privates.push.platform.oppo.MTOppo").newInstance());
            } catch (Throwable unused) {
                MTCommonLog.d("MTPlatformBusiness", "not integrated oppo.aar");
                a(context, (byte) 4, 3001, 0, "");
            }
        }
    }

    public final void i(Context context, String str) {
        if (TextUtils.equals(str, "vivo")) {
            try {
                MTCommonPrivatesApi.observer(context, (MTObserver) Class.forName("com.engagelab.privates.push.platform.vivo.MTVivo").newInstance());
            } catch (Throwable unused) {
                MTCommonLog.d("MTPlatformBusiness", "not integrated vivo.aar");
                a(context, (byte) 5, 3001, 0, "");
            }
        }
    }

    public final void b(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            if (notificationManager.getNotificationChannel("MTPush_Private") == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("MTPush_Private", "Notification", 3));
            }
        }
    }

    public void c(Context context, Bundle bundle) {
        long rid = ((MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL)).getRid();
        if (this.f64973b.containsKey(Long.valueOf(rid))) {
            PlatformTokenMessage platformTokenMessage = (PlatformTokenMessage) this.f64973b.get(Long.valueOf(rid));
            this.f64973b.remove(Long.valueOf(rid));
            byte platform = platformTokenMessage.getPlatform();
            String token = platformTokenMessage.getToken();
            MTCommonLog.d("MTPlatformBusiness", "onPlatformTokenFailed, rid:" + rid + ", platformToken:" + platformTokenMessage.toString());
            if (TextUtils.equals(token, t.b(context, platform))) {
                MTCommonLog.d("MTPlatformBusiness", "no need update platform state");
                a(context, platform, 3006, 0, token);
                return;
            }
            byte platformState = (byte) (MTCoreGlobal.getPlatformState(context) | platform);
            byte b11 = (byte) (platform == 8 ? platformState & 223 : platformState | 128);
            MTCommonLog.d("MTPlatformBusiness", "set platform state:" + b11);
            MTCoreGlobal.setPlatformState(context, b11);
            a(context, platform, 3006, 0, token);
        }
    }

    public void d(Context context, Bundle bundle) {
        MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL);
        long rid = mTProtocol.getRid();
        short s11 = ByteBuffer.wrap(mTProtocol.getBody()).getShort();
        if (!this.f64973b.containsKey(Long.valueOf(rid))) {
            MTCommonLog.d("MTPlatformBusiness", "onPlatformTokenFailed, rid:" + rid + ", internal error");
            return;
        }
        PlatformTokenMessage platformTokenMessage = (PlatformTokenMessage) this.f64973b.get(Long.valueOf(rid));
        this.f64973b.remove(Long.valueOf(rid));
        byte platform = platformTokenMessage.getPlatform();
        String token = platformTokenMessage.getToken();
        if (s11 != 0) {
            MTCommonLog.d("MTPlatformBusiness", "onPlatformTokenFailed, rid:" + rid + ", code:" + s11);
            a(context, platform, 3006, s11, token);
            return;
        }
        MTCommonLog.d("MTPlatformBusiness", "onPlatformTokenSuccess, rid:" + rid + ", platformToken:" + platformTokenMessage.toString());
        if (TextUtils.equals(token, t.b(context, platform))) {
            MTCommonLog.d("MTPlatformBusiness", "no need update platform state");
            a(context, platform, MTPushConstants.PlatformNode.CODE_UPLOAD_TOKEN_SUCCESS, 0, token);
            return;
        }
        t.a(context, platform, token);
        byte platformState = (byte) (MTCoreGlobal.getPlatformState(context) | platform);
        byte b11 = (byte) (platform == 8 ? platformState | 32 : platformState & Ascii.DEL);
        MTCommonLog.d("MTPlatformBusiness", "set platform state:" + b11);
        MTCoreGlobal.setPlatformState(context, b11);
        a(context, platform, MTPushConstants.PlatformNode.CODE_UPLOAD_TOKEN_SUCCESS, 0, token);
    }

    public void e(Context context, Bundle bundle) {
        MTCommonReceiver commonReceiver;
        PlatformTokenMessage platformTokenMessage = (PlatformTokenMessage) bundle.getParcelable("message");
        if (platformTokenMessage != null && (commonReceiver = MTGlobal.getCommonReceiver(context)) != null) {
            String token = platformTokenMessage.getToken();
            t.a(context, platformTokenMessage.getPlatform(), token);
            MTCommonLog.e("MTPlatformBusiness", "processMainToken:" + token);
            commonReceiver.onPlatformToken(context, platformTokenMessage);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTPushConstants.RemoteWhat.ON_PLATFORM_TOKEN, bundle);
        }
    }

    public void f(Context context, Bundle bundle) {
        bundle.setClassLoader(PlatformTokenMessage.class.getClassLoader());
        PlatformTokenMessage platformTokenMessage = (PlatformTokenMessage) bundle.getParcelable("message");
        long rid = MTCoreGlobal.getRid();
        this.f64973b.put(Long.valueOf(rid), platformTokenMessage);
        MTCommonLog.e("MTPlatformBusiness", "send platformToken, rid:" + rid + ", platformToken:" + platformTokenMessage.toString());
        MTProtocol threadName = new MTProtocol().setRid(rid).setCommand(27).setVersion(2).setBody(v.a(platformTokenMessage.getPlatform(), platformTokenMessage.getToken(), platformTokenMessage.getRegion())).setThreadName("ENGAGELAB-PRIVATES-PUSH");
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, threadName);
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.UPLOAD, bundle2);
    }

    public void b(Context context, Bundle bundle) {
        try {
            byte b11 = bundle.getByte("platform");
            int i11 = bundle.getInt("code");
            int i12 = bundle.getInt(MTPushConstants.PlatformNode.KEY_M_CODE);
            int i13 = bundle.getInt("type");
            int i14 = bundle.getInt("from");
            String b12 = t.b(context, b11);
            MTCommonLog.d("MTPlatformBusiness", "onPlatformNode platform=" + b11 + " code=" + i11 + " m_code=" + i12 + " mToken=" + b12 + " type=" + i13 + " currentFrom=" + i14);
            if (3900 == i13) {
                int b13 = u.b(context);
                int i15 = b13 ^ i14;
                if (i15 == 3) {
                    MTCommonLog.d("MTPlatformBusiness", "onTokenFailed, all method obtain orFrom=" + i15 + " lastFrom=" + b13 + " currentFrom=" + i14);
                    a(context, b11, 3005, i12, b12);
                    u.a(context, 0);
                    u.a(context, "");
                    return;
                }
                u.a(context, i14);
                u.a(context, b11 + "_" + i11 + "_" + i12);
                MTCommonLog.d("MTPlatformBusiness", "oneTokenFailed, one method obtain, orFrom=" + i15 + " lastFrom=" + b13 + " currentFrom=" + i14);
                return;
            }
            a(context, b11, i11, i12, b12);
            if (3901 == i13) {
                u.a(context, 0);
                u.a(context, "");
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTPlatformBusiness", "reportPlatformNode failed " + th2.getMessage());
        }
    }

    public final void a(Context context, byte b11, int i11, int i12, String str) {
        try {
            byte platformState = MTCoreGlobal.getPlatformState(context);
            String countryCode = MTGlobal.getCountryCode(context);
            String str2 = Build.PRODUCT;
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            String str3 = Build.VERSION.RELEASE;
            String a11 = a(context, lowerCase);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", b11);
            jSONObject.put("code", i11);
            jSONObject.put("m_code", i12);
            jSONObject.put("m_flag", platformState);
            jSONObject.put("m_token", str);
            jSONObject.put("country_code", countryCode);
            jSONObject.put("product", str2);
            jSONObject.put("manufacturer", lowerCase);
            jSONObject.put("system_version", str3);
            jSONObject.put("m_system_version", a11);
            MTReporter content = new MTReporter().setType("platform_node").setContent(jSONObject.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, content);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.REPORT, bundle);
        } catch (Throwable th2) {
            MTCommonLog.w("MTPlatformBusiness", "reportPlatformNode failed " + th2.getMessage());
        }
    }

    public final String b(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod("get", new Class[]{String.class}).invoke(loadClass, new Object[]{str});
        } catch (Throwable th2) {
            MTCommonLog.w("MTPlatformBusiness", "getPropertiesStringValue failed " + th2.getMessage());
            return "";
        }
    }

    public final String a(Context context, String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1619859642:
                if (str.equals(MTPushConstants.Manufacturer.BLACKSHARK)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1320380160:
                if (str.equals(MTPushConstants.Manufacturer.ONEPLUS)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1206476313:
                if (str.equals(MTPushConstants.Manufacturer.HUAWEI)) {
                    c11 = 2;
                    break;
                }
                break;
            case -934971466:
                if (str.equals(MTPushConstants.Manufacturer.REALME)) {
                    c11 = 3;
                    break;
                }
                break;
            case -759499589:
                if (str.equals("xiaomi")) {
                    c11 = 4;
                    break;
                }
                break;
            case 3418016:
                if (str.equals(MTPushConstants.Manufacturer.OPPO)) {
                    c11 = 5;
                    break;
                }
                break;
            case 3620012:
                if (str.equals("vivo")) {
                    c11 = 6;
                    break;
                }
                break;
            case 99462250:
                if (str.equals(MTPushConstants.Manufacturer.HONOR)) {
                    c11 = 7;
                    break;
                }
                break;
            case 103777484:
                if (str.equals(MTPushConstants.Manufacturer.MEIZU)) {
                    c11 = 8;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return b(context, "ro.joyui.ui.version.code");
            case 1:
                String b11 = b(context, "ro.rom.version");
                return TextUtils.isEmpty(b11) ? b(context, "ro.build.version.opporom") : b11;
            case 2:
                String b12 = b(context, "ro.build.version.emui");
                return TextUtils.isEmpty(b12) ? b(context, "hw_sc.build.platform.version") : b12;
            case 3:
                return b(context, "ro.build.version.realmeui");
            case 4:
                return b(context, "ro.miui.ui.version.name");
            case 5:
                return b(context, "ro.build.version.opporom");
            case 6:
                return b(context, "ro.vivo.os.build.display.id");
            case 7:
                return b(context, "ro.build.version.magic");
            case 8:
                return b(context, "ro.flyme.version.id");
            default:
                return "";
        }
    }
}
