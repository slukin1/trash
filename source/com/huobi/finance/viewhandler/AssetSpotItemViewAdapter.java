package com.huobi.finance.viewhandler;

import al.k;
import al.p;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bl.n1;
import bl.o1;
import bl.p1;
import bl.q1;
import bl.r1;
import bl.s1;
import bl.t1;
import bl.u1;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDetailInfo;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.functions.Action1;
import s9.c;
import uh.b;

public class AssetSpotItemViewAdapter implements c {

    /* renamed from: c  reason: collision with root package name */
    public static String f67599c;

    /* renamed from: d  reason: collision with root package name */
    public static BalanceDetailInfo f67600d;

    /* renamed from: b  reason: collision with root package name */
    public final bc.a f67601b = AssetModuleConfig.a();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public BalanceDetailInfo f67602a;

        public a(BalanceDetailInfo balanceDetailInfo) {
            this.f67602a = balanceDetailInfo;
        }

        public boolean a(Object obj) {
            return obj instanceof a;
        }

        public BalanceDetailInfo b() {
            return this.f67602a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this)) {
                return false;
            }
            BalanceDetailInfo b11 = b();
            BalanceDetailInfo b12 = aVar.b();
            return b11 != null ? b11.equals(b12) : b12 == null;
        }

        public int hashCode() {
            BalanceDetailInfo b11 = b();
            return 59 + (b11 == null ? 43 : b11.hashCode());
        }

        public String toString() {
            return "AssetSpotItemViewAdapter.SpotItemExpandEvent(data=" + b() + ")";
        }
    }

    public static void j() {
        f67599c = null;
        f67600d = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(View view, Void voidR) {
        t(view);
        BaseModuleConfig.a().w("app_spot_currencyAssets_click", (HashMap) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(View view, r rVar, BalanceDetailInfo balanceDetailInfo, View view2, Void voidR) {
        if (view.getVisibility() == 0) {
            u(rVar, balanceDetailInfo);
            return;
        }
        t(view2);
        BaseModuleConfig.a().w("app_spot_currencyNameLine_click", (HashMap) null);
    }

    public static /* synthetic */ void n(Context context, String str, Void voidR) {
        k.a(context, str);
        gi.a.x(FirebaseAnalytics.Param.PRICE);
    }

    public static /* synthetic */ void o(Context context, String str, Void voidR) {
        k.c(context, str);
        gi.a.x("trade");
    }

    public static /* synthetic */ void p(Context context, String str, Void voidR) {
        k.b(context, str);
        gi.a.x("openOrders");
    }

    public static /* synthetic */ void q(Context context, BalanceDetailInfo balanceDetailInfo, Void voidR) {
        AssetModuleConfig.a().s0(context, balanceDetailInfo);
        gi.a.x("details");
    }

    public static /* synthetic */ void r(BottomLineTextView bottomLineTextView, Context context, Void voidR) {
        b.b(bottomLineTextView, context.getResources().getString(R$string.n_asset_spot_notice), PixelUtils.a(300.0f));
        BaseModuleConfig.a().w("app_spot_spotBalances_explanation_click", (HashMap) null);
    }

    public static /* synthetic */ void s(BottomLineTextView bottomLineTextView, Context context, Void voidR) {
        b.b(bottomLineTextView, context.getResources().getString(R$string.n_asset_debts_notice), PixelUtils.a(300.0f));
        BaseModuleConfig.a().w("app_spot_debts_explanation_click", (HashMap) null);
    }

    public int getResId() {
        return R$layout.item_asset_spot;
    }

    /* renamed from: k */
    public void handleView(v9.c cVar, int i11, BalanceDetailInfo balanceDetailInfo, ViewGroup viewGroup) {
        ImageView imageView;
        int i12;
        int i13;
        TextView textView;
        boolean z11;
        TextView textView2;
        int i14;
        View view = cVar.itemView;
        view.setTag(R$id.item_data, balanceDetailInfo);
        Context context = view.getContext();
        Resources resources = context.getResources();
        r e11 = cVar.e();
        View b11 = e11.b(R$id.fold_layout);
        View b12 = e11.b(R$id.summary_layout);
        View b13 = e11.b(R$id.detail_layout);
        ImageView c11 = e11.c(R$id.iv_icon);
        TextView e12 = e11.e(R$id.tv_currency);
        TextView e13 = e11.e(R$id.tv_debts_tips);
        TextView e14 = e11.e(R$id.tv_currency_full_name);
        TextView textView3 = (TextView) e11.b(R$id.tv_total_asset);
        TextView textView4 = (TextView) e11.b(R$id.tv_total_asset_legal);
        View b14 = e11.b(R$id.iv_arrow);
        View view2 = b11;
        TextView textView5 = (TextView) e11.b(R$id.tv_spot_asset);
        BottomLineTextView bottomLineTextView = (BottomLineTextView) e11.b(R$id.tv_label_spot_asset);
        TextView textView6 = (TextView) e11.b(R$id.tv_spot_asset_legal);
        TextView textView7 = (TextView) e11.b(R$id.tv_ybb_asset);
        View view3 = b12;
        TextView textView8 = (TextView) e11.b(R$id.tv_ybb_asset_legal);
        View view4 = view;
        BottomLineTextView bottomLineTextView2 = (BottomLineTextView) e11.b(R$id.tv_label_debts_asset);
        TextView textView9 = (TextView) e11.b(R$id.tv_debts_asset);
        View view5 = b13;
        TextView textView10 = (TextView) e11.b(R$id.tv_debts_asset_legal);
        Resources resources2 = resources;
        View b15 = e11.b(R$id.asset_p_contract_markets);
        View b16 = e11.b(R$id.asset_p_contract_trade);
        View b17 = e11.b(R$id.asset_p_contract_order);
        View b18 = e11.b(R$id.asset_p_contract_details);
        int status = balanceDetailInfo.getStatus();
        r rVar = e11;
        boolean z12 = (status & 16) != 0;
        boolean z13 = (status & 8) != 0;
        boolean z14 = !z12 && (z13 || ((status & 1) != 0));
        int i15 = R$color.baseColorPrimaryText;
        int color = ContextCompat.getColor(context, i15);
        int i16 = i15;
        int i17 = R$color.baseColorSecondaryText;
        int color2 = ContextCompat.getColor(context, i17);
        int i18 = i17;
        if (z14) {
            i13 = ContextCompat.getColor(context, R$color.baseColorThreeLevelText);
            imageView = c11;
            i12 = i13;
        } else {
            i13 = color;
            imageView = c11;
            i12 = color2;
        }
        e12.setTextColor(i13);
        e14.setTextColor(i12);
        textView3.setTextColor(i13);
        textView4.setTextColor(i12);
        textView5.setTextColor(i13);
        textView6.setTextColor(i12);
        textView7.setTextColor(i13);
        textView8.setTextColor(i12);
        textView9.setTextColor(i13);
        textView10.setTextColor(i12);
        b14.setVisibility(z14 ? 4 : 0);
        String currency = balanceDetailInfo.getCurrency();
        View view6 = b14;
        if (m.d0(m.a(balanceDetailInfo.getAvaialAble()), BigDecimal.ZERO)) {
            e13.setVisibility(0);
        } else {
            e13.setVisibility(8);
        }
        BigDecimal add = m.a(balanceDetailInfo.getAvaialAble()).max(BigDecimal.ZERO).add(m.a(balanceDetailInfo.getOnOrders()).add(m.a(balanceDetailInfo.getLock())));
        BigDecimal min = m.a(balanceDetailInfo.getAvaialAble()).min(BigDecimal.ZERO);
        TextView textView11 = textView7;
        TextView textView12 = textView8;
        TextView textView13 = textView10;
        f6.c.a().l(context, p.k(balanceDetailInfo.getCurrency()), imageView, p.m());
        e12.setText(balanceDetailInfo.getDisplayName());
        e14.setText(d7.k.C().B(balanceDetailInfo.getCurrency()));
        String j11 = p.j((balanceDetailInfo.getYbbAsset() != null ? add.add(m.a(balanceDetailInfo.getYbbAsset().getDigitalAssetTotalAmount())) : add).toPlainString(), currency);
        textView3.setText(j11);
        String y11 = LegalCurrencyConfigUtil.y();
        Locale locale = Locale.US;
        textView4.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.E(currency, j11), y11.toUpperCase(locale)}));
        if (z14) {
            if (z13) {
                i14 = R$string.balance_detail_status_blacklist;
            } else {
                i14 = R$string.balance_detail_status_close;
            }
            textView4.setText(i14);
        }
        String j12 = p.j(add.toPlainString(), currency);
        textView5.setText(j12);
        textView6.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.E(currency, j12), LegalCurrencyConfigUtil.y().toUpperCase(locale)}));
        String j13 = p.j(min.toPlainString(), currency);
        textView9.setText(j13);
        textView13.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.E(currency, j13), LegalCurrencyConfigUtil.y().toUpperCase(locale)}));
        if (balanceDetailInfo.getYbbAsset() != null) {
            textView2 = textView12;
            ViewUtil.m(textView2, true);
            textView = textView11;
            textView.setTextColor(resources2.getColor(i16));
            String j14 = p.j(balanceDetailInfo.getYbbAsset().getDigitalAssetTotalAmount(), currency);
            textView.setText(j14);
            z11 = false;
            textView2.setText(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.E(currency, j14), LegalCurrencyConfigUtil.y().toUpperCase(locale)}));
        } else {
            Resources resources3 = resources2;
            textView2 = textView12;
            textView = textView11;
            z11 = false;
            ViewUtil.m(textView2, false);
            textView.setTextColor(resources3.getColor(R$color.baseColorThreeLevelText));
            textView.setText(resources3.getString(R$string.n_asset_currency_invalid));
        }
        Observable<Void> a11 = dw.a.a(view5);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        View view7 = view4;
        a11.throttleFirst(500, timeUnit).subscribe(new t1(this, view7));
        u1 u1Var = r1;
        Observable<Void> throttleFirst = dw.a.a(view3).throttleFirst(500, timeUnit);
        TextView textView14 = textView;
        boolean z15 = z11;
        String str = currency;
        TextView textView15 = textView2;
        u1 u1Var2 = new u1(this, view6, rVar, balanceDetailInfo, view7);
        throttleFirst.subscribe((Action1<? super Void>) u1Var2);
        dw.a.a(b15).throttleFirst(500, timeUnit).subscribe(new o1(context, str));
        dw.a.a(b16).throttleFirst(500, timeUnit).subscribe(new q1(context, str));
        dw.a.a(b17).throttleFirst(500, timeUnit).subscribe(new p1(context, str));
        dw.a.a(b18).throttleFirst(500, timeUnit).subscribe(new n1(context, balanceDetailInfo));
        BottomLineTextView bottomLineTextView3 = bottomLineTextView;
        bottomLineTextView3.setTextColor(i18);
        dw.a.a(bottomLineTextView3).throttleFirst(300, timeUnit).subscribe(new r1(bottomLineTextView3, context));
        dw.a.a(bottomLineTextView2).throttleFirst(300, timeUnit).subscribe(new s1(bottomLineTextView2, context));
        String str2 = f67599c;
        if (str2 == null || !str2.equals(balanceDetailInfo.getCurrency()) || view6.getVisibility() != 0) {
            view2.setVisibility(8);
            view6.setRotation(0.0f);
        } else {
            view2.setVisibility(0);
            view6.setRotation(180.0f);
        }
        if (!p.u()) {
            String string = cVar.itemView.getResources().getString(R$string.balance_hide_star);
            textView3.setText(string);
            textView4.setText(string);
            textView5.setText(string);
            textView6.setText(string);
            textView14.setText(string);
            textView15.setText(string);
        }
    }

    public final void t(View view) {
        if (p.d(view.getContext())) {
            this.f67601b.s0(view.getContext(), (BalanceDetailInfo) view.getTag(R$id.item_data));
        }
    }

    public final void u(r rVar, BalanceDetailInfo balanceDetailInfo) {
        View b11 = rVar.b(R$id.fold_layout);
        View b12 = rVar.b(R$id.iv_arrow);
        HashMap hashMap = new HashMap();
        if (b11.getVisibility() == 0) {
            j();
            b11.setVisibility(8);
            b12.setRotation(0.0f);
            hashMap.put("app_spot_currencyNameLine_click_state", "fold");
        } else {
            b11.setVisibility(0);
            b12.setRotation(180.0f);
            f67599c = balanceDetailInfo.getCurrency();
            EventBus.d().k(new a(f67600d));
            f67600d = balanceDetailInfo;
            hashMap.put("app_spot_currencyNameLine_click_state", "unfold");
        }
        BaseModuleConfig.a().w("app_spot_currencyNameLine_click", hashMap);
    }
}
