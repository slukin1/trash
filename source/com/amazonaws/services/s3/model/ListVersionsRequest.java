package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ListVersionsRequest extends AmazonWebServiceRequest {

    /* renamed from: b  reason: collision with root package name */
    public String f15251b;

    /* renamed from: c  reason: collision with root package name */
    public String f15252c;

    /* renamed from: d  reason: collision with root package name */
    public String f15253d;

    /* renamed from: e  reason: collision with root package name */
    public String f15254e;

    /* renamed from: f  reason: collision with root package name */
    public String f15255f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f15256g;

    /* renamed from: h  reason: collision with root package name */
    public String f15257h;

    public ListVersionsRequest() {
    }

    public void b(String str) {
        this.f15255f = str;
    }

    public void c(String str) {
        this.f15257h = str;
    }

    public void d(String str) {
        this.f15253d = str;
    }

    public void e(String str) {
        this.f15252c = str;
    }

    public void f(String str) {
        this.f15254e = str;
    }

    public ListVersionsRequest g(String str) {
        c(str);
        return this;
    }

    public void setBucketName(String str) {
        this.f15251b = str;
    }

    public void setMaxResults(Integer num) {
        this.f15256g = num;
    }

    public ListVersionsRequest(String str, String str2, String str3, String str4, String str5, Integer num) {
        setBucketName(str);
        e(str2);
        d(str3);
        f(str4);
        b(str5);
        setMaxResults(num);
    }
}
