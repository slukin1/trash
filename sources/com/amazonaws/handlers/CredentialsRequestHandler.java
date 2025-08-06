package com.amazonaws.handlers;

import com.amazonaws.auth.AWSCredentials;

public abstract class CredentialsRequestHandler extends RequestHandler2 {

    /* renamed from: a  reason: collision with root package name */
    public AWSCredentials f14871a;

    public void a(AWSCredentials aWSCredentials) {
        this.f14871a = aWSCredentials;
    }
}
