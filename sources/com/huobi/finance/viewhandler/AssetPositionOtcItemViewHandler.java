package com.huobi.finance.viewhandler;

import al.l;
import al.p;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import bl.i0;
import bl.j0;
import bl.l0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.AssetPositionOtcData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gi.a;
import i6.m;
import i6.r;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jp.k0;
import s9.d;
import v9.c;

public class AssetPositionOtcItemViewHandler implements d<AssetPositionOtcData> {
    @SensorsDataInstrumented
    public static /* synthetic */ void h(MotionLayout motionLayout, int i11, AssetPositionOtcData assetPositionOtcData, Context context, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionOtcData.k());
        k0.p(context, assetPositionOtcData.i());
        a.r(assetPositionOtcData.k(), "trade", assetPositionOtcData.j());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(MotionLayout motionLayout, int i11, AssetPositionOtcData assetPositionOtcData, Context context, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionOtcData.k());
        if (context instanceof Activity) {
            AssetModuleConfig.a().k1((Activity) context, assetPositionOtcData.i(), "2");
        }
        a.r(assetPositionOtcData.k(), "transfer", assetPositionOtcData.j());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void j(MotionLayout motionLayout, int i11, AssetPositionOtcData assetPositionOtcData, Context context, View view) {
        motionLayout.u0();
        l.f().c(i11, assetPositionOtcData.k());
        AssetModuleConfig.a().J0(context, assetPositionOtcData.h());
        a.r(assetPositionOtcData.k(), "details", assetPositionOtcData.j());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void k(MotionLayout motionLayout, int i11, AssetPositionOtcData assetPositionOtcData, Void voidR) {
        if (motionLayout.getProgress() == 1.0f) {
            motionLayout.u0();
            l.f().c(i11, assetPositionOtcData.k());
        } else if (motionLayout.getProgress() == 0.0f) {
            motionLayout.s0();
            l.f().k(i11, assetPositionOtcData.k());
        }
        a.q(assetPositionOtcData.k(), FirebaseAnalytics.Param.CURRENCY, assetPositionOtcData.j());
    }

    /* renamed from: f */
    public void handleView(c cVar, int i11, AssetPositionOtcData assetPositionOtcData, ViewGroup viewGroup) {
        c cVar2 = cVar;
        int i12 = i11;
        AssetPositionOtcData assetPositionOtcData2 = assetPositionOtcData;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        MotionLayout motionLayout = (MotionLayout) cVar2.itemView.findViewById(R$id.position_otc_root);
        View b11 = e11.b(R$id.constraintLayout);
        TextView textView = (TextView) e11.b(R$id.chase_contract_position);
        TextView textView2 = (TextView) e11.b(R$id.chase_average_price);
        TextView textView3 = (TextView) e11.b(R$id.chase_contract_profit);
        TextView textView4 = (TextView) e11.b(R$id.chase_contract_profit_number);
        String plainString = m.a(assetPositionOtcData.g()).add(m.a(assetPositionOtcData.l())).toPlainString();
        ((TextView) e11.b(R$id.chase_coin_symbol)).setText(assetPositionOtcData.j());
        f6.c.a().l(cVar2.itemView.getContext(), p.k(assetPositionOtcData.i()), (ImageView) e11.b(R$id.chase_coin_symbol_icon), p.m());
        String E = LegalCurrencyConfigUtil.E(assetPositionOtcData.i(), plainString);
        if (TextUtils.isEmpty(E)) {
            E = "--";
        }
        if (assetPositionOtcData.d()) {
            textView.setText(E);
            textView2.setText(p.j(plainString, assetPositionOtcData.i()));
            textView3.setText(LegalCurrencyConfigUtil.E(assetPositionOtcData.i(), assetPositionOtcData.g()));
            textView4.setText(p.j(assetPositionOtcData.g(), assetPositionOtcData.i()));
        } else {
            textView.setText("*****");
            textView2.setText("*****");
            textView3.setText("*****");
            textView4.setText("*****");
        }
        e11.b(R$id.asset_p_contract_trade).setOnClickListener(new j0(motionLayout, i12, assetPositionOtcData2, context));
        e11.b(R$id.asset_p_contract_order).setOnClickListener(new bl.k0(motionLayout, i12, assetPositionOtcData2, context));
        e11.b(R$id.asset_p_contract_details).setOnClickListener(new i0(motionLayout, i12, assetPositionOtcData2, context));
        if (l.f().h(i12, assetPositionOtcData.k())) {
            motionLayout.setProgress(1.0f);
        } else {
            motionLayout.setProgress(0.0f);
        }
        dw.a.a(b11).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe(new l0(motionLayout, i12, assetPositionOtcData2));
    }

    /* renamed from: g */
    public void a(c cVar, int i11, AssetPositionOtcData assetPositionOtcData, ViewGroup viewGroup, List<Object> list) {
        if (list != null && !list.isEmpty()) {
            MotionLayout motionLayout = (MotionLayout) cVar.itemView.findViewById(R$id.position_otc_root);
            if (list.get(0).equals("collapse")) {
                motionLayout.u0();
            } else {
                motionLayout.s0();
            }
        }
    }

    public int getResId() {
        return R$layout.item_asset_position_otc_content;
    }
}
