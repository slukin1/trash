package wh;

import com.huobi.asset2.index.AssetIndexFragment;
import com.huobi.view.BaseBottomCurrencyDialogFragment;

public final /* synthetic */ class e implements BaseBottomCurrencyDialogFragment.OnCurrencyMethodChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragment f61290a;

    public /* synthetic */ e(AssetIndexFragment assetIndexFragment) {
        this.f61290a = assetIndexFragment;
    }

    public final void onCurrencyMethodChanged(String str) {
        this.f61290a.ni(str);
    }
}
