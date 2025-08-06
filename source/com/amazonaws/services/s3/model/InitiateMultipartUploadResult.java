package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.SSEResultBase;

public class InitiateMultipartUploadResult extends SSEResultBase {

    /* renamed from: b  reason: collision with root package name */
    public String f15229b;

    /* renamed from: c  reason: collision with root package name */
    public String f15230c;

    /* renamed from: d  reason: collision with root package name */
    public String f15231d;

    public String a() {
        return this.f15231d;
    }

    public void b(String str) {
        this.f15231d = str;
    }

    public void setBucketName(String str) {
        this.f15229b = str;
    }

    public void setKey(String str) {
        this.f15230c = str;
    }
}
