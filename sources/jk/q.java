package jk;

import android.view.View;
import com.huobi.engineutils.widget.CurrencySelectWidget;
import vh.x;

public final /* synthetic */ class q implements x.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CurrencySelectWidget f55981a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f55982b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ x f55983c;

    public /* synthetic */ q(CurrencySelectWidget currencySelectWidget, View view, x xVar) {
        this.f55981a = currencySelectWidget;
        this.f55982b = view;
        this.f55983c = xVar;
    }

    public final void onCurrencyMethodChanged(String str) {
        this.f55981a.b0(this.f55982b, this.f55983c, str);
    }
}
