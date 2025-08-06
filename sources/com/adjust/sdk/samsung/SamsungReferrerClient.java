package com.adjust.sdk.samsung;

import android.content.Context;
import com.adjust.sdk.ILogger;
import com.samsung.android.sdk.sinstallreferrer.api.InstallReferrerClient;
import com.samsung.android.sdk.sinstallreferrer.api.InstallReferrerStateListener;
import com.samsung.android.sdk.sinstallreferrer.api.ReferrerDetails;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SamsungReferrerClient {
    public static SamsungInstallReferrerResult getReferrer(Context context, final ILogger iLogger, long j11) {
        try {
            final InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
            final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1);
            build.startConnection(new InstallReferrerStateListener() {
                public void onInstallReferrerServiceDisconnected() {
                    build.endConnection();
                }

                /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
                    r4 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
                    r4 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
                    r2.endConnection();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
                    throw r4;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:24:0x007e, code lost:
                    r4 = "SamsungReferrer onInstallReferrerSetupFinished: " + r4.getMessage();
                    r0.offer(new com.adjust.sdk.samsung.SamsungInstallReferrerResult(r4));
                    r3.error(r4, new java.lang.Object[0]);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
                    return;
                 */
                /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x000d, B:18:0x004f] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onInstallReferrerSetupFinished(int r4) {
                    /*
                        r3 = this;
                        r0 = 0
                        if (r4 == 0) goto L_0x0036
                        r1 = 1
                        if (r4 == r1) goto L_0x0020
                        r1 = 2
                        if (r4 == r1) goto L_0x000b
                        goto L_0x00a4
                    L_0x000b:
                        java.lang.String r4 = "SamsungReferrer onInstallReferrerSetupFinished: FEATURE_NOT_SUPPORTED"
                        java.util.concurrent.BlockingQueue r1 = r0     // Catch:{ Exception -> 0x0034 }
                        com.adjust.sdk.samsung.SamsungInstallReferrerResult r2 = new com.adjust.sdk.samsung.SamsungInstallReferrerResult     // Catch:{ Exception -> 0x0034 }
                        r2.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x0034 }
                        r1.offer(r2)     // Catch:{ Exception -> 0x0034 }
                        com.adjust.sdk.ILogger r1 = r3     // Catch:{ Exception -> 0x0034 }
                        java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0034 }
                        r1.info(r4, r2)     // Catch:{ Exception -> 0x0034 }
                        goto L_0x00a4
                    L_0x0020:
                        java.lang.String r4 = "SamsungReferrer onInstallReferrerSetupFinished: SERVICE_UNAVAILABLE"
                        java.util.concurrent.BlockingQueue r1 = r0     // Catch:{ Exception -> 0x0034 }
                        com.adjust.sdk.samsung.SamsungInstallReferrerResult r2 = new com.adjust.sdk.samsung.SamsungInstallReferrerResult     // Catch:{ Exception -> 0x0034 }
                        r2.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x0034 }
                        r1.offer(r2)     // Catch:{ Exception -> 0x0034 }
                        com.adjust.sdk.ILogger r1 = r3     // Catch:{ Exception -> 0x0034 }
                        java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0034 }
                        r1.info(r4, r2)     // Catch:{ Exception -> 0x0034 }
                        goto L_0x00a4
                    L_0x0034:
                        r4 = move-exception
                        goto L_0x007e
                    L_0x0036:
                        com.samsung.android.sdk.sinstallreferrer.api.InstallReferrerClient r4 = r2     // Catch:{ Exception -> 0x004e }
                        com.adjust.sdk.samsung.SamsungInstallReferrerDetails r4 = com.adjust.sdk.samsung.SamsungReferrerClient.getSamsungInstallReferrerDetails(r4)     // Catch:{ Exception -> 0x004e }
                        java.util.concurrent.BlockingQueue r1 = r0     // Catch:{ Exception -> 0x004e }
                        com.adjust.sdk.samsung.SamsungInstallReferrerResult r2 = new com.adjust.sdk.samsung.SamsungInstallReferrerResult     // Catch:{ Exception -> 0x004e }
                        r2.<init>((com.adjust.sdk.samsung.SamsungInstallReferrerDetails) r4)     // Catch:{ Exception -> 0x004e }
                        r1.offer(r2)     // Catch:{ Exception -> 0x004e }
                        com.samsung.android.sdk.sinstallreferrer.api.InstallReferrerClient r4 = r2     // Catch:{ Exception -> 0x0034 }
                    L_0x0048:
                        r4.endConnection()     // Catch:{ Exception -> 0x0034 }
                        goto L_0x00a4
                    L_0x004c:
                        r4 = move-exception
                        goto L_0x0078
                    L_0x004e:
                        r4 = move-exception
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
                        r1.<init>()     // Catch:{ all -> 0x004c }
                        java.lang.String r2 = "SamsungReferrer getInstallReferrer: "
                        r1.append(r2)     // Catch:{ all -> 0x004c }
                        java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x004c }
                        r1.append(r4)     // Catch:{ all -> 0x004c }
                        java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x004c }
                        java.util.concurrent.BlockingQueue r1 = r0     // Catch:{ all -> 0x004c }
                        com.adjust.sdk.samsung.SamsungInstallReferrerResult r2 = new com.adjust.sdk.samsung.SamsungInstallReferrerResult     // Catch:{ all -> 0x004c }
                        r2.<init>((java.lang.String) r4)     // Catch:{ all -> 0x004c }
                        r1.offer(r2)     // Catch:{ all -> 0x004c }
                        com.adjust.sdk.ILogger r1 = r3     // Catch:{ all -> 0x004c }
                        java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x004c }
                        r1.error(r4, r2)     // Catch:{ all -> 0x004c }
                        com.samsung.android.sdk.sinstallreferrer.api.InstallReferrerClient r4 = r2     // Catch:{ Exception -> 0x0034 }
                        goto L_0x0048
                    L_0x0078:
                        com.samsung.android.sdk.sinstallreferrer.api.InstallReferrerClient r1 = r2     // Catch:{ Exception -> 0x0034 }
                        r1.endConnection()     // Catch:{ Exception -> 0x0034 }
                        throw r4     // Catch:{ Exception -> 0x0034 }
                    L_0x007e:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "SamsungReferrer onInstallReferrerSetupFinished: "
                        r1.append(r2)
                        java.lang.String r4 = r4.getMessage()
                        r1.append(r4)
                        java.lang.String r4 = r1.toString()
                        java.util.concurrent.BlockingQueue r1 = r0
                        com.adjust.sdk.samsung.SamsungInstallReferrerResult r2 = new com.adjust.sdk.samsung.SamsungInstallReferrerResult
                        r2.<init>((java.lang.String) r4)
                        r1.offer(r2)
                        com.adjust.sdk.ILogger r1 = r3
                        java.lang.Object[] r0 = new java.lang.Object[r0]
                        r1.error(r4, r0)
                    L_0x00a4:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.samsung.SamsungReferrerClient.AnonymousClass1.onInstallReferrerSetupFinished(int):void");
                }
            });
            return (SamsungInstallReferrerResult) linkedBlockingQueue.poll(j11, TimeUnit.MILLISECONDS);
        } catch (Exception e11) {
            String str = "SamsungReferrer read error: " + e11.getMessage();
            iLogger.info(str, new Object[0]);
            return new SamsungInstallReferrerResult(str);
        }
    }

    /* access modifiers changed from: private */
    public static SamsungInstallReferrerDetails getSamsungInstallReferrerDetails(InstallReferrerClient installReferrerClient) {
        ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
        return new SamsungInstallReferrerDetails(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds());
    }
}
