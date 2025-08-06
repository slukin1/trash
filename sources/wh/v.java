package wh;

import com.huobi.asset2.index.AssetIndexFragmentNew;
import com.huobi.view.BaseBottomCurrencyDialogFragment;

public final /* synthetic */ class v implements BaseBottomCurrencyDialogFragment.OnCurrencyMethodChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentNew f61346a;

    public /* synthetic */ v(AssetIndexFragmentNew assetIndexFragmentNew) {
        this.f61346a = assetIndexFragmentNew;
    }

    public final void onCurrencyMethodChanged(String str) {
        this.f61346a.ri(str);
    }
}
