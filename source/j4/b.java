package j4;

import android.view.View;
import com.business.common.swapzero.view.SwapZeroSideView;
import i4.m;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapZeroSideView f55887b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m f55888c;

    public /* synthetic */ b(SwapZeroSideView swapZeroSideView, m mVar) {
        this.f55887b = swapZeroSideView;
        this.f55888c = mVar;
    }

    public final void onClick(View view) {
        SwapZeroSideView.h(this.f55887b, this.f55888c, view);
    }
}
