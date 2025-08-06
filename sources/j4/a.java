package j4;

import android.view.View;
import com.business.common.swapzero.data.SwapZeroSideModel;
import com.business.common.swapzero.view.SwapZeroSideView;
import i4.m;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapZeroSideModel f55884b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapZeroSideView f55885c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ m f55886d;

    public /* synthetic */ a(SwapZeroSideModel swapZeroSideModel, SwapZeroSideView swapZeroSideView, m mVar) {
        this.f55884b = swapZeroSideModel;
        this.f55885c = swapZeroSideView;
        this.f55886d = mVar;
    }

    public final void onClick(View view) {
        SwapZeroSideView.g(this.f55884b, this.f55885c, this.f55886d, view);
    }
}
