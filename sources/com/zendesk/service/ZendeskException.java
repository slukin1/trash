package com.zendesk.service;

import com.iproov.sdk.bridge.OptionsBridge;
import lz.a;
import lz.b;
import mz.e;
import mz.f;
import retrofit2.Response;

public class ZendeskException extends Exception {
    private final a errorResponse;

    public ZendeskException(Throwable th2) {
        super(th2);
        this.errorResponse = ErrorResponseAdapter.c(th2);
    }

    private static String message(Response response) {
        StringBuilder sb2 = new StringBuilder();
        if (response != null) {
            if (f.c(response.message())) {
                sb2.append(response.message());
            } else {
                sb2.append(response.code());
            }
        }
        return sb2.toString();
    }

    public a errorResponse() {
        return this.errorResponse;
    }

    public String toString() {
        a aVar = this.errorResponse;
        return String.format("ZendeskException{details=%s,errorResponse=%s,cause=%s}", new Object[]{super.toString(), aVar == null ? OptionsBridge.NULL_VALUE : aVar.getReason(), e.a(getCause())});
    }

    public ZendeskException(String str) {
        super(str);
        this.errorResponse = new ErrorResponseAdapter(getMessage());
    }

    public ZendeskException(a aVar) {
        super(aVar.getReason());
        this.errorResponse = aVar;
    }

    public ZendeskException(Response response) {
        super(message(response));
        this.errorResponse = b.c(response);
    }
}
