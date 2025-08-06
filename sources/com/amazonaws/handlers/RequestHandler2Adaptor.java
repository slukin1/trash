package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.TimingInfo;

final class RequestHandler2Adaptor extends RequestHandler2 {

    /* renamed from: a  reason: collision with root package name */
    public final RequestHandler f14872a;

    public RequestHandler2Adaptor(RequestHandler requestHandler) {
        if (requestHandler != null) {
            this.f14872a = requestHandler;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void afterError(Request<?> request, Response<?> response, Exception exc) {
        this.f14872a.a(request, exc);
    }

    public void afterResponse(Request<?> request, Response<?> response) {
        Object obj;
        TimingInfo timingInfo = null;
        AWSRequestMetrics c11 = request == null ? null : request.c();
        if (response == null) {
            obj = null;
        } else {
            obj = response.a();
        }
        if (c11 != null) {
            timingInfo = c11.c();
        }
        this.f14872a.c(request, obj, timingInfo);
    }

    public void beforeRequest(Request<?> request) {
        this.f14872a.b(request);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RequestHandler2Adaptor)) {
            return false;
        }
        return this.f14872a.equals(((RequestHandler2Adaptor) obj).f14872a);
    }

    public int hashCode() {
        return this.f14872a.hashCode();
    }
}
