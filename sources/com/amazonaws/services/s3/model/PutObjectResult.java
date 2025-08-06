package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.SSEResultBase;
import java.util.Date;

public class PutObjectResult extends SSEResultBase implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult {

    /* renamed from: b  reason: collision with root package name */
    public String f15300b;

    /* renamed from: c  reason: collision with root package name */
    public String f15301c;

    /* renamed from: d  reason: collision with root package name */
    public Date f15302d;

    /* renamed from: e  reason: collision with root package name */
    public String f15303e;

    /* renamed from: f  reason: collision with root package name */
    public String f15304f;

    /* renamed from: g  reason: collision with root package name */
    public ObjectMetadata f15305g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15306h;

    public void a(String str) {
        this.f15304f = str;
    }

    public void b(ObjectMetadata objectMetadata) {
        this.f15305g = objectMetadata;
    }

    public void setETag(String str) {
        this.f15301c = str;
    }

    public void setExpirationTime(Date date) {
        this.f15302d = date;
    }

    public void setExpirationTimeRuleId(String str) {
        this.f15303e = str;
    }

    public void setRequesterCharged(boolean z11) {
        this.f15306h = z11;
    }

    public void setVersionId(String str) {
        this.f15300b = str;
    }
}
