package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.s3.model.AmazonS3Exception;

public class CompleteMultipartUploadRetryCondition implements RetryPolicy.RetryCondition {

    /* renamed from: b  reason: collision with root package name */
    public final int f15141b;

    public CompleteMultipartUploadRetryCondition() {
        this(3);
    }

    public boolean a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11) {
        if (!(amazonClientException instanceof AmazonS3Exception) || !b((AmazonS3Exception) amazonClientException) || i11 >= this.f15141b) {
            return false;
        }
        return true;
    }

    public boolean b(AmazonS3Exception amazonS3Exception) {
        if (amazonS3Exception == null || amazonS3Exception.getErrorCode() == null || amazonS3Exception.getErrorMessage() == null || !amazonS3Exception.getErrorCode().contains("InternalError") || !amazonS3Exception.getErrorMessage().contains("Please try again.")) {
            return false;
        }
        return true;
    }

    public CompleteMultipartUploadRetryCondition(int i11) {
        this.f15141b = i11;
    }
}
