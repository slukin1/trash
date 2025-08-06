package com.zopim.android.sdk.api;

import android.util.Patterns;
import com.zendesk.logger.Logger;
import java.io.File;
import java.net.URL;

final class DownloadHttpRequest implements HttpRequest {
    private static final String LOG_TAG = "DownloadHttpRequest";
    private RegisteredCallback<File> mRequestCallback;

    /* renamed from: com.zopim.android.sdk.api.DownloadHttpRequest$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$api$HttpRequest$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.zopim.android.sdk.api.HttpRequest$Status[] r0 = com.zopim.android.sdk.api.HttpRequest.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$api$HttpRequest$Status = r0
                com.zopim.android.sdk.api.HttpRequest$Status r1 = com.zopim.android.sdk.api.HttpRequest.Status.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$api$HttpRequest$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.api.HttpRequest$Status r1 = com.zopim.android.sdk.api.HttpRequest.Status.REDIRECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$api$HttpRequest$Status     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.api.HttpRequest$Status r1 = com.zopim.android.sdk.api.HttpRequest.Status.CLIENT_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$api$HttpRequest$Status     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.zopim.android.sdk.api.HttpRequest$Status r1 = com.zopim.android.sdk.api.HttpRequest.Status.SERVER_ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.api.DownloadHttpRequest.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r8v4, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01a2 A[Catch:{ all -> 0x01d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01b1 A[SYNTHETIC, Splitter:B:65:0x01b1] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01c2 A[SYNTHETIC, Splitter:B:70:0x01c2] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01e1 A[SYNTHETIC, Splitter:B:79:0x01e1] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01f2 A[SYNTHETIC, Splitter:B:84:0x01f2] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void downloadFileInternal(java.net.URL r17, java.io.File r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            java.lang.String r2 = "Failed to close file output stream"
            java.lang.String r3 = "Failed to close output stream"
            java.lang.String r4 = "Closing file output stream"
            java.lang.String r5 = "Closing input stream"
            java.lang.String r6 = "Disconnecting url connection"
            java.lang.String r7 = "DownloadHttpRequest"
            r8 = 0
            r9 = 0
            java.net.URLConnection r10 = r17.openConnection()     // Catch:{ Exception -> 0x0164, all -> 0x015e }
            javax.net.ssl.HttpsURLConnection r10 = (javax.net.ssl.HttpsURLConnection) r10     // Catch:{ Exception -> 0x0164, all -> 0x015e }
            java.lang.String r11 = "User-Agent"
            java.lang.String r12 = "http.agent"
            java.lang.String r12 = java.lang.System.getProperty(r12)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r10.setRequestProperty(r11, r12)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.String r11 = "Accept-Charset"
            java.lang.String r12 = "UTF-8"
            r10.setRequestProperty(r11, r12)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r10.setInstanceFollowRedirects(r9)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            long r11 = com.zopim.android.sdk.api.HttpRequest.REQUEST_TIMEOUT     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            int r11 = (int) r11     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r10.setReadTimeout(r11)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            int r11 = r10.getResponseCode()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.String r12 = "response connection.getResponseMessage()"
            java.lang.Object[] r13 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zendesk.logger.Logger.j(r7, r12, r13)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zopim.android.sdk.api.HttpRequest$Status r12 = com.zopim.android.sdk.api.HttpRequest.Status.getStatus(r11)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            int[] r13 = com.zopim.android.sdk.api.DownloadHttpRequest.AnonymousClass1.$SwitchMap$com$zopim$android$sdk$api$HttpRequest$Status     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            int r12 = r12.ordinal()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r12 = r13[r12]     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r13 = 1
            if (r12 == r13) goto L_0x0084
            r0 = 2
            if (r12 == r0) goto L_0x0057
            r0 = 3
            if (r12 == r0) goto L_0x0057
            r0 = 4
            if (r12 == r0) goto L_0x0057
            goto L_0x0081
        L_0x0057:
            java.lang.String r0 = r10.getResponseMessage()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r12 = new com.zopim.android.sdk.api.ErrorResponseImpl$Builder     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r12.<init>()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponse$Kind r13 = com.zopim.android.sdk.api.ErrorResponse.Kind.HTTP     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r12 = r12.kind(r13)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r11 = r12.status(r11)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.String r12 = r17.toExternalForm()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r11 = r11.url(r12)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r0 = r11.responseBody(r0)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl r0 = r0.build()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zopim.android.sdk.api.RegisteredCallback<java.io.File> r11 = r1.mRequestCallback     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            if (r11 == 0) goto L_0x0081
            r11.onError(r0)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
        L_0x0081:
            r12 = r8
            goto L_0x011c
        L_0x0084:
            java.lang.String r11 = "Content-Disposition"
            java.lang.String r11 = r10.getHeaderField(r11)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.String r12 = r10.getContentType()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            int r13 = r10.getContentLength()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r14.<init>()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.String r15 = "Content-Type = "
            r14.append(r15)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r14.append(r12)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.String r12 = r14.toString()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.Object[] r14 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zendesk.logger.Logger.j(r7, r12, r14)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r12.<init>()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.String r14 = "Content-Disposition = "
            r12.append(r14)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r12.append(r11)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.String r11 = r12.toString()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.Object[] r12 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zendesk.logger.Logger.j(r7, r11, r12)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r11.<init>()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.String r12 = "Content-Length = "
            r11.append(r12)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            r11.append(r13)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.lang.Object[] r12 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            com.zendesk.logger.Logger.j(r7, r11, r12)     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.io.InputStream r11 = r10.getInputStream()     // Catch:{ Exception -> 0x015b, all -> 0x0154 }
            java.io.BufferedOutputStream r12 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            r13.<init>(r0)     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            r12.<init>(r13)     // Catch:{ Exception -> 0x0150, all -> 0x014d }
            r8 = 4096(0x1000, float:5.74E-42)
            byte[] r8 = new byte[r8]     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
        L_0x00e6:
            int r13 = r11.read(r8)     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            r14 = -1
            if (r13 == r14) goto L_0x00f1
            r12.write(r8, r9, r13)     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            goto L_0x00e6
        L_0x00f1:
            r12.flush()     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            r12.close()     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            r11.close()     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            r8.<init>()     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            java.lang.String r13 = "File downloaded "
            r8.append(r13)     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            java.lang.String r13 = r18.getPath()     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            r8.append(r13)     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            java.lang.Object[] r13 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            com.zendesk.logger.Logger.j(r7, r8, r13)     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            com.zopim.android.sdk.api.RegisteredCallback<java.io.File> r8 = r1.mRequestCallback     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
            if (r8 == 0) goto L_0x011b
            r8.onSuccess(r0)     // Catch:{ Exception -> 0x014b, all -> 0x0149 }
        L_0x011b:
            r8 = r11
        L_0x011c:
            java.lang.Object[] r0 = new java.lang.Object[r9]
            com.zendesk.logger.Logger.j(r7, r6, r0)
            r10.disconnect()
            if (r8 == 0) goto L_0x0135
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x012f }
            com.zendesk.logger.Logger.j(r7, r5, r0)     // Catch:{ Exception -> 0x012f }
            r8.close()     // Catch:{ Exception -> 0x012f }
            goto L_0x0135
        L_0x012f:
            r0 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r9]
            com.zendesk.logger.Logger.k(r7, r3, r0, r5)
        L_0x0135:
            if (r12 == 0) goto L_0x01d1
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0141 }
            com.zendesk.logger.Logger.j(r7, r4, r0)     // Catch:{ Exception -> 0x0141 }
            r12.close()     // Catch:{ Exception -> 0x0141 }
            goto L_0x01d1
        L_0x0141:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r9]
            com.zendesk.logger.Logger.k(r7, r2, r0, r3)
            goto L_0x01d1
        L_0x0149:
            r0 = move-exception
            goto L_0x0157
        L_0x014b:
            r0 = move-exception
            goto L_0x0152
        L_0x014d:
            r0 = move-exception
            r12 = r8
            goto L_0x0157
        L_0x0150:
            r0 = move-exception
            r12 = r8
        L_0x0152:
            r8 = r11
            goto L_0x0167
        L_0x0154:
            r0 = move-exception
            r11 = r8
            r12 = r11
        L_0x0157:
            r8 = r10
            r10 = r0
            goto L_0x01d5
        L_0x015b:
            r0 = move-exception
            r12 = r8
            goto L_0x0167
        L_0x015e:
            r0 = move-exception
            r10 = r0
            r11 = r8
            r12 = r11
            goto L_0x01d5
        L_0x0164:
            r0 = move-exception
            r10 = r8
            r12 = r10
        L_0x0167:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r11.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r13 = "Error downloading file from "
            r11.append(r13)     // Catch:{ all -> 0x01d2 }
            r13 = r17
            r11.append(r13)     // Catch:{ all -> 0x01d2 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x01d2 }
            java.lang.Object[] r14 = new java.lang.Object[r9]     // Catch:{ all -> 0x01d2 }
            com.zendesk.logger.Logger.c(r7, r11, r0, r14)     // Catch:{ all -> 0x01d2 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r11 = new com.zopim.android.sdk.api.ErrorResponseImpl$Builder     // Catch:{ all -> 0x01d2 }
            r11.<init>()     // Catch:{ all -> 0x01d2 }
            com.zopim.android.sdk.api.ErrorResponse$Kind r14 = com.zopim.android.sdk.api.ErrorResponse.Kind.UNEXPECTED     // Catch:{ all -> 0x01d2 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r11 = r11.kind(r14)     // Catch:{ all -> 0x01d2 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01d2 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r0 = r11.reason(r0)     // Catch:{ all -> 0x01d2 }
            java.lang.String r11 = r17.toExternalForm()     // Catch:{ all -> 0x01d2 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r0 = r0.url(r11)     // Catch:{ all -> 0x01d2 }
            com.zopim.android.sdk.api.ErrorResponseImpl r0 = r0.build()     // Catch:{ all -> 0x01d2 }
            com.zopim.android.sdk.api.RegisteredCallback<java.io.File> r11 = r1.mRequestCallback     // Catch:{ all -> 0x01d2 }
            if (r11 == 0) goto L_0x01a5
            r11.onError(r0)     // Catch:{ all -> 0x01d2 }
        L_0x01a5:
            if (r10 == 0) goto L_0x01af
            java.lang.Object[] r0 = new java.lang.Object[r9]
            com.zendesk.logger.Logger.j(r7, r6, r0)
            r10.disconnect()
        L_0x01af:
            if (r8 == 0) goto L_0x01c0
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x01ba }
            com.zendesk.logger.Logger.j(r7, r5, r0)     // Catch:{ Exception -> 0x01ba }
            r8.close()     // Catch:{ Exception -> 0x01ba }
            goto L_0x01c0
        L_0x01ba:
            r0 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r9]
            com.zendesk.logger.Logger.k(r7, r3, r0, r5)
        L_0x01c0:
            if (r12 == 0) goto L_0x01d1
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x01cb }
            com.zendesk.logger.Logger.j(r7, r4, r0)     // Catch:{ Exception -> 0x01cb }
            r12.close()     // Catch:{ Exception -> 0x01cb }
            goto L_0x01d1
        L_0x01cb:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r9]
            com.zendesk.logger.Logger.k(r7, r2, r0, r3)
        L_0x01d1:
            return
        L_0x01d2:
            r0 = move-exception
            r11 = r8
            goto L_0x0157
        L_0x01d5:
            if (r8 == 0) goto L_0x01df
            java.lang.Object[] r0 = new java.lang.Object[r9]
            com.zendesk.logger.Logger.j(r7, r6, r0)
            r8.disconnect()
        L_0x01df:
            if (r11 == 0) goto L_0x01f0
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x01ea }
            com.zendesk.logger.Logger.j(r7, r5, r0)     // Catch:{ Exception -> 0x01ea }
            r11.close()     // Catch:{ Exception -> 0x01ea }
            goto L_0x01f0
        L_0x01ea:
            r0 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r9]
            com.zendesk.logger.Logger.k(r7, r3, r0, r5)
        L_0x01f0:
            if (r12 == 0) goto L_0x0201
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x01fb }
            com.zendesk.logger.Logger.j(r7, r4, r0)     // Catch:{ Exception -> 0x01fb }
            r12.close()     // Catch:{ Exception -> 0x01fb }
            goto L_0x0201
        L_0x01fb:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r9]
            com.zendesk.logger.Logger.k(r7, r2, r0, r3)
        L_0x0201:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.api.DownloadHttpRequest.downloadFileInternal(java.net.URL, java.io.File):void");
    }

    public void downloadFile(URL url, File file) {
        if (file == null || file.getName() == null || file.getName().isEmpty()) {
            Logger.d(LOG_TAG, "File validation failed. Upload aborted.", new Object[0]);
        } else if (url == null || !Patterns.WEB_URL.matcher(url.toString()).matches()) {
            Logger.d(LOG_TAG, "URL validation failed. Upload aborted.", new Object[0]);
        } else {
            Logger.j(LOG_TAG, "Start of download.", new Object[0]);
            downloadFileInternal(url, file);
            Logger.j(LOG_TAG, "End of download.", new Object[0]);
        }
    }

    public void setRequestListener(RegisteredCallback<File> registeredCallback) {
        this.mRequestCallback = registeredCallback;
    }
}
