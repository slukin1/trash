package rl;

import android.content.DialogInterface;
import android.view.View;
import com.hbg.lib.core.ui.BaseFragment;
import com.huobi.homemarket.helper.MarketContentGuideHelper;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketContentGuideHelper f25746b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseFragment f25747c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f25748d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f25749e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f25750f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnDismissListener f25751g;

    public /* synthetic */ i(MarketContentGuideHelper marketContentGuideHelper, BaseFragment baseFragment, View view, String str, String str2, DialogInterface.OnDismissListener onDismissListener) {
        this.f25746b = marketContentGuideHelper;
        this.f25747c = baseFragment;
        this.f25748d = view;
        this.f25749e = str;
        this.f25750f = str2;
        this.f25751g = onDismissListener;
    }

    public final void run() {
        this.f25746b.lambda$showCollectionGuide$1(this.f25747c, this.f25748d, this.f25749e, this.f25750f, this.f25751g);
    }
}
