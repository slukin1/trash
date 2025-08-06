package cd;

import com.hbg.module.exchange.grid.bean.GridUserGuideInfo;
import com.hbg.module.exchange.grid.ui.GridUserGuideFragment;

public final /* synthetic */ class q0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridUserGuideFragment f13059b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GridUserGuideInfo f13060c;

    public /* synthetic */ q0(GridUserGuideFragment gridUserGuideFragment, GridUserGuideInfo gridUserGuideInfo) {
        this.f13059b = gridUserGuideFragment;
        this.f13060c = gridUserGuideInfo;
    }

    public final void run() {
        this.f13059b.xh(this.f13060c);
    }
}
