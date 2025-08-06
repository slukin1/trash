package bl;

import android.content.Context;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.viewhandler.AssetSpotItemViewAdapter;
import rx.functions.Action1;

public final /* synthetic */ class n1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12677b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BalanceDetailInfo f12678c;

    public /* synthetic */ n1(Context context, BalanceDetailInfo balanceDetailInfo) {
        this.f12677b = context;
        this.f12678c = balanceDetailInfo;
    }

    public final void call(Object obj) {
        AssetSpotItemViewAdapter.q(this.f12677b, this.f12678c, (Void) obj);
    }
}
