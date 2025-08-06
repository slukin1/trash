package jp;

import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import rx.functions.Action1;

public final /* synthetic */ class d0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcFaitDWJumpHelper f55999b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcFaitDWJumpHelper.DWCheckData f56000c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f56001d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ OtcFaitDWJumpHelper.k f56002e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f56003f;

    public /* synthetic */ d0(OtcFaitDWJumpHelper otcFaitDWJumpHelper, OtcFaitDWJumpHelper.DWCheckData dWCheckData, int i11, OtcFaitDWJumpHelper.k kVar, String str) {
        this.f55999b = otcFaitDWJumpHelper;
        this.f56000c = dWCheckData;
        this.f56001d = i11;
        this.f56002e = kVar;
        this.f56003f = str;
    }

    public final void call(Object obj) {
        this.f55999b.I(this.f56000c, this.f56001d, this.f56002e, this.f56003f, (Boolean) obj);
    }
}
