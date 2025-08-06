package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

public class S3ObjectResponseHandler extends AbstractS3ResponseHandler<S3Object> {
    public boolean a() {
        return true;
    }

    /* renamed from: e */
    public AmazonWebServiceResponse<S3Object> b(HttpResponse httpResponse) throws Exception {
        S3Object s3Object = new S3Object();
        AmazonWebServiceResponse<S3Object> c11 = c(httpResponse);
        if (httpResponse.c().get("x-amz-website-redirect-location") != null) {
            s3Object.setRedirectLocation(httpResponse.c().get("x-amz-website-redirect-location"));
        }
        if (httpResponse.c().get("x-amz-request-charged") != null) {
            s3Object.setRequesterCharged(true);
        }
        if (httpResponse.c().get("x-amz-tagging-count") != null) {
            s3Object.setTaggingCount(Integer.valueOf(Integer.parseInt(httpResponse.c().get("x-amz-tagging-count"))));
        }
        d(httpResponse, s3Object.getObjectMetadata());
        s3Object.setObjectContent(new S3ObjectInputStream(httpResponse.b()));
        c11.d(s3Object);
        return c11;
    }
}
