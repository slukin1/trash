package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.util.ArrayList;
import java.util.List;

public class PartListing implements S3RequesterChargedResult {

    /* renamed from: b  reason: collision with root package name */
    public String f15283b;

    /* renamed from: c  reason: collision with root package name */
    public String f15284c;

    /* renamed from: d  reason: collision with root package name */
    public String f15285d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f15286e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f15287f;

    /* renamed from: g  reason: collision with root package name */
    public String f15288g;

    /* renamed from: h  reason: collision with root package name */
    public Owner f15289h;

    /* renamed from: i  reason: collision with root package name */
    public Owner f15290i;

    /* renamed from: j  reason: collision with root package name */
    public String f15291j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f15292k;

    /* renamed from: l  reason: collision with root package name */
    public Integer f15293l;

    /* renamed from: m  reason: collision with root package name */
    public List<PartSummary> f15294m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f15295n;

    public List<PartSummary> a() {
        if (this.f15294m == null) {
            this.f15294m = new ArrayList();
        }
        return this.f15294m;
    }

    public void b(String str) {
        this.f15283b = str;
    }

    public void c(String str) {
        this.f15288g = str;
    }

    public void d(Owner owner) {
        this.f15290i = owner;
    }

    public void e(String str) {
        this.f15284c = str;
    }

    public void f(int i11) {
        this.f15286e = Integer.valueOf(i11);
    }

    public void g(int i11) {
        this.f15293l = Integer.valueOf(i11);
    }

    public void h(Owner owner) {
        this.f15289h = owner;
    }

    public void i(int i11) {
        this.f15287f = Integer.valueOf(i11);
    }

    public void j(String str) {
        this.f15291j = str;
    }

    public void k(boolean z11) {
        this.f15292k = z11;
    }

    public void l(String str) {
        this.f15285d = str;
    }

    public void setRequesterCharged(boolean z11) {
        this.f15295n = z11;
    }
}
