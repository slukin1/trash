package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.WindowManager;
import com.adjust.sdk.Constants;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFLogger;
import com.appsflyer.AFVersionDeclaration;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.ag;
import com.appsflyer.internal.ao;
import com.appsflyer.internal.bt;
import com.appsflyer.internal.d;
import com.appsflyer.internal.l;
import com.appsflyer.internal.v;
import com.appsflyer.internal.y;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.framework.common.ContainerUtils;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.NetworkInterface;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae extends AppsFlyerLib {
    public static final String AFInAppEventParameterName = "113";
    public static final String AFInAppEventType = "6.3";
    public static final String AFKeystoreWrapper;
    private static String onAppOpenAttribution = null;
    private static String onAttributionFailure = null;
    private static String onAttributionFailureNative = null;
    private static String onConversionDataFail = null;
    private static ae onConversionDataSuccess = new ae();
    private static final String onDeepLinkingNative;
    private static String onInstallConversionDataLoadedNative = null;
    private static String onInstallConversionFailureNative = "https://%sstats.%s/stats";
    public static AppsFlyerConversionListener valueOf = null;
    public static AppsFlyerInAppPurchaseValidatorListener values = null;
    public String AFLogger$LogLevel;
    public long AFVersionDeclaration;
    public String AppsFlyer2dXConversionCallback;
    /* access modifiers changed from: private */
    public long AppsFlyerConversionListener;
    private long AppsFlyerInAppPurchaseValidatorListener = -1;
    private long AppsFlyerLib = TimeUnit.SECONDS.toMillis(5);
    private final al enableLocationCollection = new al();
    private Map<Long, String> getInstance;
    public String[] getLevel;
    private boolean getOutOfStore = false;
    private boolean getSdkVersion = false;
    public au init;
    public bt[] onAppOpenAttributionNative;
    private long onDeepLinking = -1;
    private boolean onPause;
    /* access modifiers changed from: private */
    public boolean onValidateInApp = false;
    /* access modifiers changed from: private */
    public ScheduledExecutorService onValidateInAppFailure = null;
    private SharedPreferences sendPushNotificationData;
    private av setAdditionalData;
    private boolean setAndroidIdData = false;
    private final Executor setAppInviteOneLink = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public Map<String, Object> setCustomerIdAndLogSession;
    private String setCustomerUserId;
    private boolean setDebugLog;
    /* access modifiers changed from: private */
    public Application setImeiData;
    private boolean setOaidData = false;
    private boolean setPhoneNumber = false;
    /* access modifiers changed from: private */
    public final JSONObject setUserEmails = new JSONObject();
    /* access modifiers changed from: private */
    public long stop;
    private String updateServerUninstallToken;
    /* access modifiers changed from: private */
    public Map<String, Object> waitForCustomerUserId;

    /* renamed from: com.appsflyer.internal.ae$9  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] AFInAppEventType;
        public static final /* synthetic */ int[] valueOf;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                com.appsflyer.internal.bt$e[] r0 = com.appsflyer.internal.bt.e.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                valueOf = r0
                r1 = 1
                com.appsflyer.internal.bt$e r2 = com.appsflyer.internal.bt.e.FINISHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = valueOf     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.internal.bt$e r3 = com.appsflyer.internal.bt.e.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r2 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                AFInAppEventType = r2
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r3 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = AFInAppEventType     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r2 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ae.AnonymousClass9.<clinit>():void");
        }
    }

    public class c implements Runnable {
        private final g AFInAppEventParameterName;

        public /* synthetic */ c(ae aeVar, g gVar, byte b11) {
            this(gVar);
        }

        public final void run() {
            ae.AFKeystoreWrapper(ae.this, this.AFInAppEventParameterName);
        }

        private c(g gVar) {
            this.AFInAppEventParameterName = gVar;
        }
    }

    public class d implements Runnable {
        private final g AFInAppEventType;

        public /* synthetic */ d(ae aeVar, g gVar, byte b11) {
            this(gVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: byte[]} */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0217, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0218, code lost:
            com.appsflyer.AFLogger.values((java.lang.Throwable) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x0236, code lost:
            r0.onError(com.appsflyer.attribution.RequestError.NETWORK_FAILURE, r12.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x014e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x014f, code lost:
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0.getMessage(), r0);
            r2 = r1.AFInAppEventType.AFKeystoreWrapper;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x015a, code lost:
            if (r2 != null) goto L_0x015c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x015c, code lost:
            r2.onError(com.appsflyer.attribution.RequestError.NETWORK_FAILURE, r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0166, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0167, code lost:
            r12 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x018d, code lost:
            r2.mkdir();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0192, code lost:
            r2 = r2.listFiles();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0196, code lost:
            if (r2 == null) goto L_0x01a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x019d, code lost:
            com.appsflyer.AFLogger.AFKeystoreWrapper("reached cache limit, not caching request");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a4, code lost:
            com.appsflyer.AFLogger.AFKeystoreWrapper("caching request...");
            r2 = new java.io.File(com.appsflyer.internal.ai.AFKeystoreWrapper(r9), java.lang.Long.toString(java.lang.System.currentTimeMillis()));
            r2.createNewFile();
            r4 = new java.io.OutputStreamWriter(new java.io.FileOutputStream(r2.getPath(), true));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            r4.write("version=");
            r4.write(r0.AFKeystoreWrapper);
            r4.write(10);
            r4.write("url=");
            r4.write(r0.AFInAppEventParameterName);
            r4.write(10);
            r4.write("data=");
            r4.write(android.util.Base64.encodeToString(r0.values(), 2));
            r4.write(10);
            r4.flush();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0201, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0202, code lost:
            r2 = r0;
            r3 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0205, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0206, code lost:
            r3 = r4;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x0213 A[SYNTHETIC, Splitter:B:100:0x0213] */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0226 A[SYNTHETIC, Splitter:B:106:0x0226] */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x0236  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x014e A[ExcHandler: all (r0v23 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:32:0x00de] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x018d A[Catch:{ Exception -> 0x020b }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0192 A[Catch:{ Exception -> 0x020b }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r16 = this;
                r1 = r16
                com.appsflyer.internal.g r0 = r1.AFInAppEventType
                java.util.Map r2 = r0.AFInAppEventType()
                com.appsflyer.internal.g r0 = r1.AFInAppEventType
                boolean r0 = r0.AFKeystoreWrapper()
                com.appsflyer.internal.g r3 = r1.AFInAppEventType
                java.lang.String r4 = r3.onAppOpenAttributionNative
                int r5 = r3.onInstallConversionFailureNative
                android.app.Application r9 = r3.valueOf
                com.appsflyer.internal.ae r3 = com.appsflyer.internal.ae.this
                boolean r3 = r3.isStopped()
                if (r3 == 0) goto L_0x002c
                com.appsflyer.internal.g r0 = r1.AFInAppEventType
                com.appsflyer.attribution.AppsFlyerRequestListener r0 = r0.AFKeystoreWrapper
                if (r0 == 0) goto L_0x002b
                int r2 = com.appsflyer.attribution.RequestError.STOP_TRACKING
                java.lang.String r3 = com.appsflyer.internal.ax.values
                r0.onError(r2, r3)
            L_0x002b:
                return
            L_0x002c:
                r3 = 0
                byte[] r6 = new byte[r3]
                r7 = 2
                r8 = 1
                if (r0 == 0) goto L_0x00c6
                if (r5 > r7) goto L_0x00c6
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                com.appsflyer.internal.ae r10 = com.appsflyer.internal.ae.this
                com.appsflyer.internal.bt[] r10 = r10.onAppOpenAttributionNative
                if (r10 == 0) goto L_0x00a8
                com.appsflyer.internal.ae r10 = com.appsflyer.internal.ae.this
                com.appsflyer.internal.bt[] r10 = r10.onAppOpenAttributionNative
                int r11 = r10.length
                r12 = r3
            L_0x004a:
                if (r12 >= r11) goto L_0x00a8
                r13 = r10[r12]
                boolean r14 = r13 instanceof com.appsflyer.internal.bo
                int[] r15 = com.appsflyer.internal.ae.AnonymousClass9.valueOf
                com.appsflyer.internal.bt$e r3 = r13.AFInAppEventParameterName
                int r3 = r3.ordinal()
                r3 = r15[r3]
                if (r3 == r8) goto L_0x0082
                if (r3 == r7) goto L_0x005f
                goto L_0x00a4
            L_0x005f:
                if (r5 != r7) goto L_0x00a4
                if (r14 != 0) goto L_0x00a4
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                java.lang.String r14 = "source"
                java.lang.String r13 = r13.valueOf
                r3.put(r14, r13)
                java.lang.String r13 = "response"
                java.lang.String r14 = "TIMEOUT"
                r3.put(r13, r14)
                com.appsflyer.internal.bu r13 = new com.appsflyer.internal.bu
                r13.<init>()
                r3.putAll(r13)
                r0.add(r3)
                goto L_0x00a4
            L_0x0082:
                if (r14 == 0) goto L_0x009f
                java.lang.String r3 = "rfr"
                r14 = r13
                com.appsflyer.internal.bo r14 = (com.appsflyer.internal.bo) r14
                java.util.Map<java.lang.String, java.lang.Object> r14 = r14.AFInAppEventType
                r2.put(r3, r14)
                android.content.SharedPreferences r3 = com.appsflyer.internal.ae.values((android.content.Context) r9)
                android.content.SharedPreferences$Editor r3 = r3.edit()
                java.lang.String r14 = "newGPReferrerSent"
                android.content.SharedPreferences$Editor r3 = r3.putBoolean(r14, r8)
                r3.apply()
            L_0x009f:
                java.util.Map<java.lang.String, java.lang.Object> r3 = r13.AFKeystoreWrapper
                r0.add(r3)
            L_0x00a4:
                int r12 = r12 + 1
                r3 = 0
                goto L_0x004a
            L_0x00a8:
                boolean r3 = r0.isEmpty()
                if (r3 != 0) goto L_0x00b3
                java.lang.String r3 = "referrers"
                r2.put(r3, r0)
            L_0x00b3:
                com.appsflyer.internal.ae r0 = com.appsflyer.internal.ae.this
                java.util.Map r0 = r0.waitForCustomerUserId
                if (r0 == 0) goto L_0x00c6
                java.lang.String r0 = "fb_ddl"
                com.appsflyer.internal.ae r3 = com.appsflyer.internal.ae.this
                java.util.Map r3 = r3.waitForCustomerUserId
                r2.put(r0, r3)
            L_0x00c6:
                com.appsflyer.internal.g r0 = r1.AFInAppEventType
                boolean r0 = r0 instanceof com.appsflyer.internal.bg
                if (r0 != 0) goto L_0x00dd
                com.appsflyer.internal.d$e r0 = new com.appsflyer.internal.d$e
                r0.<init>(r2, r9)
                r2.putAll(r0)
                com.appsflyer.internal.ae r0 = com.appsflyer.internal.ae.this
                java.util.Map r0 = r0.AFInAppEventParameterName()
                r2.putAll(r0)
            L_0x00dd:
                r3 = 0
                com.appsflyer.internal.g r0 = r1.AFInAppEventType     // Catch:{ IOException -> 0x0166, all -> 0x014e }
                boolean r5 = r0 instanceof com.appsflyer.internal.bg     // Catch:{ IOException -> 0x0166, all -> 0x014e }
                if (r5 == 0) goto L_0x00ed
                java.lang.String r5 = "af_key"
                java.lang.Object r5 = r2.get(r5)     // Catch:{ IOException -> 0x0166, all -> 0x014e }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0166, all -> 0x014e }
                goto L_0x00f5
            L_0x00ed:
                java.lang.String r5 = "appsflyerKey"
                java.lang.Object r5 = r2.get(r5)     // Catch:{ IOException -> 0x0166, all -> 0x014e }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0166, all -> 0x014e }
            L_0x00f5:
                r0.AFVersionDeclaration = r5     // Catch:{ IOException -> 0x0166, all -> 0x014e }
                monitor-enter(r2)     // Catch:{ IOException -> 0x0166, all -> 0x014e }
                com.appsflyer.internal.g r0 = r1.AFInAppEventType     // Catch:{ all -> 0x014b }
                java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0142 }
                r10 = 0
                r5[r10] = r0     // Catch:{ all -> 0x0142 }
                int r0 = android.view.ViewConfiguration.getTapTimeout()     // Catch:{ all -> 0x0142 }
                int r0 = r0 >> 16
                int r0 = r0 + 48
                java.lang.String r11 = ""
                int r11 = android.text.TextUtils.getOffsetAfter(r11, r10)     // Catch:{ all -> 0x0142 }
                int r11 = r11 + 24
                int r10 = android.view.ViewConfiguration.getFadingEdgeLength()     // Catch:{ all -> 0x0142 }
                int r10 = r10 >> 16
                char r10 = (char) r10     // Catch:{ all -> 0x0142 }
                java.lang.Object r0 = com.appsflyer.internal.a.AFKeystoreWrapper(r0, r11, r10)     // Catch:{ all -> 0x0142 }
                java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x0142 }
                java.lang.String r10 = "values"
                java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ all -> 0x0142 }
                java.lang.Class<com.appsflyer.internal.g> r12 = com.appsflyer.internal.g.class
                r13 = 0
                r11[r13] = r12     // Catch:{ all -> 0x0142 }
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r10, r11)     // Catch:{ all -> 0x0142 }
                java.lang.Object r0 = r0.invoke(r3, r5)     // Catch:{ all -> 0x0142 }
                r5 = r0
                byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x0142 }
                monitor-exit(r2)     // Catch:{ all -> 0x013f }
                com.appsflyer.internal.ae r0 = com.appsflyer.internal.ae.this     // Catch:{ IOException -> 0x013b, all -> 0x014e }
                com.appsflyer.internal.g r2 = r1.AFInAppEventType     // Catch:{ IOException -> 0x013b, all -> 0x014e }
                r2.AppsFlyer2dXConversionCallback = r5     // Catch:{ IOException -> 0x013b, all -> 0x014e }
                com.appsflyer.internal.ae.valueOf((com.appsflyer.internal.ae) r0, (com.appsflyer.internal.g) r2)     // Catch:{ IOException -> 0x013b, all -> 0x014e }
                return
            L_0x013b:
                r0 = move-exception
                r12 = r0
                r6 = r5
                goto L_0x0168
            L_0x013f:
                r0 = move-exception
                r6 = r5
                goto L_0x014c
            L_0x0142:
                r0 = move-exception
                java.lang.Throwable r5 = r0.getCause()     // Catch:{ all -> 0x014b }
                if (r5 == 0) goto L_0x014a
                throw r5     // Catch:{ all -> 0x014b }
            L_0x014a:
                throw r0     // Catch:{ all -> 0x014b }
            L_0x014b:
                r0 = move-exception
            L_0x014c:
                monitor-exit(r2)     // Catch:{ IOException -> 0x0166, all -> 0x014e }
                throw r0     // Catch:{ IOException -> 0x0166, all -> 0x014e }
            L_0x014e:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()
                com.appsflyer.AFLogger.AFInAppEventParameterName((java.lang.String) r2, (java.lang.Throwable) r0)
                com.appsflyer.internal.g r2 = r1.AFInAppEventType
                com.appsflyer.attribution.AppsFlyerRequestListener r2 = r2.AFKeystoreWrapper
                if (r2 == 0) goto L_0x0165
                int r3 = com.appsflyer.attribution.RequestError.NETWORK_FAILURE
                java.lang.String r0 = r0.getMessage()
                r2.onError(r3, r0)
            L_0x0165:
                return
            L_0x0166:
                r0 = move-exception
                r12 = r0
            L_0x0168:
                java.lang.String r0 = "Exception while sending request to server. "
                com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0, (java.lang.Throwable) r12)
                if (r6 == 0) goto L_0x0230
                if (r9 == 0) goto L_0x0230
                java.lang.String r0 = "&isCachedRequest=true&timeincache="
                boolean r0 = r4.contains(r0)
                if (r0 != 0) goto L_0x0230
                com.appsflyer.internal.ai.AFKeystoreWrapper()
                com.appsflyer.internal.h r0 = new com.appsflyer.internal.h
                java.lang.String r2 = "6.3.2"
                r0.<init>(r4, r6, r2)
                java.io.File r2 = com.appsflyer.internal.ai.AFKeystoreWrapper(r9)     // Catch:{ Exception -> 0x020b }
                boolean r4 = r2.exists()     // Catch:{ Exception -> 0x020b }
                if (r4 != 0) goto L_0x0192
                r2.mkdir()     // Catch:{ Exception -> 0x020b }
                goto L_0x021c
            L_0x0192:
                java.io.File[] r2 = r2.listFiles()     // Catch:{ Exception -> 0x020b }
                if (r2 == 0) goto L_0x01a4
                int r2 = r2.length     // Catch:{ Exception -> 0x020b }
                r4 = 40
                if (r2 <= r4) goto L_0x01a4
                java.lang.String r0 = "reached cache limit, not caching request"
                com.appsflyer.AFLogger.AFKeystoreWrapper(r0)     // Catch:{ Exception -> 0x020b }
                goto L_0x021c
            L_0x01a4:
                java.lang.String r2 = "caching request..."
                com.appsflyer.AFLogger.AFKeystoreWrapper(r2)     // Catch:{ Exception -> 0x020b }
                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x020b }
                java.io.File r4 = com.appsflyer.internal.ai.AFKeystoreWrapper(r9)     // Catch:{ Exception -> 0x020b }
                long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x020b }
                java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ Exception -> 0x020b }
                r2.<init>(r4, r5)     // Catch:{ Exception -> 0x020b }
                r2.createNewFile()     // Catch:{ Exception -> 0x020b }
                java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x020b }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x020b }
                java.lang.String r2 = r2.getPath()     // Catch:{ Exception -> 0x020b }
                r5.<init>(r2, r8)     // Catch:{ Exception -> 0x020b }
                r4.<init>(r5)     // Catch:{ Exception -> 0x020b }
                java.lang.String r2 = "version="
                r4.write(r2)     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                java.lang.String r2 = r0.AFKeystoreWrapper     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                r4.write(r2)     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                r2 = 10
                r4.write(r2)     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                java.lang.String r3 = "url="
                r4.write(r3)     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                java.lang.String r3 = r0.AFInAppEventParameterName     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                r4.write(r3)     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                r4.write(r2)     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                java.lang.String r3 = "data="
                r4.write(r3)     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                byte[] r0 = r0.values()     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                java.lang.String r0 = android.util.Base64.encodeToString(r0, r7)     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                r4.write(r0)     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                r4.write(r2)     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                r4.flush()     // Catch:{ Exception -> 0x0205, all -> 0x0201 }
                r4.close()     // Catch:{ IOException -> 0x0217 }
                goto L_0x021c
            L_0x0201:
                r0 = move-exception
                r2 = r0
                r3 = r4
                goto L_0x0224
            L_0x0205:
                r0 = move-exception
                r3 = r4
                goto L_0x020c
            L_0x0208:
                r0 = move-exception
                r2 = r0
                goto L_0x0224
            L_0x020b:
                r0 = move-exception
            L_0x020c:
                java.lang.String r2 = "Could not cache request"
                com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0208 }
                if (r3 == 0) goto L_0x021c
                r3.close()     // Catch:{ IOException -> 0x0217 }
                goto L_0x021c
            L_0x0217:
                r0 = move-exception
                r2 = r0
                com.appsflyer.AFLogger.values((java.lang.Throwable) r2)
            L_0x021c:
                java.lang.String r0 = r12.getMessage()
                com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0, (java.lang.Throwable) r12)
                goto L_0x0230
            L_0x0224:
                if (r3 == 0) goto L_0x022f
                r3.close()     // Catch:{ IOException -> 0x022a }
                goto L_0x022f
            L_0x022a:
                r0 = move-exception
                r3 = r0
                com.appsflyer.AFLogger.values((java.lang.Throwable) r3)
            L_0x022f:
                throw r2
            L_0x0230:
                com.appsflyer.internal.g r0 = r1.AFInAppEventType
                com.appsflyer.attribution.AppsFlyerRequestListener r0 = r0.AFKeystoreWrapper
                if (r0 == 0) goto L_0x023f
                int r2 = com.appsflyer.attribution.RequestError.NETWORK_FAILURE
                java.lang.String r3 = r12.getMessage()
                r0.onError(r2, r3)
            L_0x023f:
                com.appsflyer.internal.ae r6 = com.appsflyer.internal.ae.this
                com.appsflyer.internal.g r7 = r1.AFInAppEventType
                java.lang.String r8 = r7.AFVersionDeclaration
                android.content.SharedPreferences r10 = com.appsflyer.internal.ae.values((android.content.Context) r9)
                r11 = 0
                com.appsflyer.internal.ba.values(r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ae.d.run():void");
        }

        private d(g gVar) {
            this.AFInAppEventType = gVar;
        }
    }

    public class e implements Runnable {
        private final Application valueOf;

        public e(Context context) {
            this.valueOf = (Application) context.getApplicationContext();
        }

        public final void run() {
            if (!ae.this.onValidateInApp) {
                ae.this.AFVersionDeclaration = System.currentTimeMillis();
                boolean unused = ae.this.onValidateInApp = true;
                try {
                    String AFKeystoreWrapper = ae.AFKeystoreWrapper(AppsFlyerProperties.AF_KEY);
                    ai.AFKeystoreWrapper();
                    for (h next : ai.AFInAppEventParameterName((Context) this.valueOf)) {
                        StringBuilder sb2 = new StringBuilder("resending request: ");
                        sb2.append(next.AFInAppEventParameterName);
                        AFLogger.AFKeystoreWrapper(sb2.toString());
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            long parseLong = Long.parseLong(next.valueOf, 10);
                            ae aeVar = ae.this;
                            be beVar = new be();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(next.AFInAppEventParameterName);
                            sb3.append("&isCachedRequest=true&timeincache=");
                            sb3.append((currentTimeMillis - parseLong) / 1000);
                            g AFInAppEventParameterName2 = beVar.AFInAppEventParameterName(sb3.toString());
                            AFInAppEventParameterName2.AppsFlyer2dXConversionCallback = next.values();
                            AFInAppEventParameterName2.AFVersionDeclaration = AFKeystoreWrapper;
                            Application application = this.valueOf;
                            if (application != null) {
                                AFInAppEventParameterName2.valueOf = (Application) application.getApplicationContext();
                            }
                            AFInAppEventParameterName2.getLevel = next.valueOf;
                            AFInAppEventParameterName2.onAttributionFailureNative = false;
                            ae.valueOf(aeVar, AFInAppEventParameterName2);
                        } catch (Exception e11) {
                            AFLogger.AFInAppEventType("Failed to resend cached request", (Throwable) e11);
                        }
                    }
                } catch (Exception e12) {
                    AFLogger.AFInAppEventType("failed to check cache. ", (Throwable) e12);
                } catch (Throwable th2) {
                    boolean unused2 = ae.this.onValidateInApp = false;
                    throw th2;
                }
                boolean unused3 = ae.this.onValidateInApp = false;
                ae.this.onValidateInAppFailure.shutdown();
                ScheduledExecutorService unused4 = ae.this.onValidateInAppFailure = null;
            }
        }
    }

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AFInAppEventType);
        sb2.append("/androidevent?buildnumber=6.3.2&app_id=");
        AFKeystoreWrapper = sb2.toString();
        StringBuilder sb3 = new StringBuilder("https://%sadrevenue.%s/api/v");
        sb3.append(AFInAppEventType);
        sb3.append("/android?buildnumber=6.3.2&app_id=");
        onInstallConversionDataLoadedNative = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(AFInAppEventType);
        sb4.append("/androidevent?app_id=");
        String obj = sb4.toString();
        onDeepLinkingNative = obj;
        StringBuilder sb5 = new StringBuilder("https://%sconversions.%s/api/v");
        sb5.append(obj);
        onAttributionFailureNative = sb5.toString();
        StringBuilder sb6 = new StringBuilder("https://%slaunches.%s/api/v");
        sb6.append(obj);
        onAppOpenAttribution = sb6.toString();
        StringBuilder sb7 = new StringBuilder("https://%sinapps.%s/api/v");
        sb7.append(obj);
        onConversionDataFail = sb7.toString();
        StringBuilder sb8 = new StringBuilder("https://%sattr.%s/api/v");
        sb8.append(obj);
        onAttributionFailure = sb8.toString();
    }

    public ae() {
        AFVersionDeclaration.init();
    }

    public final void addPushNotificationDeepLinkPath(String... strArr) {
        List asList = Arrays.asList(strArr);
        List<List<String>> list = j.AFInAppEventType().getLevel;
        if (!list.contains(asList)) {
            list.add(asList);
        }
    }

    public final void anonymizeUser(boolean z11) {
        aj.valueOf().AFInAppEventType("public_api_call", "anonymizeUser", String.valueOf(z11));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z11);
    }

    public final void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        j AFInAppEventType2 = j.AFInAppEventType();
        AFInAppEventType2.AFVersionDeclaration = str;
        AFInAppEventType2.AFLogger$LogLevel = map;
    }

    public final void enableFacebookDeferredApplinks(boolean z11) {
        this.setPhoneNumber = z11;
    }

    public final AppsFlyerLib enableLocationCollection(boolean z11) {
        this.getSdkVersion = z11;
        return this;
    }

    public final String getAppsFlyerUID(Context context) {
        aj.valueOf().AFInAppEventType("public_api_call", "getAppsFlyerUID", new String[0]);
        return an.AFKeystoreWrapper(new WeakReference(context));
    }

    public final String getAttributionId(Context context) {
        try {
            return new ah(context).AFInAppEventParameterName();
        } catch (Throwable th2) {
            AFLogger.AFInAppEventType("Could not collect facebook attribution id. ", th2);
            return null;
        }
    }

    public final String getHostName() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host");
        return string != null ? string : "appsflyer.com";
    }

    public final String getHostPrefix() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host_prefix");
        return string != null ? string : "";
    }

    public final String getOutOfStore(Context context) {
        String str;
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        if (context == null) {
            str = null;
        } else {
            str = AFKeystoreWrapper("AF_STORE", context.getPackageManager(), context.getPackageName());
        }
        if (str != null) {
            return str;
        }
        AFLogger.AFKeystoreWrapper("No out-of-store value set");
        return null;
    }

    public final String getSdkVersion() {
        aj.valueOf().AFInAppEventType("public_api_call", "getSdkVersion", new String[0]);
        StringBuilder sb2 = new StringBuilder("version: 6.3.2 (build ");
        sb2.append(AFInAppEventParameterName);
        sb2.append(")");
        return sb2.toString();
    }

    public final boolean isPreInstalledApp(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e11) {
            AFLogger.AFInAppEventType("Could not check if app is pre installed", (Throwable) e11);
        }
    }

    public final boolean isStopped() {
        return this.setOaidData;
    }

    public final void logEvent(Context context, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        HashMap hashMap;
        bj bjVar = new bj();
        if (context != null) {
            bjVar.valueOf = (Application) context.getApplicationContext();
        }
        bjVar.AFLogger$LogLevel = str;
        Activity activity = null;
        if (map == null) {
            hashMap = null;
        } else {
            hashMap = new HashMap(map);
        }
        bjVar.values = hashMap;
        bjVar.AFKeystoreWrapper = appsFlyerRequestListener;
        aj valueOf2 = aj.valueOf();
        String[] strArr = new String[2];
        strArr[0] = str;
        Map map2 = bjVar.values;
        if (map2 == null) {
            map2 = new HashMap();
        }
        strArr[1] = new JSONObject(map2).toString();
        valueOf2.AFInAppEventType("public_api_call", "logEvent", strArr);
        if (str != null) {
            z.AFKeystoreWrapper(context).AFInAppEventType();
        }
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        values((g) bjVar, activity);
    }

    public final void logLocation(Context context, double d11, double d12) {
        aj.valueOf().AFInAppEventType("public_api_call", "logLocation", String.valueOf(d11), String.valueOf(d12));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d12));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d11));
        AFKeystoreWrapper(context, AFInAppEventType.LOCATION_COORDINATES, (Map<String, Object>) hashMap);
    }

    public final void logSession(Context context) {
        aj.valueOf().AFInAppEventType("public_api_call", "logSession", new String[0]);
        aj.valueOf().AFInAppEventParameterName = false;
        AFKeystoreWrapper(context, (String) null, (Map<String, Object>) null);
    }

    public final void onPause(Context context) {
        ag.b bVar = ag.AFInAppEventParameterName;
        if (bVar != null) {
            bVar.values(context);
        }
    }

    @Deprecated
    public final void performOnAppAttribution(Context context, URI uri) {
        if (uri == null || uri.toString().isEmpty()) {
            StringBuilder sb2 = new StringBuilder("Link is \"");
            sb2.append(uri);
            sb2.append("\"");
            ap.valueOf(sb2.toString(), DeepLinkResult.Error.NETWORK);
        } else if (context == null) {
            StringBuilder sb3 = new StringBuilder("Context is \"");
            sb3.append(context);
            sb3.append("\"");
            ap.valueOf(sb3.toString(), DeepLinkResult.Error.NETWORK);
        } else {
            j.AFInAppEventType().AFInAppEventType(context, new HashMap(), Uri.parse(uri.toString()));
        }
    }

    public final void performOnDeepLinking(final Intent intent, Context context) {
        if (intent == null) {
            ap.valueOf("performOnDeepLinking was called with null intent", DeepLinkResult.Error.DEVELOPER_ERROR);
        } else if (context == null) {
            ap.valueOf("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
        } else {
            final Context applicationContext = context.getApplicationContext();
            this.setAppInviteOneLink.execute(new Runnable() {
                public final void run() {
                    j.AFInAppEventType();
                    Intent intent = intent;
                    Context context = applicationContext;
                    ae aeVar = ae.this;
                    if (aeVar.init == null) {
                        aeVar.init = new au(context);
                    }
                    au auVar = aeVar.init;
                    Uri AFInAppEventType2 = j.AFInAppEventType(intent);
                    boolean z11 = AFInAppEventType2 != null && !AFInAppEventType2.toString().isEmpty();
                    if (!ae.values(context).getBoolean("ddl_sent", false) || z11) {
                        j.AFInAppEventType().AFKeystoreWrapper(new HashMap(), auVar, intent, context);
                    } else {
                        ap.valueOf("No direct deep link", (DeepLinkResult.Error) null);
                    }
                }
            });
        }
    }

    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        aj.valueOf().AFInAppEventType("public_api_call", "registerConversionListener", new String[0]);
        if (appsFlyerConversionListener != null) {
            valueOf = appsFlyerConversionListener;
        }
    }

    public final void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        aj.valueOf().AFInAppEventType("public_api_call", "registerValidatorListener", new String[0]);
        AFLogger.values("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            AFLogger.values("registerValidatorListener null listener");
        } else {
            values = appsFlyerInAppPurchaseValidatorListener;
        }
    }

    public final void sendAdRevenue(Context context, Map<String, Object> map) {
        bg bgVar = new bg();
        if (context != null) {
            bgVar.valueOf = (Application) context.getApplicationContext();
        }
        bgVar.values = map;
        Application application = bgVar.valueOf;
        String format = String.format(onInstallConversionDataLoadedNative, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), onConversionDataSuccess.getHostName()});
        StringBuilder sb2 = new StringBuilder();
        sb2.append(format);
        sb2.append(application.getPackageName());
        String obj = sb2.toString();
        SharedPreferences values2 = values((Context) application);
        int valueOf2 = valueOf(values2, "appsFlyerCount", false);
        int valueOf3 = valueOf(values2, "appsFlyerAdRevenueCount", true);
        HashMap hashMap = new HashMap();
        hashMap.put("ad_network", bgVar.values);
        hashMap.put("adrevenue_counter", Integer.valueOf(valueOf3));
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        hashMap.put("af_key", string);
        hashMap.put("launch_counter", Integer.valueOf(valueOf2));
        hashMap.put("af_timestamp", Long.toString(new Date().getTime()));
        hashMap.put("uid", an.AFKeystoreWrapper(new WeakReference(application)));
        String string2 = AppsFlyerProperties.getInstance().getString("advertiserId");
        String string3 = AppsFlyerProperties.getInstance().getString("advertiserIdEnabled");
        if (string3 != null) {
            hashMap.put("advertiserIdEnabled", string3);
        }
        if (string2 != null) {
            hashMap.put("advertiserId", string2);
        }
        hashMap.put("device", Build.DEVICE);
        values((Context) application, (Map<String, Object>) hashMap);
        try {
            PackageInfo packageInfo = application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            long j11 = packageInfo.firstInstallTime;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
            hashMap.put("install_date", simpleDateFormat.format(new Date(j11)));
            String string4 = values2.getString("appsFlyerFirstInstall", (String) null);
            if (string4 == null) {
                string4 = AFInAppEventParameterName(simpleDateFormat, (Context) application);
            }
            hashMap.put("first_launch_date", string4);
        } catch (Throwable th2) {
            AFLogger.AFInAppEventType("AdRevenue - Exception while collecting app version data ", th2);
        }
        g valueOf4 = bgVar.AFInAppEventParameterName(obj).valueOf(hashMap);
        valueOf4.onInstallConversionFailureNative = valueOf2;
        valueOf4.AFVersionDeclaration = string;
        d dVar = new d(this, valueOf4, (byte) 0);
        if (k.valueOf == null) {
            k.valueOf = new k();
        }
        AFInAppEventType(k.valueOf.AFInAppEventParameterName(), dVar, 1, TimeUnit.MILLISECONDS);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendPushNotificationData(android.app.Activity r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "c"
            java.lang.String r2 = "pid"
            r3 = 1
            r4 = 0
            r5 = 2
            java.lang.String r6 = "public_api_call"
            java.lang.String r7 = "sendPushNotificationData"
            if (r17 == 0) goto L_0x003d
            android.content.Intent r8 = r17.getIntent()
            if (r8 == 0) goto L_0x003d
            com.appsflyer.internal.aj r8 = com.appsflyer.internal.aj.valueOf()
            java.lang.String[] r9 = new java.lang.String[r5]
            java.lang.String r10 = r17.getLocalClassName()
            r9[r4] = r10
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r10 = "activity_intent_"
            r4.<init>(r10)
            android.content.Intent r10 = r17.getIntent()
            java.lang.String r10 = r10.toString()
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            r9[r3] = r4
            r8.AFInAppEventType(r6, r7, r9)
            goto L_0x0060
        L_0x003d:
            if (r17 == 0) goto L_0x0053
            com.appsflyer.internal.aj r8 = com.appsflyer.internal.aj.valueOf()
            java.lang.String[] r9 = new java.lang.String[r5]
            java.lang.String r10 = r17.getLocalClassName()
            r9[r4] = r10
            java.lang.String r4 = "activity_intent_null"
            r9[r3] = r4
            r8.AFInAppEventType(r6, r7, r9)
            goto L_0x0060
        L_0x0053:
            com.appsflyer.internal.aj r3 = com.appsflyer.internal.aj.valueOf()
            java.lang.String r4 = "activity_null"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r3.AFInAppEventType(r6, r7, r4)
        L_0x0060:
            java.lang.String r3 = AFInAppEventParameterName((android.app.Activity) r17)
            r1.updateServerUninstallToken = r3
            if (r3 == 0) goto L_0x016d
            long r3 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.getInstance
            java.lang.String r7 = ")"
            if (r6 != 0) goto L_0x0081
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.AFKeystoreWrapper(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.getInstance = r0
            r10 = r3
            goto L_0x012f
        L_0x0081:
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0114 }
            java.lang.String r8 = "pushPayloadMaxAging"
            r9 = 1800000(0x1b7740, double:8.89318E-318)
            long r8 = r6.getLong(r8, r9)     // Catch:{ all -> 0x0114 }
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.getInstance     // Catch:{ all -> 0x0114 }
            java.util.Set r6 = r6.keySet()     // Catch:{ all -> 0x0114 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0114 }
            r10 = r3
        L_0x0099:
            boolean r12 = r6.hasNext()     // Catch:{ all -> 0x0112 }
            if (r12 == 0) goto L_0x012f
            java.lang.Object r12 = r6.next()     // Catch:{ all -> 0x0112 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0112 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x0112 }
            java.lang.String r14 = r1.updateServerUninstallToken     // Catch:{ all -> 0x0112 }
            r13.<init>(r14)     // Catch:{ all -> 0x0112 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x0112 }
            java.util.Map<java.lang.Long, java.lang.String> r15 = r1.getInstance     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r15.get(r12)     // Catch:{ all -> 0x0112 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0112 }
            r14.<init>(r15)     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r13.opt(r2)     // Catch:{ all -> 0x0112 }
            java.lang.Object r5 = r14.opt(r2)     // Catch:{ all -> 0x0112 }
            boolean r5 = r15.equals(r5)     // Catch:{ all -> 0x0112 }
            if (r5 == 0) goto L_0x00f5
            java.lang.Object r5 = r13.opt(r0)     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r14.opt(r0)     // Catch:{ all -> 0x0112 }
            boolean r5 = r5.equals(r15)     // Catch:{ all -> 0x0112 }
            if (r5 == 0) goto L_0x00f5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r2)     // Catch:{ all -> 0x0112 }
            r0.append(r14)     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = ", new: "
            r0.append(r2)     // Catch:{ all -> 0x0112 }
            r0.append(r13)     // Catch:{ all -> 0x0112 }
            r0.append(r7)     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0112 }
            com.appsflyer.AFLogger.AFKeystoreWrapper(r0)     // Catch:{ all -> 0x0112 }
            r0 = 0
            r1.updateServerUninstallToken = r0     // Catch:{ all -> 0x0112 }
            return
        L_0x00f5:
            long r13 = r12.longValue()     // Catch:{ all -> 0x0112 }
            long r13 = r3 - r13
            int r5 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x0104
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.getInstance     // Catch:{ all -> 0x0112 }
            r5.remove(r12)     // Catch:{ all -> 0x0112 }
        L_0x0104:
            long r13 = r12.longValue()     // Catch:{ all -> 0x0112 }
            int r5 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r5 > 0) goto L_0x0110
            long r10 = r12.longValue()     // Catch:{ all -> 0x0112 }
        L_0x0110:
            r5 = 2
            goto L_0x0099
        L_0x0112:
            r0 = move-exception
            goto L_0x0116
        L_0x0114:
            r0 = move-exception
            r10 = r3
        L_0x0116:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Error while handling push notification measurement: "
            r2.<init>(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r2, (java.lang.Throwable) r0)
        L_0x012f:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "pushPayloadHistorySize"
            r5 = 2
            int r0 = r0.getInt(r2, r5)
            java.util.Map<java.lang.Long, java.lang.String> r2 = r1.getInstance
            int r2 = r2.size()
            if (r2 != r0) goto L_0x015f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r2)
            r0.append(r10)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.AFKeystoreWrapper(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.getInstance
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            r0.remove(r2)
        L_0x015f:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.getInstance
            java.lang.Long r2 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = r1.updateServerUninstallToken
            r0.put(r2, r3)
            r16.start(r17)
        L_0x016d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ae.sendPushNotificationData(android.app.Activity):void");
    }

    public final void setAdditionalData(Map<String, Object> map) {
        if (map != null) {
            aj.valueOf().AFInAppEventType("public_api_call", "setAdditionalData", map.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(map).toString());
        }
    }

    public final void setAndroidIdData(String str) {
        aj.valueOf().AFInAppEventType("public_api_call", "setAndroidIdData", str);
        this.AFLogger$LogLevel = str;
    }

    public final void setAppId(String str) {
        aj.valueOf().AFInAppEventType("public_api_call", "setAppId", str);
        AppsFlyerProperties.getInstance().set("appid", str);
    }

    public final void setAppInviteOneLink(String str) {
        aj.valueOf().AFInAppEventType("public_api_call", "setAppInviteOneLink", str);
        AFLogger.AFKeystoreWrapper("setAppInviteOneLink = ".concat(String.valueOf(str)));
        if (str == null || !str.equals(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID))) {
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_DOMAIN);
            AppsFlyerProperties.getInstance().remove("onelinkVersion");
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_SCHEME);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_ID, str);
    }

    public final void setCollectAndroidID(boolean z11) {
        aj.valueOf().AFInAppEventType("public_api_call", "setCollectAndroidID", String.valueOf(z11));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z11));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z11));
    }

    public final void setCollectIMEI(boolean z11) {
        aj.valueOf().AFInAppEventType("public_api_call", "setCollectIMEI", String.valueOf(z11));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z11));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z11));
    }

    @Deprecated
    public final void setCollectOaid(boolean z11) {
        aj.valueOf().AFInAppEventType("public_api_call", "setCollectOaid", String.valueOf(z11));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z11));
    }

    public final void setCurrencyCode(String str) {
        aj.valueOf().AFInAppEventType("public_api_call", "setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
    }

    public final void setCustomerIdAndLogSession(String str, Context context) {
        if (context == null) {
            return;
        }
        if (valueOf()) {
            setCustomerUserId(str);
            StringBuilder sb2 = new StringBuilder("CustomerUserId set: ");
            sb2.append(str);
            sb2.append(" - Initializing AppsFlyer Tacking");
            AFLogger.AFInAppEventType(sb2.toString(), true);
            String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
            String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
            if (referrer == null) {
                referrer = "";
            }
            if (context instanceof Activity) {
                ((Activity) context).getIntent();
            }
            bl blVar = new bl();
            blVar.valueOf = (Application) context.getApplicationContext();
            blVar.AFLogger$LogLevel = null;
            blVar.AFVersionDeclaration = string;
            blVar.values = null;
            blVar.init = referrer;
            blVar.AFInAppEventParameterName = null;
            AFInAppEventType((g) blVar);
            return;
        }
        setCustomerUserId(str);
        AFLogger.AFInAppEventType("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
    }

    public final void setCustomerUserId(String str) {
        aj.valueOf().AFInAppEventType("public_api_call", "setCustomerUserId", str);
        AFLogger.AFKeystoreWrapper("setCustomerUserId = ".concat(String.valueOf(str)));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_USER_ID, str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
    }

    public final void setDebugLog(boolean z11) {
        setLogLevel(z11 ? AFLogger.LogLevel.DEBUG : AFLogger.LogLevel.NONE);
    }

    public final void setDisableAdvertisingIdentifiers(boolean z11) {
        AFLogger.values("setDisableAdvertisingIdentifiers: ".concat(String.valueOf(z11)));
        ab.AFInAppEventType = Boolean.valueOf(!z11);
        AppsFlyerProperties.getInstance().remove("advertiserIdEnabled");
        AppsFlyerProperties.getInstance().remove("advertiserId");
    }

    public final void setExtension(String str) {
        aj.valueOf().AFInAppEventType("public_api_call", "setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    public final void setHost(String str, String str2) {
        if (str != null) {
            AppsFlyerProperties.getInstance().set("custom_host_prefix", str);
        }
        if (str2 == null || str2.isEmpty()) {
            AFLogger.init("hostName cannot be null or empty");
        } else {
            AppsFlyerProperties.getInstance().set("custom_host", str2);
        }
    }

    public final void setImeiData(String str) {
        aj.valueOf().AFInAppEventType("public_api_call", "setImeiData", str);
        this.AppsFlyer2dXConversionCallback = str;
    }

    public final void setIsUpdate(boolean z11) {
        aj.valueOf().AFInAppEventType("public_api_call", "setIsUpdate", String.valueOf(z11));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z11);
    }

    public final void setLogLevel(AFLogger.LogLevel logLevel) {
        aj.valueOf().AFInAppEventType("public_api_call", "log", String.valueOf(logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel()));
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
    }

    public final void setMinTimeBetweenSessions(int i11) {
        this.AppsFlyerLib = TimeUnit.SECONDS.toMillis((long) i11);
    }

    public final void setOaidData(String str) {
        aj.valueOf().AFInAppEventType("public_api_call", "setOaidData", str);
        ab.valueOf = str;
    }

    public final void setOneLinkCustomDomain(String... strArr) {
        AFLogger.values(String.format("setOneLinkCustomDomain %s", new Object[]{Arrays.toString(strArr)}));
        j.AppsFlyer2dXConversionCallback = strArr;
    }

    public final void setOutOfStore(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            AFLogger.AFInAppEventType("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.valueOf("Cannot set setOutOfStore with null");
    }

    public final void setPartnerData(String str, Map<String, Object> map) {
        if (this.setAdditionalData == null) {
            this.setAdditionalData = new av();
        }
        av avVar = this.setAdditionalData;
        if (str == null || str.isEmpty()) {
            AFLogger.init("Partner ID is missing or `null`");
        } else if (map == null || map.isEmpty()) {
            AFLogger.init(avVar.valueOf.remove(str) == null ? "Partner data is missing or `null`" : "Cleared partner data for ".concat(str));
        } else {
            StringBuilder sb2 = new StringBuilder("Setting partner data for ");
            sb2.append(str);
            sb2.append(l.f34627b);
            sb2.append(map);
            AFLogger.values(sb2.toString());
            int length = new JSONObject(map).toString().length();
            if (length > 1000) {
                AFLogger.init("Partner data 1000 characters limit exceeded");
                HashMap hashMap = new HashMap();
                hashMap.put("error", "limit exceeded: ".concat(String.valueOf(length)));
                avVar.AFKeystoreWrapper.put(str, hashMap);
                return;
            }
            avVar.valueOf.put(str, map);
            avVar.AFKeystoreWrapper.remove(str);
        }
    }

    public final void setPhoneNumber(String str) {
        this.setCustomerUserId = af.values(str);
    }

    public final void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.values("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("pid", str);
            } catch (JSONException e11) {
                AFLogger.AFInAppEventType(e11.getMessage(), (Throwable) e11);
            }
        }
        if (str2 != null) {
            jSONObject.put("c", str2);
        }
        if (str3 != null) {
            jSONObject.put("af_siteid", str3);
        }
        if (jSONObject.has("pid")) {
            AppsFlyerProperties.getInstance().set("preInstallName", jSONObject.toString());
            return;
        }
        AFLogger.init("Cannot set preinstall attribution data without a media source");
    }

    public final void setResolveDeepLinkURLs(String... strArr) {
        AFLogger.values(String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)}));
        j.AFKeystoreWrapper = strArr;
    }

    public final void setSharingFilter(String... strArr) {
        if (strArr != null && !Arrays.equals(this.getLevel, new String[]{TtmlNode.COMBINE_ALL})) {
            Pattern compile = Pattern.compile("[\\d\\w_]{1,45}");
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (str == null || !compile.matcher(str).matches()) {
                    AFLogger.init("Invalid partner name :".concat(String.valueOf(str)));
                } else {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                this.getLevel = (String[]) arrayList.toArray(new String[0]);
            } else {
                this.getLevel = null;
            }
        }
    }

    public final void setSharingFilterForAllPartners() {
        this.getLevel = new String[]{TtmlNode.COMBINE_ALL};
    }

    public final void setUserEmails(String... strArr) {
        aj.valueOf().AFInAppEventType("public_api_call", "setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
    }

    public final void start(Context context) {
        start(context, (String) null);
    }

    public final void stop(boolean z11, Context context) {
        this.setOaidData = z11;
        ai.AFKeystoreWrapper();
        try {
            File AFKeystoreWrapper2 = ai.AFKeystoreWrapper(context);
            if (!AFKeystoreWrapper2.exists()) {
                AFKeystoreWrapper2.mkdir();
            } else {
                for (File file : AFKeystoreWrapper2.listFiles()) {
                    StringBuilder sb2 = new StringBuilder("Found cached request");
                    sb2.append(file.getName());
                    AFLogger.AFKeystoreWrapper(sb2.toString());
                    ai.valueOf(ai.AFInAppEventParameterName(file).valueOf, context);
                }
            }
        } catch (Exception e11) {
            AFLogger.AFInAppEventType("Could not cache request", (Throwable) e11);
        }
        if (this.setOaidData) {
            SharedPreferences.Editor edit = values(context).edit();
            edit.putBoolean("is_stop_tracking_used", true);
            edit.apply();
        }
    }

    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener) {
        subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3));
    }

    public final void unregisterConversionListener() {
        aj.valueOf().AFInAppEventType("public_api_call", "unregisterConversionListener", new String[0]);
        valueOf = null;
    }

    public final void updateServerUninstallToken(Context context, String str) {
        new bb(context).valueOf(str);
    }

    public final void validateAndLogInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Context context2 = context;
        String str6 = str3;
        String str7 = str4;
        String str8 = str5;
        aj valueOf2 = aj.valueOf();
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str6;
        strArr[3] = str7;
        strArr[4] = str8;
        strArr[5] = map == null ? "" : map.toString();
        valueOf2.AFInAppEventType("public_api_call", "validateAndTrackInAppPurchase", strArr);
        if (!isStopped()) {
            StringBuilder sb2 = new StringBuilder("Validate in app called with parameters: ");
            sb2.append(str3);
            sb2.append(" ");
            sb2.append(str7);
            sb2.append(" ");
            sb2.append(str8);
            AFLogger.AFKeystoreWrapper(sb2.toString());
        }
        if (str == null || str7 == null || str2 == null || str8 == null || str6 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = values;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (context2 instanceof Activity) {
            ((Activity) context2).getIntent();
        }
        new Thread(new ad(applicationContext, string, str, str2, str3, str4, str5, map)).start();
    }

    public final void waitForCustomerUserId(boolean z11) {
        AFLogger.AFInAppEventType("initAfterCustomerUserID: ".concat(String.valueOf(z11)), true);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z11);
    }

    private static boolean AFInAppEventType(String str, boolean z11) {
        return AppsFlyerProperties.getInstance().getBoolean(str, z11);
    }

    private boolean AFLogger$LogLevel() {
        Map<String, Object> map = this.setCustomerIdAndLogSession;
        return map != null && !map.isEmpty();
    }

    private static float AFVersionDeclaration(Context context) {
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra == -1 || intExtra2 == -1) {
                return 50.0f;
            }
            return (((float) intExtra) / ((float) intExtra2)) * 100.0f;
        } catch (Throwable th2) {
            AFLogger.AFInAppEventType(th2.getMessage(), th2);
            return 1.0f;
        }
    }

    private static boolean AppsFlyer2dXConversionCallback(Context context) {
        if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) || !AFLogger$LogLevel(context)) {
            return true;
        }
        return false;
    }

    private static boolean getLevel(Context context) {
        if (context != null) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 23) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    for (Network networkCapabilities : connectivityManager.getAllNetworks()) {
                        NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(networkCapabilities);
                        if (networkCapabilities2.hasTransport(4) && !networkCapabilities2.hasCapability(15)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e11) {
                    AFLogger.AFInAppEventType("Failed collecting ivc data", (Throwable) e11);
                }
            } else if (i11 >= 16) {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator<T> it2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (it2.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it2.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    return arrayList.contains("tun0");
                } catch (Exception e12) {
                    AFLogger.AFInAppEventType("Failed collecting ivc data", (Throwable) e12);
                }
            }
        }
        return false;
    }

    public static ae values() {
        return onConversionDataSuccess;
    }

    public final void AFInAppEventParameterName(Context context, Intent intent) {
        if (intent.getStringExtra("appsflyer_preinstall") != null) {
            String stringExtra = intent.getStringExtra("appsflyer_preinstall");
            try {
                if (new JSONObject(stringExtra).has("pid")) {
                    AppsFlyerProperties.getInstance().set("preInstallName", stringExtra);
                } else {
                    AFLogger.init("Cannot set preinstall attribution data without a media source");
                }
            } catch (JSONException e11) {
                AFLogger.AFInAppEventType("Error parsing JSON for preinstall", (Throwable) e11);
            }
        }
        AFLogger.AFKeystoreWrapper("****** onReceive called *******");
        AppsFlyerProperties.getInstance();
        String stringExtra2 = intent.getStringExtra(Constants.REFERRER);
        AFLogger.AFKeystoreWrapper("Play store referrer: ".concat(String.valueOf(stringExtra2)));
        if (stringExtra2 != null) {
            SharedPreferences.Editor edit = values(context).edit();
            edit.putString(Constants.REFERRER, stringExtra2);
            edit.apply();
            AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
            instance.set("AF_REFERRER", stringExtra2);
            instance.valueOf = stringExtra2;
            if (AppsFlyerProperties.getInstance().values()) {
                AFLogger.AFKeystoreWrapper("onReceive: isLaunchCalled");
                bd bdVar = new bd();
                if (context != null) {
                    bdVar.valueOf = (Application) context.getApplicationContext();
                }
                bdVar.init = stringExtra2;
                if (stringExtra2.length() > 5 && AFInAppEventParameterName((g) bdVar, values(context))) {
                    if (k.valueOf == null) {
                        k.valueOf = new k();
                    }
                    AFInAppEventType(k.valueOf.AFInAppEventParameterName(), new c(this, bdVar, (byte) 0), 5, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public final AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, Context context) {
        if (this.setDebugLog) {
            return this;
        }
        this.setDebugLog = true;
        if (context != null) {
            if (this.init == null) {
                this.init = new au(context);
            }
            au auVar = this.init;
            if (auVar.AFInAppEventType()) {
                auVar.valueOf.edit().putLong("init_ts", System.currentTimeMillis()).apply();
            }
            this.setImeiData = (Application) context.getApplicationContext();
            final bo boVar = new bo(new Runnable() {
                public final void run() {
                    if (k.valueOf == null) {
                        k.valueOf = new k();
                    }
                    ae.AFInAppEventType(k.valueOf.AFInAppEventParameterName(), new Runnable() {
                        public final void run() {
                            try {
                                bh bhVar = new bh();
                                Application AFInAppEventParameterName = ae.this.setImeiData;
                                if (AFInAppEventParameterName != null) {
                                    bhVar.valueOf = (Application) AFInAppEventParameterName.getApplicationContext();
                                }
                                ae aeVar = ae.this;
                                if (aeVar.AFInAppEventParameterName((g) bhVar, ae.values((Context) aeVar.setImeiData))) {
                                    ae.AFKeystoreWrapper(ae.this, (g) bhVar);
                                }
                            } catch (Throwable th2) {
                                AFLogger.AFInAppEventType(th2.getMessage(), th2);
                            }
                        }
                    }, 0, TimeUnit.MILLISECONDS);
                }
            });
            AnonymousClass5 r42 = new Runnable() {
                public final void run() {
                    SharedPreferences values2 = ae.values((Context) ae.this.setImeiData);
                    boolean z11 = false;
                    int valueOf2 = ae.valueOf(values2, "appsFlyerCount", false);
                    boolean z12 = values2.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false);
                    if (boVar.AFInAppEventParameterName == bt.e.NOT_STARTED) {
                        z11 = true;
                    }
                    if (valueOf2 != 1) {
                        return;
                    }
                    if (z11 || z12) {
                        ae aeVar = ae.this;
                        bh bhVar = new bh();
                        Application AFInAppEventParameterName = ae.this.setImeiData;
                        if (AFInAppEventParameterName != null) {
                            bhVar.valueOf = (Application) AFInAppEventParameterName.getApplicationContext();
                        }
                        ae.AFKeystoreWrapper(aeVar, (g) bhVar);
                    }
                }
            };
            bt[] btVarArr = {boVar, new br(r42), new bw(r42)};
            this.onAppOpenAttributionNative = btVarArr;
            for (bt AFInAppEventParameterName2 : btVarArr) {
                AFInAppEventParameterName2.AFInAppEventParameterName(this.setImeiData);
            }
            this.getOutOfStore = AFInAppEventType(context);
            at.AFInAppEventParameterName = this.setImeiData;
        } else {
            AFLogger.init("context is null, Google Install Referrer will be not initialized");
        }
        aj valueOf2 = aj.valueOf();
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = appsFlyerConversionListener == null ? OptionsBridge.NULL_VALUE : "conversionDataListener";
        valueOf2.AFInAppEventType("public_api_call", ZendeskBlipsProvider.ACTION_CORE_INIT, strArr);
        AFLogger.AFInAppEventType(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{"6.3.2", AFInAppEventParameterName}));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str);
        am.valueOf(str);
        valueOf = appsFlyerConversionListener;
        return this;
    }

    public final void start(Context context, String str) {
        start(context, str, (AppsFlyerRequestListener) null);
    }

    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener, long j11) {
        j.AFInAppEventType().AFInAppEventParameterName = deepLinkListener;
        aq.onInstallConversionDataLoadedNative = j11;
    }

    private boolean AFInAppEventType(Context context) {
        try {
            Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
            final long currentTimeMillis = System.currentTimeMillis();
            this.setCustomerIdAndLogSession = new ConcurrentHashMap();
            AnonymousClass1 r42 = new v.d() {
                public final void AFInAppEventParameterName(String str, String str2) {
                    ae.this.setCustomerIdAndLogSession.put("signedData", str);
                    ae.this.setCustomerIdAndLogSession.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, str2);
                    ae.this.setCustomerIdAndLogSession.put("ttr", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.AFKeystoreWrapper("Successfully retrieved Google LVL data.");
                }

                public final void AFKeystoreWrapper(String str, Exception exc) {
                    String message = exc.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    ae.this.setCustomerIdAndLogSession.put("error", message);
                    AFLogger.AFInAppEventParameterName(str, (Throwable) exc);
                }
            };
            try {
                Class<?> cls = Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
                Class<?> cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                Method method = cls.getMethod("checkLicense", new Class[]{Long.TYPE, Context.class, cls2});
                v.AnonymousClass2 r72 = new InvocationHandler(r42) {
                    private /* synthetic */ d AFInAppEventParameterName;

                    public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.internal.v.2.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.v.2.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                };
                method.invoke((Object) null, new Object[]{Long.valueOf(currentTimeMillis), context, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r72)});
            } catch (ClassNotFoundException e11) {
                r42.AFKeystoreWrapper(e11.getClass().getSimpleName(), e11);
            } catch (NoSuchMethodException e12) {
                r42.AFKeystoreWrapper(e12.getClass().getSimpleName(), e12);
            } catch (IllegalAccessException e13) {
                r42.AFKeystoreWrapper(e13.getClass().getSimpleName(), e13);
            } catch (InvocationTargetException e14) {
                r42.AFKeystoreWrapper(e14.getClass().getSimpleName(), e14);
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean AFLogger$LogLevel(Context context) {
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                return true;
            }
        } catch (Throwable th2) {
            AFLogger.AFInAppEventType("WARNING:  Google play services is unavailable. ", th2);
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e11) {
            AFLogger.AFInAppEventType("WARNING:  Google Play Services is unavailable. ", (Throwable) e11);
            return false;
        }
    }

    public static void valueOf(Context context, String str) {
        SharedPreferences.Editor edit = values(context).edit();
        edit.putBoolean(str, true);
        edit.apply();
    }

    public final void start(Context context, String str, AppsFlyerRequestListener appsFlyerRequestListener) {
        final String str2 = str;
        final AppsFlyerRequestListener appsFlyerRequestListener2 = appsFlyerRequestListener;
        if (ag.AFInAppEventParameterName == null) {
            if (!this.setDebugLog) {
                AFLogger.init("ERROR: AppsFlyer SDK is not initialized! The API call 'start()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
                if (str2 == null) {
                    if (appsFlyerRequestListener2 != null) {
                        appsFlyerRequestListener2.onError(RequestError.NO_DEV_KEY, ax.AFKeystoreWrapper);
                        return;
                    }
                    return;
                }
            }
            this.setImeiData = (Application) context.getApplicationContext();
            aj.valueOf().AFInAppEventType("public_api_call", "start", str2);
            String str3 = AFInAppEventParameterName;
            AFLogger.AFKeystoreWrapper(String.format("Starting AppsFlyer: (v%s.%s)", new Object[]{"6.3.2", str3}));
            StringBuilder sb2 = new StringBuilder("Build Number: ");
            sb2.append(str3);
            AFLogger.AFKeystoreWrapper(sb2.toString());
            AppsFlyerProperties.getInstance().loadProperties(this.setImeiData.getApplicationContext());
            if (!TextUtils.isEmpty(str)) {
                AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str2);
                am.valueOf(str);
            } else if (TextUtils.isEmpty(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY))) {
                AFLogger.init("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
                if (appsFlyerRequestListener2 != null) {
                    appsFlyerRequestListener2.onError(RequestError.NO_DEV_KEY, ax.AFKeystoreWrapper);
                    return;
                }
                return;
            }
            Context baseContext = this.setImeiData.getBaseContext();
            try {
                if ((baseContext.getPackageManager().getPackageInfo(baseContext.getPackageName(), 0).applicationInfo.flags & 32768) != 0) {
                    if (baseContext.getResources().getIdentifier("appsflyer_backup_rules", "xml", baseContext.getPackageName()) != 0) {
                        AFLogger.AFInAppEventType("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                    } else {
                        AFLogger.valueOf("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
                    }
                }
            } catch (Exception e11) {
                StringBuilder sb3 = new StringBuilder("checkBackupRules Exception: ");
                sb3.append(e11.toString());
                AFLogger.AFInAppEventParameterName(sb3.toString());
            }
            if (this.setPhoneNumber) {
                Context applicationContext = this.setImeiData.getApplicationContext();
                this.waitForCustomerUserId = new HashMap();
                final long currentTimeMillis = System.currentTimeMillis();
                AnonymousClass4 r92 = new l.a() {
                    public final void AFInAppEventType(String str, String str2, String str3) {
                        if (str != null) {
                            AFLogger.AFKeystoreWrapper("Facebook Deferred AppLink data received: ".concat(str));
                            ae.this.waitForCustomerUserId.put("link", str);
                            if (str2 != null) {
                                ae.this.waitForCustomerUserId.put("target_url", str2);
                            }
                            if (str3 != null) {
                                HashMap hashMap = new HashMap();
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(ShareConstants.PROMO_CODE, str3);
                                hashMap.put(ShareConstants.DEEPLINK_CONTEXT, hashMap2);
                                ae.this.waitForCustomerUserId.put("extras", hashMap);
                            }
                        } else {
                            ae.this.waitForCustomerUserId.put("link", "");
                        }
                        ae.this.waitForCustomerUserId.put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }

                    public final void values(String str) {
                        ae.this.waitForCustomerUserId.put("error", str);
                    }
                };
                Class<FacebookSdk> cls = FacebookSdk.class;
                try {
                    String str4 = FacebookSdk.CALLBACK_OFFSET_CHANGED_AFTER_INIT;
                    cls.getMethod("sdkInitialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{applicationContext});
                    Class<AppLinkData> cls2 = AppLinkData.class;
                    String str5 = AppLinkData.ARGUMENTS_TAPTIME_KEY;
                    Class<AppLinkData.CompletionHandler> cls3 = AppLinkData.CompletionHandler.class;
                    Method method = cls2.getMethod("fetchDeferredAppLinkData", new Class[]{Context.class, String.class, cls3});
                    l.AnonymousClass5 r13 = new InvocationHandler(cls2, r92) {
                        private /* synthetic */ Class AFInAppEventParameterName;
                        private /* synthetic */ a values;

                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.internal.l.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.l.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    };
                    Object newProxyInstance = Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, r13);
                    String string = applicationContext.getString(applicationContext.getResources().getIdentifier("facebook_app_id", "string", applicationContext.getPackageName()));
                    if (TextUtils.isEmpty(string)) {
                        r92.values("Facebook app id not defined in resources");
                    } else {
                        method.invoke((Object) null, new Object[]{applicationContext, string, newProxyInstance});
                    }
                } catch (NoSuchMethodException e12) {
                    r92.values(e12.toString());
                } catch (InvocationTargetException e13) {
                    r92.values(e13.toString());
                } catch (ClassNotFoundException e14) {
                    r92.values(e14.toString());
                } catch (IllegalAccessException e15) {
                    r92.values(e15.toString());
                }
            }
            ag.valueOf(context, new ag.b() {
                public final void AFKeystoreWrapper(Activity activity) {
                    long unused = ae.this.AppsFlyerConversionListener = System.currentTimeMillis();
                    ae aeVar = ae.this;
                    if (aeVar.init == null) {
                        aeVar.init = new au(activity);
                    }
                    au auVar = aeVar.init;
                    if (auVar.AFInAppEventType()) {
                        auVar.valueOf.edit().putLong("fg_ts", System.currentTimeMillis()).apply();
                    }
                    int valueOf2 = ae.valueOf(ae.values((Context) activity), "appsFlyerCount", false);
                    if (valueOf2 == 0) {
                        try {
                            ae.this.setUserEmails.put("init_to_fg", ae.this.AppsFlyerConversionListener - auVar.valueOf.getLong("init_ts", 0));
                        } catch (JSONException unused2) {
                        }
                    }
                    AFLogger.AFKeystoreWrapper("onBecameForeground");
                    if (valueOf2 < 2) {
                        z AFKeystoreWrapper2 = z.AFKeystoreWrapper((Context) activity);
                        AFKeystoreWrapper2.valueOf.post(AFKeystoreWrapper2.AFVersionDeclaration);
                        AFKeystoreWrapper2.valueOf.post(AFKeystoreWrapper2.AFKeystoreWrapper);
                    }
                    bl blVar = new bl();
                    j.AFInAppEventType().AFKeystoreWrapper(blVar.AFInAppEventType(), auVar, activity.getIntent(), activity.getApplication());
                    ae aeVar2 = ae.this;
                    blVar.valueOf = (Application) activity.getApplicationContext();
                    blVar.AFVersionDeclaration = str2;
                    blVar.AFKeystoreWrapper = appsFlyerRequestListener2;
                    aeVar2.values((g) blVar, activity);
                }

                public final void values(Context context) {
                    AFLogger.AFKeystoreWrapper("onBecameBackground");
                    long unused = ae.this.stop = System.currentTimeMillis();
                    long AFVersionDeclaration = ae.this.stop - ae.this.AppsFlyerConversionListener;
                    if (AFVersionDeclaration > 0 && AFVersionDeclaration < 1000) {
                        AFVersionDeclaration = 1000;
                    }
                    ae aeVar = ae.this;
                    if (aeVar.init == null) {
                        aeVar.init = new au(context);
                    }
                    aeVar.init.valueOf.edit().putLong("prev_session_dur", TimeUnit.MILLISECONDS.toSeconds(AFVersionDeclaration)).apply();
                    AFLogger.AFKeystoreWrapper("callStatsBackground background call");
                    ae.this.AFKeystoreWrapper((WeakReference<Context>) new WeakReference(context));
                    aj valueOf2 = aj.valueOf();
                    if (valueOf2.getLevel()) {
                        valueOf2.AFInAppEventParameterName();
                        if (context != null) {
                            aj.valueOf(context.getPackageName(), context.getPackageManager());
                        }
                        valueOf2.AFInAppEventType();
                    } else {
                        AFLogger.values("RD status is OFF");
                    }
                    if (k.valueOf == null) {
                        k.valueOf = new k();
                    }
                    k kVar = k.valueOf;
                    try {
                        k.AFKeystoreWrapper(kVar.values);
                        Executor executor = kVar.AFKeystoreWrapper;
                        if (executor instanceof ThreadPoolExecutor) {
                            k.AFKeystoreWrapper((ThreadPoolExecutor) executor);
                        }
                    } catch (Throwable th2) {
                        AFLogger.AFInAppEventType("failed to stop Executors", th2);
                    }
                    z AFKeystoreWrapper2 = z.AFKeystoreWrapper(context);
                    AFKeystoreWrapper2.valueOf.post(AFKeystoreWrapper2.AFVersionDeclaration);
                }
            }, this.setAppInviteOneLink);
        }
    }

    public final void values(Context context, String str) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        AFLogger.values("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = values(context).getString("extraReferrers", (String) null);
            if (string == null) {
                jSONObject = new JSONObject();
                jSONArray = new JSONArray();
            } else {
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.has(str)) {
                    jSONArray2 = new JSONArray((String) jSONObject2.get(str));
                } else {
                    jSONArray2 = new JSONArray();
                }
                JSONObject jSONObject3 = jSONObject2;
                jSONArray = jSONArray2;
                jSONObject = jSONObject3;
            }
            if (((long) jSONArray.length()) < 5) {
                jSONArray.put(currentTimeMillis);
            }
            if (((long) jSONObject.length()) >= 4) {
                AFKeystoreWrapper(jSONObject);
            }
            jSONObject.put(str, jSONArray.toString());
            String jSONObject4 = jSONObject.toString();
            SharedPreferences.Editor edit = values(context).edit();
            edit.putString("extraReferrers", jSONObject4);
            edit.apply();
        } catch (JSONException unused) {
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder("Couldn't save referrer - ");
            sb2.append(str);
            sb2.append(com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b);
            AFLogger.AFInAppEventType(sb2.toString(), th2);
        }
    }

    public final void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        aj.valueOf().AFInAppEventType("public_api_call", "setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        String str = null;
        for (String str2 : strArr) {
            if (AnonymousClass9.AFInAppEventType[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(af.values(str2));
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
        }
        hashMap.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
    }

    private static void AFKeystoreWrapper(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i11)));
                }
            } catch (JSONException unused) {
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    int i12 = 0;
                    while (i12 < jSONArray2.length()) {
                        if (jSONArray2.getLong(i12) != ((Long) arrayList.get(0)).longValue() && jSONArray2.getLong(i12) != ((Long) arrayList.get(1)).longValue() && jSONArray2.getLong(i12) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                            i12++;
                            str = next;
                        }
                    }
                    continue;
                } catch (JSONException unused2) {
                }
            }
        }
        if (str != null) {
            jSONObject.remove(str);
        }
    }

    public final void valueOf(Context context, String str, long j11) {
        SharedPreferences.Editor edit = values(context).edit();
        edit.putLong(str, j11);
        edit.apply();
    }

    public static boolean valueOf() {
        if (!AFInAppEventType(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false) || AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) != null) {
            return false;
        }
        return true;
    }

    public final void logEvent(Context context, String str, Map<String, Object> map) {
        logEvent(context, str, map, (AppsFlyerRequestListener) null);
    }

    private static String valueOf(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        if (!str.matches("fb\\d*?://authorize.*") || !str.contains("access_token")) {
            return str;
        }
        int indexOf = str.indexOf(63);
        if (indexOf == -1) {
            str2 = "";
        } else {
            str2 = str.substring(indexOf);
        }
        if (str2.length() == 0) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        if (str2.contains(ContainerUtils.FIELD_DELIMITER)) {
            arrayList = new ArrayList(Arrays.asList(str2.split(ContainerUtils.FIELD_DELIMITER)));
        } else {
            arrayList.add(str2);
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str3 = (String) it2.next();
            if (str3.contains("access_token")) {
                it2.remove();
            } else {
                if (sb2.length() != 0) {
                    sb2.append(ContainerUtils.FIELD_DELIMITER);
                } else if (!str3.startsWith("?")) {
                    sb2.append("?");
                }
                sb2.append(str3);
            }
        }
        return str.replace(str2, sb2.toString());
    }

    private boolean AFInAppEventType() {
        Map<String, Object> map = this.waitForCustomerUserId;
        return map != null && !map.isEmpty();
    }

    private static String AFInAppEventType(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Throwable th2) {
            AFLogger.AFInAppEventType(th2.getMessage(), th2);
            return null;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031 A[SYNTHETIC, Splitter:B:16:0x0031] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0028=Splitter:B:13:0x0028, B:22:0x003f=Splitter:B:22:0x003f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFInAppEventType(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r1.load(r2)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.AFKeystoreWrapper(r3)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            java.lang.String r4 = r1.getProperty(r5)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            r2.close()     // Catch:{ all -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0, (java.lang.Throwable) r5)
        L_0x0023:
            return r4
        L_0x0024:
            r4 = move-exception
            goto L_0x0028
        L_0x0026:
            r4 = move-exception
            r2 = r0
        L_0x0028:
            java.lang.String r5 = r4.getMessage()     // Catch:{ all -> 0x005a }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r5, (java.lang.Throwable) r4)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x0035 }
            goto L_0x0059
        L_0x0035:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r5, (java.lang.Throwable) r4)
            goto L_0x0059
        L_0x003e:
            r2 = r0
        L_0x003f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "PreInstall file wasn't found: "
            r5.<init>(r1)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x005a }
            r5.append(r4)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x005a }
            com.appsflyer.AFLogger.values((java.lang.String) r4)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x0035 }
        L_0x0059:
            return r0
        L_0x005a:
            r4 = move-exception
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ all -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r0, (java.lang.Throwable) r5)
        L_0x0069:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ae.AFInAppEventType(java.io.File, java.lang.String):java.lang.String");
    }

    public static void AFKeystoreWrapper(Context context, String str, String str2) {
        SharedPreferences.Editor edit = values(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static boolean values(SharedPreferences sharedPreferences) {
        return Boolean.parseBoolean(sharedPreferences.getString("sentSuccessfully", (String) null));
    }

    private static void values(Context context, Map<String, Object> map) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            map.put("sc_o", rotation != 0 ? rotation != 1 ? rotation != 2 ? rotation != 3 ? "" : "lr" : "pr" : "l" : TtmlNode.TAG_P);
        }
    }

    public static String AFKeystoreWrapper(String str) {
        return AppsFlyerProperties.getInstance().getString(str);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private static void AFKeystoreWrapper(android.content.Context r4) {
        /*
            boolean r0 = com.appsflyer.internal.aa.values()
            if (r0 == 0) goto L_0x000e
            r0 = 23
            java.lang.String r1 = "OPPO device found"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r1)
            goto L_0x0010
        L_0x000e:
            r0 = 18
        L_0x0010:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x00bf
            java.lang.String r0 = "keyPropDisableAFKeystore"
            r2 = 1
            boolean r0 = AFInAppEventType((java.lang.String) r0, (boolean) r2)
            if (r0 != 0) goto L_0x00bf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "OS SDK is="
            r0.<init>(r3)
            r0.append(r1)
            java.lang.String r1 = "; use KeyStore"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.AFInAppEventParameterName(r0)
            com.appsflyer.AFKeystoreWrapper r0 = new com.appsflyer.AFKeystoreWrapper
            r0.<init>(r4)
            boolean r1 = r0.AFInAppEventParameterName()
            if (r1 != 0) goto L_0x0054
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            java.lang.String r4 = com.appsflyer.internal.an.AFKeystoreWrapper(r1)
            r0.AFInAppEventType = r4
            r4 = 0
            r0.valueOf = r4
            java.lang.String r4 = r0.AFInAppEventType()
            r0.AFInAppEventType(r4)
            goto L_0x009d
        L_0x0054:
            java.lang.String r4 = r0.AFInAppEventType()
            java.lang.Object r1 = r0.values
            monitor-enter(r1)
            int r3 = r0.valueOf     // Catch:{ all -> 0x00bc }
            int r3 = r3 + r2
            r0.valueOf = r3     // Catch:{ all -> 0x00bc }
            java.lang.String r2 = "Deleting key with alias: "
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00bc }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x00bc }
            com.appsflyer.AFLogger.AFKeystoreWrapper(r2)     // Catch:{ all -> 0x00bc }
            java.lang.Object r2 = r0.values     // Catch:{ KeyStoreException -> 0x007a }
            monitor-enter(r2)     // Catch:{ KeyStoreException -> 0x007a }
            java.security.KeyStore r3 = r0.AFInAppEventParameterName     // Catch:{ all -> 0x0077 }
            r3.deleteEntry(r4)     // Catch:{ all -> 0x0077 }
            monitor-exit(r2)     // Catch:{ all -> 0x0077 }
            goto L_0x0095
        L_0x0077:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ KeyStoreException -> 0x007a }
            throw r4     // Catch:{ KeyStoreException -> 0x007a }
        L_0x007a:
            r4 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = "Exception "
            r2.<init>(r3)     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = r4.getMessage()     // Catch:{ all -> 0x00bc }
            r2.append(r3)     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = " occurred"
            r2.append(r3)     // Catch:{ all -> 0x00bc }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00bc }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r2, (java.lang.Throwable) r4)     // Catch:{ all -> 0x00bc }
        L_0x0095:
            monitor-exit(r1)     // Catch:{ all -> 0x00bc }
            java.lang.String r4 = r0.AFInAppEventType()
            r0.AFInAppEventType(r4)
        L_0x009d:
            java.lang.String r4 = "KSAppsFlyerId"
            java.lang.String r1 = r0.values()
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            r2.set((java.lang.String) r4, (java.lang.String) r1)
            java.lang.String r4 = "KSAppsFlyerRICounter"
            int r0 = r0.valueOf()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            r1.set((java.lang.String) r4, (java.lang.String) r0)
            return
        L_0x00bc:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        L_0x00bf:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "OS SDK is="
            r4.<init>(r0)
            r4.append(r1)
            java.lang.String r0 = "; no KeyStore usage"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.AFInAppEventParameterName(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ae.AFKeystoreWrapper(android.content.Context):void");
    }

    private static boolean values(File file) {
        return file == null || !file.exists();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r6 = com.appsflyer.internal.as.AFInAppEventType(r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void values(com.appsflyer.internal.g r5, android.app.Activity r6) {
        /*
            r4 = this;
            android.app.Application r0 = r5.valueOf
            java.lang.String r1 = ""
            if (r6 == 0) goto L_0x0011
            android.net.Uri r6 = com.appsflyer.internal.as.AFInAppEventType(r6)
            if (r6 == 0) goto L_0x0011
            java.lang.String r6 = r6.toString()
            goto L_0x0012
        L_0x0011:
            r6 = r1
        L_0x0012:
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r3 = "AppsFlyerKey"
            java.lang.String r2 = r2.getString(r3)
            if (r2 != 0) goto L_0x002f
            java.lang.String r6 = "[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey."
            com.appsflyer.AFLogger.init(r6)
            com.appsflyer.attribution.AppsFlyerRequestListener r5 = r5.AFKeystoreWrapper
            if (r5 == 0) goto L_0x002e
            int r6 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r0 = com.appsflyer.internal.ax.AFKeystoreWrapper
            r5.onError(r6, r0)
        L_0x002e:
            return
        L_0x002f:
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r2.getReferrer(r0)
            if (r0 != 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = r0
        L_0x003b:
            r5.init = r1
            r5.AFInAppEventParameterName = r6
            r4.AFInAppEventType((com.appsflyer.internal.g) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ae.values(com.appsflyer.internal.g, android.app.Activity):void");
    }

    public static String AFInAppEventParameterName(SimpleDateFormat simpleDateFormat, long j11) {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        return simpleDateFormat.format(new Date(j11));
    }

    public final String valueOf(Context context) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CHANNEL);
        if (string == null) {
            string = context == null ? null : AFKeystoreWrapper("CHANNEL", context.getPackageManager(), context.getPackageName());
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }

    private static String AFInAppEventParameterName(Activity activity) {
        Intent intent;
        String str = null;
        if (!(activity == null || (intent = activity.getIntent()) == null)) {
            try {
                Bundle extras = intent.getExtras();
                if (!(extras == null || (str = extras.getString("af")) == null)) {
                    AFLogger.AFKeystoreWrapper("Push Notification received af payload = ".concat(str));
                    extras.remove("af");
                    activity.setIntent(intent.putExtras(extras));
                }
            } catch (Throwable th2) {
                AFLogger.AFInAppEventType(th2.getMessage(), th2);
            }
        }
        return str;
    }

    public static void AFInAppEventType(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j11, TimeUnit timeUnit) {
        if (scheduledExecutorService != null) {
            try {
                if (!scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
                    scheduledExecutorService.schedule(runnable, j11, timeUnit);
                    return;
                }
            } catch (RejectedExecutionException e11) {
                AFLogger.AFInAppEventType("scheduleJob failed with RejectedExecutionException Exception", (Throwable) e11);
                return;
            } catch (Throwable th2) {
                AFLogger.AFInAppEventType("scheduleJob failed with Exception", th2);
                return;
            }
        }
        AFLogger.init("scheduler is null, shut downed or terminated");
    }

    public static int valueOf(SharedPreferences sharedPreferences, String str, boolean z11) {
        int i11 = sharedPreferences.getInt(str, 0);
        if (z11) {
            i11++;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i11);
            edit.apply();
        }
        if (aj.valueOf().getLevel()) {
            aj.valueOf().AFInAppEventParameterName(String.valueOf(i11));
        }
        return i11;
    }

    private void AFInAppEventType(g gVar) {
        boolean z11 = gVar.AFLogger$LogLevel == null;
        if (valueOf()) {
            AFLogger.AFInAppEventType("CustomerUserId not set, reporting is disabled", true);
            return;
        }
        if (z11) {
            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                AFLogger.AFKeystoreWrapper("Allowing multiple launches within a 5 second time window.");
            } else if (AFKeystoreWrapper()) {
                AppsFlyerRequestListener appsFlyerRequestListener = gVar.AFKeystoreWrapper;
                if (appsFlyerRequestListener != null) {
                    appsFlyerRequestListener.onError(RequestError.EVENT_TIMEOUT, ax.valueOf);
                    return;
                }
                return;
            }
            this.onDeepLinking = System.currentTimeMillis();
        }
        if (k.valueOf == null) {
            k.valueOf = new k();
        }
        AFInAppEventType(k.valueOf.AFInAppEventParameterName(), new c(this, gVar, (byte) 0), 0, TimeUnit.MILLISECONDS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0673, code lost:
        if (r8 != null) goto L_0x0675;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:80:0x022f */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0281 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0284 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x029b A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x037d A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0390 A[Catch:{ Exception -> 0x0396 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03d7 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03dd A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0412 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x042b A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x04ba A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04cf A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04d0 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x04e4 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x04f1 A[SYNTHETIC, Splitter:B:225:0x04f1] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x050f A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x051e A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x052b A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0531 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0548 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0560 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0577 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x05a5 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x05c1 A[SYNTHETIC, Splitter:B:262:0x05c1] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x05e0 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x05f1 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x05fa A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x064f A[SYNTHETIC, Splitter:B:295:0x064f] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0657 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x067a A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0690 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x06ad A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x06e6 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x06ee A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0704 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x070f A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x073d A[SYNTHETIC, Splitter:B:352:0x073d] */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x07f7 A[Catch:{ all -> 0x085f }] */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x088f A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0898 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x08cf A[SYNTHETIC, Splitter:B:431:0x08cf] */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x091b A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x0940 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:453:0x0976 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:454:0x0978 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:457:0x0988  */
    /* JADX WARNING: Removed duplicated region for block: B:482:0x0a08 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0a09 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:486:0x0a44 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:508:0x0bad A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:511:0x0c29 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:512:0x0c38 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:515:0x0c71 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:516:0x0c77 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0233 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0240 A[SYNTHETIC, Splitter:B:87:0x0240] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x024c A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0272 A[Catch:{ Exception -> 0x00c9, all -> 0x0c83 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> values(com.appsflyer.internal.g r32) {
        /*
            r31 = this;
            r1 = r31
            r2 = r32
            java.lang.String r3 = "AppsFlyerTimePassedSincePrevLaunch"
            java.lang.String r4 = "yyyy-MM-dd_HHmmssZ"
            java.lang.String r5 = "use cached IMEI: "
            java.lang.String r6 = "uid"
            java.lang.String r7 = "appid"
            java.lang.String r8 = "INSTALL_STORE"
            java.lang.String r9 = "gcd"
            java.lang.String r10 = "prev_event_name"
            java.lang.String r11 = "preInstallName"
            android.app.Application r12 = r2.valueOf
            java.lang.String r13 = r2.AFVersionDeclaration
            java.lang.String r14 = r2.AFLogger$LogLevel
            org.json.JSONObject r15 = new org.json.JSONObject
            r16 = r4
            java.util.Map<java.lang.String, java.lang.Object> r4 = r2.values
            if (r4 != 0) goto L_0x0029
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
        L_0x0029:
            r15.<init>(r4)
            java.lang.String r4 = r15.toString()
            java.lang.String r15 = r2.init
            r17 = r6
            android.content.SharedPreferences r6 = values((android.content.Context) r12)
            r18 = r5
            boolean r5 = r32.AFKeystoreWrapper()
            r19 = r7
            java.lang.String r7 = r2.AFInAppEventParameterName
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.AFInAppEventType
            com.appsflyer.internal.ab.valueOf(r12, r2)
            java.lang.Boolean r20 = com.appsflyer.internal.ab.AFInAppEventType
            r21 = r7
            if (r20 == 0) goto L_0x006d
            boolean r22 = r20.booleanValue()
            if (r22 != 0) goto L_0x006d
            java.util.Map r7 = AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r2)
            boolean r20 = r20.booleanValue()
            r22 = 1
            r20 = r20 ^ 1
            r22 = r13
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r20)
            r20 = r11
            java.lang.String r11 = "ad_ids_disabled"
            r7.put(r11, r13)
            goto L_0x0071
        L_0x006d:
            r20 = r11
            r22 = r13
        L_0x0071:
            java.util.Date r7 = new java.util.Date
            r7.<init>()
            r11 = r8
            long r7 = r7.getTime()
            java.lang.String r13 = java.lang.Long.toString(r7)
            r23 = r11
            java.lang.String r11 = "af_timestamp"
            r2.put(r11, r13)
            java.lang.String r7 = com.appsflyer.internal.d.values((android.content.Context) r12, (long) r7)
            if (r7 == 0) goto L_0x0091
            java.lang.String r8 = "cksm_v1"
            r2.put(r8, r7)
        L_0x0091:
            boolean r7 = r31.isStopped()     // Catch:{ all -> 0x0c83 }
            if (r7 != 0) goto L_0x00af
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "******* sendTrackingWithEvent: "
            r7.<init>(r8)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x00a3
            java.lang.String r8 = "Launch"
            goto L_0x00a4
        L_0x00a3:
            r8 = r14
        L_0x00a4:
            r7.append(r8)     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AFLogger.AFKeystoreWrapper(r7)     // Catch:{ all -> 0x0c83 }
            goto L_0x00b4
        L_0x00af:
            java.lang.String r7 = "Reporting has been stopped"
            com.appsflyer.AFLogger.AFKeystoreWrapper(r7)     // Catch:{ all -> 0x0c83 }
        L_0x00b4:
            com.appsflyer.internal.ai.AFKeystoreWrapper()     // Catch:{ all -> 0x0c83 }
            java.io.File r7 = com.appsflyer.internal.ai.AFKeystoreWrapper(r12)     // Catch:{ Exception -> 0x00c9 }
            boolean r7 = r7.exists()     // Catch:{ Exception -> 0x00c9 }
            if (r7 != 0) goto L_0x00d0
            java.io.File r7 = com.appsflyer.internal.ai.AFKeystoreWrapper(r12)     // Catch:{ Exception -> 0x00c9 }
            r7.mkdir()     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00d0
        L_0x00c9:
            r0 = move-exception
            r7 = r0
            java.lang.String r8 = "Could not create cache directory"
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r8, (java.lang.Throwable) r7)     // Catch:{ all -> 0x0c83 }
        L_0x00d0:
            android.content.pm.PackageManager r7 = r12.getPackageManager()     // Catch:{ Exception -> 0x010c }
            java.lang.String r8 = r12.getPackageName()     // Catch:{ Exception -> 0x010c }
            r13 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r8, r13)     // Catch:{ Exception -> 0x010c }
            java.lang.String[] r7 = r7.requestedPermissions     // Catch:{ Exception -> 0x010c }
            java.util.List r7 = java.util.Arrays.asList(r7)     // Catch:{ Exception -> 0x010c }
            java.lang.String r8 = "android.permission.INTERNET"
            boolean r8 = r7.contains(r8)     // Catch:{ Exception -> 0x010c }
            if (r8 != 0) goto L_0x00f1
            java.lang.String r8 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.init(r8)     // Catch:{ Exception -> 0x010c }
        L_0x00f1:
            java.lang.String r8 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r8 = r7.contains(r8)     // Catch:{ Exception -> 0x010c }
            if (r8 != 0) goto L_0x00fe
            java.lang.String r8 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.init(r8)     // Catch:{ Exception -> 0x010c }
        L_0x00fe:
            java.lang.String r8 = "android.permission.ACCESS_WIFI_STATE"
            boolean r7 = r7.contains(r8)     // Catch:{ Exception -> 0x010c }
            if (r7 != 0) goto L_0x0113
            java.lang.String r7 = "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.init(r7)     // Catch:{ Exception -> 0x010c }
            goto L_0x0113
        L_0x010c:
            r0 = move-exception
            r7 = r0
            java.lang.String r8 = "Exception while validation permissions. "
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r8, (java.lang.Throwable) r7)     // Catch:{ all -> 0x0c83 }
        L_0x0113:
            java.lang.String r7 = "af_events_api"
            java.lang.String r8 = "1"
            r2.put(r7, r8)     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "brand"
            java.lang.String r8 = android.os.Build.BRAND     // Catch:{ all -> 0x0c83 }
            r2.put(r7, r8)     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "device"
            java.lang.String r8 = android.os.Build.DEVICE     // Catch:{ all -> 0x0c83 }
            r2.put(r7, r8)     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "product"
            java.lang.String r8 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0c83 }
            r2.put(r7, r8)     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "sdk"
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0c83 }
            java.lang.String r13 = java.lang.Integer.toString(r8)     // Catch:{ all -> 0x0c83 }
            r2.put(r7, r13)     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "model"
            java.lang.String r13 = android.os.Build.MODEL     // Catch:{ all -> 0x0c83 }
            r2.put(r7, r13)     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "deviceType"
            java.lang.String r13 = android.os.Build.TYPE     // Catch:{ all -> 0x0c83 }
            r2.put(r7, r13)     // Catch:{ all -> 0x0c83 }
            values((android.content.Context) r12, (java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            com.appsflyer.internal.au r13 = r1.init     // Catch:{ all -> 0x0c83 }
            if (r13 != 0) goto L_0x015a
            com.appsflyer.internal.au r13 = new com.appsflyer.internal.au     // Catch:{ all -> 0x0c83 }
            r13.<init>(r12)     // Catch:{ all -> 0x0c83 }
            r1.init = r13     // Catch:{ all -> 0x0c83 }
        L_0x015a:
            com.appsflyer.internal.au r13 = r1.init     // Catch:{ all -> 0x0c83 }
            r24 = r10
            r25 = r11
            if (r5 == 0) goto L_0x02cc
            boolean r11 = AFInAppEventParameterName((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            if (r11 == 0) goto L_0x01b0
            boolean r11 = r7.isOtherSdkStringDisabled()     // Catch:{ all -> 0x0c83 }
            if (r11 != 0) goto L_0x017b
            float r11 = AFVersionDeclaration((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            java.lang.String r10 = "batteryLevel"
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0c83 }
            r2.put(r10, r11)     // Catch:{ all -> 0x0c83 }
        L_0x017b:
            AFKeystoreWrapper((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            r10 = 23
            if (r8 < r10) goto L_0x018b
            java.lang.Class<android.app.UiModeManager> r8 = android.app.UiModeManager.class
            java.lang.Object r8 = r12.getSystemService(r8)     // Catch:{ all -> 0x0c83 }
            android.app.UiModeManager r8 = (android.app.UiModeManager) r8     // Catch:{ all -> 0x0c83 }
            goto L_0x0193
        L_0x018b:
            java.lang.String r8 = "uimode"
            java.lang.Object r8 = r12.getSystemService(r8)     // Catch:{ all -> 0x0c83 }
            android.app.UiModeManager r8 = (android.app.UiModeManager) r8     // Catch:{ all -> 0x0c83 }
        L_0x0193:
            if (r8 == 0) goto L_0x01a3
            int r8 = r8.getCurrentModeType()     // Catch:{ all -> 0x0c83 }
            r10 = 4
            if (r8 != r10) goto L_0x01a3
            java.lang.String r8 = "tv"
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0c83 }
            r2.put(r8, r10)     // Catch:{ all -> 0x0c83 }
        L_0x01a3:
            boolean r8 = com.appsflyer.internal.bc.valueOf(r12)     // Catch:{ all -> 0x0c83 }
            if (r8 == 0) goto L_0x01b0
            java.lang.String r8 = "inst_app"
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0c83 }
            r2.put(r8, r10)     // Catch:{ all -> 0x0c83 }
        L_0x01b0:
            java.lang.String r8 = "timepassedsincelastlaunch"
            android.content.SharedPreferences r10 = values((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            r11 = r4
            r26 = r5
            r4 = 0
            long r27 = r10.getLong(r3, r4)     // Catch:{ all -> 0x0c83 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0c83 }
            r1.valueOf((android.content.Context) r12, (java.lang.String) r3, (long) r4)     // Catch:{ all -> 0x0c83 }
            r29 = 0
            int r3 = (r27 > r29 ? 1 : (r27 == r29 ? 0 : -1))
            if (r3 <= 0) goto L_0x01d3
            long r4 = r4 - r27
            r27 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r27
            goto L_0x01d5
        L_0x01d3:
            r4 = -1
        L_0x01d5:
            java.lang.String r3 = java.lang.Long.toString(r4)     // Catch:{ all -> 0x0c83 }
            r2.put(r8, r3)     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = "oneLinkSlug"
            java.lang.String r3 = r3.getString(r4)     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = "onelinkVersion"
            java.lang.String r4 = r4.getString(r5)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x01f7
            java.lang.String r5 = "onelink_id"
            r2.put(r5, r3)     // Catch:{ all -> 0x0c83 }
        L_0x01f7:
            if (r4 == 0) goto L_0x01fe
            java.lang.String r3 = "onelink_ver"
            r2.put(r3, r4)     // Catch:{ all -> 0x0c83 }
        L_0x01fe:
            com.appsflyer.internal.au r3 = r1.init     // Catch:{ all -> 0x0c83 }
            android.content.SharedPreferences r3 = r3.valueOf     // Catch:{ all -> 0x0c83 }
            r4 = 0
            java.lang.String r3 = r3.getString(r9, r4)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x022f
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x022f }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x022f }
            java.util.Map r3 = com.appsflyer.internal.m.AFInAppEventType((org.json.JSONObject) r4)     // Catch:{ JSONException -> 0x022f }
            boolean r4 = r3.isEmpty()     // Catch:{ JSONException -> 0x022f }
            if (r4 != 0) goto L_0x022f
            java.util.Map r4 = AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ JSONException -> 0x022f }
            r4.put(r9, r3)     // Catch:{ JSONException -> 0x022f }
            com.appsflyer.internal.au r3 = r1.init     // Catch:{ JSONException -> 0x022f }
            android.content.SharedPreferences r3 = r3.valueOf     // Catch:{ JSONException -> 0x022f }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ JSONException -> 0x022f }
            r4 = 0
            android.content.SharedPreferences$Editor r3 = r3.putString(r9, r4)     // Catch:{ JSONException -> 0x022f }
            r3.apply()     // Catch:{ JSONException -> 0x022f }
        L_0x022f:
            java.lang.String r3 = r1.setCustomerUserId     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x0238
            java.lang.String r4 = "phone"
            r2.put(r4, r3)     // Catch:{ all -> 0x0c83 }
        L_0x0238:
            boolean r3 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = "referrer"
            if (r3 != 0) goto L_0x0243
            r2.put(r4, r15)     // Catch:{ all -> 0x0c83 }
        L_0x0243:
            java.lang.String r3 = "extraReferrers"
            r5 = 0
            java.lang.String r3 = r6.getString(r3, r5)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x0251
            java.lang.String r5 = "extraReferrers"
            r2.put(r5, r3)     // Catch:{ all -> 0x0c83 }
        L_0x0251:
            java.lang.String r3 = r7.getReferrer(r12)     // Catch:{ all -> 0x0c83 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0c83 }
            if (r5 != 0) goto L_0x0264
            java.lang.Object r5 = r2.get(r4)     // Catch:{ all -> 0x0c83 }
            if (r5 != 0) goto L_0x0264
            r2.put(r4, r3)     // Catch:{ all -> 0x0c83 }
        L_0x0264:
            java.lang.String r3 = "prev_session_dur"
            android.content.SharedPreferences r4 = r13.valueOf     // Catch:{ all -> 0x0c83 }
            r8 = 0
            long r3 = r4.getLong(r3, r8)     // Catch:{ all -> 0x0c83 }
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x027b
            java.lang.String r5 = "prev_session_dur"
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0c83 }
            r2.put(r5, r3)     // Catch:{ all -> 0x0c83 }
        L_0x027b:
            java.lang.String r3 = "exception_number"
            android.app.Application r4 = com.appsflyer.internal.at.AFInAppEventParameterName     // Catch:{ all -> 0x0c83 }
            if (r4 != 0) goto L_0x0284
            r4 = -1
            goto L_0x0290
        L_0x0284:
            android.content.SharedPreferences r4 = values((android.content.Context) r4)     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = "exception_number"
            r8 = 0
            long r4 = r4.getLong(r5, r8)     // Catch:{ all -> 0x0c83 }
        L_0x0290:
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0c83 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0c83 }
            com.appsflyer.internal.av r3 = r1.setAdditionalData     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x02c4
            java.util.Map<java.lang.String, java.lang.Object> r4 = r3.valueOf     // Catch:{ all -> 0x0c83 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0c83 }
            if (r4 != 0) goto L_0x02aa
            java.lang.String r4 = "partner_data"
            java.util.Map<java.lang.String, java.lang.Object> r5 = r3.valueOf     // Catch:{ all -> 0x0c83 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0c83 }
        L_0x02aa:
            java.util.Map<java.lang.String, java.lang.Object> r4 = r3.AFKeystoreWrapper     // Catch:{ all -> 0x0c83 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0c83 }
            if (r4 != 0) goto L_0x02c4
            java.util.Map r4 = AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = "partner_data"
            java.util.Map<java.lang.String, java.lang.Object> r8 = r3.AFKeystoreWrapper     // Catch:{ all -> 0x0c83 }
            r4.put(r5, r8)     // Catch:{ all -> 0x0c83 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0c83 }
            r4.<init>()     // Catch:{ all -> 0x0c83 }
            r3.AFKeystoreWrapper = r4     // Catch:{ all -> 0x0c83 }
        L_0x02c4:
            r27 = r6
            r28 = r7
            r24 = r13
            goto L_0x0345
        L_0x02cc:
            r11 = r4
            r26 = r5
            android.content.SharedPreferences r3 = values((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            android.content.SharedPreferences$Editor r4 = r3.edit()     // Catch:{ all -> 0x0c83 }
            r5 = r24
            r8 = 0
            java.lang.String r9 = r3.getString(r5, r8)     // Catch:{ Exception -> 0x0338 }
            java.lang.String r8 = "prev_event_timestamp"
            java.lang.String r10 = "prev_event_value"
            if (r9 == 0) goto L_0x031f
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x0338 }
            r15.<init>()     // Catch:{ Exception -> 0x0338 }
            r24 = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0319 }
            r13.<init>()     // Catch:{ Exception -> 0x0319 }
            r27 = r6
            r28 = r7
            r6 = -1
            long r6 = r3.getLong(r8, r6)     // Catch:{ Exception -> 0x0336 }
            r13.append(r6)     // Catch:{ Exception -> 0x0336 }
            java.lang.String r6 = r13.toString()     // Catch:{ Exception -> 0x0336 }
            r15.put(r8, r6)     // Catch:{ Exception -> 0x0336 }
            r6 = 0
            java.lang.String r3 = r3.getString(r10, r6)     // Catch:{ Exception -> 0x0336 }
            r15.put(r10, r3)     // Catch:{ Exception -> 0x0336 }
            r15.put(r5, r9)     // Catch:{ Exception -> 0x0336 }
            java.lang.String r3 = "prev_event"
            java.lang.String r6 = r15.toString()     // Catch:{ Exception -> 0x0336 }
            r2.put(r3, r6)     // Catch:{ Exception -> 0x0336 }
            goto L_0x0325
        L_0x0319:
            r0 = move-exception
            r27 = r6
            r28 = r7
            goto L_0x033f
        L_0x031f:
            r27 = r6
            r28 = r7
            r24 = r13
        L_0x0325:
            r4.putString(r5, r14)     // Catch:{ Exception -> 0x0336 }
            r4.putString(r10, r11)     // Catch:{ Exception -> 0x0336 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0336 }
            r4.putLong(r8, r5)     // Catch:{ Exception -> 0x0336 }
            r4.apply()     // Catch:{ Exception -> 0x0336 }
            goto L_0x0345
        L_0x0336:
            r0 = move-exception
            goto L_0x033f
        L_0x0338:
            r0 = move-exception
            r27 = r6
            r28 = r7
            r24 = r13
        L_0x033f:
            r3 = r0
            java.lang.String r4 = "Error while processing previous event."
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r4, (java.lang.Throwable) r3)     // Catch:{ all -> 0x0c83 }
        L_0x0345:
            java.lang.String r3 = "KSAppsFlyerId"
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = "KSAppsFlyerRICounter"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x0371
            if (r4 == 0) goto L_0x0371
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0c83 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x0c83 }
            if (r5 <= 0) goto L_0x0371
            java.lang.String r5 = "reinstallCounter"
            r2.put(r5, r4)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = "originalAppsflyerId"
            r2.put(r4, r3)     // Catch:{ all -> 0x0c83 }
        L_0x0371:
            java.lang.String r3 = "additionalCustomData"
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x0382
            java.lang.String r4 = "customData"
            r2.put(r4, r3)     // Catch:{ all -> 0x0c83 }
        L_0x0382:
            android.content.pm.PackageManager r3 = r12.getPackageManager()     // Catch:{ Exception -> 0x0396 }
            java.lang.String r4 = r12.getPackageName()     // Catch:{ Exception -> 0x0396 }
            java.lang.String r3 = r3.getInstallerPackageName(r4)     // Catch:{ Exception -> 0x0396 }
            if (r3 == 0) goto L_0x039d
            java.lang.String r4 = "installer_package"
            r2.put(r4, r3)     // Catch:{ Exception -> 0x0396 }
            goto L_0x039d
        L_0x0396:
            r0 = move-exception
            r3 = r0
            java.lang.String r4 = "Exception while getting the app's installer package. "
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r4, (java.lang.Throwable) r3)     // Catch:{ all -> 0x0c83 }
        L_0x039d:
            java.lang.String r3 = "sdkExtension"
            r4 = r28
            java.lang.String r3 = r4.getString(r3)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x03b2
            int r5 = r3.length()     // Catch:{ all -> 0x0c83 }
            if (r5 <= 0) goto L_0x03b2
            java.lang.String r5 = "sdkExtension"
            r2.put(r5, r3)     // Catch:{ all -> 0x0c83 }
        L_0x03b2:
            java.lang.String r3 = r1.valueOf((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r1.AFKeystoreWrapper((android.content.Context) r12, (java.lang.String) r3)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x03c2
            boolean r6 = r5.equals(r3)     // Catch:{ all -> 0x0c83 }
            if (r6 == 0) goto L_0x03c6
        L_0x03c2:
            if (r5 != 0) goto L_0x03cb
            if (r3 == 0) goto L_0x03cb
        L_0x03c6:
            java.lang.String r5 = "af_latestchannel"
            r2.put(r5, r3)     // Catch:{ all -> 0x0c83 }
        L_0x03cb:
            android.content.SharedPreferences r3 = values((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            r5 = r23
            boolean r6 = r3.contains(r5)     // Catch:{ all -> 0x0c83 }
            if (r6 == 0) goto L_0x03dd
            r6 = 0
            java.lang.String r3 = r3.getString(r5, r6)     // Catch:{ all -> 0x0c83 }
            goto L_0x0410
        L_0x03dd:
            boolean r3 = AFInAppEventParameterName((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x0401
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r6 = "api_store_value"
            java.lang.String r3 = r3.getString(r6)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x03f0
            goto L_0x0402
        L_0x03f0:
            java.lang.String r3 = "AF_STORE"
            if (r12 == 0) goto L_0x0401
            android.content.pm.PackageManager r6 = r12.getPackageManager()     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = r12.getPackageName()     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = AFKeystoreWrapper((java.lang.String) r3, (android.content.pm.PackageManager) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0c83 }
            goto L_0x0402
        L_0x0401:
            r3 = 0
        L_0x0402:
            android.content.SharedPreferences r6 = values((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            android.content.SharedPreferences$Editor r6 = r6.edit()     // Catch:{ all -> 0x0c83 }
            r6.putString(r5, r3)     // Catch:{ all -> 0x0c83 }
            r6.apply()     // Catch:{ all -> 0x0c83 }
        L_0x0410:
            if (r3 == 0) goto L_0x041b
            java.lang.String r5 = "af_installstore"
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x0c83 }
            r2.put(r5, r3)     // Catch:{ all -> 0x0c83 }
        L_0x041b:
            android.content.SharedPreferences r3 = values((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            r6 = r20
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0c83 }
            if (r5 != 0) goto L_0x04b8
            boolean r7 = r3.contains(r6)     // Catch:{ all -> 0x0c83 }
            if (r7 == 0) goto L_0x0439
            r5 = 0
            java.lang.String r3 = r3.getString(r6, r5)     // Catch:{ all -> 0x0c83 }
            r5 = r3
            goto L_0x04af
        L_0x0439:
            boolean r3 = AFInAppEventParameterName((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x049f
            java.lang.String r3 = "ro.appsflyer.preinstall.path"
            java.lang.String r3 = AFInAppEventType((java.lang.String) r3)     // Catch:{ all -> 0x0c83 }
            java.io.File r3 = AFInAppEventParameterName((java.lang.String) r3)     // Catch:{ all -> 0x0c83 }
            boolean r5 = values((java.io.File) r3)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x0461
            java.lang.String r3 = "AF_PRE_INSTALL_PATH"
            android.content.pm.PackageManager r5 = r12.getPackageManager()     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = r12.getPackageName()     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = AFKeystoreWrapper((java.lang.String) r3, (android.content.pm.PackageManager) r5, (java.lang.String) r7)     // Catch:{ all -> 0x0c83 }
            java.io.File r3 = AFInAppEventParameterName((java.lang.String) r3)     // Catch:{ all -> 0x0c83 }
        L_0x0461:
            boolean r5 = values((java.io.File) r3)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x046d
            java.lang.String r3 = "/data/local/tmp/pre_install.appsflyer"
            java.io.File r3 = AFInAppEventParameterName((java.lang.String) r3)     // Catch:{ all -> 0x0c83 }
        L_0x046d:
            boolean r5 = values((java.io.File) r3)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x0479
            java.lang.String r3 = "/etc/pre_install.appsflyer"
            java.io.File r3 = AFInAppEventParameterName((java.lang.String) r3)     // Catch:{ all -> 0x0c83 }
        L_0x0479:
            boolean r5 = values((java.io.File) r3)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x0481
            r3 = 0
            goto L_0x0489
        L_0x0481:
            java.lang.String r5 = r12.getPackageName()     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = AFInAppEventType((java.io.File) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0c83 }
        L_0x0489:
            if (r3 == 0) goto L_0x048c
            goto L_0x049e
        L_0x048c:
            java.lang.String r3 = "AF_PRE_INSTALL_NAME"
            if (r12 != 0) goto L_0x0492
            r3 = 0
            goto L_0x049e
        L_0x0492:
            android.content.pm.PackageManager r5 = r12.getPackageManager()     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = r12.getPackageName()     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = AFKeystoreWrapper((java.lang.String) r3, (android.content.pm.PackageManager) r5, (java.lang.String) r7)     // Catch:{ all -> 0x0c83 }
        L_0x049e:
            r5 = r3
        L_0x049f:
            if (r5 == 0) goto L_0x04af
            android.content.SharedPreferences r3 = values((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ all -> 0x0c83 }
            r3.putString(r6, r5)     // Catch:{ all -> 0x0c83 }
            r3.apply()     // Catch:{ all -> 0x0c83 }
        L_0x04af:
            if (r5 == 0) goto L_0x04b8
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            r3.set((java.lang.String) r6, (java.lang.String) r5)     // Catch:{ all -> 0x0c83 }
        L_0x04b8:
            if (r5 == 0) goto L_0x04c3
            java.lang.String r3 = "af_preinstall_name"
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ all -> 0x0c83 }
            r2.put(r3, r5)     // Catch:{ all -> 0x0c83 }
        L_0x04c3:
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = "api_store_value"
            java.lang.String r3 = r3.getString(r5)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x04d0
            goto L_0x04e2
        L_0x04d0:
            java.lang.String r3 = "AF_STORE"
            if (r12 != 0) goto L_0x04d6
            r3 = 0
            goto L_0x04e2
        L_0x04d6:
            android.content.pm.PackageManager r5 = r12.getPackageManager()     // Catch:{ all -> 0x0c83 }
            java.lang.String r6 = r12.getPackageName()     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = AFKeystoreWrapper((java.lang.String) r3, (android.content.pm.PackageManager) r5, (java.lang.String) r6)     // Catch:{ all -> 0x0c83 }
        L_0x04e2:
            if (r3 == 0) goto L_0x04ed
            java.lang.String r5 = "af_currentstore"
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x0c83 }
            r2.put(r5, r3)     // Catch:{ all -> 0x0c83 }
        L_0x04ed:
            java.lang.String r3 = "appsflyerKey"
            if (r22 == 0) goto L_0x04fd
            int r5 = r22.length()     // Catch:{ all -> 0x0c83 }
            if (r5 <= 0) goto L_0x04fd
            r5 = r22
            r2.put(r3, r5)     // Catch:{ all -> 0x0c83 }
            goto L_0x0512
        L_0x04fd:
            java.lang.String r5 = "AppsFlyerKey"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x0c77
            int r6 = r5.length()     // Catch:{ all -> 0x0c83 }
            if (r6 <= 0) goto L_0x0c77
            r2.put(r3, r5)     // Catch:{ all -> 0x0c83 }
        L_0x0512:
            java.lang.String r5 = "AppUserId"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x0523
            java.lang.String r6 = "appUserId"
            r2.put(r6, r5)     // Catch:{ all -> 0x0c83 }
        L_0x0523:
            java.lang.String r5 = "userEmails"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x0531
            java.lang.String r6 = "user_emails"
            r2.put(r6, r5)     // Catch:{ all -> 0x0c83 }
            goto L_0x0546
        L_0x0531:
            java.lang.String r5 = "userEmail"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x0546
            java.lang.String r6 = "sha1_el"
            java.lang.String r5 = com.appsflyer.internal.af.AFKeystoreWrapper(r5)     // Catch:{ all -> 0x0c83 }
            r2.put(r6, r5)     // Catch:{ all -> 0x0c83 }
        L_0x0546:
            if (r14 == 0) goto L_0x0554
            java.lang.String r5 = "eventName"
            r2.put(r5, r14)     // Catch:{ all -> 0x0c83 }
            if (r11 == 0) goto L_0x0554
            java.lang.String r5 = "eventValue"
            r2.put(r5, r11)     // Catch:{ all -> 0x0c83 }
        L_0x0554:
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            r6 = r19
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x056b
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0c83 }
            r2.put(r6, r5)     // Catch:{ all -> 0x0c83 }
        L_0x056b:
            java.lang.String r5 = "currencyCode"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x0599
            int r6 = r5.length()     // Catch:{ all -> 0x0c83 }
            r7 = 3
            if (r6 == r7) goto L_0x0594
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "WARNING: currency code should be 3 characters!!! '"
            r6.<init>(r7)     // Catch:{ all -> 0x0c83 }
            r6.append(r5)     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "' is not a legal value."
            r6.append(r7)     // Catch:{ all -> 0x0c83 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AFLogger.init(r6)     // Catch:{ all -> 0x0c83 }
        L_0x0594:
            java.lang.String r6 = "currency"
            r2.put(r6, r5)     // Catch:{ all -> 0x0c83 }
        L_0x0599:
            java.lang.String r5 = "IS_UPDATE"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x05aa
            java.lang.String r6 = "isUpdate"
            r2.put(r6, r5)     // Catch:{ all -> 0x0c83 }
        L_0x05aa:
            boolean r5 = r1.isPreInstalledApp(r12)     // Catch:{ all -> 0x0c83 }
            java.lang.String r6 = "af_preinstalled"
            java.lang.String r5 = java.lang.Boolean.toString(r5)     // Catch:{ all -> 0x0c83 }
            r2.put(r6, r5)     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = "collectFacebookAttrId"
            r6 = 1
            boolean r5 = r4.getBoolean(r5, r6)     // Catch:{ all -> 0x0c83 }
            r6 = 0
            if (r5 == 0) goto L_0x05e5
            android.content.pm.PackageManager r5 = r12.getPackageManager()     // Catch:{ NameNotFoundException -> 0x05d8, all -> 0x05cf }
            java.lang.String r7 = "com.facebook.katana"
            r5.getApplicationInfo(r7, r6)     // Catch:{ NameNotFoundException -> 0x05d8, all -> 0x05cf }
            java.lang.String r5 = r1.getAttributionId(r12)     // Catch:{ NameNotFoundException -> 0x05d8, all -> 0x05cf }
            goto L_0x05de
        L_0x05cf:
            r0 = move-exception
            r5 = r0
            java.lang.String r7 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r7, (java.lang.Throwable) r5)     // Catch:{ all -> 0x0c83 }
        L_0x05d6:
            r5 = 0
            goto L_0x05de
        L_0x05d8:
            java.lang.String r5 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.init(r5)     // Catch:{ all -> 0x0c83 }
            goto L_0x05d6
        L_0x05de:
            if (r5 == 0) goto L_0x05e5
            java.lang.String r7 = "fb"
            r2.put(r7, r5)     // Catch:{ all -> 0x0c83 }
        L_0x05e5:
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "deviceTrackingDisabled"
            boolean r7 = r5.getBoolean(r7, r6)     // Catch:{ all -> 0x0c83 }
            if (r7 == 0) goto L_0x05fa
            java.lang.String r5 = "deviceTrackingDisabled"
            java.lang.String r7 = "true"
            r2.put(r5, r7)     // Catch:{ all -> 0x0c83 }
            goto L_0x0730
        L_0x05fa:
            android.content.SharedPreferences r7 = values((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "collectIMEI"
            r9 = 1
            boolean r8 = r5.getBoolean(r8, r9)     // Catch:{ all -> 0x0c83 }
            java.lang.String r9 = "imeiCached"
            r10 = 0
            java.lang.String r9 = r7.getString(r9, r10)     // Catch:{ all -> 0x0c83 }
            if (r8 == 0) goto L_0x0671
            java.lang.String r8 = r1.AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x0c83 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0c83 }
            if (r8 == 0) goto L_0x0671
            boolean r8 = AppsFlyer2dXConversionCallback((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            if (r8 == 0) goto L_0x0677
            java.lang.String r8 = "phone"
            java.lang.Object r8 = r12.getSystemService(r8)     // Catch:{ InvocationTargetException -> 0x065e, Exception -> 0x0649 }
            android.telephony.TelephonyManager r8 = (android.telephony.TelephonyManager) r8     // Catch:{ InvocationTargetException -> 0x065e, Exception -> 0x0649 }
            java.lang.Class r10 = r8.getClass()     // Catch:{ InvocationTargetException -> 0x065e, Exception -> 0x0649 }
            java.lang.String r11 = "getDeviceId"
            java.lang.Class[] r13 = new java.lang.Class[r6]     // Catch:{ InvocationTargetException -> 0x065e, Exception -> 0x0649 }
            java.lang.reflect.Method r10 = r10.getMethod(r11, r13)     // Catch:{ InvocationTargetException -> 0x065e, Exception -> 0x0649 }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ InvocationTargetException -> 0x065e, Exception -> 0x0649 }
            java.lang.Object r8 = r10.invoke(r8, r11)     // Catch:{ InvocationTargetException -> 0x065e, Exception -> 0x0649 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ InvocationTargetException -> 0x065e, Exception -> 0x0649 }
            if (r8 == 0) goto L_0x063b
            goto L_0x0675
        L_0x063b:
            if (r9 == 0) goto L_0x0677
            r8 = r18
            java.lang.String r10 = r8.concat(r9)     // Catch:{ InvocationTargetException -> 0x0660, Exception -> 0x0647 }
            com.appsflyer.AFLogger.values((java.lang.String) r10)     // Catch:{ InvocationTargetException -> 0x0660, Exception -> 0x0647 }
            goto L_0x0678
        L_0x0647:
            r0 = move-exception
            goto L_0x064c
        L_0x0649:
            r0 = move-exception
            r8 = r18
        L_0x064c:
            r10 = r0
            if (r9 == 0) goto L_0x0657
            java.lang.String r8 = r8.concat(r9)     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AFLogger.values((java.lang.String) r8)     // Catch:{ all -> 0x0c83 }
            goto L_0x0658
        L_0x0657:
            r9 = 0
        L_0x0658:
            java.lang.String r8 = "WARNING: other reason: "
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r8, (java.lang.Throwable) r10)     // Catch:{ all -> 0x0c83 }
            goto L_0x0678
        L_0x065e:
            r8 = r18
        L_0x0660:
            if (r9 == 0) goto L_0x066a
            java.lang.String r8 = r8.concat(r9)     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AFLogger.values((java.lang.String) r8)     // Catch:{ all -> 0x0c83 }
            goto L_0x066b
        L_0x066a:
            r9 = 0
        L_0x066b:
            java.lang.String r8 = "WARNING: READ_PHONE_STATE is missing."
            com.appsflyer.AFLogger.init(r8)     // Catch:{ all -> 0x0c83 }
            goto L_0x0678
        L_0x0671:
            java.lang.String r8 = r1.AppsFlyer2dXConversionCallback     // Catch:{ all -> 0x0c83 }
            if (r8 == 0) goto L_0x0677
        L_0x0675:
            r9 = r8
            goto L_0x0678
        L_0x0677:
            r9 = 0
        L_0x0678:
            if (r9 == 0) goto L_0x0690
            java.lang.String r8 = "imeiCached"
            android.content.SharedPreferences r10 = values((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            android.content.SharedPreferences$Editor r10 = r10.edit()     // Catch:{ all -> 0x0c83 }
            r10.putString(r8, r9)     // Catch:{ all -> 0x0c83 }
            r10.apply()     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "imei"
            r2.put(r8, r9)     // Catch:{ all -> 0x0c83 }
            goto L_0x0695
        L_0x0690:
            java.lang.String r8 = "IMEI was not collected."
            com.appsflyer.AFLogger.AFKeystoreWrapper(r8)     // Catch:{ all -> 0x0c83 }
        L_0x0695:
            java.lang.String r8 = "collectAndroidId"
            r9 = 1
            boolean r5 = r5.getBoolean(r8, r9)     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "androidIdCached"
            r9 = 0
            java.lang.String r7 = r7.getString(r8, r9)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x06e6
            java.lang.String r5 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x0c83 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x06e6
            boolean r5 = AppsFlyer2dXConversionCallback((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x06eb
            android.content.ContentResolver r5 = r12.getContentResolver()     // Catch:{ Exception -> 0x06ce }
            java.lang.String r8 = "android_id"
            java.lang.String r5 = android.provider.Settings.Secure.getString(r5, r8)     // Catch:{ Exception -> 0x06ce }
            if (r5 == 0) goto L_0x06c0
            goto L_0x06ec
        L_0x06c0:
            if (r7 == 0) goto L_0x06cc
            java.lang.String r5 = "use cached AndroidId: "
            java.lang.String r5 = r5.concat(r7)     // Catch:{ Exception -> 0x06ce }
            com.appsflyer.AFLogger.values((java.lang.String) r5)     // Catch:{ Exception -> 0x06ce }
            goto L_0x06e4
        L_0x06cc:
            r7 = 0
            goto L_0x06e4
        L_0x06ce:
            r0 = move-exception
            r5 = r0
            if (r7 == 0) goto L_0x06dc
            java.lang.String r8 = "use cached AndroidId: "
            java.lang.String r8 = r8.concat(r7)     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AFLogger.values((java.lang.String) r8)     // Catch:{ all -> 0x0c83 }
            goto L_0x06dd
        L_0x06dc:
            r7 = 0
        L_0x06dd:
            java.lang.String r8 = r5.getMessage()     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r8, (java.lang.Throwable) r5)     // Catch:{ all -> 0x0c83 }
        L_0x06e4:
            r5 = r7
            goto L_0x06ec
        L_0x06e6:
            java.lang.String r5 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x06eb
            goto L_0x06ec
        L_0x06eb:
            r5 = 0
        L_0x06ec:
            if (r5 == 0) goto L_0x0704
            java.lang.String r7 = "androidIdCached"
            android.content.SharedPreferences r8 = values((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            android.content.SharedPreferences$Editor r8 = r8.edit()     // Catch:{ all -> 0x0c83 }
            r8.putString(r7, r5)     // Catch:{ all -> 0x0c83 }
            r8.apply()     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "android_id"
            r2.put(r7, r5)     // Catch:{ all -> 0x0c83 }
            goto L_0x0709
        L_0x0704:
            java.lang.String r5 = "Android ID was not collected."
            com.appsflyer.AFLogger.AFKeystoreWrapper(r5)     // Catch:{ all -> 0x0c83 }
        L_0x0709:
            com.appsflyer.internal.d$e$d r5 = com.appsflyer.internal.ab.values(r12)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x0730
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0c83 }
            r7.<init>()     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "isManual"
            java.lang.Boolean r9 = r5.AFInAppEventParameterName     // Catch:{ all -> 0x0c83 }
            r7.put(r8, r9)     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "val"
            java.lang.String r9 = r5.values     // Catch:{ all -> 0x0c83 }
            r7.put(r8, r9)     // Catch:{ all -> 0x0c83 }
            java.lang.Boolean r5 = r5.valueOf     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x072b
            java.lang.String r8 = "isLat"
            r7.put(r8, r5)     // Catch:{ all -> 0x0c83 }
        L_0x072b:
            java.lang.String r5 = "oaid"
            r2.put(r5, r7)     // Catch:{ all -> 0x0c83 }
        L_0x0730:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x0743 }
            r5.<init>(r12)     // Catch:{ Exception -> 0x0743 }
            java.lang.String r5 = com.appsflyer.internal.an.AFKeystoreWrapper(r5)     // Catch:{ Exception -> 0x0743 }
            r7 = r17
            if (r5 == 0) goto L_0x075c
            r2.put(r7, r5)     // Catch:{ Exception -> 0x0741 }
            goto L_0x075c
        L_0x0741:
            r0 = move-exception
            goto L_0x0746
        L_0x0743:
            r0 = move-exception
            r7 = r17
        L_0x0746:
            r5 = r0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            java.lang.String r9 = "ERROR: could not get uid "
            r8.<init>(r9)     // Catch:{ all -> 0x0c83 }
            java.lang.String r9 = r5.getMessage()     // Catch:{ all -> 0x0c83 }
            r8.append(r9)     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r8, (java.lang.Throwable) r5)     // Catch:{ all -> 0x0c83 }
        L_0x075c:
            java.lang.String r5 = "lang"
            java.util.Locale r8 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x076a }
            java.lang.String r8 = r8.getDisplayLanguage()     // Catch:{ Exception -> 0x076a }
            r2.put(r5, r8)     // Catch:{ Exception -> 0x076a }
            goto L_0x0771
        L_0x076a:
            r0 = move-exception
            r5 = r0
            java.lang.String r8 = "Exception while collecting display language name. "
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r8, (java.lang.Throwable) r5)     // Catch:{ all -> 0x0c83 }
        L_0x0771:
            java.lang.String r5 = "lang_code"
            java.util.Locale r8 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x077f }
            java.lang.String r8 = r8.getLanguage()     // Catch:{ Exception -> 0x077f }
            r2.put(r5, r8)     // Catch:{ Exception -> 0x077f }
            goto L_0x0786
        L_0x077f:
            r0 = move-exception
            r5 = r0
            java.lang.String r8 = "Exception while collecting display language code. "
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r8, (java.lang.Throwable) r5)     // Catch:{ all -> 0x0c83 }
        L_0x0786:
            java.lang.String r5 = "country"
            java.util.Locale r8 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0794 }
            java.lang.String r8 = r8.getCountry()     // Catch:{ Exception -> 0x0794 }
            r2.put(r5, r8)     // Catch:{ Exception -> 0x0794 }
            goto L_0x079b
        L_0x0794:
            r0 = move-exception
            r5 = r0
            java.lang.String r8 = "Exception while collecting country name. "
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r8, (java.lang.Throwable) r5)     // Catch:{ all -> 0x0c83 }
        L_0x079b:
            java.lang.String r5 = "platformextension"
            com.appsflyer.internal.al r8 = r1.enableLocationCollection     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = r8.AFInAppEventParameterName()     // Catch:{ all -> 0x0c83 }
            r2.put(r5, r8)     // Catch:{ all -> 0x0c83 }
            valueOf((android.content.Context) r12, (java.util.Map<java.lang.String, ? super java.lang.String>) r2)     // Catch:{ all -> 0x0c83 }
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0c83 }
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ all -> 0x0c83 }
            r9 = r16
            r5.<init>(r9, r8)     // Catch:{ all -> 0x0c83 }
            android.content.pm.PackageManager r8 = r12.getPackageManager()     // Catch:{ Exception -> 0x07d8 }
            java.lang.String r10 = r12.getPackageName()     // Catch:{ Exception -> 0x07d8 }
            android.content.pm.PackageInfo r8 = r8.getPackageInfo(r10, r6)     // Catch:{ Exception -> 0x07d8 }
            long r10 = r8.firstInstallTime     // Catch:{ Exception -> 0x07d8 }
            java.lang.String r8 = "installDate"
            java.lang.String r13 = "UTC"
            java.util.TimeZone r13 = java.util.TimeZone.getTimeZone(r13)     // Catch:{ Exception -> 0x07d8 }
            r5.setTimeZone(r13)     // Catch:{ Exception -> 0x07d8 }
            java.util.Date r13 = new java.util.Date     // Catch:{ Exception -> 0x07d8 }
            r13.<init>(r10)     // Catch:{ Exception -> 0x07d8 }
            java.lang.String r10 = r5.format(r13)     // Catch:{ Exception -> 0x07d8 }
            r2.put(r8, r10)     // Catch:{ Exception -> 0x07d8 }
            goto L_0x07df
        L_0x07d8:
            r0 = move-exception
            r8 = r0
            java.lang.String r10 = "Exception while collecting install date. "
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r10, (java.lang.Throwable) r8)     // Catch:{ all -> 0x0c83 }
        L_0x07df:
            android.content.pm.PackageManager r8 = r12.getPackageManager()     // Catch:{ all -> 0x0867 }
            java.lang.String r10 = r12.getPackageName()     // Catch:{ all -> 0x0867 }
            android.content.pm.PackageInfo r8 = r8.getPackageInfo(r10, r6)     // Catch:{ all -> 0x0867 }
            java.lang.String r10 = "versionCode"
            r11 = r27
            int r10 = r11.getInt(r10, r6)     // Catch:{ all -> 0x085f }
            int r13 = r8.versionCode     // Catch:{ all -> 0x085f }
            if (r13 <= r10) goto L_0x0807
            java.lang.String r10 = "versionCode"
            android.content.SharedPreferences r15 = values((android.content.Context) r12)     // Catch:{ all -> 0x085f }
            android.content.SharedPreferences$Editor r15 = r15.edit()     // Catch:{ all -> 0x085f }
            r15.putInt(r10, r13)     // Catch:{ all -> 0x085f }
            r15.apply()     // Catch:{ all -> 0x085f }
        L_0x0807:
            java.lang.String r10 = "app_version_code"
            int r13 = r8.versionCode     // Catch:{ all -> 0x085f }
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ all -> 0x085f }
            r2.put(r10, r13)     // Catch:{ all -> 0x085f }
            java.lang.String r10 = "app_version_name"
            java.lang.String r13 = r8.versionName     // Catch:{ all -> 0x085f }
            r2.put(r10, r13)     // Catch:{ all -> 0x085f }
            r17 = r7
            long r6 = r8.firstInstallTime     // Catch:{ all -> 0x085b }
            r27 = r11
            long r10 = r8.lastUpdateTime     // Catch:{ all -> 0x0857 }
            java.lang.String r8 = "date1"
            java.text.SimpleDateFormat r15 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0857 }
            java.util.Locale r13 = java.util.Locale.US     // Catch:{ all -> 0x0857 }
            r15.<init>(r9, r13)     // Catch:{ all -> 0x0857 }
            r18 = r3
            java.util.Date r3 = new java.util.Date     // Catch:{ all -> 0x0855 }
            r3.<init>(r6)     // Catch:{ all -> 0x0855 }
            java.lang.String r3 = r15.format(r3)     // Catch:{ all -> 0x0855 }
            r2.put(r8, r3)     // Catch:{ all -> 0x0855 }
            java.lang.String r3 = "date2"
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0855 }
            r6.<init>(r9, r13)     // Catch:{ all -> 0x0855 }
            java.util.Date r7 = new java.util.Date     // Catch:{ all -> 0x0855 }
            r7.<init>(r10)     // Catch:{ all -> 0x0855 }
            java.lang.String r6 = r6.format(r7)     // Catch:{ all -> 0x0855 }
            r2.put(r3, r6)     // Catch:{ all -> 0x0855 }
            java.lang.String r3 = r1.AFInAppEventParameterName((java.text.SimpleDateFormat) r5, (android.content.Context) r12)     // Catch:{ all -> 0x0855 }
            java.lang.String r5 = "firstLaunchDate"
            r2.put(r5, r3)     // Catch:{ all -> 0x0855 }
            goto L_0x0872
        L_0x0855:
            r0 = move-exception
            goto L_0x086c
        L_0x0857:
            r0 = move-exception
            r18 = r3
            goto L_0x086c
        L_0x085b:
            r0 = move-exception
            r18 = r3
            goto L_0x0864
        L_0x085f:
            r0 = move-exception
            r18 = r3
            r17 = r7
        L_0x0864:
            r27 = r11
            goto L_0x086c
        L_0x0867:
            r0 = move-exception
            r18 = r3
            r17 = r7
        L_0x086c:
            r3 = r0
            java.lang.String r5 = "Exception while collecting app version data "
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r5, (java.lang.Throwable) r3)     // Catch:{ all -> 0x0c83 }
        L_0x0872:
            boolean r3 = com.appsflyer.internal.bb.values(r12)     // Catch:{ all -> 0x0c83 }
            r1.onPause = r3     // Catch:{ all -> 0x0c83 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = "didConfigureTokenRefreshService="
            r3.<init>(r5)     // Catch:{ all -> 0x0c83 }
            boolean r5 = r1.onPause     // Catch:{ all -> 0x0c83 }
            r3.append(r5)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AFLogger.values((java.lang.String) r3)     // Catch:{ all -> 0x0c83 }
            boolean r3 = r1.onPause     // Catch:{ all -> 0x0c83 }
            if (r3 != 0) goto L_0x0896
            java.lang.String r3 = "tokenRefreshConfigured"
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0c83 }
            r2.put(r3, r5)     // Catch:{ all -> 0x0c83 }
        L_0x0896:
            if (r26 == 0) goto L_0x08cb
            java.lang.String r3 = r1.updateServerUninstallToken     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x08c1
            java.lang.String r3 = "af_deeplink"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x08aa
            java.lang.String r3 = "Skip 'af' payload as deeplink was found by path"
            com.appsflyer.AFLogger.values((java.lang.String) r3)     // Catch:{ all -> 0x0c83 }
            goto L_0x08c1
        L_0x08aa:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r1.updateServerUninstallToken     // Catch:{ all -> 0x0c83 }
            r3.<init>(r5)     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = "isPush"
            java.lang.String r6 = "true"
            r3.put(r5, r6)     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = "af_deeplink"
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0c83 }
            r2.put(r5, r3)     // Catch:{ all -> 0x0c83 }
        L_0x08c1:
            r3 = 0
            r1.updateServerUninstallToken = r3     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = "open_referrer"
            r5 = r21
            r2.put(r3, r5)     // Catch:{ all -> 0x0c83 }
        L_0x08cb:
            java.lang.String r3 = "sensors"
            if (r26 != 0) goto L_0x090f
            com.appsflyer.internal.z r5 = com.appsflyer.internal.z.AFKeystoreWrapper((android.content.Context) r12)     // Catch:{ Exception -> 0x08f8 }
            java.util.concurrent.ConcurrentHashMap r6 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x08f8 }
            r6.<init>()     // Catch:{ Exception -> 0x08f8 }
            java.util.List r5 = r5.values()     // Catch:{ Exception -> 0x08f8 }
            boolean r7 = r5.isEmpty()     // Catch:{ Exception -> 0x08f8 }
            if (r7 != 0) goto L_0x08ef
            com.appsflyer.internal.i r7 = new com.appsflyer.internal.i     // Catch:{ Exception -> 0x08f8 }
            r7.<init>()     // Catch:{ Exception -> 0x08f8 }
            java.util.Map r5 = r7.AFInAppEventType(r5)     // Catch:{ Exception -> 0x08f8 }
            r6.put(r3, r5)     // Catch:{ Exception -> 0x08f8 }
            goto L_0x08f4
        L_0x08ef:
            java.lang.String r5 = "na"
            r6.put(r3, r5)     // Catch:{ Exception -> 0x08f8 }
        L_0x08f4:
            r2.putAll(r6)     // Catch:{ Exception -> 0x08f8 }
            goto L_0x090f
        L_0x08f8:
            r0 = move-exception
            r5 = r0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "Unexpected exception from AFSensorManager: "
            r6.<init>(r7)     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0c83 }
            r6.append(r5)     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0c83 }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r5)     // Catch:{ all -> 0x0c83 }
        L_0x090f:
            java.lang.String r5 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0c83 }
            if (r5 != 0) goto L_0x0936
            com.appsflyer.internal.ab.valueOf(r12, r2)     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = "GAID_retry"
            java.lang.String r6 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0c83 }
            java.lang.String r6 = r7.getString(r6)     // Catch:{ all -> 0x0c83 }
            if (r6 == 0) goto L_0x092e
            r6 = 1
            goto L_0x092f
        L_0x092e:
            r6 = 0
        L_0x092f:
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0c83 }
            r2.put(r5, r6)     // Catch:{ all -> 0x0c83 }
        L_0x0936:
            android.content.ContentResolver r5 = r12.getContentResolver()     // Catch:{ all -> 0x0c83 }
            com.appsflyer.internal.d$e$d r5 = com.appsflyer.internal.ab.AFInAppEventParameterName(r5)     // Catch:{ all -> 0x0c83 }
            if (r5 == 0) goto L_0x0952
            java.lang.String r6 = "amazon_aid"
            java.lang.String r7 = r5.values     // Catch:{ all -> 0x0c83 }
            r2.put(r6, r7)     // Catch:{ all -> 0x0c83 }
            java.lang.String r6 = "amazon_aid_limit"
            java.lang.Boolean r5 = r5.valueOf     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0c83 }
            r2.put(r6, r5)     // Catch:{ all -> 0x0c83 }
        L_0x0952:
            boolean r5 = com.appsflyer.internal.bb.AFInAppEventParameterName((android.content.SharedPreferences) r27)     // Catch:{ all -> 0x0c83 }
            java.lang.String r6 = "registeredUninstall"
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0c83 }
            r2.put(r6, r5)     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = "appsFlyerCount"
            r7 = r26
            r6 = r27
            int r5 = valueOf((android.content.SharedPreferences) r6, (java.lang.String) r5, (boolean) r7)     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "counter"
            java.lang.String r9 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x0c83 }
            r2.put(r8, r9)     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "iaecounter"
            if (r14 == 0) goto L_0x0978
            r9 = 1
            goto L_0x0979
        L_0x0978:
            r9 = 0
        L_0x0979:
            java.lang.String r10 = "appsFlyerInAppEventCount"
            int r9 = valueOf((android.content.SharedPreferences) r6, (java.lang.String) r10, (boolean) r9)     // Catch:{ all -> 0x0c83 }
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch:{ all -> 0x0c83 }
            r2.put(r8, r9)     // Catch:{ all -> 0x0c83 }
            if (r7 == 0) goto L_0x09fd
            java.lang.String r8 = "first_launch"
            r9 = 1
            if (r5 == r9) goto L_0x09b3
            r4 = 2
            if (r5 == r4) goto L_0x0991
            goto L_0x09fd
        L_0x0991:
            java.util.Map r4 = AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0c83 }
            r9 = r24
            android.content.SharedPreferences r10 = r9.valueOf     // Catch:{ all -> 0x0c83 }
            r11 = 0
            java.lang.String r10 = r10.getString(r8, r11)     // Catch:{ all -> 0x0c83 }
            if (r10 == 0) goto L_0x09ff
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x0c83 }
            r11.<init>(r10)     // Catch:{ all -> 0x0c83 }
            java.util.Map r10 = com.appsflyer.internal.m.AFInAppEventType((org.json.JSONObject) r11)     // Catch:{ all -> 0x0c83 }
            boolean r11 = r10.isEmpty()     // Catch:{ all -> 0x0c83 }
            if (r11 != 0) goto L_0x09ff
            r4.put(r8, r10)     // Catch:{ all -> 0x0c83 }
            goto L_0x09ff
        L_0x09b3:
            r11 = r9
            r9 = r24
            r4.AFInAppEventParameterName = r11     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = "waitForCustomerId"
            r10 = 0
            boolean r4 = AFInAppEventType((java.lang.String) r4, (boolean) r10)     // Catch:{ all -> 0x0c83 }
            if (r4 == 0) goto L_0x09ca
            java.lang.String r4 = "wait_cid"
            java.lang.String r13 = java.lang.Boolean.toString(r11)     // Catch:{ all -> 0x0c83 }
            r2.put(r4, r13)     // Catch:{ all -> 0x0c83 }
        L_0x09ca:
            java.util.Map r4 = AFKeystoreWrapper((java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0c83 }
            java.lang.String r13 = "ddl"
            android.content.SharedPreferences r14 = r9.valueOf     // Catch:{ all -> 0x0c83 }
            r15 = 0
            java.lang.String r13 = r14.getString(r13, r15)     // Catch:{ all -> 0x0c83 }
            if (r13 == 0) goto L_0x09ed
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x0c83 }
            r14.<init>(r13)     // Catch:{ all -> 0x0c83 }
            java.util.Map r13 = com.appsflyer.internal.m.AFInAppEventType((org.json.JSONObject) r14)     // Catch:{ all -> 0x0c83 }
            boolean r14 = r13.isEmpty()     // Catch:{ all -> 0x0c83 }
            if (r14 != 0) goto L_0x09ed
            java.lang.String r14 = "ddl"
            r4.put(r14, r13)     // Catch:{ all -> 0x0c83 }
        L_0x09ed:
            org.json.JSONObject r13 = r1.setUserEmails     // Catch:{ all -> 0x0c83 }
            java.util.Map r13 = com.appsflyer.internal.m.AFInAppEventType((org.json.JSONObject) r13)     // Catch:{ all -> 0x0c83 }
            boolean r14 = r13.isEmpty()     // Catch:{ all -> 0x0c83 }
            if (r14 != 0) goto L_0x0a00
            r4.put(r8, r13)     // Catch:{ all -> 0x0c83 }
            goto L_0x0a00
        L_0x09fd:
            r9 = r24
        L_0x09ff:
            r11 = 1
        L_0x0a00:
            java.lang.String r4 = "isFirstCall"
            boolean r8 = values((android.content.SharedPreferences) r6)     // Catch:{ all -> 0x0c83 }
            if (r8 != 0) goto L_0x0a09
            goto L_0x0a0a
        L_0x0a09:
            r11 = 0
        L_0x0a0a:
            java.lang.String r8 = java.lang.Boolean.toString(r11)     // Catch:{ all -> 0x0c83 }
            r2.put(r4, r8)     // Catch:{ all -> 0x0c83 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0c83 }
            r4.<init>()     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "cpu_abi"
            java.lang.String r11 = "ro.product.cpu.abi"
            java.lang.String r11 = AFInAppEventType((java.lang.String) r11)     // Catch:{ all -> 0x0c83 }
            r4.put(r8, r11)     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "cpu_abi2"
            java.lang.String r11 = "ro.product.cpu.abi2"
            java.lang.String r11 = AFInAppEventType((java.lang.String) r11)     // Catch:{ all -> 0x0c83 }
            r4.put(r8, r11)     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "arch"
            java.lang.String r11 = "os.arch"
            java.lang.String r11 = AFInAppEventType((java.lang.String) r11)     // Catch:{ all -> 0x0c83 }
            r4.put(r8, r11)     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "build_display_id"
            java.lang.String r11 = "ro.build.display.id"
            java.lang.String r11 = AFInAppEventType((java.lang.String) r11)     // Catch:{ all -> 0x0c83 }
            r4.put(r8, r11)     // Catch:{ all -> 0x0c83 }
            if (r7 == 0) goto L_0x0acc
            boolean r7 = r1.getSdkVersion     // Catch:{ all -> 0x0c83 }
            if (r7 == 0) goto L_0x0a88
            com.appsflyer.internal.u r7 = com.appsflyer.internal.u.c.AFInAppEventParameterName     // Catch:{ all -> 0x0c83 }
            android.location.Location r7 = r7.valueOf(r12)     // Catch:{ all -> 0x0c83 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x0c83 }
            r11 = 3
            r8.<init>(r11)     // Catch:{ all -> 0x0c83 }
            if (r7 == 0) goto L_0x0a7d
            java.lang.String r11 = "lat"
            double r13 = r7.getLatitude()     // Catch:{ all -> 0x0c83 }
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x0c83 }
            r8.put(r11, r13)     // Catch:{ all -> 0x0c83 }
            java.lang.String r11 = "lon"
            double r13 = r7.getLongitude()     // Catch:{ all -> 0x0c83 }
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x0c83 }
            r8.put(r11, r13)     // Catch:{ all -> 0x0c83 }
            java.lang.String r11 = "ts"
            long r13 = r7.getTime()     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x0c83 }
            r8.put(r11, r7)     // Catch:{ all -> 0x0c83 }
        L_0x0a7d:
            boolean r7 = r8.isEmpty()     // Catch:{ all -> 0x0c83 }
            if (r7 != 0) goto L_0x0a88
            java.lang.String r7 = "loc"
            r4.put(r7, r8)     // Catch:{ all -> 0x0c83 }
        L_0x0a88:
            com.appsflyer.internal.c r7 = com.appsflyer.internal.c.C0073c.AFKeystoreWrapper     // Catch:{ all -> 0x0c83 }
            com.appsflyer.internal.c$e r7 = r7.values(r12)     // Catch:{ all -> 0x0c83 }
            java.lang.String r8 = "btl"
            float r11 = r7.values     // Catch:{ all -> 0x0c83 }
            java.lang.String r11 = java.lang.Float.toString(r11)     // Catch:{ all -> 0x0c83 }
            r4.put(r8, r11)     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = r7.AFKeystoreWrapper     // Catch:{ all -> 0x0c83 }
            if (r7 == 0) goto L_0x0aa2
            java.lang.String r8 = "btch"
            r4.put(r8, r7)     // Catch:{ all -> 0x0c83 }
        L_0x0aa2:
            r7 = 2
            if (r5 > r7) goto L_0x0acc
            com.appsflyer.internal.z r5 = com.appsflyer.internal.z.AFKeystoreWrapper((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            java.util.concurrent.ConcurrentHashMap r7 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x0c83 }
            r7.<init>()     // Catch:{ all -> 0x0c83 }
            java.util.List r8 = r5.AFInAppEventParameterName()     // Catch:{ all -> 0x0c83 }
            boolean r11 = r8.isEmpty()     // Catch:{ all -> 0x0c83 }
            if (r11 != 0) goto L_0x0abc
            r7.put(r3, r8)     // Catch:{ all -> 0x0c83 }
            goto L_0x0ac9
        L_0x0abc:
            java.util.List r5 = r5.values()     // Catch:{ all -> 0x0c83 }
            boolean r8 = r5.isEmpty()     // Catch:{ all -> 0x0c83 }
            if (r8 != 0) goto L_0x0ac9
            r7.put(r3, r5)     // Catch:{ all -> 0x0c83 }
        L_0x0ac9:
            r4.putAll(r7)     // Catch:{ all -> 0x0c83 }
        L_0x0acc:
            java.util.Map r3 = com.appsflyer.internal.w.AFInAppEventParameterName(r12)     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = "dim"
            r4.put(r5, r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = "deviceData"
            r2.put(r3, r4)     // Catch:{ all -> 0x0c83 }
            r3 = r18
            java.lang.Object r4 = r2.get(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0c83 }
            r5 = r25
            java.lang.Object r7 = r2.get(r5)     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0c83 }
            r8 = r17
            java.lang.Object r11 = r2.get(r8)     // Catch:{ all -> 0x0c83 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0c83 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            r13.<init>()     // Catch:{ all -> 0x0c83 }
            r14 = 7
            r10 = 0
            java.lang.String r4 = r4.substring(r10, r14)     // Catch:{ all -> 0x0c83 }
            r13.append(r4)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = r11.substring(r10, r14)     // Catch:{ all -> 0x0c83 }
            r13.append(r4)     // Catch:{ all -> 0x0c83 }
            int r4 = r7.length()     // Catch:{ all -> 0x0c83 }
            int r4 = r4 - r14
            java.lang.String r4 = r7.substring(r4)     // Catch:{ all -> 0x0c83 }
            r13.append(r4)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = r13.toString()     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = com.appsflyer.internal.af.AFKeystoreWrapper(r4)     // Catch:{ all -> 0x0c83 }
            java.lang.String r7 = "af_v"
            r2.put(r7, r4)     // Catch:{ all -> 0x0c83 }
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0c83 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            r4.<init>()     // Catch:{ all -> 0x0c83 }
            r4.append(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.Object r3 = r2.get(r5)     // Catch:{ all -> 0x0c83 }
            r4.append(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0c83 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            r4.<init>()     // Catch:{ all -> 0x0c83 }
            r4.append(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.Object r3 = r2.get(r8)     // Catch:{ all -> 0x0c83 }
            r4.append(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0c83 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            r4.<init>()     // Catch:{ all -> 0x0c83 }
            r4.append(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = "installDate"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0c83 }
            r4.append(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0c83 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            r4.<init>()     // Catch:{ all -> 0x0c83 }
            r4.append(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = "counter"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0c83 }
            r4.append(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0c83 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            r4.<init>()     // Catch:{ all -> 0x0c83 }
            r4.append(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = "iaecounter"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0c83 }
            r4.append(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = com.appsflyer.internal.af.AFInAppEventType(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = com.appsflyer.internal.af.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = "af_v2"
            r2.put(r4, r3)     // Catch:{ all -> 0x0c83 }
            boolean r3 = getLevel((android.content.Context) r12)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = "ivc"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0c83 }
            r2.put(r4, r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = "is_stop_tracking_used"
            boolean r3 = r6.contains(r3)     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x0bbd
            java.lang.String r3 = "istu"
            java.lang.String r4 = "is_stop_tracking_used"
            r5 = 0
            boolean r4 = r6.getBoolean(r4, r5)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0c83 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0c83 }
        L_0x0bbd:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0c83 }
            r3.<init>()     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = "mcc"
            android.content.res.Resources r5 = r12.getResources()     // Catch:{ all -> 0x0c83 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0c83 }
            int r5 = r5.mcc     // Catch:{ all -> 0x0c83 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0c83 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = "mnc"
            android.content.res.Resources r5 = r12.getResources()     // Catch:{ all -> 0x0c83 }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0c83 }
            int r5 = r5.mnc     // Catch:{ all -> 0x0c83 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0c83 }
            r3.put(r4, r5)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = "cell"
            r2.put(r4, r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = "sig"
            android.app.Application r4 = r9.AFKeystoreWrapper     // Catch:{ all -> 0x0c83 }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ all -> 0x0c83 }
            android.app.Application r5 = r9.AFKeystoreWrapper     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = com.appsflyer.internal.aa.values((android.content.pm.PackageManager) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0c83 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = "last_boot_time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0c83 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0c83 }
            long r4 = r4 - r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0c83 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = "disk"
            android.os.StatFs r4 = new android.os.StatFs     // Catch:{ all -> 0x0c83 }
            java.io.File r5 = android.os.Environment.getDataDirectory()     // Catch:{ all -> 0x0c83 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0c83 }
            r4.<init>(r5)     // Catch:{ all -> 0x0c83 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0c83 }
            r6 = 18
            if (r5 < r6) goto L_0x0c38
            long r5 = r4.getBlockSizeLong()     // Catch:{ all -> 0x0c83 }
            long r7 = r4.getAvailableBlocksLong()     // Catch:{ all -> 0x0c83 }
            long r7 = r7 * r5
            long r9 = r4.getBlockCountLong()     // Catch:{ all -> 0x0c83 }
            long r9 = r9 * r5
            goto L_0x0c48
        L_0x0c38:
            int r5 = r4.getBlockSize()     // Catch:{ all -> 0x0c83 }
            int r6 = r4.getAvailableBlocks()     // Catch:{ all -> 0x0c83 }
            int r6 = r6 * r5
            long r7 = (long) r6     // Catch:{ all -> 0x0c83 }
            int r4 = r4.getBlockCount()     // Catch:{ all -> 0x0c83 }
            int r4 = r4 * r5
            long r9 = (long) r4     // Catch:{ all -> 0x0c83 }
        L_0x0c48:
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            r11 = 4626322717216342016(0x4034000000000000, double:20.0)
            double r4 = java.lang.Math.pow(r4, r11)     // Catch:{ all -> 0x0c83 }
            double r6 = (double) r7     // Catch:{ all -> 0x0c83 }
            double r6 = r6 / r4
            long r6 = (long) r6     // Catch:{ all -> 0x0c83 }
            double r8 = (double) r9     // Catch:{ all -> 0x0c83 }
            double r8 = r8 / r4
            long r4 = (long) r8     // Catch:{ all -> 0x0c83 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0c83 }
            r8.<init>()     // Catch:{ all -> 0x0c83 }
            r8.append(r6)     // Catch:{ all -> 0x0c83 }
            java.lang.String r6 = "/"
            r8.append(r6)     // Catch:{ all -> 0x0c83 }
            r8.append(r4)     // Catch:{ all -> 0x0c83 }
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x0c83 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0c83 }
            java.lang.String[] r3 = r1.getLevel     // Catch:{ all -> 0x0c83 }
            if (r3 == 0) goto L_0x0c8c
            java.lang.String r4 = "sharing_filter"
            r2.put(r4, r3)     // Catch:{ all -> 0x0c83 }
            goto L_0x0c8c
        L_0x0c77:
            java.lang.String r3 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            com.appsflyer.AFLogger.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0c83 }
            java.lang.String r3 = "AppsFlyer will not track this event."
            com.appsflyer.AFLogger.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0c83 }
            r2 = 0
            return r2
        L_0x0c83:
            r0 = move-exception
            r3 = r0
            java.lang.String r4 = r3.getLocalizedMessage()
            com.appsflyer.AFLogger.AFInAppEventParameterName((java.lang.String) r4, (java.lang.Throwable) r3)
        L_0x0c8c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ae.values(com.appsflyer.internal.g):java.util.Map");
    }

    public final void AFInAppEventParameterName(Context context, Map<String, Object> map, Uri uri) {
        if (!map.containsKey("af_deeplink")) {
            String valueOf2 = valueOf(uri.toString());
            j AFInAppEventType2 = j.AFInAppEventType();
            String str = AFInAppEventType2.AFVersionDeclaration;
            if (!(str == null || AFInAppEventType2.AFLogger$LogLevel == null || !valueOf2.contains(str))) {
                Uri.Builder buildUpon = Uri.parse(valueOf2).buildUpon();
                Uri.Builder buildUpon2 = Uri.EMPTY.buildUpon();
                for (Map.Entry next : AFInAppEventType2.AFLogger$LogLevel.entrySet()) {
                    buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                    buildUpon2.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                }
                valueOf2 = buildUpon.build().toString();
                map.put("appended_query_params", buildUpon2.build().getEncodedQuery());
            }
            map.put("af_deeplink", valueOf2);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        ao aoVar = new ao(uri, this, context);
        if (aoVar.valueOf) {
            map.put("isBrandedDomain", Boolean.TRUE);
        }
        aa.AFKeystoreWrapper(context, hashMap, uri);
        if (aoVar.AFKeystoreWrapper()) {
            aoVar.values = new ao.b() {
                public final void AFInAppEventParameterName(Map<String, String> map) {
                    for (String next : map.keySet()) {
                        hashMap.put(next, map.get(next));
                    }
                    ap.AFInAppEventParameterName((Map<String, String>) hashMap);
                }

                public final void AFInAppEventParameterName(String str) {
                    ap.valueOf(str, DeepLinkResult.Error.NETWORK);
                }
            };
            if (k.valueOf == null) {
                k.valueOf = new k();
            }
            k.valueOf.valueOf().execute(aoVar);
            return;
        }
        ap.AFInAppEventParameterName((Map<String, String>) hashMap);
    }

    public static void valueOf(Context context, Map<String, ? super String> map) {
        y yVar = y.a.valueOf;
        y.d AFKeystoreWrapper2 = y.AFKeystoreWrapper(context);
        map.put(OptionsBridge.NETWORK_KEY, AFKeystoreWrapper2.AFKeystoreWrapper);
        String str = AFKeystoreWrapper2.AFInAppEventType;
        if (str != null) {
            map.put("operator", str);
        }
        String str2 = AFKeystoreWrapper2.valueOf;
        if (str2 != null) {
            map.put("carrier", str2);
        }
    }

    public static /* synthetic */ void valueOf(ae aeVar, g gVar) throws IOException {
        String str;
        StringBuilder sb2 = new StringBuilder("url: ");
        sb2.append(gVar.onAppOpenAttributionNative);
        AFLogger.AFKeystoreWrapper(sb2.toString());
        if (gVar.getLevel != null) {
            str = Base64.encodeToString(gVar.AFInAppEventParameterName(), 2);
            AFLogger.AFKeystoreWrapper("cached data: ".concat(String.valueOf(str)));
        } else {
            str = new JSONObject(gVar.AFInAppEventType()).toString();
            String replaceAll = str.replaceAll("\\p{C}", "*Non-printing character*");
            if (!replaceAll.equals(str)) {
                AFLogger.init("Payload contains non-printing characters");
                str = replaceAll;
            }
            am.AFKeystoreWrapper("data: ".concat(str));
        }
        aj.valueOf().AFInAppEventType("server_request", gVar.onAppOpenAttributionNative, str);
        try {
            aeVar.AFKeystoreWrapper(gVar);
        } catch (IOException e11) {
            AFLogger.AFInAppEventType("Exception in sendRequestToServer. ", (Throwable) e11);
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.USE_HTTP_FALLBACK, false)) {
                aeVar.AFKeystoreWrapper(gVar.AFInAppEventParameterName(gVar.onAppOpenAttributionNative.replace("https:", "http:")));
                return;
            }
            StringBuilder sb3 = new StringBuilder("failed to send request to server. ");
            sb3.append(e11.getLocalizedMessage());
            AFLogger.AFKeystoreWrapper(sb3.toString());
            throw e11;
        }
    }

    public final void AFKeystoreWrapper(WeakReference<Context> weakReference) {
        if (weakReference.get() != null) {
            AFLogger.AFKeystoreWrapper("app went to background");
            SharedPreferences values2 = values(weakReference.get());
            AppsFlyerProperties.getInstance().saveProperties(values2);
            long j11 = this.stop - this.AppsFlyerConversionListener;
            HashMap hashMap = new HashMap();
            String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
            if (string == null) {
                AFLogger.init("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                return;
            }
            String string2 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
            }
            d.e.C0074d AFInAppEventParameterName2 = ab.AFInAppEventParameterName(weakReference.get().getContentResolver());
            if (AFInAppEventParameterName2 != null) {
                hashMap.put("amazon_aid", AFInAppEventParameterName2.values);
                hashMap.put("amazon_aid_limit", String.valueOf(AFInAppEventParameterName2.valueOf));
            }
            String string3 = AppsFlyerProperties.getInstance().getString("advertiserId");
            if (string3 != null) {
                hashMap.put("advertiserId", string3);
            }
            hashMap.put("app_id", weakReference.get().getPackageName());
            hashMap.put("devkey", string);
            hashMap.put("uid", an.AFKeystoreWrapper(weakReference));
            hashMap.put("time_in_app", String.valueOf(j11 / 1000));
            hashMap.put("statType", "user_closed_app");
            hashMap.put("platform", n0.f32119g);
            hashMap.put("launch_counter", Integer.toString(valueOf(values2, "appsFlyerCount", false)));
            hashMap.put(AppsFlyerProperties.CHANNEL, valueOf(weakReference.get()));
            if (string2 == null) {
                string2 = "";
            }
            hashMap.put("originalAppsflyerId", string2);
            if (this.setAndroidIdData) {
                try {
                    AFLogger.values("Running callStats task");
                    bp bpVar = new bp();
                    bpVar.onConversionDataFail = isStopped();
                    new Thread(new m((bf) bpVar.valueOf(hashMap).AFInAppEventParameterName(String.format(onInstallConversionFailureNative, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), onConversionDataSuccess.getHostName()})))).start();
                } catch (Throwable th2) {
                    AFLogger.AFInAppEventType("Could not send callStats request", th2);
                }
            } else {
                AFLogger.values("Stats call is disabled, ignore ...");
            }
        }
    }

    public static boolean AFInAppEventParameterName(Context context) {
        return !values(context).contains("appsFlyerCount");
    }

    private static File AFInAppEventParameterName(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.trim().length() > 0) {
                return new File(str.trim());
            }
            return null;
        } catch (Throwable th2) {
            AFLogger.AFInAppEventType(th2.getMessage(), th2);
            return null;
        }
    }

    private String AFInAppEventParameterName(SimpleDateFormat simpleDateFormat, Context context) {
        String str;
        String string = values(context).getString("appsFlyerFirstInstall", (String) null);
        if (string == null) {
            if (AFInAppEventParameterName(context)) {
                AFLogger.values("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
            } else {
                str = "";
            }
            string = str;
            SharedPreferences.Editor edit = values(context).edit();
            edit.putString("appsFlyerFirstInstall", string);
            edit.apply();
        }
        AFLogger.AFKeystoreWrapper("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    public final Map<String, Object> AFInAppEventParameterName() {
        HashMap hashMap = new HashMap();
        if (AFLogger$LogLevel()) {
            hashMap.put("lvl", this.setCustomerIdAndLogSession);
        } else if (this.getOutOfStore) {
            HashMap hashMap2 = new HashMap();
            this.setCustomerIdAndLogSession = hashMap2;
            hashMap2.put("error", "operation timed out.");
            hashMap.put("lvl", this.setCustomerIdAndLogSession);
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public boolean AFInAppEventParameterName(g gVar, SharedPreferences sharedPreferences) {
        int valueOf2 = valueOf(sharedPreferences, "appsFlyerCount", false);
        return (!sharedPreferences.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false) && valueOf2 == 1) || (valueOf2 == 1 && !(gVar instanceof bh));
    }

    private void AFKeystoreWrapper(Context context, String str, Map<String, Object> map) {
        bj bjVar = new bj();
        if (context != null) {
            bjVar.valueOf = (Application) context.getApplicationContext();
        }
        bjVar.AFLogger$LogLevel = str;
        bjVar.values = map;
        values((g) bjVar, context instanceof Activity ? (Activity) context : null);
    }

    private boolean AFKeystoreWrapper() {
        if (this.onDeepLinking > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.onDeepLinking;
            Locale locale = Locale.US;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", locale);
            long j11 = this.onDeepLinking;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
            String format = simpleDateFormat.format(new Date(j11));
            long j12 = this.AppsFlyerInAppPurchaseValidatorListener;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
            String format2 = simpleDateFormat.format(new Date(j12));
            if (currentTimeMillis < this.AppsFlyerLib && !isStopped()) {
                AFLogger.AFKeystoreWrapper(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{format, format2, Long.valueOf(currentTimeMillis), Long.valueOf(this.AppsFlyerLib)}));
                return true;
            } else if (!isStopped()) {
                AFLogger.AFKeystoreWrapper(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{format, format2, Long.valueOf(currentTimeMillis)}));
            }
        } else if (!isStopped()) {
            AFLogger.AFKeystoreWrapper("Sending first launch for this session!");
        }
        return false;
    }

    public static Map<String, Object> AFKeystoreWrapper(Map<String, Object> map) {
        if (map.containsKey(Constants.REFERRER_API_META)) {
            return (Map) map.get(Constants.REFERRER_API_META);
        }
        HashMap hashMap = new HashMap();
        map.put(Constants.REFERRER_API_META, hashMap);
        return hashMap;
    }

    private static String AFKeystoreWrapper(String str, PackageManager packageManager, String str2) {
        Object obj;
        try {
            Bundle bundle = packageManager.getApplicationInfo(str2, 128).metaData;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder("Could not find ");
            sb2.append(str);
            sb2.append(" value in the manifest");
            AFLogger.AFInAppEventType(sb2.toString(), th2);
            return null;
        }
    }

    public final String AFKeystoreWrapper(Context context, String str) {
        SharedPreferences values2 = values(context);
        if (values2.contains("CACHED_CHANNEL")) {
            return values2.getString("CACHED_CHANNEL", (String) null);
        }
        SharedPreferences.Editor edit = values(context).edit();
        edit.putString("CACHED_CHANNEL", str);
        edit.apply();
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064 A[SYNTHETIC, Splitter:B:29:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069 A[Catch:{ all -> 0x003b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFKeystoreWrapper(java.net.HttpURLConnection r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStream r2 = r7.getErrorStream()     // Catch:{ all -> 0x0047 }
            if (r2 != 0) goto L_0x0010
            java.io.InputStream r2 = r7.getInputStream()     // Catch:{ all -> 0x0047 }
        L_0x0010:
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0047 }
            r3.<init>(r2)     // Catch:{ all -> 0x0047 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0045 }
            r2.<init>(r3)     // Catch:{ all -> 0x0045 }
            r1 = 0
        L_0x001b:
            java.lang.String r4 = r2.readLine()     // Catch:{ all -> 0x0040 }
            if (r4 == 0) goto L_0x0034
            if (r1 == 0) goto L_0x002a
            r1 = 10
            java.lang.Character r1 = java.lang.Character.valueOf(r1)     // Catch:{ all -> 0x0040 }
            goto L_0x002c
        L_0x002a:
            java.lang.String r1 = ""
        L_0x002c:
            r0.append(r1)     // Catch:{ all -> 0x0040 }
            r0.append(r4)     // Catch:{ all -> 0x0040 }
            r1 = 1
            goto L_0x001b
        L_0x0034:
            r2.close()     // Catch:{ all -> 0x003b }
            r3.close()     // Catch:{ all -> 0x003b }
            goto L_0x006c
        L_0x003b:
            r7 = move-exception
            com.appsflyer.AFLogger.values((java.lang.Throwable) r7)
            goto L_0x006c
        L_0x0040:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0049
        L_0x0045:
            r2 = move-exception
            goto L_0x0049
        L_0x0047:
            r2 = move-exception
            r3 = r1
        L_0x0049:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r5 = "Could not read connection response from: "
            r4.<init>(r5)     // Catch:{ all -> 0x008f }
            java.net.URL r7 = r7.getURL()     // Catch:{ all -> 0x008f }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008f }
            r4.append(r7)     // Catch:{ all -> 0x008f }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x008f }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r7, (java.lang.Throwable) r2)     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x0067
            r1.close()     // Catch:{ all -> 0x003b }
        L_0x0067:
            if (r3 == 0) goto L_0x006c
            r3.close()     // Catch:{ all -> 0x003b }
        L_0x006c:
            java.lang.String r7 = r0.toString()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0076 }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x0076 }
            return r7
        L_0x0076:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x0085 }
            java.lang.String r7 = r0.toString()     // Catch:{ JSONException -> 0x0085 }
            return r7
        L_0x0085:
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r7 = r7.toString()
            return r7
        L_0x008f:
            r7 = move-exception
            if (r1 == 0) goto L_0x0098
            r1.close()     // Catch:{ all -> 0x0096 }
            goto L_0x0098
        L_0x0096:
            r0 = move-exception
            goto L_0x009e
        L_0x0098:
            if (r3 == 0) goto L_0x00a1
            r3.close()     // Catch:{ all -> 0x0096 }
            goto L_0x00a1
        L_0x009e:
            com.appsflyer.AFLogger.values((java.lang.Throwable) r0)
        L_0x00a1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ae.AFKeystoreWrapper(java.net.HttpURLConnection):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:25|26|27|28|(2:30|31)|32|33|(1:35)|36|(6:(1:40)|(1:42)|(1:44)(2:45|(2:47|(1:49)(2:50|(3:52|(1:54)|55))))|56|(1:60)|61)(1:(1:63))|64|65|66) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x009b */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f A[Catch:{ all -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f0 A[ADDED_TO_REGION, Catch:{ all -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0182 A[Catch:{ all -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b9 A[SYNTHETIC, Splitter:B:71:0x01b9] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFKeystoreWrapper(com.appsflyer.internal.g r17) throws java.io.IOException {
        /*
            r16 = this;
            r8 = r16
            r0 = r17
            java.net.URL r1 = new java.net.URL
            java.lang.String r2 = r0.onAppOpenAttributionNative
            r1.<init>(r2)
            byte[] r2 = r17.AFInAppEventParameterName()
            java.lang.String r3 = r0.AFVersionDeclaration
            java.lang.String r4 = r0.getLevel
            boolean r5 = r17.AFKeystoreWrapper()
            android.app.Application r6 = r0.valueOf
            com.appsflyer.attribution.AppsFlyerRequestListener r7 = r0.AFKeystoreWrapper
            r10 = 1
            if (r5 == 0) goto L_0x0024
            int r11 = r0.onInstallConversionFailureNative
            if (r11 != r10) goto L_0x0024
            r11 = r10
            goto L_0x0025
        L_0x0024:
            r11 = 0
        L_0x0025:
            if (r11 == 0) goto L_0x003a
            org.json.JSONObject r12 = r8.setUserEmails     // Catch:{ JSONException -> 0x0035 }
            java.lang.String r13 = "from_fg"
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0035 }
            long r9 = r8.AppsFlyerConversionListener     // Catch:{ JSONException -> 0x0035 }
            long r14 = r14 - r9
            r12.put(r13, r14)     // Catch:{ JSONException -> 0x0035 }
        L_0x0035:
            long r9 = java.lang.System.currentTimeMillis()
            goto L_0x003c
        L_0x003a:
            r9 = 0
        L_0x003c:
            java.net.URLConnection r13 = r1.openConnection()     // Catch:{ all -> 0x01c0 }
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ all -> 0x01c0 }
            java.lang.String r14 = "POST"
            r13.setRequestMethod(r14)     // Catch:{ all -> 0x01bd }
            int r14 = r2.length     // Catch:{ all -> 0x01bd }
            java.lang.String r15 = "Content-Length"
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x01bd }
            r13.setRequestProperty(r15, r14)     // Catch:{ all -> 0x01bd }
            java.lang.String r14 = "Content-Type"
            boolean r15 = r17.values()     // Catch:{ all -> 0x01bd }
            if (r15 == 0) goto L_0x005c
            java.lang.String r15 = "application/octet-stream"
            goto L_0x005e
        L_0x005c:
            java.lang.String r15 = "application/json"
        L_0x005e:
            r13.setRequestProperty(r14, r15)     // Catch:{ all -> 0x01bd }
            r14 = 10000(0x2710, float:1.4013E-41)
            r13.setConnectTimeout(r14)     // Catch:{ all -> 0x01bd }
            r14 = 1
            r13.setDoOutput(r14)     // Catch:{ all -> 0x01bd }
            com.appsflyer.AppsFlyerProperties r15 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x01bd }
            java.lang.String r12 = "http_cache"
            boolean r12 = r15.getBoolean(r12, r14)     // Catch:{ all -> 0x01bd }
            if (r12 != 0) goto L_0x007a
            r12 = 0
            r13.setUseCaches(r12)     // Catch:{ all -> 0x01bd }
        L_0x007a:
            java.io.DataOutputStream r12 = new java.io.DataOutputStream     // Catch:{ all -> 0x01b5 }
            java.io.OutputStream r14 = r13.getOutputStream()     // Catch:{ all -> 0x01b5 }
            r12.<init>(r14)     // Catch:{ all -> 0x01b5 }
            r12.write(r2)     // Catch:{ all -> 0x01b3 }
            r12.close()     // Catch:{ all -> 0x01bd }
            int r2 = r13.getResponseCode()     // Catch:{ all -> 0x01bd }
            if (r11 == 0) goto L_0x009b
            org.json.JSONObject r11 = r8.setUserEmails     // Catch:{ JSONException -> 0x009b }
            java.lang.String r12 = "net"
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x009b }
            long r14 = r14 - r9
            r11.put(r12, r14)     // Catch:{ JSONException -> 0x009b }
        L_0x009b:
            com.appsflyer.internal.au r9 = r8.init     // Catch:{ all -> 0x01bd }
            if (r9 != 0) goto L_0x00a6
            com.appsflyer.internal.au r9 = new com.appsflyer.internal.au     // Catch:{ all -> 0x01bd }
            r9.<init>(r6)     // Catch:{ all -> 0x01bd }
            r8.init = r9     // Catch:{ all -> 0x01bd }
        L_0x00a6:
            com.appsflyer.internal.au r9 = r8.init     // Catch:{ all -> 0x01bd }
            java.lang.String r10 = "first_launch"
            org.json.JSONObject r11 = r8.setUserEmails     // Catch:{ all -> 0x01bd }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x01bd }
            android.content.SharedPreferences r9 = r9.valueOf     // Catch:{ all -> 0x01bd }
            android.content.SharedPreferences$Editor r9 = r9.edit()     // Catch:{ all -> 0x01bd }
            android.content.SharedPreferences$Editor r9 = r9.putString(r10, r11)     // Catch:{ all -> 0x01bd }
            r9.apply()     // Catch:{ all -> 0x01bd }
            java.lang.String r9 = AFKeystoreWrapper((java.net.HttpURLConnection) r13)     // Catch:{ all -> 0x01bd }
            com.appsflyer.internal.aj r10 = com.appsflyer.internal.aj.valueOf()     // Catch:{ all -> 0x01bd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01bd }
            java.lang.String r11 = "server_response"
            r12 = 2
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ all -> 0x01bd }
            java.lang.String r14 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x01bd }
            r15 = 0
            r12[r15] = r14     // Catch:{ all -> 0x01bd }
            r14 = 1
            r12[r14] = r9     // Catch:{ all -> 0x01bd }
            r10.AFInAppEventType(r11, r1, r12)     // Catch:{ all -> 0x01bd }
            java.lang.String r1 = "response code: "
            java.lang.String r10 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x01bd }
            java.lang.String r1 = r1.concat(r10)     // Catch:{ all -> 0x01bd }
            com.appsflyer.AFLogger.AFKeystoreWrapper(r1)     // Catch:{ all -> 0x01bd }
            android.content.SharedPreferences r10 = values((android.content.Context) r6)     // Catch:{ all -> 0x01bd }
            r1 = 200(0xc8, float:2.8E-43)
            if (r2 != r1) goto L_0x0182
            if (r6 == 0) goto L_0x00fa
            if (r5 == 0) goto L_0x00fa
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01bd }
            r8.AppsFlyerInAppPurchaseValidatorListener = r11     // Catch:{ all -> 0x01bd }
        L_0x00fa:
            if (r7 == 0) goto L_0x00ff
            r7.onSuccess()     // Catch:{ all -> 0x01bd }
        L_0x00ff:
            if (r4 == 0) goto L_0x0108
            com.appsflyer.internal.ai.AFKeystoreWrapper()     // Catch:{ all -> 0x01bd }
            com.appsflyer.internal.ai.valueOf(r4, r6)     // Catch:{ all -> 0x01bd }
            goto L_0x0151
        L_0x0108:
            java.lang.String r1 = "sentSuccessfully"
            java.lang.String r4 = "true"
            android.content.SharedPreferences r5 = values((android.content.Context) r6)     // Catch:{ all -> 0x01bd }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x01bd }
            r5.putString(r1, r4)     // Catch:{ all -> 0x01bd }
            r5.apply()     // Catch:{ all -> 0x01bd }
            boolean r1 = r8.onValidateInApp     // Catch:{ all -> 0x01bd }
            if (r1 != 0) goto L_0x0151
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01bd }
            long r11 = r8.AFVersionDeclaration     // Catch:{ all -> 0x01bd }
            long r4 = r4 - r11
            r11 = 15000(0x3a98, double:7.411E-320)
            int r1 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x012c
            goto L_0x0151
        L_0x012c:
            java.util.concurrent.ScheduledExecutorService r1 = r8.onValidateInAppFailure     // Catch:{ all -> 0x01bd }
            if (r1 != 0) goto L_0x0151
            com.appsflyer.internal.k r1 = com.appsflyer.internal.k.valueOf     // Catch:{ all -> 0x01bd }
            if (r1 != 0) goto L_0x013b
            com.appsflyer.internal.k r1 = new com.appsflyer.internal.k     // Catch:{ all -> 0x01bd }
            r1.<init>()     // Catch:{ all -> 0x01bd }
            com.appsflyer.internal.k.valueOf = r1     // Catch:{ all -> 0x01bd }
        L_0x013b:
            com.appsflyer.internal.k r1 = com.appsflyer.internal.k.valueOf     // Catch:{ all -> 0x01bd }
            java.util.concurrent.ScheduledThreadPoolExecutor r1 = r1.AFInAppEventParameterName()     // Catch:{ all -> 0x01bd }
            r8.onValidateInAppFailure = r1     // Catch:{ all -> 0x01bd }
            com.appsflyer.internal.ae$e r1 = new com.appsflyer.internal.ae$e     // Catch:{ all -> 0x01bd }
            r1.<init>(r6)     // Catch:{ all -> 0x01bd }
            java.util.concurrent.ScheduledExecutorService r4 = r8.onValidateInAppFailure     // Catch:{ all -> 0x01bd }
            r11 = 1
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x01bd }
            AFInAppEventType(r4, r1, r11, r5)     // Catch:{ all -> 0x01bd }
        L_0x0151:
            com.appsflyer.internal.bb r1 = new com.appsflyer.internal.bb     // Catch:{ all -> 0x01bd }
            r1.<init>(r6)     // Catch:{ all -> 0x01bd }
            com.appsflyer.internal.l r4 = r1.valueOf()     // Catch:{ all -> 0x01bd }
            if (r4 == 0) goto L_0x0174
            boolean r5 = r4.AFInAppEventParameterName()     // Catch:{ all -> 0x01bd }
            if (r5 == 0) goto L_0x0174
            java.lang.String r4 = r4.values     // Catch:{ all -> 0x01bd }
            java.lang.String r5 = "Resending Uninstall token to AF servers: "
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x01bd }
            java.lang.String r5 = r5.concat(r7)     // Catch:{ all -> 0x01bd }
            com.appsflyer.AFLogger.values((java.lang.String) r5)     // Catch:{ all -> 0x01bd }
            r1.AFInAppEventType((java.lang.String) r4)     // Catch:{ all -> 0x01bd }
        L_0x0174:
            org.json.JSONObject r1 = com.appsflyer.internal.ar.AFKeystoreWrapper(r9)     // Catch:{ all -> 0x01bd }
            java.lang.String r4 = "send_background"
            r5 = 0
            boolean r1 = r1.optBoolean(r4, r5)     // Catch:{ all -> 0x01bd }
            r8.setAndroidIdData = r1     // Catch:{ all -> 0x01bd }
            goto L_0x019f
        L_0x0182:
            if (r7 == 0) goto L_0x019f
            int r1 = com.appsflyer.attribution.RequestError.RESPONSE_CODE_FAILURE     // Catch:{ all -> 0x01bd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bd }
            r4.<init>()     // Catch:{ all -> 0x01bd }
            java.lang.String r5 = com.appsflyer.internal.ax.AFInAppEventType     // Catch:{ all -> 0x01bd }
            r4.append(r5)     // Catch:{ all -> 0x01bd }
            java.lang.String r5 = " "
            r4.append(r5)     // Catch:{ all -> 0x01bd }
            r4.append(r2)     // Catch:{ all -> 0x01bd }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01bd }
            r7.onError(r1, r4)     // Catch:{ all -> 0x01bd }
        L_0x019f:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x01bd }
            r9 = 0
            r1 = r16
            r2 = r17
            r4 = r6
            r5 = r10
            r6 = r7
            r7 = r9
            com.appsflyer.internal.ba.values(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x01bd }
            r13.disconnect()
            return
        L_0x01b3:
            r0 = move-exception
            goto L_0x01b7
        L_0x01b5:
            r0 = move-exception
            r12 = 0
        L_0x01b7:
            if (r12 == 0) goto L_0x01bc
            r12.close()     // Catch:{ all -> 0x01bd }
        L_0x01bc:
            throw r0     // Catch:{ all -> 0x01bd }
        L_0x01bd:
            r0 = move-exception
            r12 = r13
            goto L_0x01c2
        L_0x01c0:
            r0 = move-exception
            r12 = 0
        L_0x01c2:
            if (r12 == 0) goto L_0x01c7
            r12.disconnect()
        L_0x01c7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ae.AFKeystoreWrapper(com.appsflyer.internal.g):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ca, code lost:
        if (r9.AFLogger$LogLevel() == false) goto L_0x01ce;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void AFKeystoreWrapper(com.appsflyer.internal.ae r9, com.appsflyer.internal.g r10) {
        /*
            android.app.Application r0 = r10.valueOf
            java.lang.String r1 = r10.AFLogger$LogLevel
            if (r0 != 0) goto L_0x000c
            java.lang.String r9 = "sendWithEvent - got null context. skipping event/launch."
            com.appsflyer.AFLogger.values((java.lang.String) r9)
            return
        L_0x000c:
            android.content.SharedPreferences r2 = values((android.content.Context) r0)
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()
            r3.saveProperties(r2)
            boolean r3 = r9.isStopped()
            if (r3 != 0) goto L_0x0036
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "sendWithEvent from activity: "
            r3.<init>(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.appsflyer.AFLogger.AFKeystoreWrapper(r3)
        L_0x0036:
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x003c
            r1 = r3
            goto L_0x003d
        L_0x003c:
            r1 = r4
        L_0x003d:
            boolean r5 = r10 instanceof com.appsflyer.internal.bd
            boolean r6 = r10 instanceof com.appsflyer.internal.bh
            r10.onAttributionFailureNative = r1
            java.util.Map r7 = r9.values((com.appsflyer.internal.g) r10)
            java.lang.String r8 = "appsflyerKey"
            java.lang.Object r8 = r7.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x0211
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0059
            goto L_0x0211
        L_0x0059:
            boolean r8 = r9.isStopped()
            if (r8 != 0) goto L_0x0064
            java.lang.String r8 = "AppsFlyerLib.sendWithEvent"
            com.appsflyer.AFLogger.AFKeystoreWrapper(r8)
        L_0x0064:
            java.lang.String r8 = "appsFlyerCount"
            int r2 = valueOf((android.content.SharedPreferences) r2, (java.lang.String) r8, (boolean) r4)
            r8 = 2
            if (r6 != 0) goto L_0x00c5
            if (r5 == 0) goto L_0x0070
            goto L_0x00c5
        L_0x0070:
            if (r1 == 0) goto L_0x00aa
            if (r2 >= r8) goto L_0x008f
            java.lang.String r5 = onAttributionFailureNative
            java.lang.Object[] r6 = new java.lang.Object[r8]
            com.appsflyer.AppsFlyerLib r8 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r8 = r8.getHostPrefix()
            r6[r4] = r8
            com.appsflyer.internal.ae r8 = onConversionDataSuccess
            java.lang.String r8 = r8.getHostName()
            r6[r3] = r8
            java.lang.String r5 = java.lang.String.format(r5, r6)
            goto L_0x00df
        L_0x008f:
            java.lang.String r5 = onAppOpenAttribution
            java.lang.Object[] r6 = new java.lang.Object[r8]
            com.appsflyer.AppsFlyerLib r8 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r8 = r8.getHostPrefix()
            r6[r4] = r8
            com.appsflyer.internal.ae r8 = onConversionDataSuccess
            java.lang.String r8 = r8.getHostName()
            r6[r3] = r8
            java.lang.String r5 = java.lang.String.format(r5, r6)
            goto L_0x00df
        L_0x00aa:
            java.lang.String r5 = onConversionDataFail
            java.lang.Object[] r6 = new java.lang.Object[r8]
            com.appsflyer.AppsFlyerLib r8 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r8 = r8.getHostPrefix()
            r6[r4] = r8
            com.appsflyer.internal.ae r8 = onConversionDataSuccess
            java.lang.String r8 = r8.getHostName()
            r6[r3] = r8
            java.lang.String r5 = java.lang.String.format(r5, r6)
            goto L_0x00df
        L_0x00c5:
            java.lang.String r5 = onAttributionFailure
            java.lang.Object[] r6 = new java.lang.Object[r8]
            com.appsflyer.AppsFlyerLib r8 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r8 = r8.getHostPrefix()
            r6[r4] = r8
            com.appsflyer.internal.ae r8 = onConversionDataSuccess
            java.lang.String r8 = r8.getHostName()
            r6[r3] = r8
            java.lang.String r5 = java.lang.String.format(r5, r6)
        L_0x00df:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = r0.getPackageName()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = "&buildnumber=6.3.2"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r0 = r9.valueOf((android.content.Context) r0)
            if (r0 == 0) goto L_0x011d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = "&channel="
            r6.append(r5)
            r6.append(r0)
            java.lang.String r5 = r6.toString()
        L_0x011d:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r6 = "collectAndroidIdForceByUser"
            boolean r0 = r0.getBoolean(r6, r4)
            if (r0 != 0) goto L_0x0138
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r6 = "collectIMEIForceByUser"
            boolean r0 = r0.getBoolean(r6, r4)
            if (r0 == 0) goto L_0x0136
            goto L_0x0138
        L_0x0136:
            r0 = r4
            goto L_0x0139
        L_0x0138:
            r0 = r3
        L_0x0139:
            if (r0 != 0) goto L_0x0174
            java.lang.String r0 = "advertiserId"
            java.lang.Object r0 = r7.get(r0)
            if (r0 == 0) goto L_0x0174
            java.lang.String r0 = r9.AFLogger$LogLevel     // Catch:{ Exception -> 0x016e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x016e }
            if (r0 == 0) goto L_0x0158
            java.lang.String r0 = "android_id"
            java.lang.Object r0 = r7.remove(r0)     // Catch:{ Exception -> 0x016e }
            if (r0 == 0) goto L_0x0158
            java.lang.String r0 = "validateGaidAndIMEI :: removing: android_id"
            com.appsflyer.AFLogger.AFKeystoreWrapper(r0)     // Catch:{ Exception -> 0x016e }
        L_0x0158:
            java.lang.String r0 = r9.AppsFlyer2dXConversionCallback     // Catch:{ Exception -> 0x016e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x016e }
            if (r0 == 0) goto L_0x0174
            java.lang.String r0 = "imei"
            java.lang.Object r0 = r7.remove(r0)     // Catch:{ Exception -> 0x016e }
            if (r0 == 0) goto L_0x0174
            java.lang.String r0 = "validateGaidAndIMEI :: removing: imei"
            com.appsflyer.AFLogger.AFKeystoreWrapper(r0)     // Catch:{ Exception -> 0x016e }
            goto L_0x0174
        L_0x016e:
            r0 = move-exception
            java.lang.String r6 = "failed to remove IMEI or AndroidID key from params; "
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r6, (java.lang.Throwable) r0)
        L_0x0174:
            com.appsflyer.internal.ae$d r0 = new com.appsflyer.internal.ae$d
            com.appsflyer.internal.g r10 = r10.AFInAppEventParameterName(r5)
            com.appsflyer.internal.g r10 = r10.valueOf(r7)
            r10.onInstallConversionFailureNative = r2
            r0.<init>(r9, r10, r4)
            if (r1 == 0) goto L_0x01cd
            com.appsflyer.internal.bt[] r10 = r9.onAppOpenAttributionNative
            if (r10 == 0) goto L_0x01b2
            int r1 = r10.length
            r2 = r4
        L_0x018b:
            if (r4 >= r1) goto L_0x01b1
            r5 = r10[r4]
            com.appsflyer.internal.bt$e r6 = r5.AFInAppEventParameterName
            com.appsflyer.internal.bt$e r7 = com.appsflyer.internal.bt.e.STARTED
            if (r6 != r7) goto L_0x01ae
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "Failed to get "
            r2.<init>(r6)
            java.lang.String r5 = r5.valueOf
            r2.append(r5)
            java.lang.String r5 = " referrer, wait ..."
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.values((java.lang.String) r2)
            r2 = r3
        L_0x01ae:
            int r4 = r4 + 1
            goto L_0x018b
        L_0x01b1:
            r4 = r2
        L_0x01b2:
            boolean r10 = r9.setPhoneNumber
            if (r10 == 0) goto L_0x01c2
            boolean r10 = r9.AFInAppEventType()
            if (r10 != 0) goto L_0x01c2
            java.lang.String r10 = "fetching Facebook deferred AppLink data, wait ..."
            com.appsflyer.AFLogger.values((java.lang.String) r10)
            r4 = r3
        L_0x01c2:
            boolean r10 = r9.getOutOfStore
            if (r10 == 0) goto L_0x01cd
            boolean r9 = r9.AFLogger$LogLevel()
            if (r9 != 0) goto L_0x01cd
            goto L_0x01ce
        L_0x01cd:
            r3 = r4
        L_0x01ce:
            boolean r9 = com.appsflyer.internal.j.valueOf
            if (r9 == 0) goto L_0x01f3
            java.lang.String r9 = "ESP deeplink: execute launch on SerialExecutor"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r9)
            com.appsflyer.internal.k r9 = com.appsflyer.internal.k.valueOf
            if (r9 != 0) goto L_0x01e2
            com.appsflyer.internal.k r9 = new com.appsflyer.internal.k
            r9.<init>()
            com.appsflyer.internal.k.valueOf = r9
        L_0x01e2:
            com.appsflyer.internal.k r9 = com.appsflyer.internal.k.valueOf
            java.util.concurrent.ScheduledExecutorService r10 = r9.AFInAppEventParameterName
            if (r10 != 0) goto L_0x01f0
            java.util.concurrent.ThreadFactory r10 = r9.AFInAppEventType
            java.util.concurrent.ScheduledExecutorService r10 = java.util.concurrent.Executors.newSingleThreadScheduledExecutor(r10)
            r9.AFInAppEventParameterName = r10
        L_0x01f0:
            java.util.concurrent.ScheduledExecutorService r9 = r9.AFInAppEventParameterName
            goto L_0x0204
        L_0x01f3:
            com.appsflyer.internal.k r9 = com.appsflyer.internal.k.valueOf
            if (r9 != 0) goto L_0x01fe
            com.appsflyer.internal.k r9 = new com.appsflyer.internal.k
            r9.<init>()
            com.appsflyer.internal.k.valueOf = r9
        L_0x01fe:
            com.appsflyer.internal.k r9 = com.appsflyer.internal.k.valueOf
            java.util.concurrent.ScheduledThreadPoolExecutor r9 = r9.AFInAppEventParameterName()
        L_0x0204:
            if (r3 == 0) goto L_0x0209
            r1 = 500(0x1f4, double:2.47E-321)
            goto L_0x020b
        L_0x0209:
            r1 = 0
        L_0x020b:
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS
            AFInAppEventType(r9, r0, r1, r10)
            return
        L_0x0211:
            java.lang.String r9 = "Not sending data yet, waiting for dev key"
            com.appsflyer.AFLogger.values((java.lang.String) r9)
            com.appsflyer.attribution.AppsFlyerRequestListener r9 = r10.AFKeystoreWrapper
            if (r9 == 0) goto L_0x0221
            int r10 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r0 = com.appsflyer.internal.ax.AFKeystoreWrapper
            r9.onError(r10, r0)
        L_0x0221:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ae.AFKeystoreWrapper(com.appsflyer.internal.ae, com.appsflyer.internal.g):void");
    }

    public static SharedPreferences values(Context context) {
        ae aeVar = onConversionDataSuccess;
        if (aeVar.sendPushNotificationData == null) {
            aeVar.sendPushNotificationData = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
        }
        return onConversionDataSuccess.sendPushNotificationData;
    }
}
