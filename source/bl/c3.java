package bl;

import android.view.View;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.finance.viewhandler.SymbolCurrencyViewHandler;

public final /* synthetic */ class c3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SymbolCurrencyEntity f12558b;

    public /* synthetic */ c3(SymbolCurrencyEntity symbolCurrencyEntity) {
        this.f12558b = symbolCurrencyEntity;
    }

    public final void onClick(View view) {
        SymbolCurrencyViewHandler.d(this.f12558b, view);
    }
}
