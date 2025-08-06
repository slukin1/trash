package com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils;

import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDLProxyLogListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class TPCGIRequester {
    private static final String FILE_NAME = "TPCGIRequester";
    private static final int MAX_RETRY_TIMES = 3;
    private static final int MSG_CONFIG_URL = 2011;
    private static final int MSG_REPORT_URL = 2010;
    private static final int MSG_WUJI_CONFIG_URL = 2013;
    private static final int RETRY_INTERVAL = 3000;
    private static final int TIMEOUT = 3000;
    private static volatile ExecutorService mCustomExecutor;
    private static TPCGIRequester mRequester;
    /* access modifiers changed from: private */
    public LinkedBlockingQueue<TPRequestItem> mRequestQueue = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */
    public LinkedBlockingQueue<TPRequestItem> mRetryQueue = new LinkedBlockingQueue<>();
    private TimerTask mTimerTask = new TimerTask() {
        public void run() {
            while (TPCGIRequester.this.mRetryQueue.peek() != null && System.currentTimeMillis() - ((TPRequestItem) TPCGIRequester.this.mRetryQueue.peek()).getRequestFailedTime() > 3000) {
                TPCGIRequester tPCGIRequester = TPCGIRequester.this;
                tPCGIRequester.addNotifyReqQueue((TPRequestItem) tPCGIRequester.mRetryQueue.poll());
            }
        }
    };

    private TPCGIRequester() {
        new Timer(true).scheduleAtFixedRate(this.mTimerTask, 0, 1000);
        process();
    }

    /* access modifiers changed from: private */
    public void addNotifyReqQueue(TPRequestItem tPRequestItem) {
        try {
            this.mRequestQueue.put(tPRequestItem);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "RequestQueue add failed:" + th2.toString());
        }
    }

    /* access modifiers changed from: private */
    public void addRetryRequestItem(TPRequestItem tPRequestItem) {
        try {
            if (tPRequestItem.getRequestTimes() <= 3) {
                this.mRetryQueue.put(tPRequestItem);
            }
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "retry queue add failed" + th2.toString());
        }
    }

    public static TPCGIRequester getInstance() {
        if (mRequester == null) {
            synchronized (TPCGIRequester.class) {
                if (mRequester == null) {
                    mRequester = new TPCGIRequester();
                }
            }
        }
        return mRequester;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e1 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleRequestItem(com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPRequestItem r13) {
        /*
            r12 = this;
            java.lang.String r0 = "tpdlnative"
            java.lang.String r1 = "TPCGIRequester"
            java.lang.String r2 = r13.getUrl()
            r3 = 0
            r4 = 0
            java.net.URL r5 = new java.net.URL     // Catch:{ all -> 0x00c8 }
            r5.<init>(r2)     // Catch:{ all -> 0x00c8 }
            java.net.URLConnection r2 = r5.openConnection()     // Catch:{ all -> 0x00c8 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ all -> 0x00c8 }
            java.lang.String r4 = "GET"
            r2.setRequestMethod(r4)     // Catch:{ all -> 0x00c5 }
            r4 = 3000(0xbb8, float:4.204E-42)
            r2.setConnectTimeout(r4)     // Catch:{ all -> 0x00c5 }
            r2.connect()     // Catch:{ all -> 0x00c5 }
            int r4 = r2.getResponseCode()     // Catch:{ all -> 0x00c5 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 == r5) goto L_0x002e
            r5 = 206(0xce, float:2.89E-43)
            if (r4 != r5) goto L_0x00bc
        L_0x002e:
            r4 = 1
            int r5 = r13.getRequestType()     // Catch:{ all -> 0x00c0 }
            r6 = 2011(0x7db, float:2.818E-42)
            r7 = 2013(0x7dd, float:2.821E-42)
            if (r5 == r6) goto L_0x003f
            int r5 = r13.getRequestType()     // Catch:{ all -> 0x00c0 }
            if (r5 != r7) goto L_0x00bb
        L_0x003f:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ all -> 0x00c0 }
            r5.<init>()     // Catch:{ all -> 0x00c0 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x00c0 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ all -> 0x00c0 }
            java.io.InputStream r9 = r2.getInputStream()     // Catch:{ all -> 0x00c0 }
            java.lang.String r10 = "UTF-8"
            r8.<init>(r9, r10)     // Catch:{ all -> 0x00c0 }
            r6.<init>(r8)     // Catch:{ all -> 0x00c0 }
        L_0x0054:
            java.lang.String r8 = r6.readLine()     // Catch:{ all -> 0x00c0 }
            if (r8 == 0) goto L_0x0063
            r5.append(r8)     // Catch:{ all -> 0x00c0 }
            java.lang.String r8 = "\n"
            r5.append(r8)     // Catch:{ all -> 0x00c0 }
            goto L_0x0054
        L_0x0063:
            r6.close()     // Catch:{ all -> 0x00c0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "QZOutputJson="
            java.lang.String r8 = ""
            java.lang.String r5 = r5.replace(r6, r8)     // Catch:{ all -> 0x00c0 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x00c0 }
            r6.<init>(r5)     // Catch:{ all -> 0x00c0 }
            java.lang.String r8 = "start update config. responce data: "
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00c0 }
            java.lang.String r5 = r8.concat(r5)     // Catch:{ all -> 0x00c0 }
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.i(r1, r3, r0, r5)     // Catch:{ all -> 0x00c0 }
            int r13 = r13.getRequestType()     // Catch:{ all -> 0x00c0 }
            java.lang.String r5 = "proxy_config"
            if (r13 != r7) goto L_0x00a2
            java.lang.String r13 = "code"
            int r13 = r6.getInt(r13)     // Catch:{ all -> 0x00c0 }
            if (r13 != 0) goto L_0x00bb
            java.lang.String r13 = "data"
            java.lang.String r13 = r6.getString(r13)     // Catch:{ all -> 0x00c0 }
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.jni.TPDownloadProxyNative r6 = com.tencent.thumbplayer.tcmedia.core.downloadproxy.jni.TPDownloadProxyNative.getInstance()     // Catch:{ all -> 0x00c0 }
            r6.setUserData(r5, r13)     // Catch:{ all -> 0x00c0 }
            goto L_0x00bb
        L_0x00a2:
            java.lang.String r13 = "ret"
            int r13 = r6.getInt(r13)     // Catch:{ all -> 0x00c0 }
            if (r13 != 0) goto L_0x00bb
            java.lang.String r13 = "config"
            org.json.JSONObject r13 = r6.getJSONObject(r13)     // Catch:{ all -> 0x00c0 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00c0 }
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.jni.TPDownloadProxyNative r6 = com.tencent.thumbplayer.tcmedia.core.downloadproxy.jni.TPDownloadProxyNative.getInstance()     // Catch:{ all -> 0x00c0 }
            r6.setUserData(r5, r13)     // Catch:{ all -> 0x00c0 }
        L_0x00bb:
            r3 = r4
        L_0x00bc:
            r2.disconnect()
            goto L_0x00e5
        L_0x00c0:
            r13 = move-exception
            r11 = r4
            r4 = r2
            r2 = r11
            goto L_0x00ca
        L_0x00c5:
            r13 = move-exception
            r4 = r2
            goto L_0x00c9
        L_0x00c8:
            r13 = move-exception
        L_0x00c9:
            r2 = r3
        L_0x00ca:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e6 }
            java.lang.String r6 = "Send Request Routine error:"
            r5.<init>(r6)     // Catch:{ all -> 0x00e6 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00e6 }
            r5.append(r13)     // Catch:{ all -> 0x00e6 }
            java.lang.String r13 = r5.toString()     // Catch:{ all -> 0x00e6 }
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r1, r3, r0, r13)     // Catch:{ all -> 0x00e6 }
            if (r4 == 0) goto L_0x00e4
            r4.disconnect()
        L_0x00e4:
            r3 = r2
        L_0x00e5:
            return r3
        L_0x00e6:
            r13 = move-exception
            if (r4 == 0) goto L_0x00ec
            r4.disconnect()
        L_0x00ec:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPCGIRequester.handleRequestItem(com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPRequestItem):boolean");
    }

    private static ExecutorService obtainThreadExcutor() {
        if (mCustomExecutor == null) {
            synchronized (TPCGIRequester.class) {
                if (mCustomExecutor == null) {
                    mCustomExecutor = Executors.newSingleThreadExecutor();
                }
            }
        }
        return mCustomExecutor;
    }

    private void process() {
        obtainThreadExcutor().execute(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        TPRequestItem tPRequestItem = (TPRequestItem) TPCGIRequester.this.mRequestQueue.take();
                        if (!TPCGIRequester.this.handleRequestItem(tPRequestItem)) {
                            tPRequestItem.updateFailedTime();
                            TPCGIRequester.this.addRetryRequestItem(tPRequestItem);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPCGIRequester.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "request queue take failed: " + th2.toString());
                    }
                }
            }
        });
    }

    public void addRequestItem(String str, int i11) {
        if (str.isEmpty()) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "request url null");
        } else {
            addNotifyReqQueue(new TPRequestItem(str, i11));
        }
    }
}
