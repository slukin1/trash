package com.huobi.finance.viewhandler;

import al.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import bl.m0;
import bl.n0;
import bl.o0;
import bl.p0;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.w;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.AssetPositionQuantData;
import com.huobi.share.AssetShareHelper;
import com.xiaomi.mipush.sdk.Constants;
import i6.r;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import s9.d;
import v9.c;

public class AssetPositionQuantItemViewHandler implements d<AssetPositionQuantData> {

    public class a implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssetPositionQuantData f67592a;

        public a(AssetPositionQuantData assetPositionQuantData) {
            this.f67592a = assetPositionQuantData;
        }

        public int a() {
            if (this.f67592a.t() == null || Double.valueOf(this.f67592a.t()).doubleValue() == 0.0d) {
                return R$string.n_grid_share_subtitle_2;
            }
            if (Double.valueOf(this.f67592a.t()).doubleValue() > 0.0d) {
                return R$string.n_grid_share_subtitle_1;
            }
            return R$string.n_grid_share_subtitle_3;
        }

        public int b() {
            if (this.f67592a.t() == null || Double.valueOf(this.f67592a.t()).doubleValue() == 0.0d) {
                return R$drawable.share_asset_strategy_cow_3;
            }
            if (Double.valueOf(this.f67592a.t()).doubleValue() > 0.0d) {
                return R$drawable.share_asset_strategy_cow_1;
            }
            return R$drawable.share_asset_strategy_cow_2;
        }

