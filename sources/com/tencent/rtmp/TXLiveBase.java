package com.tencent.rtmp;

import android.content.Context;
import com.tencent.liteav.LiveSettingJni;
import com.tencent.liteav.TXLiteAVExternalDecoderFactoryInterface;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.HttpDnsUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.liteav.videoconsumer.decoder.ExternalDecodeFactoryManager;
import java.util.List;

public class TXLiveBase {
    private static final String TAG = "TXLiveBase";
    private static TXLiveBase instance = new TXLiveBase();
    private static c networkTimeCallback = new c((byte) 0);
    /* access modifiers changed from: private */
    public static TXLiveBaseListener sListener;

    public static class b implements LiteavLog.a {
        private b() {
        }

        public final void a(int i11, String str, String str2) {
            TXLiveBaseListener access$100 = TXLiveBase.sListener;
            if (access$100 != null) {
                access$100.onLog(i11, str, str2);
            }
        }

        public /* synthetic */ b(byte b11) {
            this();
        }
    }

    public static class c implements CommonUtil.a {
        private c() {
        }

        public final void a(int i11, String str) {
            TXLiveBase.onUpdateNetworkTime(i11, str);
        }

        public /* synthetic */ c(byte b11) {
            this();
        }
    }

    static {
        if (r.a()) {
            CommonUtil.setUpdateNetworkTimeCallback(networkTimeCallback);
        }
    }

    private TXLiveBase() {
    }

    public static void enableCustomHttpDNS(boolean z11) {
        if (z11) {
            HttpDnsUtil.enableCustomHttpDNS(true, new HttpDnsUtil.a() {
                public final void a(String str, List<String> list) {
                    if (TXLiveBase.sListener != null) {
                        TXLiveBase.sListener.onCustomHttpDNS(str, list);
                    }
                }
            });
        } else {
            HttpDnsUtil.enableCustomHttpDNS(false, (HttpDnsUtil.a) null);
        }
    }

    public static TXLiveBase getInstance() {
        return instance;
    }

    public static long getNetworkTimestamp() {
        return CommonUtil.getNetworkTimestamp();
    }

    public static String getPituSDKVersion() {
        return "";
    }

    public static String getSDKVersionStr() {
        return CommonUtil.getSDKVersionStr();
    }

    public static boolean isLibraryPathValid(String str) {
        return false;
    }

    public static void onUpdateNetworkTime(int i11, String str) {
        TXLiveBaseListener tXLiveBaseListener = sListener;
        if (tXLiveBaseListener != null) {
            tXLiveBaseListener.onUpdateNetworkTime(i11, str);
        }
    }

    public static void setAppID(String str) {
        LiveSettingJni.setAppId(str);
    }

    public static void setAppVersion(String str) {
        LiteavLog.i(TAG, "Set app version:".concat(String.valueOf(str)));
        LiveSettingJni.setAppVersion(str);
    }

    public static void setConsoleEnabled(boolean z11) {
        LiteavLog.nativeSetConsoleLogEnabled(z11);
    }

    public static boolean setExtID(String str, String str2) {
        return LiteavSystemInfo.setExtID(str, str2);
    }

    public static void setExternalDecoderFactory(TXLiteAVExternalDecoderFactoryInterface tXLiteAVExternalDecoderFactoryInterface) {
        LiteavLog.i(TAG, "Set external decoder factory. factory:".concat(String.valueOf(tXLiteAVExternalDecoderFactoryInterface)));
        if (tXLiteAVExternalDecoderFactoryInterface == null) {
            ExternalDecodeFactoryManager.a((com.tencent.liteav.videoconsumer.decoder.b) null);
        } else {
            ExternalDecodeFactoryManager.a(new a(tXLiteAVExternalDecoderFactoryInterface));
        }
    }

    public static int setGlobalEnv(String str) {
        return CommonUtil.setGlobalEnv(str);
    }

    public static boolean setLibraryPath(String str) {
        r.b(str);
        boolean a11 = r.a();
        if (a11) {
            CommonUtil.setUpdateNetworkTimeCallback(networkTimeCallback);
        }
        return a11;
    }

    public static void setListener(TXLiveBaseListener tXLiveBaseListener) {
        boolean z11 = false;
        LiteavLog.setCallback(new b((byte) 0));
        if (tXLiveBaseListener != null) {
            z11 = true;
        }
        LiteavLog.nativeSetLogCallbackEnabled(z11);
        sListener = tXLiveBaseListener;
    }

    public static void setLogLevel(int i11) {
        LiteavLog.b bVar = LiteavLog.b.kAll;
        if (i11 == 2) {
            bVar = LiteavLog.b.kInfo;
        } else if (i11 == 3) {
            bVar = LiteavLog.b.kWarning;
        } else if (i11 == 4) {
            bVar = LiteavLog.b.kError;
        } else if (i11 == 5) {
            bVar = LiteavLog.b.kFatal;
        } else if (i11 == 6) {
            bVar = LiteavLog.b.kNone;
        }
        LiteavLog.nativeSetLogLevel(bVar.mNativeValue);
    }

    public static void setPituLicencePath(String str) {
    }

    public static void setUserId(String str) {
        LiveSettingJni.setUserId(str);
    }

    public static int updateNetworkTime() {
        return CommonUtil.updateNetworkTime();
    }

    public String getLicenceInfo(Context context) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        return LicenseChecker.getInstance().getLicense(LicenseChecker.c.LIVE);
    }

    public void setLicence(Context context, String str, String str2) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        LicenseChecker.getInstance().setListener(new LicenseChecker.b() {
            public final void a(int i11, String str) {
                TXLiveBaseListener access$100 = TXLiveBase.sListener;
                if (access$100 != null) {
                    access$100.onLicenceLoaded(i11, str);
                }
            }
        });
        LicenseChecker.getInstance().setLicense(LicenseChecker.c.LIVE, str, str2);
    }

    public static class a implements com.tencent.liteav.videoconsumer.decoder.b {

        /* renamed from: a  reason: collision with root package name */
        private TXLiteAVExternalDecoderFactoryInterface f48602a;

        public a(TXLiteAVExternalDecoderFactoryInterface tXLiteAVExternalDecoderFactoryInterface) {
            this.f48602a = tXLiteAVExternalDecoderFactoryInterface;
        }

        public final long a() {
            long createHevcDecoder = this.f48602a.createHevcDecoder();
            LiteavLog.i("ExternalDecoderWrapper", "Create external hevc decoder. decoder:".concat(String.valueOf(createHevcDecoder)));
            return createHevcDecoder;
        }

        public final void a(long j11) {
            LiteavLog.i("ExternalDecoderWrapper", "Destroy external hevc decoder. handler:".concat(String.valueOf(j11)));
            this.f48602a.destroyHevcDecoder(j11);
        }
    }
}
