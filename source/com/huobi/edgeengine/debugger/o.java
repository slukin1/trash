package com.huobi.edgeengine.debugger;

import com.facebook.stetho.json.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/huobi/edgeengine/debugger/o;", "", "", "a", "Ljava/lang/String;", "scriptId", "b", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class o {
    @JsonProperty

    /* renamed from: a  reason: collision with root package name */
    public final String f44046a;
    @JsonProperty

    /* renamed from: b  reason: collision with root package name */
    public final String f44047b;

    public o(String str, String str2) {
        this.f44046a = str;
        this.f44047b = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(String str, String str2, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? MappersKt.d(str) : str2);
    }
}
