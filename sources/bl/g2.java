package bl;

import android.content.Context;
import android.view.View;
import com.huobi.finance.bean.C2CMarginBalanceDetailInfo;
import com.huobi.finance.viewhandler.C2cMarginBalanceViewAdapter;

public final /* synthetic */ class g2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12596b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2CMarginBalanceDetailInfo f12597c;

    public /* synthetic */ g2(Context context, C2CMarginBalanceDetailInfo c2CMarginBalanceDetailInfo) {
        this.f12596b = context;
        this.f12597c = c2CMarginBalanceDetailInfo;
    }

    public final void onClick(View view) {
        C2cMarginBalanceViewAdapter.e(this.f12596b, this.f12597c, view);
    }
}
