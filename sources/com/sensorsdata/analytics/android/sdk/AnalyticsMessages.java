package com.sensorsdata.analytics.android.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException;
import com.sensorsdata.analytics.android.sdk.exceptions.DebugModeException;
import com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;
import com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

class AnalyticsMessages {
    private static final int DELETE_ALL = 4;
    private static final int FLUSH_QUEUE = 3;
    private static final int FLUSH_SCHEDULE = 5;
    private static final Map<Context, AnalyticsMessages> S_INSTANCES = new HashMap();
    private static final String TAG = "SA.AnalyticsMessages";
    private final Context mContext;
    /* access modifiers changed from: private */
    public final DbAdapter mDbAdapter = DbAdapter.getInstance();
    private SensorsDataAPI mSensorsDataAPI;
    private final Worker mWorker = new Worker();

    public class Worker {
        private Handler mHandler;
        private final Object mHandlerLock = new Object();

        public class AnalyticsMessageHandler extends Handler {
            public AnalyticsMessageHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                try {
                    int i11 = message.what;
                    if (i11 == 3) {
                        AnalyticsMessages.this.sendData();
                    } else if (i11 == 4) {
                        try {
                            AnalyticsMessages.this.mDbAdapter.deleteAllEvents();
                        } catch (Exception e11) {
                            SALog.printStackTrace(e11);
                        }
                    } else if (i11 == 5) {
                        AnalyticsMessages.this.flushScheduled();
                        AnalyticsMessages.this.sendData();
                    } else {
                        SALog.i(AnalyticsMessages.TAG, "Unexpected message received by SensorsData worker: " + message);
                    }
                } catch (RuntimeException e12) {
                    SALog.i(AnalyticsMessages.TAG, "Worker threw an unhandled exception", e12);
                }
            }
        }

        public Worker() {
            HandlerThread handlerThread = new HandlerThread("com.sensorsdata.analytics.android.sdk.AnalyticsMessages.Worker", 1);
            handlerThread.start();
            this.mHandler = new AnalyticsMessageHandler(handlerThread.getLooper());
        }

        public void runMessage(Message message) {
            synchronized (this.mHandlerLock) {
                Handler handler = this.mHandler;
                if (handler == null) {
                    SALog.i(AnalyticsMessages.TAG, "Dead worker dropping a message: " + message.what);
                } else {
                    handler.sendMessage(message);
                }
            }
        }

