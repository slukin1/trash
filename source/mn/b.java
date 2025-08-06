package mn;

import android.view.View;
import com.huobi.login.bean.AccountHistoryBean;
import com.huobi.login.holder.AccountHistoryHolder;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountHistoryBean f58247b;

    public /* synthetic */ b(AccountHistoryBean accountHistoryBean) {
        this.f58247b = accountHistoryBean;
    }

    public final void onClick(View view) {
        AccountHistoryHolder.f(this.f58247b, view);
    }
}
