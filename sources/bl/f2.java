package bl;

import android.view.View;
import com.huobi.finance.bean.C2CLendBalanceDetailInfo;
import com.huobi.finance.viewhandler.C2cLendBalanceViewAdapter;

public final /* synthetic */ class f2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2CLendBalanceDetailInfo f12585b;

    public /* synthetic */ f2(C2CLendBalanceDetailInfo c2CLendBalanceDetailInfo) {
        this.f12585b = c2CLendBalanceDetailInfo;
    }

    public final void onClick(View view) {
        C2cLendBalanceViewAdapter.e(this.f12585b, view);
    }
}
