package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.DateUtils;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractS3ResponseHandler<T> implements HttpResponseHandler<AmazonWebServiceResponse<T>> {

    /* renamed from: a  reason: collision with root package name */
    public static final Log f15139a = LogFactory.b(S3MetadataResponseHandler.class);

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f15140b;

    static {
        HashSet hashSet = new HashSet();
        f15140b = hashSet;
        hashSet.add(HttpHeaders.DATE);
        hashSet.add(HttpHeaders.SERVER);
        hashSet.add("x-amz-request-id");
        hashSet.add("x-amz-id-2");
        hashSet.add("X-Amz-Cf-Id");
        hashSet.add(HttpHeaders.CONNECTION);
    }

    public boolean a() {
        return false;
    }

    public AmazonWebServiceResponse<T> c(HttpResponse httpResponse) {
        AmazonWebServiceResponse<T> amazonWebServiceResponse = new AmazonWebServiceResponse<>();
        HashMap hashMap = new HashMap();
        hashMap.put("AWS_REQUEST_ID", httpResponse.c().get("x-amz-request-id"));
        hashMap.put("HOST_ID", httpResponse.c().get("x-amz-id-2"));
        hashMap.put("CLOUD_FRONT_ID", httpResponse.c().get("X-Amz-Cf-Id"));
        amazonWebServiceResponse.c(new S3ResponseMetadata(hashMap));
        return amazonWebServiceResponse;
    }

    public void d(HttpResponse httpResponse, ObjectMetadata objectMetadata) {
        for (Map.Entry next : httpResponse.c().entrySet()) {
            String str = (String) next.getKey();
            if (str.startsWith("x-amz-meta-")) {
                objectMetadata.addUserMetadata(str.substring(11), (String) next.getValue());
            } else if (f15140b.contains(str)) {
                f15139a.h(String.format("%s is ignored.", new Object[]{str}));
            } else if (str.equalsIgnoreCase(HttpHeaders.LAST_MODIFIED)) {
                try {
                    objectMetadata.setHeader(str, ServiceUtils.d((String) next.getValue()));
                } catch (Exception e11) {
                    Log log = f15139a;
                    log.f("Unable to parse last modified date: " + ((String) next.getValue()), e11);
                }
            } else if (str.equalsIgnoreCase("Content-Length")) {
                try {
                    objectMetadata.setHeader(str, Long.valueOf(Long.parseLong((String) next.getValue())));
                } catch (NumberFormatException e12) {
                    Log log2 = f15139a;
                    log2.f("Unable to parse content length: " + ((String) next.getValue()), e12);
                }
            } else if (str.equalsIgnoreCase(HttpHeaders.ETAG)) {
                objectMetadata.setHeader(str, ServiceUtils.e((String) next.getValue()));
            } else if (str.equalsIgnoreCase(HttpHeaders.EXPIRES)) {
                try {
                    objectMetadata.setHttpExpiresDate(DateUtils.i((String) next.getValue()));
                } catch (Exception e13) {
                    Log log3 = f15139a;
                    log3.f("Unable to parse http expiration date: " + ((String) next.getValue()), e13);
                }
            } else if (str.equalsIgnoreCase("x-amz-expiration")) {
                new ObjectExpirationHeaderHandler().a(objectMetadata, httpResponse);
            } else if (str.equalsIgnoreCase("x-amz-restore")) {
                new ObjectRestoreHeaderHandler().a(objectMetadata, httpResponse);
            } else if (str.equalsIgnoreCase("x-amz-request-charged")) {
                new S3RequesterChargedHeaderHandler().a(objectMetadata, httpResponse);
            } else if (str.equalsIgnoreCase("x-amz-mp-parts-count")) {
                try {
                    objectMetadata.setHeader(str, Integer.valueOf(Integer.parseInt((String) next.getValue())));
                } catch (NumberFormatException e14) {
                    throw new AmazonClientException("Unable to parse part count. Header x-amz-mp-parts-count has corrupted data" + e14.getMessage(), e14);
                }
            } else {
                objectMetadata.setHeader(str, next.getValue());
            }
        }
    }
}
