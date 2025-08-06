package com.huobi.edgeengine.debugger;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.json.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.i;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0006\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/huobi/edgeengine/debugger/V8Response;", "Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcResult;", "", "a", "Lkotlin/i;", "()Z", "isResponse", "", "b", "Ljava/lang/Integer;", "id", "", "c", "Ljava/lang/String;", "method", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "result", "e", "params", "<init>", "()V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class V8Response implements JsonRpcResult {

    /* renamed from: a  reason: collision with root package name */
    public final i f43993a = LazyKt__LazyJVMKt.a(new V8Response$isResponse$2(this));
    @JsonProperty

    /* renamed from: b  reason: collision with root package name */
    public Integer f43994b;
    @JsonProperty

    /* renamed from: c  reason: collision with root package name */
    public String f43995c;
    @JsonProperty

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f43996d;
    @JsonProperty

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f43997e;

    public final boolean a() {
        return ((Boolean) this.f43993a.getValue()).booleanValue();
    }
}
