package jr;

import c6.b;
import com.huobi.setting.ui.NoDisturbSwitchView;

public final /* synthetic */ class c implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NoDisturbSwitchView f56103b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f56104c;

    public /* synthetic */ c(NoDisturbSwitchView noDisturbSwitchView, boolean z11) {
        this.f56103b = noDisturbSwitchView;
        this.f56104c = z11;
    }

    public final void onCallback(Object obj) {
        this.f56103b.j(this.f56104c, obj);
    }
}
