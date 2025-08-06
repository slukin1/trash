package cn;

import androidx.core.widget.NestedScrollView;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;

public final /* synthetic */ class v0 implements NestedScrollView.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LinearSwapTradeBaseFragment f13763a;

    public /* synthetic */ v0(LinearSwapTradeBaseFragment linearSwapTradeBaseFragment) {
        this.f13763a = linearSwapTradeBaseFragment;
    }

    public final void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        this.f13763a.dj(nestedScrollView, i11, i12, i13, i14);
    }
}