        public void runMessageOnce(Message message, long j11) {
            synchronized (this.mHandlerLock) {
                Handler handler = this.mHandler;
                if (handler == null) {
                    SALog.i(AnalyticsMessages.TAG, "Dead worker dropping a message: " + message.what);
                } else if (!handler.hasMessages(message.what)) {
                    this.mHandler.sendMessageDelayed(message, j11);
                }
            }
        }
    }

    private AnalyticsMessages(Context context, SensorsDataAPI sensorsDataAPI) {
        this.mContext = context;
        this.mSensorsDataAPI = sensorsDataAPI;
    }

    private void closeStream(BufferedOutputStream bufferedOutputStream, OutputStream outputStream, InputStream inputStream, HttpURLConnection httpURLConnection) {
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (Exception e11) {
                SALog.i(TAG, e11.getMessage());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e12) {
                SALog.i(TAG, e12.getMessage());
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e13) {
                SALog.i(TAG, e13.getMessage());
            }
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e14) {
                SALog.i(TAG, e14.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041 A[SYNTHETIC, Splitter:B:19:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String encodeData(java.lang.String r5) throws com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException {
        /*
            r4 = this;
            java.lang.String r0 = "UTF-8"
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0038 }
            byte[] r3 = r5.getBytes(r0)     // Catch:{ IOException -> 0x0038 }
            int r3 = r3.length     // Catch:{ IOException -> 0x0038 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0038 }
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0038 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0038 }
            byte[] r5 = r5.getBytes(r0)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r3.write(r5)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r3.close()     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            byte[] r5 = r2.toByteArray()     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r2.close()     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            char[] r5 = com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(r5)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r0.<init>(r5)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r3.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r0
        L_0x0030:
            r5 = move-exception
            r1 = r3
            goto L_0x003f
        L_0x0033:
            r5 = move-exception
            r1 = r3
            goto L_0x0039
        L_0x0036:
            r5 = move-exception
            goto L_0x003f
        L_0x0038:
            r5 = move-exception
        L_0x0039:
            com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException r0 = new com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException     // Catch:{ all -> 0x0036 }
            r0.<init>((java.lang.Throwable) r5)     // Catch:{ all -> 0x0036 }
            throw r0     // Catch:{ all -> 0x0036 }
        L_0x003f:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.AnalyticsMessages.encodeData(java.lang.String):java.lang.String");
    }

    public static AnalyticsMessages getInstance(Context context, SensorsDataAPI sensorsDataAPI) {
        AnalyticsMessages analyticsMessages;
        Map<Context, AnalyticsMessages> map = S_INSTANCES;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (!map.containsKey(applicationContext)) {
                analyticsMessages = new AnalyticsMessages(applicationContext, sensorsDataAPI);
                map.put(applicationContext, analyticsMessages);
            } else {
                analyticsMessages = map.get(applicationContext);
            }
        }
        return analyticsMessages;
    }

    private boolean isDeleteEventsByCode(int i11) {
        return (i11 == 404 || i11 == 403 || (i11 >= 500 && i11 < 600)) ? false : true;
    }

    /* access modifiers changed from: private */
    public void sendData() {
        String[] strArr;
        boolean z11;
        String str;
        String format;
        try {
            if (!this.mSensorsDataAPI.isNetworkRequestEnable()) {
                SALog.i(TAG, "NetworkRequest 已关闭，不发送数据！");
            } else if (TextUtils.isEmpty(this.mSensorsDataAPI.getServerUrl())) {
                SALog.i(TAG, "Server url is null or empty.");
            } else if (NetworkUtils.isNetworkAvailable(this.mContext)) {
                String networkType = NetworkUtils.networkType(this.mContext);
                if (!NetworkUtils.isShouldFlush(networkType, this.mSensorsDataAPI.getFlushNetworkPolicy())) {
                    SALog.i(TAG, String.format("您当前网络为 %s，无法发送数据，请确认您的网络发送策略！", new Object[]{networkType}));
                    return;
                }
                if (AbstractSensorsDataAPI.getConfigOptions().isMultiProcessFlush()) {
                    if (!DbAdapter.getInstance().isSubProcessFlushing()) {
                        DbAdapter.getInstance().commitSubProcessFlushState(true);
                    } else {
                        return;
                    }
                } else if (!AbstractSensorsDataAPI.mIsMainProcess) {
                    return;
                }
                int i11 = 100;
                while (i11 > 0) {
                    synchronized (this.mDbAdapter) {
                        if (this.mSensorsDataAPI.isDebugMode()) {
                            strArr = this.mDbAdapter.generateDataString(DbParams.TABLE_EVENTS, 1);
                        } else {
                            strArr = this.mDbAdapter.generateDataString(DbParams.TABLE_EVENTS, 50);
                        }
                    }
                    if (strArr == null) {
                        DbAdapter.getInstance().commitSubProcessFlushState(false);
                        return;
                    }
                    String str2 = strArr[0];
                    String str3 = strArr[1];
                    String str4 = strArr[2];
                    try {
                        String encodeData = "1".equals(str4) ? encodeData(str3) : str3;
                        if (!TextUtils.isEmpty(encodeData)) {
                            sendHttpRequest(this.mSensorsDataAPI.getServerUrl(), encodeData, str4, str3, false);
                        }
                        boolean isDebugMode = this.mSensorsDataAPI.isDebugMode();
                        if (!TextUtils.isEmpty((CharSequence) null) && (isDebugMode || SALog.isLogEnabled())) {
                            SALog.i(TAG, (String) null);
                            if (isDebugMode && AbstractSensorsDataAPI.SHOW_DEBUG_INFO_VIEW) {
                                SensorsDataDialogUtils.showHttpErrorDialog(AppStateManager.getInstance().getForegroundActivity(), (String) null);
                            }
                        }
                        i11 = this.mDbAdapter.cleanupEvents(str2);
                        str = TAG;
                        format = String.format(Locale.CHINA, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(i11)});
                    } catch (ConnectErrorException e11) {
                        String str5 = "Connection error: " + e11.getMessage();
                        boolean isDebugMode2 = this.mSensorsDataAPI.isDebugMode();
                        if (!TextUtils.isEmpty(str5) && (isDebugMode2 || SALog.isLogEnabled())) {
                            SALog.i(TAG, str5);
                            if (isDebugMode2 && AbstractSensorsDataAPI.SHOW_DEBUG_INFO_VIEW) {
                                SensorsDataDialogUtils.showHttpErrorDialog(AppStateManager.getInstance().getForegroundActivity(), str5);
                            }
                        }
                        if (isDebugMode2) {
                            i11 = this.mDbAdapter.cleanupEvents(str2);
                            str = TAG;
                            format = String.format(Locale.CHINA, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(i11)});
                        }
                        i11 = 0;
                    } catch (InvalidDataException e12) {
                        String str6 = "Invalid data: " + e12.getMessage();
                        boolean isDebugMode3 = this.mSensorsDataAPI.isDebugMode();
                        if (!TextUtils.isEmpty(str6) && (isDebugMode3 || SALog.isLogEnabled())) {
                            SALog.i(TAG, str6);
                            if (isDebugMode3 && AbstractSensorsDataAPI.SHOW_DEBUG_INFO_VIEW) {
                                SensorsDataDialogUtils.showHttpErrorDialog(AppStateManager.getInstance().getForegroundActivity(), str6);
                            }
                        }
                        i11 = this.mDbAdapter.cleanupEvents(str2);
                        str = TAG;
                        format = String.format(Locale.CHINA, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(i11)});
                    } catch (ResponseErrorException e13) {
                        z11 = isDeleteEventsByCode(e13.getHttpCode());
                        String str7 = "ResponseErrorException: " + e13.getMessage();
                        boolean isDebugMode4 = this.mSensorsDataAPI.isDebugMode();
                        if (!TextUtils.isEmpty(str7) && (isDebugMode4 || SALog.isLogEnabled())) {
                            SALog.i(TAG, str7);
                            if (isDebugMode4 && AbstractSensorsDataAPI.SHOW_DEBUG_INFO_VIEW) {
                                SensorsDataDialogUtils.showHttpErrorDialog(AppStateManager.getInstance().getForegroundActivity(), str7);
                            }
                        }
                        if (z11 || isDebugMode4) {
                            i11 = this.mDbAdapter.cleanupEvents(str2);
                            str = TAG;
                            format = String.format(Locale.CHINA, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(i11)});
                        }
                        i11 = 0;
                    } catch (Exception e14) {
                        String str8 = "Exception: " + e14.getMessage();
                        boolean isDebugMode5 = this.mSensorsDataAPI.isDebugMode();
                        if (!TextUtils.isEmpty(str8) && (isDebugMode5 || SALog.isLogEnabled())) {
                            SALog.i(TAG, str8);
                            if (isDebugMode5 && AbstractSensorsDataAPI.SHOW_DEBUG_INFO_VIEW) {
                                SensorsDataDialogUtils.showHttpErrorDialog(AppStateManager.getInstance().getForegroundActivity(), str8);
                            }
                        }
                        if (isDebugMode5) {
                            i11 = this.mDbAdapter.cleanupEvents(str2);
                            str = TAG;
                            format = String.format(Locale.CHINA, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(i11)});
                        }
                        i11 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        boolean isDebugMode6 = this.mSensorsDataAPI.isDebugMode();
                        SALog.i(TAG, (String) null);
                        SensorsDataDialogUtils.showHttpErrorDialog(AppStateManager.getInstance().getForegroundActivity(), (String) null);
                        SALog.i(TAG, String.format(Locale.CHINA, "Events flushed. [left = %d]", new Object[]{Integer.valueOf(this.mDbAdapter.cleanupEvents(str2))}));
                        throw th;
                    }
                    SALog.i(str, format);
                }
                if (AbstractSensorsDataAPI.getConfigOptions().isMultiProcessFlush()) {
                    DbAdapter.getInstance().commitSubProcessFlushState(false);
                }
            }
        } catch (Exception e15) {
            SALog.printStackTrace(e15);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v33, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: type inference failed for: r9v0, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:48|49) */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r0 = r9.getErrorStream();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x010e */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendHttpRequest(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21) throws com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException, com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            java.lang.String r1 = "UTF-8"
            r8 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x01bb, all -> 0x01b6 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01bb, all -> 0x01b6 }
            java.net.URLConnection r3 = r2.openConnection()     // Catch:{ IOException -> 0x01bb, all -> 0x01b6 }
            r9 = r3
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ IOException -> 0x01bb, all -> 0x01b6 }
            r3 = 1
            r4 = 0
            java.lang.String r5 = "SA.AnalyticsMessages"
            if (r9 != 0) goto L_0x002e
            java.lang.String r0 = "can not connect %s, it shouldn't happen"
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            r1[r4] = r2     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            com.sensorsdata.analytics.android.sdk.SALog.i(r5, r0, r8)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            r7.closeStream(r8, r8, r8, r9)
            return
        L_0x002e:
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r2 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            if (r2 == 0) goto L_0x0042
            javax.net.ssl.SSLSocketFactory r2 = r2.mSSLSocketFactory     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            if (r2 == 0) goto L_0x0042
            boolean r6 = r9 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            if (r6 == 0) goto L_0x0042
            r6 = r9
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            r6.setSSLSocketFactory(r2)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
        L_0x0042:
            r9.setInstanceFollowRedirects(r4)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = r7.mSensorsDataAPI     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$DebugMode r2 = r2.getDebugMode()     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$DebugMode r6 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_ONLY     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            if (r2 != r6) goto L_0x0056
            java.lang.String r2 = "Dry-Run"
            java.lang.String r6 = "true"
            r9.addRequestProperty(r2, r6)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
        L_0x0056:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = r7.mSensorsDataAPI     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            java.lang.String r2 = r2.getCookie(r4)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            if (r6 != 0) goto L_0x0067
            java.lang.String r6 = "Cookie"
            r9.setRequestProperty(r6, r2)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
        L_0x0067:
            android.net.Uri$Builder r2 = new android.net.Uri$Builder     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            r2.<init>()     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            boolean r6 = android.text.TextUtils.isEmpty(r18)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            if (r6 != 0) goto L_0x007f
            java.lang.String r6 = "crc"
            int r10 = r18.hashCode()     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            r2.appendQueryParameter(r6, r10)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
        L_0x007f:
            java.lang.String r6 = "gzip"
            r10 = r19
            r2.appendQueryParameter(r6, r10)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            java.lang.String r6 = "data_list"
            r11 = r18
            r2.appendQueryParameter(r6, r11)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            android.net.Uri r2 = r2.build()     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            java.lang.String r2 = r2.getEncodedQuery()     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            if (r6 == 0) goto L_0x009f
            r7.closeStream(r8, r8, r8, r9)
            return
        L_0x009f:
            byte[] r6 = r2.getBytes(r1)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            int r6 = r6.length     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            r9.setFixedLengthStreamingMode(r6)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            r9.setDoOutput(r3)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            java.lang.String r6 = "POST"
            r9.setRequestMethod(r6)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            r6 = 30000(0x7530, float:4.2039E-41)
            r9.setConnectTimeout(r6)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            r9.setReadTimeout(r6)     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            java.io.OutputStream r12 = r9.getOutputStream()     // Catch:{ IOException -> 0x01b0, all -> 0x01ac }
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x01a8, all -> 0x01a5 }
            r13.<init>(r12)     // Catch:{ IOException -> 0x01a8, all -> 0x01a5 }
            byte[] r2 = r2.getBytes(r1)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r13.write(r2)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r13.flush()     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            int r2 = r9.getResponseCode()     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r6.<init>()     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r14 = "responseCode: "
            r6.append(r14)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r6.append(r2)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            if (r21 != 0) goto L_0x0108
            boolean r6 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.needRedirects(r2)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            if (r6 == 0) goto L_0x0108
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getLocation(r9, r0)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            if (r6 != 0) goto L_0x0108
            r7.closeStream(r13, r12, r8, r9)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r6 = 1
            r1 = r16
            r2 = r0
            r3 = r18
            r4 = r19
            r5 = r20
            r1.sendHttpRequest(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r7.closeStream(r13, r12, r8, r9)
            return
        L_0x0108:
            java.io.InputStream r0 = r9.getInputStream()     // Catch:{ FileNotFoundException -> 0x010e }
        L_0x010c:
            r6 = r0
            goto L_0x0113
        L_0x010e:
            java.io.InputStream r0 = r9.getErrorStream()     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            goto L_0x010c
        L_0x0113:
            byte[] r0 = slurp(r6)     // Catch:{ IOException -> 0x019d, all -> 0x019b }
            r6.close()     // Catch:{ IOException -> 0x019d, all -> 0x019b }
            java.lang.String r6 = new java.lang.String     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r6.<init>(r0, r1)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            boolean r0 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r1 = 300(0x12c, float:4.2E-43)
            r10 = 200(0xc8, float:2.8E-43)
            if (r0 == 0) goto L_0x017c
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(r20)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            if (r2 < r10) goto L_0x0146
            if (r2 >= r1) goto L_0x0146
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r11.<init>()     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r14 = "valid message: \n"
            r11.append(r14)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r11.append(r0)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r0 = r11.toString()     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            goto L_0x017c
        L_0x0146:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r11.<init>()     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r14 = "invalid message: \n"
            r11.append(r14)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r11.append(r0)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r0 = r11.toString()     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.util.Locale r0 = java.util.Locale.CHINA     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r11 = "ret_code: %d"
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r14[r4] = r15     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r0 = java.lang.String.format(r0, r11, r14)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.util.Locale r0 = java.util.Locale.CHINA     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r11 = "ret_content: %s"
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r14[r4] = r6     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r0 = java.lang.String.format(r0, r11, r14)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
        L_0x017c:
            if (r2 < r10) goto L_0x0184
            if (r2 >= r1) goto L_0x0184
            r7.closeStream(r13, r12, r8, r9)
            return
        L_0x0184:
            com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException r0 = new com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r1 = "flush failure with response '%s', the response code is '%d'"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r5[r4] = r6     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r5[r3] = r4     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            java.lang.String r1 = java.lang.String.format(r1, r5)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            r0.<init>((java.lang.String) r1, (int) r2)     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
            throw r0     // Catch:{ IOException -> 0x01a2, all -> 0x019f }
        L_0x019b:
            r0 = move-exception
            goto L_0x01c7
        L_0x019d:
            r0 = move-exception
            goto L_0x01b4
        L_0x019f:
            r0 = move-exception
            r6 = r8
            goto L_0x01c7
        L_0x01a2:
            r0 = move-exception
            r6 = r8
            goto L_0x01b4
        L_0x01a5:
            r0 = move-exception
            r6 = r8
            goto L_0x01c8
        L_0x01a8:
            r0 = move-exception
            r6 = r8
            r13 = r6
            goto L_0x01b4
        L_0x01ac:
            r0 = move-exception
            r6 = r8
            r12 = r6
            goto L_0x01c8
        L_0x01b0:
            r0 = move-exception
            r6 = r8
            r12 = r6
            r13 = r12
        L_0x01b4:
            r8 = r9
            goto L_0x01bf
        L_0x01b6:
            r0 = move-exception
            r6 = r8
            r9 = r6
            r12 = r9
            goto L_0x01c8
        L_0x01bb:
            r0 = move-exception
            r6 = r8
            r12 = r6
            r13 = r12
        L_0x01bf:
            com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException r1 = new com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException     // Catch:{ all -> 0x01c5 }
            r1.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x01c5 }
            throw r1     // Catch:{ all -> 0x01c5 }
        L_0x01c5:
            r0 = move-exception
            r9 = r8
        L_0x01c7:
            r8 = r13
        L_0x01c8:
            r7.closeStream(r8, r12, r6, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.AnalyticsMessages.sendHttpRequest(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    private static byte[] slurp(InputStream inputStream) throws IOException {
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

    public void deleteAll() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 4;
            this.mWorker.runMessage(obtain);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void enqueueEventMessage(String str, JSONObject jSONObject) {
        try {
            synchronized (this.mDbAdapter) {
                int addJSON = this.mDbAdapter.addJSON(jSONObject);
                if (addJSON < 0) {
                    String str2 = "Failed to enqueue the event: " + jSONObject;
                    if (!this.mSensorsDataAPI.isDebugMode()) {
                        SALog.i(TAG, str2);
                    } else {
                        throw new DebugModeException(str2);
                    }
                }
                Message obtain = Message.obtain();
                obtain.what = 3;
                if (!this.mSensorsDataAPI.isDebugMode()) {
                    if (addJSON != -2) {
                        if (!str.equals("track_signup")) {
                            if (addJSON <= this.mSensorsDataAPI.getFlushBulkSize()) {
                                this.mWorker.runMessageOnce(obtain, (long) this.mSensorsDataAPI.getFlushInterval());
                            }
                        }
                        this.mWorker.runMessage(obtain);
                    }
                }
                this.mWorker.runMessage(obtain);
            }
        } catch (Exception e11) {
            SALog.i(TAG, "enqueueEventMessage error:" + e11);
        }
    }

    public void flush() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.mWorker.runMessage(obtain);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void flushScheduled() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 5;
            this.mWorker.runMessageOnce(obtain, (long) this.mSensorsDataAPI.getFlushInterval());
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }
}
