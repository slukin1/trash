package com.amazonaws.internal;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class StaticCredentialsProvider implements AWSCredentialsProvider {

    /* renamed from: a  reason: collision with root package name */
    public final AWSCredentials f14919a;

    public StaticCredentialsProvider(AWSCredentials aWSCredentials) {
        this.f14919a = aWSCredentials;
    }

    public AWSCredentials a() {
        return this.f14919a;
    }
}
