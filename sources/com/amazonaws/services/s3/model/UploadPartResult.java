package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.SSEResultBase;

public class UploadPartResult extends SSEResultBase implements S3RequesterChargedResult {

    /* renamed from: b  reason: collision with root package name */
    public int f15353b;

    /* renamed from: c  reason: collision with root package name */
    public String f15354c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f15355d;

    public String getETag() {
        return this.f15354c;
    }

    public int getPartNumber() {
        return this.f15353b;
    }

    public void setETag(String str) {
        this.f15354c = str;
    }

    public void setPartNumber(int i11) {
        this.f15353b = i11;
    }

    public void setRequesterCharged(boolean z11) {
        this.f15355d = z11;
    }
}
