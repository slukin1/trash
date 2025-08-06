package jk;

import android.view.View;
import com.huobi.engineutils.widget.AssetBalanceWidget;
import rj.n;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetBalanceWidget f55963b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f55964c;

    public /* synthetic */ d(AssetBalanceWidget assetBalanceWidget, n nVar) {
        this.f55963b = assetBalanceWidget;
        this.f55964c = nVar;
    }

    public final void onClick(View view) {
        this.f55963b.l0(this.f55964c, view);
    }
}
