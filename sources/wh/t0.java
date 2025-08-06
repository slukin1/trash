package wh;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.huobi.asset2.index.AssetIndexFragmentNew1;
import java.util.Map;

public final /* synthetic */ class t0 implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentNew1 f61342a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f61343b;

    public /* synthetic */ t0(AssetIndexFragmentNew1 assetIndexFragmentNew1, Map map) {
        this.f61342a = assetIndexFragmentNew1;
        this.f61343b = map;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i11) {
        this.f61342a.ji(this.f61343b, tab, i11);
    }
}
