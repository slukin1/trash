package com.huobi.finance.viewhandler;

import al.l;
import al.p;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import bl.t0;
import bl.u0;
import bl.v0;
import bl.w0;
import bl.x0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.hbg.core.bean.AssetOptionsInfo;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.AssetPositionWarrantData;
import com.huobi.finance.bean.OtcOptionsDetailInfo;
import com.huobi.share.AssetShareHelper;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import i6.r;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import s9.d;
import v9.c;

public class AssetPositionWarrantItemViewHandler implements d<AssetPositionWarrantData> {

    public class a implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ double f67595a;

        public a(double d11) {
            this.f67595a = d11;
        }

        public int a() {
            return 0;
        }

        public int b() {
            double d11 = this.f67595a;
            if (d11 > 0.0d) {
                return R$drawable.share_asset_position_cow_1;
            }
            if (d11 < 0.0d) {
                return R$drawable.share_asset_position_cow_3;
            }
            return R$drawable.share_asset_position_cow_2;
        }

        public int c() {
            double d11 = this.f67595a;
            if (d11 > 0.0d) {
                return R$string.n_asset_share_total_great;
            }
            if (d11 < 0.0d) {
                return R$string.n_asset_share_total_less;
            }
            return R$string.n_asset_share_total_same;
        }
    }

    public static /* synthetic */ void j(int i11, AssetPositionWarrantData assetPositionWarrantData, MotionLayout motionLayout, Context context, Void voidR) {
        l.f().c(i11, assetPositionWarrantData.h());
        motionLayout.u0();
        AssetModuleConfig.a().R0(context, assetPositionWarrantData.i());
        gi.a.q(assetPositionWarrantData.h(), FirebaseAnalytics.Param.PRICE, assetPositionWarrantData.i());
    }

    public static /* synthetic */ void k(int i11, AssetPositionWarrantData assetPositionWarrantData, MotionLayout motionLayout, Context context, Void voidR) {
        l.f().c(i11, assetPositionWarrantData.h());
        motionLayout.u0();
        if (context instanceof Activity) {
            AssetModuleConfig.a().y0((Activity) context, assetPositionWarrantData.i());
            gi.a.q(assetPositionWarrantData.h(), "transfer", assetPositionWarrantData.i());
        }
    }

    public static /* synthetic */ void l(int i11, AssetPositionWarrantData assetPositionWarrantData, MotionLayout motionLayout, OtcOptionsDetailInfo otcOptionsDetailInfo, Context context, Void voidR) {
        l.f().c(i11, assetPositionWarrantData.h());
        motionLayout.u0();
        if (otcOptionsDetailInfo != null) {
            AssetModuleConfig.a().x(context, otcOptionsDetailInfo);
            gi.a.q(assetPositionWarrantData.h(), "details", assetPositionWarrantData.i());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(int i11, AssetPositionWarrantData assetPositionWarrantData, MotionLayout motionLayout, Context context, Void voidR) {
        l.f().c(i11, assetPositionWarrantData.h());
        motionLayout.u0();
        o(context, assetPositionWarrantData);
    }

    public static /* synthetic */ void n(MotionLayout motionLayout, int i11, AssetPositionWarrantData assetPositionWarrantData, Void voidR) {
        if (motionLayout.getProgress() == 1.0f) {
            motionLayout.u0();
            l.f().c(i11, assetPositionWarrantData.h());
        } else if (motionLayout.getProgress() == 0.0f) {
            motionLayout.s0();
            l.f().k(i11, assetPositionWarrantData.h());
        }
        gi.a.q(assetPositionWarrantData.h(), FirebaseAnalytics.Param.CURRENCY, assetPositionWarrantData.i());
    }

    public final String g(String str, String str2) {
        return p.j(str, str2);
    }

    public int getResId() {
        return R$layout.item_asset_position_warrant_content;
    }

    /* renamed from: h */
    public void handleView(c cVar, int i11, AssetPositionWarrantData assetPositionWarrantData, ViewGroup viewGroup) {
        c cVar2 = cVar;
        int i12 = i11;
        AssetPositionWarrantData assetPositionWarrantData2 = assetPositionWarrantData;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        MotionLayout motionLayout = (MotionLayout) cVar2.itemView.findViewById(R$id.position_warrant_root);
        View b11 = e11.b(R$id.constraintLayout);
        TextView textView = (TextView) e11.b(R$id.chase_coin_symbol);
        TextView textView2 = (TextView) e11.b(R$id.chase_contract_position);
        TextView textView3 = (TextView) e11.b(R$id.chase_average_price);
        TextView textView4 = (TextView) e11.b(R$id.chase_contract_profit);
        TextView textView5 = (TextView) e11.b(R$id.chase_contract_profit_number);
        View b12 = e11.b(R$id.asset_p_contract_trade);
        View b13 = e11.b(R$id.asset_p_contract_order);
        View b14 = e11.b(R$id.asset_p_contract_details);
        View b15 = e11.b(R$id.asset_p_contract_share);
        View view = b11;
        b15.setVisibility(0);
        View view2 = b15;
        e11.b(R$id.separator_line_view_3).setVisibility(0);
        AssetOptionsInfo g11 = assetPositionWarrantData.g();
        OtcOptionsDetailInfo f11 = assetPositionWarrantData.f();
        if (g11 != null) {
            textView.setText(g11.getCurrency().toUpperCase());
            w.n(textView4, g11.getProfitLoss());
            w.n(textView5, g11.getProfitRate());
            if (assetPositionWarrantData.d()) {
                textView2.setText(g(g11.getPosition(), g11.getCurrency()));
                textView3.setText(g(g11.getAvailable(), g11.getCurrency()));
                p.f(textView4, g11.getProfitLoss(), g11.getCurrency());
                String charSequence = textView4.getText().toString();
                String str = charSequence.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? "" : "+";
                String Q = m.Q(g11.getProfitRate(), 2, 1);
                textView4.setText(str + charSequence);
                textView5.setText(str + Q);
            } else {
                textView2.setText("*****");
                textView3.setText("*****");
                textView4.setText("*****");
                textView5.setText("*****");
            }
        }
        Observable<Void> a11 = dw.a.a(b12);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(1000, timeUnit).subscribe(new t0(i12, assetPositionWarrantData2, motionLayout, context));
        dw.a.a(b13).throttleFirst(1000, timeUnit).subscribe(new u0(i12, assetPositionWarrantData2, motionLayout, context));
        Context context2 = context;
        dw.a.a(b14).throttleFirst(1000, timeUnit).subscribe(new v0(i11, assetPositionWarrantData, motionLayout, f11, context2));
        int i13 = i11;
        dw.a.a(view2).throttleFirst(1000, timeUnit).subscribe(new x0(this, i13, assetPositionWarrantData, motionLayout, context2));
        if (l.f().h(i13, assetPositionWarrantData.h())) {
            motionLayout.setProgress(1.0f);
        } else {
            motionLayout.setProgress(0.0f);
        }
        dw.a.a(view).throttleFirst(1000, timeUnit).subscribe(new w0(motionLayout, i13, assetPositionWarrantData2));
    }

    /* renamed from: i */
    public void a(c cVar, int i11, AssetPositionWarrantData assetPositionWarrantData, ViewGroup viewGroup, List<Object> list) {
        if (list != null && !list.isEmpty()) {
            MotionLayout motionLayout = (MotionLayout) cVar.itemView.findViewById(R$id.position_warrant_root);
            if (list.get(0).equals("collapse")) {
                motionLayout.u0();
            } else {
                motionLayout.s0();
            }
        }
    }

    public final void o(Context context, AssetPositionWarrantData assetPositionWarrantData) {
        double doubleValue = Double.valueOf((assetPositionWarrantData.g() == null || TextUtils.isEmpty(assetPositionWarrantData.g().getProfitRate())) ? "0" : assetPositionWarrantData.g().getProfitRate()).doubleValue();
        View loadView = AssetShareHelper.loadView(context, String.valueOf(doubleValue), new a(doubleValue));
        loadView.findViewById(R$id.layout_title).setVisibility(0);
        ((TextView) loadView.findViewById(R$id.tv_title)).setTextColor(context.getResources().getColor(R$color.white));
        ((TextView) loadView.findViewById(R$id.tv_hield_currency)).setText(context.getString(R$string.n_asset_cumulative_yield));
        ViewGroup viewGroup = (ViewGroup) loadView.findViewById(R$id.layout_position);
        viewGroup.setVisibility(0);
        LayoutInflater.from(context).inflate(R$layout.layout_asset_position_contract, viewGroup, true);
        ((TextView) viewGroup.findViewById(R$id.tv_symbol)).setText(assetPositionWarrantData.i().toUpperCase());
        ImageView imageView = (ImageView) viewGroup.findViewById(R$id.iv_icon);
        imageView.setVisibility(0);
        f6.c.a().l(context, p.k(assetPositionWarrantData.i()), imageView, p.m());
        String upperCase = BaseModuleConfig.a().M().toUpperCase();
        ((TextView) viewGroup.findViewById(R$id.tv_price_title)).setText(context.getString(R$string.contarct_share_position_cur_price) + "(" + upperCase.toUpperCase() + ")");
        new DecimalFormat("0.00").setRoundingMode(RoundingMode.FLOOR);
        ((TextView) viewGroup.findViewById(R$id.tv_price)).setText(LegalCurrencyConfigUtil.F(assetPositionWarrantData.g().getCurrency(), upperCase, "1"));
        AssetShareHelper.share(context, loadView);
    }
}
