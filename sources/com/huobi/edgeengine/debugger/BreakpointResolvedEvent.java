package com.huobi.edgeengine.debugger;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.json.annotation.JsonProperty;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/huobi/edgeengine/debugger/BreakpointResolvedEvent;", "Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcResult;", "", "a", "Ljava/lang/String;", "breakpointId", "Lcom/huobi/edgeengine/debugger/LocationResponse;", "b", "Lcom/huobi/edgeengine/debugger/LocationResponse;", "location", "<init>", "()V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class BreakpointResolvedEvent implements JsonRpcResult {
    @JsonProperty

    /* renamed from: a  reason: collision with root package name */
    public String f43962a;
    @JsonProperty

    /* renamed from: b  reason: collision with root package name */
    public LocationResponse f43963b;
}
