package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ListObjectsRequest extends AmazonWebServiceRequest {

    /* renamed from: b  reason: collision with root package name */
    public String f15233b;

    /* renamed from: c  reason: collision with root package name */
    public String f15234c;

    /* renamed from: d  reason: collision with root package name */
    public String f15235d;

    /* renamed from: e  reason: collision with root package name */
    public String f15236e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f15237f;

    /* renamed from: g  reason: collision with root package name */
    public String f15238g;

    public ListObjectsRequest() {
    }

    public void b(String str) {
        this.f15236e = str;
    }

    public void c(String str) {
        this.f15238g = str;
    }

    public void d(Integer num) {
        this.f15237f = num;
    }

    public void e(String str) {
        this.f15234c = str;
    }

    public ListObjectsRequest f(String str) {
        c(str);
        return this;
    }

    public void setBucketName(String str) {
        this.f15233b = str;
    }

    public void setMarker(String str) {
        this.f15235d = str;
    }

    public ListObjectsRequest(String str, String str2, String str3, String str4, Integer num) {
        setBucketName(str);
        e(str2);
        setMarker(str3);
        b(str4);
        d(num);
    }
}
