package jp;

import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class e0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcFaitDWJumpHelper f56009b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f56010c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ OtcFaitDWJumpHelper.k f56011d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ OtcFaitDWJumpHelper.DWCheckData f56012e;

    public /* synthetic */ e0(OtcFaitDWJumpHelper otcFaitDWJumpHelper, boolean z11, OtcFaitDWJumpHelper.k kVar, OtcFaitDWJumpHelper.DWCheckData dWCheckData) {
        this.f56009b = otcFaitDWJumpHelper;
        this.f56010c = z11;
        this.f56011d = kVar;
        this.f56012e = dWCheckData;
    }

    public final void call(Object obj) {
        this.f56009b.F(this.f56010c, this.f56011d, this.f56012e, (List) obj);
    }
}
