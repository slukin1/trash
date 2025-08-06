package cn;

import androidx.core.widget.NestedScrollView;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;
import com.huobi.view.MyNestedScrollView;

public final /* synthetic */ class m1 implements MyNestedScrollView.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LinearSwapTradeBaseFragment f13169a;

    public /* synthetic */ m1(LinearSwapTradeBaseFragment linearSwapTradeBaseFragment) {
        this.f13169a = linearSwapTradeBaseFragment;
    }

    public final void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        this.f13169a.oj(nestedScrollView, i11, i12, i13, i14);
    }
}
