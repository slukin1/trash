package com.amazonaws.services.s3;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.FileDeletionEvent;
import com.amazonaws.services.s3.internal.PartCreationEvent;
import com.amazonaws.services.s3.internal.S3DirectSpi;
import com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class UploadObjectObserver {

    /* renamed from: a  reason: collision with root package name */
    public final List<Future<UploadPartResult>> f15130a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public UploadObjectRequest f15131b;

    /* renamed from: c  reason: collision with root package name */
    public String f15132c;

    /* renamed from: d  reason: collision with root package name */
    public S3DirectSpi f15133d;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f15134e;

    public <X extends AmazonWebServiceRequest> X a(X x11, String str) {
        x11.getRequestClientOptions().a(str);
        return x11;
    }

    public UploadPartRequest b(PartCreationEvent partCreationEvent, File file) {
        return new UploadPartRequest().withBucketName(this.f15131b.getBucketName()).withFile(file).withKey(this.f15131b.getKey()).withPartNumber(partCreationEvent.c()).withPartSize(file.length()).withLastPart(partCreationEvent.d()).withUploadId(this.f15132c).withObjectMetadata(this.f15131b.getUploadPartMetadata());
    }

    public void c(PartCreationEvent partCreationEvent) {
        final File b11 = partCreationEvent.b();
        final UploadPartRequest b12 = b(partCreationEvent, b11);
        final OnFileDelete a11 = partCreationEvent.a();
        a(b12, AmazonS3EncryptionClient.f15120x);
        this.f15130a.add(this.f15134e.submit(new Callable<UploadPartResult>() {
            /* renamed from: a */
            public UploadPartResult call() {
                try {
                    UploadPartResult d11 = UploadObjectObserver.this.d(b12);
                    if (!b11.delete()) {
                        Log b11 = LogFactory.b(getClass());
                        b11.h("Ignoring failure to delete file " + b11 + " which has already been uploaded");
                    } else {
                        OnFileDelete onFileDelete = a11;
                        if (onFileDelete != null) {
                            onFileDelete.a((FileDeletionEvent) null);
                        }
                    }
                    return d11;
                } catch (Throwable th2) {
                    if (b11.delete()) {
                        OnFileDelete onFileDelete2 = a11;
                        if (onFileDelete2 != null) {
                            onFileDelete2.a((FileDeletionEvent) null);
                        }
                    } else {
                        Log b12 = LogFactory.b(getClass());
                        b12.h("Ignoring failure to delete file " + b11 + " which has already been uploaded");
                    }
                    throw th2;
                }
            }
        }));
    }

    public UploadPartResult d(UploadPartRequest uploadPartRequest) {
        return this.f15133d.a(uploadPartRequest);
    }
}
