package com.huobi.finance.viewhandler;

import al.k;
import al.l;
import al.p;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.FragmentActivity;
import bl.i;
import bl.j;
import bl.n;
import bl.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.finance.bean.AssetPositionCoinData;
import com.huobi.share.AssetShareHelper;
import com.huobi.view.BottomAlterCostDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import s9.d;
import v9.c;

public class AssetPositionCoinItemViewHandler implements d<AssetPositionCoinData> {

    /* renamed from: b  reason: collision with root package name */
    public BottomAlterCostDialogFragment f67582b;

    public class a implements BottomAlterCostDialogFragment.DialogCloseCallback {
        public a() {
        }

        public void onDialogClose(String str) {
        }
    }

    public class b implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssetPositionCoinData f67584a;

        public b(AssetPositionCoinData assetPositionCoinData) {
            this.f67584a = assetPositionCoinData;
        }

        public int a() {
            return 0;
        }

        public int b() {
            if (this.f67584a.v() == null || Double.valueOf(this.f67584a.v()).doubleValue() == 0.0d) {
                return R$drawable.share_asset_position_cow_2;
            }
            if (Double.valueOf(this.f67584a.v()).doubleValue() > 0.0d) {
                return R$drawable.share_asset_position_cow_1;
            }
            return R$drawable.share_asset_position_cow_3;
        }

