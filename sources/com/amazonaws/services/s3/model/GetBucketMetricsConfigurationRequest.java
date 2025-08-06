package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetBucketMetricsConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;

    /* renamed from: id  reason: collision with root package name */
    private String f15222id;

    public GetBucketMetricsConfigurationRequest() {
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getId() {
        return this.f15222id;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setId(String str) {
        this.f15222id = str;
    }

    public GetBucketMetricsConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GetBucketMetricsConfigurationRequest withId(String str) {
        setId(str);
        return this;
    }

    public GetBucketMetricsConfigurationRequest(String str, String str2) {
        this.bucketName = str;
        this.f15222id = str2;
    }
}
