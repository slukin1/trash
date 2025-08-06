package zk;

import android.view.View;
import com.huobi.finance.transfer.bean.ChooseCurrencyItem;
import com.huobi.finance.transfer.viewhandler.ChooseCurrencyItemHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseCurrencyItem f63078b;

    public /* synthetic */ a(ChooseCurrencyItem chooseCurrencyItem) {
        this.f63078b = chooseCurrencyItem;
    }

    public final void onClick(View view) {
        ChooseCurrencyItemHandler.d(this.f63078b, view);
    }
}
