package jk;

import android.view.View;
import com.huobi.engineutils.widget.AssetBalanceWidget;
import rj.n;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetBalanceWidget f55965b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f55966c;

    public /* synthetic */ e(AssetBalanceWidget assetBalanceWidget, n nVar) {
        this.f55965b = assetBalanceWidget;
        this.f55966c = nVar;
    }

    public final void onClick(View view) {
        this.f55965b.m0(this.f55966c, view);
    }
}
