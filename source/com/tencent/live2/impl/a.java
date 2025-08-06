package com.tencent.live2.impl;

import android.content.Context;
import com.tencent.liteav.LiveSettingJni;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.live.V2TXLivePremierJni;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePremier;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0178a f22719a = new C0178a();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static V2TXLivePremier.V2TXLivePremierObserver f22720b;

    /* renamed from: com.tencent.live2.impl.a$a  reason: collision with other inner class name */
    public static final class C0178a implements LiteavLog.a {

        /* renamed from: a  reason: collision with root package name */
        public V2TXLivePremier.V2TXLivePremierObserver f22721a;

        public final void a(int i11, String str, String str2) {
            V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = this.f22721a;
            if (v2TXLivePremierObserver != null) {
                v2TXLivePremierObserver.onLog(i11, str2);
            }
        }
    }

    public static String a() {
        return CommonUtil.getSDKVersionStr();
    }

    public static int c(String str) {
        return V2TXLivePremierJni.callExperimentalAPI(str);
    }

    public static void a(V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver) {
        f22720b = v2TXLivePremierObserver;
        f22719a.f22721a = v2TXLivePremierObserver;
        V2TXLivePremierJni.setObserver(v2TXLivePremierObserver);
    }

    public static void b(boolean z11, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        V2TXLivePremierJni.enableAudioPlayoutObserver(z11, v2TXLiveAudioFrameObserverFormat);
    }

    public static void b(String str) {
        LiveSettingJni.setUserId(str);
    }

    public static void a(V2TXLiveDef.V2TXLiveLogConfig v2TXLiveLogConfig) {
        LiteavLog.b bVar;
        if (v2TXLiveLogConfig != null) {
            LiteavLog.nativeSetConsoleLogEnabled(v2TXLiveLogConfig.enableConsole);
            LiteavLog.nativeSetLogToFileEnabled(v2TXLiveLogConfig.enableLogFile);
            String str = v2TXLiveLogConfig.logPath;
            if (str != null) {
                LiteavLog.nativeSetLogFilePath(str);
            }
            int i11 = v2TXLiveLogConfig.logLevel;
            if (i11 == 2) {
                bVar = LiteavLog.b.kInfo;
            } else if (i11 == 3) {
                bVar = LiteavLog.b.kWarning;
            } else if (i11 == 4) {
                bVar = LiteavLog.b.kError;
            } else if (i11 == 5) {
                bVar = LiteavLog.b.kFatal;
            } else if (i11 != 6) {
                bVar = LiteavLog.b.kAll;
            } else {
                bVar = LiteavLog.b.kNone;
            }
            LiteavLog.nativeSetLogLevel(bVar.mNativeValue);
            C0178a aVar = f22719a;
            boolean z11 = v2TXLiveLogConfig.enableObserver;
            if (!z11) {
                aVar = null;
            }
            LiteavLog.setCallback(aVar);
            LiteavLog.nativeSetLogCallbackEnabled(z11);
        }
    }

    public static void a(String str) {
        CommonUtil.setGlobalEnv(str);
    }

    public static void a(Context context, String str, String str2) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        LicenseChecker.getInstance().setListener(new LicenseChecker.b() {
            public final void a(int i11, String str) {
                V2TXLivePremier.V2TXLivePremierObserver b11 = a.f22720b;
                if (b11 != null) {
                    b11.onLicenceLoaded(i11, str);
                }
            }
        });
        LicenseChecker.getInstance().setLicense(LicenseChecker.c.LIVE, str, str2);
    }

    public static void a(String str, int i11, String str2, String str3, V2TXLiveDef.V2TXLiveSocks5ProxyConfig v2TXLiveSocks5ProxyConfig) {
        CommonUtil.setSocks5Proxy(str, i11, str2, str3, v2TXLiveSocks5ProxyConfig.supportHttps, v2TXLiveSocks5ProxyConfig.supportTcp, v2TXLiveSocks5ProxyConfig.supportUdp);
    }

    public static void a(boolean z11, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        V2TXLivePremierJni.enableAudioCaptureObserver(z11, v2TXLiveAudioFrameObserverFormat);
    }

    public static void a(boolean z11) {
        V2TXLivePremierJni.enableVoiceEarMonitorObserver(z11);
    }
}
