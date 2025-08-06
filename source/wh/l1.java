package wh;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.List;

public final /* synthetic */ class l1 implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f61318a;

    public /* synthetic */ l1(List list) {
        this.f61318a = list;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i11) {
        tab.setText((CharSequence) this.f61318a.get(i11));
    }
}
