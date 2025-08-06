package bl;

import android.content.Context;
import android.view.View;
import com.huobi.finance.bean.MineDetailInfo;
import com.huobi.finance.viewhandler.MineBalanceViewAdapter;

public final /* synthetic */ class x2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12790b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MineDetailInfo f12791c;

    public /* synthetic */ x2(Context context, MineDetailInfo mineDetailInfo) {
        this.f12790b = context;
        this.f12791c = mineDetailInfo;
    }

    public final void onClick(View view) {
        MineBalanceViewAdapter.e(this.f12790b, this.f12791c, view);
    }
}
