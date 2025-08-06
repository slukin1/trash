package com.sensorsdata.analytics.android.sdk.visual;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo;
import com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol;
import com.sensorsdata.analytics.android.sdk.visual.snap.EditState;
import com.sensorsdata.analytics.android.sdk.visual.snap.ResourceReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

public abstract class AbstractViewCrawler implements VTrack {
    private static final int MESSAGE_SEND_STATE_FOR_EDITING = 1;
    private static final String TAG = "SA.AbstractViewCrawler";
    public static final String TYPE_HEAT_MAP = "heat_map";
    public static final String TYPE_VISUAL = "visual";
    private final Activity mActivity;
    /* access modifiers changed from: private */
    public String mAppVersion;
    /* access modifiers changed from: private */
    public final EditState mEditState;
    /* access modifiers changed from: private */
    public String mFeatureCode;
    private final LifecycleCallbacks mLifecycleCallbacks;
    /* access modifiers changed from: private */
    public final Handler mMainThreadHandler;
    /* access modifiers changed from: private */
    public final ViewCrawlerHandler mMessageThreadHandler;
    /* access modifiers changed from: private */
    public String mPostUrl;
    private boolean mServiceRunning = false;
    /* access modifiers changed from: private */
    public String mType;

    @TargetApi(14)
    public class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            AbstractViewCrawler.this.mEditState.remove(activity);
        }

        public void onActivityResumed(Activity activity) {
            AbstractViewCrawler.this.mEditState.add(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        private LifecycleCallbacks() {
        }
    }

    public class ViewCrawlerHandler extends Handler {
        private String mAppId;
        private StringBuilder mLastImageHash;
        private final EditProtocol mProtocol;
        private final String mSDKVersion;
        private ViewSnapshot mSnapshot;
        private boolean mUseGzip;

        private void onSnapFinished(SnapInfo snapInfo) {
            if (snapInfo != null && !WebNodesManager.getInstance().hasWebView()) {
                WebNodesManager.getInstance().clear();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.io.InputStream} */
        /* JADX WARNING: type inference failed for: r6v12 */
        /* JADX WARNING: Can't wrap try/catch for region: R(2:29|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
            r12.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x01a0, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x01a1, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x01aa, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x01ab, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x01b4, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x01b5, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
            r12.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x01be, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x01bf, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r4 = r6.getErrorStream();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0116, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0117, code lost:
            r6 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x013f, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0140, code lost:
            r6 = r4;
            r4 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0160, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0161, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x016a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x016b, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x0174, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0175, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x009a */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x017f  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x0193  */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x019c A[SYNTHETIC, Splitter:B:106:0x019c] */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x01a6 A[SYNTHETIC, Splitter:B:111:0x01a6] */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x01b0 A[SYNTHETIC, Splitter:B:116:0x01b0] */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x01ba A[SYNTHETIC, Splitter:B:121:0x01ba] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x013f A[ExcHandler: all (th java.lang.Throwable), PHI: r4 
          PHI: (r4v4 java.io.BufferedOutputStream) = (r4v0 java.io.BufferedOutputStream), (r4v0 java.io.BufferedOutputStream), (r4v10 java.io.BufferedOutputStream) binds: [B:25:0x0083, B:29:0x009a, B:38:0x00e5] A[DONT_GENERATE, DONT_INLINE], Splitter:B:25:0x0083] */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x015c A[SYNTHETIC, Splitter:B:84:0x015c] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0166 A[SYNTHETIC, Splitter:B:89:0x0166] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0170 A[SYNTHETIC, Splitter:B:94:0x0170] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x017a A[SYNTHETIC, Splitter:B:99:0x017a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void postSnapshot(java.io.ByteArrayOutputStream r12) {
            /*
                r11 = this;
                java.lang.String r0 = "SA.AbstractViewCrawler"
                java.lang.String r1 = "UTF-8"
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r2 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                java.lang.String r2 = r2.mFeatureCode
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x01c3
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r2 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                java.lang.String r2 = r2.mPostUrl
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 == 0) goto L_0x001e
                goto L_0x01c3
            L_0x001e:
                r2 = 1000(0x3e8, double:4.94E-321)
                r4 = 0
                r5 = 1
                java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r7 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                java.lang.String r7 = r7.mPostUrl     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                r6.<init>(r7)     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                java.net.URLConnection r6 = r6.openConnection()     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r7 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                if (r7 == 0) goto L_0x006b
                boolean r8 = r7.isDisableSDK()     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                if (r8 == 0) goto L_0x005d
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r0 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r0 = r0.mMessageThreadHandler     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r1 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r1 = r1.mMessageThreadHandler     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                android.os.Message r1 = r1.obtainMessage(r5)     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                r0.sendMessageDelayed(r1, r2)     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                if (r12 == 0) goto L_0x005c
                r12.close()     // Catch:{ Exception -> 0x0058 }
                goto L_0x005c
            L_0x0058:
                r12 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12)
            L_0x005c:
                return
            L_0x005d:
                javax.net.ssl.SSLSocketFactory r7 = r7.mSSLSocketFactory     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                if (r7 == 0) goto L_0x006b
                boolean r8 = r6 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                if (r8 == 0) goto L_0x006b
                r8 = r6
                javax.net.ssl.HttpsURLConnection r8 = (javax.net.ssl.HttpsURLConnection) r8     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                r8.setSSLSocketFactory(r7)     // Catch:{ Exception -> 0x0153, all -> 0x014f }
            L_0x006b:
                r6.setDoOutput(r5)     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                java.lang.String r7 = "POST"
                r6.setRequestMethod(r7)     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                java.lang.String r7 = "Content-type"
                java.lang.String r8 = "text/plain"
                r6.setRequestProperty(r7, r8)     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                java.io.OutputStream r7 = r6.getOutputStream()     // Catch:{ Exception -> 0x0153, all -> 0x014f }
                java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x014c, all -> 0x0149 }
                r8.<init>(r7)     // Catch:{ Exception -> 0x014c, all -> 0x0149 }
                java.lang.String r9 = r12.toString()     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                byte[] r9 = r9.getBytes(r1)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                r8.write(r9)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                r8.flush()     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                int r9 = r6.getResponseCode()     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                java.io.InputStream r4 = r6.getInputStream()     // Catch:{ FileNotFoundException -> 0x009a }
                goto L_0x009e
            L_0x009a:
                java.io.InputStream r4 = r6.getErrorStream()     // Catch:{ Exception -> 0x0144, all -> 0x013f }
            L_0x009e:
                byte[] r6 = r11.slurp(r4)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                java.lang.String r10 = new java.lang.String     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                r10.<init>(r6, r1)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                r1.<init>()     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                java.lang.String r6 = "responseCode="
                r1.append(r6)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                r1.append(r9)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                r1.<init>()     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                java.lang.String r6 = "response="
                r1.append(r6)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                r1.append(r10)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                r0.<init>(r10)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                r1 = 200(0xc8, float:2.8E-43)
                if (r9 != r1) goto L_0x0119
                java.lang.String r1 = "delay"
                int r1 = r0.getInt(r1)     // Catch:{ Exception -> 0x0144, all -> 0x013f }
                if (r1 >= 0) goto L_0x00e2
                r1 = 0
                goto L_0x00e3
            L_0x00e2:
                r1 = r5
            L_0x00e3:
                java.lang.String r6 = "visualized_sdk_config"
                java.lang.String r6 = r0.optString(r6)     // Catch:{ Exception -> 0x0116, all -> 0x013f }
                java.lang.String r9 = "visualized_config_disabled"
                boolean r9 = r0.optBoolean(r9)     // Catch:{ Exception -> 0x0116, all -> 0x013f }
                boolean r10 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0116, all -> 0x013f }
                if (r10 == 0) goto L_0x00f7
                if (r9 == 0) goto L_0x0108
            L_0x00f7:
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r9 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x0116, all -> 0x013f }
                boolean r9 = r9.isVisualizedPropertiesEnabled()     // Catch:{ Exception -> 0x0116, all -> 0x013f }
                if (r9 == 0) goto L_0x0108
                com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r9 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ Exception -> 0x0116, all -> 0x013f }
                r9.save2Cache(r6)     // Catch:{ Exception -> 0x0116, all -> 0x013f }
            L_0x0108:
                com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r6 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ Exception -> 0x0116, all -> 0x013f }
                java.lang.String r9 = "visualized_debug_mode_enabled"
                boolean r0 = r0.optBoolean(r9)     // Catch:{ Exception -> 0x0116, all -> 0x013f }
                r6.setDebugModeEnabled(r0)     // Catch:{ Exception -> 0x0116, all -> 0x013f }
                goto L_0x011a
            L_0x0116:
                r0 = move-exception
                r6 = r4
                goto L_0x0147
            L_0x0119:
                r1 = r5
            L_0x011a:
                r8.close()     // Catch:{ Exception -> 0x011e }
                goto L_0x0122
            L_0x011e:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x0122:
                if (r4 == 0) goto L_0x012c
                r4.close()     // Catch:{ Exception -> 0x0128 }
                goto L_0x012c
            L_0x0128:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x012c:
                if (r7 == 0) goto L_0x0136
                r7.close()     // Catch:{ Exception -> 0x0132 }
                goto L_0x0136
            L_0x0132:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x0136:
                r12.close()     // Catch:{ Exception -> 0x013a }
                goto L_0x017d
            L_0x013a:
                r12 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12)
                goto L_0x017d
            L_0x013f:
                r0 = move-exception
                r6 = r4
                r4 = r8
                goto L_0x019a
            L_0x0144:
                r0 = move-exception
                r6 = r4
                r1 = r5
            L_0x0147:
                r4 = r8
                goto L_0x0157
            L_0x0149:
                r0 = move-exception
                r6 = r4
                goto L_0x019a
            L_0x014c:
                r0 = move-exception
                r6 = r4
                goto L_0x0156
            L_0x014f:
                r0 = move-exception
                r6 = r4
                r7 = r6
                goto L_0x019a
            L_0x0153:
                r0 = move-exception
                r6 = r4
                r7 = r6
            L_0x0156:
                r1 = r5
            L_0x0157:
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ all -> 0x0199 }
                if (r4 == 0) goto L_0x0164
                r4.close()     // Catch:{ Exception -> 0x0160 }
                goto L_0x0164
            L_0x0160:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x0164:
                if (r6 == 0) goto L_0x016e
                r6.close()     // Catch:{ Exception -> 0x016a }
                goto L_0x016e
            L_0x016a:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x016e:
                if (r7 == 0) goto L_0x0178
                r7.close()     // Catch:{ Exception -> 0x0174 }
                goto L_0x0178
            L_0x0174:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x0178:
                if (r12 == 0) goto L_0x017d
                r12.close()     // Catch:{ Exception -> 0x013a }
            L_0x017d:
                if (r1 == 0) goto L_0x0193
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r12 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r12 = r12.mMessageThreadHandler
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r0 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r0 = r0.mMessageThreadHandler
                android.os.Message r0 = r0.obtainMessage(r5)
                r12.sendMessageDelayed(r0, r2)
                goto L_0x0198
            L_0x0193:
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r12 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                r12.stopUpdates(r5)
            L_0x0198:
                return
            L_0x0199:
                r0 = move-exception
            L_0x019a:
                if (r4 == 0) goto L_0x01a4
                r4.close()     // Catch:{ Exception -> 0x01a0 }
                goto L_0x01a4
            L_0x01a0:
                r1 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            L_0x01a4:
                if (r6 == 0) goto L_0x01ae
                r6.close()     // Catch:{ Exception -> 0x01aa }
                goto L_0x01ae
            L_0x01aa:
                r1 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            L_0x01ae:
                if (r7 == 0) goto L_0x01b8
                r7.close()     // Catch:{ Exception -> 0x01b4 }
                goto L_0x01b8
            L_0x01b4:
                r1 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            L_0x01b8:
                if (r12 == 0) goto L_0x01c2
                r12.close()     // Catch:{ Exception -> 0x01be }
                goto L_0x01c2
            L_0x01be:
                r12 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12)
            L_0x01c2:
                throw r0
            L_0x01c3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.ViewCrawlerHandler.postSnapshot(java.io.ByteArrayOutputStream):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:106:0x037c, code lost:
            if (android.text.TextUtils.isEmpty(r4) == false) goto L_0x0381;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x05b7, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0620, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x0621, code lost:
            r11 = r17;
            r10 = r18;
            r4 = r19;
            r8 = r20;
            r2 = r0;
            r14 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x062d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x062e, code lost:
            r21 = r5;
            r22 = r12;
            r11 = r17;
            r10 = r18;
            r4 = r19;
            r8 = r20;
            r2 = r0;
            r14 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x064c, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:205:0x064d, code lost:
            r11 = r17;
            r10 = r18;
            r4 = r19;
            r8 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x0656, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:207:0x0657, code lost:
            r22 = r12;
            r11 = r17;
            r10 = r18;
            r4 = r19;
            r8 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0140, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0141, code lost:
            r2 = r0;
            r10 = "Can't close payload_out.";
            r8 = "Can't close gos.";
            r4 = "Can't close os.";
            r11 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:228:?, code lost:
            r14.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x0693, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0149, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:230:0x0694, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, r4, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:233:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:234:0x069e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:235:0x069f, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, r8, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:238:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:239:0x06a9, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:240:0x06aa, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, r10, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:251:?, code lost:
            r14.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:252:0x06c8, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:253:0x06c9, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, r4, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:256:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:257:0x06d3, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:258:0x06d4, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, r8, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:261:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:262:0x06de, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:263:0x06df, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, r10, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x029e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x029f, code lost:
            r2 = r0;
            r11 = r17;
            r10 = r18;
            r4 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x02a7, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x02a8, code lost:
            r2 = r0;
            r22 = r12;
            r11 = r17;
            r10 = r18;
            r4 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x034e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x034f, code lost:
            r2 = r0;
            r14 = r6;
            r11 = r17;
            r10 = r18;
            r4 = r19;
            r8 = r20;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x036a  */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x0370 A[SYNTHETIC, Splitter:B:104:0x0370] */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x039b A[SYNTHETIC, Splitter:B:111:0x039b] */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x03be A[SYNTHETIC, Splitter:B:116:0x03be] */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x03fd A[SYNTHETIC, Splitter:B:121:0x03fd] */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x041e A[SYNTHETIC, Splitter:B:126:0x041e] */
        /* JADX WARNING: Removed duplicated region for block: B:176:0x05dd A[SYNTHETIC, Splitter:B:176:0x05dd] */
        /* JADX WARNING: Removed duplicated region for block: B:181:0x05ea A[SYNTHETIC, Splitter:B:181:0x05ea] */
        /* JADX WARNING: Removed duplicated region for block: B:186:0x05f7 A[SYNTHETIC, Splitter:B:186:0x05f7] */
        /* JADX WARNING: Removed duplicated region for block: B:198:0x0620 A[ExcHandler: all (r0v19 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:89:0x0324] */
        /* JADX WARNING: Removed duplicated region for block: B:204:0x064c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:84:0x02e8] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0140 A[ExcHandler: all (r0v45 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r17 
          PHI: (r17v5 java.lang.String) = (r17v2 java.lang.String), (r17v2 java.lang.String), (r17v2 java.lang.String), (r17v2 java.lang.String), (r17v6 java.lang.String) binds: [B:40:0x0199, B:41:?, B:32:0x0168, B:33:?, B:12:0x0102] A[DONT_GENERATE, DONT_INLINE], Splitter:B:12:0x0102] */
        /* JADX WARNING: Removed duplicated region for block: B:227:0x068f A[SYNTHETIC, Splitter:B:227:0x068f] */
        /* JADX WARNING: Removed duplicated region for block: B:232:0x069a A[SYNTHETIC, Splitter:B:232:0x069a] */
        /* JADX WARNING: Removed duplicated region for block: B:237:0x06a5 A[SYNTHETIC, Splitter:B:237:0x06a5] */
        /* JADX WARNING: Removed duplicated region for block: B:250:0x06c4 A[SYNTHETIC, Splitter:B:250:0x06c4] */
        /* JADX WARNING: Removed duplicated region for block: B:255:0x06cf A[SYNTHETIC, Splitter:B:255:0x06cf] */
        /* JADX WARNING: Removed duplicated region for block: B:260:0x06da A[SYNTHETIC, Splitter:B:260:0x06da] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0168 A[SYNTHETIC, Splitter:B:32:0x0168] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0199 A[SYNTHETIC, Splitter:B:40:0x0199] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x029e A[ExcHandler: all (r0v37 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:49:0x01b7] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x02e0  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x032c A[SYNTHETIC, Splitter:B:92:0x032c] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x034e A[ExcHandler: all (r0v17 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r3 r6 r7 r18 r19 r20 
          PHI: (r3v16 java.io.ByteArrayOutputStream) = (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v17 java.io.ByteArrayOutputStream), (r3v30 java.io.ByteArrayOutputStream), (r3v30 java.io.ByteArrayOutputStream) binds: [B:126:0x041e, B:138:0x0484, B:149:0x04b3, B:154:0x04c1, B:159:0x04d5, B:147:0x04ac, B:148:?, B:131:0x0432, B:121:0x03fd, B:122:?, B:116:0x03be, B:117:?, B:111:0x039b, B:112:?, B:104:0x0370, B:92:0x032c, B:93:?, B:61:0x023f, B:62:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r6v3 java.io.ByteArrayOutputStream) = (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v4 java.io.ByteArrayOutputStream), (r6v16 java.io.ByteArrayOutputStream), (r6v16 java.io.ByteArrayOutputStream) binds: [B:126:0x041e, B:138:0x0484, B:149:0x04b3, B:154:0x04c1, B:159:0x04d5, B:147:0x04ac, B:148:?, B:131:0x0432, B:121:0x03fd, B:122:?, B:116:0x03be, B:117:?, B:111:0x039b, B:112:?, B:104:0x0370, B:92:0x032c, B:93:?, B:61:0x023f, B:62:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r7v8 java.util.zip.GZIPOutputStream) = (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v9 java.util.zip.GZIPOutputStream), (r7v16 java.util.zip.GZIPOutputStream), (r7v16 java.util.zip.GZIPOutputStream) binds: [B:126:0x041e, B:138:0x0484, B:149:0x04b3, B:154:0x04c1, B:159:0x04d5, B:147:0x04ac, B:148:?, B:131:0x0432, B:121:0x03fd, B:122:?, B:116:0x03be, B:117:?, B:111:0x039b, B:112:?, B:104:0x0370, B:92:0x032c, B:93:?, B:61:0x023f, B:62:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r18v2 java.lang.String) = (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v5 java.lang.String), (r18v5 java.lang.String) binds: [B:126:0x041e, B:138:0x0484, B:149:0x04b3, B:154:0x04c1, B:159:0x04d5, B:147:0x04ac, B:148:?, B:131:0x0432, B:121:0x03fd, B:122:?, B:116:0x03be, B:117:?, B:111:0x039b, B:112:?, B:104:0x0370, B:92:0x032c, B:93:?, B:61:0x023f, B:62:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r19v2 java.lang.String) = (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v6 java.lang.String), (r19v6 java.lang.String) binds: [B:126:0x041e, B:138:0x0484, B:149:0x04b3, B:154:0x04c1, B:159:0x04d5, B:147:0x04ac, B:148:?, B:131:0x0432, B:121:0x03fd, B:122:?, B:116:0x03be, B:117:?, B:111:0x039b, B:112:?, B:104:0x0370, B:92:0x032c, B:93:?, B:61:0x023f, B:62:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r20v2 java.lang.String) = (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v3 java.lang.String), (r20v5 java.lang.String), (r20v5 java.lang.String) binds: [B:126:0x041e, B:138:0x0484, B:149:0x04b3, B:154:0x04c1, B:159:0x04d5, B:147:0x04ac, B:148:?, B:131:0x0432, B:121:0x03fd, B:122:?, B:116:0x03be, B:117:?, B:111:0x039b, B:112:?, B:104:0x0370, B:92:0x032c, B:93:?, B:61:0x023f, B:62:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:138:0x0484] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void sendSnapshot() {
            /*
                r23 = this;
                r1 = r23
                java.lang.String r2 = "{"
                java.lang.String r3 = "Can't close writer."
                java.lang.String r4 = "Can't close payload_out."
                java.lang.String r5 = "Can't close gos."
                java.lang.String r6 = "Can't close os."
                java.lang.String r7 = "\","
                java.lang.String r8 = ","
                java.lang.String r9 = "SA.AbstractViewCrawler"
                long r10 = java.lang.System.currentTimeMillis()
                com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol r12 = r1.mProtocol     // Catch:{ BadInstructionsException -> 0x06ed }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r13 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ BadInstructionsException -> 0x06ed }
                android.os.Handler r13 = r13.mMainThreadHandler     // Catch:{ BadInstructionsException -> 0x06ed }
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot r12 = r12.readSnapshotConfig(r13)     // Catch:{ BadInstructionsException -> 0x06ed }
                r1.mSnapshot = r12     // Catch:{ BadInstructionsException -> 0x06ed }
                if (r12 != 0) goto L_0x002c
                java.lang.String r2 = "Snapshot should be initialize at first calling."
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r9, (java.lang.String) r2)     // Catch:{ BadInstructionsException -> 0x06ed }
                return
            L_0x002c:
                java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream
                r12.<init>()
                java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream
                r13.<init>(r12)
                byte[] r15 = r2.getBytes()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r13.write(r15)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r15 = "\"type\": \"snapshot_response\","
                byte[] r15 = r15.getBytes()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r13.write(r15)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r15.<init>()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r14 = "\"feature_code\": \""
                r15.append(r14)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r14 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r14 = r14.mFeatureCode     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r15.append(r14)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r15.append(r7)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r14 = r15.toString()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r13.write(r14)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.<init>()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r15 = "\"app_version\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r15 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r15 = r15.mAppVersion     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.append(r15)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.append(r7)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r13.write(r14)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.<init>()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r15 = "\"lib_version\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r15 = r1.mSDKVersion     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.append(r15)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.append(r7)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r13.write(r14)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r14 = "\"os\": \"Android\","
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r13.write(r14)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r14 = "\"lib\": \"Android\","
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r13.write(r14)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.<init>()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r15 = "\"app_id\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r15 = r1.mAppId     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.append(r15)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.append(r7)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r13.write(r14)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.<init>()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r15 = "\"app_enablevisualizedproperties\": "
                r14.append(r15)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r15 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                boolean r15 = r15.isVisualizedPropertiesEnabled()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.append(r15)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r14.append(r8)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                byte[] r14 = r14.getBytes()     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                r13.write(r14)     // Catch:{ IOException -> 0x067c, all -> 0x0672 }
                org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ Exception -> 0x0153, all -> 0x014b }
                r14.<init>()     // Catch:{ Exception -> 0x0153, all -> 0x014b }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI r15 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x0153, all -> 0x014b }
                r17 = r3
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r3 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_CLICK     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                boolean r3 = r15.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r3)     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                if (r3 != 0) goto L_0x010f
                java.lang.String r3 = "$AppClick"
                r14.put(r3)     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
            L_0x010f:
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI r3 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r15 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                boolean r3 = r3.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r15)     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                if (r3 != 0) goto L_0x0120
                java.lang.String r3 = "$AppViewScreen"
                r14.put(r3)     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
            L_0x0120:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                r3.<init>()     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                java.lang.String r15 = "\"app_autotrack\": "
                r3.append(r15)     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                r3.append(r14)     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                r3.append(r8)     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                r13.write(r3)     // Catch:{ Exception -> 0x0149, all -> 0x0140 }
                goto L_0x015a
            L_0x0140:
                r0 = move-exception
                r2 = r0
                r10 = r4
                r8 = r5
                r4 = r6
                r11 = r17
                goto L_0x0678
            L_0x0149:
                r0 = move-exception
                goto L_0x0156
            L_0x014b:
                r0 = move-exception
                r2 = r0
                r11 = r3
                r10 = r4
                r8 = r5
                r4 = r6
                goto L_0x0678
            L_0x0153:
                r0 = move-exception
                r17 = r3
            L_0x0156:
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r3)     // Catch:{ IOException -> 0x0669, all -> 0x0662 }
            L_0x015a:
                com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r3 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ IOException -> 0x0669, all -> 0x0662 }
                java.lang.String r3 = r3.getVisualConfigVersion()     // Catch:{ IOException -> 0x0669, all -> 0x0662 }
                boolean r14 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x0669, all -> 0x0662 }
                if (r14 != 0) goto L_0x018f
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0184, all -> 0x0140 }
                r14.<init>()     // Catch:{ IOException -> 0x0184, all -> 0x0140 }
                java.lang.String r15 = "\"config_version\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x0184, all -> 0x0140 }
                r14.append(r3)     // Catch:{ IOException -> 0x0184, all -> 0x0140 }
                r14.append(r7)     // Catch:{ IOException -> 0x0184, all -> 0x0140 }
                java.lang.String r3 = r14.toString()     // Catch:{ IOException -> 0x0184, all -> 0x0140 }
                byte[] r3 = r3.getBytes()     // Catch:{ IOException -> 0x0184, all -> 0x0140 }
                r13.write(r3)     // Catch:{ IOException -> 0x0184, all -> 0x0140 }
                goto L_0x018f
            L_0x0184:
                r0 = move-exception
                r2 = r0
                r10 = r4
                r8 = r5
                r4 = r6
                r22 = r12
                r11 = r17
                goto L_0x0684
            L_0x018f:
                boolean r3 = r1.mUseGzip     // Catch:{ IOException -> 0x0669, all -> 0x0662 }
                java.lang.String r7 = ",\"snapshot_time_millis\": "
                java.lang.String r14 = "}"
                java.lang.String r15 = "\""
                if (r3 == 0) goto L_0x02e0
                java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0184, all -> 0x0140 }
                r3.<init>()     // Catch:{ IOException -> 0x0184, all -> 0x0140 }
                r18 = r4
                java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x02d4, all -> 0x02ca }
                r4.<init>(r3)     // Catch:{ IOException -> 0x02d4, all -> 0x02ca }
                java.lang.String r19 = "{\"activities\":"
                r20 = r5
                byte[] r5 = r19.getBytes()     // Catch:{ IOException -> 0x02bd, all -> 0x02b2 }
                r4.write(r5)     // Catch:{ IOException -> 0x02bd, all -> 0x02b2 }
                r4.flush()     // Catch:{ IOException -> 0x02bd, all -> 0x02b2 }
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot r5 = r1.mSnapshot     // Catch:{ IOException -> 0x02bd, all -> 0x02b2 }
                r19 = r6
                java.lang.StringBuilder r6 = r1.mLastImageHash     // Catch:{ IOException -> 0x02a7, all -> 0x029e }
                com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo r5 = r5.snapshots(r3, r6)     // Catch:{ IOException -> 0x02a7, all -> 0x029e }
                long r21 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                long r21 = r21 - r10
                byte[] r6 = r7.getBytes()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r4.write(r6)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                java.lang.String r6 = java.lang.Long.toString(r21)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r4.write(r6)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r6 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                java.lang.String r6 = r6.getDebugInfo()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                if (r7 != 0) goto L_0x01fa
                byte[] r7 = r8.getBytes()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r4.write(r7)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                java.lang.String r7 = "\"event_debug\": "
                byte[] r7 = r7.getBytes()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r4.write(r7)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r4.write(r6)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
            L_0x01fa:
                com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r6 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                java.lang.String r6 = r6.getVisualLogInfo()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                if (r7 != 0) goto L_0x021f
                byte[] r7 = r8.getBytes()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r4.write(r7)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                java.lang.String r7 = "\"log_info\":"
                byte[] r7 = r7.getBytes()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r4.write(r7)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r4.write(r6)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
            L_0x021f:
                byte[] r6 = r14.getBytes()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r4.write(r6)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r4.flush()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r3.close()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                java.lang.String r4 = r3.toString()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                int r7 = r4.length     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                r6.<init>(r7)     // Catch:{ IOException -> 0x0290, all -> 0x029e }
                java.util.zip.GZIPOutputStream r7 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0280, all -> 0x0272 }
                r7.<init>(r6)     // Catch:{ IOException -> 0x0280, all -> 0x0272 }
                r7.write(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r7.close()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                byte[] r4 = r6.toByteArray()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r6.close()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.<init>()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r11 = "\"gzip_payload\": \""
                r10.append(r11)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                char[] r4 = com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r11.<init>(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.append(r11)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.append(r15)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r4 = r10.toString()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                goto L_0x0324
            L_0x0272:
                r0 = move-exception
                r2 = r0
                r14 = r6
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                r7 = 0
                goto L_0x06c2
            L_0x0280:
                r0 = move-exception
                r2 = r0
                r14 = r6
                r22 = r12
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                r7 = 0
                goto L_0x0688
            L_0x0290:
                r0 = move-exception
                r2 = r0
                r22 = r12
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                goto L_0x0686
            L_0x029e:
                r0 = move-exception
                r2 = r0
                r11 = r17
                r10 = r18
                r4 = r19
                goto L_0x02b9
            L_0x02a7:
                r0 = move-exception
                r2 = r0
                r22 = r12
                r11 = r17
                r10 = r18
                r4 = r19
                goto L_0x02c6
            L_0x02b2:
                r0 = move-exception
                r2 = r0
                r4 = r6
                r11 = r17
                r10 = r18
            L_0x02b9:
                r8 = r20
                goto L_0x0679
            L_0x02bd:
                r0 = move-exception
                r2 = r0
                r4 = r6
                r22 = r12
                r11 = r17
                r10 = r18
            L_0x02c6:
                r8 = r20
                goto L_0x0685
            L_0x02ca:
                r0 = move-exception
                r2 = r0
                r8 = r5
                r4 = r6
                r11 = r17
                r10 = r18
                goto L_0x0679
            L_0x02d4:
                r0 = move-exception
                r2 = r0
                r8 = r5
                r4 = r6
                r22 = r12
                r11 = r17
                r10 = r18
                goto L_0x0685
            L_0x02e0:
                r18 = r4
                r20 = r5
                r19 = r6
                java.lang.String r3 = "\"payload\": {"
                byte[] r3 = r3.getBytes()     // Catch:{ IOException -> 0x0656, all -> 0x064c }
                r13.write(r3)     // Catch:{ IOException -> 0x0656, all -> 0x064c }
                java.lang.String r3 = "\"activities\":"
                byte[] r3 = r3.getBytes()     // Catch:{ IOException -> 0x0656, all -> 0x064c }
                r13.write(r3)     // Catch:{ IOException -> 0x0656, all -> 0x064c }
                r13.flush()     // Catch:{ IOException -> 0x0656, all -> 0x064c }
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot r3 = r1.mSnapshot     // Catch:{ IOException -> 0x0656, all -> 0x064c }
                java.lang.StringBuilder r4 = r1.mLastImageHash     // Catch:{ IOException -> 0x0656, all -> 0x064c }
                com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo r5 = r3.snapshots(r12, r4)     // Catch:{ IOException -> 0x0656, all -> 0x064c }
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x063e, all -> 0x064c }
                long r3 = r3 - r10
                byte[] r6 = r7.getBytes()     // Catch:{ IOException -> 0x063e, all -> 0x064c }
                r13.write(r6)     // Catch:{ IOException -> 0x063e, all -> 0x064c }
                java.lang.String r3 = java.lang.Long.toString(r3)     // Catch:{ IOException -> 0x063e, all -> 0x064c }
                byte[] r3 = r3.getBytes()     // Catch:{ IOException -> 0x063e, all -> 0x064c }
                r13.write(r3)     // Catch:{ IOException -> 0x063e, all -> 0x064c }
                byte[] r3 = r14.getBytes()     // Catch:{ IOException -> 0x063e, all -> 0x064c }
                r13.write(r3)     // Catch:{ IOException -> 0x063e, all -> 0x064c }
                r3 = 0
                r6 = 0
                r7 = 0
            L_0x0324:
                java.lang.String r4 = r5.screenName     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                if (r4 != 0) goto L_0x036a
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r4.<init>()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r10 = ",\"screen_name\": \""
                r4.append(r10)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r10 = r5.screenName     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r4.append(r10)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r4.append(r15)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r4 = r5.screenName     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r16 = r4
                goto L_0x036c
            L_0x034e:
                r0 = move-exception
                r2 = r0
                r14 = r6
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                goto L_0x06c2
            L_0x035b:
                r0 = move-exception
                r2 = r0
                r14 = r6
                r22 = r12
            L_0x0360:
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                goto L_0x0688
            L_0x036a:
                r16 = 0
            L_0x036c:
                boolean r4 = r5.hasFragment     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                if (r4 == 0) goto L_0x037f
                com.sensorsdata.analytics.android.sdk.AppStateManager r4 = com.sensorsdata.analytics.android.sdk.AppStateManager.getInstance()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r4 = r4.getFragmentScreenName()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                boolean r10 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                if (r10 != 0) goto L_0x037f
                goto L_0x0381
            L_0x037f:
                r4 = r16
            L_0x0381:
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                r10.<init>()     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                java.lang.String r11 = "page_name： "
                r10.append(r11)     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                r10.append(r4)     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                boolean r10 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                if (r10 != 0) goto L_0x03b6
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.<init>()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r11 = ",\"page_name\": \""
                r10.append(r11)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.append(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.append(r15)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r4 = r10.toString()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
            L_0x03b6:
                java.lang.String r4 = r5.activityTitle     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                if (r4 != 0) goto L_0x03db
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r4.<init>()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r10 = ",\"title\": \""
                r4.append(r10)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r10 = r5.activityTitle     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r4.append(r10)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r4.append(r15)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
            L_0x03db:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                r4.<init>()     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                java.lang.String r10 = ",\"is_webview\": "
                r4.append(r10)     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                boolean r10 = r5.isWebView     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                r4.append(r10)     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                r13.write(r4)     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                java.lang.String r4 = r5.webLibVersion     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                if (r4 != 0) goto L_0x041a
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r4.<init>()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r10 = ",\"web_lib_version\": \""
                r4.append(r10)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r10 = r5.webLibVersion     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r4.append(r10)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r4.append(r15)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
            L_0x041a:
                boolean r4 = r5.isWebView     // Catch:{ IOException -> 0x062d, all -> 0x0620 }
                if (r4 == 0) goto L_0x05cd
                java.lang.String r4 = r5.webViewUrl     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                if (r4 != 0) goto L_0x05cd
                com.sensorsdata.analytics.android.sdk.visual.WebNodesManager r4 = com.sensorsdata.analytics.android.sdk.visual.WebNodesManager.getInstance()     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                java.lang.String r10 = r5.webViewUrl     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo r4 = r4.getWebPageInfo(r10)     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                if (r4 == 0) goto L_0x0484
                java.lang.String r10 = r4.getUrl()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                if (r10 != 0) goto L_0x045b
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.<init>()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r11 = ",\"h5_url\": \""
                r10.append(r11)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r11 = r4.getUrl()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.append(r11)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.append(r15)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                byte[] r10 = r10.getBytes()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r13.write(r10)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
            L_0x045b:
                java.lang.String r10 = r4.getTitle()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                if (r10 != 0) goto L_0x0484
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.<init>()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r11 = ",\"h5_title\": \""
                r10.append(r11)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r4 = r4.getTitle()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.append(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r10.append(r15)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                java.lang.String r4 = r10.toString()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
            L_0x0484:
                java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo$AlertInfo> r4 = r5.alertInfos     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                if (r4 == 0) goto L_0x05cd
                int r10 = r4.size()     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                if (r10 <= 0) goto L_0x05cd
                java.lang.String r10 = ",\"app_alert_infos\":"
                byte[] r10 = r10.getBytes()     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                r13.write(r10)     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                r13.flush()     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                java.lang.String r10 = "["
                byte[] r10 = r10.getBytes()     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                r13.write(r10)     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                r10 = 0
            L_0x04a4:
                int r11 = r4.size()     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                if (r10 >= r11) goto L_0x05a6
                if (r10 <= 0) goto L_0x04b3
                byte[] r11 = r8.getBytes()     // Catch:{ IOException -> 0x035b, all -> 0x034e }
                r13.write(r11)     // Catch:{ IOException -> 0x035b, all -> 0x034e }
            L_0x04b3:
                java.lang.Object r11 = r4.get(r10)     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo$AlertInfo r11 = (com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.AlertInfo) r11     // Catch:{ IOException -> 0x05c4, all -> 0x034e }
                if (r11 == 0) goto L_0x0596
                r16 = r4
                java.lang.String r4 = "heat_map"
                r21 = r5
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r5 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x0592, all -> 0x034e }
                java.lang.String r5 = r5.mType     // Catch:{ IOException -> 0x0592, all -> 0x034e }
                boolean r4 = android.text.TextUtils.equals(r4, r5)     // Catch:{ IOException -> 0x0592, all -> 0x034e }
                if (r4 == 0) goto L_0x04dc
                java.lang.String r4 = r11.title     // Catch:{ IOException -> 0x0592, all -> 0x034e }
                java.lang.String r5 = "可视化全埋点"
                r22 = r12
                java.lang.String r12 = "点击分析"
                java.lang.String r4 = r4.replace(r5, r12)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r11.title = r4     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                goto L_0x04de
            L_0x04dc:
                r22 = r12
            L_0x04de:
                byte[] r4 = r2.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r4 = "\"title\":"
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.<init>()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r15)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r5 = r11.title     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r5)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r15)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                byte[] r4 = r8.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r4 = "\"message\":"
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.<init>()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r15)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r5 = r11.message     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r5)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r15)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                byte[] r4 = r8.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r4 = "\"link_text\":"
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.<init>()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r15)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r5 = r11.linkText     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r5)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r15)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                byte[] r4 = r8.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r4 = "\"link_url\":"
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.<init>()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r15)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r5 = r11.linkUrl     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r5)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r4.append(r15)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                byte[] r4 = r14.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r4)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                goto L_0x059c
            L_0x0592:
                r0 = move-exception
                r22 = r12
                goto L_0x05b8
            L_0x0596:
                r16 = r4
                r21 = r5
                r22 = r12
            L_0x059c:
                int r10 = r10 + 1
                r4 = r16
                r5 = r21
                r12 = r22
                goto L_0x04a4
            L_0x05a6:
                r21 = r5
                r22 = r12
                java.lang.String r2 = "]"
                byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.write(r2)     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                r13.flush()     // Catch:{ IOException -> 0x05b7, all -> 0x034e }
                goto L_0x05d1
            L_0x05b7:
                r0 = move-exception
            L_0x05b8:
                r2 = r0
                r14 = r6
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                goto L_0x061c
            L_0x05c4:
                r0 = move-exception
                r21 = r5
                r22 = r12
                r2 = r0
                r14 = r6
                goto L_0x0360
            L_0x05cd:
                r21 = r5
                r22 = r12
            L_0x05d1:
                byte[] r2 = r14.getBytes()     // Catch:{ IOException -> 0x0611, all -> 0x0620 }
                r13.write(r2)     // Catch:{ IOException -> 0x0611, all -> 0x0620 }
                r13.flush()     // Catch:{ IOException -> 0x0611, all -> 0x0620 }
                if (r6 == 0) goto L_0x05e8
                r6.close()     // Catch:{ Exception -> 0x05e1 }
                goto L_0x05e8
            L_0x05e1:
                r0 = move-exception
                r2 = r0
                r4 = r19
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r4, r2)
            L_0x05e8:
                if (r7 == 0) goto L_0x05f5
                r7.close()     // Catch:{ Exception -> 0x05ee }
                goto L_0x05f5
            L_0x05ee:
                r0 = move-exception
                r2 = r0
                r8 = r20
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r8, r2)
            L_0x05f5:
                if (r3 == 0) goto L_0x0602
                r3.close()     // Catch:{ Exception -> 0x05fb }
                goto L_0x0602
            L_0x05fb:
                r0 = move-exception
                r2 = r0
                r10 = r18
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r10, r2)
            L_0x0602:
                r13.close()     // Catch:{ IOException -> 0x0606 }
                goto L_0x060d
            L_0x0606:
                r0 = move-exception
                r2 = r0
                r11 = r17
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r11, r2)
            L_0x060d:
                r5 = r21
                goto L_0x06b7
            L_0x0611:
                r0 = move-exception
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                r2 = r0
                r14 = r6
            L_0x061c:
                r5 = r21
                goto L_0x0688
            L_0x0620:
                r0 = move-exception
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                r2 = r0
                r14 = r6
                goto L_0x06c2
            L_0x062d:
                r0 = move-exception
                r21 = r5
                r22 = r12
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                r2 = r0
                r14 = r6
                goto L_0x0688
            L_0x063e:
                r0 = move-exception
                r22 = r12
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                r2 = r0
                r3 = 0
                goto L_0x0686
            L_0x064c:
                r0 = move-exception
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                goto L_0x0677
            L_0x0656:
                r0 = move-exception
                r22 = r12
                r11 = r17
                r10 = r18
                r4 = r19
                r8 = r20
                goto L_0x0683
            L_0x0662:
                r0 = move-exception
                r10 = r4
                r8 = r5
                r4 = r6
                r11 = r17
                goto L_0x0677
            L_0x0669:
                r0 = move-exception
                r10 = r4
                r8 = r5
                r4 = r6
                r22 = r12
                r11 = r17
                goto L_0x0683
            L_0x0672:
                r0 = move-exception
                r11 = r3
                r10 = r4
                r8 = r5
                r4 = r6
            L_0x0677:
                r2 = r0
            L_0x0678:
                r3 = 0
            L_0x0679:
                r7 = 0
                r14 = 0
                goto L_0x06c2
            L_0x067c:
                r0 = move-exception
                r11 = r3
                r10 = r4
                r8 = r5
                r4 = r6
                r22 = r12
            L_0x0683:
                r2 = r0
            L_0x0684:
                r3 = 0
            L_0x0685:
                r5 = 0
            L_0x0686:
                r7 = 0
                r14 = 0
            L_0x0688:
                java.lang.String r6 = "Can't write snapshot request to server"
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r6, r2)     // Catch:{ all -> 0x06c0 }
                if (r14 == 0) goto L_0x0698
                r14.close()     // Catch:{ Exception -> 0x0693 }
                goto L_0x0698
            L_0x0693:
                r0 = move-exception
                r2 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r4, r2)
            L_0x0698:
                if (r7 == 0) goto L_0x06a3
                r7.close()     // Catch:{ Exception -> 0x069e }
                goto L_0x06a3
            L_0x069e:
                r0 = move-exception
                r2 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r8, r2)
            L_0x06a3:
                if (r3 == 0) goto L_0x06ae
                r3.close()     // Catch:{ Exception -> 0x06a9 }
                goto L_0x06ae
            L_0x06a9:
                r0 = move-exception
                r2 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r10, r2)
            L_0x06ae:
                r13.close()     // Catch:{ IOException -> 0x06b2 }
                goto L_0x06b7
            L_0x06b2:
                r0 = move-exception
                r2 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r11, r2)
            L_0x06b7:
                r1.onSnapFinished(r5)
                r2 = r22
                r1.postSnapshot(r2)
                return
            L_0x06c0:
                r0 = move-exception
                r2 = r0
            L_0x06c2:
                if (r14 == 0) goto L_0x06cd
                r14.close()     // Catch:{ Exception -> 0x06c8 }
                goto L_0x06cd
            L_0x06c8:
                r0 = move-exception
                r5 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r4, r5)
            L_0x06cd:
                if (r7 == 0) goto L_0x06d8
                r7.close()     // Catch:{ Exception -> 0x06d3 }
                goto L_0x06d8
            L_0x06d3:
                r0 = move-exception
                r4 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r8, r4)
            L_0x06d8:
                if (r3 == 0) goto L_0x06e3
                r3.close()     // Catch:{ Exception -> 0x06de }
                goto L_0x06e3
            L_0x06de:
                r0 = move-exception
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r10, r3)
            L_0x06e3:
                r13.close()     // Catch:{ IOException -> 0x06e7 }
                goto L_0x06ec
            L_0x06e7:
                r0 = move-exception
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r11, r3)
            L_0x06ec:
                throw r2
            L_0x06ed:
                r0 = move-exception
                r2 = r0
                java.lang.String r3 = "VisualizedAutoTrack server sent malformed message with snapshot request"
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r3, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.ViewCrawlerHandler.sendSnapshot():void");
        }

        private byte[] slurp(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr, 0, 8192);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                sendSnapshot();
            }
        }

        public void start() {
        }

        private ViewCrawlerHandler(Context context, Looper looper, String str) {
            super(looper);
            this.mSnapshot = null;
            this.mProtocol = new EditProtocol(new ResourceReader.Ids(str, context));
            this.mLastImageHash = new StringBuilder();
            this.mUseGzip = true;
            this.mAppId = AppInfoUtils.getProcessName(context);
            this.mSDKVersion = SensorsDataAPI.sharedInstance().getSDKVersion();
        }
    }

    public AbstractViewCrawler(Activity activity, String str, String str2, String str3, String str4) {
        this.mActivity = activity;
        this.mFeatureCode = str2;
        EditState editState = new EditState();
        this.mEditState = editState;
        this.mType = str4;
        editState.add(activity);
        this.mLifecycleCallbacks = new LifecycleCallbacks();
        try {
            this.mPostUrl = URLDecoder.decode(str3, "UTF-8");
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        Application application = (Application) this.mActivity.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
        }
        try {
            this.mAppVersion = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            this.mAppVersion = "";
        }
        HandlerThread handlerThread = new HandlerThread(VisualizedAutoTrackViewCrawler.class.getCanonicalName(), 10);
        handlerThread.start();
        this.mMessageThreadHandler = new ViewCrawlerHandler(this.mActivity, handlerThread.getLooper(), str);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    }

    public boolean isServiceRunning() {
        return this.mServiceRunning;
    }

    public void startUpdates() {
        try {
            if (!TextUtils.isEmpty(this.mFeatureCode) && !TextUtils.isEmpty(this.mPostUrl)) {
                Application application = (Application) this.mActivity.getApplicationContext();
                if (Build.VERSION.SDK_INT >= 14) {
                    application.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
                }
                this.mMessageThreadHandler.start();
                ViewCrawlerHandler viewCrawlerHandler = this.mMessageThreadHandler;
                viewCrawlerHandler.sendMessage(viewCrawlerHandler.obtainMessage(1));
                this.mServiceRunning = true;
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void stopUpdates(boolean z11) {
        if (z11) {
            try {
                this.mFeatureCode = null;
                this.mPostUrl = null;
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
                return;
            }
        }
        this.mMessageThreadHandler.removeMessages(1);
        Application application = (Application) this.mActivity.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            application.unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
        }
        this.mServiceRunning = false;
    }
}
