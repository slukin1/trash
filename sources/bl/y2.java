package bl;

import android.content.Context;
import android.view.View;
import com.huobi.finance.bean.OtcOptionsDetailInfo;
import com.huobi.finance.viewhandler.OtcOptionsBalanceViewAdapter;

public final /* synthetic */ class y2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcOptionsDetailInfo f12799b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f12800c;

    public /* synthetic */ y2(OtcOptionsDetailInfo otcOptionsDetailInfo, Context context) {
        this.f12799b = otcOptionsDetailInfo;
        this.f12800c = context;
    }

    public final void onClick(View view) {
        OtcOptionsBalanceViewAdapter.d(this.f12799b, this.f12800c, view);
    }
}
