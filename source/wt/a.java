package wt;

import android.view.View;
import android.widget.TextView;
import com.huobi.trade.prime.bean.PrimeOrderBean;
import com.huobi.tradenew.prime.viewhandler.PrimeOrderBeanViewHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrimeOrderBeanViewHandler f61502b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PrimeOrderBean f61503c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f61504d;

    public /* synthetic */ a(PrimeOrderBeanViewHandler primeOrderBeanViewHandler, PrimeOrderBean primeOrderBean, TextView textView) {
        this.f61502b = primeOrderBeanViewHandler;
        this.f61503c = primeOrderBean;
        this.f61504d = textView;
    }

    public final void onClick(View view) {
        this.f61502b.f(this.f61503c, this.f61504d, view);
    }
}
