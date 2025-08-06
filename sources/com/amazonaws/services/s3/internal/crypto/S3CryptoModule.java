package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;

@Deprecated
public abstract class S3CryptoModule<T> {
    public abstract void a(AbortMultipartUploadRequest abortMultipartUploadRequest);

    public abstract CompleteMultipartUploadResult b(CompleteMultipartUploadRequest completeMultipartUploadRequest);

    public abstract S3Object c(GetObjectRequest getObjectRequest);

    public abstract InitiateMultipartUploadResult d(InitiateMultipartUploadRequest initiateMultipartUploadRequest);

    public abstract PutObjectResult e(PutObjectRequest putObjectRequest);

    public abstract UploadPartResult f(UploadPartRequest uploadPartRequest);
}
