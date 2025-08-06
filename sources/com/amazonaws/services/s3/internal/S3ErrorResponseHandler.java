package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.XpathUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;

public class S3ErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {

    /* renamed from: a  reason: collision with root package name */
    public static final Log f15180a = LogFactory.b(S3ErrorResponseHandler.class);

    public boolean a() {
        return false;
    }

    public final AmazonServiceException.ErrorType c(int i11) {
        return i11 >= 500 ? AmazonServiceException.ErrorType.Service : AmazonServiceException.ErrorType.Client;
    }

    /* renamed from: d */
    public AmazonServiceException b(HttpResponse httpResponse) throws IOException {
        InputStream b11 = httpResponse.b();
        if (b11 == null) {
            return e(httpResponse.f(), httpResponse);
        }
        try {
            String iOUtils = IOUtils.toString(b11);
            try {
                Document d11 = XpathUtils.d(iOUtils);
                String b12 = XpathUtils.b("Error/Message", d11);
                String b13 = XpathUtils.b("Error/Code", d11);
                String b14 = XpathUtils.b("Error/RequestId", d11);
                String b15 = XpathUtils.b("Error/HostId", d11);
                AmazonS3Exception amazonS3Exception = new AmazonS3Exception(b12);
                int e11 = httpResponse.e();
                amazonS3Exception.setStatusCode(e11);
                amazonS3Exception.setErrorType(c(e11));
                amazonS3Exception.setErrorCode(b13);
                amazonS3Exception.setRequestId(b14);
                amazonS3Exception.setExtendedRequestId(b15);
                amazonS3Exception.setCloudFrontId(httpResponse.c().get("X-Amz-Cf-Id"));
                return amazonS3Exception;
            } catch (Exception e12) {
                Log log = f15180a;
                if (log.i()) {
                    log.d("Failed in parsing the response as XML: " + iOUtils, e12);
                }
                return e(iOUtils, httpResponse);
            }
        } catch (IOException e13) {
            if (f15180a.i()) {
                f15180a.d("Failed in reading the error response", e13);
            }
            return e(httpResponse.f(), httpResponse);
        }
    }

    public final AmazonS3Exception e(String str, HttpResponse httpResponse) {
        AmazonS3Exception amazonS3Exception = new AmazonS3Exception(str);
        int e11 = httpResponse.e();
        amazonS3Exception.setErrorCode(e11 + " " + httpResponse.f());
        amazonS3Exception.setStatusCode(e11);
        amazonS3Exception.setErrorType(c(e11));
        Map<String, String> c11 = httpResponse.c();
        amazonS3Exception.setRequestId(c11.get("x-amz-request-id"));
        amazonS3Exception.setExtendedRequestId(c11.get("x-amz-id-2"));
        amazonS3Exception.setCloudFrontId(c11.get("X-Amz-Cf-Id"));
        HashMap hashMap = new HashMap();
        hashMap.put("x-amz-bucket-region", c11.get("x-amz-bucket-region"));
        amazonS3Exception.setAdditionalDetails(hashMap);
        return amazonS3Exception;
    }
}
