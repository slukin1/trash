package uk;

import android.view.View;
import com.huobi.finance.address.BindAddressView;

public final /* synthetic */ class j implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BindAddressView f60762b;

    public /* synthetic */ j(BindAddressView bindAddressView) {
        this.f60762b = bindAddressView;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f60762b.r(view, z11);
    }
}