        public int c() {
            if (this.f67584a.v() == null || Double.valueOf(this.f67584a.v()).doubleValue() == 0.0d) {
                return R$string.n_asset_share_total_same;
            }
            if (Double.valueOf(this.f67584a.v()).doubleValue() > 0.0d) {
                return R$string.n_asset_share_total_great;
            }
            return R$string.n_asset_share_total_less;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void l(String str, Context context, View view) {
        if (this.f67582b == null) {
            this.f67582b = new BottomAlterCostDialogFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.CURRENCY, str);
        this.f67582b.setArguments(bundle);
        this.f67582b.setOnDialogCloseCallback(new a());
        this.f67582b.show(((FragmentActivity) context).getSupportFragmentManager(), BottomAlterCostDialogFragment.class.getName());
        BaseModuleConfig.a().w("app_assets_alter Cost_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void m(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context, String str, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionCoinData.t());
        gi.a.r(assetPositionCoinData.t(), FirebaseAnalytics.Param.PRICE, assetPositionCoinData.r());
        k.a(context, str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void n(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context, String str, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionCoinData.t());
        gi.a.r(assetPositionCoinData.t(), "trade", assetPositionCoinData.r());
        k.c(context, str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void o(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context, String str, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionCoinData.t());
        k.b(context, str);
        gi.a.r(assetPositionCoinData.t(), "openOrders", assetPositionCoinData.r());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void p(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionCoinData.t());
        AssetModuleConfig.a().s0(context, assetPositionCoinData.q());
        gi.a.r(assetPositionCoinData.t(), "details", assetPositionCoinData.r());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionCoinData.t());
        t(context, assetPositionCoinData);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void r(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, View view) {
        if (motionLayout.getProgress() == 1.0f) {
            motionLayout.u0();
            l.f().c(i11, assetPositionCoinData.t());
        } else if (motionLayout.getProgress() == 0.0f) {
            motionLayout.s0();
            l.f().k(i11, assetPositionCoinData.t());
        }
        gi.a.q(assetPositionCoinData.t(), FirebaseAnalytics.Param.CURRENCY, assetPositionCoinData.r());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void s(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context, Void voidR) {
        if (motionLayout.getProgress() == 1.0f) {
            motionLayout.u0();
            l.f().c(i11, assetPositionCoinData.t());
        }
        AssetModuleConfig.a().s0(context, assetPositionCoinData.q());
        gi.a.q(assetPositionCoinData.t(), "notCurrency", assetPositionCoinData.r());
    }

    public int getResId() {
        return R$layout.item_asset_position_coin_content;
    }

    /* renamed from: j */
    public void handleView(c cVar, int i11, AssetPositionCoinData assetPositionCoinData, ViewGroup viewGroup) {
        c cVar2 = cVar;
        int i12 = i11;
        AssetPositionCoinData assetPositionCoinData2 = assetPositionCoinData;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        MotionLayout motionLayout = (MotionLayout) cVar2.itemView.findViewById(R$id.position_coin_root);
        View b11 = e11.b(R$id.constraintLayout);
        ImageView imageView = (ImageView) e11.b(R$id.chase_coin_symbol_icon);
        ((TextView) e11.b(R$id.chase_coin_symbol)).setText(assetPositionCoinData.r().toUpperCase());
        TextView textView = (TextView) e11.b(R$id.chase_contract_position);
        TextView textView2 = (TextView) e11.b(R$id.chase_average_price);
        TextView textView3 = (TextView) e11.b(R$id.chase_contract_profit);
        TextView textView4 = (TextView) e11.b(R$id.chase_contract_profit_number);
        ViewUtil.m(e11.b(R$id.chase_coin_liabilities), m.a(assetPositionCoinData.l()).compareTo(BigDecimal.ZERO) < 0);
        String upperCase = BaseModuleConfig.a().M().toUpperCase();
        String z11 = assetPositionCoinData.z();
        boolean L = d7.k.C().L(z11);
        View view = b11;
        f6.c.a().l(cVar2.itemView.getContext(), p.k(z11), imageView, p.m());
        String t11 = a1.v().t(z11);
        a1.v().J(t11, TradeType.PRO);
        boolean z12 = TextUtils.isEmpty(t11) ? true : L;
        textView3.setTextColor(context.getResources().getColor(R$color.baseColorPrimaryText));
        View b12 = e11.b(R$id.asset_p_contract_markets);
        View b13 = e11.b(R$id.asset_p_contract_trade);
        View b14 = e11.b(R$id.asset_p_contract_order);
        View b15 = e11.b(R$id.asset_p_contract_details);
        View b16 = e11.b(R$id.asset_p_contract_share);
        View view2 = b14;
        boolean z13 = z12;
        TextView textView5 = (TextView) e11.b(R$id.asset_p_contract_available_content);
        TextView textView6 = (TextView) e11.b(R$id.asset_p_contract_timer);
        View view3 = b13;
        TextView textView7 = (TextView) e11.b(R$id.asset_p_contract_price_content);
        View view4 = b12;
        TextView textView8 = (TextView) e11.b(R$id.asset_p_contract_cost_content);
        MotionLayout motionLayout2 = motionLayout;
        String str = z11;
        TextView textView9 = (TextView) e11.b(R$id.asset_p_contract_pl_content);
        View b17 = e11.b(R$id.asset_p_contract_update_cost);
        ((TextView) e11.b(R$id.asset_p_contract_available)).setText(context.getString(R$string.n_asset_position_available_and_debts));
        int i13 = R$string.n_asset_position_mk_price_and_cost;
        TextView textView10 = (TextView) e11.b(R$id.asset_p_contract_margin_content);
        ((TextView) e11.b(R$id.asset_p_contract_price)).setText(context.getString(i13, new Object[]{upperCase}));
        ((TextView) e11.b(R$id.asset_p_contract_margin)).setText(context.getString(R$string.n_asset_position_all_margin_pl, new Object[]{upperCase}));
        ViewUtil.m(b17, !"--".equals(assetPositionCoinData.m()));
        int a11 = w.a(assetPositionCoinData.o());
        int a12 = w.a(assetPositionCoinData.h());
        if (assetPositionCoinData.d()) {
            textView.setText(assetPositionCoinData.w());
            textView2.setText(assetPositionCoinData.s());
            textView3.setText(assetPositionCoinData.o());
            textView4.setText(assetPositionCoinData.p());
            textView5.setText(assetPositionCoinData.j());
            textView6.setText(m.a(assetPositionCoinData.l()).min(BigDecimal.ZERO).toPlainString());
            textView7.setText(assetPositionCoinData.n());
            textView8.setText(assetPositionCoinData.m());
            TextView textView11 = textView10;
            textView11.setText(assetPositionCoinData.h());
            TextView textView12 = textView9;
            textView12.setText(assetPositionCoinData.i());
            textView3.setTextColor(context.getResources().getColor(a11));
            textView4.setTextColor(context.getResources().getColor(a11));
            textView11.setTextColor(context.getResources().getColor(a12));
            textView12.setTextColor(context.getResources().getColor(a12));
        } else {
            TextView textView13 = textView10;
            TextView textView14 = textView9;
            textView.setText("*****");
            textView2.setText("*****");
            textView3.setText("*****");
            textView4.setText("*****");
            textView5.setText("*****");
            textView6.setText("*****");
            textView7.setText("*****");
            textView8.setText("*****");
            textView13.setText("*****");
            textView14.setText("*****");
            textView3.setTextColor(context.getResources().getColor(w.e()));
            textView4.setTextColor(context.getResources().getColor(w.e()));
            textView13.setTextColor(context.getResources().getColor(w.e()));
            textView14.setTextColor(context.getResources().getColor(w.e()));
        }
        String str2 = str;
        b17.setOnClickListener(new o(this, str2, context));
        MotionLayout motionLayout3 = motionLayout2;
        int i14 = i11;
        AssetPositionCoinData assetPositionCoinData3 = assetPositionCoinData;
        Context context2 = context;
        String str3 = str2;
        view4.setOnClickListener(new bl.m(motionLayout3, i14, assetPositionCoinData3, context2, str3));
        view3.setOnClickListener(new bl.l(motionLayout3, i14, assetPositionCoinData3, context2, str3));
        view2.setOnClickListener(new bl.k(motionLayout3, i14, assetPositionCoinData3, context2, str3));
        int i15 = i11;
        AssetPositionCoinData assetPositionCoinData4 = assetPositionCoinData;
        MotionLayout motionLayout4 = motionLayout2;
        b15.setOnClickListener(new j(motionLayout4, i15, assetPositionCoinData4, context));
        b16.setOnClickListener(new n(this, motionLayout4, i11, assetPositionCoinData, context));
        if (l.f().h(i15, assetPositionCoinData.t())) {
            motionLayout4.setProgress(1.0f);
        } else {
            motionLayout4.setProgress(0.0f);
        }
        i iVar = new i(motionLayout4, i15, assetPositionCoinData4);
        if (!z13) {
            view.setOnClickListener(iVar);
        } else {
            dw.a.a(view).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe(new bl.p(motionLayout4, i15, assetPositionCoinData4, context));
        }
    }

    /* renamed from: k */
    public void a(c cVar, int i11, AssetPositionCoinData assetPositionCoinData, ViewGroup viewGroup, List<Object> list) {
        if (list != null && !list.isEmpty()) {
            MotionLayout motionLayout = (MotionLayout) cVar.itemView.findViewById(R$id.position_coin_root);
            if (list.get(0).equals("collapse")) {
                motionLayout.u0();
            } else {
                motionLayout.s0();
            }
        }
    }

    public final void t(Context context, AssetPositionCoinData assetPositionCoinData) {
        View loadView = AssetShareHelper.loadView(context, assetPositionCoinData.v(), new b(assetPositionCoinData));
        loadView.findViewById(R$id.layout_title).setVisibility(0);
        ((TextView) loadView.findViewById(R$id.tv_title)).setTextColor(context.getResources().getColor(R$color.white));
        ViewGroup viewGroup = (ViewGroup) loadView.findViewById(R$id.layout_position);
        viewGroup.setVisibility(0);
        LayoutInflater.from(context).inflate(R$layout.layout_asset_position_contract, viewGroup, true);
        ((TextView) viewGroup.findViewById(R$id.tv_symbol)).setText(assetPositionCoinData.z().toUpperCase());
        ImageView imageView = (ImageView) viewGroup.findViewById(R$id.iv_icon);
        imageView.setVisibility(0);
        f6.c.a().l(context, p.k(assetPositionCoinData.z()), imageView, p.m());
        ((TextView) viewGroup.findViewById(R$id.tv_price_title)).setText(context.getString(R$string.contarct_share_position_cur_price));
        ((TextView) viewGroup.findViewById(R$id.tv_price)).setText(TextUtils.isEmpty(assetPositionCoinData.n()) ? "" : assetPositionCoinData.n());
        AssetShareHelper.share(context, loadView);
    }
}