        public int c() {
            if (this.f67592a.t() == null || Double.valueOf(this.f67592a.t()).doubleValue() == 0.0d) {
                return R$string.n_grid_share_title_2;
            }
            if (Double.valueOf(this.f67592a.t()).doubleValue() > 0.0d) {
                return R$string.n_grid_share_title_1;
            }
            return R$string.n_grid_share_title_3;
        }
    }

    public static /* synthetic */ void h(MotionLayout motionLayout, int i11, AssetPositionQuantData assetPositionQuantData, Context context, Void voidR) {
        motionLayout.u0();
        l.f().c(i11, assetPositionQuantData.j());
        AssetModuleConfig.a().E(context, assetPositionQuantData.p());
        HashMap hashMap = new HashMap();
        hashMap.put("app_assets_shortcuts_click_button", "operate");
        BaseModuleConfig.a().w("app_assets_shortcuts_click", hashMap);
    }

    public static /* synthetic */ void i(MotionLayout motionLayout, int i11, AssetPositionQuantData assetPositionQuantData, Context context, Void voidR) {
        motionLayout.u0();
        l.f().c(i11, assetPositionQuantData.j());
        AssetModuleConfig.a().X0(context, assetPositionQuantData.p());
        HashMap hashMap = new HashMap();
        hashMap.put("app_assets_shortcuts_click_button", "details");
        BaseModuleConfig.a().w("app_assets_shortcuts_click", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(MotionLayout motionLayout, int i11, AssetPositionQuantData assetPositionQuantData, Context context, Void voidR) {
        motionLayout.u0();
        l.f().c(i11, assetPositionQuantData.j());
        l(context, assetPositionQuantData);
    }

    public static /* synthetic */ void k(MotionLayout motionLayout, int i11, AssetPositionQuantData assetPositionQuantData, Void voidR) {
        if (motionLayout.getProgress() == 1.0f) {
            motionLayout.u0();
            l.f().c(i11, assetPositionQuantData.j());
        } else if (motionLayout.getProgress() == 0.0f) {
            motionLayout.s0();
            l.f().k(i11, assetPositionQuantData.j());
        }
        gi.a.s(assetPositionQuantData.j(), false);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: f */
    public void handleView(c cVar, int i11, AssetPositionQuantData assetPositionQuantData, ViewGroup viewGroup) {
        c cVar2 = cVar;
        int i12 = i11;
        AssetPositionQuantData assetPositionQuantData2 = assetPositionQuantData;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        MotionLayout motionLayout = (MotionLayout) cVar2.itemView.findViewById(R$id.position_quant_root);
        TextView textView = (TextView) e11.b(R$id.level_coin_symbol);
        TextView textView2 = (TextView) e11.b(R$id.level_contract_bond);
        TextView textView3 = (TextView) e11.b(R$id.level_contract_position);
        TextView textView4 = (TextView) e11.b(R$id.level_contract_profit);
        TextView textView5 = (TextView) e11.b(R$id.level_contract_profit_number);
        View b11 = e11.b(R$id.asset_p_contract_markets);
        View b12 = e11.b(R$id.asset_p_contract_details);
        View b13 = e11.b(R$id.asset_p_contract_share);
        View b14 = e11.b(R$id.constraintLayout);
        ((TextView) e11.b(R$id.level_position_type)).setVisibility(8);
        if (l.f().h(i12, assetPositionQuantData.j())) {
            motionLayout.setProgress(1.0f);
        } else {
            motionLayout.setProgress(0.0f);
        }
        textView.setText(assetPositionQuantData.s().toUpperCase());
        textView2.setText(assetPositionQuantData.q());
        String E = LegalCurrencyConfigUtil.E("usdt", assetPositionQuantData.m());
        if (assetPositionQuantData.d()) {
            String str = E.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? "" : "+";
            textView3.setText(LegalCurrencyConfigUtil.E("usdt", assetPositionQuantData.h()));
            textView4.setText(str + E);
            textView5.setText(str + assetPositionQuantData.n());
        } else {
            textView3.setText("*****");
            textView4.setText("*****");
            textView5.setText("*****");
        }
        w.n(textView4, E);
        w.n(textView5, assetPositionQuantData.i());
        Observable<Void> a11 = dw.a.a(b11);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(1000, timeUnit).subscribe(new o0(motionLayout, i12, assetPositionQuantData2, context));
        dw.a.a(b12).throttleFirst(1000, timeUnit).subscribe(new n0(motionLayout, i12, assetPositionQuantData2, context));
        dw.a.a(b13).throttleFirst(1000, timeUnit).subscribe(new p0(this, motionLayout, i11, assetPositionQuantData, context));
        dw.a.a(b14).throttleFirst(1000, timeUnit).subscribe(new m0(motionLayout, i12, assetPositionQuantData2));
    }

    /* renamed from: g */
    public void a(c cVar, int i11, AssetPositionQuantData assetPositionQuantData, ViewGroup viewGroup, List<Object> list) {
        if (list != null && !list.isEmpty()) {
            MotionLayout motionLayout = (MotionLayout) cVar.itemView.findViewById(R$id.position_quant_root);
            if (list.get(0).equals("collapse")) {
                motionLayout.u0();
            } else {
                motionLayout.s0();
            }
        }
    }

    public int getResId() {
        return R$layout.item_asset_position_quant_content;
    }

    public final void l(Context context, AssetPositionQuantData assetPositionQuantData) {
        a aVar = new a(assetPositionQuantData);
        View loadView = AssetShareHelper.loadView(context, assetPositionQuantData.t(), aVar);
        TextView textView = (TextView) loadView.findViewById(R$id.tv_symbol);
        if (!TextUtils.isEmpty(assetPositionQuantData.s())) {
            textView.setVisibility(0);
            textView.setText(assetPositionQuantData.s().toUpperCase() + context.getString(R$string.n_grid_grid_strategy));
        }
        ((TextView) loadView.findViewById(R$id.tv_hield_currency)).setText(context.getString(R$string.n_asset_cumulative_yield));
        loadView.findViewById(R$id.layout_title).setVisibility(0);
        TextView textView2 = (TextView) loadView.findViewById(R$id.tv_subtitle);
        textView2.setVisibility(0);
        textView2.setText(context.getString(aVar.a()));
        ViewGroup viewGroup = (ViewGroup) loadView.findViewById(R$id.layout_position);
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_asset_position_stretage, viewGroup, true);
        viewGroup.setVisibility(0);
        ((TextView) inflate.findViewById(R$id.tv_price_range)).setText(String.format(context.getString(R$string.n_grid_trade_price_range_with_quote), new Object[]{assetPositionQuantData.getQuoteCurrency().toUpperCase()}));
        ((TextView) inflate.findViewById(R$id.tv_price_range_value)).setText(assetPositionQuantData.l() + Constants.WAVE_SEPARATOR + assetPositionQuantData.k());
        ((TextView) inflate.findViewById(R$id.tv_vol_amount_value)).setText(String.valueOf(assetPositionQuantData.u()));
        ((TextView) inflate.findViewById(R$id.tv_strategy_runtime_value)).setText(DateTimeUtils.e(assetPositionQuantData.o()));
        AssetShareHelper.share(context, loadView);
    }
}
