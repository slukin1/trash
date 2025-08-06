package com.zopim.android.sdk.api;

import android.util.Patterns;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.api.HttpRequest;
import java.io.File;
import java.net.URL;

final class MonitoredUploadHttpRequest implements HttpRequest {
    private static final String BOUNDARY = Long.toHexString(System.currentTimeMillis());
    private static final String CRLF = "\r\n";
    private static final String HTTP_METHOD = "POST";
    private static final String LOG_TAG = "MonitoredUploadHttpReq";
    private HttpRequest.ProgressListener mProgressListener;
    private RegisteredCallback<Void> mRequestCallback;

    /* renamed from: com.zopim.android.sdk.api.MonitoredUploadHttpRequest$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.api.MonitoredUploadHttpRequest.AnonymousClass1.<clinit>():void");
        }
    }

    private void reportProgress(int i11) {
        HttpRequest.ProgressListener progressListener = this.mProgressListener;
        if (progressListener != null) {
            progressListener.onProgressUpdate(i11);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: java.io.PrintWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: java.io.OutputStream} */
    /* JADX WARNING: type inference failed for: r3v33 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0386 A[SYNTHETIC, Splitter:B:164:0x0386] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x039d A[SYNTHETIC, Splitter:B:173:0x039d] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x03b5 A[SYNTHETIC, Splitter:B:185:0x03b5] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x03ca  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x03cd A[SYNTHETIC, Splitter:B:197:0x03cd] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x03ec  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x03f6 A[SYNTHETIC, Splitter:B:214:0x03f6] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x040b  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x040e A[SYNTHETIC, Splitter:B:226:0x040e] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0423  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0426 A[SYNTHETIC, Splitter:B:238:0x0426] */
    /* JADX WARNING: Removed duplicated region for block: B:251:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void uploadFileInternal(java.io.File r23, java.net.URL r24) {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r0 = "UTF-8"
            java.lang.String r2 = "--"
            java.lang.String r3 = "Failed to close file input stream"
            java.lang.String r4 = "Failed to close output stream"
            java.lang.String r5 = "Closing file input stream"
            java.lang.String r6 = "Failed to close writer"
            java.lang.String r7 = "Closing output stream"
            java.lang.String r8 = "Closing print writer"
            java.lang.String r9 = "Disconnecting url connection"
            java.lang.String r10 = "\r\n"
            java.lang.String r11 = "MonitoredUploadHttpReq"
            java.net.URLConnection r14 = r24.openConnection()     // Catch:{ Exception -> 0x033e, all -> 0x0331 }
            javax.net.ssl.HttpsURLConnection r14 = (javax.net.ssl.HttpsURLConnection) r14     // Catch:{ Exception -> 0x033e, all -> 0x0331 }
            java.lang.String r15 = "POST"
            r14.setRequestMethod(r15)     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            r15 = 1
            r14.setDoOutput(r15)     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            java.lang.String r12 = "User-Agent"
            java.lang.String r16 = "http.agent"
            java.lang.String r15 = java.lang.System.getProperty(r16)     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            r14.setRequestProperty(r12, r15)     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            java.lang.String r12 = "Accept-Charset"
            r14.setRequestProperty(r12, r0)     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            java.lang.String r12 = "Content-Type"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            r15.<init>()     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            java.lang.String r13 = "multipart/form-data; boundary="
            r15.append(r13)     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            java.lang.String r13 = BOUNDARY     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            r15.append(r13)     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            r14.setRequestProperty(r12, r15)     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            r12 = 0
            r14.setInstanceFollowRedirects(r12)     // Catch:{ Exception -> 0x0327, all -> 0x031b }
            r12 = r3
            r15 = r4
            long r3 = com.zopim.android.sdk.api.HttpRequest.REQUEST_TIMEOUT     // Catch:{ Exception -> 0x0314, all -> 0x0309 }
            int r3 = (int) r3     // Catch:{ Exception -> 0x0314, all -> 0x0309 }
            r14.setReadTimeout(r3)     // Catch:{ Exception -> 0x0314, all -> 0x0309 }
            java.io.OutputStream r3 = r14.getOutputStream()     // Catch:{ Exception -> 0x0314, all -> 0x0309 }
            java.io.PrintWriter r4 = new java.io.PrintWriter     // Catch:{ Exception -> 0x0300, all -> 0x02f6 }
            r17 = r15
            java.io.OutputStreamWriter r15 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x02ef, all -> 0x02e8 }
            r15.<init>(r3, r0)     // Catch:{ Exception -> 0x02ef, all -> 0x02e8 }
            r0 = 1
            r4.<init>(r15, r0)     // Catch:{ Exception -> 0x02ef, all -> 0x02e8 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r0.<init>()     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r0.append(r2)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r0.append(r13)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.io.PrintWriter r0 = r4.append(r0)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r0.append(r10)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r0.<init>()     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.String r13 = "Content-Disposition: form-data; name=\"binaryFile\"; filename=\""
            r0.append(r13)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.String r13 = r23.getName()     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r0.append(r13)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.String r13 = "\""
            r0.append(r13)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.io.PrintWriter r0 = r4.append(r0)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r0.append(r10)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r0.<init>()     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.String r13 = "Content-Type: "
            r0.append(r13)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.String r13 = r23.getName()     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.String r13 = java.net.URLConnection.guessContentTypeFromName(r13)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r0.append(r13)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.io.PrintWriter r0 = r4.append(r0)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r0.append(r10)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r0.<init>()     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            java.lang.String r13 = "Content-Length: "
            r0.append(r13)     // Catch:{ Exception -> 0x02df, all -> 0x02d6 }
            r15 = r12
            long r12 = r23.length()     // Catch:{ Exception -> 0x02d0, all -> 0x02c5 }
            r0.append(r12)     // Catch:{ Exception -> 0x02d0, all -> 0x02c5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02d0, all -> 0x02c5 }
            r4.append(r0)     // Catch:{ Exception -> 0x02d0, all -> 0x02c5 }
            java.lang.String r0 = "Content-Transfer-Encoding: binary"
            java.io.PrintWriter r0 = r4.append(r0)     // Catch:{ Exception -> 0x02d0, all -> 0x02c5 }
            r0.append(r10)     // Catch:{ Exception -> 0x02d0, all -> 0x02c5 }
            java.io.PrintWriter r0 = r4.append(r10)     // Catch:{ Exception -> 0x02d0, all -> 0x02c5 }
            r0.flush()     // Catch:{ Exception -> 0x02d0, all -> 0x02c5 }
            long r12 = r23.length()     // Catch:{ Exception -> 0x02d0, all -> 0x02c5 }
            r0 = 1
            r1.reportProgress(r0)     // Catch:{ Exception -> 0x02d0, all -> 0x02c5 }
            r18 = r15
            java.io.BufferedInputStream r15 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x02bc, all -> 0x02b3 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x02bc, all -> 0x02b3 }
            r19 = r5
            r5 = r23
            r0.<init>(r5)     // Catch:{ Exception -> 0x02a9, all -> 0x02a1 }
            r15.<init>(r0)     // Catch:{ Exception -> 0x02a9, all -> 0x02a1 }
            int r0 = r15.available()     // Catch:{ Exception -> 0x0295, all -> 0x028a }
            r5 = 4096(0x1000, float:5.74E-42)
            int r0 = java.lang.Math.min(r0, r5)     // Catch:{ Exception -> 0x0295, all -> 0x028a }
            byte[] r5 = new byte[r0]     // Catch:{ Exception -> 0x0295, all -> 0x028a }
            r20 = r7
            r7 = 0
            int r0 = r15.read(r5, r7, r0)     // Catch:{ Exception -> 0x027f, all -> 0x0276 }
            r16 = r0
            java.lang.String r0 = "Reading bytes from fis"
            r21 = r6
            java.lang.Object[] r6 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            com.zendesk.logger.Logger.j(r11, r0, r6)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r0 = r16
            r6 = r0
        L_0x0125:
            if (r0 <= 0) goto L_0x0171
            r3.write(r5, r7, r0)     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            r0 = 99
            int r7 = r0 * r6
            long r0 = (long) r7
            long r0 = r0 / r12
            float r0 = (float) r0     // Catch:{ Exception -> 0x0150, all -> 0x014c }
            int r0 = java.lang.Math.round(r0)     // Catch:{ Exception -> 0x0150, all -> 0x014c }
            r1 = r22
            r1.reportProgress(r0)     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            int r0 = r15.available()     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            r7 = 4096(0x1000, float:5.74E-42)
            int r0 = java.lang.Math.min(r0, r7)     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            r7 = 0
            int r0 = r15.read(r5, r7, r0)     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            int r6 = r6 + r0
            r7 = 0
            goto L_0x0125
        L_0x014c:
            r0 = move-exception
            r1 = r22
            goto L_0x0155
        L_0x0150:
            r0 = move-exception
            r1 = r22
            goto L_0x0164
        L_0x0154:
            r0 = move-exception
        L_0x0155:
            r13 = r0
            r2 = r15
            r7 = r17
            r12 = r18
            r10 = r19
            r6 = r20
            r5 = r21
            goto L_0x03e9
        L_0x0163:
            r0 = move-exception
        L_0x0164:
            r2 = r15
            r7 = r17
            r12 = r18
            r10 = r19
            r6 = r20
            r5 = r21
            goto L_0x0348
        L_0x0171:
            java.lang.String r0 = "Finished write to output stream. Closing file input stream"
            r5 = 0
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            com.zendesk.logger.Logger.j(r11, r0, r6)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r15.close()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r3.flush()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            java.io.PrintWriter r0 = r4.append(r10)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r0.flush()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r0.<init>()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r0.append(r2)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            java.lang.String r5 = BOUNDARY     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r0.append(r5)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r0.append(r2)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            java.io.PrintWriter r0 = r4.append(r0)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            java.io.PrintWriter r0 = r0.append(r10)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r0.flush()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r4.close()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r3.close()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            int r0 = r14.getResponseCode()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            com.zopim.android.sdk.api.HttpRequest$Status r2 = com.zopim.android.sdk.api.HttpRequest.Status.getStatus(r0)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            int[] r5 = com.zopim.android.sdk.api.MonitoredUploadHttpRequest.AnonymousClass1.$SwitchMap$com$zopim$android$sdk$api$HttpRequest$Status     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            int r2 = r2.ordinal()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r2 = r5[r2]     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r5 = 1
            if (r2 == r5) goto L_0x01f3
            r5 = 2
            if (r2 == r5) goto L_0x01c8
            r5 = 3
            if (r2 == r5) goto L_0x01c8
            r5 = 4
            if (r2 == r5) goto L_0x01c8
            goto L_0x0212
        L_0x01c8:
            java.lang.String r2 = r14.getResponseMessage()     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r5 = new com.zopim.android.sdk.api.ErrorResponseImpl$Builder     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            r5.<init>()     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponse$Kind r6 = com.zopim.android.sdk.api.ErrorResponse.Kind.HTTP     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r5 = r5.kind(r6)     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r0 = r5.status(r0)     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            java.lang.String r5 = r24.toExternalForm()     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r0 = r0.url(r5)     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r0 = r0.responseBody(r2)     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            com.zopim.android.sdk.api.ErrorResponseImpl r0 = r0.build()     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            com.zopim.android.sdk.api.RegisteredCallback<java.lang.Void> r2 = r1.mRequestCallback     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            if (r2 == 0) goto L_0x0212
            r2.onErrorInternal(r0)     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
            goto L_0x0212
        L_0x01f3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r2.<init>()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            java.lang.String r5 = "Request completed. Status "
            r2.append(r5)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r2.append(r0)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            r2 = 0
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            com.zendesk.logger.Logger.g(r11, r0, r5)     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            com.zopim.android.sdk.api.RegisteredCallback<java.lang.Void> r0 = r1.mRequestCallback     // Catch:{ Exception -> 0x026a, all -> 0x0260 }
            if (r0 == 0) goto L_0x0212
            r2 = 0
            r0.onSuccessInternal(r2)     // Catch:{ Exception -> 0x0163, all -> 0x0154 }
        L_0x0212:
            r2 = 0
            java.lang.Object[] r0 = new java.lang.Object[r2]
            com.zendesk.logger.Logger.j(r11, r9, r0)
            r14.disconnect()
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0228 }
            com.zendesk.logger.Logger.j(r11, r8, r0)     // Catch:{ Exception -> 0x0225 }
            r4.close()     // Catch:{ Exception -> 0x0225 }
            r2 = 0
            goto L_0x0230
        L_0x0225:
            r0 = move-exception
            r2 = 0
            goto L_0x0229
        L_0x0228:
            r0 = move-exception
        L_0x0229:
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r5 = r21
            com.zendesk.logger.Logger.k(r11, r5, r0, r4)
        L_0x0230:
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x023f }
            r6 = r20
            com.zendesk.logger.Logger.j(r11, r6, r0)     // Catch:{ Exception -> 0x023c }
            r3.close()     // Catch:{ Exception -> 0x023c }
            r2 = 0
            goto L_0x0247
        L_0x023c:
            r0 = move-exception
            r2 = 0
            goto L_0x0240
        L_0x023f:
            r0 = move-exception
        L_0x0240:
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r7 = r17
            com.zendesk.logger.Logger.k(r11, r7, r0, r3)
        L_0x0247:
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0256 }
            r10 = r19
            com.zendesk.logger.Logger.j(r11, r10, r0)     // Catch:{ Exception -> 0x0253 }
            r15.close()     // Catch:{ Exception -> 0x0253 }
            goto L_0x03e2
        L_0x0253:
            r0 = move-exception
            r2 = 0
            goto L_0x0257
        L_0x0256:
            r0 = move-exception
        L_0x0257:
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r12 = r18
            com.zendesk.logger.Logger.k(r11, r12, r0, r2)
            goto L_0x03e2
        L_0x0260:
            r0 = move-exception
            r7 = r17
            r10 = r19
            r6 = r20
            r5 = r21
            goto L_0x0291
        L_0x026a:
            r0 = move-exception
            r7 = r17
            r12 = r18
            r10 = r19
            r6 = r20
            r5 = r21
            goto L_0x029e
        L_0x0276:
            r0 = move-exception
            r5 = r6
            r7 = r17
            r10 = r19
            r6 = r20
            goto L_0x0291
        L_0x027f:
            r0 = move-exception
            r5 = r6
            r7 = r17
            r12 = r18
            r10 = r19
            r6 = r20
            goto L_0x029e
        L_0x028a:
            r0 = move-exception
            r5 = r6
            r6 = r7
            r7 = r17
            r10 = r19
        L_0x0291:
            r13 = r0
            r2 = r15
            goto L_0x038c
        L_0x0295:
            r0 = move-exception
            r5 = r6
            r6 = r7
            r7 = r17
            r12 = r18
            r10 = r19
        L_0x029e:
            r2 = r15
            goto L_0x0348
        L_0x02a1:
            r0 = move-exception
            r5 = r6
            r6 = r7
            r7 = r17
            r10 = r19
            goto L_0x02b9
        L_0x02a9:
            r0 = move-exception
            r5 = r6
            r6 = r7
            r7 = r17
            r12 = r18
            r10 = r19
            goto L_0x02e5
        L_0x02b3:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r7 = r17
        L_0x02b9:
            r2 = 0
            goto L_0x038b
        L_0x02bc:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r7 = r17
            r12 = r18
            goto L_0x02e5
        L_0x02c5:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r7 = r17
            r2 = 0
            r13 = r0
            r12 = r15
            goto L_0x03e9
        L_0x02d0:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r12 = r15
            goto L_0x02e3
        L_0x02d6:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r7 = r17
            r2 = 0
            goto L_0x03e8
        L_0x02df:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
        L_0x02e3:
            r7 = r17
        L_0x02e5:
            r2 = 0
            goto L_0x0348
        L_0x02e8:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r7 = r17
            goto L_0x02fb
        L_0x02ef:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r7 = r17
            goto L_0x0305
        L_0x02f6:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r7 = r15
        L_0x02fb:
            r2 = 0
            r13 = r0
            r4 = r2
            goto L_0x03e9
        L_0x0300:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r7 = r15
        L_0x0305:
            r2 = 0
            r4 = r2
            goto L_0x0348
        L_0x0309:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r7 = r15
            r2 = 0
            r13 = r0
            r3 = r2
            r4 = r3
            goto L_0x03e9
        L_0x0314:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r7 = r15
            r2 = 0
            goto L_0x032e
        L_0x031b:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r2 = 0
            r7 = r4
            r13 = r0
            r4 = r2
            r12 = r3
            r3 = r4
            goto L_0x03e9
        L_0x0327:
            r0 = move-exception
            r12 = r3
            r10 = r5
            r5 = r6
            r6 = r7
            r2 = 0
            r7 = r4
        L_0x032e:
            r3 = r2
            r4 = r3
            goto L_0x0348
        L_0x0331:
            r0 = move-exception
            r10 = r5
            r5 = r6
            r6 = r7
            r2 = 0
            r7 = r4
            r13 = r0
            r4 = r2
            r14 = r4
            r12 = r3
            r3 = r14
            goto L_0x03e9
        L_0x033e:
            r0 = move-exception
            r12 = r3
            r10 = r5
            r5 = r6
            r6 = r7
            r2 = 0
            r7 = r4
            r3 = r2
            r4 = r3
            r14 = r4
        L_0x0348:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x03e7 }
            r13.<init>()     // Catch:{ all -> 0x03e7 }
            java.lang.String r15 = "Error uploading file to "
            r13.append(r15)     // Catch:{ all -> 0x03e7 }
            r15 = r24
            r13.append(r15)     // Catch:{ all -> 0x03e7 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x03e7 }
            r18 = r12
            r15 = 0
            java.lang.Object[] r12 = new java.lang.Object[r15]     // Catch:{ all -> 0x03e3 }
            com.zendesk.logger.Logger.c(r11, r13, r0, r12)     // Catch:{ all -> 0x03e3 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r12 = new com.zopim.android.sdk.api.ErrorResponseImpl$Builder     // Catch:{ all -> 0x03e3 }
            r12.<init>()     // Catch:{ all -> 0x03e3 }
            com.zopim.android.sdk.api.ErrorResponse$Kind r13 = com.zopim.android.sdk.api.ErrorResponse.Kind.UNEXPECTED     // Catch:{ all -> 0x03e3 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r12 = r12.kind(r13)     // Catch:{ all -> 0x03e3 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x03e3 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r0 = r12.reason(r0)     // Catch:{ all -> 0x03e3 }
            java.lang.String r12 = r24.toExternalForm()     // Catch:{ all -> 0x03e3 }
            com.zopim.android.sdk.api.ErrorResponseImpl$Builder r0 = r0.url(r12)     // Catch:{ all -> 0x03e3 }
            com.zopim.android.sdk.api.ErrorResponseImpl r0 = r0.build()     // Catch:{ all -> 0x03e3 }
            com.zopim.android.sdk.api.RegisteredCallback<java.lang.Void> r12 = r1.mRequestCallback     // Catch:{ all -> 0x03e3 }
            if (r12 == 0) goto L_0x0390
            r12.onErrorInternal(r0)     // Catch:{ all -> 0x038a }
            goto L_0x0390
        L_0x038a:
            r0 = move-exception
        L_0x038b:
            r13 = r0
        L_0x038c:
            r12 = r18
            goto L_0x03e9
        L_0x0390:
            r12 = 0
            if (r14 == 0) goto L_0x039b
            java.lang.Object[] r0 = new java.lang.Object[r12]
            com.zendesk.logger.Logger.j(r11, r9, r0)
            r14.disconnect()
        L_0x039b:
            if (r4 == 0) goto L_0x03b2
            java.lang.Object[] r0 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x03aa }
            com.zendesk.logger.Logger.j(r11, r8, r0)     // Catch:{ Exception -> 0x03a7 }
            r4.close()     // Catch:{ Exception -> 0x03a7 }
            r4 = 0
            goto L_0x03b3
        L_0x03a7:
            r0 = move-exception
            r4 = 0
            goto L_0x03ac
        L_0x03aa:
            r0 = move-exception
            r4 = r12
        L_0x03ac:
            java.lang.Object[] r8 = new java.lang.Object[r4]
            com.zendesk.logger.Logger.k(r11, r5, r0, r8)
            goto L_0x03b3
        L_0x03b2:
            r4 = r12
        L_0x03b3:
            if (r3 == 0) goto L_0x03ca
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x03c2 }
            com.zendesk.logger.Logger.j(r11, r6, r0)     // Catch:{ Exception -> 0x03bf }
            r3.close()     // Catch:{ Exception -> 0x03bf }
            r3 = 0
            goto L_0x03cb
        L_0x03bf:
            r0 = move-exception
            r3 = 0
            goto L_0x03c4
        L_0x03c2:
            r0 = move-exception
            r3 = r4
        L_0x03c4:
            java.lang.Object[] r4 = new java.lang.Object[r3]
            com.zendesk.logger.Logger.k(r11, r7, r0, r4)
            goto L_0x03cb
        L_0x03ca:
            r3 = r4
        L_0x03cb:
            if (r2 == 0) goto L_0x03e2
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x03d9 }
            com.zendesk.logger.Logger.j(r11, r10, r0)     // Catch:{ Exception -> 0x03d6 }
            r2.close()     // Catch:{ Exception -> 0x03d6 }
            goto L_0x03e2
        L_0x03d6:
            r0 = move-exception
            r2 = 0
            goto L_0x03db
        L_0x03d9:
            r0 = move-exception
            r2 = r3
        L_0x03db:
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r12 = r18
            com.zendesk.logger.Logger.k(r11, r12, r0, r2)
        L_0x03e2:
            return
        L_0x03e3:
            r0 = move-exception
            r12 = r18
            goto L_0x03e8
        L_0x03e7:
            r0 = move-exception
        L_0x03e8:
            r13 = r0
        L_0x03e9:
            r15 = 0
            if (r14 == 0) goto L_0x03f4
            java.lang.Object[] r0 = new java.lang.Object[r15]
            com.zendesk.logger.Logger.j(r11, r9, r0)
            r14.disconnect()
        L_0x03f4:
            if (r4 == 0) goto L_0x040b
            java.lang.Object[] r0 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0403 }
            com.zendesk.logger.Logger.j(r11, r8, r0)     // Catch:{ Exception -> 0x0400 }
            r4.close()     // Catch:{ Exception -> 0x0400 }
            r4 = 0
            goto L_0x040c
        L_0x0400:
            r0 = move-exception
            r4 = 0
            goto L_0x0405
        L_0x0403:
            r0 = move-exception
            r4 = r15
        L_0x0405:
            java.lang.Object[] r8 = new java.lang.Object[r4]
            com.zendesk.logger.Logger.k(r11, r5, r0, r8)
            goto L_0x040c
        L_0x040b:
            r4 = r15
        L_0x040c:
            if (r3 == 0) goto L_0x0423
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x041b }
            com.zendesk.logger.Logger.j(r11, r6, r0)     // Catch:{ Exception -> 0x0418 }
            r3.close()     // Catch:{ Exception -> 0x0418 }
            r3 = 0
            goto L_0x0424
        L_0x0418:
            r0 = move-exception
            r3 = 0
            goto L_0x041d
        L_0x041b:
            r0 = move-exception
            r3 = r4
        L_0x041d:
            java.lang.Object[] r4 = new java.lang.Object[r3]
            com.zendesk.logger.Logger.k(r11, r7, r0, r4)
            goto L_0x0424
        L_0x0423:
            r3 = r4
        L_0x0424:
            if (r2 == 0) goto L_0x0439
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0432 }
            com.zendesk.logger.Logger.j(r11, r10, r0)     // Catch:{ Exception -> 0x042f }
            r2.close()     // Catch:{ Exception -> 0x042f }
            goto L_0x0439
        L_0x042f:
            r0 = move-exception
            r2 = 0
            goto L_0x0434
        L_0x0432:
            r0 = move-exception
            r2 = r3
        L_0x0434:
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.zendesk.logger.Logger.k(r11, r12, r0, r2)
        L_0x0439:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.api.MonitoredUploadHttpRequest.uploadFileInternal(java.io.File, java.net.URL):void");
    }

    public void setProgressListener(HttpRequest.ProgressListener progressListener) {
        this.mProgressListener = progressListener;
    }

    public void setRequestListener(RegisteredCallback<Void> registeredCallback) {
        this.mRequestCallback = registeredCallback;
    }

    public void upload(File file, URL url) {
        if (file == null || file.getName() == null || file.getName().isEmpty() || !file.exists()) {
            Logger.d(LOG_TAG, "File validation failed. Upload aborted.", new Object[0]);
        } else if (url == null || !Patterns.WEB_URL.matcher(url.toString()).matches()) {
            Logger.d(LOG_TAG, "URL validation failed. Upload aborted.", new Object[0]);
        } else {
            Logger.j(LOG_TAG, "Start of upload.", new Object[0]);
            uploadFileInternal(file, url);
            Logger.j(LOG_TAG, "End of upload.", new Object[0]);
        }
    }
}
