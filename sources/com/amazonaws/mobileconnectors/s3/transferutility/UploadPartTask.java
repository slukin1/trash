package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AbortedException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transferutility.UploadTask;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class UploadPartTask implements Callable<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public static final Log f15038g = LogFactory.b(UploadPartTask.class);

    /* renamed from: b  reason: collision with root package name */
    public final UploadTask.UploadPartTaskMetadata f15039b;

    /* renamed from: c  reason: collision with root package name */
    public final UploadPartTaskProgressListener f15040c;

    /* renamed from: d  reason: collision with root package name */
    public final UploadPartRequest f15041d;

    /* renamed from: e  reason: collision with root package name */
    public final AmazonS3 f15042e;

    /* renamed from: f  reason: collision with root package name */
    public final TransferDBUtil f15043f;

    public class UploadPartTaskProgressListener implements ProgressListener {

        /* renamed from: a  reason: collision with root package name */
        public final UploadTask.UploadTaskProgressListener f15044a;

        /* renamed from: b  reason: collision with root package name */
        public long f15045b;

        public UploadPartTaskProgressListener(UploadTask.UploadTaskProgressListener uploadTaskProgressListener) {
            this.f15044a = uploadTaskProgressListener;
        }

        public void a(ProgressEvent progressEvent) {
            if (32 == progressEvent.b()) {
                UploadPartTask.f15038g.h("Reset Event triggered. Resetting the bytesCurrent to 0.");
                this.f15045b = 0;
            } else {
                this.f15045b += progressEvent.a();
            }
            this.f15044a.b(UploadPartTask.this.f15041d.getPartNumber(), this.f15045b);
        }
    }

    public UploadPartTask(UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata, UploadTask.UploadTaskProgressListener uploadTaskProgressListener, UploadPartRequest uploadPartRequest, AmazonS3 amazonS3, TransferDBUtil transferDBUtil) {
        this.f15039b = uploadPartTaskMetadata;
        this.f15040c = new UploadPartTaskProgressListener(uploadTaskProgressListener);
        this.f15041d = uploadPartRequest;
        this.f15042e = amazonS3;
        this.f15043f = transferDBUtil;
    }

    /* renamed from: c */
    public Boolean call() throws Exception {
        this.f15039b.f15058d = TransferState.IN_PROGRESS;
        this.f15041d.setGeneralProgressListener(this.f15040c);
        int i11 = 1;
        while (true) {
            try {
                UploadPartResult a11 = this.f15042e.a(this.f15041d);
                f(TransferState.PART_COMPLETED);
                this.f15043f.l(this.f15041d.getId(), a11.getETag());
                return Boolean.TRUE;
            } catch (AbortedException unused) {
                f15038g.h("Upload part aborted.");
                e();
                return Boolean.FALSE;
            } catch (Exception e11) {
                Log log = f15038g;
                log.c("Unexpected error occurred: " + e11);
                e();
                try {
                    if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                        log.j("Thread: [" + Thread.currentThread().getId() + "]: Network wasn't available.");
                        UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata = this.f15039b;
                        TransferState transferState = TransferState.WAITING_FOR_NETWORK;
                        uploadPartTaskMetadata.f15058d = transferState;
                        this.f15043f.n(this.f15041d.getId(), transferState);
                        log.j("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                        return Boolean.FALSE;
                    }
                } catch (TransferUtilityException e12) {
                    Log log2 = f15038g;
                    log2.c("TransferUtilityException: [" + e12 + "]");
                }
                if (i11 < 3) {
                    long d11 = d(i11);
                    Log log3 = f15038g;
                    log3.j("Retrying in " + d11 + " ms.");
                    TimeUnit.MILLISECONDS.sleep(d11);
                    log3.d("Retry attempt: " + i11, e11);
                    i11++;
                } else {
                    f(TransferState.FAILED);
                    f15038g.b("Encountered error uploading part ", e11);
                    throw e11;
                }
            }
        }
    }

    public final long d(int i11) {
        return (((long) (1 << i11)) * 1000) + ((long) (Math.random() * 1000.0d));
    }

    public final void e() {
        ProgressEvent progressEvent = new ProgressEvent(0);
        progressEvent.c(32);
        this.f15040c.a(progressEvent);
    }

    public final void f(TransferState transferState) {
        this.f15039b.f15058d = transferState;
        this.f15043f.n(this.f15041d.getId(), transferState);
    }
}
