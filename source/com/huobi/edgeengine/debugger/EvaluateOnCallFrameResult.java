package com.huobi.edgeengine.debugger;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.json.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/huobi/edgeengine/debugger/EvaluateOnCallFrameResult;", "Lcom/facebook/stetho/inspector/jsonrpc/JsonRpcResult;", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "result", "<init>", "(Lorg/json/JSONObject;)V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class EvaluateOnCallFrameResult implements JsonRpcResult {
    @JsonProperty

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f43971a;

    public EvaluateOnCallFrameResult() {
        this((JSONObject) null, 1, (r) null);
    }

    public EvaluateOnCallFrameResult(JSONObject jSONObject) {
        this.f43971a = jSONObject;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EvaluateOnCallFrameResult(JSONObject jSONObject, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : jSONObject);
    }
}
