package com.huobi.finance.viewhandler;

import al.p;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bl.b3;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.SuperMarginDetailInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import java.math.BigDecimal;
import java.util.Locale;
import s9.c;

public class SuperMarginBalanceViewAdapter implements c {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f67624a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f67625b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f67626c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f67627d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f67628e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f67629f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f67630g;

        public a(View view) {
            this.f67624a = view;
            this.f67625b = (TextView) view.findViewById(R$id.tv_title);
            this.f67626c = (TextView) view.findViewById(R$id.tvAvailable);
            this.f67627d = (TextView) view.findViewById(R$id.tvLoan);
            this.f67628e = (TextView) view.findViewById(R$id.tv_frozen);
            this.f67629f = (TextView) view.findViewById(R$id.tv_estimate);
            this.f67630g = (TextView) view.findViewById(R$id.tv_overloss_tag);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(Context context, SuperMarginDetailInfo superMarginDetailInfo, View view) {
        if (!p.d(context)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        AssetModuleConfig.a().M0(context, superMarginDetailInfo);
        AssetModuleConfig.a().n1("223", StringUtils.g(superMarginDetailInfo.getCurrency()));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String c(String str, String str2) {
        return p.j(str, str2);
    }

    public final String d(SuperMarginDetailInfo superMarginDetailInfo) {
        return m.a(superMarginDetailInfo.getEstimateAmount()).setScale(2, 1).toPlainString();
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, SuperMarginDetailInfo superMarginDetailInfo, ViewGroup viewGroup) {
        View view = cVar.itemView;
        Context context = view.getContext();
        a aVar = new a(view);
        aVar.f67625b.setText(superMarginDetailInfo.getDisplayName());
        boolean z11 = false;
        if (p.u()) {
            aVar.f67626c.setText(c(superMarginDetailInfo.getAvaialAble(), superMarginDetailInfo.getCurrency()));
            aVar.f67627d.setText(c(m.a(superMarginDetailInfo.getLoan()).abs().toPlainString(), superMarginDetailInfo.getCurrency()));
            aVar.f67628e.setText(c(superMarginDetailInfo.getOnOrders(), superMarginDetailInfo.getCurrency()));
            aVar.f67629f.setText(context.getString(R$string.balance_margin_item_short_estimate, new Object[]{d(superMarginDetailInfo), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
            TextView textView = aVar.f67630g;
            if (m.a(superMarginDetailInfo.getAvaialAble()).compareTo(BigDecimal.ZERO) < 0) {
                z11 = true;
            }
            ViewUtil.m(textView, z11);
        } else {
            String string = cVar.itemView.getResources().getString(R$string.balance_hide_star);
            aVar.f67626c.setText(string);
            aVar.f67627d.setText(string);
            aVar.f67628e.setText(string);
            aVar.f67629f.setText(string);
            ViewUtil.m(aVar.f67630g, false);
        }
        ImageView c11 = cVar.e().c(R$id.item_margin_balance_symbol_icon);
        TextView e11 = cVar.e().e(R$id.item_balance_currency_name_all);
        CurrencyBean s11 = k.C().s(superMarginDetailInfo.getCurrency());
        if (s11 != null) {
            e11.setText(s11.getFullName());
        } else {
            e11.setText("");
        }
        f6.c.a().l(view.getContext(), p.k(superMarginDetailInfo.getCurrency()), c11, p.m());
        view.setTag(R$id.item_data, superMarginDetailInfo);
        view.setOnClickListener(new b3(context, superMarginDetailInfo));
    }

    public int getResId() {
        return R$layout.item_super_margin_balance_detail;
    }
}
