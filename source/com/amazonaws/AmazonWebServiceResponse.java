package com.amazonaws;

public class AmazonWebServiceResponse<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f14770a;

    /* renamed from: b  reason: collision with root package name */
    public ResponseMetadata f14771b;

    public String a() {
        ResponseMetadata responseMetadata = this.f14771b;
        if (responseMetadata == null) {
            return null;
        }
        return responseMetadata.a();
    }

    public T b() {
        return this.f14770a;
    }

    public void c(ResponseMetadata responseMetadata) {
        this.f14771b = responseMetadata;
    }

    public void d(T t11) {
        this.f14770a = t11;
    }
}
