package com.kakao.sdk.share;

import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationInfo;
import com.kakao.sdk.common.model.ContextInfo;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0003B\u001b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/kakao/sdk/share/WebSharerClient;", "", "Lcom/kakao/sdk/common/model/ContextInfo;", "a", "Lcom/kakao/sdk/common/model/ContextInfo;", "contextInfo", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "b", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "applicationInfo", "<init>", "(Lcom/kakao/sdk/common/model/ContextInfo;Lcom/kakao/sdk/common/model/ApplicationInfo;)V", "c", "share_release"}, k = 1, mv = {1, 6, 0})
public final class WebSharerClient {

    /* renamed from: c  reason: collision with root package name */
    public static final a f25141c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final i<WebSharerClient> f25142d = LazyKt__LazyJVMKt.a(WebSharerClient$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final ContextInfo f25143a;

    /* renamed from: b  reason: collision with root package name */
    public final ApplicationInfo f25144b;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/kakao/sdk/share/WebSharerClient$a;", "", "<init>", "()V", "share_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public WebSharerClient() {
        this((ContextInfo) null, (ApplicationInfo) null, 3, (r) null);
    }

    public WebSharerClient(ContextInfo contextInfo, ApplicationInfo applicationInfo) {
        this.f25143a = contextInfo;
        this.f25144b = applicationInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebSharerClient(ContextInfo contextInfo, ApplicationInfo applicationInfo, int i11, r rVar) {
        this((i11 & 1) != 0 ? KakaoSdk.f25078a.a() : contextInfo, (i11 & 2) != 0 ? KakaoSdk.f25078a.a() : applicationInfo);
    }
}
