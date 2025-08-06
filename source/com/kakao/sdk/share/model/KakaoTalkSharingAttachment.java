package com.kakao.sdk.share.model;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u0019\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/kakao/sdk/share/model/KakaoTalkSharingAttachment;", "", "", "lv", "Ljava/lang/String;", "getLv", "()Ljava/lang/String;", "av", "getAv", "ak", "getAk", "Lcom/google/gson/JsonObject;", "P", "Lcom/google/gson/JsonObject;", "getP", "()Lcom/google/gson/JsonObject;", "C", "getC", "", "ti", "J", "getTi", "()J", "ta", "getTa", "extras", "getExtras", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;JLcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;)V", "share_release"}, k = 1, mv = {1, 6, 0})
public final class KakaoTalkSharingAttachment {
    private final JsonObject C;
    private final JsonObject P;

    /* renamed from: ak  reason: collision with root package name */
    private final String f25145ak;

    /* renamed from: av  reason: collision with root package name */
    private final String f25146av;
    private final JsonObject extras;

    /* renamed from: lv  reason: collision with root package name */
    private final String f25147lv;

    /* renamed from: ta  reason: collision with root package name */
    private final JsonObject f25148ta;

    /* renamed from: ti  reason: collision with root package name */
    private final long f25149ti;

    public KakaoTalkSharingAttachment(String str, String str2, String str3, JsonObject jsonObject, JsonObject jsonObject2, long j11, JsonObject jsonObject3, JsonObject jsonObject4) {
        this.f25147lv = str;
        this.f25146av = str2;
        this.f25145ak = str3;
        this.P = jsonObject;
        this.C = jsonObject2;
        this.f25149ti = j11;
        this.f25148ta = jsonObject3;
        this.extras = jsonObject4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KakaoTalkSharingAttachment(String str, String str2, String str3, JsonObject jsonObject, JsonObject jsonObject2, long j11, JsonObject jsonObject3, JsonObject jsonObject4, int i11, r rVar) {
        this((i11 & 1) != 0 ? "4.0" : str, (i11 & 2) != 0 ? "4.0" : str2, str3, (i11 & 8) != 0 ? null : jsonObject, (i11 & 16) != 0 ? null : jsonObject2, j11, (i11 & 64) != 0 ? null : jsonObject3, jsonObject4);
    }
}
