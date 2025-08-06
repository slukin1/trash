package bl;

import android.content.Context;
import android.view.View;
import com.huobi.finance.bean.SavingsDetailInfo;
import com.huobi.finance.viewhandler.SavingsBalanceViewAdapter;

public final /* synthetic */ class a3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12543b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SavingsDetailInfo f12544c;

    public /* synthetic */ a3(Context context, SavingsDetailInfo savingsDetailInfo) {
        this.f12543b = context;
        this.f12544c = savingsDetailInfo;
    }

    public final void onClick(View view) {
        SavingsBalanceViewAdapter.f(this.f12543b, this.f12544c, view);
    }
}
