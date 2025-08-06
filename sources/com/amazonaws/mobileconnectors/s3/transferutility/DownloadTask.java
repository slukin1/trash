package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.File;
import java.util.concurrent.Callable;

class DownloadTask implements Callable<Boolean> {

    /* renamed from: e  reason: collision with root package name */
    public static final Log f14953e = LogFactory.b(DownloadTask.class);

    /* renamed from: b  reason: collision with root package name */
    public final AmazonS3 f14954b;

    /* renamed from: c  reason: collision with root package name */
    public final TransferRecord f14955c;

    /* renamed from: d  reason: collision with root package name */
    public final TransferStatusUpdater f14956d;

    public DownloadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        this.f14955c = transferRecord;
        this.f14954b = amazonS3;
        this.f14956d = transferStatusUpdater;
    }

    /* renamed from: a */
    public Boolean call() {
        try {
            if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                Log log = f14953e;
                log.j("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                this.f14956d.j(this.f14955c.f14977a, TransferState.WAITING_FOR_NETWORK);
                return Boolean.FALSE;
            }
        } catch (TransferUtilityException e11) {
            Log log2 = f14953e;
            log2.c("TransferUtilityException: [" + e11 + "]");
        }
        this.f14956d.j(this.f14955c.f14977a, TransferState.IN_PROGRESS);
        ProgressListener f11 = this.f14956d.f(this.f14955c.f14977a);
        try {
            TransferRecord transferRecord = this.f14955c;
            GetObjectRequest getObjectRequest = new GetObjectRequest(transferRecord.f14992p, transferRecord.f14993q);
            TransferUtility.b(getObjectRequest);
            File file = new File(this.f14955c.f14995s);
            long length = file.length();
            if (length > 0) {
                f14953e.h(String.format("Resume transfer %d from %d bytes", new Object[]{Integer.valueOf(this.f14955c.f14977a), Long.valueOf(length)}));
                getObjectRequest.setRange(length, -1);
            }
            getObjectRequest.setGeneralProgressListener(f11);
            S3Object b11 = this.f14954b.b(getObjectRequest);
            if (b11 == null) {
                this.f14956d.h(this.f14955c.f14977a, new IllegalStateException("AmazonS3.getObject returns null"));
                this.f14956d.j(this.f14955c.f14977a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            long instanceLength = b11.getObjectMetadata().getInstanceLength();
            this.f14956d.i(this.f14955c.f14977a, length, instanceLength, true);
            b(b11.getObjectContent(), file);
            this.f14956d.i(this.f14955c.f14977a, instanceLength, instanceLength, true);
            this.f14956d.j(this.f14955c.f14977a, TransferState.COMPLETED);
            return Boolean.TRUE;
        } catch (Exception e12) {
            Exception exc = e12;
            if (TransferState.PENDING_CANCEL.equals(this.f14955c.f14991o)) {
                TransferStatusUpdater transferStatusUpdater = this.f14956d;
                int i11 = this.f14955c.f14977a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater.j(i11, transferState);
                Log log3 = f14953e;
                log3.j("Transfer is " + transferState);
                return Boolean.FALSE;
            } else if (TransferState.PENDING_PAUSE.equals(this.f14955c.f14991o)) {
                TransferStatusUpdater transferStatusUpdater2 = this.f14956d;
                int i12 = this.f14955c.f14977a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater2.j(i12, transferState2);
                Log log4 = f14953e;
                log4.j("Transfer is " + transferState2);
                new ProgressEvent(0).c(32);
                f11.a(new ProgressEvent(0));
                return Boolean.FALSE;
            } else {
                try {
                    if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                        Log log5 = f14953e;
                        log5.j("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                        this.f14956d.j(this.f14955c.f14977a, TransferState.WAITING_FOR_NETWORK);
                        log5.h("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                        new ProgressEvent(0).c(32);
                        f11.a(new ProgressEvent(0));
                        return Boolean.FALSE;
                    }
                } catch (TransferUtilityException e13) {
                    Log log6 = f14953e;
                    log6.c("TransferUtilityException: [" + e13 + "]");
                }
                if (RetryUtils.b(exc)) {
                    Log log7 = f14953e;
                    log7.j("Transfer is interrupted. " + exc);
                    this.f14956d.j(this.f14955c.f14977a, TransferState.FAILED);
                    return Boolean.FALSE;
                }
                Log log8 = f14953e;
                log8.h("Failed to download: " + this.f14955c.f14977a + " due to " + exc.getMessage());
                this.f14956d.h(this.f14955c.f14977a, exc);
                this.f14956d.j(this.f14955c.f14977a, TransferState.FAILED);
                return Boolean.FALSE;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0098 A[SYNTHETIC, Splitter:B:41:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a4 A[SYNTHETIC, Splitter:B:46:0x00a4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.io.InputStream r7, java.io.File r8) {
        /*
            r6 = this;
            java.lang.String r0 = "got exception"
            java.io.File r1 = r8.getParentFile()
            if (r1 == 0) goto L_0x0011
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x0011
            r1.mkdirs()
        L_0x0011:
            long r1 = r8.length()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            if (r1 <= 0) goto L_0x001e
            r1 = 1
            goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            r3 = 0
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ SocketTimeoutException -> 0x0075, IOException -> 0x0059 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ SocketTimeoutException -> 0x0075, IOException -> 0x0059 }
            r5.<init>(r8, r1)     // Catch:{ SocketTimeoutException -> 0x0075, IOException -> 0x0059 }
            r4.<init>(r5)     // Catch:{ SocketTimeoutException -> 0x0075, IOException -> 0x0059 }
            r8 = 16384(0x4000, float:2.2959E-41)
            byte[] r8 = new byte[r8]     // Catch:{ SocketTimeoutException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
        L_0x002e:
            int r1 = r7.read(r8)     // Catch:{ SocketTimeoutException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            r3 = -1
            if (r1 == r3) goto L_0x0039
            r4.write(r8, r2, r1)     // Catch:{ SocketTimeoutException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            goto L_0x002e
        L_0x0039:
            r4.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0043
        L_0x003d:
            r8 = move-exception
            com.amazonaws.logging.Log r1 = f14953e
            r1.f(r0, r8)
        L_0x0043:
            r7.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004d
        L_0x0047:
            r7 = move-exception
            com.amazonaws.logging.Log r8 = f14953e
            r8.f(r0, r7)
        L_0x004d:
            return
        L_0x004e:
            r8 = move-exception
            r3 = r4
            goto L_0x0096
        L_0x0051:
            r8 = move-exception
            r3 = r4
            goto L_0x005a
        L_0x0054:
            r8 = move-exception
            r3 = r4
            goto L_0x0076
        L_0x0057:
            r8 = move-exception
            goto L_0x0096
        L_0x0059:
            r8 = move-exception
        L_0x005a:
            com.amazonaws.AmazonClientException r1 = new com.amazonaws.AmazonClientException     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r2.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "Unable to store object contents to disk: "
            r2.append(r4)     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = r8.getMessage()     // Catch:{ all -> 0x0057 }
            r2.append(r4)     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0057 }
            r1.<init>(r2, r8)     // Catch:{ all -> 0x0057 }
            throw r1     // Catch:{ all -> 0x0057 }
        L_0x0075:
            r8 = move-exception
        L_0x0076:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r1.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = "SocketTimeoutException: Unable to retrieve contents over network: "
            r1.append(r2)     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r8.getMessage()     // Catch:{ all -> 0x0057 }
            r1.append(r2)     // Catch:{ all -> 0x0057 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0057 }
            com.amazonaws.logging.Log r2 = f14953e     // Catch:{ all -> 0x0057 }
            r2.c(r1)     // Catch:{ all -> 0x0057 }
            com.amazonaws.AmazonClientException r2 = new com.amazonaws.AmazonClientException     // Catch:{ all -> 0x0057 }
            r2.<init>(r1, r8)     // Catch:{ all -> 0x0057 }
            throw r2     // Catch:{ all -> 0x0057 }
        L_0x0096:
            if (r3 == 0) goto L_0x00a2
            r3.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x00a2
        L_0x009c:
            r1 = move-exception
            com.amazonaws.logging.Log r2 = f14953e
            r2.f(r0, r1)
        L_0x00a2:
            if (r7 == 0) goto L_0x00ae
            r7.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00ae
        L_0x00a8:
            r7 = move-exception
            com.amazonaws.logging.Log r1 = f14953e
            r1.f(r0, r7)
        L_0x00ae:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.DownloadTask.b(java.io.InputStream, java.io.File):void");
    }
}
