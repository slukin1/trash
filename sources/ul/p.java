package ul;

import android.widget.CompoundButton;
import com.hbg.lib.network.contract.core.bean.ContractTagInfo;
import com.huobi.homemarket.ui.HomeMarketNewFragment;

public final /* synthetic */ class p implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMarketNewFragment f60797b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractTagInfo.TagsGroupInfo.TagInfo f60798c;

    public /* synthetic */ p(HomeMarketNewFragment homeMarketNewFragment, ContractTagInfo.TagsGroupInfo.TagInfo tagInfo) {
        this.f60797b = homeMarketNewFragment;
        this.f60798c = tagInfo;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f60797b.Uj(this.f60798c, compoundButton, z11);
    }
}
