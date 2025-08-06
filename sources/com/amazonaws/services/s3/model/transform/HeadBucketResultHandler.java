package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.internal.AbstractS3ResponseHandler;
import com.amazonaws.services.s3.model.HeadBucketResult;

public class HeadBucketResultHandler extends AbstractS3ResponseHandler<HeadBucketResult> {
    /* renamed from: e */
    public AmazonWebServiceResponse<HeadBucketResult> b(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse<HeadBucketResult> amazonWebServiceResponse = new AmazonWebServiceResponse<>();
        HeadBucketResult headBucketResult = new HeadBucketResult();
        headBucketResult.b(httpResponse.c().get("x-amz-bucket-region"));
        amazonWebServiceResponse.d(headBucketResult);
        return amazonWebServiceResponse;
    }
}
