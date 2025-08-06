package rl;

import android.view.View;
import com.hbg.lib.core.ui.BaseFragment;
import com.huobi.homemarket.helper.MarketContentGuideHelper;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketContentGuideHelper f25741b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseFragment f25742c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f25743d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f25744e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f25745f;

    public /* synthetic */ h(MarketContentGuideHelper marketContentGuideHelper, BaseFragment baseFragment, View view, String str, String str2) {
        this.f25741b = marketContentGuideHelper;
        this.f25742c = baseFragment;
        this.f25743d = view;
        this.f25744e = str;
        this.f25745f = str2;
    }

    public final void run() {
        this.f25741b.lambda$showFreshItemGuide$3(this.f25742c, this.f25743d, this.f25744e, this.f25745f);
    }
}
