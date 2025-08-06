package jp;

import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.otc.helper.OtcSecurityTokenFactory;
import rx.functions.Action1;

public final /* synthetic */ class h1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcSecurityTokenFactory f56021b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f56022c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f56023d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f56024e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f56025f;

    public /* synthetic */ h1(OtcSecurityTokenFactory otcSecurityTokenFactory, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.f56021b = otcSecurityTokenFactory;
        this.f56022c = z11;
        this.f56023d = z12;
        this.f56024e = z13;
        this.f56025f = z14;
    }

    public final void call(Object obj) {
        this.f56021b.o(this.f56022c, this.f56023d, this.f56024e, this.f56025f, (UserSecurityInfoData) obj);
    }
}
