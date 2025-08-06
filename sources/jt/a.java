package jt;

import android.view.View;
import android.widget.TextView;
import com.huobi.trade.prime.bean.PrimeOrderBean;
import com.huobi.trade.prime.viewhandler.PrimeOrderBeanViewHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrimeOrderBeanViewHandler f56105b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PrimeOrderBean f56106c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f56107d;

    public /* synthetic */ a(PrimeOrderBeanViewHandler primeOrderBeanViewHandler, PrimeOrderBean primeOrderBean, TextView textView) {
        this.f56105b = primeOrderBeanViewHandler;
        this.f56106c = primeOrderBean;
        this.f56107d = textView;
    }

    public final void onClick(View view) {
        this.f56105b.f(this.f56106c, this.f56107d, view);
    }
}
