package ul;

import android.widget.CompoundButton;
import com.hbg.lib.network.contract.core.bean.ContractTagInfo;
import com.huobi.homemarket.ui.HomeMarketNewFragment;

public final /* synthetic */ class r implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMarketNewFragment f60802b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractTagInfo.TagsGroupInfo.TagInfo f60803c;

    public /* synthetic */ r(HomeMarketNewFragment homeMarketNewFragment, ContractTagInfo.TagsGroupInfo.TagInfo tagInfo) {
        this.f60802b = homeMarketNewFragment;
        this.f60803c = tagInfo;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f60802b.ak(this.f60803c, compoundButton, z11);
    }
}
