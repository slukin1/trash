package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.List;

public class MultipartUploadListing {

    /* renamed from: a  reason: collision with root package name */
    public String f15268a;

    /* renamed from: b  reason: collision with root package name */
    public String f15269b;

    /* renamed from: c  reason: collision with root package name */
    public String f15270c;

    /* renamed from: d  reason: collision with root package name */
    public String f15271d;

    /* renamed from: e  reason: collision with root package name */
    public String f15272e;

    /* renamed from: f  reason: collision with root package name */
    public int f15273f;

    /* renamed from: g  reason: collision with root package name */
    public String f15274g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15275h;

    /* renamed from: i  reason: collision with root package name */
    public String f15276i;

    /* renamed from: j  reason: collision with root package name */
    public String f15277j;

    /* renamed from: k  reason: collision with root package name */
    public List<MultipartUpload> f15278k;

    /* renamed from: l  reason: collision with root package name */
    public List<String> f15279l = new ArrayList();

    public List<String> a() {
        return this.f15279l;
    }

    public List<MultipartUpload> b() {
        if (this.f15278k == null) {
            this.f15278k = new ArrayList();
        }
        return this.f15278k;
    }

    public void c(String str) {
        this.f15268a = str;
    }

    public void d(String str) {
        this.f15270c = str;
    }

    public void e(String str) {
        this.f15274g = str;
    }

    public void f(String str) {
        this.f15269b = str;
    }

    public void g(int i11) {
        this.f15273f = i11;
    }

    public void h(String str) {
        this.f15276i = str;
    }

    public void i(String str) {
        this.f15277j = str;
    }

    public void j(String str) {
        this.f15271d = str;
    }

    public void k(boolean z11) {
        this.f15275h = z11;
    }

    public void l(String str) {
        this.f15272e = str;
    }
}
