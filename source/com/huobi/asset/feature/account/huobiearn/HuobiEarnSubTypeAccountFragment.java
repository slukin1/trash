package com.huobi.asset.feature.account.huobiearn;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bj.o0;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jh.i;
import jh.j;
import jh.k;
import s9.a;

public class HuobiEarnSubTypeAccountFragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public EasyRecyclerView f42253l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingLayout f42254m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f42255n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f42256o;

    /* renamed from: p  reason: collision with root package name */
    public View f42257p;

    /* renamed from: q  reason: collision with root package name */
    public View f42258q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f42259r;

    @SensorsDataInstrumented
    public static /* synthetic */ void Hh(View view) {
        BaseModuleConfig.a().b("5173", (Map<String, Object>) null);
        BaseModuleConfig.a().w("app_assets_Huobi_Earn_deposit_now_click", (HashMap) null);
        AssetModuleConfig.a().w0(view.getContext(), "financial/earn/h5?utm_source=huobiearn_assets_now_buy");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Ih(View view) {
        BaseModuleConfig.a().w("app_earn_auto_transfer_switch_click", (HashMap) null);
        HBBaseWebActivity.showWebView(view.getContext(), BaseModuleConfig.a().W() + "financial/earn/h5/saveings/", (String) null, (String) null, true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(View view) {
        DialogUtils.X(requireActivity(), getResources().getString(R$string.n_usdt_exchange_entrance_tips_title), getResources().getString(R$string.n_asset_ybb_notice), (String) null, getResources().getString(R$string.n_otc_optional_process_know), o0.f12469a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Kh(boolean z11) {
        this.f42259r = z11;
    }

    public void Lh(View.OnClickListener onClickListener) {
        this.f42254m.setOnRetryClickListener(onClickListener);
    }

    public void initViews() {
        super.initViews();
        this.f42254m = (LoadingLayout) this.f67460i.b(R$id.loading_layout);
        this.f42253l = (EasyRecyclerView) this.f67460i.b(R$id.rcv);
        this.f42255n = (TextView) this.f67460i.b(R$id.tv_question_font_icon);
        this.f42256o = (TextView) this.f67460i.b(R$id.tv_enter);
        this.f42257p = this.f67460i.b(R$id.switcher_layout);
        this.f42258q = this.f67460i.b(R$id.switcher_line);
        this.f67460i.b(R$id.tv_mining_now).setOnClickListener(k.f55943b);
        this.f42253l.addItemDecoration(new VerticalDividerItemDecoration((Drawable) new ColorDrawable(ContextCompat.getColor(getContext(), R$color.baseColorPrimarySeparator)), (int) getContext().getResources().getDimension(R$dimen.dimen_0_5), false, false));
        this.f42256o.setOnClickListener(j.f55942b);
        this.f42255n.setOnClickListener(new i(this));
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return LayoutInflater.from(getContext()).inflate(R$layout.layout_mining_list, viewGroup, false);
    }

    public void setData(List<? extends a> list) {
        if (list == null) {
            this.f42254m.k();
        } else if (list.isEmpty()) {
            this.f42254m.i();
        } else {
            this.f42254m.g();
            this.f42253l.setData(list);
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            HashMap hashMap = new HashMap();
            hashMap.put("tab", this.f42259r ? "flexible" : "fixed");
            BaseModuleConfig.a().w("app_earn_all_exposure", hashMap);
            if (this.f42259r) {
                if (uh.i.d().h()) {
                    BaseModuleConfig.a().w("app_earn_auto_transfer_switch_exposure", (HashMap) null);
                }
                ViewUtil.m(this.f42257p, uh.i.d().h());
                ViewUtil.m(this.f42258q, uh.i.d().h());
                return;
            }
            ViewUtil.m(this.f42257p, false);
            ViewUtil.m(this.f42258q, false);
        }
    }
}
