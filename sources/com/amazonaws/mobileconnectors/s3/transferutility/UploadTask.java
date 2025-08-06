package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.util.Mimetypes;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class UploadTask implements Callable<Boolean> {

    /* renamed from: h  reason: collision with root package name */
    public static final Log f15047h = LogFactory.b(UploadTask.class);

    /* renamed from: i  reason: collision with root package name */
    public static final Map<String, CannedAccessControlList> f15048i = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final AmazonS3 f15049b;

    /* renamed from: c  reason: collision with root package name */
    public final TransferRecord f15050c;

    /* renamed from: d  reason: collision with root package name */
    public final TransferDBUtil f15051d;

    /* renamed from: e  reason: collision with root package name */
    public final TransferStatusUpdater f15052e;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, UploadPartTaskMetadata> f15053f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public List<UploadPartRequest> f15054g;

    public class UploadPartTaskMetadata {

        /* renamed from: a  reason: collision with root package name */
        public UploadPartRequest f15055a;

        /* renamed from: b  reason: collision with root package name */
        public Future<Boolean> f15056b;

        /* renamed from: c  reason: collision with root package name */
        public long f15057c;

        /* renamed from: d  reason: collision with root package name */
        public TransferState f15058d;

        public UploadPartTaskMetadata() {
        }
    }

    public class UploadTaskProgressListener implements ProgressListener {

        /* renamed from: a  reason: collision with root package name */
        public long f15060a;

        /* renamed from: b  reason: collision with root package name */
        public final long f15061b;

        public UploadTaskProgressListener(long j11) {
            this.f15060a = j11;
            this.f15061b = j11;
        }

        public void a(ProgressEvent progressEvent) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0072, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void b(int r8, long r9) {
            /*
                r7 = this;
                monitor-enter(r7)
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask r0 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.this     // Catch:{ all -> 0x0073 }
                java.util.Map<java.lang.Integer, com.amazonaws.mobileconnectors.s3.transferutility.UploadTask$UploadPartTaskMetadata> r0 = r0.f15053f     // Catch:{ all -> 0x0073 }
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0073 }
                java.lang.Object r8 = r0.get(r8)     // Catch:{ all -> 0x0073 }
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask$UploadPartTaskMetadata r8 = (com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.UploadPartTaskMetadata) r8     // Catch:{ all -> 0x0073 }
                if (r8 != 0) goto L_0x001c
                com.amazonaws.logging.Log r8 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.f15047h     // Catch:{ all -> 0x0073 }
                java.lang.String r9 = "Update received for unknown part. Ignoring."
                r8.j(r9)     // Catch:{ all -> 0x0073 }
                monitor-exit(r7)
                return
            L_0x001c:
                r8.f15057c = r9     // Catch:{ all -> 0x0073 }
                long r8 = r7.f15061b     // Catch:{ all -> 0x0073 }
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask r10 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.this     // Catch:{ all -> 0x0073 }
                java.util.Map<java.lang.Integer, com.amazonaws.mobileconnectors.s3.transferutility.UploadTask$UploadPartTaskMetadata> r10 = r10.f15053f     // Catch:{ all -> 0x0073 }
                java.util.Set r10 = r10.entrySet()     // Catch:{ all -> 0x0073 }
                java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0073 }
            L_0x002c:
                boolean r0 = r10.hasNext()     // Catch:{ all -> 0x0073 }
                if (r0 == 0) goto L_0x0042
                java.lang.Object r0 = r10.next()     // Catch:{ all -> 0x0073 }
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0073 }
                java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0073 }
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask$UploadPartTaskMetadata r0 = (com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.UploadPartTaskMetadata) r0     // Catch:{ all -> 0x0073 }
                long r0 = r0.f15057c     // Catch:{ all -> 0x0073 }
                long r8 = r8 + r0
                goto L_0x002c
            L_0x0042:
                long r0 = r7.f15060a     // Catch:{ all -> 0x0073 }
                int r10 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r10 <= 0) goto L_0x0071
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask r10 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.this     // Catch:{ all -> 0x0073 }
                com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord r10 = r10.f15050c     // Catch:{ all -> 0x0073 }
                long r0 = r10.f14984h     // Catch:{ all -> 0x0073 }
                int r10 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r10 > 0) goto L_0x0071
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask r10 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.this     // Catch:{ all -> 0x0073 }
                com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater r0 = r10.f15052e     // Catch:{ all -> 0x0073 }
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask r10 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.this     // Catch:{ all -> 0x0073 }
                com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord r10 = r10.f15050c     // Catch:{ all -> 0x0073 }
                int r1 = r10.f14977a     // Catch:{ all -> 0x0073 }
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask r10 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.this     // Catch:{ all -> 0x0073 }
                com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord r10 = r10.f15050c     // Catch:{ all -> 0x0073 }
                long r4 = r10.f14984h     // Catch:{ all -> 0x0073 }
                r6 = 1
                r2 = r8
                r0.i(r1, r2, r4, r6)     // Catch:{ all -> 0x0073 }
                r7.f15060a = r8     // Catch:{ all -> 0x0073 }
            L_0x0071:
                monitor-exit(r7)
                return
            L_0x0073:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.UploadTaskProgressListener.b(int, long):void");
        }
    }

    static {
        for (CannedAccessControlList cannedAccessControlList : CannedAccessControlList.values()) {
            f15048i.put(cannedAccessControlList.toString(), cannedAccessControlList);
        }
    }

    public UploadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater) {
        this.f15050c = transferRecord;
        this.f15049b = amazonS3;
        this.f15051d = transferDBUtil;
        this.f15052e = transferStatusUpdater;
    }

    public static CannedAccessControlList h(String str) {
        if (str == null) {
            return null;
        }
        return f15048i.get(str);
    }

    public final void a(int i11, String str, String str2, String str3) {
        Log log = f15047h;
        log.j("Aborting the multipart since complete multipart failed.");
        try {
            this.f15049b.f(new AbortMultipartUploadRequest(str, str2, str3));
            log.h("Successfully aborted multipart upload: " + i11);
        } catch (AmazonClientException e11) {
            Log log2 = f15047h;
            log2.d("Failed to abort the multipart upload: " + i11, e11);
        }
    }

    /* renamed from: e */
    public Boolean call() throws Exception {
        try {
            if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                f15047h.j("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                this.f15052e.j(this.f15050c.f14977a, TransferState.WAITING_FOR_NETWORK);
                return Boolean.FALSE;
            }
        } catch (TransferUtilityException e11) {
            Log log = f15047h;
            log.c("TransferUtilityException: [" + e11 + "]");
        }
        this.f15052e.j(this.f15050c.f14977a, TransferState.IN_PROGRESS);
        TransferRecord transferRecord = this.f15050c;
        int i11 = transferRecord.f14980d;
        if (i11 == 1 && transferRecord.f14983g == 0) {
            return j();
        }
        if (i11 == 0) {
            return k();
        }
        return Boolean.FALSE;
    }

    public final void f(int i11, String str, String str2, String str3) throws AmazonClientException, AmazonServiceException {
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(str, str2, str3, this.f15051d.h(i11));
        TransferUtility.a(completeMultipartUploadRequest);
        this.f15049b.d(completeMultipartUploadRequest);
    }

    public final PutObjectRequest g(TransferRecord transferRecord) {
        File file = new File(transferRecord.f14995s);
        PutObjectRequest putObjectRequest = new PutObjectRequest(transferRecord.f14992p, transferRecord.f14993q, file);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.length());
        String str = transferRecord.f15002z;
        if (str != null) {
            objectMetadata.setCacheControl(str);
        }
        String str2 = transferRecord.f15000x;
        if (str2 != null) {
            objectMetadata.setContentDisposition(str2);
        }
        String str3 = transferRecord.f15001y;
        if (str3 != null) {
            objectMetadata.setContentEncoding(str3);
        }
        String str4 = transferRecord.f14998v;
        if (str4 != null) {
            objectMetadata.setContentType(str4);
        } else {
            objectMetadata.setContentType(Mimetypes.a().b(file));
        }
        String str5 = transferRecord.B;
        if (str5 != null) {
            putObjectRequest.setStorageClass(str5);
        }
        String str6 = transferRecord.D;
        if (str6 != null) {
            objectMetadata.setExpirationTimeRuleId(str6);
        }
        if (transferRecord.E != null) {
            objectMetadata.setHttpExpiresDate(new Date(Long.valueOf(transferRecord.E).longValue()));
        }
        String str7 = transferRecord.F;
        if (str7 != null) {
            objectMetadata.setSSEAlgorithm(str7);
        }
        Map<String, String> map = transferRecord.C;
        if (map != null) {
            objectMetadata.setUserMetadata(map);
            String str8 = transferRecord.C.get("x-amz-tagging");
            if (str8 != null) {
                try {
                    String[] split = str8.split(ContainerUtils.FIELD_DELIMITER);
                    ArrayList arrayList = new ArrayList();
                    for (String split2 : split) {
                        String[] split3 = split2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        arrayList.add(new Tag(split3[0], split3[1]));
                    }
                    putObjectRequest.setTagging(new ObjectTagging(arrayList));
                } catch (Exception e11) {
                    f15047h.b("Error in passing the object tags as request headers.", e11);
                }
            }
            String str9 = transferRecord.C.get("x-amz-website-redirect-location");
            if (str9 != null) {
                putObjectRequest.setRedirectLocation(str9);
            }
            String str10 = transferRecord.C.get("x-amz-request-payer");
            if (str10 != null) {
                putObjectRequest.setRequesterPays("requester".equals(str10));
            }
        }
        String str11 = transferRecord.H;
        if (str11 != null) {
            objectMetadata.setContentMD5(str11);
        }
        String str12 = transferRecord.G;
        if (str12 != null) {
            putObjectRequest.setSSEAwsKeyManagementParams(new SSEAwsKeyManagementParams(str12));
        }
        putObjectRequest.setMetadata(objectMetadata);
        putObjectRequest.setCannedAcl(h(transferRecord.I));
        return putObjectRequest;
    }

    public final String i(PutObjectRequest putObjectRequest) {
        InitiateMultipartUploadRequest withTagging = new InitiateMultipartUploadRequest(putObjectRequest.getBucketName(), putObjectRequest.getKey()).withCannedACL(putObjectRequest.getCannedAcl()).withObjectMetadata(putObjectRequest.getMetadata()).withSSEAwsKeyManagementParams(putObjectRequest.getSSEAwsKeyManagementParams()).withTagging(putObjectRequest.getTagging());
        TransferUtility.a(withTagging);
        return this.f15049b.e(withTagging).a();
    }

    public final Boolean j() throws ExecutionException {
        long j11;
        String str = this.f15050c.f14996t;
        if (str == null || str.isEmpty()) {
            PutObjectRequest g11 = g(this.f15050c);
            TransferUtility.a(g11);
            try {
                this.f15050c.f14996t = i(g11);
                TransferDBUtil transferDBUtil = this.f15051d;
                TransferRecord transferRecord = this.f15050c;
                transferDBUtil.m(transferRecord.f14977a, transferRecord.f14996t);
                j11 = 0;
            } catch (AmazonClientException e11) {
                f15047h.b("Error initiating multipart upload: " + this.f15050c.f14977a + " due to " + e11.getMessage(), e11);
                this.f15052e.h(this.f15050c.f14977a, e11);
                this.f15052e.j(this.f15050c.f14977a, TransferState.FAILED);
                return Boolean.FALSE;
            }
        } else {
            long g12 = this.f15051d.g(this.f15050c.f14977a);
            if (g12 > 0) {
                f15047h.j(String.format("Resume transfer %d from %d bytes", new Object[]{Integer.valueOf(this.f15050c.f14977a), Long.valueOf(g12)}));
            }
            j11 = g12;
        }
        UploadTaskProgressListener uploadTaskProgressListener = new UploadTaskProgressListener(j11);
        TransferStatusUpdater transferStatusUpdater = this.f15052e;
        TransferRecord transferRecord2 = this.f15050c;
        transferStatusUpdater.i(transferRecord2.f14977a, j11, transferRecord2.f14984h, false);
        TransferDBUtil transferDBUtil2 = this.f15051d;
        TransferRecord transferRecord3 = this.f15050c;
        this.f15054g = transferDBUtil2.c(transferRecord3.f14977a, transferRecord3.f14996t);
        f15047h.j("Multipart upload " + this.f15050c.f14977a + " in " + this.f15054g.size() + " parts.");
        for (UploadPartRequest next : this.f15054g) {
            TransferUtility.a(next);
            UploadPartTaskMetadata uploadPartTaskMetadata = new UploadPartTaskMetadata();
            uploadPartTaskMetadata.f15055a = next;
            uploadPartTaskMetadata.f15057c = 0;
            uploadPartTaskMetadata.f15058d = TransferState.WAITING;
            this.f15053f.put(Integer.valueOf(next.getPartNumber()), uploadPartTaskMetadata);
            uploadPartTaskMetadata.f15056b = TransferThreadPool.c(new UploadPartTask(uploadPartTaskMetadata, uploadTaskProgressListener, next, this.f15049b, this.f15051d));
        }
        try {
            boolean z11 = true;
            for (UploadPartTaskMetadata uploadPartTaskMetadata2 : this.f15053f.values()) {
                z11 &= uploadPartTaskMetadata2.f15056b.get().booleanValue();
            }
            if (!z11) {
                try {
                    if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                        f15047h.j("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                        this.f15052e.j(this.f15050c.f14977a, TransferState.WAITING_FOR_NETWORK);
                        return Boolean.FALSE;
                    }
                } catch (TransferUtilityException e12) {
                    f15047h.c("TransferUtilityException: [" + e12 + "]");
                }
            }
            f15047h.j("Completing the multi-part upload transfer for " + this.f15050c.f14977a);
            try {
                TransferRecord transferRecord4 = this.f15050c;
                f(transferRecord4.f14977a, transferRecord4.f14992p, transferRecord4.f14993q, transferRecord4.f14996t);
                TransferStatusUpdater transferStatusUpdater2 = this.f15052e;
                TransferRecord transferRecord5 = this.f15050c;
                int i11 = transferRecord5.f14977a;
                long j12 = transferRecord5.f14984h;
                transferStatusUpdater2.i(i11, j12, j12, true);
                this.f15052e.j(this.f15050c.f14977a, TransferState.COMPLETED);
                return Boolean.TRUE;
            } catch (AmazonClientException e13) {
                f15047h.b("Failed to complete multipart: " + this.f15050c.f14977a + " due to " + e13.getMessage(), e13);
                TransferRecord transferRecord6 = this.f15050c;
                a(transferRecord6.f14977a, transferRecord6.f14992p, transferRecord6.f14993q, transferRecord6.f14996t);
                this.f15052e.h(this.f15050c.f14977a, e13);
                this.f15052e.j(this.f15050c.f14977a, TransferState.FAILED);
                return Boolean.FALSE;
            }
        } catch (Exception e14) {
            Exception exc = e14;
            f15047h.c("Upload resulted in an exception. " + exc);
            for (UploadPartTaskMetadata uploadPartTaskMetadata3 : this.f15053f.values()) {
                uploadPartTaskMetadata3.f15056b.cancel(true);
            }
            if (TransferState.PENDING_CANCEL.equals(this.f15050c.f14991o)) {
                TransferStatusUpdater transferStatusUpdater3 = this.f15052e;
                int i12 = this.f15050c.f14977a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater3.j(i12, transferState);
                f15047h.j("Transfer is " + transferState);
                return Boolean.FALSE;
            } else if (TransferState.PENDING_PAUSE.equals(this.f15050c.f14991o)) {
                TransferStatusUpdater transferStatusUpdater4 = this.f15052e;
                int i13 = this.f15050c.f14977a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater4.j(i13, transferState2);
                f15047h.j("Transfer is " + transferState2);
                return Boolean.FALSE;
            } else {
                for (UploadPartTaskMetadata uploadPartTaskMetadata4 : this.f15053f.values()) {
                    TransferState transferState3 = TransferState.WAITING_FOR_NETWORK;
                    if (transferState3.equals(uploadPartTaskMetadata4.f15058d)) {
                        f15047h.j("Individual part is WAITING_FOR_NETWORK.");
                        this.f15052e.j(this.f15050c.f14977a, transferState3);
                        return Boolean.FALSE;
                    }
                }
                try {
                    if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                        f15047h.j("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                        this.f15052e.j(this.f15050c.f14977a, TransferState.WAITING_FOR_NETWORK);
                        return Boolean.FALSE;
                    }
                } catch (TransferUtilityException e15) {
                    f15047h.c("TransferUtilityException: [" + e15 + "]");
                }
                if (RetryUtils.b(exc)) {
                    f15047h.j("Transfer is interrupted. " + exc);
                    this.f15052e.j(this.f15050c.f14977a, TransferState.FAILED);
                    return Boolean.FALSE;
                }
                f15047h.b("Error encountered during multi-part upload: " + this.f15050c.f14977a + " due to " + exc.getMessage(), exc);
                this.f15052e.h(this.f15050c.f14977a, exc);
                this.f15052e.j(this.f15050c.f14977a, TransferState.FAILED);
                return Boolean.FALSE;
            }
        }
    }

    public final Boolean k() {
        PutObjectRequest g11 = g(this.f15050c);
        ProgressListener f11 = this.f15052e.f(this.f15050c.f14977a);
        long length = g11.getFile().length();
        TransferUtility.b(g11);
        g11.setGeneralProgressListener(f11);
        try {
            this.f15049b.c(g11);
            this.f15052e.i(this.f15050c.f14977a, length, length, true);
            this.f15052e.j(this.f15050c.f14977a, TransferState.COMPLETED);
            return Boolean.TRUE;
        } catch (Exception e11) {
            if (TransferState.PENDING_CANCEL.equals(this.f15050c.f14991o)) {
                TransferStatusUpdater transferStatusUpdater = this.f15052e;
                int i11 = this.f15050c.f14977a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater.j(i11, transferState);
                Log log = f15047h;
                log.j("Transfer is " + transferState);
                return Boolean.FALSE;
            } else if (TransferState.PENDING_PAUSE.equals(this.f15050c.f14991o)) {
                TransferStatusUpdater transferStatusUpdater2 = this.f15052e;
                int i12 = this.f15050c.f14977a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater2.j(i12, transferState2);
                Log log2 = f15047h;
                log2.j("Transfer is " + transferState2);
                new ProgressEvent(0).c(32);
                f11.a(new ProgressEvent(0));
                return Boolean.FALSE;
            } else {
                try {
                    if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                        Log log3 = f15047h;
                        log3.j("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                        this.f15052e.j(this.f15050c.f14977a, TransferState.WAITING_FOR_NETWORK);
                        log3.h("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                        new ProgressEvent(0).c(32);
                        f11.a(new ProgressEvent(0));
                        return Boolean.FALSE;
                    }
                } catch (TransferUtilityException e12) {
                    Log log4 = f15047h;
                    log4.c("TransferUtilityException: [" + e12 + "]");
                }
                if (RetryUtils.b(e11)) {
                    Log log5 = f15047h;
                    log5.j("Transfer is interrupted. " + e11);
                    this.f15052e.j(this.f15050c.f14977a, TransferState.FAILED);
                    return Boolean.FALSE;
                }
                Log log6 = f15047h;
                log6.h("Failed to upload: " + this.f15050c.f14977a + " due to " + e11.getMessage());
                this.f15052e.h(this.f15050c.f14977a, e11);
                this.f15052e.j(this.f15050c.f14977a, TransferState.FAILED);
                return Boolean.FALSE;
            }
        }
    }
}
