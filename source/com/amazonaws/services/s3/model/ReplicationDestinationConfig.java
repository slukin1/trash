package com.amazonaws.services.s3.model;

public class ReplicationDestinationConfig {

    /* renamed from: a  reason: collision with root package name */
    public String f15312a;

    /* renamed from: b  reason: collision with root package name */
    public String f15313b;

    public void a(String str) {
        if (str != null) {
            this.f15312a = str;
            return;
        }
        throw new IllegalArgumentException("Bucket name cannot be null");
    }

    public void b(String str) {
        this.f15313b = str;
    }
}
