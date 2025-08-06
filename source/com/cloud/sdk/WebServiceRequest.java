package com.cloud.sdk;

import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class WebServiceRequest implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static final WebServiceRequest f64712c = new a();

    /* renamed from: b  reason: collision with root package name */
    public final RequestClientOptions f64713b = new RequestClientOptions();

    public static class a extends WebServiceRequest {
        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return WebServiceRequest.super.clone();
        }
    }

    /* renamed from: b */
    public WebServiceRequest clone() {
        try {
            return (WebServiceRequest) super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e11);
        }
    }
}
