package wn;

import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import rx.functions.Action1;
import wn.u0;

public final /* synthetic */ class s0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u0 f61472b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61473c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f61474d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f61475e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f61476f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ u0.e f61477g;

    public /* synthetic */ s0(u0 u0Var, String str, int i11, int i12, String str2, u0.e eVar) {
        this.f61472b = u0Var;
        this.f61473c = str;
        this.f61474d = i11;
        this.f61475e = i12;
        this.f61476f = str2;
        this.f61477g = eVar;
    }

    public final void call(Object obj) {
        this.f61472b.t(this.f61473c, this.f61474d, this.f61475e, this.f61476f, this.f61477g, (ImgCaptchaData) obj);
    }
}
