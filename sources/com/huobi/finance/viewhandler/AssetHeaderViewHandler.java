package com.huobi.finance.viewhandler;

import android.view.ViewGroup;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.asset.widget.AssetHeadView.AssetHeadData;
import s9.c;

public abstract class AssetHeaderViewHandler<T extends AssetHeadView.AssetHeadData> implements c {

    /* renamed from: b  reason: collision with root package name */
    public T f67576b;

    /* renamed from: c  reason: collision with root package name */
    public AssetHeadView<T> f67577c;

    public abstract String b();

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, T t11, ViewGroup viewGroup) {
        this.f67576b = t11;
        AssetHeadView<T> assetHeadView = (AssetHeadView) cVar.e().b(R$id.root);
        this.f67577c = assetHeadView;
        assetHeadView.setDistributionType(b());
        if (b().equals("1")) {
            this.f67577c.setChildUpdateBalance(true);
        }
        this.f67577c.k(t11);
    }

    public int getResId() {
        return R$layout.item_asset_header_layout;
    }
}
