package bl;

import android.content.Context;
import android.view.View;
import com.huobi.finance.bean.SuperMarginDetailInfo;
import com.huobi.finance.viewhandler.SuperMarginBalanceViewAdapter;

public final /* synthetic */ class b3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12549b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SuperMarginDetailInfo f12550c;

    public /* synthetic */ b3(Context context, SuperMarginDetailInfo superMarginDetailInfo) {
        this.f12549b = context;
        this.f12550c = superMarginDetailInfo;
    }

    public final void onClick(View view) {
        SuperMarginBalanceViewAdapter.f(this.f12549b, this.f12550c, view);
    }
}
