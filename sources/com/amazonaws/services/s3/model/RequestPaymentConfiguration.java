package com.amazonaws.services.s3.model;

public class RequestPaymentConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public Payer f15317a;

    public enum Payer {
        Requester,
        BucketOwner
    }

    public RequestPaymentConfiguration(Payer payer) {
        this.f15317a = payer;
    }
}
