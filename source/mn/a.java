package mn;

import android.view.View;
import com.huobi.login.bean.AccountHistoryBean;
import com.huobi.login.holder.AccountHistoryHolder;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountHistoryBean f58246b;

    public /* synthetic */ a(AccountHistoryBean accountHistoryBean) {
        this.f58246b = accountHistoryBean;
    }

    public final void onClick(View view) {
        AccountHistoryHolder.e(this.f58246b, view);
    }
}
