package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public class AnalyticsConfiguration implements Serializable {
    private AnalyticsFilter filter;

    /* renamed from: id  reason: collision with root package name */
    private String f15369id;
    private StorageClassAnalysis storageClassAnalysis;

    public AnalyticsFilter getFilter() {
        return this.filter;
    }

    public String getId() {
        return this.f15369id;
    }

    public StorageClassAnalysis getStorageClassAnalysis() {
        return this.storageClassAnalysis;
    }

    public void setFilter(AnalyticsFilter analyticsFilter) {
        this.filter = analyticsFilter;
    }

    public void setId(String str) {
        this.f15369id = str;
    }

    public void setStorageClassAnalysis(StorageClassAnalysis storageClassAnalysis2) {
        this.storageClassAnalysis = storageClassAnalysis2;
    }

    public AnalyticsConfiguration withFilter(AnalyticsFilter analyticsFilter) {
        setFilter(analyticsFilter);
        return this;
    }

    public AnalyticsConfiguration withId(String str) {
        setId(str);
        return this;
    }

    public AnalyticsConfiguration withStorageClassAnalysis(StorageClassAnalysis storageClassAnalysis2) {
        setStorageClassAnalysis(storageClassAnalysis2);
        return this;
    }
}
