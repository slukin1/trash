package cd;

import android.view.View;
import com.hbg.module.exchange.grid.bean.GridUserGuideInfo;
import com.hbg.module.exchange.grid.ui.GridUserGuideContentFragment;

public final /* synthetic */ class p0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridUserGuideContentFragment f13056b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GridUserGuideInfo f13057c;

    public /* synthetic */ p0(GridUserGuideContentFragment gridUserGuideContentFragment, GridUserGuideInfo gridUserGuideInfo) {
        this.f13056b = gridUserGuideContentFragment;
        this.f13057c = gridUserGuideInfo;
    }

    public final void onClick(View view) {
        this.f13056b.Fh(this.f13057c, view);
    }
}
