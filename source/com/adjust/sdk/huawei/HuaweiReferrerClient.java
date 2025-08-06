package com.adjust.sdk.huawei;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public class HuaweiReferrerClient {
    private static final int COLUMN_INDEX_CLICK_TIME = 1;
    private static final int COLUMN_INDEX_INSTALL_TIME = 2;
    private static final int COLUMN_INDEX_REFERRER = 0;
    private static final int COLUMN_INDEX_TRACK_ID = 4;
    private static final String REFERRER_PROVIDER_AUTHORITY = "com.huawei.appmarket.commondata";
    private static final String REFERRER_PROVIDER_URI = "content://com.huawei.appmarket.commondata/item/5";
    private static final AtomicBoolean shouldTryToReadHuaweiAdsReferrer = new AtomicBoolean(true);
    private static final AtomicBoolean shouldTryToReadHuaweiAppGalleryReferrer = new AtomicBoolean(true);

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b3, code lost:
        if (r2 != null) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b5, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00db, code lost:
        if (r2 == null) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e3, code lost:
        return new com.adjust.sdk.huawei.HuaweiInstallReferrerResult(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.adjust.sdk.huawei.HuaweiInstallReferrerResult getHuaweiAdsInstallReferrer(android.content.Context r19, com.adjust.sdk.ILogger r20) {
        /*
            r1 = r20
            java.util.concurrent.atomic.AtomicBoolean r0 = shouldTryToReadHuaweiAdsReferrer
            boolean r2 = r0.get()
            r3 = 0
            if (r2 != 0) goto L_0x0018
            java.lang.String r0 = "Should not try to read HuaweiAdsInstallReferrer"
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r1.info(r0, r2)
            com.adjust.sdk.huawei.HuaweiInstallReferrerResult r1 = new com.adjust.sdk.huawei.HuaweiInstallReferrerResult
            r1.<init>((java.lang.String) r0)
            return r1
        L_0x0018:
            java.lang.String r2 = "com.huawei.appmarket.commondata"
            r4 = r19
            boolean r2 = resolveContentProvider(r4, r2)
            if (r2 != 0) goto L_0x002a
            com.adjust.sdk.huawei.HuaweiInstallReferrerResult r0 = new com.adjust.sdk.huawei.HuaweiInstallReferrerResult
            java.lang.String r1 = "HuaweiAdsInstallReferrer fail to resolve content provider"
            r0.<init>((java.lang.String) r1)
            return r0
        L_0x002a:
            r2 = 0
            java.lang.String r5 = "content://com.huawei.appmarket.commondata/item/5"
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00bb }
            android.content.ContentResolver r6 = r19.getContentResolver()     // Catch:{ Exception -> 0x00bb }
            r12 = 1
            java.lang.String[] r10 = new java.lang.String[r12]     // Catch:{ Exception -> 0x00bb }
            java.lang.String r7 = r19.getPackageName()     // Catch:{ Exception -> 0x00bb }
            r10[r3] = r7     // Catch:{ Exception -> 0x00bb }
            r8 = 0
            r9 = 0
            r11 = 0
            r7 = r5
            android.database.Cursor r2 = r6.query(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00bb }
            r6 = 2
            if (r2 == 0) goto L_0x0097
            boolean r7 = r2.moveToFirst()     // Catch:{ Exception -> 0x00bb }
            if (r7 == 0) goto L_0x0097
            java.lang.String r14 = r2.getString(r3)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r0 = "HuaweiAdsInstallReferrer index_referrer[%s]"
            java.lang.Object[] r4 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x00bb }
            r4[r3] = r14     // Catch:{ Exception -> 0x00bb }
            r1.debug(r0, r4)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r0 = r2.getString(r12)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r4 = r2.getString(r6)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r5 = "HuaweiAdsInstallReferrer clickTime[%s] installTime[%s]"
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00bb }
            r6[r3] = r0     // Catch:{ Exception -> 0x00bb }
            r6[r12] = r4     // Catch:{ Exception -> 0x00bb }
            r1.debug(r5, r6)     // Catch:{ Exception -> 0x00bb }
            long r15 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00bb }
            long r17 = java.lang.Long.parseLong(r4)     // Catch:{ Exception -> 0x00bb }
            boolean r0 = isValidHuaweiAdsInstallReferrer(r14)     // Catch:{ Exception -> 0x00bb }
            if (r0 == 0) goto L_0x008c
            com.adjust.sdk.huawei.HuaweiInstallReferrerDetails r0 = new com.adjust.sdk.huawei.HuaweiInstallReferrerDetails     // Catch:{ Exception -> 0x00bb }
            r13 = r0
            r13.<init>(r14, r15, r17)     // Catch:{ Exception -> 0x00bb }
            com.adjust.sdk.huawei.HuaweiInstallReferrerResult r4 = new com.adjust.sdk.huawei.HuaweiInstallReferrerResult     // Catch:{ Exception -> 0x00bb }
            r4.<init>((com.adjust.sdk.huawei.HuaweiInstallReferrerDetails) r0)     // Catch:{ Exception -> 0x00bb }
            r2.close()
            return r4
        L_0x008c:
            com.adjust.sdk.huawei.HuaweiInstallReferrerResult r0 = new com.adjust.sdk.huawei.HuaweiInstallReferrerResult     // Catch:{ Exception -> 0x00bb }
            java.lang.String r4 = "Invalid HuaweiAdsInstallReferrer"
            r0.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x00bb }
            r2.close()
            return r0
        L_0x0097:
            java.lang.String r7 = "HuaweiAdsInstallReferrer fail to read referrer for package [%s] and content uri [%s]"
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00bb }
            java.lang.String r4 = r19.getPackageName()     // Catch:{ Exception -> 0x00bb }
            r6[r3] = r4     // Catch:{ Exception -> 0x00bb }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x00bb }
            r6[r12] = r4     // Catch:{ Exception -> 0x00bb }
            java.lang.String r4 = com.adjust.sdk.Util.formatString(r7, r6)     // Catch:{ Exception -> 0x00bb }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00bb }
            r1.debug(r4, r5)     // Catch:{ Exception -> 0x00bb }
            r0.set(r3)     // Catch:{ Exception -> 0x00bb }
            if (r2 == 0) goto L_0x00de
        L_0x00b5:
            r2.close()
            goto L_0x00de
        L_0x00b9:
            r0 = move-exception
            goto L_0x00e4
        L_0x00bb:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r4.<init>()     // Catch:{ all -> 0x00b9 }
            java.lang.String r5 = "HuaweiAdsInstallReferrer error ["
            r4.append(r5)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00b9 }
            r4.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = "]"
            r4.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00b9 }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x00b9 }
            r1.debug(r4, r0)     // Catch:{ all -> 0x00b9 }
            if (r2 == 0) goto L_0x00de
            goto L_0x00b5
        L_0x00de:
            com.adjust.sdk.huawei.HuaweiInstallReferrerResult r0 = new com.adjust.sdk.huawei.HuaweiInstallReferrerResult
            r0.<init>((java.lang.String) r4)
            return r0
        L_0x00e4:
            if (r2 == 0) goto L_0x00e9
            r2.close()
        L_0x00e9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.huawei.HuaweiReferrerClient.getHuaweiAdsInstallReferrer(android.content.Context, com.adjust.sdk.ILogger):com.adjust.sdk.huawei.HuaweiInstallReferrerResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: android.database.Cursor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.adjust.sdk.huawei.HuaweiInstallReferrerResult getHuaweiAppGalleryInstallReferrer(android.content.Context r19, com.adjust.sdk.ILogger r20) {
        /*
            r1 = r20
            java.util.concurrent.atomic.AtomicBoolean r0 = shouldTryToReadHuaweiAppGalleryReferrer
            boolean r2 = r0.get()
            r3 = 0
            if (r2 != 0) goto L_0x0018
            java.lang.String r0 = "Should not try to read HuaweiAppGalleryInstallReferrer"
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r1.debug(r0, r2)
            com.adjust.sdk.huawei.HuaweiInstallReferrerResult r1 = new com.adjust.sdk.huawei.HuaweiInstallReferrerResult
            r1.<init>((java.lang.String) r0)
            return r1
        L_0x0018:
            java.lang.String r2 = "com.huawei.appmarket.commondata"
            r4 = r19
            boolean r2 = resolveContentProvider(r4, r2)
            if (r2 != 0) goto L_0x002a
            com.adjust.sdk.huawei.HuaweiInstallReferrerResult r0 = new com.adjust.sdk.huawei.HuaweiInstallReferrerResult
            java.lang.String r1 = "HuaweiAppGalleryInstallReferrer fail to resolve content provider"
            r0.<init>((java.lang.String) r1)
            return r0
        L_0x002a:
            r2 = 0
            java.lang.String r5 = "content://com.huawei.appmarket.commondata/item/5"
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00bf }
            android.content.ContentResolver r6 = r19.getContentResolver()     // Catch:{ Exception -> 0x00bf }
            r12 = 1
            java.lang.String[] r10 = new java.lang.String[r12]     // Catch:{ Exception -> 0x00bf }
            java.lang.String r7 = r19.getPackageName()     // Catch:{ Exception -> 0x00bf }
            r10[r3] = r7     // Catch:{ Exception -> 0x00bf }
            r8 = 0
            r9 = 0
            r11 = 0
            r7 = r5
            android.database.Cursor r6 = r6.query(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00bf }
            r7 = 2
            if (r6 == 0) goto L_0x0095
            boolean r8 = r6.moveToFirst()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            if (r8 == 0) goto L_0x0095
            r4 = 4
            java.lang.String r14 = r6.getString(r4)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r4 = "HuaweiAppGalleryInstallReferrer index_track_id[%s]"
            java.lang.Object[] r5 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r5[r3] = r14     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r1.debug(r4, r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r4 = r6.getString(r12)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r5 = r6.getString(r7)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r8 = "HuaweiAppGalleryInstallReferrer clickTime[%s] installTime[%s]"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r7[r3] = r4     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r7[r12] = r5     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r1.debug(r8, r7)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            long r15 = java.lang.Long.parseLong(r4)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            long r17 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            boolean r4 = isValidHuaweiAppGalleryInstallReferrer(r14)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            if (r4 == 0) goto L_0x008d
            com.adjust.sdk.huawei.HuaweiInstallReferrerDetails r0 = new com.adjust.sdk.huawei.HuaweiInstallReferrerDetails     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r13 = r0
            r13.<init>(r14, r15, r17)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            com.adjust.sdk.huawei.HuaweiInstallReferrerResult r2 = new com.adjust.sdk.huawei.HuaweiInstallReferrerResult     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r2.<init>((com.adjust.sdk.huawei.HuaweiInstallReferrerDetails) r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r6.close()
            return r2
        L_0x008d:
            com.adjust.sdk.huawei.HuaweiInstallReferrerResult r4 = new com.adjust.sdk.huawei.HuaweiInstallReferrerResult     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r5 = "Invalid HuaweiAppGalleryInstallReferrer"
            r4.<init>((java.lang.String) r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            goto L_0x00ae
        L_0x0095:
            java.lang.String r2 = "HuaweiAppGalleryInstallReferrer fail to read referrer for package [%s] and content uri [%s]"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r4 = r19.getPackageName()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r7[r3] = r4     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r7[r12] = r4     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r2 = com.adjust.sdk.Util.formatString(r2, r7)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r1.debug(r2, r4)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        L_0x00ae:
            r0.set(r3)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            if (r6 == 0) goto L_0x00e5
            r6.close()
            goto L_0x00e5
        L_0x00b7:
            r0 = move-exception
            r2 = r6
            goto L_0x00eb
        L_0x00ba:
            r0 = move-exception
            r2 = r6
            goto L_0x00c0
        L_0x00bd:
            r0 = move-exception
            goto L_0x00eb
        L_0x00bf:
            r0 = move-exception
        L_0x00c0:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r4.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r5 = "HuaweiAppGalleryInstallReferrer error ["
            r4.append(r5)     // Catch:{ all -> 0x00bd }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00bd }
            r4.append(r0)     // Catch:{ all -> 0x00bd }
            java.lang.String r0 = "]"
            r4.append(r0)     // Catch:{ all -> 0x00bd }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00bd }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x00bd }
            r1.debug(r0, r3)     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x00e4
            r2.close()
        L_0x00e4:
            r2 = r0
        L_0x00e5:
            com.adjust.sdk.huawei.HuaweiInstallReferrerResult r0 = new com.adjust.sdk.huawei.HuaweiInstallReferrerResult
            r0.<init>((java.lang.String) r2)
            return r0
        L_0x00eb:
            if (r2 == 0) goto L_0x00f0
            r2.close()
        L_0x00f0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.huawei.HuaweiReferrerClient.getHuaweiAppGalleryInstallReferrer(android.content.Context, com.adjust.sdk.ILogger):com.adjust.sdk.huawei.HuaweiInstallReferrerResult");
    }

    private static boolean isValidHuaweiAdsInstallReferrer(String str) {
        return str != null && !str.isEmpty();
    }

    private static boolean isValidHuaweiAppGalleryInstallReferrer(String str) {
        return str != null && !str.isEmpty();
    }

    private static boolean resolveContentProvider(Context context, String str) {
        try {
            if (context.getPackageManager().resolveContentProvider(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
