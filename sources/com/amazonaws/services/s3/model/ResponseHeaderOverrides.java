package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ResponseHeaderOverrides extends AmazonWebServiceRequest {

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f15318h = {"response-cache-control", "response-content-disposition", "response-content-encoding", "response-content-language", "response-content-type", "response-expires"};

    /* renamed from: b  reason: collision with root package name */
    public String f15319b;

    /* renamed from: c  reason: collision with root package name */
    public String f15320c;

    /* renamed from: d  reason: collision with root package name */
    public String f15321d;

    /* renamed from: e  reason: collision with root package name */
    public String f15322e;

    /* renamed from: f  reason: collision with root package name */
    public String f15323f;

    /* renamed from: g  reason: collision with root package name */
    public String f15324g;

    public String b() {
        return this.f15322e;
    }

    public String c() {
        return this.f15323f;
    }

    public String d() {
        return this.f15324g;
    }

    public String e() {
        return this.f15320c;
    }

    public String f() {
        return this.f15321d;
    }

    public String getContentType() {
        return this.f15319b;
    }
}
