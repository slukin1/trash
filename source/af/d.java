package af;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hbg.module.livesquare.dialog.LiveSelfAwardDialog;

public final /* synthetic */ class d implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LiveSelfAwardDialog f3537a;

    public /* synthetic */ d(LiveSelfAwardDialog liveSelfAwardDialog) {
        this.f3537a = liveSelfAwardDialog;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i11) {
        LiveSelfAwardDialog.zh(this.f3537a, tab, i11);
    }
}
