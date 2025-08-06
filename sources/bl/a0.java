package bl;

import android.view.View;
import com.huobi.finance.viewhandler.AssetPositionEarnItemViewHandler;

public final /* synthetic */ class a0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f12539b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ StringBuilder f12540c;

    public /* synthetic */ a0(boolean z11, StringBuilder sb2) {
        this.f12539b = z11;
        this.f12540c = sb2;
    }

    public final void onClick(View view) {
        AssetPositionEarnItemViewHandler.j(this.f12539b, this.f12540c, view);
    }
}
