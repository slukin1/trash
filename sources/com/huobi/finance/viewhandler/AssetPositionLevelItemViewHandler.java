package com.huobi.finance.viewhandler;

import al.l;
import al.p;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.content.ContextCompat;
import bl.e0;
import bl.f0;
import bl.g0;
import bl.h0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.AssetPositionLevelData;
import com.jumio.sdk.reject.JumioRejectReason;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import gi.a;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import s9.d;
import v9.c;

public class AssetPositionLevelItemViewHandler implements d<AssetPositionLevelData> {
    @SensorsDataInstrumented
    public static /* synthetic */ void j(MotionLayout motionLayout, int i11, AssetPositionLevelData assetPositionLevelData, Context context, String str, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionLevelData.l());
        if (assetPositionLevelData.t()) {
            AssetModuleConfig.a().e(context, a1.v().t(assetPositionLevelData.k()), false, TradeType.PRO);
        } else {
            AssetModuleConfig.a().e(context, assetPositionLevelData.k(), false, TradeType.PRO);
        }
        a.r(assetPositionLevelData.l(), FirebaseAnalytics.Param.PRICE, str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void k(MotionLayout motionLayout, int i11, AssetPositionLevelData assetPositionLevelData, Context context, String str, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionLevelData.l());
        if (assetPositionLevelData.t()) {
            AssetModuleConfig.a().f0(context, assetPositionLevelData.k());
        } else {
            AssetModuleConfig.a().t(context, assetPositionLevelData.getQuoteCurrency(), assetPositionLevelData.getBaseCurrency());
        }
        a.r(assetPositionLevelData.l(), "borrow", str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void l(MotionLayout motionLayout, int i11, AssetPositionLevelData assetPositionLevelData, Context context, String str, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionLevelData.l());
        AssetModuleConfig.a().C0(context, assetPositionLevelData.t(), assetPositionLevelData.k());
        a.r(assetPositionLevelData.l(), "details", str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void m(MotionLayout motionLayout, int i11, AssetPositionLevelData assetPositionLevelData, String str, Void voidR) {
        if (motionLayout.getProgress() == 1.0f) {
            motionLayout.u0();
            l.f().c(i11, assetPositionLevelData.l());
        } else if (motionLayout.getProgress() == 0.0f) {
            motionLayout.s0();
            l.f().k(i11, assetPositionLevelData.l());
        }
        a.q(assetPositionLevelData.l(), FirebaseAnalytics.Param.CURRENCY, str);
    }

    public final String f(String str, String str2) {
        return p.j(str, str2);
    }

    public final String g(String str, boolean z11) {
        String str2;
        BigDecimal multiply = m.a(str).multiply(m.a("100"));
        if (multiply.compareTo(m.a(JumioRejectReason.NOT_READABLE)) >= 0) {
            return "≥200%";
        }
        if (z11) {
            str2 = m.q(multiply, 0);
        } else {
            str2 = m.I(multiply, 0);
        }
        return String.format("%s%%", new Object[]{str2});
    }

    public int getResId() {
        return R$layout.item_asset_position_level_content;
    }

    /* renamed from: h */
    public void handleView(c cVar, int i11, AssetPositionLevelData assetPositionLevelData, ViewGroup viewGroup) {
        String str;
        View view;
        String str2;
        r rVar;
        MotionLayout motionLayout;
        c cVar2 = cVar;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        MotionLayout motionLayout2 = (MotionLayout) cVar2.itemView.findViewById(R$id.position_level_root);
        View b11 = e11.b(R$id.constraintLayout);
        boolean t11 = assetPositionLevelData.t();
        View b12 = e11.b(R$id.asset_include_position_level);
        View b13 = e11.b(R$id.include_asset_position_chase_level_type);
        ViewUtil.m(b12, t11);
        ViewUtil.m(b13, !t11);
        if (l.f().h(i11, assetPositionLevelData.l())) {
            motionLayout2.setProgress(1.0f);
        } else {
            motionLayout2.setProgress(0.0f);
        }
        if (assetPositionLevelData.t()) {
            str = assetPositionLevelData.s();
        } else {
            str = assetPositionLevelData.getBaseCurrencyDisplayName() + "/" + assetPositionLevelData.o();
        }
        String str3 = str;
        if (assetPositionLevelData.t()) {
            TextView textView = (TextView) e11.b(R$id.level_contract_position);
            TextView textView2 = (TextView) e11.b(R$id.level_average_price);
            TextView textView3 = (TextView) e11.b(R$id.level_contract_bond_number);
            TextView textView4 = (TextView) e11.b(R$id.level_contract_profit);
            TextView textView5 = (TextView) e11.b(R$id.level_contract_profit_number);
            view = b11;
            ((TextView) e11.b(R$id.level_coin_symbol)).setText(assetPositionLevelData.s());
            ((TextView) e11.b(R$id.level_position_type)).setText(context.getString(R$string.n_contract_super_margin));
            ((TextView) e11.b(R$id.level_contract_bond)).setText(context.getString(R$string.n_trade_margin_ratio) + ":");
            BigDecimal abs = m.a(assetPositionLevelData.i()).abs();
            String f11 = f(abs.toPlainString(), assetPositionLevelData.k());
            if (assetPositionLevelData.d()) {
                textView.setText(LegalCurrencyConfigUtil.E(assetPositionLevelData.k(), assetPositionLevelData.n()));
                textView2.setText(f(assetPositionLevelData.f(), assetPositionLevelData.k()));
                textView4.setText(LegalCurrencyConfigUtil.E(assetPositionLevelData.k(), abs.toPlainString()));
                textView5.setText(f11);
                textView3.setText(g(assetPositionLevelData.r(), true));
                if (assetPositionLevelData.m().isHighRiskOrAbove()) {
                    textView3.setTextColor(ContextCompat.getColor(context, R$color.baseMarginDangerousTip));
                } else {
                    textView3.setTextColor(ContextCompat.getColor(context, R$color.baseColorSecondaryText));
                }
            } else {
                textView.setText("*****");
                textView2.setText("*****");
                textView4.setText("*****");
                textView3.setText("*****");
                textView3.setTextColor(ContextCompat.getColor(context, R$color.baseColorSecondaryText));
            }
            rVar = e11;
            motionLayout = motionLayout2;
            str2 = str3;
        } else {
            view = b11;
            View b14 = e11.b(R$id.base_include_layout);
            int i12 = R$id.chase_coin_symbol;
            TextView textView6 = (TextView) b14.findViewById(i12);
            int i13 = R$id.chase_contract_position;
            str2 = str3;
            TextView textView7 = (TextView) b14.findViewById(i13);
            motionLayout = motionLayout2;
            int i14 = R$id.chase_contract_profit;
            CharSequence charSequence = "*****";
            TextView textView8 = (TextView) e11.b(R$id.chase_header_contract_bond_number);
            int i15 = R$id.chase_contract_profit_number;
            TextView textView9 = (TextView) b14.findViewById(i14);
            TextView textView10 = (TextView) b14.findViewById(i15);
            int i16 = R$id.chase_average_price;
            TextView textView11 = (TextView) b14.findViewById(i16);
            View b15 = e11.b(R$id.quote_include_layout);
            TextView textView12 = (TextView) b15.findViewById(i12);
            TextView textView13 = (TextView) b15.findViewById(i13);
            TextView textView14 = (TextView) b15.findViewById(i14);
            TextView textView15 = (TextView) b15.findViewById(i15);
            TextView textView16 = (TextView) b15.findViewById(i16);
            Resources resources = context.getResources();
            rVar = e11;
            int i17 = R$color.baseColorSecondaryText;
            textView6.setTextColor(resources.getColor(i17));
            textView12.setTextColor(context.getResources().getColor(i17));
            StringBuilder sb2 = new StringBuilder();
            int i18 = i17;
            sb2.append(assetPositionLevelData.getBaseCurrencyDisplayName());
            sb2.append("/");
            sb2.append(assetPositionLevelData.o());
            ((TextView) e11.b(R$id.chase_header_coin_symbol)).setText(sb2.toString());
            ((TextView) e11.b(R$id.chase_header_position_type)).setText(context.getString(R$string.n_contract_trade_margin));
            ((TextView) e11.b(R$id.chase_header_contract_bond)).setText(context.getString(R$string.n_trade_margin_ratio) + ":");
            String baseCurrency = assetPositionLevelData.getBaseCurrency();
            textView6.setText(assetPositionLevelData.getBaseCurrencyDisplayName());
            String quoteCurrency = assetPositionLevelData.getQuoteCurrency();
            textView12.setText(assetPositionLevelData.o());
            if (assetPositionLevelData.d()) {
                textView7.setText(LegalCurrencyConfigUtil.E(baseCurrency, assetPositionLevelData.h()));
                textView11.setText(f(assetPositionLevelData.h(), baseCurrency));
                textView9.setText(LegalCurrencyConfigUtil.E(baseCurrency, assetPositionLevelData.g()));
                textView10.setText(f(assetPositionLevelData.g(), baseCurrency));
                textView13.setText(LegalCurrencyConfigUtil.E(quoteCurrency, assetPositionLevelData.q()));
                textView16.setText(f(assetPositionLevelData.q(), quoteCurrency));
                textView14.setText(LegalCurrencyConfigUtil.E(quoteCurrency, assetPositionLevelData.p()));
                textView15.setText(f(assetPositionLevelData.p(), quoteCurrency));
                TextView textView17 = textView8;
                textView17.setText(g(assetPositionLevelData.r(), false));
                if (assetPositionLevelData.m().isHighRiskOrAbove()) {
                    textView17.setTextColor(ContextCompat.getColor(context, R$color.baseMarginDangerousTip));
                } else {
                    textView17.setTextColor(ContextCompat.getColor(context, i18));
                }
            } else {
                TextView textView18 = textView8;
                CharSequence charSequence2 = charSequence;
                textView7.setText(charSequence2);
                textView9.setText(charSequence2);
                textView10.setText(charSequence2);
                textView11.setText(charSequence2);
                textView13.setText(charSequence2);
                textView14.setText(charSequence2);
                textView15.setText(charSequence2);
                textView16.setText(charSequence2);
                textView18.setText(charSequence2);
                textView18.setTextColor(ContextCompat.getColor(context, i18));
            }
        }
        r rVar2 = rVar;
        View b16 = rVar2.b(R$id.asset_p_contract_markets);
        View b17 = rVar2.b(R$id.asset_p_contract_trade);
        View b18 = rVar2.b(R$id.asset_p_contract_order);
        ((TextView) rVar2.b(R$id.contract_trade_text)).setText(context.getString(R$string.loan_coin));
        b18.setVisibility(8);
        MotionLayout motionLayout3 = motionLayout;
        int i19 = i11;
        AssetPositionLevelData assetPositionLevelData2 = assetPositionLevelData;
        Context context2 = context;
        String str4 = str2;
        b16.setOnClickListener(new e0(motionLayout3, i19, assetPositionLevelData2, context2, str4));
        b17.setOnClickListener(new f0(motionLayout3, i19, assetPositionLevelData2, context2, str4));
        rVar2.b(R$id.asset_p_contract_details).setOnClickListener(new g0(motionLayout3, i19, assetPositionLevelData2, context2, str4));
        dw.a.a(view).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe(new h0(motionLayout, i11, assetPositionLevelData, str4));
    }

    /* renamed from: i */
    public void a(c cVar, int i11, AssetPositionLevelData assetPositionLevelData, ViewGroup viewGroup, List<Object> list) {
        if (list != null && !list.isEmpty()) {
            MotionLayout motionLayout = (MotionLayout) cVar.itemView.findViewById(R$id.position_level_root);
            if (list.get(0).equals("collapse")) {
                motionLayout.u0();
            } else {
                motionLayout.s0();
            }
        }
    }
}
