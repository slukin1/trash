package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import java.io.Serializable;

public class SetBucketMetricsConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private MetricsConfiguration metricsConfiguration;

    public SetBucketMetricsConfigurationRequest() {
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public MetricsConfiguration getMetricsConfiguration() {
        return this.metricsConfiguration;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setMetricsConfiguration(MetricsConfiguration metricsConfiguration2) {
        this.metricsConfiguration = metricsConfiguration2;
    }

    public SetBucketMetricsConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public SetBucketMetricsConfigurationRequest withMetricsConfiguration(MetricsConfiguration metricsConfiguration2) {
        setMetricsConfiguration(metricsConfiguration2);
        return this;
    }

    public SetBucketMetricsConfigurationRequest(String str, MetricsConfiguration metricsConfiguration2) {
        this.bucketName = str;
        this.metricsConfiguration = metricsConfiguration2;
    }
}
