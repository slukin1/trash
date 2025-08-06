package com.huobi.finance.account;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c6.b;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.grid.bean.GridAccountConvertInfo;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.bean.CommonEmptyItem;
import com.hbg.lib.widgets.adapter.bean.CommonNetErrorItem;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.finance.bean.GridDataTotal;
import com.huobi.finance.ui.GridAssetDetailActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import sk.c;
import sk.d;
import vk.o;

public class GridAssetAccount extends BaseAssetAccount<GridDataTotal> {

    /* renamed from: b  reason: collision with root package name */
    public GridDataTotal f45183b;

    /* renamed from: c  reason: collision with root package name */
    public Context f45184c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f45185d;

    /* renamed from: e  reason: collision with root package name */
    public LoadingLayout f45186e;

    /* renamed from: f  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f45187f;

    /* renamed from: g  reason: collision with root package name */
    public final List<s9.a> f45188g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f45189h;

    /* renamed from: i  reason: collision with root package name */
    public CommonEmptyItem.a f45190i = new a();

    /* renamed from: j  reason: collision with root package name */
    public b<o> f45191j = new c(this);

    public class a implements CommonEmptyItem.a {
        public a() {
        }

        public void a() {
            BaseModuleConfig.a().w("app_assets_quant_account_create_now_click", (HashMap) null);
            HbgRouter.i(GridAssetAccount.this.f45185d, "/trade/grid", new Bundle());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(o oVar) {
        GridAssetDetailActivity.Qg(this.f45185d, oVar.c());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        View.OnClickListener onClickListener = this.f45189h;
        if (onClickListener != null) {
            onClickListener.onClick((View) null);
        }
    }

    public void a() {
        b(this.f45183b);
    }

    public int c() {
        return R$string.n_grid_account;
    }

    public View d(Context context, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        this.f45185d = (Activity) context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_asset_grid, viewGroup, false);
        this.f45184c = inflate.getContext();
        this.f45186e = (LoadingLayout) inflate.findViewById(R$id.loading_layout);
        this.f45189h = onClickListener;
        this.f45187f = (EasyRecyclerView) inflate.findViewById(R$id.id_asset_grid_recyclerView);
        return inflate;
    }

    /* renamed from: j */
    public void b(GridDataTotal gridDataTotal) {
        if (this.f45186e != null) {
            n(gridDataTotal);
            o(gridDataTotal);
        }
    }

    public void m() {
        this.f45188g.clear();
        EasyRecyclerView<s9.a> easyRecyclerView = this.f45187f;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(this.f45188g);
        }
    }

    public final void n(GridDataTotal gridDataTotal) {
        if (this.f45183b == null || gridDataTotal.isAvailable()) {
            this.f45183b = gridDataTotal;
            this.f45186e.g();
        }
    }

    public final void o(GridDataTotal gridDataTotal) {
        this.f45188g.clear();
        if (gridDataTotal == null || gridDataTotal.getConvertList() == null) {
            CommonNetErrorItem commonNetErrorItem = new CommonNetErrorItem();
            commonNetErrorItem.d(new d(this));
            this.f45188g.add(commonNetErrorItem);
        } else {
            List<GridAccountConvertInfo> convertList = gridDataTotal.getConvertList();
            if (convertList.isEmpty()) {
                CommonEmptyItem commonEmptyItem = new CommonEmptyItem();
                commonEmptyItem.k(R$drawable.empty_pic_remind_norecord3);
                commonEmptyItem.l(this.f45185d.getString(R$string.trade_no_record));
                commonEmptyItem.i(this.f45185d.getString(R$string.n_cloud_wallet_go_create));
                commonEmptyItem.j(this.f45190i);
                this.f45188g.add(commonEmptyItem);
            } else {
                for (GridAccountConvertInfo oVar : convertList) {
                    this.f45188g.add(new o(oVar, this.f45191j));
                }
            }
        }
        this.f45187f.setData(this.f45188g);
    }
}
