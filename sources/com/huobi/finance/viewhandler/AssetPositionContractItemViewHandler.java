package com.huobi.finance.viewhandler;

import al.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import bl.q;
import bl.s;
import bl.t;
import bl.u;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.AssetPositionContractData;
import com.huobi.share.AssetShareHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.util.List;
import java.util.concurrent.TimeUnit;
import s9.d;
import v9.c;

public class AssetPositionContractItemViewHandler implements d<AssetPositionContractData> {

    public class a implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssetPositionContractData f67586a;

        public a(AssetPositionContractData assetPositionContractData) {
            this.f67586a = assetPositionContractData;
        }

        public int a() {
            return -1;
        }

        public int b() {
            if (this.f67586a.m() == null || Double.valueOf(this.f67586a.m()).doubleValue() == 0.0d) {
                return R$drawable.share_asset_contract_cow_3;
            }
            if (Double.valueOf(this.f67586a.m()).doubleValue() > 0.0d) {
                return R$drawable.share_asset_contract_cow_1;
            }
            return R$drawable.share_asset_contract_cow_2;
        }

        public int c() {
            if (this.f67586a.m() == null || Double.valueOf(this.f67586a.m()).doubleValue() == 0.0d) {
                return R$string.contract_share_profit_hint2;
            }
            if (Double.valueOf(this.f67586a.m()).doubleValue() > 0.0d) {
                return R$string.contract_share_profit_win_mid_hint1;
            }
            return R$string.contract_share_profit_lose_mid_hint1;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j(MotionLayout motionLayout, int i11, AssetPositionContractData assetPositionContractData, Context context, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionContractData.p());
        q(context, assetPositionContractData.B(), assetPositionContractData.k(), assetPositionContractData.E());
        gi.a.r(assetPositionContractData.p(), FirebaseAnalytics.Param.PRICE, assetPositionContractData.C());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void k(MotionLayout motionLayout, int i11, AssetPositionContractData assetPositionContractData, Context context, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionContractData.p());
        o(context, assetPositionContractData.B(), assetPositionContractData.k(), assetPositionContractData.E());
        gi.a.r(assetPositionContractData.p(), "trade", assetPositionContractData.C());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void l(MotionLayout motionLayout, int i11, AssetPositionContractData assetPositionContractData, Context context, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionContractData.p());
        p(context, assetPositionContractData.B(), assetPositionContractData.k(), assetPositionContractData.E(), assetPositionContractData.s(), assetPositionContractData.G(), assetPositionContractData.D());
        gi.a.r(assetPositionContractData.p(), "details", assetPositionContractData.C());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(MotionLayout motionLayout, int i11, AssetPositionContractData assetPositionContractData, Context context, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionContractData.p());
        r(context, assetPositionContractData);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void n(MotionLayout motionLayout, int i11, AssetPositionContractData assetPositionContractData, Void voidR) {
        if (motionLayout.getProgress() == 1.0f) {
            motionLayout.u0();
            l.f().c(i11, assetPositionContractData.p());
        } else if (motionLayout.getProgress() == 0.0f) {
            motionLayout.s0();
            l.f().k(i11, assetPositionContractData.p());
        }
        gi.a.q(assetPositionContractData.p(), FirebaseAnalytics.Param.CURRENCY, assetPositionContractData.C());
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: g */
    public void handleView(c cVar, int i11, AssetPositionContractData assetPositionContractData, ViewGroup viewGroup) {
        String str;
        int i12;
        MotionLayout motionLayout;
        c cVar2 = cVar;
        int i13 = i11;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        Resources resources = context.getResources();
        String upperCase = BaseModuleConfig.a().M().toUpperCase();
        View b11 = e11.b(R$id.constraintLayout);
        TextView textView = (TextView) e11.b(R$id.many);
        TextView textView2 = (TextView) e11.b(R$id.coin_symbol);
        TextView textView3 = (TextView) e11.b(R$id.position_type);
        TextView textView4 = (TextView) e11.b(R$id.limit);
        TextView textView5 = (TextView) e11.b(R$id.contract_position);
        TextView textView6 = (TextView) e11.b(R$id.contract_profit);
        TextView textView7 = (TextView) e11.b(R$id.contract_profit_number);
        View view = b11;
        MotionLayout motionLayout2 = (MotionLayout) cVar2.itemView.findViewById(R$id.position_contract_root);
        TextView textView8 = (TextView) e11.b(R$id.asset_p_contract_margin_content);
        TextView textView9 = (TextView) e11.b(R$id.asset_p_contract_pl_content);
        View b12 = e11.b(R$id.contract_risk_layout);
        TextView textView10 = (TextView) e11.b(R$id.asset_p_contract_cost_content);
        TextView textView11 = (TextView) e11.b(R$id.asset_p_contract_price_content);
        r rVar = e11;
        int i14 = R$string.n_asset_position_contract_price_cost;
        TextView textView12 = (TextView) e11.b(R$id.asset_p_contract_available_content);
        TextView textView13 = (TextView) e11.b(R$id.average_price);
        ((TextView) e11.b(R$id.asset_p_contract_price)).setText(context.getString(i14, new Object[]{upperCase}));
        ((TextView) e11.b(R$id.asset_p_contract_margin)).setText(context.getString(R$string.n_asset_position_contract_margin_pl, new Object[]{upperCase}));
        boolean equalsIgnoreCase = "buy".equalsIgnoreCase(assetPositionContractData.n());
        if (equalsIgnoreCase) {
            str = resources.getString(R$string.n_asset_future_buy);
        } else {
            str = resources.getString(R$string.n_asset_future_sell);
        }
        textView.setText(str);
        ViewUtil.m(b12, i(assetPositionContractData.r(), m.n0(assetPositionContractData.z()).toPlainString()));
        Drawable drawable = resources.getDrawable(R$drawable.asset_future_direction_bg_green);
        Drawable drawable2 = resources.getDrawable(R$drawable.asset_future_direction_bg_red);
        if (!w.l() ? !equalsIgnoreCase : equalsIgnoreCase) {
            drawable = drawable2;
        }
        textView.setBackground(drawable);
        textView2.setText(assetPositionContractData.C());
        if (assetPositionContractData.G()) {
            i12 = R$string.n_contract_super_margin;
        } else {
            i12 = R$string.n_contract_trade_margin;
        }
        textView3.setText(i12);
        textView4.setText(assetPositionContractData.t());
        String str2 = assetPositionContractData.h() + assetPositionContractData.i();
        int color = resources.getColor(assetPositionContractData.x());
        textView6.setTextColor(color);
        textView7.setTextColor(color);
        if (assetPositionContractData.d()) {
            textView5.setText(assetPositionContractData.v());
            textView13.setText(str2);
            textView6.setText(assetPositionContractData.w());
            textView7.setText(assetPositionContractData.y());
            textView12.setText(assetPositionContractData.j());
            textView11.setText(LegalCurrencyConfigUtil.E(assetPositionContractData.B(), "1"));
            textView10.setText(LegalCurrencyConfigUtil.E("usdt", assetPositionContractData.A()));
            textView8.setText(assetPositionContractData.u());
            textView9.setText(assetPositionContractData.z());
        } else {
            textView5.setText("*****");
            textView6.setText("*****");
            textView7.setText("*****");
            textView13.setText("*****");
            textView12.setText("*****");
            textView11.setText("*****");
            textView10.setText("*****");
            textView8.setText("*****");
            textView9.setText("*****");
        }
        r rVar2 = rVar;
        View b13 = rVar2.b(R$id.asset_p_contract_markets);
        View b14 = rVar2.b(R$id.asset_p_contract_trade);
        MotionLayout motionLayout3 = motionLayout2;
        int i15 = i11;
        AssetPositionContractData assetPositionContractData2 = assetPositionContractData;
        Context context2 = context;
        b13.setOnClickListener(new bl.r(this, motionLayout3, i15, assetPositionContractData2, context2));
        b14.setOnClickListener(new q(this, motionLayout3, i15, assetPositionContractData2, context2));
        rVar2.b(R$id.asset_p_contract_details).setOnClickListener(new t(this, motionLayout3, i15, assetPositionContractData2, context2));
        rVar2.b(R$id.asset_p_contract_share).setOnClickListener(new s(this, motionLayout3, i15, assetPositionContractData2, context2));
        int i16 = i11;
        if (l.f().h(i16, assetPositionContractData.p())) {
            motionLayout = motionLayout2;
            motionLayout.setProgress(1.0f);
        } else {
            motionLayout = motionLayout2;
            motionLayout.setProgress(0.0f);
        }
        dw.a.a(view).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe(new u(motionLayout, i16, assetPositionContractData));
    }

    public int getResId() {
        return R$layout.item_asset_position_contract_content;
    }

    /* renamed from: h */
    public void a(c cVar, int i11, AssetPositionContractData assetPositionContractData, ViewGroup viewGroup, List<Object> list) {
        if (list != null && !list.isEmpty()) {
            MotionLayout motionLayout = (MotionLayout) cVar.itemView.findViewById(R$id.position_contract_root);
            if (list.get(0).equals("collapse")) {
                motionLayout.u0();
            } else {
                motionLayout.s0();
            }
        }
    }

    public final boolean i(String str, String str2) {
        int k02 = m.k0(str);
        double h02 = m.h0(m.a(str2).multiply(m.f68179a).setScale(2).toPlainString());
        if (k02 >= 0 && k02 < 3) {
            return h02 <= 10.0d;
        }
        if (k02 >= 3 && k02 < 5) {
            return h02 <= 20.0d;
        }
        if (k02 >= 5 && k02 < 20) {
            return h02 <= 30.0d;
        }
        if (k02 >= 20 && k02 < 50) {
            return h02 <= 40.0d;
        }
        if (k02 >= 50) {
            return h02 <= 50.0d;
        }
        return false;
    }

    public final void o(Context context, String str, String str2, TradeType tradeType) {
        if (tradeType == TradeType.CONTRACT) {
            AssetModuleConfig.a().f1(context, str, str2);
        } else if (tradeType == TradeType.SWAP) {
            AssetModuleConfig.a().O(context, str);
        } else if (tradeType == TradeType.LINEAR_SWAP) {
            AssetModuleConfig.a().h1(context, str, str2);
        }
    }

    public final void p(Context context, String str, String str2, TradeType tradeType, String str3, boolean z11, String str4) {
        if (tradeType == TradeType.CONTRACT) {
            ContractAccountInfo contractAccountInfo = new ContractAccountInfo();
            contractAccountInfo.setSymbol(str);
            contractAccountInfo.setNewAssetData(true);
            AssetModuleConfig.a().s(context, contractAccountInfo);
        } else if (tradeType == TradeType.SWAP) {
            SwapAccountInfo swapAccountInfo = new SwapAccountInfo();
            swapAccountInfo.setSymbol(str);
            swapAccountInfo.setContractCode(str2);
            AssetModuleConfig.a().Q(context, swapAccountInfo);
        } else if (tradeType == TradeType.LINEAR_SWAP) {
            LinearSwapAccountInfo linearSwapAccountInfo = new LinearSwapAccountInfo();
            linearSwapAccountInfo.setSymbol(str);
            linearSwapAccountInfo.setCross(z11);
            if (z11) {
                linearSwapAccountInfo.setSymbol(str4);
                linearSwapAccountInfo.setTradePartition(str4);
            }
            if (TextUtils.isEmpty(str3)) {
                linearSwapAccountInfo.setContractCode(str2);
            } else {
                linearSwapAccountInfo.setContractCode(str3);
            }
            AssetModuleConfig.a().G(context, linearSwapAccountInfo);
        }
    }

    public final void q(Context context, String str, String str2, TradeType tradeType) {
        if (tradeType == TradeType.CONTRACT) {
            AssetModuleConfig.a().u0(context, str, str2);
        } else if (tradeType == TradeType.SWAP) {
            AssetModuleConfig.a().v(context, str, str2);
        } else if (tradeType == TradeType.LINEAR_SWAP) {
            AssetModuleConfig.a().V0(context, str, str2);
        }
    }

    public final void r(Context context, AssetPositionContractData assetPositionContractData) {
        String str;
        int i11;
        View loadView = AssetShareHelper.loadView(context, assetPositionContractData.m(), new a(assetPositionContractData));
        loadView.findViewById(R$id.layout_title).setVisibility(0);
        ((TextView) loadView.findViewById(R$id.tv_title)).setTextColor(context.getResources().getColor(R$color.white));
        ViewGroup viewGroup = (ViewGroup) loadView.findViewById(R$id.layout_position);
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_asset_position_contract, viewGroup, true);
        viewGroup.setVisibility(0);
        ((TextView) inflate.findViewById(R$id.tv_symbol)).setText(assetPositionContractData.C().toUpperCase());
        TextView textView = (TextView) inflate.findViewById(R$id.tv_lever_rate);
        boolean equalsIgnoreCase = "buy".equalsIgnoreCase(assetPositionContractData.n());
        if (equalsIgnoreCase) {
            str = context.getString(R$string.n_asset_future_buy);
        } else {
            str = context.getString(R$string.n_asset_future_sell);
        }
        textView.setText(str + " " + assetPositionContractData.r() + "X");
        textView.setVisibility(0);
        if (equalsIgnoreCase) {
            i11 = w.h();
        } else {
            i11 = w.d();
        }
        textView.setTextColor(i11);
        ((TextView) inflate.findViewById(R$id.tv_price_title)).setTextColor(context.getResources().getColor(R$color.color_E9EAED));
        ((TextView) inflate.findViewById(R$id.tv_price)).setText(LegalCurrencyConfigUtil.E(assetPositionContractData.B(), "1"));
        AssetShareHelper.share(context, loadView);
    }
}
