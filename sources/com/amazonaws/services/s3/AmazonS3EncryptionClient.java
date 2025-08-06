package com.amazonaws.services.s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.internal.crypto.S3CryptoModule;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.EncryptedInitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.amazonaws.util.VersionInfoUtils;

@Deprecated
public class AmazonS3EncryptionClient extends AmazonS3Client {

    /* renamed from: x  reason: collision with root package name */
    public static final String f15120x = (AmazonS3EncryptionClient.class.getName() + "/" + VersionInfoUtils.c());

    /* renamed from: w  reason: collision with root package name */
    public final S3CryptoModule<?> f15121w;

    public UploadPartResult a(UploadPartRequest uploadPartRequest) throws AmazonClientException, AmazonServiceException {
        return this.f15121w.f(uploadPartRequest);
    }

    public S3Object b(GetObjectRequest getObjectRequest) {
        return this.f15121w.c(getObjectRequest);
    }

    public PutObjectResult c(PutObjectRequest putObjectRequest) {
        return this.f15121w.e(putObjectRequest.clone());
    }

    public CompleteMultipartUploadResult d(CompleteMultipartUploadRequest completeMultipartUploadRequest) {
        return this.f15121w.b(completeMultipartUploadRequest);
    }

    public InitiateMultipartUploadResult e(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        if (initiateMultipartUploadRequest instanceof EncryptedInitiateMultipartUploadRequest ? ((EncryptedInitiateMultipartUploadRequest) initiateMultipartUploadRequest).isCreateEncryptionMaterial() : true) {
            return this.f15121w.d(initiateMultipartUploadRequest);
        }
        return super.e(initiateMultipartUploadRequest);
    }

    public void f(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        this.f15121w.a(abortMultipartUploadRequest);
    }
}
