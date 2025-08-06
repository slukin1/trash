package com.kakao.sdk.common;

import android.content.Context;
import androidx.lifecycle.c0;
import com.kakao.sdk.common.model.ApplicationContextInfo;
import com.kakao.sdk.common.model.ApprovalType;
import com.kakao.sdk.common.model.SdkIdentifier;
import com.kakao.sdk.common.model.ServerHosts;
import com.kakao.sdk.common.util.SdkLog;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \bÆ\u0002\u0018\u00002\u00020\u0001:\u00016B\t\b\u0002¢\u0006\u0004\b4\u00105J[\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011JN\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007J\b\u0010\u0016\u001a\u00020\u000fH\u0002R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0018\u0010!\"\u0004\b\"\u0010#R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010$\u001a\u0004\b\u001f\u0010%\"\u0004\b&\u0010'R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010\u0014\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b\u0014\u0010%¨\u00067"}, d2 = {"Lcom/kakao/sdk/common/KakaoSdk;", "", "Landroid/content/Context;", "context", "", "appKey", "customScheme", "", "loggingEnabled", "Lcom/kakao/sdk/common/model/ServerHosts;", "hosts", "Lcom/kakao/sdk/common/model/ApprovalType;", "approvalType", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "sdkIdentifier", "", "d", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/common/model/ServerHosts;Lcom/kakao/sdk/common/model/ApprovalType;Lcom/kakao/sdk/common/model/SdkIdentifier;)V", "Lcom/kakao/sdk/common/KakaoSdk$Type;", "type", "isAutomotive", "e", "g", "Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "b", "Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "a", "()Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "h", "(Lcom/kakao/sdk/common/model/ApplicationContextInfo;)V", "applicationContextInfo", "c", "Lcom/kakao/sdk/common/model/ServerHosts;", "()Lcom/kakao/sdk/common/model/ServerHosts;", "j", "(Lcom/kakao/sdk/common/model/ServerHosts;)V", "Z", "()Z", "setLoggingEnabled", "(Z)V", "Lcom/kakao/sdk/common/KakaoSdk$Type;", "getType", "()Lcom/kakao/sdk/common/KakaoSdk$Type;", "k", "(Lcom/kakao/sdk/common/KakaoSdk$Type;)V", "f", "Lcom/kakao/sdk/common/model/ApprovalType;", "getApprovalType", "()Lcom/kakao/sdk/common/model/ApprovalType;", "i", "(Lcom/kakao/sdk/common/model/ApprovalType;)V", "<set-?>", "<init>", "()V", "Type", "common_release"}, k = 1, mv = {1, 6, 0})
public final class KakaoSdk {

    /* renamed from: a  reason: collision with root package name */
    public static final KakaoSdk f25078a = new KakaoSdk();

    /* renamed from: b  reason: collision with root package name */
    public static ApplicationContextInfo f25079b;

    /* renamed from: c  reason: collision with root package name */
    public static ServerHosts f25080c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f25081d;

    /* renamed from: e  reason: collision with root package name */
    public static Type f25082e;

    /* renamed from: f  reason: collision with root package name */
    public static ApprovalType f25083f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f25084g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/kakao/sdk/common/KakaoSdk$Type;", "", "(Ljava/lang/String;I)V", "KOTLIN", "RX_KOTLIN", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Type {
        KOTLIN,
        RX_KOTLIN
    }

    public static final void d(Context context, String str, String str2, Boolean bool, ServerHosts serverHosts, ApprovalType approvalType, SdkIdentifier sdkIdentifier) {
        String str3;
        boolean z11;
        KakaoSdk kakaoSdk = f25078a;
        if (str2 == null) {
            String str4 = str;
            str3 = x.i("kakao", str);
        } else {
            String str5 = str;
            str3 = str2;
        }
        if (bool == null) {
            z11 = false;
        } else {
            z11 = bool.booleanValue();
        }
        kakaoSdk.e(context, str, str3, z11, serverHosts == null ? new ServerHosts() : serverHosts, approvalType == null ? new ApprovalType() : approvalType, Type.KOTLIN, sdkIdentifier == null ? new SdkIdentifier((String) null, 1, (r) null) : sdkIdentifier, false);
    }

    public static /* synthetic */ void f(Context context, String str, String str2, Boolean bool, ServerHosts serverHosts, ApprovalType approvalType, SdkIdentifier sdkIdentifier, int i11, Object obj) {
        SdkIdentifier sdkIdentifier2 = null;
        String str3 = (i11 & 4) != 0 ? null : str2;
        Boolean bool2 = (i11 & 8) != 0 ? null : bool;
        ServerHosts serverHosts2 = (i11 & 16) != 0 ? null : serverHosts;
        ApprovalType approvalType2 = (i11 & 32) != 0 ? null : approvalType;
        if ((i11 & 64) == 0) {
            sdkIdentifier2 = sdkIdentifier;
        }
        d(context, str, str3, bool2, serverHosts2, approvalType2, sdkIdentifier2);
    }

    public final ApplicationContextInfo a() {
        ApplicationContextInfo applicationContextInfo = f25079b;
        if (applicationContextInfo != null) {
            return applicationContextInfo;
        }
        return null;
    }

    public final ServerHosts b() {
        ServerHosts serverHosts = f25080c;
        if (serverHosts != null) {
            return serverHosts;
        }
        return null;
    }

    public final boolean c() {
        return f25081d;
    }

    public final void e(Context context, String str, String str2, boolean z11, ServerHosts serverHosts, ApprovalType approvalType, Type type, SdkIdentifier sdkIdentifier, boolean z12) {
        j(serverHosts);
        f25081d = z11;
        k(type);
        i(approvalType);
        h(new ApplicationContextInfo(context, str, str2, type, sdkIdentifier));
        f25084g = z12;
        g();
    }

    public final void g() {
        try {
            Class<?> cls = Class.forName("com.kakao.sdk.user.AppLifecycleObserver");
            Object invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
            if (invoke != null) {
                c0.l().getLifecycle().a((androidx.lifecycle.r) invoke);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");
        } catch (Exception e11) {
            SdkLog.f25100d.b(x.i("Failed to register AppLifecycleObserver ", e11));
        }
    }

    public final void h(ApplicationContextInfo applicationContextInfo) {
        f25079b = applicationContextInfo;
    }

    public final void i(ApprovalType approvalType) {
        f25083f = approvalType;
    }

    public final void j(ServerHosts serverHosts) {
        f25080c = serverHosts;
    }

    public final void k(Type type) {
        f25082e = type;
    }
}
