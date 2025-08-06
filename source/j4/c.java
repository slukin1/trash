package j4;

import android.view.View;
import com.business.common.swapzero.data.SwapZeroSideModel;
import com.business.common.swapzero.view.SwapZeroSideView;
import i4.m;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f55889b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapZeroSideView f55890c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SwapZeroSideModel f55891d;

    public /* synthetic */ c(m mVar, SwapZeroSideView swapZeroSideView, SwapZeroSideModel swapZeroSideModel) {
        this.f55889b = mVar;
        this.f55890c = swapZeroSideView;
        this.f55891d = swapZeroSideModel;
    }

    public final void onClick(View view) {
        SwapZeroSideView.f(this.f55889b, this.f55890c, this.f55891d, view);
    }
}
