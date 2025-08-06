package com.facebook.stetho.inspector.jsonrpc;

import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;

public class JsonRpcException extends Exception {
    private final JsonRpcError mErrorMessage;

    public JsonRpcException(JsonRpcError jsonRpcError) {
        super(jsonRpcError.code + l.f34627b + jsonRpcError.message);
        this.mErrorMessage = (JsonRpcError) Util.throwIfNull(jsonRpcError);
    }

    public JsonRpcError getErrorMessage() {
        return this.mErrorMessage;
    }
}
