package com.huobi.finance.viewhandler;

import al.p;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bl.k2;
import bl.l2;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.hbg.core.bean.MiningItem;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import i6.r;
import s9.c;
import vk.n;

public class FixedMiningViewHandler implements c {
    public static /* synthetic */ String e(String str) {
        return str;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(MiningItem miningItem, View view) {
        AssetModuleConfig.a().W(view.getContext(), miningItem.getOrderId());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, n nVar, ViewGroup viewGroup) {
        v9.c cVar2 = cVar;
        MiningItem c11 = nVar.c();
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.tv_currency_title);
        TextView textView2 = (TextView) e11.b(R$id.tv_limit_time_tag);
        TextView textView3 = (TextView) e11.b(R$id.tv_ratio_increase_tag);
        TextView textView4 = (TextView) e11.b(R$id.tv_mining_amount);
        TextView textView5 = (TextView) e11.b(R$id.tv_duration);
        TextView textView6 = (TextView) e11.b(R$id.tv_estimated_profit);
        TextView textView7 = (TextView) e11.b(R$id.tv_apy);
        ImageView c12 = e11.c(R$id.item_margin_balance_symbol_icon);
        TextView e12 = e11.e(R$id.item_balance_currency_name_all);
        CurrencyBean s11 = k.C().s(c11.getCurrency());
        if (s11 != null) {
            e12.setText(s11.getFullName());
        } else {
            e12.setText("");
        }
        f6.c.a().l(cVar2.itemView.getContext(), p.k(c11.getCurrency()), c12, p.m());
        textView.setText(StringUtils.i(c11.getCurrency()));
        String fixedTag = c11.getFixedTag(textView2.getContext());
        ViewUtil.m(textView2, !TextUtils.isEmpty(fixedTag));
        textView2.setText(fixedTag);
        boolean z11 = c11.getCouponStatus() == 1;
        ViewUtil.m(textView3, z11);
        if (z11) {
            textView3.setText(String.format(textView3.getResources().getString(R$string.n_balance_earn_extra_interest), new Object[]{m.Q(c11.getCouponRate(), 2, 1)}));
        }
        textView7.setText(p.o(cVar2.itemView.getContext(), m.Q(c11.getMiningYearRate(), 2, 1), p.u(), k2.f12647a));
        String currency = nVar.c().getCurrency();
        p.f(textView4, c11.getMiningAmount(), currency);
        if (c11.getTerm() == 0) {
            textView5.setText("--");
        } else {
            String string = textView5.getResources().getString(R$string.n_c2c_lend_days);
            textView5.setText(String.format(string, new Object[]{c11.getTerm() + ""}));
        }
        p.f(textView6, c11.getProIncomeAmount(), currency);
        cVar2.itemView.setOnClickListener(new l2(c11));
    }

    public int getResId() {
        return R$layout.item_fixed_mining_balance_detail;
    }
}
