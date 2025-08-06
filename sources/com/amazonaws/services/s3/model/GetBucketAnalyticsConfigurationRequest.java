package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetBucketAnalyticsConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;

    /* renamed from: id  reason: collision with root package name */
    private String f15219id;

    public GetBucketAnalyticsConfigurationRequest() {
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getId() {
        return this.f15219id;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setId(String str) {
        this.f15219id = str;
    }

    public GetBucketAnalyticsConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GetBucketAnalyticsConfigurationRequest withId(String str) {
        setId(str);
        return this;
    }

    public GetBucketAnalyticsConfigurationRequest(String str, String str2) {
        this.bucketName = str;
        this.f15219id = str2;
    }
}
