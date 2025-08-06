package com.zendesk.service;

import lz.a;
import lz.b;
import retrofit2.HttpException;

public class ErrorResponseAdapter implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String f53459a;

    public ErrorResponseAdapter() {
        this("");
    }

    public static a c(Throwable th2) {
        if (th2 instanceof ZendeskException) {
            return ((ZendeskException) th2).errorResponse();
        }
        if (th2 instanceof HttpException) {
            return b.d(th2);
        }
        return new ErrorResponseAdapter(th2.getMessage());
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public String getReason() {
        return this.f53459a;
    }

    public String getResponseBody() {
        return this.f53459a;
    }

    public String getResponseBodyType() {
        return "text/plain; charset=UTF8";
    }

    public int getStatus() {
        return -1;
    }

    public String getUrl() {
        return "";
    }

    public ErrorResponseAdapter(String str) {
        this.f53459a = str;
    }
}
