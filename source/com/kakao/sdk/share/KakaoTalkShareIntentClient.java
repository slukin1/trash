package com.kakao.sdk.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.gson.JsonObject;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationInfo;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.ContextInfo;
import com.kakao.sdk.common.util.IntentResolveClient;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.share.model.KakaoTalkSharingAttachment;
import com.kakao.sdk.share.model.SharingResult;
import com.kakao.sdk.share.model.ValidationResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0016B%\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001b\u0012\b\b\u0002\u0010$\u001a\u00020 ¢\u0006\u0004\b%\u0010&JB\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0007J\u0010\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rH\u0002J.\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J&\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002R\u0017\u0010\u001a\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "", "Landroid/content/Context;", "context", "Lcom/kakao/sdk/share/model/ValidationResult;", "response", "", "", "serverCallbackArgs", "appKey", "appVer", "Lcom/kakao/sdk/share/model/SharingResult;", "d", "Landroid/net/Uri$Builder;", "kotlin.jvm.PlatformType", "f", "", "b", "Lcom/google/gson/JsonObject;", "extras", "c", "Lcom/kakao/sdk/common/model/ContextInfo;", "a", "Lcom/kakao/sdk/common/model/ContextInfo;", "getContextInfo", "()Lcom/kakao/sdk/common/model/ContextInfo;", "contextInfo", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "getApplicationInfo", "()Lcom/kakao/sdk/common/model/ApplicationInfo;", "applicationInfo", "Lcom/kakao/sdk/common/util/IntentResolveClient;", "Lcom/kakao/sdk/common/util/IntentResolveClient;", "getIntentResolveClient", "()Lcom/kakao/sdk/common/util/IntentResolveClient;", "intentResolveClient", "<init>", "(Lcom/kakao/sdk/common/model/ContextInfo;Lcom/kakao/sdk/common/model/ApplicationInfo;Lcom/kakao/sdk/common/util/IntentResolveClient;)V", "share_release"}, k = 1, mv = {1, 6, 0})
public final class KakaoTalkShareIntentClient {

    /* renamed from: d  reason: collision with root package name */
    public static final a f25127d = new a((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static final i<KakaoTalkShareIntentClient> f25128e = LazyKt__LazyJVMKt.a(KakaoTalkShareIntentClient$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final ContextInfo f25129a;

    /* renamed from: b  reason: collision with root package name */
    public final ApplicationInfo f25130b;

    /* renamed from: c  reason: collision with root package name */
    public final IntentResolveClient f25131c;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/kakao/sdk/share/KakaoTalkShareIntentClient$a;", "", "Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "instance$delegate", "Lkotlin/i;", "a", "()Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "instance", "<init>", "()V", "share_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final KakaoTalkShareIntentClient a() {
            return (KakaoTalkShareIntentClient) KakaoTalkShareIntentClient.f25128e.getValue();
        }
    }

    public KakaoTalkShareIntentClient() {
        this((ContextInfo) null, (ApplicationInfo) null, (IntentResolveClient) null, 7, (r) null);
    }

    public KakaoTalkShareIntentClient(ContextInfo contextInfo, ApplicationInfo applicationInfo, IntentResolveClient intentResolveClient) {
        this.f25129a = contextInfo;
        this.f25130b = applicationInfo;
        this.f25131c = intentResolveClient;
    }

    public static /* synthetic */ SharingResult e(KakaoTalkShareIntentClient kakaoTalkShareIntentClient, Context context, ValidationResult validationResult, Map map, String str, String str2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str = kakaoTalkShareIntentClient.f25130b.d();
        }
        String str3 = str;
        if ((i11 & 16) != 0) {
            str2 = kakaoTalkShareIntentClient.f25129a.a();
        }
        return kakaoTalkShareIntentClient.d(context, validationResult, map, str3, str2);
    }

    public final int b(String str, ValidationResult validationResult, Map<String, String> map) {
        return com.kakao.sdk.common.util.a.f25105a.c(new KakaoTalkSharingAttachment((String) null, (String) null, str, validationResult.d().get("P").getAsJsonObject(), validationResult.d().get("C").getAsJsonObject(), validationResult.c(), validationResult.b(), c(this.f25129a.getExtras(), map), 3, (r) null)).length();
    }

    public final JsonObject c(JsonObject jsonObject, Map<String, String> map) {
        JsonObject deepCopy = jsonObject.deepCopy();
        if (map == null) {
            return deepCopy;
        }
        deepCopy.addProperty("lcba", com.kakao.sdk.common.util.a.f25105a.c(map));
        return deepCopy;
    }

    public final SharingResult d(Context context, ValidationResult validationResult, Map<String, String> map, String str, String str2) {
        int b11 = b(str, validationResult, map);
        if (b11 <= 10240) {
            Uri build = f().appendQueryParameter("linkver", "4.0").appendQueryParameter("appkey", str).appendQueryParameter("appver", str2).appendQueryParameter("template_id", String.valueOf(validationResult.c())).appendQueryParameter("template_args", String.valueOf(validationResult.b())).appendQueryParameter("template_json", validationResult.d().toString()).appendQueryParameter("extras", c(this.f25129a.getExtras(), map).toString()).build();
            SdkLog.f25100d.d(build);
            Intent c11 = this.f25131c.c(context, new Intent("android.intent.action.SEND", build).addFlags(335544320));
            if (c11 != null) {
                com.kakao.sdk.common.util.a aVar = com.kakao.sdk.common.util.a.f25105a;
                return new SharingResult(c11, (Map) aVar.a(String.valueOf(validationResult.e()), Map.class), (Map) aVar.a(String.valueOf(validationResult.a()), Map.class));
            }
            throw new ClientError(ClientErrorCause.NotSupported, "Kakaotalk not installed");
        }
        ClientErrorCause clientErrorCause = ClientErrorCause.BadParameter;
        throw new ClientError(clientErrorCause, "KakaoTalk Share intent size is " + b11 + " bytes. It should be less than 10240 bytes.");
    }

    public final Uri.Builder f() {
        return new Uri.Builder().scheme("kakaolink").authority("send");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KakaoTalkShareIntentClient(ContextInfo contextInfo, ApplicationInfo applicationInfo, IntentResolveClient intentResolveClient, int i11, r rVar) {
        this((i11 & 1) != 0 ? KakaoSdk.f25078a.a() : contextInfo, (i11 & 2) != 0 ? KakaoSdk.f25078a.a() : applicationInfo, (i11 & 4) != 0 ? IntentResolveClient.f25096c.a() : intentResolveClient);
    }
}
