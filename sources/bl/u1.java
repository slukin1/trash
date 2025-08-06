package bl;

import android.view.View;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.viewhandler.AssetSpotItemViewAdapter;
import i6.r;
import rx.functions.Action1;

public final /* synthetic */ class u1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSpotItemViewAdapter f12753b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f12754c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ r f12755d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BalanceDetailInfo f12756e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f12757f;

    public /* synthetic */ u1(AssetSpotItemViewAdapter assetSpotItemViewAdapter, View view, r rVar, BalanceDetailInfo balanceDetailInfo, View view2) {
        this.f12753b = assetSpotItemViewAdapter;
        this.f12754c = view;
        this.f12755d = rVar;
        this.f12756e = balanceDetailInfo;
        this.f12757f = view2;
    }

    public final void call(Object obj) {
        this.f12753b.m(this.f12754c, this.f12755d, this.f12756e, this.f12757f, (Void) obj);
    }
}
