package uk;

import android.animation.ValueAnimator;
import com.huobi.finance.address.AddrMgrDialog;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddrMgrDialog f60708b;

    public /* synthetic */ a(AddrMgrDialog addrMgrDialog) {
        this.f60708b = addrMgrDialog;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f60708b.Hh(valueAnimator);
    }
}
