package com.amazonaws.services.s3.model;

import java.util.Date;

public class S3ObjectSummary {

    /* renamed from: a  reason: collision with root package name */
    public String f15330a;

    /* renamed from: b  reason: collision with root package name */
    public String f15331b;

    /* renamed from: c  reason: collision with root package name */
    public String f15332c;

    /* renamed from: d  reason: collision with root package name */
    public long f15333d;

    /* renamed from: e  reason: collision with root package name */
    public Date f15334e;

    /* renamed from: f  reason: collision with root package name */
    public String f15335f;

    /* renamed from: g  reason: collision with root package name */
    public Owner f15336g;

    public String a() {
        return this.f15331b;
    }

    public void b(String str) {
        this.f15330a = str;
    }

    public void c(String str) {
        this.f15332c = str;
    }

    public void d(String str) {
        this.f15331b = str;
    }

    public void e(Date date) {
        this.f15334e = date;
    }

    public void f(Owner owner) {
        this.f15336g = owner;
    }

    public void g(long j11) {
        this.f15333d = j11;
    }

    public void h(String str) {
        this.f15335f = str;
    }

    public String toString() {
        return "S3ObjectSummary{bucketName='" + this.f15330a + '\'' + ", key='" + this.f15331b + '\'' + ", eTag='" + this.f15332c + '\'' + ", size=" + this.f15333d + ", lastModified=" + this.f15334e + ", storageClass='" + this.f15335f + '\'' + ", owner=" + this.f15336g + '}';
    }
}
